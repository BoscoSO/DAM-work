package log.mysql;


import java.util.ArrayList;

import dto.Client;
import dto.Order;
import dto.Product;

public class OperationsMySQL {
	private Conection orderDB;
	private String url;
	public String getErros() {return this.orderDB.getErros();}
	
	public OperationsMySQL(String url){
		this.url=url;
		this.orderDB = new Conection();
	}
	public void openCon()throws Exception {

		orderDB.openConection(url);
		
	}
	public ArrayList<Order> ordersList()throws Exception{
		
		return orderDB.getOrdersList(); 
	}
	public ArrayList<Product> productList()throws Exception{
			
		return orderDB.getProductList(); 
	}
	public ArrayList<Client> clientList()throws Exception{
		
	return orderDB.getClientList(); 
	}
	
	public boolean existProduct(int id) throws Exception{
		if(orderDB.getProduct(id)!=null) {
			return true;
		}
		return false;
	}
	public boolean existClient(int id) throws Exception{
		if(orderDB.getClient(id)!=null) {
			return true;
		}
		return false;
	}
	
	
	public Order getOrder(int id) throws Exception{
		return orderDB.getOrder(id);
	}
	public Product getProduct(int id) throws Exception{
		return orderDB.getProduct(id);
	}
	public Client getClient(int id) throws Exception{
		return orderDB.getClient(id);
	}
	
	public void addOrder(Order order)throws Exception {

		int idCL=order.getClient().getIdClient();
		int idPro=order.getProduct().getIdProduct();
		
		if(existClient(idCL)) {
			if(existProduct(idPro)) {
				orderDB.addOrder(order.getIdPedido(),idPro,idCL,order.getAmount());
			}	
		}
	
	
	}
	public void modifyOrder(Order order) throws Exception{
		int idCL=order.getClient().getIdClient();
		int idPro=order.getProduct().getIdProduct();
		
		if(existClient(idCL)) {
			if(existProduct(idPro)) {
				orderDB.modifyOrder(order.getIdPedido(),idPro,idCL,order.getAmount());
			}	
		}
	}	
	public int deleteOrder(int idPedido)throws Exception {
		return orderDB.deleteOrder(idPedido);
		
		
	}
	
	public void quit() throws Exception{
		this.orderDB.closeConection();
	}

	
	
}
