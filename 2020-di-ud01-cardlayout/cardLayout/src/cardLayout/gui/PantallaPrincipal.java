package cardLayout.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaPrincipal {

	private JFrame frame;
	private JButton btnPanel1 ;
	private JButton btnPanel2 ;
	private JButton btnPanel3 ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
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
	public PantallaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		
		
		 
		frame.setSize(541, 320);
		frame.setLocationRelativeTo(null);
		
		JPanel panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		JPanel panelInferior = new JPanel();
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new BorderLayout(0, 0));
		
	
		
		JButton btnNewButton_1 = new JButton("Salir ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panelInferior.add(btnNewButton_1, BorderLayout.EAST);
		
		JPanel panelCentral = new JPanel();
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		CardLayout card = new CardLayout();

		JButton btnNewButton = new JButton("Restaurar App");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPanel1.setEnabled(true);
				btnPanel2.setEnabled(true);
				btnPanel3.setEnabled(true);
				card.show(panelCentral	, "panel0");
			}
		});
		panelInferior.add(btnNewButton, BorderLayout.WEST);
		
		panelCentral.setLayout(card);
		
		JPanel panel0 = new JPanel();
		panel0.setBackground(Color.ORANGE);
		panelCentral.add(panel0, "panel0");
		panel0.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPanel_1 = new JLabel("Panel 0");
		panel0.add(lblPanel_1);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.PINK);
		panelCentral.add(panel1, "panel1");
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPanel_2 = new JLabel("Panel 1");
		panel1.add(lblPanel_2);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.CYAN);
		panelCentral.add(panel2, "panel2");
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPanel_3 = new JLabel("Panel 2");
		panel2.add(lblPanel_3);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.MAGENTA);
		panelCentral.add(panel3, "panel3");
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPanel = new JLabel("Panel 3");
		panel3.add(lblPanel);
		
		
		btnPanel1 = new JButton("panel 1");
		btnPanel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panelCentral	, "panel1");
				btnPanel1.setEnabled(false);
				btnPanel2.setEnabled(true);
				btnPanel3.setEnabled(true);
			}
		});
		panelSuperior.add(btnPanel1);
		
		btnPanel2 = new JButton("panel 2");
		btnPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panelCentral	, "panel2");
				btnPanel1.setEnabled(true);
				btnPanel2.setEnabled(false);
				btnPanel3.setEnabled(true);
			}
		});
		panelSuperior.add(btnPanel2);
		
		btnPanel3 = new JButton("panel 3");
		btnPanel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panelCentral	, "panel3");
				btnPanel1.setEnabled(true);
				btnPanel2.setEnabled(true);
				btnPanel3.setEnabled(false);
			}
		});
		panelSuperior.add(btnPanel3);
	}
}
