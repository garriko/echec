package interfaceGraphique;

import interfaceGraphique.InterfacePopupSuppression.Ecouteur;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
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
 * Fenêtre du menu principal du jeu
 *
 */

public class InterfaceMenu {
	
	JFrame fenetre=new JFrame("Popup");
	Container tmp = fenetre.getContentPane();
	Image bouton1 = new ImageIcon("images/boutonCommencer.png").getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT);
	JButton Bouton1 = new JButton(new ImageIcon(bouton1));
	Image bouton2 = new ImageIcon("images/boutonReprendre.png").getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT);
	JButton Bouton2 = new JButton(new ImageIcon(bouton2));
	Image bouton3 = new ImageIcon("images/boutonRevoir.png").getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT);
	JButton Bouton3 = new JButton(new ImageIcon(bouton3));
	Image bouton4 = new ImageIcon("images/boutonOptions.png").getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT);
	JButton Bouton4 = new JButton(new ImageIcon(bouton4));
	Image bouton5 = new ImageIcon("images/boutonQuitter.png").getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT);
	JButton Bouton5 = new JButton(new ImageIcon(bouton5));
	
	/**
	 * Constructeur de la classe
	 */
	public InterfaceMenu() {
		
		Bouton1.setBounds(260, 180, 500, 52); //position x, position y, largeur, hauteur
		Bouton2.setBounds(260, 290, 500, 52); 
		Bouton3.setBounds(260, 390, 500, 52);
		Bouton4.setBounds(260, 490, 500, 52);
		Bouton5.setBounds(260, 580, 500, 52);
		
		//Bouton1.setBorderPainted(false); // effacer le bord du bouton
		//Bouton1.setCursor(new Cursor(Cursor.HAND_CURSOR)); // changer le curseur lors du survol
		
		Ecouteur listen=new Ecouteur();
		Bouton1.addActionListener(listen);
		Bouton2.addActionListener(listen);
		Bouton3.addActionListener(listen);
		Bouton4.addActionListener(listen);
		Bouton5.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/Menu.png").getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT));
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(Bouton1);   
		boutonsChoix.add(Bouton2);
		boutonsChoix.add(Bouton3);   
		boutonsChoix.add(Bouton4);
		boutonsChoix.add(Bouton5);   
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(1000,720); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
		}
	}
	
	public static void main(String[] args){
		new InterfaceMenu();
	}

}
