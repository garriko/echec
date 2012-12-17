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
 * @author Anne-Sophie
 * 
 * Fenêtre de l'interface graphique de la popup de confirmation de suppression 
 * d'une partie ou de la liste d'une partie
 *
 */

public class InterfacePopupSuppression {
	
	JFrame fenetre=new JFrame("Popup");
	Container tmp = fenetre.getContentPane();
	JButton Bouton1 = new JButton(new ImageIcon("images/oui.png"));
	JButton Bouton2 = new JButton(new ImageIcon("images/non.png"));
	
	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupSuppression() {
		
		Bouton1.setBounds(105, 175, 105, 52); //position x, position y, largeur, hauteur
		Bouton2.setBounds(275, 175, 105, 52); 
		
		Ecouteur listen=new Ecouteur();
		Bouton1.addActionListener(listen);
		Bouton2.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/suppression.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(Bouton1);   
		boutonsChoix.add(Bouton2);
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(507,286); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
		}
	}
	
	public static void main(String[] args){
		new InterfacePopupSuppression();
	}
}