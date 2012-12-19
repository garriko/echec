package interfaceGraphique;

import interfaceGraphique.InterfacePopupSuppression.Ecouteur;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Anne-Sophie
 *
 * Fenêtre de la popup de réglage des options (aide)
 *
 */

public class InterfacePopupOptions {

	JFrame fenetre;
	Container tmp;
	JButton boutonAppliquer;
	JButton boutonAnnuler;
	JCheckBox aideJ1;
	JCheckBox aideJ2;
	
	
	
	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupOptions() {
		fenetre=new JFrame("Options");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		tmp = fenetre.getContentPane();
		boutonAppliquer = new JButton(new ImageIcon("images/boutonAppliquer.png"));
		boutonAnnuler = new JButton(new ImageIcon("images/boutonAnnulerOptions.png"));
		aideJ1 = new JCheckBox();
		aideJ2 = new JCheckBox();
		
		boutonAppliquer.setBounds(112, 282, 158, 72); //position x, position y, largeur, hauteur
		boutonAnnuler.setBounds(292, 282, 158, 72); 
		aideJ1.setBounds(252,123, 30, 30);
		aideJ2.setBounds(252,187, 30, 30);
		aideJ1.setOpaque(false);
		aideJ2.setOpaque(false);
		aideJ1.setVisible(true);
		aideJ2.setVisible(true);
		
		Ecouteur listen=new Ecouteur();
		boutonAppliquer.addActionListener(listen);
		boutonAnnuler.addActionListener(listen);
				
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/popupOptions.png").getImage());
		boutonsChoix.setLayout(null);	 
		boutonsChoix.add(boutonAppliquer);   
		boutonsChoix.add(boutonAnnuler);
		boutonsChoix.add(aideJ1);   
		boutonsChoix.add(aideJ2);
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(505,433); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
		}
	}
	
	public static void main(String[] args){
		new InterfacePopupOptions();
	}
}
