package ejercicioBtnTeclas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class TeclaPulsada implements ActionListener {
	private int numPuls;
	JLabel lbl;
	public TeclaPulsada(int i,JLabel lbl){
		numPuls=i;
		this.lbl=lbl;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Pulsaches o botón.");
	}
}