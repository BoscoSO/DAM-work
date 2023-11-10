package bdCuentas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class PreBaseDatos {


	BaseDatos bd=new BaseDatos();
	
	 public PreBaseDatos(){
	    	File fichero=new File("BD.dat");
	    	if(fichero.exists())
	    		cargarDatos(fichero);
	    
	 }
	 
	 public void cerrarBaseDatos() {
	    	guardarDatos();
	 }
	public BaseDatos getBaseDatos() {
		return bd;
	}
	
	private void guardarDatos() {
    	FileOutputStream datos = null;
      	

    
    	try{   		
    		datos=new FileOutputStream("BD.dat");
    		ObjectOutputStream tuberiaDatos = new ObjectOutputStream(datos);

		
    		tuberiaDatos.writeObject(bd);
             
    	
    		
    		tuberiaDatos.close();
    		datos.close();
    		
    	
    	}catch(FileNotFoundException e) {
    		System.out.println("Fichero no encontrado /"+e.getMessage());
    	}catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("guardarDatos :"+e.getMessage());
    	}
    			
    	
               
    }
    private void cargarDatos(File fichDatos){
    	FileInputStream datos = null;
    	ObjectInputStream tuberiaDatos= null;
        try{
        	datos=new FileInputStream(fichDatos);
        	tuberiaDatos= new ObjectInputStream(datos);
        	
        	int bytes=tuberiaDatos.available();
        	if(bytes>=0) {
        		bd=(BaseDatos)tuberiaDatos.readObject();
        	}
     
        }catch(FileNotFoundException e){
            System.out.println("FIN DE FICHERO1");
        }catch(ClassNotFoundException e){
            System.out.println("FIN DE FICHERO2");
        } catch (IOException e) {
		}finally { 
            try {
				datos.close();
				tuberiaDatos.close();
			} catch (IOException e) {
	            System.out.println("problema al cerrar Stream"); 
			}
        			
    	}
    }
}
