/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compoñentespersonalizados;

import botonPersonalizado.Cores;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ImaxeFondoPanel extends JPanel{
	
	
        
        
	private JTextField rutaImaxe;
	private JSlider jSliderOpacidade;
	
	
	public ImaxeFondoPanel() {
		init();
	}
	
	public ImaxeFondo getSelectedValue() {
		File f = new File(rutaImaxe.getText());
		// Engádese o f para converter o enteiro a float
		Float opacidade = jSliderOpacidade.getValue() / 100f;
		return new ImaxeFondo(f, opacidade);

	}
        
        private void jButtonRutaActionPerformed(java.awt.event.ActionEvent evt) {
            JFileChooser fileChooser = new JFileChooser();
            int resultado = fileChooser.showOpenDialog(this);
            // Se se selecciona un arquivo e se pulsa aceptar
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                rutaImaxe.setText(file.getAbsolutePath());
            }
        }

	public void init() {
		setLayout(null);
		
		JLabel lbl_ruta = new JLabel("Imaxe: ");
		lbl_ruta.setBounds(41, 92, 46, 14);
		add(lbl_ruta);
		
		JLabel lbl_opacidad = new JLabel("Opacidad");
		lbl_opacidad.setBounds(41, 177, 46, 14);
		add(lbl_opacidad);
		
		rutaImaxe = new JTextField();
		rutaImaxe.setBounds(114, 89, 144, 20);
		add(rutaImaxe);
		rutaImaxe.setColumns(10);
		
		JButton btn_buscarRuta = new JButton("...");
		btn_buscarRuta.setBounds(279, 88, 51, 23);
		btn_buscarRuta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jButtonRutaActionPerformed(e);
			}
		});
		add(btn_buscarRuta);	
		
		jSliderOpacidade = new JSlider();
		jSliderOpacidade.setBounds(117, 177, 200, 26);
		add(jSliderOpacidade);
	}
}
