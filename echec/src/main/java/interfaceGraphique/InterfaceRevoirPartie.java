package interfaceGraphique;

import interfaceGraphique.InterfaceConfigPartie.Ecouteur;
import interfaceGraphique.InterfaceJeu.CountdownTimerListener;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;

import projet_echec.echec.exception.DeplacementException;
import projet_echec.echec.gestion.Partie;
import projet_echec.echec.gestion.SaveGame;
import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.EchiquierActif;
import projet_echec.echec.jeu.Position;
import projet_echec.echec.wrapper.Wrapper;


/**
 * 
 * @author Anne-Sophie
 *
 * Fênetre lors du replay d'une partie
 *
 */

public class InterfaceRevoirPartie {

	JFrame fenetre;
	Container tmp;
	Image boutonLect;
	JButton BoutonLect;
	Image boutonPause;
	JButton BoutonPause ;
	
	int cad;
	JSpinner cadence ;
	JComboBox modeLecture;
	
	Collection<JLabel> tab_cases;
	
	Wrapper w;
	Partie p;
	EchiquierActif plateauJeu;
	
	Timer countdown; 
	int timeRemaining;
	
	
	/**
	 * Constructeur de la classe
	 */
	public InterfaceRevoirPartie(String nomPartie) {
		fenetre=new JFrame("Replay");
		tmp = fenetre.getContentPane();
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		try {
			w = SaveGame.charger(nomPartie);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = w.getP();
		plateauJeu = (EchiquierActif) w.getE();
		
		
		boutonLect = new ImageIcon("images/interface_revoirpartieBoutonLecture.png").getImage().getScaledInstance(92, 64, Image.SCALE_DEFAULT);
		BoutonLect = new JButton(new ImageIcon(boutonLect));
		boutonPause = new ImageIcon("images/interface_revoirpartieBoutonPause.png").getImage().getScaledInstance(92, 65, Image.SCALE_DEFAULT);
		BoutonPause = new JButton(new ImageIcon(boutonPause));
		
		cad = 1;
		cadence = new JSpinner(new SpinnerNumberModel(cad, cad - 0, cad + 50,1));
		modeLecture = new JComboBox();
		
		
		BoutonLect.setBounds(85, 590, 92, 64); //position x, position y, largeur, hauteur
		BoutonPause.setBounds(180, 590, 92, 65); 
		modeLecture.setBounds(430,597,140,41);
		cadence.setBounds(760, 597, 69, 41);
		cadence.setVisible(true);
		modeLecture.setVisible(true);
		
		Ecouteur listen=new Ecouteur();
		BoutonLect.addActionListener(listen);
		BoutonPause.addActionListener(listen);
		
		
		// Initialisation de l'échiquier
		tab_cases = new Vector<JLabel>	();	
		
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
				
				if (j%2==0){
					
					if (i%2==0){
						tab_cases.add(new JLabel(new ImageIcon("images/caseblanche.png")));
					}
					else {
						tab_cases.add(new JLabel(new ImageIcon("images/casegrise.png")));
					}
				}
				else {
					if (i%2==1){
						tab_cases.add(new JLabel(new ImageIcon("images/caseblanche.png")));
					}
					else {
						tab_cases.add(new JLabel(new ImageIcon("images/casegrise.png")));
					}			
				}
				((Vector<JLabel>) tab_cases).get(i).setPreferredSize(new Dimension(45,45));
			}
		}
		
		
		
		
		JPanel plateau = new JPanel();
		plateau.setLayout(new GridLayout(8,8));
	
		plateau.setBounds(505,90,360,360);		
		
		
		for (int i=0; i<64 ; i++){
			plateau.add(((Vector<JLabel>) tab_cases).get(i));
			//((Vector<JButton>) tab_cases).get(i).setBorder(BorderFactory.createLineBorder(Color.gray));
		}		
		
		
		
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/interfaceRevoirPartie.png").getImage().getScaledInstance(1035, 700, Image.SCALE_DEFAULT));
		imageFond.setLayout(null);
		
		imageFond.add(plateau);
		
		
		timeRemaining = (Integer) cadence.getValue(); 		
		countdown = new Timer(1000, new CountdownTimerListener()); // On crée le timer
		countdown.start(); //Démarrer le compteur
	
		
		imageFond.add(BoutonLect);   		
		imageFond.add(BoutonPause);
		imageFond.add(cadence);
		imageFond.add(modeLecture);
		
		modeLecture.addItem("Continue");
	    modeLecture.addItem("Pas à pas");

		
		
		imageFond.setOpaque(false);
		tmp.add(imageFond);
    
		fenetre.setSize(1035,720); // taille de l'image de fond
		fenetre.setResizable(false);
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
		((Vector<JLabel>) tab_cases).get(numCase).setIcon(new ImageIcon(NewCase.getImg()));
	}
	
	
	public void deplacementSuivant(){
		String dep = p.lireDeplacement();
		Case caseDepart = plateauJeu.chercherCase(new Position(Integer.parseInt(String.valueOf(dep.charAt(0))), Integer.parseInt(String.valueOf(dep.charAt(1)))));
		Case caseArrivee = plateauJeu.chercherCase(new Position(Integer.parseInt(String.valueOf(dep.charAt(3))), Integer.parseInt(String.valueOf(dep.charAt(4)))));
		try {
			plateauJeu.selectionnerCase(caseDepart);
		} catch (DeplacementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			plateauJeu.selectionnerCase(caseArrivee);
		} catch (DeplacementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0; i<plateauJeu.getPlateau().size(); i++){						
			actualiserImage(plateauJeu.getPlateau().get(i));
		}		
	}
	
	public void play(){
		countdown.restart();
	}
	
	public void pause(){
		countdown.stop();
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (((String) modeLecture.getSelectedItem()).equals(new String("Pas à pas"))){	
				if (e.getSource()==BoutonLect){
					deplacementSuivant();
				}
			}
			else {
				if (e.getSource()==BoutonLect){
					play();
				}
				if (e.getSource()==BoutonPause){
					pause();
				}
			}
		}
	}
	
	
	
	class CountdownTimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (--timeRemaining >= 0) {
				countdown.start();
			} 
			else {
				countdown.stop();
				deplacementSuivant();
				timeRemaining = (Integer) cadence.getValue();
				countdown.start();
			}
			
				
			
		}
	}
	
	
	
	public static void main(String[] args){
		//new InterfaceRevoirPartie();
	}

	
}

