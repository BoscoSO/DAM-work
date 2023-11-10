package dto;

import org.bson.Document;

public class Client  implements MongoDocs{

	private int idClient;
	private String dni;
	private String name;
	
	public Client(int idClient, String dni, String name) {
		this.idClient = idClient;
		this.dni = dni;
		this.name = name;
	}
	public Client(Document doc) {
		this.idClient = doc.getInteger("idClient");
		this.dni = doc.getString("dni");
		this.name = doc.getString("name");
	}


	public int getIdClient() {
		return idClient;
	}
	public String getDni() {
		return dni;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "ID cliente: "+idClient+"\n"+
				"DNI: "+dni+"\n"+
				"Name: "+name+"\n";
	}


	@Override
	public Document toDocument() {
		Document client= new Document()
         		.append("idClient", idClient)
         		.append("dni",dni)
         		.append("name", name);
		return client;
	}
	
}
