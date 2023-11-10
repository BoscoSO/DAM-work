/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compoñentespersonalizados;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelImaxe extends JPanel implements Serializable {
	private ImaxeFondo imaxeFondo;

        public JPanelImaxe() {
	
	}
	public JPanelImaxe(ImaxeFondo img2) {
		imaxeFondo=img2;
	}

	public ImaxeFondo getImg() {
		return imaxeFondo;
	}

	public void setImg(ImaxeFondo img) {
		this.imaxeFondo = img;
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Para evitar un NullPointerException antes de iniciar a propiedade
		if (imaxeFondo != null) {
			if (imaxeFondo.getRuta() != null && imaxeFondo.getRuta().exists()) {
				ImageIcon imageIcon = new ImageIcon(imaxeFondo.getRuta().getAbsolutePath());
				Graphics2D g2d = (Graphics2D) g;
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				imaxeFondo.getOpacidade()));
				g.drawImage(imageIcon.getImage(), 0, 0, null);
				// Unha vez cambiada a opacidade, hai que volver a poñela en 1
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
			}
		}
	}
}
