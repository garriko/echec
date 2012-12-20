package interfaceGraphique;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Vincent
 *
 * Fenêtre de l'interface graphique de la popup lorsque un pion arrive au bout de l'échiqier.
 * On lui propose alors de choisir par quelle pièce remplacer son pion
 *
 */

public class InterfacePopupPionBout {
	
	JFrame fenetre;
	Container tmp;
	JButton BoutonOK;
	JComboBox ChoixPieces;

	/**
	 * Constructeur de la classe
	 */
	public InterfacePopupPionBout() {
		fenetre=new JFrame("Popup");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		tmp = fenetre.getContentPane();
		BoutonOK = new JButton(new ImageIcon("images/okSauvegarde.png"));
		ChoixPieces = new JComboBox();
		
		BoutonOK.setBounds(190, 225, 100, 48); //position x, position y, largeur, hauteur
		ChoixPieces.setBounds(170,80,140,41);
		
		Ecouteur listen=new Ecouteur();
		BoutonOK.addActionListener(listen);
		
	
		JPanel boutonsChoix = new TestImagePanel(new ImageIcon("images/InterfacePopupPionBout.png").getImage());
		boutonsChoix.setLayout(null);	 
		
		boutonsChoix.add(BoutonOK);
		
		
		boutonsChoix.add(ChoixPieces);
		ChoixPieces.addItem("Cavalier");
		ChoixPieces.addItem("Tour");
		ChoixPieces.addItem("Fou");
		ChoixPieces.addItem("Reine");
		
	    
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(500,320); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			
			if (ChoixPieces.getSelectedItem()=="Fou"){
				
			}
	    				
			else if (ChoixPieces.getSelectedItem()=="Cavalier"){
				
			}	    		
		
	}
	
	class ItemAction implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    		}
	    	}        
	  }
	
	public static void main(String[] args){
		new InterfacePopupPionBout();
	}
}
