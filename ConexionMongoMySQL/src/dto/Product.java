package dto;

import org.bson.Document;

public class Product implements MongoDocs{

	private int idProduct;
	private String name;
	private String description;
	private double price;
	private String picture;

	
	public Product(int idProduct,String name, String description, double price, String picture) {
		this.idProduct=idProduct;
		this.name = name;
		this.description = description;
		this.price = price;
		this.picture = picture;
	}
	public Product(Document doc) {
		this.idProduct = doc.getInteger("idProduct");
		this.name = doc.getString("name");
		this.description = doc.getString("description");
		this.price = doc.getDouble("price");
		this.picture = doc.getString("picture");
	}

	public int getIdProduct() {
		return idProduct;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public String getPicture() {
		return picture;
	}
	
	
	public String toString() {
		return "ID product: "+idProduct+"\n"+
				"name: "+name+"\n"+
				"description: "+description+"\n"+
				"price: "+price+"\n"+
				"picture"+picture+"\n";
	}

	@Override
	public Document toDocument() {
		Document book= new Document()
         		.append("idProduct", idProduct)
         		.append("name",name)
         		.append("description", description)
         		.append("price", price)
         		.append("picture", picture);
		return book;
	}
	
}
