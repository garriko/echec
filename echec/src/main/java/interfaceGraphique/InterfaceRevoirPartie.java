package interfaceGraphique;

import interfaceGraphique.InterfaceConfigPartie.Ecouteur;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;


/**
 * 
 * @author Vincent
 *
 * Fênetre lors du replay d'une partie
 *
 */

public class InterfaceRevoirPartie {

	JFrame fenetre;
	Container tmp;
	Image boutonLect;
	JButton BoutonLect;
	Image boutonPause;
	JButton BoutonPause ;
	
	int cad;
	JSpinner cadence ;
	JComboBox modeLecture;
	
	JLabel mode;
	
	
	/**
	 * Constructeur de la classe
	 */
	public InterfaceRevoirPartie() {
		fenetre=new JFrame("Replay");
		tmp = fenetre.getContentPane();
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		boutonLect = new ImageIcon("images/interface_revoirpartieBoutonLecture.png").getImage().getScaledInstance(92, 64, Image.SCALE_DEFAULT);
		BoutonLect = new JButton(new ImageIcon(boutonLect));
		boutonPause = new ImageIcon("images/interface_revoirpartieBoutonPause.png").getImage().getScaledInstance(92, 65, Image.SCALE_DEFAULT);
		BoutonPause = new JButton(new ImageIcon(boutonPause));
		
		cad = 1;
		cadence = new JSpinner(new SpinnerNumberModel(cad, cad - 0, cad + 50,1));
		modeLecture = new JComboBox();
		
		mode = new JLabel();
		
		BoutonLect.setBounds(85, 590, 92, 64); //position x, position y, largeur, hauteur
		BoutonPause.setBounds(180, 590, 92, 65); 
		modeLecture.setBounds(430,597,140,41);
		cadence.setBounds(760, 597, 69, 41);
		cadence.setVisible(true);
		modeLecture.setVisible(true);
		
		Ecouteur listen=new Ecouteur();
		BoutonLect.addActionListener(listen);
		BoutonPause.addActionListener(listen);
		
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/interfaceRevoirPartie.png").getImage().getScaledInstance(1035, 700, Image.SCALE_DEFAULT));
		boutonsChoix.setLayout(null);
		
		boutonsChoix.add(BoutonLect);   		
		boutonsChoix.add(BoutonPause);
		boutonsChoix.add(mode);
		boutonsChoix.add(cadence);
		boutonsChoix.add(modeLecture);
		
		modeLecture.addItem("Continue");
	    modeLecture.addItem("Pas à pas");

		
		
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(1035,720); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
		}
	}
	
	public static void main(String[] args){
		new InterfaceRevoirPartie();
	}

	
}

