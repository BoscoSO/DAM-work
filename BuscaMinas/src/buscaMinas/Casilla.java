package buscaMinas;

public class Casilla {
	private int minasArround;
	private boolean tapada;
	private boolean esMina;
	private boolean bandera;
	
	public Casilla(boolean esMina) {
		this.esMina=esMina;
		this.tapada=true;
		this.bandera=false;
		this.minasArround=0;
	}
	
	public String getCasString() {
		if(bandera)
			return "P";
		if(tapada)
			return " ";
		if(esMina) return "X";
		
		return String.valueOf(minasArround);
	}
	
	
	public void minaMas() {
		this.minasArround++;
	}
	public boolean esMina() {
		return this.esMina;
	}
	public void destapar() {
		this.tapada=false;
	}
	public boolean estaDes() {
		return !this.tapada;
	}
	public void bandera(boolean es) {
		this.bandera=es;
	}
	public int getMinasArround() {
		return this.minasArround;
	}
}
