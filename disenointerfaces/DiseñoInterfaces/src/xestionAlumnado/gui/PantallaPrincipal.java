package xestionAlumnado.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import xestionAlumnado.dto.Alumnado;
import xestionAlumnado.gui.tableModel.AlumnadoTableModel;
import xestionAlumnado.logica.LogicaAlumnos;

public class PantallaPrincipal {

	private JFrame frame;

	private JTable tabla;
	private JTextField textNome;
	private JTextField textCurso;
	private JButton btnModificar;
	private LogicaAlumnos logicaAlumnos = new LogicaAlumnos();

	private int modificable;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actualizarTaboa() {
		tabla.setModel(new AlumnadoTableModel(logicaAlumnos.getListAlumnado()));
	}

	public PantallaPrincipal() {
		initialize();
		
	}



	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 578, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 563, 228);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(12, 12, 526, 204);
		panel.add(scrollPane);
		
		tabla = new JTable();
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setModel(new AlumnadoTableModel(logicaAlumnos.getListAlumnado()));
		tabla.setBounds(12, 23, 526, 193);
		tabla.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			@Override
			public void keyPressed(KeyEvent arg0) {				
				if(tabla.getRowCount()>=1) {
					
					switch(arg0.getKeyCode()) {
					
						case KeyEvent.VK_DOWN: {
							int i=tabla.getSelectedRow()+1;
							if(i<tabla.getRowCount())
								setDatos(i);

							frame.setBounds(frame.getX(),frame.getY(), 587, 608);
						}break;
						
						case KeyEvent.VK_UP: {
							int i=tabla.getSelectedRow()-1;
							if(i<0)
								i=0;
							setDatos(i);

							frame.setBounds(frame.getX(),frame.getY(), 587, 608);
						}break;					
						case KeyEvent.VK_SPACE:{
							btnModificar.doClick();
							textNome.requestFocus();
							
						}break;
						case KeyEvent.VK_ESCAPE:{
							System.exit(0);
							
						}break;
					}
				}
				
			}
		});
		tabla.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int i=tabla.getSelectedRow();
				if(i>=0)
					setDatos(i);

				frame.setBounds(frame.getX(),frame.getY(), 587, 608);
				tabla.setRowSelectionInterval(i,i);
				
			}
		});
		scrollPane.setViewportView(tabla);
	
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(92, 280, 373, 193);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDatosAlumno = new JLabel("Datos Alumno");
		lblDatosAlumno.setBounds(12, 12, 110, 15);
		panel_1.add(lblDatosAlumno);
		
		JLabel lblNome = new JLabel("nome:");
		lblNome.setBounds(52, 40, 70, 15);
		panel_1.add(lblNome);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(52, 68, 70, 15);
		panel_1.add(lblCurso);
		
		textNome = new JTextField();
		textNome.setEditable(false);
		textNome.setBounds(140, 38, 174, 19);
		panel_1.add(textNome);
		textNome.setColumns(10);
		
		textCurso = new JTextField();
		textCurso.setEditable(false);
		textCurso.setColumns(10);
		textCurso.setBounds(140, 66, 174, 19);
		panel_1.add(textCurso);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textNome.getText().isEmpty())					
					switch(btnModificar.getText()) {
					
						case "Modificar":{
							textNome.setEditable(true);
							textCurso.setEditable(true);
							
							
							btnModificar.setText("Aplicar");
						}break;
						case "Aplicar":{
							LogicaAlumnos.modAlumno(textNome.getText(),textCurso.getText(),modificable);
														
							textNome.setEditable(false);textNome.setText("");
							textCurso.setEditable(false);textCurso.setText("");
							
							
							
							btnModificar.setText("Modificar");
							
							actualizarTaboa();

							frame.setBounds(frame.getX(),frame.getY(), 587, 315);
						}break;
					}
			}
		});
		btnModificar.setBounds(230, 97, 131, 25);
		panel_1.add(btnModificar);
		

		

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnJmenuclientes = new JMenu("Alumnos");
		menuBar.add(mnJmenuclientes);
		
		JMenuItem menuItemAlta = new JMenuItem("Alta");
		mnJmenuclientes.add(menuItemAlta);
		menuItemAlta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				alta();
			}
		});
	}
	private void alta() {
		dialogoAlta dlA =new dialogoAlta(this,this.frame,false);
		dlA.setVisible(true);

		
	}
	private void setDatos(int i) {
		Alumnado aux=LogicaAlumnos.getListAlumnado().get(i); 
		modificable=i;
		textNome.setText(aux.getNome());
		textCurso.setText(aux.getCurso());
		
	}
}
