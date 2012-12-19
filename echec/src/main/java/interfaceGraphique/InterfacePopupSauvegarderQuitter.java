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
 * Fenêtre de la popup de demande de sauvegarde lorsque l'utilisateur 
 * quitte une partie en cours
 *
 */

public class InterfacePopupSauvegarderQuitter {
	
	JFrame fenetre;
	Container tmp;
	JButton boutonOUI;
	JButton boutonNON;
	JTextField texte;
	
	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupSauvegarderQuitter() {
		fenetre=new JFrame("Popup");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		tmp = fenetre.getContentPane();
		boutonOUI = new JButton(new ImageIcon("images/oui.png"));
		boutonNON = new JButton(new ImageIcon("images/non.png"));
		texte = new JTextField("sauvegarde");
		
		boutonOUI.setBounds(105, 257, 105, 52); //position x, position y, largeur, hauteur
		boutonNON.setBounds(275, 257, 105, 52); 
		texte.setBounds(22, 145, 375, 40);
		
		Ecouteur listen=new Ecouteur();
		boutonOUI.addActionListener(listen);
		boutonNON.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/sauvegarderQuitter.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(boutonOUI);   
		boutonsChoix.add(boutonNON);
		boutonsChoix.add(texte);
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(503,377); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
		}
	}
	
	public static void main(String[] args){
		new InterfacePopupSauvegarderQuitter();
	}
}
