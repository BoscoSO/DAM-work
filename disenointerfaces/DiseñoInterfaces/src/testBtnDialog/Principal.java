package testBtnDialog;

import java.awt.EventQueue;

import javax.swing.JFrame;

import testDialog.PantallaSecundaria;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Izquierda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dialogo scnd=new Dialogo(frame,"izquierda");
				scnd.setVisible(true);			
			}
		});
		btnNewButton.setBounds(42, 129, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDerecha = new JButton("Derecha");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dialogo scnd=new Dialogo(frame,"derecha");
				scnd.setVisible(true);	
			}
		});
		btnDerecha.setBounds(273, 129, 117, 25);
		frame.getContentPane().add(btnDerecha);
	}

}
