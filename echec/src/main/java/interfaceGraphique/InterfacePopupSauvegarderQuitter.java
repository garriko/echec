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
	JButton boutonAnnuler;
	JTextField nomSauvegarde;
	String choix;
	Partie p;
	EchiquierActif plateau;
	
	InterfaceJeu mere;
	
	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupSauvegarderQuitter(String menuOuQuitter, Partie partie, Echiquier echiquier, InterfaceJeu maman) {
		fenetre=new JFrame("Popup");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		mere = maman;
		
		p = partie;
		plateau = (EchiquierActif) echiquier;
		
		tmp = fenetre.getContentPane();
		boutonOUI = new JButton(new ImageIcon("images/PopupRevenirMenuP/PopupRevenirMenuPrincipalBoutonOui.png"));
		boutonNON = new JButton(new ImageIcon("images/PopupRevenirMenuP/PopupRevenirMenuPrincipalBoutonNon.png"));
		boutonAnnuler = new JButton(new ImageIcon("images/PopupRevenirMenuP/PopupRevenirMenuPrincipalBoutonAnnuler.png"));
				
		boutonOUI.setBounds(53, 263, 100, 48); //position x, position y, largeur, hauteur
		boutonNON.setBounds(181, 263, 100, 48); 
		boutonAnnuler.setBounds(312, 263, 130, 48); 
		
		nomSauvegarde = new JTextField("sauvegarde");
		nomSauvegarde.setBounds(22, 145, 375, 40);

		
		choix = menuOuQuitter;
		
		Ecouteur listen=new Ecouteur();
		boutonOUI.addActionListener(listen);
		boutonNON.addActionListener(listen);
		boutonAnnuler.addActionListener(listen);
		boutonAnnuler.addActionListener(listen);
	
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/PopupRevenirMenuP/PopupRevenirMenuPrincipal.png").getImage());
		imageFond.setLayout(null);	 
		imageFond.add(boutonOUI);   
		imageFond.add(boutonNON);
		imageFond.add(boutonAnnuler);
		imageFond.add(nomSauvegarde);
		imageFond.setOpaque(false);
		tmp.add(imageFond);
    
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
				if (choix=="Menu"){
					fenetre.setVisible(false);
					mere.getFrame().setVisible(false);
					new InterfaceMenu();
				}
				else if (choix=="Quitter"){
					System.exit(0);
				}
			}
			else if (e.getSource()==boutonNON){
				if (choix=="Menu"){
					fenetre.setVisible(false);
					mere.getFrame().setVisible(false);
					new InterfaceMenu();
				}
				else if (choix=="Quitter"){
					System.exit(0);
				}
			}
			else if (e.getSource()==boutonAnnuler){
				fenetre.setVisible(false);
			}		
		}
	}
	
	public static void main(String[] args){
		//new InterfacePopupSauvegarderQuitter("Menu");
	}
}
