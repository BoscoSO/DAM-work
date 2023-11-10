package xestionClientes.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import xestionClientes.dto.Cliente;
import xestionClientes.logica.LogicaNegocio;

public class dialogoAlta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNome;
	private JTextField textApelidos;
	private JComboBox provincias;
	JSpinner dataAlta;
	SpinnerDateModel spinMod;
	
	
	PantallaPrincipal principal;
	
	public dialogoAlta(PantallaPrincipal jj,JFrame parent,boolean c) {
		super(parent,c);
		principal=jj;
		initialize1();
		
	}
	private void  initialize() {
		
		setBounds(500, 300, 460, 297);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 35, 23));
		
		JPanel panelAlta = new JPanel();
		panelAlta.setBounds(30, 27, 400, 209);
		
		contentPanel.add(panelAlta);
		panelAlta.setLayout(new BorderLayout(10, 30));
		
		JPanel panel = new JPanel();
		panelAlta.add(panel, BorderLayout.WEST);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNome = new JLabel("Nome: ");
		panel.add(lblNome);
		
		textNome = new JTextField();
		panel.add(textNome);
		textNome.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panelAlta.add(panel_1, BorderLayout.EAST);
		
		JLabel lblApelidos = new JLabel("Apelidos:");
		panel_1.add(lblApelidos);
		
		textApelidos = new JTextField();
		panel_1.add(textApelidos);
		textApelidos.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		panelAlta.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblDataDeAlta = new JLabel("Data de alta:");
		panel_2.add(lblDataDeAlta);
		
		spinMod=new SpinnerDateModel();
		dataAlta=new JSpinner(spinMod);
		dataAlta.setEditor(new JSpinner.DateEditor(dataAlta,"dd-MM-yyyy"));
		dataAlta.setModel(new SpinnerDateModel(new Date(1602709200000L), null, null, Calendar.DAY_OF_YEAR));
		
		panel_2.add(dataAlta);
		
		JPanel panel_3 = new JPanel();
		panelAlta.add(panel_3, BorderLayout.SOUTH);
		
		JLabel lblProvincia = new JLabel("Provincia: ");
		panel_3.add(lblProvincia);
		
		provincias = new JComboBox();
		provincias.setModel(new DefaultComboBoxModel(new String[] {"A Coru\u00F1a ", "Lugo ", "Orense", "Pontevedra"}));
		
		panel_3.add(provincias);
		

		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAlta = new JButton("Alta");
				
				btnAlta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAlta();

						dispose();
					}
				});
				buttonPane.add(btnAlta);
			}
		}
	}
	private void initialize1() {

		setBounds(500, 300, 455, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelAlta = new JPanel();
		panelAlta.setBounds(30, 27, 400, 209);
		
		contentPanel.add(panelAlta);
		panelAlta.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(43, 24, 70, 15);
		panelAlta.add(lblNome);
		
		JLabel lblApelidos = new JLabel("Apelidos:");
		lblApelidos.setBounds(43, 52, 70, 15);
		panelAlta.add(lblApelidos);
		
		JLabel lblDataDeAlta = new JLabel("Data de alta:");
		lblDataDeAlta.setBounds(43, 92, 114, 15);
		panelAlta.add(lblDataDeAlta);
		
		JLabel lblProvincia = new JLabel("Provincia: ");
		lblProvincia.setBounds(43, 154, 146, 15);
		panelAlta.add(lblProvincia);
		
		textNome = new JTextField();
		textNome.setBounds(163, 22, 225, 19);
		panelAlta.add(textNome);
		textNome.setColumns(10);
		
		
		provincias = new JComboBox();
		provincias.setModel(new DefaultComboBoxModel(new String[] {"A Coru\u00F1a ", "Lugo ", "Orense", "Pontevedra"}));
		provincias.setBounds(163, 149, 225, 24);
		panelAlta.add(provincias);
		
		textApelidos = new JTextField();
		textApelidos.setColumns(10);
		textApelidos.setBounds(163, 50, 225, 19);
		panelAlta.add(textApelidos);
		
		spinMod=new SpinnerDateModel();
		dataAlta=new JSpinner(spinMod);
		
		dataAlta.setEditor(new JSpinner.DateEditor(dataAlta,"dd-MM-yyyy"));
//		dataAlta.setModel(new SpinnerDateModel(new Date(1602709200000L), null, null, Calendar.DAY_OF_YEAR));
		dataAlta.setBounds(163, 90, 225, 20);
		panelAlta.add(dataAlta);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAlta = new JButton("Alta");
				
				btnAlta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAlta();

						dispose();
					}
				});
				buttonPane.add(btnAlta);
			}
		}
		
	}
	private void btnAlta() {
		String nome,apelidos,provincia;
		
		
		nome=textNome.getText();
		apelidos=textApelidos.getText();
		Date data=(Date) dataAlta.getValue();
		provincia=(String) provincias.getSelectedItem();
		
		
		
		principal.newClient(new Cliente(nome,apelidos,data,provincia));        

		
		
	}
}
