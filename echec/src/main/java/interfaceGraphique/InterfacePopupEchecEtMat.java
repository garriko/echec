package interfaceGraphique;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Vincent
 *
 * Fenêtre de l'interface graphique de la popup lorsqu'il y a echec et mat
 *
 */

public class InterfacePopupEchecEtMat {
	
	JFrame fenetre;
	Container tmp;
	JButton BoutonNouvelleP;
	JButton BoutonQuitter;
	JLabel gagnant;
	
	InterfaceJeu mere;
	
	

	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupEchecEtMat(int winner, InterfaceJeu maman) {
		
		fenetre=new JFrame("Echec et Mat");;
		tmp = fenetre.getContentPane();
		
		mere = maman;
		
		BoutonNouvelleP = new JButton(new ImageIcon("images/PopupEchecEtMat/Popup_EchecEtMatBoutonNouvPartie.png"));
		BoutonQuitter = new JButton(new ImageIcon("images/PopupEchecEtMat/Popup_EchecEtMatBoutonQuitter.png"));
		
		BoutonNouvelleP.setBounds(95, 195, 147, 71); //position x, position y, largeur, hauteur
		BoutonQuitter.setBounds(255, 195, 147, 71);
		
		if(winner==1){
			gagnant = new JLabel("Winner : joueur 1 !");
		}
		else{
			gagnant = new JLabel("Winner : joueur 2 !");
		}
		gagnant.setBounds(200, 25, 200, 50);
		gagnant.setForeground(Color.red);
		
		
		Ecouteur listen=new Ecouteur();
		BoutonNouvelleP.addActionListener(listen);
		BoutonQuitter.addActionListener(listen);
	
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/PopupEchecEtMat/Popup_EchecEtMat.png").getImage());
		imageFond.setLayout(null);	 
		imageFond.add(BoutonNouvelleP); 
		imageFond.add(BoutonQuitter);
		imageFond.add(gagnant);
		imageFond.setOpaque(false);
		tmp.add(imageFond);
    
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
		//new InterfacePopupEchecEtMat(2);
	}
}
