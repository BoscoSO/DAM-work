package gui;

import org.bson.Document;

import log.json.OperationsJson;
import log.mongo.OperationsMongo;

public class Ejercicio2 {

	public static void main(String[] args) {
		OperationsJson jsonLog = new OperationsJson();
		jsonLog.generarJSONOrders();
		Document doc =jsonLog.readJsonOrders();

		String urlMongo="192.168.56.102";						//URL PARA Mongo
		OperationsMongo mongoLog=new OperationsMongo(urlMongo) ;
		
		
		try {
			mongoLog.abrirConexion("conmsql");
			mongoLog.createCollection("jsonOrders");
			mongoLog.addDoc(doc);
			mongoLog.list().forEach(System.out::println);
			mongoLog.cerrarConexion();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
