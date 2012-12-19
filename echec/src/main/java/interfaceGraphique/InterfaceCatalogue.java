package interfaceGraphique;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import projet_echec.echec.gestion.Gestion;
import projet_echec.echec.gestion.GestionCatalogueCharger;
import projet_echec.echec.gestion.GestionCatalogueRevoir;
import projet_echec.echec.gestion.GestionJeu;

/**
 * 
 * @author Anne-Sophie
 *
 * Fenêtre du catalogue des parties, utilisée pour 'Revoir une partie' et pour 'Reprendre une partie'
 *
 */

public class InterfaceCatalogue {

	GestionJeu cerveley;
	
	JFrame fenetre;
	Container tmp; 

	
	JList listeVariantes;
	
	
	/**
	 * Constructeur de la classe
	 * 
	 * @param mode : prend la valeur "revoir" ou "reprendre", et indique si l'on affiche le catalogue des
	 * parties à revoir ou à rejouées
	 * 
	 */
	public InterfaceCatalogue(String mode, GestionJeu cerveau) {
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		cerveley = cerveau;
		
		fenetre=new JFrame("Catalogue");
		tmp= fenetre.getContentPane();
		listeVariantes = new JList();
		
		
		/*Bouton1.setBounds(260, 180, 500, 52); //position x, position y, largeur, hauteur
		Bouton2.setBounds(260, 290, 500, 52); 
		Bouton3.setBounds(260, 390, 500, 52);
		Bouton4.setBounds(260, 490, 500, 52);
		Bouton5.setBounds(260, 580, 500, 52);
		*/
		
		//bouton1.setBounds(400, 800, 100, 100);
		/*
		Ecouteur listen=new Ecouteur();
		Bouton1.addActionListener(listen);
		Bouton2.addActionListener(listen);
		Bouton3.addActionListener(listen);
		Bouton4.addActionListener(listen);
		Bouton5.addActionListener(listen);
	*/
		JPanel imageFond;
		if (mode=="revoir"){
			imageFond = new TestImagePanel(new ImageIcon("images/revoirPartie.png").getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT));
		}
		else{
			imageFond = new TestImagePanel(new ImageIcon("images/chargerPartie.png").getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT));
		}
		
		imageFond.setLayout(null);	
		
		//boutonsChoix.add(bouton1);   
		/*
		boutonsChoix.add(Bouton2);
		boutonsChoix.add(Bouton3);   
		boutonsChoix.add(Bouton4);
		boutonsChoix.add(Bouton5);   
		*/
		
		imageFond.add(listeVariantes);
		
		JScrollPane scroll = new JScrollPane(listeVariantes);
		scroll.setPreferredSize(new Dimension(100, 120));
		imageFond.add(scroll);
		scroll.setBounds(149, 297, 465, 337);
		
		Gestion catalogue;
		Vector<String> liste;
		if (mode=="revoir"){
			catalogue = new GestionCatalogueRevoir();
			catalogue.chargerListe();
			liste = catalogue.getListePartie();
		}
		else {
			catalogue = new GestionCatalogueCharger();
			catalogue.chargerListe();
			liste = catalogue.getListePartie();
		}
		
		for (int i=0; i<liste.size(); i++){
			listeVariantes.setListData(liste);
		}
		
		
		
		imageFond.setOpaque(false);
		tmp.add(imageFond);
    
		fenetre.setSize(1000,720); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
		}
	}
	
	public static void main(String[] args){
		
		new InterfaceCatalogue(new String("revoir"), new GestionJeu());
	}

	
}

