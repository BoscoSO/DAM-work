package dto;

public class Carta {
	private final String id;
	private String picture;
	
	private int enPantalla;
	
	private boolean encontrada;
	
	public Carta(String id, String picture) {
		this.id = id;
		this.picture = picture;
		enPantalla=0;
		encontrada=false;
	}

	public String getPicture() {
		return this.picture;
	}
	public String getID() {
		return this.id;
	}
	public int getEnPantalla() {
		return this.enPantalla;
	}
	public void anhadeAPantalla() {
		enPantalla++;
	}
	
	public void setEncontrar(boolean b) {
		encontrada=b;
	}
	public boolean getEncontrada() {
		return this.encontrada;
	}
}
