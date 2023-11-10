package ejercicioBtnTeclas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class SumaBtn implements ActionListener {
	private int numPuls;
	JLabel lbl;
	public SumaBtn(int i,JLabel lbl){
		numPuls=i;
		this.lbl=lbl;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int aux;

		if(lbl.getText().isEmpty()) {
			aux=numPuls;
		}else
			aux=Integer.valueOf(lbl.getText())+numPuls;
		
		lbl.setText(String.valueOf(aux));
	}
}