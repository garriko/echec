package interfaceGraphique;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import projet_echec.echec.exception.RoiManquantException;
import projet_echec.echec.jeu.Variantes;


/**
 * 
 * @author Vincent
 * 
 * Fenetre de la popup pour rentrer le nom et la description de notre variante personnalisee
 *
 */

public class InterfacePopupNomVar {
	
	JFrame fenetre;
	Container tmp;
	JButton boutonOK;
	JButton boutonAnnuler;
	JTextField nomVariante;
	JTextArea descVariante;
	
	InterfaceConfigVariante grandMere;
	InterfacePersoEchiquier mere;
	
	Variantes nouvelleVariante;

			
	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupNomVar(InterfaceConfigVariante grandMaman, InterfacePersoEchiquier maman, Variantes laVariante) {
		fenetre=new JFrame("Popup Nom Variante");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		grandMere = grandMaman;
		mere = maman;
		nouvelleVariante = laVariante;
		
		tmp = fenetre.getContentPane();
		boutonOK = new JButton(new ImageIcon("images/PopupNomVar/BoutonOk.png"));
		boutonAnnuler = new JButton(new ImageIcon("images/PopupNomVar/BoutonAnnuler.png"));
		nomVariante = new JTextField("nom");
		descVariante = new JTextArea("rentrez votre description ici");
		
		boutonOK.setBounds(118, 415, 119, 59); //position x, position y, largeur, hauteur
		boutonAnnuler.setBounds(240,415, 143, 59); 
		
		nomVariante.setBounds(75, 93, 345, 50);
		descVariante.setBounds(75, 210, 345, 175);
		descVariante.setAutoscrolls(true);
		
		Ecouteur listen=new Ecouteur();
		boutonOK.addActionListener(listen);
		boutonAnnuler.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/PopupNomVar/popupNomVariante.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(boutonOK);   
		boutonsChoix.add(boutonAnnuler);
		boutonsChoix.add(nomVariante);
		boutonsChoix.add(descVariante);
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(500,525); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==boutonOK){
				grandMere.ajouterVariante(nomVariante.getText());
				grandMere.ajouterDescription(nouvelleVariante, descVariante.getText());
				try {
					nouvelleVariante.saveVariante(nomVariante.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RoiManquantException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fenetre.setVisible(false);
				mere.getFrame().setVisible(false);
			}
			if (e.getSource()==boutonAnnuler){
				fenetre.setVisible(false);
			}
		}
	}
	
	public static void main(String[] args){
		//new InterfacePopupNomVar();
	}
}
