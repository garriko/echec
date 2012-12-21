package interfaceGraphique;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Vincent
 *
 * Fenêtre de l'interface graphique Aide.
 *
 */

public class InterfacePopupAide {
	
	JFrame fenetre;
	Container tmp;
	JButton boutonOK;
	

	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupAide() {
		
		fenetre=new JFrame(" A propos de");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tmp = fenetre.getContentPane();
		boutonOK = new JButton(new ImageIcon("images/PopupAide/AideBoutonOk.png"));
		boutonOK.setBounds(192, 410, 118, 59); //position x, position y, largeur, hauteur
		
		Ecouteur listen=new Ecouteur();
		boutonOK.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/PopupAide/PopupAide.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(boutonOK);   
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(500,520); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==boutonOK){
				fenetre.setVisible(false);
			}
		}
	}
	
	public static void main(String[] args){
	
	}
}
