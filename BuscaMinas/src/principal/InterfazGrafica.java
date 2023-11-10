package principal;
import buscaMinas.BuscaMinas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import java.awt.Font;

public class InterfazGrafica  {
	private static final int TAM=23;
	private final int dif=9; 
	private JFrame frame;
	private static Button[] conjunto=new Button[TAM*TAM];
	private BuscaMinas bm=new BuscaMinas(TAM,dif);
	public JLabel mensaje_Ganador = new JLabel("");
	
	public void destapar(int x, int y) {
		bm.destapar(x, y);
		
	}
	public void bandera(int x, int y,boolean es) {
		if(es) {conjunto[x+(y*TAM)].setForeground(Color.RED);
		}else {conjunto[x+(y*TAM)].setForeground(Color.BLACK);}
		bm.setBandera(x,y,es);
	}
	public void mostrar() {
		int x=0;
		int y=0;
		for(Button c: conjunto) {
			c.setLabel(bm.getCas(x, y));
			x++;
			if(x>22) {
				x=0;
				y++;
			}
		}
		if(bm.esFin()) {
			mensaje_Ganador.setText(bm.ganador());
			for(Button c: conjunto) {
				c.setEnabled(false);
			}
		}
		
	}
	public void reset() {
		bm.reset();
		for(Button c: conjunto) {
			c.setEnabled(true);
			
		}
		mostrar();
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				try {
					InterfazGrafica window = new InterfazGrafica();
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
	public InterfazGrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 698, 738);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.requestFocus();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(44, 84, 597, 597);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
	
		
		int contX=10;
		int contY=10;
		int i=0;
		for(int y=0;y<TAM;y++) {
			for(int x=0;x<TAM;x++) {
				int xx=x;
				int yy=y;
				Button button = new Button("");
				button.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						if(e.getButton()==1) {
							destapar(xx,yy);

							bandera(xx, yy, false);
							mostrar();
						}
						if(e.getButton()==3) {
							bandera(xx, yy, true);
							mostrar();
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				button.setBounds(contX, contY, 25, 25);
				panel.add(button);
				contX+=25;
				conjunto[i]=button;i++;
			}
			contX=10;
			contY+=25;
		}
		
		
		JLabel lblNewLabel = new JLabel("Busca Minas");
		lblNewLabel.setBounds(44, 11, 87, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNewButton.setBounds(423, 11, 217, 23);
		frame.getContentPane().add(btnNewButton);
		mensaje_Ganador.setFont(new Font("Arial", Font.BOLD, 16));

			
		
		mensaje_Ganador.setBounds(45, 50, 495, 23);
		frame.getContentPane().add(mensaje_Ganador);
		
		
	}
	
}
