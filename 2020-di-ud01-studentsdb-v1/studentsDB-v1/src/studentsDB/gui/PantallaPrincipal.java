package studentsDB.gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import studentsDB.dto.Student;
import studentsDB.gui.editores.MyCellEditor;

import studentsDB.gui.tableModel.AlumnadoTableModel;
import studentsDB.gui.tableModel.StudentGenericTable;
import studentsDB.loxica.Loxica;

public class PantallaPrincipal {

	private JFrame frame;

	private JTable tabla;
	
        private JTextField textDni;
	private JTextField textNome;
	private JTextField textSurname;
        private JTextField textIdade;
        
        private JLabel msgError;
        
	private JButton btnModificar;
        private JButton btn_baja;
        private JButton btn_cancelar;
	private Loxica logicaAlumnos = new Loxica();

	private int modificable;
	private StudentGenericTable sgt;
        
	public Loxica getLoxica(){return this.logicaAlumnos;}
        
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
            try {
                logicaAlumnos.updateListAlumnado();
                tabla.setModel(new AlumnadoTableModel(logicaAlumnos.getListAlumnado()));
            } catch (Exception ex) {
                System.out.println(logicaAlumnos.getErro());
            }
	}

	public PantallaPrincipal() {
		initialize();
		
	}



	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 578, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 563, 228);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(12, 12, 526, 204);
		panel.add(scrollPane);
		
                
		List<String> colums=new ArrayList<String>();
		colums.add("Dni");colums.add("Nome");
		colums.add("Apelidos");colums.add("Idade");
                
                sgt=new StudentGenericTable(colums);
                
		tabla = new JTable();
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);/*
                tabla.setModel(sgt);
		tabla.getColumnModel().getColumn(2).setCellEditor(new MyCellEditor());
                */
            try {
                logicaAlumnos.updateListAlumnado();
                tabla.setModel(new AlumnadoTableModel(logicaAlumnos.getListAlumnado()));
            } catch (Exception ex) {
                 System.out.println(logicaAlumnos.getErro());
            }
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
		panel_1.setBounds(92, 280, 373, 217);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDatosAlumno = new JLabel("Datos Alumno");
		lblDatosAlumno.setBounds(12, 12, 110, 15);
		panel_1.add(lblDatosAlumno);
                
                msgError = new JLabel();
		msgError.setBounds(170, 12, 200, 15);
                msgError.setForeground(Color.red);
		panel_1.add(msgError);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(52, 38, 70, 15);
		panel_1.add(lblDni);
		
		JLabel lblName = new JLabel("Nome:");
		lblName.setBounds(52, 66, 70, 15);
		panel_1.add(lblName);
                
                JLabel lblSurname = new JLabel("Apelidos:");
		lblSurname.setBounds(52, 94, 70, 15);
		panel_1.add(lblSurname);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(52, 122, 70, 15);
		panel_1.add(lblIdade);
		
                textDni = new JTextField();
		textDni.setEditable(false);
		textDni.setBounds(140, 38, 174, 19);
		panel_1.add(textDni);
		textDni.setColumns(10);
                
		textNome = new JTextField();
		textNome.setEditable(false);
		textNome.setBounds(140, 66, 174, 19);
		panel_1.add(textNome);
		textNome.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setEditable(false);
		textSurname.setColumns(10);
		textSurname.setBounds(140, 94, 174, 19);
		panel_1.add(textSurname);
                
                textIdade = new JTextField();
		textIdade.setEditable(false);
		textIdade.setBounds(140, 122, 174, 19);
		panel_1.add(textIdade);
		textIdade.setColumns(10);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textNome.getText().isEmpty())					
					switch(btnModificar.getText()) {
					
						case "Modificar":{
							textNome.setEditable(true);
							textDni.setEditable(true);
							textSurname.setEditable(true);
							textIdade.setEditable(true);
                                                        
                                                        btn_baja.setEnabled(false);
                                                        btn_cancelar.setVisible(true);
                                                        
                                                        btnModificar.setText("Aplicar");
						}break;
						case "Aplicar":{boolean aplicar=true;
                                                        String dni,nom,sur;int age=0;
                                                        dni=textDni.getText();
                                                        nom=textNome.getText();
                                                        sur=textSurname.getText();
                                                       
                                                        if(dni.isEmpty() ||nom.isEmpty() ||sur.isEmpty() ||textIdade.getText().isEmpty() ){
                                                            msgError.setText("No pueden quedar campos vacios");
                                                            aplicar=false;
                                                        }
           
                                                        try {
                                                            age=Integer.valueOf(textIdade.getText());
                                                        }catch (Exception ex) {
                                                            msgError.setText("Formato de numero incorrecto");
                                                            aplicar=false;
                                                        }
                                                        if(aplicar){msgError.setText("");
                                                            try {
                                                                logicaAlumnos.modAlumno(dni, nom, sur, age, modificable);
                                                            } catch (Exception ex) {
                                                                System.out.println(ex.getMessage());
                                                            }

                                                            textNome.setEditable(false);textNome.setText("");
                                                            textDni.setEditable(false);textDni.setText("");
                                                            textSurname.setEditable(false);textSurname.setText("");
                                                            textIdade.setEditable(false);textIdade.setText("");

                                                            btn_baja.setEnabled(true);
                                                            btn_cancelar.setVisible(false);
                                                            btnModificar.setText("Modificar");

                                                            actualizarTaboa();

                                                            frame.setBounds(frame.getX(),frame.getY(), 587, 315);
                                                        }
						}break;
					}
			}
		});
		btnModificar.setBounds(230, 160, 131, 25);
		panel_1.add(btnModificar);
		
                
		btn_cancelar = new JButton("Cancelar");
                btn_cancelar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textNome.setEditable(false);textNome.setText("");
                        textDni.setEditable(false);textDni.setText("");
                        textSurname.setEditable(false);textSurname.setText("");
                        textIdade.setEditable(false);textIdade.setText("");

                        btn_baja.setEnabled(true);
                        btn_cancelar.setVisible(false);
                        btnModificar.setText("Modificar");setDatos(modificable);
                        
                        msgError.setText("");

                    }
                });
		btn_cancelar.setBounds(230, 190, 131, 25);
                btn_cancelar.setVisible(false);
		panel_1.add(btn_cancelar);
                
                btn_baja=new JButton("Dar de baja");
		btn_baja.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        try {
                            logicaAlumnos.deleteStudent(textDni.getText());
                            frame.setBounds(frame.getX(),frame.getY(), 587, 315);
                            btn_cancelar.doClick();
                            actualizarTaboa();
                        } catch (Exception ex) {
                            System.out.println("Erros :"+logicaAlumnos.getErro());
                        }
                    }
                });
		btn_baja.setBounds(60, 160, 131, 25);
		panel_1.add(btn_baja);
		

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
            List<Student> lista=logicaAlumnos.getListAlumnado();
            
            Student st=lista.get(i);
            
            textDni.setText(st.getDni());
            textNome.setText(st.getNome());
            textSurname.setText(st.getApelidos());
            textIdade.setText(String.valueOf(st.getIdade()));
            
            modificable=i;
		
	}
}
