package gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import gui.escuchador.Escuchador;
import logica.Logica;

public class Pantalla {

	private JPanel panel;
	private JFrame frame;
	private Logica logica;


	private JButton reset;
	private JLabel msg;
	
	private ArrayList<JToggleButton> botones;
	private int numC;
	public int getNumC() {
		return this.numC;
	}
	public void setMsg(String ms) {
		this.msg.setText(ms);
	}
	private void distribuirBtns(String[] distribucionB ) {
		JToggleButton btnCarta;

		botones=new ArrayList<JToggleButton>();
		
		String tipo="pregunta";
		if (numC>=16) {
			tipo="preguntaV2";
		}
		
		for(int i=0;i<numC;i++) {
			btnCarta = new JToggleButton();
			btnCarta.setName(distribucionB[i]);

			btnCarta.setIcon(new ImageIcon(Pantalla.class.getResource("/otrosIconos/"+tipo+".png")));
			btnCarta.addActionListener(new Escuchador(this,logica,panel));
			panel.add(btnCarta);
			botones.add(btnCarta);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
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
	public Pantalla() {
		logica=new Logica();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 681, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//*****************PANEL JUEGO*************************
		
		panel= new JPanel();
		panel.setBounds(13, 83, 645, 423);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 3));

		
		msg = new JLabel("Intentos restantes : 4");
		msg.setBounds(243, 57, 250, 14);
		frame.getContentPane().add(msg);
		numC=8;
		logica.setCartas(numC);
		String[] distribucion=logica.distribuir();
	
		distribuirBtns(distribucion);
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {8, 12, 16}));
		comboBox.setBounds(29, 11, 112, 20);
		frame.getContentPane().add(comboBox);
		 
		reset = new JButton("reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numC=(int) comboBox.getSelectedItem();
				Escuchador.cont=0;
				panel.setVisible(false);
				panel = new JPanel();
				panel.setBounds(10, 82, 645, 423);
				frame.getContentPane().add(panel);
				panel.setLayout(new GridLayout(0, 4, 0, 3+comboBox.getSelectedIndex()));
				Escuchador.oportunidades=4+comboBox.getSelectedIndex();
				logica.setCartas(numC);
				String[] distribucionB=logica.distribuir();
				distribuirBtns(distribucionB);
				
				msg.setText(("Intentos restantes : "+Escuchador.oportunidades));
			}
		});
		reset.setBounds(164, 10, 89, 23);
		frame.getContentPane().add(reset);

		
	}
	public void dialogoResultado(boolean b) {
		Dialogo scnd;
		if(b) {
			scnd=new Dialogo(frame,new ImageIcon(Pantalla.class.getResource("/animaciones/animacionGanar.gif")));
		}else {
			scnd=new Dialogo(frame,new ImageIcon(Pantalla.class.getResource("/animaciones/animacionPerder.gif")));
			
		}
		scnd.setVisible(true);	
		reset.doClick();
	}
}
