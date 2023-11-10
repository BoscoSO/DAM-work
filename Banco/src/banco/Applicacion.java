package banco;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bdCuentas.BaseDatos;
import bdCuentas.BaseDatosException;
import bdCuentas.PreBaseDatos;
import cuenta.Cliente;
import cuenta.ClienteException;
import cuenta.CuentaPlusTransfer;
import cuenta.CuentaRegalito;
import dni.DNIException;
import utilidadesbanco.CCCException;
import utilidadesbanco.UtilidadesBanco;

public class Applicacion {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	private boolean registrarse=false;
	protected BaseDatos bd;
	private PreBaseDatos preBd;
//	private CargaBaseDatos guardadoMemoria;
	
	public void exit(int i) {

		preBd.cerrarBaseDatos();
//		bd.cerrarBaseDatos();
		System.exit(i);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Applicacion window = new Applicacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("run-"+e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Applicacion() {
		preBd = new PreBaseDatos();
		this.bd=preBd.getBaseDatos();
		
		//this.bd=new BaseDatos();
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 554, 250);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(136, 94, 181, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(80, 97, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(80, 140, 46, 14);
		frame.getContentPane().add(lblDni);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("00000000A");
		textField_1.setColumns(10);
		textField_1.setBounds(136, 137, 181, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel messError = new JLabel("");
		messError.setBounds(80, 69, 394, 14);
		frame.getContentPane().add(messError);
	
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a,b;
				a=textField.getText();
				b=textField_1.getText().toLowerCase();

				if(a.isEmpty() || b.isEmpty()) {

					messError.setText("Rellena ambos campos para continuar");	
				}else {
					Cliente cli;
					try {
						cli = bd.getCliente(a,b);
						ApplicacionGestorCliente.ejecuta(cli);
						messError.setText("");
					} catch (BaseDatosException e1) {
						messError.setText(e1.getMessage());
					}
				}
			}
		});
		btnNewButton.setBounds(405, 110, 105, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_3 = new JButton("Crear Cliente\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom,dni;
				nom=textField.getText();
				dni=textField_1.getText();
				boolean datos=false;
				try {
					bd.comprobarDatos(dni,"");
					datos=true;
				} catch (BaseDatosException e1) {
					messError.setText(e1.getMessage());
				} 
				if(datos) 
					try {
						new Cliente(dni,nom,bd);
						messError.setText("Cliente creado");
					} catch (ClienteException | DNIException e1) {
						messError.setText(e1.getMessage());
					}
				
				
			}
		});
		btnNewButton_3.setBounds(172, 178, 120, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cerrar Programa");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit(0);
			}
		});
		btnNewButton_4.setBounds(10, 11, 132, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 232, 528, 244);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Entidad\r\n");
		lblNewLabel_1.setBounds(48, 14, 54, 14);
		panel.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 11, 181, 20);
		panel.add(textField_3);
		textField_3.setToolTipText("1111");
		textField_3.setColumns(10);
		
		JLabel lblOficina = new JLabel("Oficina");
		lblOficina.setBounds(48, 35, 54, 14);
		panel.add(lblOficina);
		
		textField_4 = new JTextField();
		textField_4.setBounds(106, 32, 181, 20);
		panel.add(textField_4);
		textField_4.setToolTipText("1111");
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(106, 54, 181, 20);
		panel.add(textField_5);
		textField_5.setToolTipText("-1111111111-");
		textField_5.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(48, 60, 54, 14);
		panel.add(lblCliente);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(48, 99, 41, 14);
		panel.add(lblPais);
		
			
			textField_6 = new JTextField();
			textField_6.setBounds(88, 96, 41, 20);
			panel.add(textField_6);
			textField_6.setColumns(10);
			
			textField_7 = new JTextField();
			textField_7.setBounds(139, 96, 148, 20);
			panel.add(textField_7);
			textField_7.setEditable(false);
			textField_7.setColumns(10);
			
			
			JLabel lblIban = new JLabel("IBAN");
			lblIban.setBounds(71, 155, 46, 14);
			panel.add(lblIban);
			
			textField_2 = new JTextField();
			textField_2.setBounds(127, 152, 181, 20);
			panel.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblTipoDeCuenta = new JLabel("Tipo de cuenta :");
			lblTipoDeCuenta.setBounds(71, 205, 96, 14);
			panel.add(lblTipoDeCuenta);
			

			JComboBox<String> comboBox = new JComboBox<String>();
			comboBox.setBounds(177, 197, 131, 30);
			panel.add(comboBox);
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Cuenta Regalito", "Cuenta PlusTransfer"}));
			

			
			JLabel lblNewLabel_3 = new JLabel("No tienes cuenta?");
			lblNewLabel_3.setBounds(313, 15, 126, 14);
			frame.getContentPane().add(lblNewLabel_3);
			
			JButton btnNewButton_2 = new JButton("Crearla");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registrarse=!registrarse;
					if(registrarse) {
						frame.setBounds(frame.getX(), frame.getY(), 554, 502);
						btnNewButton_2.setText("Ocultar");
						lblNewLabel_3.setText("");
					}else {
						frame.setBounds(frame.getX(), frame.getY(), 554, 250);
						btnNewButton_2.setText("Crearla");
						lblNewLabel_3.setText("No tienes cuenta?");
					}
				}
			});
			btnNewButton_2.setBounds(420, 11, 105, 23);
			frame.getContentPane().add(btnNewButton_2);
			
			
			JButton btnNewButton_1 = new JButton("CCC\r\n");
			btnNewButton_1.setBounds(361, 51, 89, 23);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String a,b,c;
					a=textField_3.getText();
					b=textField_4.getText();
					c=textField_5.getText();
					String ccc;
					try {
						ccc = UtilidadesBanco.calcular_CCC(a,b,c);
						textField_7.setText(ccc);
					} catch (CCCException e1) {
						messError.setText(e1.getMessage());
					}
				}
			});
			panel.add(btnNewButton_1);
			JButton btnIban = new JButton("iban\r\n");
			btnIban.setBounds(361, 95, 89, 23);
			btnIban.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String a=textField_6.getText();
					
					try {
						String iban=UtilidadesBanco.calcular_iban(a,textField_7.getText());
						textField_2.setText(iban);
					} catch (CCCException e1) {

						messError.setText(e1.getMessage());
					}
				}
			});
			panel.add(btnIban);
			JButton btnCrear = new JButton("Crear\r\n Cuenta");
			btnCrear.setBounds(349, 201, 116, 23);
			btnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String iban;
					iban=textField_2.getText();
					int op=comboBox.getSelectedIndex();					
					boolean datos=false;
					try {
						bd.comprobarDatos("",iban);
						datos=true;
					} catch (BaseDatosException e1) {
						messError.setText(e1.getMessage());
					} 
					
					if(datos)
						try {
							if(op==0) {
							
									new CuentaRegalito(iban,bd);
									frame.setBounds(frame.getX(), frame.getY(), 554, 250);
									btnNewButton_2.setText("Crearla");
									lblNewLabel_3.setText("No tienes cuenta?");
									messError.setText("Cuenta creada correctamente");	
									registrarse=!registrarse;
							}else {
									new CuentaPlusTransfer(iban,bd);
									frame.setBounds(frame.getX(), frame.getY(), 554, 250);
									btnNewButton_2.setText("Crearla");
									lblNewLabel_3.setText("No tienes cuenta?");
									messError.setText("Cuenta creada correctamente");
									registrarse=!registrarse;
					
							}
							
						} catch (Exception e1) {
							messError.setText(e1.getMessage());
						}
					
				}
			});
			panel.add(btnCrear);
			
			JButton btnNewButton_5 = new JButton("BaseDatos");
			btnNewButton_5.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					ApplicacionBD.ejecuta(bd);
				}
				
			});
			btnNewButton_5.setBounds(19, 45, 116, 23);
			frame.getContentPane().add(btnNewButton_5);
			
			
			
		
	
	}
}
