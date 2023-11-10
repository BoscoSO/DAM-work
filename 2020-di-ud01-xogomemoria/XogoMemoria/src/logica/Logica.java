package logica;

import java.util.ArrayList;
import java.util.Random;

import dto.Carta;

public class Logica {

	private ArrayList<Carta> bdCartas;

	private ArrayList<Carta> cartas;
	
	private void inicializarCartas() {
		bdCartas=new ArrayList<Carta>();
		bdCartas.add(new Carta("0", "/frutas/fresa.png"));
		bdCartas.add(new Carta("1", "/frutas/cereza.png"));
		bdCartas.add(new Carta("2", "/frutas/platanos.png"));
		bdCartas.add(new Carta("3", "/frutas/mango.png"));
		bdCartas.add(new Carta("4", "/frutas/pina.png"));
		bdCartas.add(new Carta("5", "/frutas/uvas.png"));
		bdCartas.add(new Carta("6", "/frutas/arandano.png"));
		bdCartas.add(new Carta("7", "/frutas/sandia.png"));
		
	}
	public void setCartas(int i) {
		inicializarCartas();
		cartas=new ArrayList<Carta>();
		Random r=new Random();
		int numC=i/2;
		int aux=0;
		int y=0;
		while(y<numC) {
			aux=r.nextInt(8);
			if(!cartas.contains(bdCartas.get(aux))) {
				cartas.add(bdCartas.get(aux));
				y++;
			}
		}
	}
	
	public String[] distribuir() {
		int tam=cartas.size();

		String[] distribucion=new String[tam*2];
		Random r=new Random();
		int i=0;
		while(i<distribucion.length) {
			int cardI=r.nextInt(tam);
			if(cartas.get(cardI).getEnPantalla()<2) {
				cartas.get(cardI).anhadeAPantalla();
				distribucion[i]=cartas.get(cardI).getID();
				i++;
			}
		}
		
		return distribucion;
	}
	public Carta getCartaByID(String id) {
		for(Carta c:cartas) {
			if(c.getID().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	
	public boolean comprobarVictoria() {
		for(Carta c:cartas) {
			if(!c.getEncontrada()) {
				return false;
			}
		}
		return true;

	}



}
