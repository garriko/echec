package interfaceGraphique;


//import interfaceGraphique.InterfaceMenu.Ecouteur;

//import interfaceGraphique.InterfaceMenu.Ecouteur;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import projet_echec.echec.gestion.GestionCatalogueVariante;
import projet_echec.echec.jeu.Variantes;

/**
 * 
 * @author Anne-Sophie
 * 
 * Fenêtre de configuration de la variante de jeu
 *
 */

public class InterfaceConfigVariante {

	JFrame fenetre;
	
	Container tmp;
	
	JButton boutonCreer;
	JButton boutonModifier;
	JButton boutonAppliquer;
	JButton boutonRetour;
	JButton boutonSupprimer;
	
	JLabel infos;

	
	JList listeVariantes;
	
	GestionCatalogueVariante catalogue; 
	Vector<String> liste;
	
	InterfaceConfigPartie mere;
	
	
	/**
	 * Constructeur de la classe
	 */
	public InterfaceConfigVariante(InterfaceConfigPartie maman) {
		fenetre=new JFrame("Popup");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tmp = fenetre.getContentPane();
		catalogue = new GestionCatalogueVariante();
		catalogue.chargerListe();		
		liste = catalogue.getListePartie();
		listeVariantes = new JList();
		
		mere=maman;
		
		infos = new JLabel();
		infos.setBounds(800, 300, 209, 152);
		infos.setVisible(true);
		
		boutonCreer = new JButton(new ImageIcon("Images/CatalogueConfigVar/boutonCreer.png"));
		boutonModifier = new JButton(new ImageIcon("Images/CatalogueConfigVar/boutonModifier.png"));
		boutonAppliquer = new JButton(new ImageIcon("Images/CatalogueConfigVar/boutonAppliquer.png"));
		boutonRetour = new JButton(new ImageIcon("Images/CatalogueConfigVar/boutonRetour.png"));
		boutonSupprimer = new JButton(new ImageIcon("Images/CatalogueConfigVar/boutonSupprimer.png"));
		
		boutonCreer.setBounds(452, 462, 109, 45); //position x, position y, largeur, hauteur
		boutonModifier.setBounds(318, 462, 130, 45); 
		boutonAppliquer.setBounds(602, 593, 158, 63);
		boutonRetour.setBounds(770, 593, 143, 63);
		boutonSupprimer.setBounds(159, 462, 155, 45);
		
		
		Ecouteur listen=new Ecouteur();
		boutonCreer.addActionListener(listen);
		boutonModifier.addActionListener(listen);
		boutonAppliquer.addActionListener(listen);
		boutonRetour.addActionListener(listen);
		boutonSupprimer.addActionListener(listen);
		
	
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/CatalogueConfigVar/configVariantes.png").getImage());
		imageFond.setLayout(null);
		
		imageFond.add(boutonCreer);   
		imageFond.add(boutonModifier);
		imageFond.add(boutonAppliquer);   
		imageFond.add(boutonRetour);  
		imageFond.add(boutonSupprimer);
		imageFond.add(infos);
		imageFond.add(listeVariantes);
		
		JScrollPane scroll = new JScrollPane(listeVariantes);
		scroll.setPreferredSize(new Dimension(100, 120));
		imageFond.add(scroll);
		scroll.setBounds(124, 214, 441, 244);
		
		for (int i=0; i<liste.size(); i++){
			listeVariantes.setListData(liste);
		}
		listeVariantes.setSelectedIndex(0);
		
		
		
		imageFond.setOpaque(false);
		tmp.add(imageFond);
    
		fenetre.setSize(1040,700); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
	
	/**
	 * Methode permettant d'ajouter a la liste de variantes la variante creee dans InterfacePersoEchiquier
	 * 
	 * @param v le nom de la variante a ajouter
	 */
	public void ajouterVariante(String v){
		liste.add(v);
		listeVariantes.setListData(liste);
	}
	
	
	public void ajouterDescription(Variantes v, String des){		
		v.setDescription(des);
	}
	
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			/*try {				
				infos.setText(Variantes.recupererDescription((String) listeVariantes.getSelectedValue()));
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			*/	
			
			
			if(e.getSource()==boutonSupprimer){
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
			if (e.getSource()==boutonCreer){
				new InterfacePersoEchiquier(InterfaceConfigVariante.this);
			}
			if (e.getSource()==boutonModifier){
				new InterfacePersoEchiquier((String) listeVariantes.getSelectedValue(), InterfaceConfigVariante.this);			
			}
			if (e.getSource()==boutonAppliquer){
				((InterfaceConfigPartie) mere).appliquerVariante((String) listeVariantes.getSelectedValue());
				fenetre.setVisible(false);
			}
			if (e.getSource()==boutonRetour){
				fenetre.setVisible(false);
			}
		}
	}
	
	public static void main(String[] args){		
		//new InterfaceConfigVariante();
	}

	
}
