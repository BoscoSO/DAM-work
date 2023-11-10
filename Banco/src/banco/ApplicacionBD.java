package banco;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import bdCuentas.BaseDatos;

public class ApplicacionBD {

	private JFrame frame;
	private BaseDatos bd;
	/**
	 * Launch the application.
	 */

	public static void ejecuta(BaseDatos baseD) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicacionBD window = new ApplicacionBD(baseD);
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
	public ApplicacionBD(BaseDatos baseD) {
		bd=baseD;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 546);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 299, 485);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(305, 11, 299, 485);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
			
		JTextArea textPane1 = new JTextArea();
		textPane1.setEditable(false);
		textPane1.setLineWrap(true);
		textPane1.setWrapStyleWord(true);
		JScrollPane scroll1 = new JScrollPane(textPane1);
		scroll1.setBounds(15, 70, 270, 410);
		panel.add(scroll1);
	
		JTextArea textPane2 = new JTextArea();
		textPane2.setEditable(false);
		textPane2.setLineWrap(true);
		textPane2.setWrapStyleWord(true);
		JScrollPane scroll2 = new JScrollPane(textPane2);
		scroll2.setBounds(15, 70, 270, 410);
		panel_1.add(scroll2);
	
	
		JButton btnNewButton = new JButton("Listar Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane1.setText(bd.verTodosClientes());
			}
		});
		btnNewButton.setBounds(75, 32, 120, 23);
		panel.add(btnNewButton);
	
		JButton btnListarCuentas = new JButton("Listar Cuentas");
		btnListarCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane2.setText(bd.verTodasCuentas());
			}
		});
		btnListarCuentas.setBounds(88, 36, 120, 23);
		panel_1.add(btnListarCuentas);
	}
}
