package buscaMinas;

import java.util.Random;

public class Mapa {
	private Casilla mapa[][];
	private final int LADO;
	private int dif;
	private int num;
	public Mapa(int l,int d){
		this.LADO=l;
		mapa=new Casilla[LADO][LADO];
		dif=d;
		inicializar();
									
	}
	
	private void inicializar() {
		Random n=new Random();
		
		for(int y=0;y<LADO;y++)
			for(int x=0;x<LADO;x++)
				if(n.nextInt(dif)==1) {
					mapa[x][y]=new Casilla(true);
				}else {
					mapa[x][y]=new Casilla(false);
					num++;
				}
		for(int y=0;y<LADO;y++)
			for(int x=0;x<LADO;x++)
				if(!getCasilla(x,y).esMina())
					minasAlrededor(x,y);
		
	}
	public void reset() {
		inicializar();
	}
	private void minasAlrededor(int x, int y) {
		Casilla cas;
		for(int i=y-1;i<=y+1;i++) {
			for(int c=x-1;c<=x+1;c++){
				cas=getCasilla(c,i);
				if(cas!=null)
					if(cas.esMina()) 
						mapa[x][y].minaMas();
				
			}
		}
	}
	private Casilla getCasilla(int x, int y) {
		if(x<0 || y<0 || x>=LADO || y>=LADO)
			return null;
	
		return mapa[x][y];		
	}
	public String getMapa() {
		String m="";
		for(int y=0;y<LADO;y++) {
			for(int x=0;x<LADO;x++)
				m+=" | "+mapa[x][y].getCasString();
			m+=" |\n";
		}
		return m;
	}
	public String getCas(int x,int y) {
		return mapa[x][y].getCasString();
	}
	private boolean despejar(int x,int y){

		if(x<0 || y<0 || x>=LADO || y>=LADO) return false;
		if(mapa[x][y].esMina())	return false;
		if(mapa[x][y].estaDes()) return false;
		if(mapa[x][y].getMinasArround()!=0) {

			mapa[x][y].destapar(); 
			return false;
		}
		mapa[x][y].destapar();

		if(despejar(x+1,y)) return true;		//derecha
		if(despejar(x-1,y)) return true; 		//izquierda
		if(despejar(x,y+1)) return true;		//abajo
		if(despejar(x,y-1)) return true;		//arriba
		
		return false;
	}
	public void setBandera(int x,int y,boolean es) {
		mapa[x][y].bandera(es);
	}
	public boolean destapar(int x,int y) {
		
		if(mapa[x][y].esMina()) {
			mapa[x][y].destapar();
			return false;
		}else
			if(mapa[x][y].getMinasArround()==0) {

				despejar(x,y);
			}
		mapa[x][y].destapar();
		
		return true;
	
	
	}
	public int getNum() {
		return this.num;
	}
	public void finPartida() {
		for(int y=0;y<LADO;y++)
			for(int x=0;x<LADO;x++)
				if(mapa[x][y].esMina())
					mapa[x][y].destapar();
	}

}
