package menu.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import ejercicioBtnTeclas.Principal;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class PantallaPrincipal {

	private JFrame frmClienteTableModel;
	private JTextPane log;

	//contadores
	private int contS=0;
	private int contG=0;
	private int contT=0;
	private int contB=0;
	private int contC=0;
	private int contH=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
					window.frmClienteTableModel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PantallaPrincipal() {
		initialize();
	}

	private void initialize() {
		
		frmClienteTableModel = new JFrame();
		frmClienteTableModel.setResizable(false);
		frmClienteTableModel.setTitle("Cliente Table Model");
		frmClienteTableModel.setBounds(100, 100, 603, 377);
		frmClienteTableModel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClienteTableModel.getContentPane().setLayout(null);
		
		JPanel logPane = new JPanel();
		logPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		logPane.setBounds(31, 21, 531, 271);
		frmClienteTableModel.getContentPane().add(logPane);
		logPane.setLayout(new BorderLayout(0, 0));
		
		
		log = new JTextPane();
		log.setText("Registro\n");
		log.setEditable(false);
		
		JScrollPane scrollBar = new JScrollPane(log,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBar.setBounds(441, 12, 17, 306);
		logPane.add(scrollBar, BorderLayout.CENTER);
		
		
		//BARRA DE MENU
		JMenuBar menuBar = new JMenuBar();
		frmClienteTableModel.setJMenuBar(menuBar);
		
			JMenu menuCasa = new JMenu("Casa");
			menuCasa.setMnemonic(KeyEvent.VK_C);
			menuCasa.setIcon(new ImageIcon(Principal.class.getResource("/iconosMenu/home.png")));
			menuBar.add(menuCasa);
			
				JMenu menuItemHabitacions = new JMenu("Habitacións");
				menuCasa.add(menuItemHabitacions);
					
					JMenuItem itemHab1= new JMenuItem("Habitación 1");
					itemHab1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							contH++;
							if(contH==1) {
								log.setText(log.getText()+"Entraches na habitacion1 "+contH+" vez. \n");
							}else log.setText(log.getText()+"Entraches na habitacion1 "+contH+" veces. \n");
						}
					});
					itemHab1.setToolTipText("Selecciona a  habitación 1");
					menuItemHabitacions.add(itemHab1);
					JMenuItem itemHab2= new JMenuItem("Habitación 2");
					itemHab2.setEnabled(false);
					menuItemHabitacions.add(itemHab2);
			
				JCheckBoxMenuItem itemSalon = new JCheckBoxMenuItem("Salón");
				itemSalon.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						String estado="Estado ";
						if (itemSalon.isSelected()) {
							estado+="activado.";
						}else estado+="desactivado.";
						contS++;
						if(contS==1) {
							log.setText(log.getText()+"Entraches no salón "+contS+" vez. "+estado+"\n");
						}else log.setText(log.getText()+"Entraches no salón "+contS+" veces. "+estado+"\n");
					}
				});
				itemSalon.setAccelerator(KeyStroke.getKeyStroke("control S"));
				menuCasa.add(itemSalon);
	
				JSeparator separador =new JSeparator();
				menuCasa.add(separador);
						
				JRadioButtonMenuItem itemRdoCocina = new JRadioButtonMenuItem("Cociña");
				itemRdoCocina.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						String estado="Estado ";
						if (itemRdoCocina.isSelected()) {
							estado+="activado.";
						}else estado+="desactivado.";
						contC++;
						if(contC==1) {
							log.setText(log.getText()+"Entraches na cociña "+contC+" vez. "+estado+"\n");
						}else log.setText(log.getText()+"Entraches na cociña "+contC+" veces. "+estado+"\n");
					}
				});
				itemRdoCocina.setAccelerator(KeyStroke.getKeyStroke("control O"));
				itemRdoCocina.setSelected(true);
				menuCasa.add(itemRdoCocina);
				JRadioButtonMenuItem itemRdoBaño = new JRadioButtonMenuItem("Baño");
				itemRdoBaño.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						String estado="Estado ";
						if (itemRdoBaño.isSelected()) {
							estado+="activado.";
						}else estado+="desactivado.";
						contB++;
						if(contB==1) {
							log.setText(log.getText()+"Entraches no baño "+contB+" vez. "+estado+"\n");
						}else log.setText(log.getText()+"Entraches no baño "+contB+" veces. "+estado+"\n");
					}
				});
				itemRdoBaño.setAccelerator(KeyStroke.getKeyStroke("control B"));
				menuCasa.add(itemRdoBaño);
				
				
			JMenu menuExtras = new JMenu("Extras");
			menuExtras.setMnemonic(KeyEvent.VK_E);
			menuBar.add(menuExtras);
			
				JMenuItem itemGaraxe= new JMenuItem("Garaxe");
				itemGaraxe.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						contG++;
						if(contG==1) {
							log.setText(log.getText()+"Entraches no garaxe "+contG+" vez.\n");
						}else log.setText(log.getText()+"Entraches no garaxe "+contG+" veces.\n");
					}
				});
				itemGaraxe.setAccelerator(KeyStroke.getKeyStroke("alt G"));
				menuExtras.add(itemGaraxe);
			
				JMenuItem itemTrateiro= new JMenuItem("Trateiro");
				itemTrateiro.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						contT++;
						if(contT==1) {
							log.setText(log.getText()+"Entraches no trasteiro "+contT+" vez.\n");
						}else log.setText(log.getText()+"Entraches no trasteiro "+contT+" veces.\n");
					}
				});
				itemTrateiro.setAccelerator(KeyStroke.getKeyStroke("alt T"));
				menuExtras.add(itemTrateiro);
		//FIN BARRA DE MENU
	}
}
