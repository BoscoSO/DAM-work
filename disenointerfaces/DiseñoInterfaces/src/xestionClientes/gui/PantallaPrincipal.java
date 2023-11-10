package xestionClientes.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SpinnerDateModel;
import javax.swing.table.TableRowSorter;

import xestionClientes.dto.Cliente;
import xestionClientes.gui.editorYRender.MiCellEditor;
import xestionClientes.gui.editorYRender.MyRenderer;
import xestionClientes.gui.tableModel.ClientGenericTable;

public class PantallaPrincipal {

	private JFrame frmClienteTableModel;

	private JTable tabla;
	
		//elementos panel modificar
	private JPanel panel_Modificar;
	private JTextField textNome;
	private JTextField textApelido;
	private JTextField textProvincia;
	private JTextField textData;
		//fin de los elementos panel modificar

		//elementos panel filtrar	
	private JPanel panel_Filtrar;
	private JTextField textNome2;
	private JTextField textApelido2;
	private JComboBox provincias2;
	private JSpinner modData2;
	
	private JButton btnFiltrar;
		//fin de los elementos panel filtrar	

	private JMenuItem menuItemFiltrar;
	private JButton btnAplicarFiltros;
	
	
	JButton btnModificar;
	private int modificable;
	
	private ClientGenericTable cgt;
	
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
		newClient(new Cliente("Pepe", "suarez",new Date(114,2, 13),"Lugo"));
		newClient(new Cliente("Juan", "perez",new Date(116,7, 11),"Pontevedra"));
		newClient(new Cliente("Luis", "martinez",new Date(112,4, 3),"Orense"));
		//LogicaNegocio.a√±adirCliente(new Cliente("Pepe", "suarez",new Date(114,2, 13),"Lugo"));
	}

	private void initialize() {
		
		frmClienteTableModel = new JFrame();
		frmClienteTableModel.setTitle("Cliente Table Model");
		frmClienteTableModel.setBounds(100, 100, 754, 312);
		frmClienteTableModel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClienteTableModel.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 730, 228);
		frmClienteTableModel.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(12, 12, 706, 204);
		panel.add(scrollPane);
		 	
		List<String> colums=new ArrayList<String>();
		colums.add("Nome");colums.add("Apelidos");
		colums.add("Data de alta");colums.add("Provincia");
		
		tabla = new JTable();
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		cgt=new ClientGenericTable(colums);
		
		tabla.setModel(cgt);
		tabla.getColumnModel().getColumn(2).setCellRenderer(new MyRenderer());
		tabla.getColumnModel().getColumn(2).setCellEditor(new MiCellEditor());
		
		
		//Ordenacion
		
		TableRowSorter<ClientGenericTable> sorter= new TableRowSorter<ClientGenericTable>(cgt);
		tabla.setRowSorter(sorter);
			//comienza ordenado
		List<RowSorter.SortKey> sortKeys=new ArrayList<RowSorter.SortKey>();
		int col=0;
				
		sortKeys.add(new RowSorter.SortKey(col,SortOrder.ASCENDING));
		
		sorter.setSortKeys(sortKeys);
		
		//fin ordenacion
		
		tabla.setBounds(12, 23, 526, 193);
		
		tabla.addMouseListener(new MouseListener() {
			
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
				setDatos(-1);
			}
		});

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
//							int i=tabla.getSelectedRow()+1;
//							if(i<tabla.getRowCount())
								setDatos(0);
