package gui;


import java.util.ArrayList;

import dto.Client;
import dto.Order;
import dto.Product;
import log.mongo.OperationsMongo;
import log.mysql.OperationsMySQL;

public class Ejercicio1 {

	public static void main(String[] args) {
		String urlMysql="jdbc:mysql://192.168.56.102/orders";	//URL PARA UBUNTUWEB
		String urlMongo="192.168.56.101";						//URL PARA Mongo
		
		OperationsMySQL mysqlLog=new OperationsMySQL(urlMysql);
		OperationsMongo mongoLog=new OperationsMongo(urlMongo) ;
		try {
			//MySQL 
			mysqlLog.openCon();
			System.out.println("*************************************************************");
			ArrayList<Order> orderlist=mysqlLog.ordersList();
			ArrayList<Client> clientlist=mysqlLog.clientList();
			ArrayList<Product> productlist=mysqlLog.productList();
			
			System.out.println("Contenido inicial en la base de datos MySQL orders:");
			System.out.println("\nContenido de clientes:\n");
			clientlist.forEach(System.out::println);
			System.out.println("\nContenido de productos:\n");
			productlist.forEach(System.out::println);
			
			System.out.println("\nContenido de orders:\n\n  idPedido  |  idProduct  |  idClient  |  amount");
			orderlist.forEach(System.out::println);
			
			mysqlLog.quit();

			System.out.println("\n*************************************************************\n");
			//Mongo 
			mongoLog.abrirConexion("conmsql");
			
			mongoLog.createCollection("product");
			for(Product p: productlist) {
				mongoLog.addDoc(p.toDocument());
			}
			mongoLog.createCollection("client");
			for(Client c: clientlist) {
				mongoLog.addDoc(c.toDocument());
			}
			mongoLog.createCollection("mysqlOrders");
			for(Order o: orderlist) {
				mongoLog.addDoc(o.toDocument());
			}
			
			mongoLog.list().forEach(System.out::println);
			
			System.out.println("*************************************************************");
			mongoLog.cerrarConexion();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
