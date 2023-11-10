package banco;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cuenta.Cliente;
import cuenta.Cuenta;
import utilidadesbanco.CCCException;
import utilidadesbanco.UtilidadesBanco;

public class ApplicacionGestorCliente {

	private JFrame frame;
	private final JPanel panel_1 = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel[] cuentasClientes=new JLabel[0];
	private Cliente cliente;
	private boolean creandoCC=false;
	
	private void infoCuentas(JPanel panel) {
		String[] cc=cliente.getCuentasInfo();
		for(JLabel jl: cuentasClientes) {
			jl.setText("");
		}
		cuentasClientes=new JLabel[cc.length];
		int posY=94;
		int i=0;
		for(int x=0;x<cc.length;x++) {
			
			JLabel cuentasCli = new JLabel("\r\n");
			cuentasCli.setVerticalAlignment(SwingConstants.TOP);
			cuentasCli.setBounds(10, posY, 282, 14);
			panel.add(cuentasCli);
			cuentasCli.setText(cc[i]);		
			posY+=25;
			
			cuentasClientes[i++]=cuentasCli;
		}		
	}
	/**
	 * Launch the application.
	 */

	public static void ejecuta(Cliente cli) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicacionGestorCliente window = new ApplicacionGestorCliente(cli);
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("ejecuta -"+e.getMessage());
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public ApplicacionGestorCliente(Cliente cli) {

		this.cliente=cli;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setResizable(false);
		frame.setBounds(100, 100, 445, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel nombre = new JLabel("Nombre :");
		nombre.setBounds(10, 11, 65, 14);
		panel.add(nombre);
		
		JLabel dni = new JLabel("DNI :\r\n");
		dni.setBounds(30, 36, 47, 14);
		panel.add(dni);
		
		JLabel nombreCli = new JLabel("\r\n");
		nombreCli.setBounds(72, 11, 65, 14);
		panel.add(nombreCli);
		nombreCli.setText(cliente.getNombre());
		
		JLabel dniCli = new JLabel("\r\n");
		dniCli.setBounds(82, 36, 65, 14);
		panel.add(dniCli);
		dniCli.setText(cliente.getDni());
		JLabel cuentas = new JLabel("Cuentas asociadas :");
		cuentas.setBounds(10, 65, 154, 14);
		panel.add(cuentas);

		JComboBox<String> ccuentas = new JComboBox<String>();
		ccuentas.setBounds(280, 170, 133, 30);
		panel.add(ccuentas);
		ccuentas.setModel(new DefaultComboBoxModel<String>(cliente.getCuentas()));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(106, 236, 311, 14);
		panel_1.add(lblNewLabel);
		
		
		JButton sleccionar = new JButton("Seleccionar");
		sleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int indice=ccuentas.getSelectedIndex();
				
				Cuenta c=cliente.getCC(indice);

				ApplicacionGestorCC.ejecuta(c);
				
				
			}
		});
		sleccionar.setBounds(280, 211, 133, 23);
		panel.add(sleccionar);
		
		
		infoCuentas(panel);
		
		JButton cuentaNueva = new JButton("Nueva Cuenta");
		cuentaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creandoCC=!creandoCC;
				if(creandoCC) {
					frame.setBounds(frame.getX(), frame.getY(), 910, 300);
					cuentaNueva.setText("Ocultar");
				}else {
					frame.setBounds(frame.getX(), frame.getY(), 445, 300);
					cuentaNueva.setText("Nueva Cuenta");
				}
			}
		});
		cuentaNueva.setBounds(280, 32, 133, 23);
		panel.add(cuentaNueva);
		panel_1.setBounds(436, 0, 462, 271);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Entidad\r\n");
		label.setBounds(48, 14, 54, 14);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setToolTipText("1111");
		textField.setColumns(10);
		textField.setBounds(106, 11, 181, 20);
		panel_1.add(textField);
		
		JLabel label_1 = new JLabel("Oficina");
		label_1.setBounds(48, 35, 54, 14);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("1111");
		textField_1.setColumns(10);
		textField_1.setBounds(106, 32, 181, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("-1111111111-");
		textField_2.setColumns(10);
		textField_2.setBounds(106, 54, 181, 20);
		panel_1.add(textField_2);
		
		JLabel label_2 = new JLabel("Cliente");
		label_2.setBounds(48, 60, 54, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Pais");
		label_3.setBounds(48, 99, 41, 14);
		panel_1.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(88, 96, 41, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(139, 96, 148, 20);
		panel_1.add(textField_4);
		
		JLabel label_4 = new JLabel("IBAN");
		label_4.setBounds(71, 155, 46, 14);
		panel_1.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(127, 152, 181, 20);
		panel_1.add(textField_5);
		
		JLabel label_5 = new JLabel("Tipo de cuenta :");
		label_5.setBounds(71, 205, 96, 14);
		panel_1.add(label_5);
		
		JButton button = new JButton("CCC\r\n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a,b,c;
				a=textField.getText();
				b=textField_1.getText();
				c=textField_2.getText();
				String ccc;
				try {
					ccc = UtilidadesBanco.calcular_CCC(a,b,c);
					textField_4.setText(ccc);
				} catch (CCCException e1) {
					lblNewLabel.setText(e1.getMessage());
				}
			}
		});
		button.setBounds(361, 51, 89, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("iban\r\n");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=textField_3.getText();
				
				try {
					String iban=UtilidadesBanco.calcular_iban(a,textField_4.getText());
					textField_5.setText(iban);
				} catch (CCCException e1) {
					lblNewLabel.setText(e1.getMessage());
				}
			}
		});
		button_1.setBounds(361, 95, 89, 23);
		panel_1.add(button_1);
		
		JComboBox<String> tipoC = new JComboBox<String>();
		tipoC.setBounds(177, 197, 131, 30);
		panel_1.add(tipoC);
		tipoC.setModel(new DefaultComboBoxModel<String>(new String[] {"Cuenta Regalito", "Cuenta PlusTransfer"}));
		
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(ApplicacionGestorCC.class.getResource("/iconos/reload.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoCuentas(panel);
				ccuentas.setModel(new DefaultComboBoxModel<String>(cliente.getCuentas()));
			}
		});
		btnNewButton_1.setBounds(134, 63, 19, 18);
		panel.add(btnNewButton_1);
		
		JButton btnCrearagregar = new JButton("Crear\r\n/Agregar"); 
		btnCrearagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String a;
				a=textField_5.getText();
				int op=tipoC.getSelectedIndex();
				try {
					
					cliente.addCuenta(op,a,null);
	

					infoCuentas(panel);
					ccuentas.setModel(new DefaultComboBoxModel<String>(cliente.getCuentas()));
					frame.setBounds(frame.getX(), frame.getY(), 445, 300);
					creandoCC=!creandoCC;
					cuentaNueva.setText("Nueva Cuenta");
				} catch (Exception e1) {
					lblNewLabel.setText(e1.getMessage());
				}
				
			}
		});
		btnCrearagregar.setBounds(328, 201, 122, 23);
		panel_1.add(btnCrearagregar);
		
		

		
	}
}
