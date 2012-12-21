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
 * Fenêtre de l'interface graphique de la popup lorsque le temps d'un joueur est écoulé
 *
 */

public class InterfacePopupTempsEcoule {
	
	JFrame fenetre;
	Container tmp;
	JButton BoutonNouvelleP;
	JButton BoutonQuitter;
	
	InterfaceJeu mere;

	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupTempsEcoule(int joueur, InterfaceJeu maman) {
		
		fenetre=new JFrame("Temps Ecoulé");;
		tmp = fenetre.getContentPane();
		
		mere = maman;
		
		BoutonNouvelleP = new JButton(new ImageIcon("images/PopupTempsEcoule/BoutonNouvPartie.png"));
		BoutonQuitter = new JButton(new ImageIcon("images/PopupTempsEcoule/BoutonQuitter.png"));
		
		BoutonNouvelleP.setBounds(95, 195, 147, 71); //position x, position y, largeur, hauteur
		BoutonQuitter.setBounds(255, 195, 147, 71);
		
		Ecouteur listen=new Ecouteur();
		BoutonNouvelleP.addActionListener(listen);
		BoutonQuitter.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/PopupTempsEcoule/popup_Temps-écoulé.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(BoutonNouvelleP); 
		boutonsChoix.add(BoutonQuitter); 
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(500,325); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==BoutonNouvelleP){
				fenetre.setVisible(false);
				mere.getFrame().setVisible(false);
				new InterfaceConfigPartie();
			}
			if (e.getSource()==BoutonQuitter){
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args){
		//new InterfacePopupTempsEcoule();
	}
}
