package interfaceGraphique;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Vincent
 *
 * Fenêtre de l'interface graphique de la Popup à Propos De.
 *
 */

public class InterfaceAProposDe {
	
	JFrame fenetre;
	Container tmp;
	JButton boutonOK;


	/**
	 * Constructeur de la classe
	 */
	public InterfaceAProposDe() {
		
		fenetre=new JFrame("à propos De");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tmp = fenetre.getContentPane();
		boutonOK = new JButton(new ImageIcon("images/PopupAProposDe/PopupAproposDeBoutonOk.png"));
		boutonOK.setBounds(170, 240, 158, 74); //position x, position y, largeur, hauteur
		
		Ecouteur listen=new Ecouteur();
		boutonOK.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/PopupAProposDe/PopupAProposDe.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(boutonOK);   
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(500,370); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==boutonOK){
				fenetre.setVisible(false);
			}
		}
	}
	
	public static void main(String[] args){
		
	}
}
