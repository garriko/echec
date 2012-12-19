package interfaceGraphique;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import projet_echec.echec.exception.GameException;
import projet_echec.echec.gestion.GestionJeu;
import projet_echec.echec.gestion.Joueur;
import projet_echec.echec.gestion.Options;
import projet_echec.echec.gestion.Partie;
import projet_echec.echec.jeu.Echiquier;
import projet_echec.echec.jeu.Variantes;
import projet_echec.echec.wrapper.Wrapper;


/**
 * 
 * @author Anne-Sophie
 *
 * Fenêtre de configuration d'une nouvelle partie
 *
 */

public class InterfaceConfigPartie {

	JFrame fenetre;
	Container tmp;
	Image bouton1 = new ImageIcon("images/boutonModifier.png").getImage().getScaledInstance(156, 40, Image.SCALE_DEFAULT);
	JButton Bouton1 = new JButton(new ImageIcon(bouton1));
	Image bouton2 = new ImageIcon("images/boutonValider.png").getImage().getScaledInstance(125, 45, Image.SCALE_DEFAULT);
	JButton Bouton2 = new JButton(new ImageIcon(bouton2));
	Image bouton3 = new ImageIcon("images/boutonAnnuler.png").getImage().getScaledInstance(125, 45, Image.SCALE_DEFAULT);
	JButton Bouton3 = new JButton(new ImageIcon(bouton3));

	JTextField nomJ1;
	JTextField nomJ2;
	
	JSpinner dureeJ1; 
	JSpinner dureeJ2;
	
	JCheckBox aideJ1;
	JCheckBox aideJ2;
	JCheckBox rotation;
	
	JLabel variante;
	
	GestionJeu cerveley;
	
	
	/**
	 * Constructeur de la classe
	 */
	public InterfaceConfigPartie(GestionJeu cerveau) {	
		fenetre=new JFrame("Configuration de la partie");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tmp = fenetre.getContentPane();
		
		cerveley = cerveau;
		
		variante = new JLabel("classique");
		
		nomJ1 = new JTextField("Joueur 1");
		nomJ2 = new JTextField("Joueur 2");
		aideJ1 = new JCheckBox();
		aideJ2 = new JCheckBox();
		rotation = new JCheckBox();
		
		Bouton1.setBounds(487, 516, 156, 40); //position x, position y, largeur, hauteur
		Bouton2.setBounds(598, 606, 125, 45); 
		Bouton3.setBounds(728, 606, 125, 45);
		nomJ1.setBounds(300,185, 110, 34);
		nomJ2.setBounds(300,325, 110, 34);
		aideJ1.setBounds(777,190, 30, 30);
		aideJ2.setBounds(777,330, 30, 30);
		rotation.setBounds(475, 400, 30, 30);
		aideJ1.setOpaque(false);
		aideJ2.setOpaque(false);
		rotation.setOpaque(false);
		aideJ1.setVisible(true);
		aideJ2.setVisible(true);
		rotation.setVisible(true);
		int duree = 20;
		dureeJ1 = new JSpinner(new SpinnerNumberModel(duree, duree - 5, duree + 100, 5));
		dureeJ1.setBounds(538, 183, 69, 41);
		dureeJ2 = new JSpinner(new SpinnerNumberModel(duree, duree - 5, duree + 100, 5));
		dureeJ2.setBounds(537, 323, 70, 41);
		dureeJ1.setVisible(true);
		dureeJ2.setVisible(true);
		
		variante.setBounds(200, 550, 200, 100);
		variante.setVisible(true);
		
		Ecouteur listen=new Ecouteur();
		Bouton1.addActionListener(listen);
		Bouton2.addActionListener(listen);
		Bouton3.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/configPartie.png").getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT));
		boutonsChoix.setLayout(null);
		
		boutonsChoix.add(Bouton1);   		
		boutonsChoix.add(Bouton2);
		boutonsChoix.add(Bouton3);
		
		
		boutonsChoix.add(nomJ1);	
		boutonsChoix.add(nomJ2);
		
		boutonsChoix.add(aideJ1);
		boutonsChoix.add(aideJ2);
		boutonsChoix.add(rotation);
		boutonsChoix.add(variante);
		boutonsChoix.add(dureeJ1);
		boutonsChoix.add(dureeJ2);
		
		
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
		
		fenetre.setSize(1000,720); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==Bouton1){ //modifier
				new InterfaceConfigVariante();
			}
			if (e.getSource()==Bouton2){ //valider
				Joueur J1 = new Joueur(nomJ1.getText(), aideJ1.isSelected());
				Joueur J2 = new Joueur(nomJ2.getText(), aideJ2.isSelected());
				Options optionsPartie = new Options((Integer) dureeJ1.getValue(), (Integer) dureeJ2.getValue(), aideJ2.isSelected(),
						aideJ1.isSelected(), rotation.isSelected());
				String varianteChoisie = variante.getText();
				Wrapper w = null;
				try {
					w = cerveley.creerNewGame(J1, J2, varianteChoisie, optionsPartie);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (GameException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Partie partie = w.getP();
				Echiquier echiquier = w.getE();
				
				fenetre.setVisible(false);
				new InterfaceJeu(partie, echiquier);
				
			}
			if (e.getSource()==Bouton3){ //annuler
				fenetre.setVisible(false);
				InterfaceMenu pop = new InterfaceMenu(cerveley);
				fenetre.dispose();
			}
		}
	}
	
	public static void main(String[] args){
		new InterfaceConfigPartie(new GestionJeu());
	}

	
}

