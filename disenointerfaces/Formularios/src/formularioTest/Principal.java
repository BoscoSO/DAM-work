package formularioTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Principal {

	private JFrame frame;
	private JLabel lblNewLabel ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
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
		
		JButton btnNewButton = new JButton("Nuevo Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField username = new JTextField();
				JTextField age = new JTextField();
				//JTextField password = new JPasswordField();
				Object[] message = {
				    "Username:", username,
				    "age:", age
				};

				int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) 			
				     validarForm(username.getText(),age.getText());
				
			}
		});
		btnNewButton.setBounds(140, 94, 129, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setBounds(85, 165, 244, 48);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public boolean validarForm(String name,String age) {
		String mssgErr;
		if(!name.isEmpty() && !age.isEmpty()) {
			for(int i=0;i<age.length();i++)
				if(age.charAt(i)<48 ||age.charAt(i)>57  ) {
					mssgErr="caracteres no validos no campo edad";
					lblNewLabel.setText(mssgErr);
					return false;
				}
			if(Integer.valueOf(age)<=0) {
				mssgErr="edad introducida erronea";
				lblNewLabel.setText(mssgErr);
				return false;
			}
			for(int i=0;i<name.length();i++)
				if(name.charAt(i)<=64 ||name.charAt(i)>=123  ) {
					mssgErr="caracteres no validos no campo nome";
					lblNewLabel.setText(mssgErr);
					return false;
				}
				
				
		}else {
			mssgErr="Rellene ambos campos";
			lblNewLabel.setText(mssgErr);
			return false;
		}
		return true;
	}
}
