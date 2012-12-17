package interfaceGraphique;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * @author Anne-Sophie
 * 
 * Classe gérant les images en fond de fenêtre
 *
 */

class TestImagePanel extends JPanel {
	 
	private static final long serialVersionUID = 1L;
	private Image img;
 
	
	public TestImagePanel(String img) {
	
		this(new ImageIcon(img).getImage());
	}
   
	
	/**
	 * Constructeur de la classe
	 */
	public TestImagePanel(Image img) {
		this.img = img;
	}
 
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
}
