package splitpane.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ejercicioBtnTeclas.Principal;

import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JLabel imagen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Otoño","Invierno","Aurora","Arboles"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setImagen();
			}
		});
		
		
		JScrollPane scrollBar = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//scrollBar.setBounds(441, 12, 17, 306);
	
		splitPane.setLeftComponent(scrollBar);
		
		imagen = new JLabel("");
		splitPane.setRightComponent(imagen);
		splitPane.setOneTouchExpandable(true);
		
	}
	
	public void setImagen() {
		int i=list.getSelectedIndex();
		switch(i) {
		case 0:imagen.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Otoño.jpg")));
			break;
		case 1:imagen.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Invierno.jpg")));
			break;
		case 2:imagen.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/aurora.jpg")));
			break;
		case 3:imagen.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Arboles.jpg")));
			break;
		}
		
	}
}
