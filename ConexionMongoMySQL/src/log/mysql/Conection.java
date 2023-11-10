package log.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Client;
import dto.Order;
import dto.Product;


public class Conection {
	
	private Connection conexion;
	private String erros="";
	
	public void openConection(String url) throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Crea unha conexion a base de datos
		    conexion = DriverManager.getConnection(url,"manager","abc123.");
		    
		} catch (ClassNotFoundException e) {
			erros+="Class not found "+e.getMessage();
			throw(e);
		} catch (SQLException e) {
			erros+="SQL open operation :"+e.getMessage();
			throw(e);
		}
      
	}
	public void closeConection()throws Exception {
	
	      try {
			conexion.close();
		} catch (SQLException e) {
			erros+="SQL close operation :"+e.getMessage();
			throw(e);
		}
	}
	
	
	public int addOrder(int idPedido,int idProducto,int idClient,int amount) throws Exception{
		
		int datos=0;
		String linea="insert into orderr (idPedido, idProduct, idClient, amount) values ('"+idPedido+
									"','"+idProducto+"','"+idClient+"',"+amount+");";
	      try {
		      Statement consult=conexion.createStatement();
		      datos=consult.executeUpdate(linea);

		      consult.close();
		} catch (SQLException e) {
			erros+="SQL addStudent :"+e.getMessage();
			throw(e);
		}
	      
		return datos;
	}
	public int deleteOrder(int idPedido) throws Exception{
		int datos=0;
		
	      try {
	    	  String parametros="delete from orderr WHERE  idPedido=?;";
		      PreparedStatement consultParams=conexion.prepareStatement(parametros);
		      
		      consultParams.setInt(1,idPedido);

    		  datos=consultParams.executeUpdate();
    		  consultParams.close();
		} catch (SQLException e) {
			erros+="SQL deleteStudent :"+e.getMessage();
			throw(e);
		}
	      
		return datos;
	}
	public int modifyOrder(int idPedido,int idProducto,int idClient,int amount) throws Exception{


		int datos=0;
		try {


		      PreparedStatement updateSales = conexion.prepareStatement(
		    		  "UPDATE orderr SET idProduct=?,idClient=?,amount=? WHERE idPedido=?");
    		  updateSales.setInt(1, idProducto);
    		  updateSales.setInt(2, idClient);
    		  updateSales.setInt(3, amount);
    		  updateSales.setInt(4, idPedido);
    		  
    		  
    		  datos=updateSales.executeUpdate();
    		  updateSales.close();
		      
		} catch (SQLException e) {
			erros+="SQL addStudent :"+e.getMessage();
			throw(e);
		}
	      
		return datos;
		
	}

	
	public Client getClient(int id) throws Exception{
		Client st=null;
		 try {
			 //Consulta con parametros
		      String parametros="select * from client where idClient=?";
		      PreparedStatement consultParams=conexion.prepareStatement(parametros);
		      
		      consultParams.setInt(1,id);
		      
		      ResultSet datos=consultParams.executeQuery();
		      String dni,name;
		      int idClient;
		      if(datos.next()) {  
		    	  idClient=datos.getInt("idClient");
		    	  dni=datos.getString("dni");
		    	  name=datos.getString("name");
		    	  st=new Client(idClient,dni, name);
		      }
		      
		      consultParams.close();
		      datos.close();
		      
		      
		} catch (SQLException e) {
			erros+="SQL getClient :"+e.getMessage();
			throw(e);
		}
		return st;
	    
	}
	public Product getProduct(int id) throws Exception{
		Product st=null;
		 try {
			 //Consulta con parametros
		      String parametros="select * from product where idProduct=?";
		      PreparedStatement consultParams=conexion.prepareStatement(parametros);
		      
		      consultParams.setInt(1,id);
		      
		      ResultSet datos=consultParams.executeQuery();

		      String name,description,picture;
		      int idProduct,price;
		      if(datos.next()) {  
		    	  idProduct=datos.getInt("idProduct");
		    	  name=datos.getString("name");
		    	  description=datos.getString("description");
		    	  price=datos.getInt("price");
		    	  picture=datos.getString("picture");
		    	  
		    	  st=new Product(idProduct, name, description, price, picture);
		      }
		      
		      consultParams.close();
		      datos.close();
		      
		      
		} catch (SQLException e) {
			erros+="SQL getProdcut :"+e.getMessage();
			throw(e);
		}
		return st;
	    
	}
	public Order getOrder(int id) throws Exception{
		Order st=null;
		 try {
			 //Consulta con parametros
		      String parametros="select * from orderr where idPedido=?";
		      PreparedStatement consultParams=conexion.prepareStatement(parametros);
		      
		      consultParams.setInt(1,id);
		      
		      ResultSet datos=consultParams.executeQuery();


		      
		      int idPedido,idProduct,idClient,amount;
		      if(datos.next()) {  
		    	  idPedido=datos.getInt("idPedido");
		    	  idProduct=datos.getInt("idProduct");
		    	  idClient=datos.getInt("idClient");
		    	  amount=datos.getInt("amount");
		    	  
		    	  st=new Order(idPedido, getProduct(idProduct),getClient(idClient), amount);
		      }
		      
		      consultParams.close();
		      datos.close();
		      
		      
		} catch (SQLException e) {
			erros+="SQL getOrder :"+e.getMessage();
			throw(e);
		}
		return st;
	    
	}

	
	public ArrayList<Order> getOrdersList()throws Exception{
		
		ArrayList<Order> ordersList=new ArrayList<Order>();
		try { 
			
			Statement consult=conexion.createStatement();
		    ResultSet datos;
		
		    datos = consult.executeQuery("select * from orderr");
		    int idOrder;
		    while(datos.next()) {
		    	idOrder=datos.getInt("idPedido");
		    	ordersList.add(getOrder(idOrder));
		    }
		    consult.close();
		    datos.close();
		} catch (SQLException e) {
			erros+="SQL getOrdersList() :"+e.getMessage();
			throw(e);
		}
		
	    return ordersList; 
}
	public ArrayList<Client> getClientList()throws Exception{
		
		ArrayList<Client> clientList=new ArrayList<Client>();
		try { 
			
			Statement consult=conexion.createStatement();
		    ResultSet datos;
		
		    datos = consult.executeQuery("select * from client");
		    int idClient;
		    while(datos.next()) {
		    	idClient=datos.getInt("idClient");
		    	clientList.add(getClient(idClient));
		    }
		    consult.close();
		    datos.close();
		} catch (SQLException e) {
			erros+="SQL getClientsList() :"+e.getMessage();
			throw(e);
		}
		
	    return clientList; 
}
	public ArrayList<Product> getProductList()throws Exception{
		
		ArrayList<Product> productList=new ArrayList<Product>();
		try { 
			
			Statement consult=conexion.createStatement();
		    ResultSet datos;
		
		    datos = consult.executeQuery("select * from product");
		    int idProduct;
		    while(datos.next()) {
		    	idProduct=datos.getInt("idProduct");
		    	productList.add(getProduct(idProduct));
		    }
		    consult.close();
		    datos.close();
		} catch (SQLException e) {
			erros+="SQL getProductList() :"+e.getMessage();
			throw(e);
		}
		
	    return productList; 
}
	
	public Connection getConection() {
		return this.conexion;
	}
	public String getErros() {return this.erros;}
	
}