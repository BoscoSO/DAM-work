package transformadorUnidades;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class Aplicacion {

	private JFrame frame;
	private JTextField insertUnidades;
	private JTextField resultado;
	private JTextField campoTxt;
	private JTextField resultado3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacion window = new Aplicacion();
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
	public Aplicacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 775, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel conversor = new JPanel();
		conversor.setBounds(12, 12, 543, 109);
		frame.getContentPane().add(conversor);
		conversor.setLayout(null);
		
		insertUnidades = new JTextField();
		insertUnidades.setBounds(12, 48, 118, 19);
		conversor.add(insertUnidades);
		insertUnidades.setColumns(10);
		
		resultado = new JTextField();
		resultado.setEditable(false);
		resultado.setBounds(336, 48, 135, 19);
		conversor.add(resultado);
		resultado.setColumns(10);
		
		JComboBox<String> unidad = new JComboBox<String>();
		unidad.setModel(new DefaultComboBoxModel(new String[] {"millas", "yardas"}));
		unidad.setBounds(142, 45, 87, 24);
		conversor.add(unidad);
		
		JButton button = new JButton("->");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int uni=unidad.getSelectedIndex();
				
				double aCambiar=Float.valueOf(insertUnidades.getText());
				switch(uni) {
					case 0:		
							resultado.setText((aCambiar*1.60934)+" Km");
						break;
					case 1:
							resultado.setText((aCambiar*0.0009144)+" Km");
						break;
				}
			}
		});
		button.setBounds(263, 45, 49, 25);
		conversor.add(button);
		
	
		
		JLabel lblKm = new JLabel("Conversor a Km");
		lblKm.setBounds(184, 12, 118, 15);
		conversor.add(lblKm);
		
		JPanel loopBtns = new JPanel();
		loopBtns.setBounds(12, 136, 543, 109);
		frame.getContentPane().add(loopBtns);
		loopBtns.setLayout(null);
		
		JButton btnIzquierda = new JButton("a mi no me pulses");
		JButton btnDerecha = new JButton("Pulsame a mi");
		
		
		btnIzquierda.setEnabled(false);
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnIzquierda.setText("a mi no me pulses");
				btnIzquierda.setEnabled(false);
				btnDerecha.setText("Pulsame a mi");
				btnDerecha.setEnabled(true);
			}
		});
		btnIzquierda.setBounds(40, 43, 181, 25);
		btnIzquierda.setToolTipText("Nadie sabe para que sirve");
		loopBtns.add(btnIzquierda);
		
		
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDerecha.setText("a mi no me pulses");
				btnDerecha.setEnabled(false);;
				btnIzquierda.setText("Pulsame a mi");
				btnIzquierda.setEnabled(true);
			
			}
		});
		btnDerecha.setBounds(269, 43, 192, 25);
		btnDerecha.setToolTipText("Nadie sabe para que sirve");
		loopBtns.add(btnDerecha);
		
		JPanel sumador = new JPanel();
		sumador.setBounds(12, 257, 543, 109);
		frame.getContentPane().add(sumador);
		sumador.setLayout(null);
		
		resultado3 = new JTextField();
		resultado3.setEditable(false);
		resultado3.setColumns(10);
		resultado3.setBounds(262, 46, 135, 19);
		sumador.add(resultado3);
		
		campoTxt = new JTextField();
		campoTxt.setBounds(58, 46, 114, 19);
		sumador.add(campoTxt);
		campoTxt.setColumns(10);
		campoTxt.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					
					Double valor =Double.valueOf(campoTxt.getText());
					
					
					if(!resultado3.getText().isEmpty()) {
						resultado3.setText(String.valueOf(Double.valueOf(resultado3.getText())+valor));
					}else
						resultado3.setText(String.valueOf(valor));
					campoTxt.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		JButton btnReset = new JButton("reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				campoTxt.setText("");
				resultado3.setText("");
				
			}
		});
		btnReset.setBounds(426, 40, 94, 46);
		sumador.add(btnReset);
		
		resultado3 = new JTextField();
		resultado3.setEditable(false);
		resultado3.setColumns(10);
		resultado3.setBounds(262, 46, 135, 19);
		sumador.add(resultado3);
	}
}
