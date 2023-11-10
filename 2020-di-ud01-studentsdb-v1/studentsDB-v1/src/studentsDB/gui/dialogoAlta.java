package studentsDB.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import studentsDB.dto.Student;
import studentsDB.loxica.Loxica;


public class dialogoAlta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
        private JTextField textDni;
	private JTextField textNome;
        private JTextField textApelidos;
	private JTextField textIdade;
	private JLabel msgError;
	JSpinner dataAlta;
	SpinnerDateModel spinMod;
	
	
	PantallaPrincipal principal;
	
	public dialogoAlta(PantallaPrincipal jj,JFrame parent,boolean c) {
		super(parent,c);
		principal=jj;
	
		setBounds(100, 100, 490, 296);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelAlta = new JPanel();
		panelAlta.setBounds(30, 27, 400, 186);
		contentPanel.add(panelAlta);
		panelAlta.setLayout(null);
		
                msgError = new JLabel();
		msgError.setBounds(163, 130, 200, 30);
                msgError.setForeground(Color.red);
		panelAlta.add(msgError);
                
                JLabel lblDni = new JLabel("Dni: ");
		lblDni.setBounds(43, 25, 70, 15);
		panelAlta.add(lblDni);
                
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(43, 51, 70, 15);
		panelAlta.add(lblNome);
		
                JLabel lblApelidos = new JLabel("Apelidos: ");
		lblApelidos.setBounds(43, 80, 70, 15);
		panelAlta.add(lblApelidos);
                
		JLabel lblCurso = new JLabel("idade:");
		lblCurso.setBounds(43, 106, 70, 15);
		panelAlta.add(lblCurso);
		
                textDni = new JTextField();
		textDni.setBounds(163, 22, 225, 19);
		panelAlta.add(textDni);
		textDni.setColumns(9);
                
		textNome = new JTextField();
		textNome.setBounds(163, 48, 225, 19);
		panelAlta.add(textNome);
		textNome.setColumns(50);
                
                textApelidos = new JTextField();
		textApelidos.setBounds(163, 77, 225, 19);
		panelAlta.add(textApelidos);
		textApelidos.setColumns(250);
	
		textIdade = new JTextField();
		textIdade.setColumns(3);
		textIdade.setBounds(163, 103, 225, 19);
		textIdade.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {	
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					btnAlta();
				}
			}
		});
		panelAlta.add(textIdade);
	

		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAlta = new JButton("Alta");
				btnAlta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnAlta();
					}
				});
				buttonPane.add(btnAlta);
			}
		}
	}
	private void btnAlta() {
            boolean alta=true;
            String dni,nome,apelidos;int idade=0;
            if(textDni.getText().isEmpty() ||textNome.getText().isEmpty() ||textApelidos.getText().isEmpty() ||textIdade.getText().isEmpty() ){
                msgError.setText("Rellena todos los campos");
            }else{
                dni=textDni.getText();
                nome=textNome.getText();
                apelidos=textApelidos.getText();
                try {
                    idade=Integer.valueOf(textIdade.getText());
                } catch (Exception ex) {
                    msgError.setText("Formato de numero incorrecto");alta=false;
                }
                if(alta){
                     msgError.setText("");
                    try {
                        principal.getLoxica().addStudent(new Student(dni, nome,apelidos,idade));
                    } catch (Exception ex) {
                        System.out.println("Erros :"+principal.getLoxica().getErro());
                    }
                    principal.actualizarTaboa();
                    dispose();
                }
            }
	}
}
