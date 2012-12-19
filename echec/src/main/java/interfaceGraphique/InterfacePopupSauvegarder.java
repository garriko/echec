package interfaceGraphique;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Anne-Sophie
 * 
 * Fenêtre de la popup de confirmation de sauvegarde d'une partie
 *
 */

public class InterfacePopupSauvegarder {
	
	JFrame fenetre;
	Container tmp;
	JButton boutonOK;
	JButton boutonAnnuler;
	JTextField texte;
	
	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupSauvegarder() {
		fenetre=new JFrame("Popup");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		tmp = fenetre.getContentPane();
		boutonOK = new JButton(new ImageIcon("images/okSauvegarde.png"));
		boutonAnnuler = new JButton(new ImageIcon("images/annulerSauvegarde.png"));
		texte = new JTextField("sauvegarde");
		
		boutonOK.setBounds(105, 195, 103, 50); //position x, position y, largeur, hauteur
		boutonAnnuler.setBounds(275, 195, 150, 50); 
		texte.setBounds(22, 78, 375, 40);
		
		Ecouteur listen=new Ecouteur();
		boutonOK.addActionListener(listen);
		boutonAnnuler.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/sauvegarde.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(boutonOK);   
		boutonsChoix.add(boutonAnnuler);
		boutonsChoix.add(texte);
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(507,310); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
		}
	}
	
	public static void main(String[] args){
		new InterfacePopupSauvegarder();
	}
}
