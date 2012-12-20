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
 * Fenêtre de l'interface graphique de la popup lançant un message d'erreur 
 * lorsque l'utilisateur tente d'ouvrir plus de quatre parties simultanément.
 *
 */

public class InterfacePopupErreur4 {
	
	JFrame fenetre;
	Container tmp;
	JButton boutonOK;

	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupErreur4() {
		fenetre=new JFrame("Popup");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tmp = fenetre.getContentPane();
		boutonOK = new JButton(new ImageIcon("images/ok.png"));
		boutonOK.setBounds(150, 215, 160, 76); //position x, position y, largeur, hauteur
		
		Ecouteur listen=new Ecouteur();
		boutonOK.addActionListener(listen);
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/erreur.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(boutonOK);   
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(507,376); // taille de l'image de fond
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
		new InterfacePopupErreur4();
	}
}

