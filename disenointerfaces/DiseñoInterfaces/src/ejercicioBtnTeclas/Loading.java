package ejercicioBtnTeclas;

import java.awt.BorderLayout; 	
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Loading extends JDialog {

	private final JPanel contentPanel = new JPanel();


	public Loading(int x, int y) {
		setBounds(x, y, 275, 276);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(Loading.class.getResource("/gifs/tenor.gif")));
			label.setBounds(0, -33, 440, 291);
			contentPanel.add(label);label.setFocusable(true);
		}
	}

}
