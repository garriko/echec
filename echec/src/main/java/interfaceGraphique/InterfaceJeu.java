package interfaceGraphique;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
	
	
	Vector<String> casesPrisesJ1;
	Vector<String> casesPrisesJ2;
	
	private int tour;
	
	JLabel affichageAideJ1;
	JLabel affichageAideJ2;
	JLabel joueur1;
	JLabel joueur2;
	
	
	JLabel chronoJ1; //Le label qui contient le temps restant du joueur 1
	Timer countdownJ1; //Le compteur du joueur 1
	int timeRemaining1;
	int timeRemaining2; 
	JLabel chronoJ2; //Le label qui contient le temps restant du joueur 1
	Timer countdownJ2; //Le compteur du joueur 1
	
	JLabel tempsTotalJ1;
	JLabel tempsTotalJ2;
	
	JLabel total1;
	JLabel total2;
	JLabel secondes1;
	JLabel secondes2;
	JLabel tour1;
	JLabel tour2;
	JLabel secondes3;
	JLabel secondes4;
	
	boolean fin;
	
	
	
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
		
		fin = false;
		
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
		
		affichageAideJ1 = new JLabel("aide");
		affichageAideJ1.setBounds(255, 90, 100, 40);
		affichageAideJ1.setForeground(Color.white);
		affichageAideJ1.setVisible(partie.getjBlanc().isModeAide());	
		affichageAideJ2 = new JLabel("aide");
		affichageAideJ2.setBounds(255, 355, 100, 40);
		affichageAideJ2.setForeground(Color.white);
		affichageAideJ2.setVisible(partie.getjNoir().isModeAide());
		
		joueur1 = new JLabel(new ImageIcon("images/InterfaceJeuJoueur1Actif.png"));
		joueur2 = new JLabel(new ImageIcon("images/InterfaceJeuJoueur2Actif.png"));
		joueur1.setBounds(137, 95, 100, 25);
		joueur2.setBounds(139, 351, 100, 25);
		joueur1.setVisible(true);
		joueur2.setVisible(false);
		
		this.tour=1;
		/*
		 * if (plateauJeu.getCampActif().equals(new String("blanc"))){
			setTour(1);
		}
		else {
			setTour(2);
		}
		*/
		
		CaseSelectionnee = new Case(new Position(5,2));
		selectionCase = false;

		casesPrisesJ1 = new Vector<String>();
		casesPrisesJ2 = new Vector<String>();
		
		game = partie;
		plateauJeu = (EchiquierActif) echiquier;
		

		
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
		
		
		
		
		total1 = new JLabel("total :");
		total2 = new JLabel("total :");
		secondes1 = new JLabel("sec");
		secondes2 = new JLabel("sec");
		tour1 = new JLabel("tour :");
		tour2 = new JLabel("tour :");
		secondes3 = new JLabel("sec");
		secondes4 = new JLabel("sec");
		total1.setForeground(Color.white);
		total2.setForeground(Color.white);
		secondes1.setForeground(Color.white);
		secondes2.setForeground(Color.white);
		tour1.setForeground(Color.white);
		tour2.setForeground(Color.white);
		secondes3.setForeground(Color.white);
		secondes4.setForeground(Color.white);
		total1.setBounds(160,120,50,50);
		total2.setBounds(160, 370, 50, 50);
		secondes1.setBounds(270,120, 50, 50);
		secondes2.setBounds(270,370,50,50);
		tour1.setBounds(160,160,50,50);
		tour2.setBounds(160,410,50,50);
		secondes3.setBounds(270,160,50,50);
		secondes4.setBounds(270,410,50,50);
		imageFond.add(total1);
		imageFond.add(total2);
		imageFond.add(tour1);
		imageFond.add(tour2);
		imageFond.add(secondes1);
		imageFond.add(secondes2);
		imageFond.add(secondes3);
		imageFond.add(secondes4);
		
		
		
		// Timer
		
		
		tempsTotalJ1 = new JLabel("0");
		tempsTotalJ2 = new JLabel("0");
		tempsTotalJ1.setBounds(210, 120, 50, 50);
		tempsTotalJ2.setBounds(210, 370, 50, 50);
		tempsTotalJ1.setForeground(Color.white);
		tempsTotalJ2.setForeground(Color.white);
		imageFond.add(tempsTotalJ1);
		imageFond.add(tempsTotalJ2);
		
		//Récupération de dureeTour
		timeRemaining1 = game.getListeOptions().getDureeTourJ1(); // On commence par J1
		
		countdownJ1 = new Timer(1000, new CountdownTimerListener()); // On créé le timer du J1
		chronoJ1 = new JLabel(String.valueOf(timeRemaining1), JLabel.CENTER); //On affiche ce label
		chronoJ1.setBounds(192,160,50,50);
		chronoJ1.setForeground(Color.white);
		countdownJ1.start();//Démarrer le compteur
		
		timeRemaining2 = game.getListeOptions().getDureeTourJ2();
		countdownJ2 = new Timer(1000, new CountdownTimerListener()); // On créé le timer du J2
		chronoJ2 = new JLabel(String.valueOf(timeRemaining2), JLabel.CENTER); //On affiche ce label
		chronoJ2.setBounds(192,410,50,50);
		chronoJ2.setForeground(Color.white);
		
		
		imageFond.add(chronoJ1);
		imageFond.add(chronoJ2);
		
		
		imageFond.add(plateau);
		imageFond.add(affichageAideJ1);
		imageFond.add(affichageAideJ2);
		imageFond.add(joueur1);
		imageFond.add(joueur2);
		
		tmp.add(imageFond);
		fenetre.setSize(1030,700); 
		fenetre.setResizable(false);
		fenetre.setJMenuBar(barreMenu);
		barreMenu.setVisible(true);
		fenetre.setVisible(true);
		
		/*
		System.out.println(plateauCases.get(60).getPiece().getClass().getSimpleName());
		System.out.println(plateauCases.get(60).getPiece().getCamp());
		*/
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
	
	
	/**
	 * Getter du tour, permettant de savoir si c'est le tour du joueur 1 ou du joueur 2
	 * 
	 * @return le numéro du tour : 1 ou 2
	 */
	public int getTour(){
		return this.tour;
	}
	
	/**
	 * Setter du tour, permettant de modifier le tour
	 * @param newTour 1 ou 2, le joueur dont c'est maintenant le tour
	 */
	public void setTour(int newTour){
		this.tour = newTour;
	}
	
	
	/**
	 * Methode permettant d'actualiser le changement de joueur
	 * 
	 * @param tour, le numéro du joueur qui vient de jouer.
	 */
	public void actualiserTour(int tour){
		if (getTour()==1){	
			setTour(2);
			joueur1.setVisible(false);
			joueur2.setVisible(true);
			countdownJ1.stop();
			tempsTotalJ1.setText(String.valueOf(game.getListeOptions().getDureeTourJ1()-timeRemaining1+Integer.valueOf(tempsTotalJ1.getText())));
			timeRemaining2 = game.getListeOptions().getDureeTourJ2();
			countdownJ2.start();
		}
		else {
			setTour(1);
			joueur2.setVisible(false);
			joueur1.setVisible(true);
			countdownJ2.stop();
			tempsTotalJ2.setText(String.valueOf(game.getListeOptions().getDureeTourJ2()-timeRemaining2+Integer.valueOf(tempsTotalJ2.getText())));
			timeRemaining1 = game.getListeOptions().getDureeTourJ1();
			countdownJ1.start();
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
	
	public void echecEtMat(){
		if (plateauJeu.echecEtMat("noir")==true){
			finPartie();
			new InterfacePopupEchecEtMat(1, InterfaceJeu.this);
			new InterfacePopupSauvegarder(game, plateauJeu, true);
		}
		else if (plateauJeu.echecEtMat("blanc")==true){
			finPartie();
			new InterfacePopupEchecEtMat(2, InterfaceJeu.this);
		}		
	}
	
	public void pionBout(){
		if (plateauJeu.pionBoutEchiquiertest()){
			new InterfacePopupPionBout(plateauJeu.chercherCase(plateauJeu.pionBoutEchiquier()));
		}
	}
	
	
	
	public class EcouteurAction implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			
			if (tab_cases.contains(e.getSource())){
				
				int numCase = ((Vector<JButton>) tab_cases).indexOf(e.getSource());

				Position p = new Position(8-numCase/8,numCase%8 +1);
				Case eCase = plateauJeu.chercherCase(p);			
				
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
					}
						actualiserTour(getTour());
						pionBout();	
						echecEtMat();							
				}
				
				
				
			}
			if (e.getSource()==boutonSauvegarder){
				new InterfacePopupSauvegarder(game, plateauJeu, fin);
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
				new InterfacePopupSauvegarderQuitter("Menu", game, plateauJeu, InterfaceJeu.this, fin);
			}
			if (e.getSource()==boutonQuitter){
				new InterfacePopupSauvegarderQuitter("Quitter", game, plateauJeu, InterfaceJeu.this, fin);
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
				
				int numCase = ((Vector<JButton>) tab_cases).indexOf(e.getSource());
				Position p = new Position(8-numCase/8,numCase%8 +1);
				Case eCase = plateauJeu.chercherCase(p);
				
				if (getTour()==1){
					if (eCase.estVide()==false){
						if (eCase.getPiece().getCamp().equals("blanc")){							
							ArrayList<Case> plop = plateauJeu.filtreGeneral(eCase);
							for (int i=0; i<plop.size(); i++){
								Case laCase = plop.get(i);
								Position po = new Position(8-laCase.getPosition().getHauteur()+1, laCase.getPosition().getLargeur());
								int num = po.getLargeur() + 8*(po.getHauteur()-1)-1;		
								((Vector<JButton>) tab_cases).get(num).setBorderPainted(true);
								((Vector<JButton>) tab_cases).get(num).setBorder(BorderFactory.createLineBorder(Color.blue));
							}
						}
					}
				}
				
				else if (getTour()==2){
					if (eCase.estVide()==false){
						if (eCase.getPiece().getCamp().equals("noir")){
							ArrayList<Case> plop = plateauJeu.filtreGeneral(eCase);					
							for (int i=0; i<plop.size(); i++){
								Case laCase = plop.get(i);
								Position po = new Position(8-laCase.getPosition().getHauteur()+1, laCase.getPosition().getLargeur());
								int num = po.getLargeur() + 8*(po.getHauteur()-1)-1;		
								((Vector<JButton>) tab_cases).get(num).setBorderPainted(true);
								((Vector<JButton>) tab_cases).get(num).setBorder(BorderFactory.createLineBorder(Color.blue));
							}
						}
					}
				}
			}
		}
		public void focusLost(FocusEvent e){
			//((JButton) e.getSource()).setBorderPainted(false);
			((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.gray));
			
			int numCase = ((Vector<JButton>) tab_cases).indexOf(e.getSource());
			Position p = new Position(8-numCase/8,numCase%8 +1);
			Case eCase = plateauJeu.chercherCase(p);
			if (getTour()==1){
				if (eCase.estVide()==false){
					if (eCase.getPiece().getCamp().equals("blanc")){					
							ArrayList<Case> plop = plateauJeu.filtreGeneral(eCase);
							for (int i=0; i<plop.size(); i++){
							Case laCase = plop.get(i);
							Position po = new Position(8-laCase.getPosition().getHauteur()+1, laCase.getPosition().getLargeur());
							int num = po.getLargeur() + 8*(po.getHauteur()-1)-1;		
							((Vector<JButton>) tab_cases).get(num).setBorderPainted(true);
							((Vector<JButton>) tab_cases).get(num).setBorder(BorderFactory.createLineBorder(Color.gray));
						}
					}
				}
			}
			
			else if (getTour()==2){
				if (eCase.estVide()==false){
					if (eCase.getPiece().getCamp().equals("noir")){
						ArrayList<Case> plop = plateauJeu.filtreGeneral(eCase);			
						for (int i=0; i<plop.size(); i++){
							Case laCase = plop.get(i);
							Position po = new Position(8-laCase.getPosition().getHauteur()+1, laCase.getPosition().getLargeur());
							int num = po.getLargeur() + 8*(po.getHauteur()-1)-1;		
							((Vector<JButton>) tab_cases).get(num).setBorderPainted(true);
							((Vector<JButton>) tab_cases).get(num).setBorder(BorderFactory.createLineBorder(Color.gray));
						}
					}
				}
			}
		}		
	}
	

	
	class CountdownTimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (getTour()==1){
				if (--timeRemaining1 >= 0) {
					countdownJ1.start();
					chronoJ1.setText(String.valueOf(timeRemaining1));
				}
				else {
					countdownJ1.stop();
					new InterfacePopupTempsEcoule(1, InterfaceJeu.this);
				}
			}
			else {
				if (--timeRemaining2 >= 0) {
					countdownJ2.start();
					chronoJ2.setText(String.valueOf(timeRemaining2));
				}
				else {
					countdownJ2.stop();
					new InterfacePopupTempsEcoule(2, InterfaceJeu.this);
				}
			}
		}
	}
	
	
	
	public static void main(String[] args){
	//	new InterfaceJeu();
	}
}







