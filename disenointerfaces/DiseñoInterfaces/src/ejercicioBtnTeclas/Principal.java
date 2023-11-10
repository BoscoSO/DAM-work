package ejercicioBtnTeclas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Principal {

	private JFrame frame;

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
		frame.setBounds(100, 100, 642, 307);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel display = new JLabel("");
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setBounds(39, 52, 559, 47);
		frame.getContentPane().add(display);

		
		JButton btnPulsaOTeclea_1 = new JButton("Pulsa o teclea 1");
		btnPulsaOTeclea_1.addActionListener(new SumaBtn(1,display));
		btnPulsaOTeclea_1.setBounds(39, 167, 146, 25);
		frame.getContentPane().add(btnPulsaOTeclea_1);
		
		btnPulsaOTeclea_1.addKeyListener(new EscuchandoTeclas(display));
		btnPulsaOTeclea_1.addMouseListener(new EscuchandoRatones(btnPulsaOTeclea_1));
		
		
		JButton btnPulsaOTeclea_2 = new JButton("Pulsa o teclea 2");
		btnPulsaOTeclea_2.addActionListener(new SumaBtn(2,display));
		btnPulsaOTeclea_2.setBounds(248, 167, 146, 25);
		frame.getContentPane().add(btnPulsaOTeclea_2);
		btnPulsaOTeclea_2.addKeyListener(new EscuchandoTeclas(display));
		btnPulsaOTeclea_2.addMouseListener(new EscuchandoRatones(btnPulsaOTeclea_2));
		
		JButton btnPulsaOTeclea_3 = new JButton("Pulsa o teclea 3");
		btnPulsaOTeclea_3.addActionListener(new SumaBtn(3,display));
		btnPulsaOTeclea_3.setBounds(452, 167, 146, 25);
		frame.getContentPane().add(btnPulsaOTeclea_3);
		btnPulsaOTeclea_3.addKeyListener(new EscuchandoTeclas(display));
		btnPulsaOTeclea_3.addMouseListener(new EscuchandoRatones(btnPulsaOTeclea_3));
		
		JButton btnLimpiar = new JButton("\n");
		btnLimpiar.setIcon(new ImageIcon(Principal.class.getResource("/icons/reload.png")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Loading ld=new Loading(frame.getX()+frame.getWidth()/2-130,frame.getY()+frame.getHeight()/2-130);
				ld.setVisible(true);
				ld.toFront();
				try {
		            Thread.sleep(3*1000);
		         } catch (Exception e) {
		            System.out.println(e);
		         }
				
				ld.dispose();
				display.setText("");
			}
		});
		btnLimpiar.setBounds(292, 231, 53, 39);
		frame.getContentPane().add(btnLimpiar);
		btnLimpiar.addKeyListener(new EscuchandoTeclas(display));
	}
}
