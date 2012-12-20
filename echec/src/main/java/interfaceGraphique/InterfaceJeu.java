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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

import projet_echec.echec.exception.DeplacementException;
import projet_echec.echec.gestion.GestionJeu;
import projet_echec.echec.gestion.Options;
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
	
	JFrame fenetre;
	Container tmp;
	Collection<JButton> tab_cases;
	
	JPanel imageFond;
	
	JMenuBar barreMenu;
	
	JMenu boutonPartie;
	JMenuItem boutonNouvellePartie;
	JMenuItem boutonSauvegarder;
	JMenuItem boutonChargerPartie;
	JMenuItem boutonOptions;
	JMenuItem boutonRevenirMenu;
	JMenuItem boutonQuitter;
	
	JMenu boutonQuestion;
	JMenuItem boutonAide;
	JMenuItem boutonAProposDe;
	
	Case CaseSelectionnee;
	boolean selectionCase;
	
	Partie game;
	EchiquierActif plateauJeu;
	
	
	Timer chrono;
	
	Vector<String> casesPrisesJ1;
	Vector<String> casesPrisesJ2;
	
	int tour = 1;
	
	JLabel affichageAideJ1;
	JLabel affichageAideJ2;
	
	
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
		fenetre=new JFrame("Jeu d'échecs");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tmp = fenetre.getContentPane();
		tab_cases = new Vector<JButton>();
		
		barreMenu = new JMenuBar();
		
		boutonPartie = new JMenu("Partie");
		boutonNouvellePartie = new JMenuItem("Nouvelle partie");
		boutonSauvegarder = new JMenuItem("Sauvegarder la partie");
		boutonChargerPartie = new JMenuItem("Charger une partie");
		boutonOptions = new JMenuItem("Options");
		boutonRevenirMenu = new JMenuItem("Revenir au menu principal");
		boutonQuitter = new JMenuItem("Quitter");
		
		boutonQuestion = new JMenu("?");
		boutonAide = new JMenuItem("Aide");
		boutonAProposDe = new JMenuItem("A propos de");
		
		affichageAideJ1 = new JLabel("aide1");
		affichageAideJ1.setBounds(255, 90, 100, 40);
		affichageAideJ1.setVisible(partie.getjBlanc().isModeAide());	
		affichageAideJ2 = new JLabel("aide2");
		affichageAideJ2.setBounds(255, 355, 100, 40);
		affichageAideJ2.setVisible(partie.getjNoir().isModeAide());
		
		CaseSelectionnee = new Case(new Position(5,2));
		selectionCase = false;

		casesPrisesJ1 = new Vector<String>();
		casesPrisesJ2 = new Vector<String>();
		
		game = partie;
		plateauJeu = (EchiquierActif) echiquier;
		
		//chrono = new Timer(speed, this);
		//chrono.setInitialDelay(pause);
		//chrono.start();
		
		// fond d'écran
		imageFond = new TestImagePanel(new ImageIcon("images/interface_jeu.png").getImage());
		
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
			int numCase = plateauCases.get(i).getPosition().getLargeur() + 8*(8-plateauCases.get(i).getPosition().getHauteur())-1;			
			((Vector<JButton>) tab_cases).get(numCase).setIcon(new ImageIcon(plateauCases.get(i).getImg()));
		}
		
		
		
		
		JPanel plateau = new JPanel();
		plateau.setLayout(new GridLayout(8,8));
		
		imageFond.setLayout(null);
		plateau.setBounds(430,100,448,448);		
		
		
		for (int i=0; i<64 ; i++){
			plateau.add(((Vector<JButton>) tab_cases).get(i));	
			((Vector<JButton>) tab_cases).get(i).setBorder(BorderFactory.createLineBorder(Color.gray));
				
		}
		
		EcouteurAction listenAction=new EcouteurAction();
		for (int i=0; i<64 ; i++){
			((Vector<JButton>) tab_cases).get(i).addActionListener(listenAction);					
		}
		
		boutonNouvellePartie.addActionListener(listenAction);
		boutonSauvegarder.addActionListener(listenAction);
		boutonChargerPartie.addActionListener(listenAction);
		boutonOptions.addActionListener(listenAction);
		boutonRevenirMenu.addActionListener(listenAction);
		boutonQuitter.addActionListener(listenAction);
		boutonAide.addActionListener(listenAction);
		boutonAProposDe.addActionListener(listenAction);
		
		EcouteurFocus listenFocus = new EcouteurFocus();
		for (int i=0; i<64 ; i++){
			((Vector<JButton>) tab_cases).get(i).addFocusListener(listenFocus);					
		}
		
		imageFond.add(plateau);
		imageFond.add(affichageAideJ1);
		imageFond.add(affichageAideJ2);
		
		tmp.add(imageFond);
		fenetre.setSize(1030,700); 
		fenetre.setResizable(false);
		fenetre.setJMenuBar(barreMenu);
		barreMenu.setVisible(true);
		fenetre.setVisible(true);
	
	}
	
	
	
	/**
	 * Methode permettant de mettre a jour l'image d'une case
	 * 
	 * @param NewCase la case dont l'image doit etre rechargee
	 */
	
	public void actualiserImage(Case NewCase){
		Position p = new Position(8-NewCase.getPosition().getHauteur()+1, NewCase.getPosition().getLargeur());
		int numCase = p.getLargeur() + 8*(p.getHauteur()-1)-1;		
		((Vector<JButton>) tab_cases).get(numCase).setIcon(new ImageIcon(NewCase.getImg()));

	}
	
	
	
	
	
	/**
	 * Methode permettant de mettre a jour les options et l'affichage du mode aide ou non pour chaque joueur, 
	 * lorsque les options ont ete changees dans InterfacePopupOptions
	 * 
	 * @param aideJ1 booleen indiquant si le joueur 1 est en mode aide ou non
	 * @param aideJ2 booleen indiquant si le joueur 2 est en mode aide ou non
	 */
	public void actualiserOptions(boolean aideJ1, boolean aideJ2){
		game.getjBlanc().setModeAide(aideJ1);
		game.getjNoir().setModeAide(aideJ2);
		affichageAideJ1.setVisible(game.getjBlanc().isModeAide());
		affichageAideJ2.setVisible(game.getjNoir().isModeAide());
	}
	
	
	
	
	
	
	
	public void aPerduUnePiece(int tour){
		if (tour==1){
			
		}
	}
	
	

	
	
	/**
	 * Methode permettant d'actualiser l'affichage des pieces prises
	 * 
	 * @param J le joueur concerne : 1 pour joueur blanc, et 2 pour joueur noir
	 */
	
	public void actualiserPiecesPrises(int J){
		String img;		
		if (J==1){
			for (int i=0; i<casesPrisesJ1.size(); i++){
				String piece = casesPrisesJ1.get(i);
				if (piece=="Pion"){
					img = "images/Pieces/perso/PionB.png";
				}
				else if (piece=="Tour"){
					img = "images/Pieces/perso/TourB.png";
				}
				else if (piece=="Cavalier"){
					img = "images/Pieces/perso/CavalierB.png";
				}
				else if (piece=="Fou"){
					img = "images/Pieces/perso/FouB.png";
				}
				else if (piece=="Roi"){
					img = "images/Pieces/perso/RoiB.png";
				}
				else {
					img = "images/Pieces/perso/ReineB.png";
				}
				JLabel labelPiecePrise = new JLabel(new ImageIcon(img));
				//labelPiecePrise.setBounds());
				labelPiecePrise.setVisible(true);
				imageFond.add(labelPiecePrise);				
			}
		}
		else if (J==2){
			for (int i=0; i<casesPrisesJ2.size(); i++){
				String piece = casesPrisesJ2.get(i);
				if (piece=="Pion"){
					img = "images/Pieces/perso/PionN.png";
				}
				else if (piece=="Tour"){
					img = "images/Pieces/perso/TourN.png";
				}
				else if (piece=="Cavalier"){
					img = "images/Pieces/perso/CavalierN.png";
				}
				else if (piece=="Fou"){
					img = "images/Pieces/perso/FouN.png";
				}
				else if (piece=="Roi"){
					img = "images/Pieces/perso/RoiN.png";
				}
				else {
					img = "images/Pieces/perso/ReineN.png";
				}
				JLabel labelPiecePrise = new JLabel(new ImageIcon(img));
				//labelPiecePrise.setBounds());
				labelPiecePrise.setVisible(true);
				imageFond.add(labelPiecePrise);		
			}
		}
	}
	
	
	
	/**
	 * Methode getters permettant d'acceder a la fenetre depuis une autre fenetre 
	 * (popup sauvegarder avant de quitter)
	 * 
	 * @return fenetre la fenetre de jeu
	 */
	public JFrame getFrame(){
		return fenetre;
	}
	
	
	public void finPartie(){
		GestionJeu.finPartie(game);
	}
	
	
	
	public class EcouteurAction implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			
			if (tab_cases.contains(e.getSource())){
				int numCase = ((Vector<JButton>) tab_cases).indexOf(e.getSource());
				//int largeur = numCase%8 +1;
				//int hauteur = numCase/8 +1;
				//Case eCase = plateauJeu.chercherCase(new Position(hauteur, largeur));
				Position p = new Position(8-numCase/8,numCase%8 +1);
				Case eCase = plateauJeu.chercherCase(p);
			
			
				//System.out.println(eCase.getPosition().getLargeur());
				//System.out.println(eCase.getPosition().getHauteur());
				
				/*
				if ((eCase.estVide()==true) && (selectionCase==true)){
					CaseSelectionnee = eCase;
					selectionCase = true;
				}
				else if ((eCase.estVide()==true) && (selectionCase==true)){
					try {
						plateauJeu.selectionnerCase(eCase);
					} catch (DeplacementException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					actualiserImage(CaseSelectionnee);
					actualiserImage(eCase);
					selectionCase = false;
				}
				else if ((eCase.estVide()==false) && (selectionCase==true)){
					if (eCase.getPiece().getCamp()==CaseSelectionnee.getPiece().getCamp()){
						CaseSelectionnee = eCase;
					}
					else {
						casesPrisesJ1.add(eCase.getPiece().getClass().getSimpleName());
						// ou casesPrisesJ2.add(eCase.getPiece().getClass().getSimpleName());
						// prendre la pièce
						actualiserImage(CaseSelectionnee);
						actualiserImage(eCase);
						selectionCase = false;
						actualiserPiecesPrises(1);
						// ou actualiserPiecesPrises(2);
					}
				}
				*/
				
				String dep = "rien";
				try {
					
					dep = plateauJeu.selectionnerCase(eCase);
				} catch (DeplacementException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (dep!="rien"){
					game.ajoutDeplacement(dep);
					for (int i=0; i<plateauJeu.getPlateau().size(); i++){						
						actualiserImage(plateauJeu.getPlateau().get(i));						
						if (tour==1){
							tour=2;
						}
						else {
							tour=1;
						}	
						aPerduUnePiece(tour);
					}				
				}
				
				
				
			}
			if (e.getSource()==boutonSauvegarder){
				new InterfacePopupSauvegarder(game, plateauJeu);
			}
			if (e.getSource()==boutonOptions){
				new InterfacePopupOptions(InterfaceJeu.this);
			}
			if (e.getSource()==boutonNouvellePartie){
				new InterfaceConfigPartie();
			}
			if (e.getSource()==boutonChargerPartie){
				new InterfaceCatalogue("reprendre");
			}
			if (e.getSource()==boutonRevenirMenu){
				new InterfacePopupSauvegarderQuitter("Menu", game, plateauJeu, InterfaceJeu.this);
			}
			if (e.getSource()==boutonQuitter){
				new InterfacePopupSauvegarderQuitter("Quitter", game, plateauJeu, InterfaceJeu.this);
			}
			if (e.getSource()==boutonAide){
				//new InterfaceAide();
			}
			if (e.getSource()==boutonAProposDe){
				//new InterfacePopupAProposDe();
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







