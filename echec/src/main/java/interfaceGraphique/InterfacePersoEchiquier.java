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

	Variantes nouvelleVariante = new Variantes();
	
	JFrame fenetre=new JFrame("Jeu d'échecs");
	Container tmp = fenetre.getContentPane();
	Collection<JButton> tab_cases = new Vector<JButton>();
	
	Image ok = new ImageIcon("images/partiepersoBoutonOK.png").getImage();
	JButton boutonOK = new JButton(new ImageIcon(ok));
	Image annuler = new ImageIcon("images/partiepersoBoutonAnnuler.png").getImage();
	JButton boutonAnnuler = new JButton(new ImageIcon(annuler));
	
	JButton PionBlanc = new JButton(new ImageIcon("images/Pieces/pasAuto/121.png"));
	JButton TourBlanc = new JButton(new ImageIcon("images/Pieces/pasAuto/122.png"));
	JButton CavalierBlanc = new JButton(new ImageIcon("images/Pieces/pasAuto/123.png"));
	JButton FouBlanc = new JButton(new ImageIcon("images/Pieces/pasAuto/124.png"));
	JButton RoiBlanc = new JButton(new ImageIcon("images/Pieces/pasAuto/125.png"));
	JButton ReineBlanc = new JButton(new ImageIcon("images/Pieces/pasAuto/126.png"));
	
	JButton PionNoir = new JButton(new ImageIcon("images/Pieces/pasAuto/221.png"));
	JButton TourNoir = new JButton(new ImageIcon("images/Pieces/pasAuto/222.png"));
	JButton CavalierNoir = new JButton(new ImageIcon("images/Pieces/pasAuto/223.png"));
	JButton FouNoir = new JButton(new ImageIcon("images/Pieces/pasAuto/224.png"));
	JButton RoiNoir = new JButton(new ImageIcon("images/Pieces/pasAuto/225.png"));
	JButton ReineNoir = new JButton(new ImageIcon("images/Pieces/pasAuto/226.png"));
	
	
	Case CaseSelectionnee = new Case(null);
	Piece PieceSelectionnee = new Pion("blanc");
	boolean selectionPiece = false;
	boolean selectionCase = false;
	
	
	
	
	/**
	 * Constructeur sans parametre
	 */
	public InterfacePersoEchiquier() {
		
		
		// fond d'écran
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/partieperso.png").getImage());
		
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
		
		tmp.add(imageFond);
		fenetre.setSize(1030,700); 
		fenetre.setResizable(false);
		fenetre.setVisible(true);
		
	}
	
	
	

	
	
	
	
	
	public void actualiserImage(Case NewCase){
		int numCase = NewCase.getPosition().getLargeur() + 8*(NewCase.getPosition().getHauteur()-1);			
		((Vector<JButton>) tab_cases).get(numCase).setIcon(new ImageIcon(NewCase.getImg()));
	}
		
	
	
	
	
	public class EcouteurAction implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==boutonOK){
				nouvelleVariante.saveVariante("maVariante");
			}
			else if (e.getSource()==boutonAnnuler){
				
			}
			else if (tab_cases.contains(e.getSource())){
				int numCase = 64-(((Vector<JButton>) tab_cases).indexOf(e.getSource())-1);
				int largeur = numCase%8;
				int hauteur = numCase/8;
				Case eCase = new Case(new Position(hauteur, largeur));
				
				if ((eCase.estVide()==false) && (selectionPiece==false)){ // si case occupée et pas de pièce retenue
					CaseSelectionnee = eCase ; // la case est retenue
					selectionCase = true ;
				}
				else if ((eCase.estVide()==false) && (selectionPiece==true)){ // si case occupée et pièce retenue
					nouvelleVariante.ajouterPiece(eCase, PieceSelectionnee) ;
					// on change la pièce
					actualiserImage(eCase);
					selectionPiece = false;
				}
				else if ((eCase.estVide()==true) && (selectionPiece==true)){ // si case vide et pièce retenue
					nouvelleVariante.ajouterPiece(eCase, PieceSelectionnee);
					// on place la pièce
					actualiserImage(eCase);
					selectionPiece = false;
				}
				else if (selectionCase == true){ // si case retenue
					nouvelleVariante.ajouterPiece(eCase, CaseSelectionnee.getPiece()) ;
					// on change la pièce
					nouvelleVariante.retirerPiece(CaseSelectionnee) ;
					// On la retire la la première case
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
				selectionCase=false ;
			}
		}
	}
	



	
	
	public static void main(String[] args){
		new InterfacePersoEchiquier();
	}
}

