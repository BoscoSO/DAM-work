package banco;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bdCuentas.BaseDatosException;
import cuenta.Cuenta;
import cuenta.MovimientoException;
import utilidadesbanco.CCCException;
import utilidadesbanco.IbanException;

public class ApplicacionGestorCC {

	private Cuenta cuenta;
	
	private JFrame frame;
	private JTextField ingreso;
	private JTextField retirar;
	private JTextField cantidadTrans;
	private JTextField ibanTrans;
	private JLabel[] clientesCuentas=new JLabel[0];
	private JTextField textField;
	private JTextField textField_1;
	
	private void infoClientes(JPanel panel) {
		String[] cc=cuenta.getClientesInfo();
		for(JLabel jl: clientesCuentas) {
			jl.setText("");
		}
		clientesCuentas=new JLabel[cc.length];
		int posY=30;
		int i=0;
		for(int x=0;x<cc.length;x++) {
			
			JLabel cuentasCli = new JLabel("\r\n");
			cuentasCli.setVerticalAlignment(SwingConstants.TOP);
			cuentasCli.setBounds(25, posY, 242, 14);
			panel.add(cuentasCli);
			cuentasCli.setText(cc[i]);		
			posY+=25;
			
			clientesCuentas[i++]=cuentasCli;
		}		
	}
	/**
	 * Launch the application.
	 */
	public static void ejecuta(Cuenta i) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicacionGestorCC window = new ApplicacionGestorCC(i);
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
	public ApplicacionGestorCC(Cuenta i) {
		cuenta=i;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */ 
	private void initialize() {
		frame = new JFrame();

		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 323);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 784, 284);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.setBounds(0, 0, 784, 284);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTitular = new JLabel("Titulares de la cuenta :");
		lblTitular.setBounds(20, 10, 174, 14);
		panel_2.add(lblTitular);
		
		infoClientes(panel_2);
		
		ingreso = new JTextField();
		ingreso.setBounds(375, 103, 86, 20);
		panel_2.add(ingreso);
		ingreso.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(579, 102, 127, 53);
		panel_2.add(panel);
		
		JLabel saldo = new JLabel("");
		saldo.setForeground(Color.WHITE);
		panel.add(saldo);
		JLabel mess = new JLabel("\r\n");
		mess.setHorizontalAlignment(SwingConstants.CENTER);
		mess.setBounds(128, 201, 215, 14);
		panel_2.add(mess);
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(ApplicacionGestorCC.class.getResource("/iconos/reload.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=cuenta.getSaldo();
				saldo.setText(a);
			}
		});
		btnNewButton_1.setBounds(716, 134, 25, 21);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=ingreso.getText();
				try {
					cuenta.ingresar(new BigDecimal(a));
				} catch (MovimientoException e1) {
					mess.setText(e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(471, 102, 73, 23);
		panel_2.add(btnNewButton);
		
		retirar = new JTextField();
		retirar.setColumns(10);
		retirar.setBounds(375, 135, 86, 20);
		panel_2.add(retirar);
		
		JButton btnRetirar = new JButton("Retirar");
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=retirar.getText();
				try {
					cuenta.retirar(new BigDecimal(a));
				} catch (MovimientoException e1) {
					mess.setText(e1.getMessage());
				}
			}
		});
		btnRetirar.setBounds(471, 132, 75, 23);
		panel_2.add(btnRetirar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(471, 10, 303, 45);
		panel_2.add(panel_1);
		
		JLabel regalo = new JLabel("\r\n");
		regalo.setForeground(Color.WHITE);
		panel_1.add(regalo);
		
		JButton btnNewButton_2 = new JButton("Regalito");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=cuenta.getRegalito();
				regalo.setText(a);
			}
		});
		btnNewButton_2.setBounds(384, 10, 85, 44);
		panel_2.add(btnNewButton_2);
		
		
		JLabel lblNewLabel = new JLabel("Transferencia :");
		lblNewLabel.setBounds(28, 201, 73, 14);
		panel_2.add(lblNewLabel);
		
		cantidadTrans = new JTextField();
		cantidadTrans.setBounds(87, 226, 65, 20);
		panel_2.add(cantidadTrans);
		cantidadTrans.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u20AC  a la cuenta de iban");
		lblNewLabel_1.setBounds(157, 229, 103, 14);
		panel_2.add(lblNewLabel_1);
		
		ibanTrans = new JTextField();
		ibanTrans.setColumns(10);
		ibanTrans.setBounds(270, 226, 110, 20);
		panel_2.add(ibanTrans);
		
		JButton btnNewButton_3 = new JButton("Transferir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a,b;
				b=cantidadTrans.getText();
				a=ibanTrans.getText();
				int cant=Integer.parseInt(b);
				try {
					cuenta.transferencia(a, cant);
					mess.setText("");
				} catch (IbanException | CCCException | MovimientoException | BaseDatosException e1) {
					mess.setText(e1.getMessage());
				}
			}
		});
		btnNewButton_3.setBounds(390, 225, 79, 23);
		panel_2.add(btnNewButton_3);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Transfiero");
		lblNewLabel_2.setBounds(28, 229, 49, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Saldo");
		lblNewLabel_3.setBounds(628, 84, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JButton btnNewButton_5 = new JButton("a\u00F1adir titular\r\n\r\n");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_2.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(238, 61, 127, 23);
		panel_2.add(btnNewButton_5);
		
		JLabel ibancuenta = new JLabel("");
		ibancuenta.setBounds(168, 10, 197, 14);
		panel_2.add(ibancuenta);
		ibancuenta.setText(cuenta.getIBAN());
		
		JLabel messError = new JLabel("");
		messError.setBounds(186, 41, 296, 14);
		panel_3.add(messError);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(168, 98, 46, 14);
		panel_3.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(224, 95, 181, 20);
		panel_3.add(textField);
		
		JLabel label_1 = new JLabel("DNI");
		label_1.setBounds(168, 141, 46, 14);
		panel_3.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("00000000A");
		textField_1.setColumns(10);
		textField_1.setBounds(224, 138, 181, 20);
		panel_3.add(textField_1);
		
		JButton btnNewButton_6 = new JButton("A\u00F1adir");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom=textField.getText();
				String dni=textField_1.getText();
			
				try {
					if(cuenta.comprobarClientes(nom,dni)) {
						messError.setText("Ese usuario ya está en esta cuenta");
					}else {
						cuenta.addCliente(nom, dni,true);
						
				
						panel_3.setVisible(false);
						panel_2.setVisible(true);

						infoClientes(panel_2);
					}
				} catch (BaseDatosException e1) {
					messError.setText(e1.getMessage());
				}
			}
		});
		btnNewButton_6.setBounds(451, 137, 89, 23);
		panel_3.add(btnNewButton_6);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(250, 232, 206, 23);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		panel_3.add(btnVolver);
		
		
		
	}
}
