package interfaceGraphique;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Anne-Sophie
 * 
 * Fenêtre de la popup de confirmation de sauvegarde d'une partie
 *
 */

public class InterfacePopupSauvegarder {
	
	JFrame fenetre=new JFrame("Popup");
	Container tmp = fenetre.getContentPane();
	JButton Bouton1 = new JButton(new ImageIcon("images/okSauvegarde.png"));
	JButton Bouton2 = new JButton(new ImageIcon("images/annulerSauvegarde.png"));
	JTextField texte = new JTextField("sauvegarde");
	
	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupSauvegarder() {
		
		Bouton1.setBounds(105, 195, 103, 50); //position x, position y, largeur, hauteur
		Bouton2.setBounds(275, 195, 150, 50); 
		texte.setBounds(22, 78, 375, 40);
		
		Ecouteur listen=new Ecouteur();
		Bouton1.addActionListener(listen);
		Bouton2.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/sauvegarde.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(Bouton1);   
		boutonsChoix.add(Bouton2);
		boutonsChoix.add(texte);
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(507,310); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
		}
	}
	
	public static void main(String[] args){
		new InterfacePopupSauvegarder();
	}
}
