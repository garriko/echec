package interfaceGraphique;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

/**
 * 
 * @author Vincent
 *
 * Fenêtre de l'interface graphique de l'option, à partir du menu principale
 *
 */

public class InterfaceOptionsMenu {
	
	JFrame fenetre;
	Container tmp;
	JButton BoutonOK;
	JCheckBox modeAide;
	JSpinner dureeTour;

	/**
	 * Constructeur de la classe
	 */
	public InterfaceOptionsMenu() {
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JFrame fenetre=new JFrame("Menu Principale - Option");
		Container tmp = fenetre.getContentPane();
		
		JButton BoutonAppliquer = new JButton(new ImageIcon("images/boutonAppliquer.png"));
		JButton BoutonAnnuler = new JButton(new ImageIcon("images/boutonAnnulerOptions.png"));
		JCheckBox modeAide = new JCheckBox();
		int duree = 10;
		JSpinner dureeTour = new JSpinner(new SpinnerNumberModel(duree, duree - 5, duree + 100,5));
		
		BoutonAppliquer.setBounds(500, 550, 158, 72); //position x, position y, largeur, hauteur
		BoutonAnnuler.setBounds(670, 550, 158, 72);
		dureeTour.setBounds(660, 270, 69, 41);
		modeAide.setBounds(440,360, 30, 30);
		modeAide.setOpaque(false);
		
		Ecouteur listen=new Ecouteur();
		BoutonAppliquer.addActionListener(listen);
		BoutonAnnuler.addActionListener(listen);
		
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/InterfaceMenuOptions.png").getImage());
		boutonsChoix.setLayout(null);	 
		
		boutonsChoix.add(BoutonAppliquer);
		boutonsChoix.add(BoutonAnnuler);
		boutonsChoix.add(modeAide);
		boutonsChoix.add(dureeTour);
		
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(1035,700); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	
	public static void main(String[] args){
		new InterfaceOptionsMenu();
	}
}
