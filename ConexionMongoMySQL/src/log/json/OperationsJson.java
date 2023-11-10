package log.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OperationsJson {
    ///////////Funciones cogidas del ejercicio de la unidad 1
	private JSONArray getArrayOrderRows() {
		JSONObject value= new JSONObject();
		
		
		JSONObject product1= new JSONObject();
			
			value.put("id", "2");
			value.put("productName", "Silla");
			value.put("description", "es una silla");
			value.put("picture", "/silla.png");
			value.put("price", "60");
			
		product1.put("product", value);
		product1.put("amount", 2);
		product1.put("price", 2*60);
		
		JSONObject orderRow1= new JSONObject();
		orderRow1.put("OrderRow", product1);
		
		/**************************/
		JSONObject product2= new JSONObject();
		value= new JSONObject();
			value.put("id", "2");
			value.put("productName", "Cama");
			value.put("description", "es una cama");
			value.put("picture", "/cama.png");
			value.put("price", "120");


		product2.put("product", value);
		product2.put("amount", 1);
		product2.put("price", 1*120);
		
		JSONObject orderRow2= new JSONObject();
		orderRow2.put("OrderRow", product2);
		/**************************/
		JSONObject product3= new JSONObject();
		value= new JSONObject();
			value.put("id", "2");
			value.put("productName", "Mesa");
			value.put("description", "es una mesa");
			value.put("picture", "/mesa.png");
			value.put("price", "40");
			
		product3.put("product", value);
		product3.put("amount", 3);
		product3.put("price", 3*40);
		
		JSONObject orderRow3= new JSONObject();
		orderRow3.put("OrderRow", product3);
		
		
		
		JSONArray arrai=new JSONArray();
		arrai.add(orderRow1);
		arrai.add(orderRow2);
		arrai.add(orderRow3);
		return arrai;
		
	}
	public void generarJSONOrders() {
		
		try {
			JSONObject cliente= new JSONObject();
			cliente.put("DNI", "4123456E");
			cliente.put("name", "PACO");
			cliente.put("surname", "Fernandez");
			
			
			JSONArray array=getArrayOrderRows();
			
			JSONObject padre= new JSONObject();
			JSONObject value= new JSONObject();
			
		
			value.put("id", 1);
			value.put("Client", cliente);
			value.put("orderRows", array);
			value.put("price", 360);
			value.put("delivered", false);
			
			padre.put("order",value);
			
			FileWriter fw=new FileWriter("orders.json");
			fw.write(padre.toJSONString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    //Funcion añadida
	public Document readJsonOrders(){
		Document order=new Document();
		Document cliente=new Document();

		try (FileReader fr = new FileReader("orders.json")){

			JSONParser parser = new JSONParser();

	        JSONObject orders =  (JSONObject) parser.parse(fr);
	        
	        JSONObject ord =  (JSONObject) orders.get("order");
	        
	        
	        //////////////////////////////////////////////////////////////////////////////////////CLIENT
	        JSONObject client=(JSONObject) ord.get("Client");
			cliente.append("surname", (String)client.get("surname"));
			cliente.append("name", (String)client.get("name"));
			cliente.append("DNI", (String)client.get("DNI"));
	        //////////////////////////////////////////////////////////////////////////////////////ORDER ROWS			
	        ArrayList<Document> lineasPedido = new ArrayList<Document>();
	        Document linea=new Document();
	        Document producto=new Document();
	        
		    JSONArray arr=(JSONArray) ord.get("orderRows");
		    JSONObject orderRow;
		    for(int i=0;i<arr.size();i++) {
		    	orderRow=(JSONObject) arr.get(i);
		    	JSONObject aux=(JSONObject)orderRow.get("OrderRow"); 
		    	JSONObject product=(JSONObject)aux.get("product"); 
		    	producto.append("id", (String)product.get("id"));
		    	producto.append("productName", (String)product.get("productName"));
		    	producto.append("description", (String)product.get("description"));
		    	producto.append("picture", (String)product.get("picture"));
		    	producto.append("price", (String)product.get("price"));
		    	
		    	linea.append("producto", producto);
		    	linea.append("amount", (Long)aux.get("amount"));
		    	linea.append("price", (Long)aux.get("price"));
		    	
		    	lineasPedido.add(linea);
		    }
	        //////////////////////////////////////////////////////////////////////////////////////ORDER

	        order.append("id", (Long) ord.get("id"));

	        order.append("client", cliente);

	        order.append("orderRows", lineasPedido);
	        
	        order.append("price", (Long) ord.get("price"));

	        order.append("delivered", (Boolean) ord.get("delivered"));
	        

			return order;
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
