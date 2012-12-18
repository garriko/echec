package interfaceGraphique;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.Piece;
import projet_echec.echec.jeu.Variantes;


public class InterfaceJeu {
	
	JFrame fenetre=new JFrame("Jeu d'échecs");
	Container tmp = fenetre.getContentPane();
	Collection<JButton> tab_cases = new Vector<JButton>();
	
	JMenuBar barreMenu = new JMenuBar();
	
	JMenu boutonPartie = new JMenu("Partie");
	JMenuItem boutonNouvellePartie = new JMenuItem("Nouvelle partie");
	JMenuItem boutonSauvegarder = new JMenuItem("Sauvegarder la partie");
	JMenuItem boutonChargerPartie = new JMenuItem("Charger une partie");
	JMenuItem boutonOptions = new JMenuItem("Options");
	JMenuItem boutonAffichage = new JMenuItem("Affichage");
	JMenuItem boutonRevenirMenu = new JMenuItem("Revenir au menu principal");
	JMenuItem boutonQuitter = new JMenuItem("Quitter");
	
	JMenu boutonQuestion = new JMenu("?");
	JMenuItem boutonAide = new JMenuItem("Aide");
	JMenuItem boutonAProposDe = new JMenuItem("A propos de");
	
	Case CaseSelectionnee = new Case(null);
	
	
	/**
	 * Constructeur sans parametre
	 */
	public InterfaceJeu() {
		
		
		// fond d'écran
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/interface_jeu.png").getImage());
		
		// Création de la JMenuBar
		boutonPartie.add(boutonNouvellePartie);
		boutonPartie.add(boutonSauvegarder);
		boutonPartie.add(boutonChargerPartie);
		boutonPartie.add(boutonOptions);
		boutonPartie.add(boutonAffichage);
		boutonPartie.add(boutonRevenirMenu);
		boutonPartie.add(boutonQuitter);
		
		boutonQuestion.add(boutonAide);
		boutonQuestion.add(boutonAProposDe);
		
		barreMenu.add(boutonPartie);
		barreMenu.add(boutonQuestion);
		
		
	
		
		// Initialisation de l'échiquier sans pièce
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				
				if (j%2==0){
					
					if (i%2==0){
						tab_cases.add(new JButton(new ImageIcon("images/casegrise.png")));
					}
					else {
						tab_cases.add(new JButton(new ImageIcon("images/caseblanche.png")));
					}
				}
				else {
					if (i%2==1){
						tab_cases.add(new JButton(new ImageIcon("images/casegrise.png")));
					}
					else {
						tab_cases.add(new JButton(new ImageIcon("images/caseblanche.png")));
					}			
				}
				((Vector<JButton>) tab_cases).get(i).setPreferredSize(new Dimension(56,56));
			}
		}
			
		// 2ème ligne : pions
		for (int i=8; i<16; i++){			
			if (i%2==0){
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/pions/1.png"));	
			}
			else {
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/pions/2.png"));	
			}
		}
		
		// 7ème ligne : pions
		for (int i=48; i<56; i++){			
			if (i%2==0){
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/pions/3.png"));	
			}
			else {
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/pions/4.png"));	
			}
		}
		
		// 1ère ligne
		for (int i=0; i<8; i++){			
			if (i%2==0){
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/"+String.valueOf(i+1)+".png"));	
			}
			else {
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/"+String.valueOf(i+1)+".png"));		
			}
		}
		
		// 8ème ligne
		for (int i=56; i<64; i++){			
			if (i%2==0){
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/"+String.valueOf(i+1)+".png"));		
			}
			else {
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/"+String.valueOf(i+1)+".png"));		
			}
		}
		
		JPanel plateau = new JPanel();
		plateau.setLayout(new GridLayout(8,8));
		
		imageFond.setLayout(null);
		plateau.setBounds(465,110,448,448);		
		
		
		for (int i=0; i<64 ; i++){
			plateau.add(((Vector<JButton>) tab_cases).get(i));	
				
		}
		
		imageFond.add(plateau);
		
		tmp.add(imageFond);
		fenetre.setSize(1030,700); 
		fenetre.setResizable(false);
		fenetre.setJMenuBar(barreMenu);
		barreMenu.setVisible(true);
		fenetre.setVisible(true);
		
	}
	
	
	
	
	
	
	/**
	 * Constructeur avec paramètre
	 * @param v la variante de jeu choisie par l'utilisateur
	 */
	public InterfaceJeu(Variantes v) {
		
		
		// fond d'écran
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/interface_jeu.png").getImage());
		
		// Création de la JMenuBar
		boutonPartie.add(boutonNouvellePartie);
		boutonPartie.add(boutonSauvegarder);
		boutonPartie.add(boutonChargerPartie);
		boutonPartie.add(boutonOptions);
		boutonPartie.add(boutonAffichage);
		boutonPartie.add(boutonRevenirMenu);
		boutonPartie.add(boutonQuitter);
		
		boutonQuestion.add(boutonAide);
		boutonQuestion.add(boutonAProposDe);
		
		barreMenu.add(boutonPartie);
		barreMenu.add(boutonQuestion);
		
		
	
		
		// Initialisation de l'échiquier sans pièce
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				
				if (j%2==0){
					
					if (i%2==0){
						tab_cases.add(new JButton(new ImageIcon("images/casegrise.png")));
					}
					else {
						tab_cases.add(new JButton(new ImageIcon("images/caseblanche.png")));
					}
				}
				else {
					if (i%2==1){
						tab_cases.add(new JButton(new ImageIcon("images/casegrise.png")));
					}
					else {
						tab_cases.add(new JButton(new ImageIcon("images/caseblanche.png")));
					}			
				}
				((Vector<JButton>) tab_cases).get(i).setPreferredSize(new Dimension(56,56));
			}
		}
			
		
		//Récupération des données depuis la variante v
		Vector<Case> plateauVariante = v.getPlateau();
		for (int i=0; i<64; i++){
			int numCase = plateauVariante.get(i).getPosition().getLargeur() + 8*(plateauVariante.get(i).getPosition().getHauteur()-1);
			Piece pieceCase = plateauVariante.get(i).getPiece();
			
			if (pieceCase.getClass()==Pion){
				if (pieceCase.getCamp()=="noir")
				numCase
			}
			
			((Vector<JButton>) tab_cases).get(numCase).setIcon(new ImageIcon("images/Pieces/pions/"+String.valueOf(numPiece)+".png"));
		}
		
		
		
		
		JPanel plateau = new JPanel();
		plateau.setLayout(new GridLayout(8,8));
		
		imageFond.setLayout(null);
		plateau.setBounds(465,110,448,448);		
		
		
		for (int i=0; i<64 ; i++){
			plateau.add(((Vector<JButton>) tab_cases).get(i));	
				
		}
		
		imageFond.add(plateau);
		
		tmp.add(imageFond);
		fenetre.setSize(1030,700); 
		fenetre.setResizable(false);
		fenetre.setJMenuBar(barreMenu);
		barreMenu.setVisible(true);
		fenetre.setVisible(true);
	
				
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
		}
	}
	

	
	
	
	
	public static void main(String[] args){
		new InterfaceJeu();
	}
}







