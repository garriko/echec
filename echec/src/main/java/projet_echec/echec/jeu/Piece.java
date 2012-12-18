package projet_echec.echec.jeu;

import java.util.ArrayList;

/**
 * Classe abstraite. Gere les proprietes des differents types de piece
 * @author Kevin
 * @see Case, Pion,Fou,Cavalier,Tour,Roi,Reine
 * 
 */


public abstract class Piece {
	/**
	 * Camp de la piece.
	 * Valeurs possibles : "blanc" ou "noir"
	 */
	protected String camp;
	/**
	 * Image correspondant à la pièce et au camp (chemin d'accès
	 */
	private  String img;
	
	
	/**
	 * constructeur
	 * @param camp
	 */
	
	public Piece(String camp,String img){
		this.camp=camp;
		this.img=img;
	}
	/**
	 * Test si le deplacement vers la case c est possible
	 * @param c case a tester
	 * @return vrai si le deplacement est possible, faux sinon
	 */
	protected boolean isDeplacementOk(Case c)
	{
		
		if(c.getPosition().getHauteur() < 1 || c.getPosition().getHauteur() > 8 || c.getPosition().getLargeur() <1 || c.getPosition().getLargeur() > 8)
			return false;
		else
			return true;
		
	}
	
	public abstract ArrayList<Case> getDeplacementPossible(Case caseActuelle);
	
	public String getCamp() {return camp;}
	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	
}
