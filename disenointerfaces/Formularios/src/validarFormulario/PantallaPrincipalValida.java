package validarFormulario;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.builtin.stringvalidation.ValidacionMaiusculas;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;

public class PantallaPrincipalValida {

	private JFrame frame;
	private JTextField text_nome;
	private JTextField text_edad;

	private JTextField text_mail;
	
	ValidationPanel validationPanel;
	private JLabel lblMail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Locale.setDefault(new Locale("gl","ES"));
				try {
					PantallaPrincipalValida window = new PantallaPrincipalValida();
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
	public PantallaPrincipalValida() {
		initialize();
		ValidationGroup grupo = validationPanel.getValidationGroup();
		grupo.add(text_nome, StringValidators.REQUIRE_NON_EMPTY_STRING,StringValidators.NO_WHITESPACE, StringValidators.MAY_NOT_START_WITH_DIGIT,new ValidacionMaiusculas());
		
		grupo.add(text_edad, StringValidators.REQUIRE_NON_NEGATIVE_NUMBER,StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_INTEGER);
	
		grupo.add(text_mail, StringValidators.EMAIL_ADDRESS);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton jButtonAceptar = new JButton("Aceptar");
		jButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		jButtonAceptar.setBounds(291, 253, 89, 23);
		frame.getContentPane().add(jButtonAceptar);
		jButtonAceptar.setEnabled(false);

		validationPanel = new ValidationPanel();
		validationPanel.setBounds(23, 11, 401, 69);
		frame.getContentPane().add(validationPanel);
		
		validationPanel.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if (validationPanel.getProblem() == null) {
					jButtonAceptar.setEnabled(true);
					} else {
					jButtonAceptar.setEnabled(false);
					}

			}
		});
		
		
		
		text_nome = new JTextField();
		text_nome.setName("nome");
		text_nome.setBounds(181, 91, 187, 30);
		frame.getContentPane().add(text_nome);
		text_nome.setColumns(10);
		
		text_edad = new JTextField();
		text_edad.setName("edad");
		text_edad.setColumns(10);
		text_edad.setBounds(181, 130, 187, 30);
		frame.getContentPane().add(text_edad);
		
		text_mail = new JTextField();
		text_mail.setName("edad");
		text_mail.setColumns(10);
		text_mail.setBounds(181, 171, 187, 30);
		frame.getContentPane().add(text_mail);
		
		JLabel lblNewLabel = new JLabel("nome :");
		lblNewLabel.setBounds(82, 95, 89, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEdad = new JLabel("edad :");
		lblEdad.setBounds(82, 134, 89, 22);
		frame.getContentPane().add(lblEdad);

		lblMail = new JLabel("mail :");
		lblMail.setBounds(82, 179, 89, 22);
		frame.getContentPane().add(lblMail);
	}
}
