package gui.escuchador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import dto.Carta;
import gui.Pantalla;
import logica.Logica;

public class Escuchador implements ActionListener{
	public static int cont=0;
	public static int oportunidades=4;
	public static boolean noEra=false;

	private static JToggleButton[] botones=new JToggleButton[2];
	
	Pantalla p;
	private JPanel panelXogo;
	
	private Logica l;
	
	public Escuchador(Pantalla p,Logica l,JPanel panel) {	
		this.p=p;
		this.panelXogo=panel;
		this.l=l;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(noEra) {
			waitSec(1);
			mostrarInterrogacion();
			noEra=false;
			cont=0;
			botones[0]=null;
			botones[1]=null;
		}else		
		if(oportunidades!=0) {	
			
			JToggleButton btnX=(JToggleButton) e.getSource();
			Carta carta=l.getCartaByID(btnX.getName());
			mostrarCarta(carta,btnX);
			if(botones[0]!=btnX) {
				cont++;
				switch(cont) {
					case 1:	botones[0]=btnX;
						break;
					case 2:{botones[1]=btnX;
						if(botones[0].getName().equals(botones[1].getName())) {
							carta.setEncontrar(true);
				
							mostrarCarta(carta,botones[0]);botones[0].setSelected(false);botones[0].setEnabled(false);
							mostrarCarta(carta,botones[1]);botones[1].setSelected(false);botones[1].setEnabled(false);
							
							if(l.comprobarVictoria()) {
								panelXogo.setVisible(false);
								p.dialogoResultado(true);
							}
	
							botones[0]=null;
							botones[1]=null;
						}else {
							oportunidades--;
							p.setMsg("Intentos restantes : "+String.valueOf(oportunidades));
							
							noEra=true;
							btnX.doClick();
						}
						cont=0;	
					}
						break;
				}
			}else btnX.setSelected(false);
	
		}
		if(oportunidades==0) {
			panelXogo.setVisible(false);
			p.dialogoResultado(false);
		}
	}
	
	private void mostrarInterrogacion() {
		String tipo="pregunta";
		if (p.getNumC()>=16) {
			tipo="preguntaV2";
		}
		String imagen="/otrosIconos/"+tipo+".png";
		botones[0].setSelected(false);
		botones[0].setIcon(new ImageIcon(Pantalla.class.getResource(imagen)));
		botones[1].setSelected(false);
		botones[1].setIcon(new ImageIcon(Pantalla.class.getResource(imagen)));
	}
	private void mostrarCarta(Carta carta, JToggleButton btnX1) {
		
		String imagen=carta.getPicture();
		btnX1.setIcon(new ImageIcon(Pantalla.class.getResource(imagen)));
		
	}

	public void waitSec(int secs) {
		try {
			Thread.sleep(secs*1000);
		} catch (InterruptedException e) {
			System.out.println("error esperando");
		}
	}

}
