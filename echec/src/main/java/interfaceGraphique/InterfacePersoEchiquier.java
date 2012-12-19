package interfaceGraphique;

import interfaceGraphique.InterfaceJeu.EcouteurAction;
import interfaceGraphique.InterfaceJeu.EcouteurFocus;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
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
import javax.swing.JTextField;

import projet_echec.echec.exception.CaseErrorException;
import projet_echec.echec.exception.EmptyCaseException;
import projet_echec.echec.exception.FullCaseException;
import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.EchiquierActif;
import projet_echec.echec.jeu.Piece;
import projet_echec.echec.jeu.Position;
import projet_echec.echec.jeu.Variantes;
import projet_echec.echec.jeu.piece.Cavalier;
import projet_echec.echec.jeu.piece.Fou;
import projet_echec.echec.jeu.piece.Pion;
import projet_echec.echec.jeu.piece.Reine;
import projet_echec.echec.jeu.piece.Roi;
import projet_echec.echec.jeu.piece.Tour;

public class InterfacePersoEchiquier {

	Variantes nouvelleVariante;
	
	JFrame fenetre;
	Container tmp;
	Collection<JButton> tab_cases;
	
	Image ok;
	JButton boutonOK;
	Image annuler;
	JButton boutonAnnuler;
	
	JTextField nomVariante;
	
	JButton PionBlanc;
	JButton TourBlanc;
	JButton CavalierBlanc;
	JButton FouBlanc;
	JButton RoiBlanc;
	JButton ReineBlanc;
	
	JButton PionNoir ;
	JButton TourNoir;
	JButton CavalierNoir;
	JButton FouNoir;
	JButton RoiNoir;
	JButton ReineNoir;
	
