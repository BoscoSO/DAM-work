package ejercicioBtnTeclas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class EscuchandoTeclas  implements KeyListener {
	JLabel lbl;
	
	public EscuchandoTeclas(JLabel display){
		this.lbl=display;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_1) {
			suma(1);
		}
		if(arg0.getKeyCode()==KeyEvent.VK_2) {
			suma(2);
		}
		if(arg0.getKeyCode()==KeyEvent.VK_3) {
			suma(3);
		}
		if(arg0.getKeyCode()==KeyEvent.VK_S) {
			this.lbl.setText("");
		}
		
		
	}
	public void suma(int numPuls) {
		int aux;

		if(lbl.getText().isEmpty()) {
			aux=numPuls;
		}else
			aux=Integer.valueOf(lbl.getText())+numPuls;
		
		lbl.setText(String.valueOf(aux));
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
