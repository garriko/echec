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
 * @author Anne-Sophie
 * 
 * Fenêtre de l'interface graphique de la popup de confirmation de suppression 
 * d'une partie ou de la liste d'une partie
 *
 */

public class InterfacePopupSuppression {
	
	JFrame fenetre;
	Container tmp;
	JButton boutonOUI;
	JButton boutonNON;
	
	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupSuppression() {
		fenetre=new JFrame("Popup");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tmp = fenetre.getContentPane();
		boutonOUI = new JButton(new ImageIcon("images/oui.png"));
		boutonNON = new JButton(new ImageIcon("images/non.png"));
		
		boutonOUI.setBounds(105, 175, 105, 52); //position x, position y, largeur, hauteur
		boutonNON.setBounds(275, 175, 105, 52); 
		
		Ecouteur listen=new Ecouteur();
		boutonOUI.addActionListener(listen);
		boutonNON.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/suppression.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(boutonOUI);   
		boutonsChoix.add(boutonNON);
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(507,286); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
		}
	}
	
	public static void main(String[] args){
		new InterfacePopupSuppression();
	}
}