	JButton Poubelle;
	JButton Reset;
	
	
	Case CaseSelectionnee;
	Piece PieceSelectionnee;
	boolean selectionPiece;
	boolean selectionCase;
	
	
	
	
	/**
	 * Constructeur sans parametre
	 */
	public InterfacePersoEchiquier(Variantes v) {
		
		nouvelleVariante = v;
		
		selectionPiece = false;
		selectionCase = false;
		PieceSelectionnee = new Pion("blanc");
		CaseSelectionnee = new Case(null);
		
		nouvelleVariante = new Variantes();
		fenetre = new JFrame("Jeu d'échecs");
		tmp = fenetre.getContentPane();
		
		tab_cases = new Vector<JButton>();
		
		nomVariante = new JTextField("maVariante");
		nomVariante.setBounds(50, 100, 200, 50);
		nomVariante.setVisible(true);
		
		ok = new ImageIcon("images/partiepersoBoutonOK.png").getImage();
		boutonOK =new JButton(new ImageIcon(ok));
		
		annuler  = new ImageIcon("images/partiepersoBoutonAnnuler.png").getImage();
		boutonAnnuler  = new JButton(new ImageIcon(annuler));
		
		PionBlanc  = new JButton(new ImageIcon("images/Pieces/perso/PionB.png"));
		PionBlanc.setBorderPainted(false);
		TourBlanc = new JButton(new ImageIcon("images/Pieces/perso/TourB.png"));
		TourBlanc.setBorderPainted(false);
		CavalierBlanc = new JButton(new ImageIcon("images/Pieces/perso/CavalierB.png"));
		CavalierBlanc.setBorderPainted(false);
		FouBlanc  = new JButton(new ImageIcon("images/Pieces/perso/FouB.png"));
		FouBlanc.setBorderPainted(false);
		RoiBlanc  = new JButton(new ImageIcon("images/Pieces/perso/RoiB.png"));
		RoiBlanc.setBorderPainted(false);
		ReineBlanc = new JButton(new ImageIcon("images/Pieces/perso/ReineB.png"));
		ReineBlanc.setBorderPainted(false);
		
		PionNoir= new JButton(new ImageIcon("images/Pieces/perso/PionN.png"));
		PionNoir.setBorderPainted(false);
		TourNoir = new JButton(new ImageIcon("images/Pieces/perso/TourN.png"));
		TourNoir.setBorderPainted(false);
		FouNoir = new JButton(new ImageIcon("images/Pieces/perso/FouN.png"));
		FouNoir.setBorderPainted(false);
		CavalierNoir = new JButton(new ImageIcon("images/Pieces/perso/CavalierN.png"));
		CavalierNoir.setBorderPainted(false);
		RoiNoir = new JButton(new ImageIcon("images/Pieces/perso/RoiN.png"));
		RoiNoir.setBorderPainted(false);
		ReineNoir = new JButton(new ImageIcon("images/Pieces/perso/ReineN.png"));
		ReineNoir.setBorderPainted(false);
		
		Poubelle = new JButton("Poubelle");
		Reset = new JButton("Reset");
		
		// fond d'écran
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/persoEchiquier.png").getImage());
	
		
		boutonOK.setBounds(675, 550, 124, 65);
		boutonAnnuler.setBounds(800, 550, 149, 65);
		
		PionBlanc.setBounds(100, 170, 55,55);
		TourBlanc.setBounds(100, 230, 55,55);
		CavalierBlanc.setBounds(160, 170, 55,55);
		FouBlanc.setBounds(160, 230, 55,55);
		RoiBlanc.setBounds(220, 170, 55,55);
		ReineBlanc.setBounds(220, 230, 55,55);
		PionNoir.setBounds(100, 420, 55,55);
		TourNoir.setBounds(100, 480, 55,55);
		CavalierNoir.setBounds(160, 420, 55,55);
		FouNoir.setBounds(160, 480, 55,55);
		RoiNoir.setBounds(220, 420, 55,55);
		ReineNoir.setBounds(220, 480, 55,55);
		
		Poubelle.setBounds(100, 600, 100, 40);
		Reset.setBounds(200, 600, 70, 40);
		
	
		
		// Initialisation de l'échiquier sans pièce
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				
				if (j%2==0){
					
					if (i%2==0){
						tab_cases.add(new JButton(new ImageIcon("images/caseblanche.png")));
					}
					else {
						tab_cases.add(new JButton(new ImageIcon("images/casegrise.png")));
					}
				}
				else {
					if (i%2==1){
						tab_cases.add(new JButton(new ImageIcon("images/caseblanche.png")));
					}
					else {
						tab_cases.add(new JButton(new ImageIcon("images/casegrise.png")));
					}			
				}
				((Vector<JButton>) tab_cases).get(i).setPreferredSize(new Dimension(44,44));
			}
		}
		
		
		
		
		JPanel plateau = new JPanel();
		plateau.setLayout(new GridLayout(8,8));
		
		imageFond.setLayout(null);
		plateau.setBounds(523,141,352, 352);		
		
		
		for (int i=0; i<64 ; i++){
			plateau.add(((Vector<JButton>) tab_cases).get(i));
			//((Vector<JButton>) tab_cases).get(i).setBorder(BorderFactory.createLineBorder(Color.gray));
		}		
		
		imageFond.add(plateau);
		
		EcouteurAction listenAction=new EcouteurAction();
		for (int i=0; i<64 ; i++){
			((Vector<JButton>) tab_cases).get(i).addActionListener(listenAction);					
		}
		boutonOK.addActionListener(listenAction);
		boutonAnnuler.addActionListener(listenAction);
		PionBlanc.addActionListener(listenAction);
		TourBlanc.addActionListener(listenAction);
		FouBlanc.addActionListener(listenAction);
		CavalierBlanc.addActionListener(listenAction);
		RoiBlanc.addActionListener(listenAction);
		ReineBlanc.addActionListener(listenAction);
		PionNoir.addActionListener(listenAction);
		TourNoir.addActionListener(listenAction);
		CavalierNoir.addActionListener(listenAction);
		FouNoir.addActionListener(listenAction);
		RoiNoir.addActionListener(listenAction);
		ReineNoir.addActionListener(listenAction);
		
		Poubelle.addActionListener(listenAction);
		Reset.addActionListener(listenAction);
		
		EcouteurFocus listenFocus=new EcouteurFocus();
		for (int i=0; i<64 ; i++){
			((Vector<JButton>) tab_cases).get(i).addFocusListener(listenFocus);					
		}
		PionBlanc.addFocusListener(listenFocus);
		TourBlanc.addFocusListener(listenFocus);
		FouBlanc.addFocusListener(listenFocus);
		CavalierBlanc.addFocusListener(listenFocus);
		RoiBlanc.addFocusListener(listenFocus);
		ReineBlanc.addFocusListener(listenFocus);
		PionNoir.addFocusListener(listenFocus);
		TourNoir.addFocusListener(listenFocus);
		CavalierNoir.addFocusListener(listenFocus);
		FouNoir.addFocusListener(listenFocus);
		RoiNoir.addFocusListener(listenFocus);
		ReineNoir.addFocusListener(listenFocus);
		
		
		imageFond.add(nomVariante);
		imageFond.add(boutonOK);
		imageFond.add(boutonAnnuler);
		imageFond.add(PionBlanc);
		imageFond.add(TourBlanc);
		imageFond.add(FouBlanc);
		imageFond.add(CavalierBlanc);
		imageFond.add(RoiBlanc);
		imageFond.add(ReineBlanc);
		imageFond.add(PionNoir);
		imageFond.add(TourNoir);
		imageFond.add(FouNoir);
		imageFond.add(CavalierNoir);
		imageFond.add(RoiNoir);
		imageFond.add(ReineNoir);
		imageFond.add(Poubelle);
		imageFond.add(Reset);
		
		tmp.add(imageFond);
		fenetre.setSize(1030,700); 
		fenetre.setResizable(false);
		fenetre.setVisible(true);
		
	}
	
	
	

	
	
	
	
	
	public void actualiserImage(Case NewCase){
		NewCase.setPosition(new Position(8-NewCase.getPosition().getHauteur()+1, NewCase.getPosition().getLargeur()));
		int numCase = NewCase.getPosition().getLargeur() + 8*(NewCase.getPosition().getHauteur()-1)-1;	
		((Vector<JButton>) tab_cases).get(numCase).setIcon(new ImageIcon(NewCase.getImg()));
	}
		
	
	
	
	
	public class EcouteurAction implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==boutonOK){
				try {
					nouvelleVariante.saveVariante("maVariante");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (e.getSource()==boutonAnnuler){
				
			}
			else if (e.getSource()==Poubelle){
				if ((selectionCase==true) && (CaseSelectionnee.estVide()==false)){ // si une case avait été sélectionnée
					try {
						nouvelleVariante.retirerPiece(CaseSelectionnee) ;
					} catch (EmptyCaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CaseErrorException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// la case est vidée
					actualiserImage(CaseSelectionnee) ; // image rechargée
					selectionCase = false ;
					selectionPiece = false ;
				}
				selectionPiece = false ;
			}
			else if (e.getSource()==Reset){
				/*
				for (int i=0; i<nouvelleVariante.getPlateau().size(); i++){
					try {
						nouvelleVariante.retirerPiece(nouvelleVariante.getPlateau().get(i));
					} catch (EmptyCaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CaseErrorException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					actualiserImage(nouvelleVariante.getPlateau().get(i));
				}
				*/
			}
			else if (tab_cases.contains(e.getSource())){
				int numCase = ((Vector<JButton>) tab_cases).indexOf(e.getSource());
				//int largeur = numCase%8 +1;
				//int hauteur = numCase/8 +1;
				Case eCase = nouvelleVariante.getPlateau().get(numCase);
				eCase.setPosition(new Position(8-eCase.getPosition().getHauteur()+1, eCase.getPosition().getLargeur()));
				
				if ((eCase.estVide()==false) && (selectionPiece==false)){ // si case occupée et pas de pièce retenue
					CaseSelectionnee = eCase ; // la case est retenue
					selectionCase = true ;
				}
				else if ((eCase.estVide()==false) && (selectionPiece==true)){ // si case occupée et pièce retenue
					try {
						nouvelleVariante.ajouterPiece(eCase, PieceSelectionnee) ;
					} catch (FullCaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// on change la pièce
					actualiserImage(eCase);
					selectionPiece = false;
				}
				
				else if ((eCase.estVide()==true) && (selectionPiece==true)){ // si case vide et pièce retenue
					
					try {
						nouvelleVariante.ajouterPiece(eCase, PieceSelectionnee);
						System.out.println(eCase.getImg());
					} catch (FullCaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					// on place la pièce
					// eCase.setImg("Images/Pieces/pasAuto/111.png"); // test
					actualiserImage(eCase);
				}
				
				else if ((selectionCase == false) && (eCase.estVide()==false) && (selectionPiece == false)){
					PieceSelectionnee = eCase.getPiece();
					selectionPiece = true;
					selectionCase = true;
				}
				
				else if ((selectionCase == true) && (eCase.estVide() == true)) { // si case retenue
					try {
						nouvelleVariante.ajouterPiece(eCase, PieceSelectionnee) ;
					} catch (FullCaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// on change la pièce
					try {
						nouvelleVariante.retirerPiece(CaseSelectionnee) ;
					} catch (EmptyCaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CaseErrorException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// On la retire de la première case
					actualiserImage(CaseSelectionnee) ;
					actualiserImage(eCase) ;
					selectionCase = false ;
				}
				
				else if ((selectionCase == true) && (eCase.estVide() == false)){
					try {
						nouvelleVariante.retirerPiece(eCase) ;
					} catch (EmptyCaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CaseErrorException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						nouvelleVariante.ajouterPiece(eCase, PieceSelectionnee) ;
					} catch (FullCaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// on change la pièce
					try {
						nouvelleVariante.retirerPiece(CaseSelectionnee) ;
					} catch (EmptyCaseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CaseErrorException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// On la retire de la première case
					actualiserImage(CaseSelectionnee) ;
					actualiserImage(eCase) ;
					selectionCase = false ;
				}
				
			}
			
			else{
				if (e.getSource()==PionBlanc){
					PieceSelectionnee = new Pion("blanc");
				}
				if (e.getSource()==TourBlanc){
					PieceSelectionnee = new Tour("blanc");
				}
				if (e.getSource()==CavalierBlanc){
					PieceSelectionnee = new Cavalier("blanc");
				}
				if (e.getSource()==FouBlanc){
					PieceSelectionnee = new Fou("blanc");
				}
				if (e.getSource()==RoiBlanc){
					PieceSelectionnee = new Roi("blanc");
				}
				if (e.getSource()==ReineBlanc){
					PieceSelectionnee = new Reine("blanc");
				}
				if (e.getSource()==PionNoir){
					PieceSelectionnee = new Pion("noir");
				}
				if (e.getSource()==TourNoir){
					PieceSelectionnee = new Tour("noirblanc");
				}
				if (e.getSource()==CavalierNoir){
					PieceSelectionnee = new Cavalier("noir");
				}
				if (e.getSource()==FouNoir){
					PieceSelectionnee = new Fou("noir");
				}
				if (e.getSource()==RoiNoir){
					PieceSelectionnee = new Roi("noir");
				}
				if (e.getSource()==ReineNoir){
					PieceSelectionnee = new Reine("noir");
				}
				selectionPiece = true ;
				selectionCase = false ;
			}
		}
	}
	
	
	
	public class EcouteurFocus implements FocusListener{		
		public void focusGained(FocusEvent e){			
			((JButton) e.getSource()).setBorderPainted(true);
			((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.red));
		}
		public void focusLost(FocusEvent e){
			if(tab_cases.contains(e.getSource())){
				((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.gray));
			}
			else {
				((JButton) e.getSource()).setBorderPainted(false);
			}		
		}
	}



	
	
	public static void main(String[] args){
		new InterfacePersoEchiquier(new Variantes());
	}
}