//
////							frmClienteTableModel.setBounds(frmClienteTableModel.getX(),frmClienteTableModel.getY(),  754, 550);
						}break;
						
						case KeyEvent.VK_UP: {/*
							int i=tabla.getSelectedRow()-1;
							if(i<0)
								i=0;*/
							setDatos(1);//1 for up

							//frmClienteTableModel.setBounds(frmClienteTableModel.getX(),frmClienteTableModel.getY(),  754, 550);
						}break;					
						case KeyEvent.VK_SPACE:{
							btnModificar.doClick();
							textNome.requestFocus();
							
						}break;
						case KeyEvent.VK_ESCAPE:{
							System.exit(0);
							
						}break;
						case KeyEvent.VK_ENTER:{
							int col=tabla.getSelectedColumn();
							int row=tabla.getSelectedRow();			
							Object a=tabla.getValueAt(row, col);
							tabla.setValueAt(a, row, col);
						}break;
					}
				}

			}
		});
		scrollPane.setViewportView(tabla);
										 		//		IGNORAR
		

		//PANEL MODIFICAR
		panel_Modificar = new JPanel();
		panel_Modificar.setBounds(69, 274, 373, 179);
		frmClienteTableModel.getContentPane().add(panel_Modificar);
		panel_Modificar.setLayout(null);
		
		JLabel lblDatosCliente = new JLabel("Datos Cliente");
		lblDatosCliente.setBounds(12, 12, 110, 15);
		panel_Modificar.add(lblDatosCliente);
		
		JLabel lblNome = new JLabel("nome:");
		lblNome.setBounds(52, 40, 70, 15);
		panel_Modificar.add(lblNome);
		
		JLabel lblApelido = new JLabel("apelido:");
		lblApelido.setBounds(52, 68, 70, 15);
		panel_Modificar.add(lblApelido);
		
		JLabel lblProvincia = new JLabel("provincia:");
		lblProvincia.setBounds(52, 95, 70, 15);
		panel_Modificar.add(lblProvincia);
		
		JLabel lblData = new JLabel("data:");
		lblData.setBounds(52, 122, 70, 15);
		panel_Modificar.add(lblData);
		
		textNome = new JTextField();
		textNome.setEditable(false);
		textNome.setBounds(140, 38, 174, 19);
		panel_Modificar.add(textNome);
		textNome.setColumns(10);
		
		textApelido = new JTextField();
		textApelido.setEditable(false);
		textApelido.setColumns(10);
		textApelido.setBounds(140, 66, 174, 19);
		panel_Modificar.add(textApelido);
		
		textProvincia = new JTextField();
		textProvincia.setEditable(false);
		textProvincia.setColumns(10);
		textProvincia.setBounds(140, 93, 174, 19);
		panel_Modificar.add(textProvincia);
		
		textData = new JTextField();
		textData.setEditable(false);
		textData.setColumns(10);
		textData.setBounds(140, 120, 174, 19);
		panel_Modificar.add(textData);
		

		SpinnerDateModel spinMod=new SpinnerDateModel();
		JSpinner modData = new JSpinner(spinMod);
		
		modData.setEditor(new JSpinner.DateEditor(modData,"dd-MM-yyyy"));
