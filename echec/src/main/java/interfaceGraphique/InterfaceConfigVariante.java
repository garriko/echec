package interfaceGraphique;

import interfaceGraphique.InterfaceMenu.Ecouteur;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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

	JFrame fenetre=new JFrame("Popup");
	
	Container tmp = fenetre.getContentPane();
	
	JButton boutonCreer;
	JButton boutonModifier;
	JButton boutonAppliquer;
	JButton boutonRetour;

	
	JList listeVariantes = new JList();
	
	GestionCatalogueVariante catalogue; 
	
	
	
	/**
	 * Constructeur de la classe
	 */
	public InterfaceConfigVariante() {
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		catalogue = new GestionCatalogueVariante();
		catalogue.chargerListe();
		Vector<String> liste = catalogue.getListePartie();
		
		boutonCreer = new JButton("créer");
		boutonModifier = new JButton("modifier");
		boutonAppliquer = new JButton("appliquer");
		boutonRetour = new JButton("retour");
		
		boutonCreer.setBounds(100, 600, 200, 52); //position x, position y, largeur, hauteur
		boutonModifier.setBounds(350, 600, 200, 52); 
		boutonAppliquer.setBounds(600, 600, 200, 52);
		boutonRetour.setBounds(850, 600, 200, 52);
		
		
		Ecouteur listen=new Ecouteur();
		boutonCreer.addActionListener(listen);
		boutonModifier.addActionListener(listen);
		boutonAppliquer.addActionListener(listen);
		boutonRetour.addActionListener(listen);
		
	
		JPanel imageFond = new TestImagePanel(new ImageIcon("images/configVariantes.png").getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT));
		imageFond.setLayout(null);
		
		imageFond.add(boutonCreer);   
		imageFond.add(boutonModifier);
		imageFond.add(boutonAppliquer);   
		imageFond.add(boutonRetour);  
		
		imageFond.add(listeVariantes);
		
		JScrollPane scroll = new JScrollPane(listeVariantes);
		scroll.setPreferredSize(new Dimension(100, 120));
		imageFond.add(scroll);
		scroll.setBounds(120, 250, 465, 260);
		
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
			if (e.getSource()==boutonCreer){
				Variantes v = new Variantes();
				new InterfacePersoEchiquier(v);
			}
			if (e.getSource()==boutonModifier){
							
			}
			if (e.getSource()==boutonAppliquer){
				
			}
			if (e.getSource()==boutonRetour){
				
			}
		}
	}
	
	public static void main(String[] args){		
		new InterfaceConfigVariante();
	}

	
}
