package interfaceGraphique;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import projet_echec.echec.gestion.Partie;
import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.Echiquier;
import projet_echec.echec.jeu.EchiquierActif;
import projet_echec.echec.jeu.Piece;
import projet_echec.echec.jeu.Position;
import projet_echec.echec.jeu.Variantes;

/**
 * 
 * @author Anne-Sophie
 * 
 * Fenêtre de jeu
 *
 */

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
	JMenuItem boutonRevenirMenu = new JMenuItem("Revenir au menu principal");
	JMenuItem boutonQuitter = new JMenuItem("Quitter");
	
	JMenu boutonQuestion = new JMenu("?");
	JMenuItem boutonAide = new JMenuItem("Aide");
	JMenuItem boutonAProposDe = new JMenuItem("A propos de");
	
	Case CaseSelectionnee = new Case(new Position(5,2));
	
	Partie game;
	EchiquierActif plateauJeu;
	
	
	
	/*
	
	
	public InterfaceJeu(Partie partie, EchiquierActif echiquier) {
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		game = partie;
		plateauJeu = echiquier;
		
		
		// fond d'écran
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/interface_jeu.png").getImage());
		
		// Création de la JMenuBar
		boutonPartie.add(boutonNouvellePartie);
		boutonPartie.add(boutonSauvegarder);
		boutonPartie.add(boutonChargerPartie);
		boutonPartie.add(boutonOptions);
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
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/auto/"+String.valueOf(i+1)+".png"));	
			}
			else {
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/auto/"+String.valueOf(i+1)+".png"));		
			}
		}
		
		// 8ème ligne
		for (int i=56; i<64; i++){			
			if (i%2==0){
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/auto/"+String.valueOf(i+1)+".png"));		
			}
			else {
				((Vector<JButton>) tab_cases).get(i).setIcon(new ImageIcon("images/Pieces/auto/"+String.valueOf(i+1)+".png"));		
			}
		}
		
		JPanel plateau = new JPanel();
		plateau.setLayout(new GridLayout(8,8));
		
		imageFond.setLayout(null);
		plateau.setBounds(465,110,448,448);		
		
		
		for (int i=0; i<64 ; i++){
			plateau.add(((Vector<JButton>) tab_cases).get(i));
			((Vector<JButton>) tab_cases).get(i).setBorder(BorderFactory.createLineBorder(Color.gray));
		}
		
		imageFond.add(plateau);
		
		EcouteurAction listenAction=new EcouteurAction();
		for (int i=0; i<64 ; i++){
			((Vector<JButton>) tab_cases).get(i).addActionListener(listenAction);					
		}
		
		EcouteurFocus listenFocus = new EcouteurFocus();
		for (int i=0; i<64 ; i++){
			((Vector<JButton>) tab_cases).get(i).addFocusListener(listenFocus);					
		}
		
		
		tmp.add(imageFond);
		fenetre.setSize(1030,700); 
		fenetre.setResizable(false);
		fenetre.setJMenuBar(barreMenu);
		barreMenu.setVisible(true);
		fenetre.setVisible(true);
		
	}
	
	*/
	
	
	
	
	/**
	 * Constructeur avec paramètre
	 * @param partie la Partie créé précédemment
	 * @param echiquier l'Echiquier créé précédemment 
	 */
	public InterfaceJeu(Partie partie, Echiquier echiquier) {
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		game = partie;
		plateauJeu = (EchiquierActif) echiquier;
		
		// fond d'écran
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/interface_jeu.png").getImage());
		
		// Création de la JMenuBar
		boutonPartie.add(boutonNouvellePartie);
		boutonPartie.add(boutonSauvegarder);
		boutonPartie.add(boutonChargerPartie);
		boutonPartie.add(boutonOptions);
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
		Vector<Case> plateauCases = plateauJeu.getPlateau();
		for (int i=0; i<64; i++){
			int numCase = plateauCases.get(i).getPosition().getLargeur() + 8*(plateauCases.get(i).getPosition().getHauteur()-1)-1;			
			((Vector<JButton>) tab_cases).get(numCase).setIcon(new ImageIcon(plateauCases.get(i).getImg()));
		}
		
		
		
		
		JPanel plateau = new JPanel();
		plateau.setLayout(new GridLayout(8,8));
		
		imageFond.setLayout(null);
		plateau.setBounds(465,110,448,448);		
		
		
		for (int i=0; i<64 ; i++){
			plateau.add(((Vector<JButton>) tab_cases).get(i));	
			((Vector<JButton>) tab_cases).get(i).setBorder(BorderFactory.createLineBorder(Color.gray));
				
		}
		
		imageFond.add(plateau);
		
		tmp.add(imageFond);
		fenetre.setSize(1030,700); 
		fenetre.setResizable(false);
		fenetre.setJMenuBar(barreMenu);
		barreMenu.setVisible(true);
		fenetre.setVisible(true);
	
				
	}
	
	
	
	
	
	public void actualiserImage(Case NewCase){
		NewCase.setPosition(new Position(8-NewCase.getPosition().getHauteur()+1, NewCase.getPosition().getLargeur()));
		int numCase = NewCase.getPosition().getLargeur() + 8*(NewCase.getPosition().getHauteur()-1)-1;			
		((Vector<JButton>) tab_cases).get(numCase).setIcon(new ImageIcon(NewCase.getImg()));
	}
		
	
	
	
	
	public class EcouteurAction implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (tab_cases.contains(e.getSource())){
				int numCase = ((Vector<JButton>) tab_cases).indexOf(e.getSource());
				int largeur = numCase%8 ;
				int hauteur = numCase/8 +1;
				Case eCase = plateauJeu.chercherCase(new Position(hauteur, largeur));
				eCase.setPosition(new Position(8-eCase.getPosition().getHauteur()+1, eCase.getPosition().getLargeur()));
				plateauJeu.selectionnerCase(eCase);
				actualiserImage(CaseSelectionnee);
				actualiserImage(eCase);
				CaseSelectionnee =  eCase;
			}
			if (e.getSource()==boutonSauvegarder){
				new InterfacePopupSauvegarder();
			}
			if (e.getSource()==boutonOptions){
				new InterfacePopupOptions();
			}
			if (e.getSource()==boutonNouvellePartie){
				new InterfacePopupSauvegarder();
			}
			if (e.getSource()==boutonChargerPartie){
				new InterfacePopupSauvegarder();
			}
			if (e.getSource()==boutonQuitter){
				new InterfacePopupSauvegarderQuitter();
			}
			if (e.getSource()==boutonAide){
				new InterfacePopupSauvegarder();
			}
			if (e.getSource()==boutonAProposDe){
				new InterfacePopupSauvegarderQuitter();
			}
		}
	}
	

	public class EcouteurFocus implements FocusListener{		
		public void focusGained(FocusEvent e){
			if (tab_cases.contains(e.getSource())){
				//((JButton) e.getSource()).setIcon(new ImageIcon("images/caserouge.png"));
				((JButton) e.getSource()).setBorderPainted(true);
				((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
		}
		public void focusLost(FocusEvent e){
			//((JButton) e.getSource()).setBorderPainted(false);
			((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.gray));
		}
	}
	

	
	
	public static void main(String[] args){
	//	new InterfaceJeu();
	}
}