//		modData.setModel(new SpinnerDateModel(new Date(1602626400000L), null, null, Calendar.DAY_OF_YEAR));
		modData.setBounds(140, 120, 192, 20);
		//intentar inicializarla con la fecha de textData
		modData.setVisible(false);

		panel_Modificar.add(modData);
		
		JComboBox provincias = new JComboBox();
		provincias.setModel(new DefaultComboBoxModel(new String[] {"A CoruÒa ", "Lugo ", "Orense", "Pontevedra"}));
		provincias.setBounds(140, 90, 174, 24);
		provincias.setVisible(false);
		panel_Modificar.add(provincias);

		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				modificable=tabla.getSelectedRow();	
					switch(btnModificar.getText()) {
					
						case "Modificar":{
			
							textNome.setEditable(true);
							textApelido.setEditable(true);
							
							textData.setVisible(false);
							textProvincia.setVisible(false);
							
							modData.setVisible(true);
							provincias.setVisible(true);

							Date  d=(Date) tabla.getValueAt(modificable, 2);
				    	  
							modData.setValue(d);
							
							btnModificar.setText("Aplicar");
						}break;
						case "Aplicar":{

							if(!textNome.getText().isEmpty())	
								tabla.setValueAt(textNome.getText(), modificable, 0);

							if(!textApelido.getText().isEmpty())	
								tabla.setValueAt(textApelido.getText(), modificable, 1);

							tabla.setValueAt((Date) modData.getValue(), modificable, 2);
							tabla.setValueAt((String) provincias.getSelectedItem(), modificable, 3);
								
							textNome.setEditable(false);textNome.setText("");
							textApelido.setEditable(false);textApelido.setText("");
							
							textData.setVisible(true);textData.setText("");
							textProvincia.setVisible(true);textProvincia.setText("");
							
							modData.setVisible(false);
							provincias.setVisible(false);
							
							btnModificar.setText("Modificar");
							
							tabla.requestFocus();
							frmClienteTableModel.setBounds(frmClienteTableModel.getX(),frmClienteTableModel.getY(), 754, 315);
						}break;
					}
			}
		});
		btnModificar.setBounds(230, 151, 131, 25);
		panel_Modificar.add(btnModificar);

		//FIN PANEL MODIFICAR
		//**************************************************************************************************************//
		//PANEL MODIFICAR
		panel_Filtrar = new JPanel();
		panel_Filtrar.setBounds(176, 274, 389, 179);
		frmClienteTableModel.getContentPane().add(panel_Filtrar);
		panel_Filtrar.setLayout(null);
		panel_Filtrar.setVisible(false);
		
		JLabel lblDatosCliente2 = new JLabel("Filtros :");
		lblDatosCliente2.setBounds(12, 12, 110, 15);
		panel_Filtrar.add(lblDatosCliente2);
		
		JLabel lblNome2 = new JLabel("nome:");
		lblNome2.setBounds(52, 40, 70, 15);
		panel_Filtrar.add(lblNome2);
		
		JLabel lblApelido2 = new JLabel("apelido:");
		lblApelido2.setBounds(52, 68, 70, 15);
		panel_Filtrar.add(lblApelido2);
		
		JLabel lblProvincia2 = new JLabel("provincia:");
		lblProvincia2.setBounds(52, 95, 70, 15);
		panel_Filtrar.add(lblProvincia2);
		
		JLabel lblData2 = new JLabel("data:");
		lblData2.setBounds(52, 122, 70, 15);
		panel_Filtrar.add(lblData2);
		
		textNome2 = new JTextField();
		textNome2.setBounds(140, 38, 174, 19);
		panel_Filtrar.add(textNome2);
		textNome2.setColumns(10);
		
		textApelido2 = new JTextField();
		textApelido2.setColumns(10);
		textApelido2.setBounds(140, 66, 174, 19);
		panel_Filtrar.add(textApelido2);
		
		

		SpinnerDateModel spinMod2=new SpinnerDateModel();
		modData2 = new JSpinner(spinMod2);
		
		modData2.setEditor(new JSpinner.DateEditor(modData2,"dd-MM-yyyy"));
		modData2.setBounds(140, 120, 192, 20);

		panel_Filtrar.add(modData2);
		
		provincias2 = new JComboBox();
		provincias2.setModel(new DefaultComboBoxModel(new String[] {"A Coru\u00F1a ", "Lugo", "Orense", "Pontevedra"}));
		provincias2.setBounds(140, 90, 174, 24);
		panel_Filtrar.add(provincias2);
		
		JCheckBox chkNome = new JCheckBox("");
		chkNome.setBounds(347, 34, 30, 23);
		panel_Filtrar.add(chkNome);
		
		JCheckBox chkApe = new JCheckBox("");
		chkApe.setBounds(347, 60, 30, 23);
		panel_Filtrar.add(chkApe);
		
		JCheckBox chkPro = new JCheckBox("");
		chkPro.setBounds(347, 90, 30, 23);
		panel_Filtrar.add(chkPro);
		
		JCheckBox chkData = new JCheckBox("");
		chkData.setBounds(347, 117, 30, 23);
		panel_Filtrar.add(chkData);
		
	
	

		
	//FIN PANEL FILTRAR
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();
			}
		});
		btnFiltrar.setBounds(575, 274, 136, 35);
		frmClienteTableModel.getContentPane().add(btnFiltrar);
		
		btnAplicarFiltros = new JButton("Aplicar Filtros");
		btnAplicarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean[] cheked=new boolean[]{chkNome.isSelected(),chkApe.isSelected(),chkPro.isSelected(),chkData.isSelected()};
				aplicarFiltros(sorter,cheked);
			}
			
		});
		btnAplicarFiltros.setBounds(575, 361, 136, 23);
		frmClienteTableModel.getContentPane().add(btnAplicarFiltros);
		
		//BARRA DE MENU
		JMenuBar menuBar = new JMenuBar();
		frmClienteTableModel.setJMenuBar(menuBar);
		
		JMenu mnJmenuclientes = new JMenu("Clientes");
		menuBar.add(mnJmenuclientes);
		
		JMenuItem menuItemAlta = new JMenuItem("Alta");
		mnJmenuclientes.add(menuItemAlta);
		menuItemAlta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				alta();
			}
		});
		menuItemFiltrar = new JMenuItem("Filtrar");
		menuBar.add(menuItemFiltrar);
		menuItemFiltrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				filtrar();
			}
		});
		//FIN BARRA DE MENU
	}
	private void alta() {
		dialogoAlta dlA =new dialogoAlta(this,this.frmClienteTableModel,false);
		dlA.setVisible(true);
	}
	
	private void setDatos(int i) {//1 for up // 0 for down// -1 or default for click
		int size=tabla.getRowCount();
		modificable=tabla.getSelectedRow();
		if(i==1)
			modificable--;
		else if(i==0)
			modificable++;
		
		if(modificable>=0 && modificable<size) {
			frmClienteTableModel.setBounds(frmClienteTableModel.getX(),frmClienteTableModel.getY(),  754, 550);
			
			textNome.setText((String)tabla.getValueAt(modificable, 0));
			
			textApelido.setText((String) tabla.getValueAt(modificable, 1));
			DateFormat dForm= new SimpleDateFormat("dd/MM/yyyy");
	    	  Date  d=(Date) tabla.getValueAt(modificable, 2);
	    	  
	    	  String s = dForm.format(d);
			textData.setText((String)s);
			
			
			textProvincia.setText((String)tabla.getValueAt(modificable, 3));
		}
	}
	public void newClient(Cliente cl) {
		cgt.addRow(cl);
	}

	private void filtrar() {
		String opcion = btnFiltrar.getText();
		
		switch (opcion) {
		case "Filtrar":{
			btnFiltrar.setText("Modificar");
			menuItemFiltrar.setText("Modificar");
			frmClienteTableModel.setBounds(frmClienteTableModel.getX(),frmClienteTableModel.getY(),  754, 550);
			panel_Modificar.setVisible(false);
			panel_Filtrar.setVisible(true);
			btnAplicarFiltros.setVisible(true);
		}
			break;
		case "Modificar":{
			btnFiltrar.setText("Filtrar");
			menuItemFiltrar.setText("Filtrar");
			frmClienteTableModel.setBounds(frmClienteTableModel.getX(),frmClienteTableModel.getY(),  754, 550);
			panel_Modificar.setVisible(true);
			btnAplicarFiltros.setVisible(false);
			panel_Filtrar.setVisible(false);
		}
			break;

		default:
			break;
		}
		
		
	}
	private void aplicarFiltros(TableRowSorter<ClientGenericTable> sorter,boolean[] opcion) {
		List<RowFilter<ClientGenericTable,Object>> listOfFilters = new ArrayList<>();

		boolean aux=true;
		
		for(int i=0;i<opcion.length;i++) {
			switch (i) {
				case 0:{
					if(opcion[i]) {aux=false;
					listOfFilters.add(RowFilter.regexFilter(textNome2.getText(), 0));
						
					}
				}
					break;
				case 1:{
					if(opcion[i]) {aux=false;
					listOfFilters.add(RowFilter.regexFilter(textApelido2.getText(), 1));
					}	
				}
					break;
				case 2:{
					if(opcion[i]) {aux=false;
					listOfFilters.add(RowFilter.regexFilter(provincias2.getItemAt(provincias2.getSelectedIndex()).toString(), 3));
					
					}
				}
					break;
				case 3:{
					if(opcion[i]) {aux=false;
					listOfFilters.add(RowFilter.regexFilter(modData2.getValue().toString(), 2));
					
						
					}
				}
					break;
			}
		}
		
		
		if(aux) {
			sorter.setRowFilter(null);
		}else {
			RowFilter rf=RowFilter.andFilter(listOfFilters);
			sorter.setRowFilter(rf);
		}
	}
}
