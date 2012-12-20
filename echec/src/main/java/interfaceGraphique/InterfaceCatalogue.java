package interfaceGraphique;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import projet_echec.echec.gestion.SaveGame;
import projet_echec.echec.wrapper.Wrapper;

/**
 * 
 * @author Anne-Sophie
 *
 * Fenêtre du catalogue des parties, utilisée pour 'Revoir une partie' et pour 'Reprendre une partie'
 *
 */

public class InterfaceCatalogue {
	
	JFrame fenetre;
	Container tmp; 

	String choix;
	
	Gestion catalogue;
	JList listeVariantes;
	Vector<String> liste;
	
	JButton boutonRetour;
	JButton boutonCharger;
	JButton boutonSupprimerPartie;
	JButton boutonSupprimerListe;
	
	
	/**
	 * Constructeur de la classe
	 * 
	 * @param mode : prend la valeur "revoir" ou "reprendre", et indique si l'on affiche le catalogue des
	 * parties à revoir ou à rejouées
	 * 
	 */
	public InterfaceCatalogue(String mode) {
		
		fenetre=new JFrame("Catalogue");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tmp= fenetre.getContentPane();
		listeVariantes = new JList();
		
		choix = mode;
		
		boutonRetour = new JButton(new ImageIcon("images/catalogue/boutonRetour.png"));
		boutonCharger = new JButton(new ImageIcon("images/catalogue/boutonChargerPartie.png"));
		boutonSupprimerPartie = new JButton(new ImageIcon("images/catalogue/boutonSupprimerPartie.png"));
		boutonSupprimerListe = new JButton(new ImageIcon("images/catalogue/boutonSupprimerListe.png"));
		
		
		boutonRetour.setBounds(780, 595, 148, 63); //position x, position y, largeur, hauteur
		boutonCharger.setBounds(676, 307, 238, 69); 
		boutonSupprimerPartie.setBounds(676, 375, 238, 69);
		boutonSupprimerListe.setBounds(676, 442, 238, 69);
		
		
		Ecouteur listen=new Ecouteur();
		boutonRetour.addActionListener(listen);
		boutonCharger.addActionListener(listen);
		boutonSupprimerPartie.addActionListener(listen);
		boutonSupprimerListe.addActionListener(listen);

	
		JPanel imageFond;
		if (mode=="revoir"){
			imageFond = new TestImagePanel(new ImageIcon("images/catalogue/revoirPartie.png").getImage());
		}
		else{
			imageFond = new TestImagePanel(new ImageIcon("images/catalogue/reprendrePartie.png").getImage());
		}
		
		imageFond.setLayout(null);	
		
		imageFond.add(boutonRetour);   		
		imageFond.add(boutonCharger);
		imageFond.add(boutonSupprimerPartie);   
		imageFond.add(boutonSupprimerListe);
		
		
		imageFond.add(listeVariantes);
		
		JScrollPane scroll = new JScrollPane(listeVariantes);
		scroll.setPreferredSize(new Dimension(100, 120));
		imageFond.add(scroll);
		scroll.setBounds(149, 297, 465, 337);
		
		if (choix=="revoir"){
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
		listeVariantes.setSelectedIndex(0);

		
		
		imageFond.setOpaque(false);
		tmp.add(imageFond);
    
		fenetre.setSize(1035,700); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==boutonCharger){
				if (choix=="revoir"){
					new InterfaceRevoirPartie((String) listeVariantes.getSelectedValue());
				}
				else {
					Wrapper w = null;
					try {
						w = SaveGame.charger((String) listeVariantes.getSelectedValue());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					new InterfaceJeu(w.getP(), w.getE());
				}
			}
			else if (e.getSource()==boutonSupprimerPartie){
				try {
					catalogue.supprimerPartie((String) listeVariantes.getSelectedValue());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				liste.removeAllElements();
				catalogue.chargerListe();
				liste = catalogue.getListePartie();
				listeVariantes.setListData(liste);
			}
			else if (e.getSource()==boutonSupprimerListe){
				for (int i=0; i<liste.size(); i++){
					try {
						catalogue.supprimerPartie(liste.get(i));
					} 
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
				}
				//catalogue.chargerListe();
				//liste = catalogue.getListePartie();
				liste.removeAllElements();			
				listeVariantes.setListData(liste);
			}
			else if (e.getSource()==boutonRetour){
				fenetre.setVisible(false);
				new InterfaceMenu();
			}
		}
	}
	
	public static void main(String[] args){
		
		new InterfaceCatalogue(new String("revoir"));
	}

	
}

