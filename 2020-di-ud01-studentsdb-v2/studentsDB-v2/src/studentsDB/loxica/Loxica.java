package studentsDB.loxica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import studentsDB.dto.Student;


public class Loxica {
    Connection conexion;
    String erros;
    private List<Student> alumnos=new ArrayList<Student>(); 
       
    public Loxica(){
        erros="";
        abrirConexion();
    }

    private void abrirConexion() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String url = "jdbc:derby:basedatos;create=true";
            conexion = DriverManager.getConnection(url, "usuario", "abc123.");
        } catch (Exception erro) {
            System.out.println("Erro Abrir conexión: " + erro.getMessage());
            erro.printStackTrace();
        }
    }
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public int addStudent(Student student) throws Exception {
        int datos=0;
        String linea="insert into student (dni, name, surname, age) values ('"+student.getDni()+
                                                                    "','"+student.getNome()+"','"+student.getApelidos()+"',"+student.getIdade()+")";
            try {
                Statement consult=conexion.createStatement();
                datos=consult.executeUpdate(linea);

                consult.close();System.out.println("entro");
            } catch (Exception e) {
                erros+="SQL addStudent :"+e.getMessage();
                throw(e);
            }

            return datos;
    } 
    public int deleteStudent(String dni)throws Exception {
            int datos=0;

          try {
              String parametros="delete from student WHERE  DNI=?";
                  PreparedStatement consultParams=conexion.prepareStatement(parametros);

                  consultParams.setString(1,dni);

              datos=consultParams.executeUpdate();
              consultParams.close();
            } catch (SQLException e) {
                    erros+="SQL deleteStudent :"+e.getMessage();
                    throw(e);
            }

            return datos;
    }
    public Student getStudent(String id) throws Exception{
            Student st=null;
             try {
                     //Consulta con parametros
                  String parametros="select * from student where dni=?";
                  PreparedStatement consultParams=conexion.prepareStatement(parametros);

                  consultParams.setString(1,id);

                  ResultSet datos=consultParams.executeQuery();


                    
                  String dni,name,surname;
                  int age;
                  if(datos.next()) {  
                      dni=datos.getString("dni");
                      name=datos.getString("name");
                      surname=datos.getString("surname");
                      age=datos.getInt("age");

                      st=new Student(dni, name,surname,age);
                  }

                  consultParams.close();
                  datos.close();


            } catch (SQLException e) {
                    erros+="SQL getStudent :"+e.getMessage();
                    throw(e);
            }
            return st;

    }
    public void updateListAlumnado() throws Exception{ // sellect * y news students
        ArrayList<Student> alumnado=new ArrayList<Student>();
		try { 
			
			Statement consult=conexion.createStatement();
		    ResultSet datos;
		
		    datos = consult.executeQuery("select * from student");
		    String dni;
		    while(datos.next()) {
		    	dni=datos.getString("dni");
		    	alumnado.add(getStudent(dni));
		    }
		    consult.close();
		    datos.close();
		} catch (SQLException e) {
			erros+="SQL getListAlumnado() :"+e.getMessage();
			                 
                        throw(e);
		}
		
	    //return ordersList; 
            alumnos=alumnado;
    }
    public List<Student> getListAlumnado(){
        return this.alumnos;
    }
    
    public int modAlumno(String dni,String name,String surname,int age,int index) throws Exception { // updates varios
        String buscado=alumnos.get(index).getDni();
        String sent="UPDATE student SET ";
        
        boolean masdeuno=false;    
        boolean[] aMod=new boolean[] {false,false,false,false};
        if(!dni.isEmpty()){aMod[0]=true;
            masdeuno=true;
            sent+="dni=?";
        }
        if(!name.isEmpty()){aMod[1]=true;
            if(masdeuno)sent+=",";
            masdeuno=true;
            sent+="name=?";
        }
        if(!surname.isEmpty()){aMod[2]=true;
            if(masdeuno)sent+=",";
            masdeuno=true;
            sent+="surname=?";
        }
        if(age!=0){aMod[3]=true;
            if(masdeuno)sent+=",";
            masdeuno=true;
            sent+="age=?";
        }

            sent+="WHERE dni=?";
            int datos=0;
            try {


                PreparedStatement updateSales = conexion.prepareStatement(sent);
                int i=1;
                for(int y=0;y<4;y++){
                    switch(y){
                        case 0: if(aMod[y]){
                            updateSales.setString(i++, dni);System.out.println("dni  "+dni);
                        }break;
                        case 1: if(aMod[y]){
                            updateSales.setString(i++, name);System.out.println("name  "+name);
                        }break;
                        case 2: if(aMod[y]){
                            updateSales.setString(i++, surname);System.out.println("surname  "+surname);
                        }break;
                        case 3: if(aMod[y]){
                            updateSales.setInt(i++, age);System.out.println("age  "+age);
                        }break;
                    }
                }

                 updateSales.setString(i,buscado);
            
            
              datos=updateSales.executeUpdate();
              updateSales.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                    erros+="SQL modStudent :"+e.getMessage();
                    throw(e);
            }

            return datos;
		
	
    }
    
     public String getErro(){
            return this.erros;
     }
}
