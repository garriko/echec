package interfaceGraphique;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
	JButton BoutonAppliquer;
	JButton BoutonAnnuler;
	JCheckBox modeAide;
	JSpinner dureeTour;
	
	DataOutputStream dos;
	//DataInputStream dis;

	/**
	 * Constructeur de la classe
	 */
	public InterfaceOptionsMenu() {
	
		fenetre=new JFrame("Menu Principal - Options");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tmp = fenetre.getContentPane();
		
		BoutonAppliquer = new JButton(new ImageIcon("images/boutonAppliquer.png"));
		BoutonAnnuler = new JButton(new ImageIcon("images/boutonAnnulerOptions.png"));
		modeAide = new JCheckBox();
		int duree = 10;
		dureeTour = new JSpinner(new SpinnerNumberModel(duree, duree - 5, duree + 100,5));
		
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
		//modeAide.addActionListener(new StateListener());
		
		boutonsChoix.setOpaque(false);
		tmp.add(boutonsChoix);
    
		fenetre.setSize(1035,700); // taille de l'image de fond
		fenetre.setResizable(false);
		fenetre.setVisible(true);
	}
	
		
	public class Ecouteur implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == BoutonAppliquer){

				try {
					dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("OptionsDefaut.vega"))));
	
					dos.writeInt(((Integer)dureeTour.getValue()).intValue());
					dos.writeBoolean(modeAide.isSelected());
	
					dos.close();
	
					//dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("OptionsDefaut.vega"))));
	
					//System.out.println(dis.readInt());
					//System.out.println(dis.readBoolean());
	
				}
				catch (FileNotFoundException f) {
					f.printStackTrace();
				} 
				catch (IOException f) {
					f.printStackTrace();
				}
	
				//System.out.println( ((Integer)dureeTour.getValue()).intValue() );
				//System.out.println("source : "+ modeAide.isSelected() );
				
				fenetre.setVisible(false);

			}
			else if (e.getSource() == BoutonAnnuler){
				fenetre.setVisible(false);
			}
		}
	}
	/*
	class StateListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

		}
	}
	*/
	public static void main(String[] args){
		new InterfaceOptionsMenu();
	}
}
