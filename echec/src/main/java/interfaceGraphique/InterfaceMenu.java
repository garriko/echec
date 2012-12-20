package interfaceGraphique;

import interfaceGraphique.InterfacePopupSuppression.Ecouteur;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import projet_echec.echec.gestion.GestionJeu;

/**
 * 
 * @author Anne-Sophie
 * 
 * Fenêtre du menu principal du jeu
 *
 */

public class InterfaceMenu {
	JFrame fenetre;
	Container tmp;
	Image bouton1;
	JButton Bouton1;
	Image bouton2;
	JButton Bouton2;
	Image bouton3;
	JButton Bouton3;
	Image bouton4;
	JButton Bouton4;
	Image bouton5;
	JButton Bouton5;
	
	/**
	 * Constructeur de la classe
	 */
	public InterfaceMenu() {
		
		fenetre= new JFrame();
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tmp = fenetre.getContentPane();
		
		Bouton1 = new JButton(new ImageIcon("images/MenuPrincipal/MenuBoutonCommencerPartiesansF.png"));		
		Bouton2 = new JButton(new ImageIcon("images/MenuPrincipal/MenuBoutonReprendrePartie.png"));	
		Bouton3 = new JButton(new ImageIcon("images/MenuPrincipal/MenuBoutonRevoirPartie.png"));	
		Bouton4 = new JButton(new ImageIcon("images/MenuPrincipal/MenuBoutonOption.png"));		
		Bouton5 = new JButton(new ImageIcon("images/MenuPrincipal/MenuBoutonQuitter.png"));
		
		Bouton1.setBounds(240, 180, 581, 61); //position x, position y, largeur, hauteur
		Bouton2.setBounds(250, 270, 566, 61);
		Bouton3.setBounds(300, 360, 456, 61);
		Bouton4.setBounds(400, 447, 260, 61);
		Bouton5.setBounds(415, 535, 236, 61);

		Bouton1.setBorderPainted(false);
		Bouton2.setBorderPainted(false);
		Bouton3.setBorderPainted(false);
		Bouton4.setBorderPainted(false);
		Bouton5.setBorderPainted(false);
		
		//Bouton1.setBorderPainted(false); // effacer le bord du bouton
		//Bouton1.setCursor(new Cursor(Cursor.HAND_CURSOR)); // changer le curseur lors du survol
		
		EcouteurAction listen=new EcouteurAction();
		Bouton1.addActionListener(listen);
		Bouton2.addActionListener(listen);
		Bouton3.addActionListener(listen);
		Bouton4.addActionListener(listen);
		Bouton5.addActionListener(listen);
		
		EcouteurMouse souris = new EcouteurMouse();
		Bouton1.addMouseListener(souris);
		Bouton2.addMouseListener(souris);
		Bouton3.addMouseListener(souris);
		Bouton4.addMouseListener(souris);
		Bouton5.addMouseListener(souris);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/MenuPrincipal/MenuPrincipal.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(Bouton1);   
		boutonsChoix.add(Bouton2);
		boutonsChoix.add(Bouton3);   
		boutonsChoix.add(Bouton4);
		boutonsChoix.add(Bouton5);   
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
		fenetre.setContentPane(tmp);
		fenetre.setSize(1035,700); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class EcouteurAction implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==Bouton1){ // Commencer partie
				fenetre.setVisible(false);
				new InterfaceConfigPartie();
				
			}
			if (e.getSource()==Bouton2){ // Continuer partie
				fenetre.setVisible(false);
				new InterfaceCatalogue("reprendre");	
			}
			if (e.getSource()==Bouton3){ // Revoir partie
				fenetre.setVisible(false);
				new InterfaceCatalogue("revoir");
			}
			if (e.getSource()==Bouton4){ // Options partie
				new InterfaceOptionsMenu();
			}
			if (e.getSource()==Bouton5){ // Quitter partie
				System.exit(0);
			}
		}
	}
	
	public class EcouteurMouse implements MouseListener{
		public void mouseEntered(MouseEvent e) {
			if (e.getSource()==Bouton1){
				Bouton1.setIcon(new ImageIcon("images/MenuPrincipal/MenuBoutonCommencerPartie.png"));
			}
			if (e.getSource()==Bouton2) { 
				Bouton2.setIcon(new ImageIcon("images/MenuPrincipal/MenuBoutonReprendrePartieFocus.png"));
			}
			if (e.getSource()==Bouton3) { 
				Bouton3.setIcon(new ImageIcon("images/MenuPrincipal/MenuBoutonRevoirPartieFocus.png"));
			}
			if (e.getSource()==Bouton4) {
				Bouton4.setIcon(new ImageIcon("images/MenuPrincipal/MenuBoutonOptionFocus.png"));
			}
			if (e.getSource()==Bouton5) { 
				Bouton5.setIcon(new ImageIcon("images/MenuPrincipal/MenuBoutonQuitterFocus.png"));
			}
		}
 
		public void mouseExited(MouseEvent e) {
			if (e.getSource()==Bouton1){
				Bouton1.setIcon(new ImageIcon("images/MenuPrincipal/MenuBoutonCommencerPartiesansF.png"));
			}
			if (e.getSource()==Bouton2) { 
				Bouton2.setIcon(new ImageIcon("images/MenuPrincipal/MenuBoutonReprendrePartie.png"));
			}
			if (e.getSource()==Bouton3) { 
				Bouton3.setIcon(new ImageIcon("images/MenuPrincipal/MenuBoutonRevoirPartie.png"));
			}
			if (e.getSource()==Bouton4) {
				Bouton4.setIcon(new ImageIcon("images/MenuPrincipal/MenuBoutonOption.png"));
			}
			if (e.getSource()==Bouton5) { 
				Bouton5.setIcon(new ImageIcon("images/MenuPrincipal/MenuBoutonQuitter.png"));
			}
		}

		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
	}

}
