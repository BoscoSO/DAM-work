package textEditor.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.StyledEditorKit;

public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextPane logPane;
	
	
	private String abrirArchivo() {
		  String aux="";   
		  String texto;

		  texto="";
		  try
		  {
		   
		   JFileChooser file=new JFileChooser();
		   file.showOpenDialog(this);
		   
		   File abre=file.getSelectedFile();

		   if(abre!=null)
		   {     
		      FileReader archivos=new FileReader(abre);
		      BufferedReader lee=new BufferedReader(archivos);
		      while((aux=lee.readLine())!=null)
		      {
		         texto+= aux+ "\n";
		      }
		         lee.close();
		         logPane.setText(logPane.getText()+"Fichero abierto: "+ abre.getName()+"\n");
		    }    
		   }
		   catch(IOException ex)
		   {
		     JOptionPane.showMessageDialog(null,ex+"" +
		           "\nNo se ha encontrado el archivo",
		                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
		    }
		  return texto;
		}

	private void guardarArchivo(String t) {
		 try
		 {
		  String nombre="";
		  JFileChooser file=new JFileChooser();
		  file.showSaveDialog(this);
		  File guarda =file.getSelectedFile();

		  if(guarda !=null)
		  {
		    FileWriter  save=new FileWriter(guarda);
		    save.write(t);
		    save.close();
		    JOptionPane.showMessageDialog(null,
		         "El archivo se a guardado Exitosamente",
		             "Información",JOptionPane.INFORMATION_MESSAGE);

	         logPane.setText(logPane.getText()+"Fichero guardado: "+ guarda.getName()+"\n");
		    }
		 }
		  catch(IOException ex)
		  {
		   JOptionPane.showMessageDialog(null,
		        "Su archivo no se ha guardado",
		           "Advertencia",JOptionPane.WARNING_MESSAGE);
		  }
	 }
		
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
		setBounds(100, 100, 705, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JTextPane editorPane = new JTextPane();
		splitPane.setLeftComponent(editorPane);

		
		logPane = new JTextPane();
		logPane.setText("");
		logPane.setEditable(false);
		logPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		logPane.setBounds(31, 21, 531, 271);
		splitPane.setRightComponent(logPane);
		
		//MENU
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
			JMenu menuFile = new JMenu("File");
			menuFile.setMnemonic(KeyEvent.VK_F);
			menuBar.add(menuFile);
			
				JMenuItem item1= new JMenuItem("Open File");
				item1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						editorPane.setText(abrirArchivo());
					}
				});
				item1.setToolTipText("Selecciona un ficheiro de texto");
				menuFile.add(item1);
				
				JMenuItem item2= new JMenuItem("Save");
				item2.setAccelerator(KeyStroke.getKeyStroke("control S"));
				item2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						guardarArchivo(editorPane.getText());					}
				});
				item2.setToolTipText("Selecciona un ficheiro de texto");
				menuFile.add(item2);
		

			JMenu menuEdit = new JMenu("Edit");
			menuEdit.setMnemonic(KeyEvent.VK_E);
			menuBar.add(menuEdit);

			JMenuItem item11 = new JMenuItem("Cursiva");
				
				item11.setAccelerator(KeyStroke.getKeyStroke("control C"));
				item11.addActionListener(new StyledEditorKit.ItalicAction());
				menuEdit.add(item11);

				JMenuItem item12 = new JMenuItem("Negrita");
				item12.setAccelerator(KeyStroke.getKeyStroke("control N"));
				item12.addActionListener(new StyledEditorKit.BoldAction());
				menuEdit.add(item12);

				JMenuItem item13 = new JMenuItem("Subliñado");
				item13.setAccelerator(KeyStroke.getKeyStroke("control K"));
				item13.addActionListener(new StyledEditorKit.UnderlineAction());
				menuEdit.add(item13);

				JSeparator separador= new JSeparator();
				menuEdit.add(separador);
				
				JMenuItem item14 = new JMenuItem("Color");
				item14.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Color color=JColorChooser.showDialog(contentPane, "Elige un color", Color.BLACK);
						
						editorPane.setForeground(color);
					}
				});
				menuEdit.add(item14);
				
				
		
		
	}

}
