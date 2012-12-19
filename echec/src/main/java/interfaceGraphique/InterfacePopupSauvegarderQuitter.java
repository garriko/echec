package interfaceGraphique;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projet_echec.echec.gestion.GestionJeu;
import projet_echec.echec.gestion.Partie;
import projet_echec.echec.gestion.SaveGame;
import projet_echec.echec.jeu.Echiquier;
import projet_echec.echec.jeu.EchiquierActif;

/**
 * 
 * @author Anne-Sophie
 * 
 * Fenêtre de la popup de demande de sauvegarde lorsque l'utilisateur 
 * quitte une partie en cours
 *
 */

public class InterfacePopupSauvegarderQuitter {
	
	JFrame fenetre;
	Container tmp;
	JButton boutonOUI;
	JButton boutonNON;
	JTextField nomSauvegarde;
	String choix;
	Partie p;
	EchiquierActif plateau;
	
	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupSauvegarderQuitter(String menuOuQuitter, Partie partie, Echiquier echiquier) {
		fenetre=new JFrame("Popup");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		p = partie;
		plateau = (EchiquierActif) echiquier;
		
		tmp = fenetre.getContentPane();
		boutonOUI = new JButton(new ImageIcon("images/oui.png"));
		boutonNON = new JButton(new ImageIcon("images/non.png"));
		nomSauvegarde = new JTextField("sauvegarde");
		
		boutonOUI.setBounds(105, 257, 105, 52); //position x, position y, largeur, hauteur
		boutonNON.setBounds(275, 257, 105, 52); 
		nomSauvegarde.setBounds(22, 145, 375, 40);
		
		choix = menuOuQuitter;
		
		Ecouteur listen=new Ecouteur();
		boutonOUI.addActionListener(listen);
		boutonNON.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/sauvegarderQuitter.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(boutonOUI);   
		boutonsChoix.add(boutonNON);
		boutonsChoix.add(nomSauvegarde);
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(503,377); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==boutonOUI){
				try {
					SaveGame.sauvegarder(nomSauvegarde.getText(), p, plateau);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
			if (choix=="Menu"){
				fenetre.setVisible(false);
				new InterfaceMenu(new GestionJeu());
			}
			else if (choix=="Quitter"){
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args){
		//new InterfacePopupSauvegarderQuitter("Menu");
	}
}
