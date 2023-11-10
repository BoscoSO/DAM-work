package buscaMinas;

public class BuscaMinas {
	
	private Mapa campo;
	private boolean esFin;
	private boolean win;
	private int cont;
	
	public BuscaMinas(int t,int d) {
		campo=new Mapa(t,d);
		esFin=false;
	}
	
	
	public String getMapa() {
		return campo.getMapa();
	}
	public String getCas(int x,int y) {
		return campo.getCas(x, y);
	}
	public void setBandera(int x,int y,boolean es) {
		campo.setBandera(x, y, es);
	}
	public void destapar(int x,int y) {
		if(!campo.destapar(x,y)) {
			esFin=true;
			win=false;
			campo.finPartida();
		}
		cont++;
		if(cont==campo.getNum()) {
			esFin=true;
			win=true;
			campo.finPartida();
		}
	}
	
	public boolean esFin() {
		return this.esFin;
	}
	public String ganador() {
		if(win)
			return "Enhorabuena as superado el nivel";
		return "Prueba Otra vez";
	}
	public void reset() {
		this.esFin=false;
		campo.reset();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
