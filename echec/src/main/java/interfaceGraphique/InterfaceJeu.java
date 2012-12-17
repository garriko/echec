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


public class InterfaceJeu {
	
	JFrame fenetre=new JFrame("InterfaceDeJeu");
	Container tmp = fenetre.getContentPane();
	Collection<JButton> tab_cases = new Vector<JButton>();
	
	JMenuBar barreMenu = new JMenuBar();
	
	JMenu boutonPartie = new JMenu();
	JMenuItem boutonNouvellepartie = new JMenuItem();
	JMenuItem boutonSauvegarder = new JMenuItem();
	JMenuItem boutonChargerPartie = new JMenuItem();
	JMenuItem boutonOptions = new JMenuItem();
	JMenuItem boutonAffichage = new JMenuItem();
	JMenuItem boutonRevenirMenu = new JMenuItem();
	JMenuItem boutonQuitter = new JMenuItem();
	
	JMenu boutonQuestion = new JMenu();
	JMenuItem boutonAide = new JMenuItem();
	JMenuItem boutonAProposDe = new JMenuItem();
	
	//Case CaseSelectionnee = new Case();
	
	
	public InterfaceJeu() {
		
		
	
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/interface_jeu.png").getImage());
	/*	
		for (int i=0; i<64; i=i+2){
			tab_cases.add(new JButton((new ImageIcon("images/casegrise.png"))));
		}
		
		for (int i=1; i<64; i=i+2){
			tab_cases.add(new JButton((new ImageIcon("images/caseblanche.png"))));
		}
		
	*/
		
		for (int i=0; i<8; i++){
			for (int j=0; j<8; j++){
			
				if (j%2==0){
				
					if (i%2==0){
						tab_cases.add(new JButton((new ImageIcon("images/casegrise.png"))));
					}
					else {
						tab_cases.add(new JButton((new ImageIcon("images/caseblanche.png"))));
					}
				}
				else {
					if (i%2==1){
						tab_cases.add(new JButton((new ImageIcon("images/casegrise.png"))));
					}
					else {
						tab_cases.add(new JButton((new ImageIcon("images/caseblanche.png"))));
					}
				}
				
				((Vector<JButton>) tab_cases).get(i).setPreferredSize(new Dimension(56,56));	
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
		fenetre.setSize(1030,677); 
		fenetre.setResizable(false);
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






