package testDialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Pantalla {

	private JFrame frame;
	private JTextField textField;

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
		
		textField = new JTextField();
		textField.setBounds(157, 94, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIntroduceNome = new JLabel("Introduce o teu nome");
		lblIntroduceNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceNome.setBounds(111, 47, 216, 15);
		frame.getContentPane().add(lblIntroduceNome);
		

		JButton btnDialogo = new JButton("Dialogo");
		btnDialogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaSecundaria scnd=new PantallaSecundaria(frame,textField.getText());
				scnd.setVisible(true);
			}
		});
		btnDialogo.setBounds(154, 159, 117, 25);
		frame.getContentPane().add(btnDialogo);
		
	}

}
