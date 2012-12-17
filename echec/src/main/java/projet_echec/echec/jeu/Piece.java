package projet_echec.echec.jeu;

import java.util.ArrayList;

/**
 * 
 * @author Kevin
 * @see Case, Echiquier
 * Cette classe permet de définir ce qu’il se passe sur l’échiquier lorsque l’on veut revoir une partie
 */


public abstract class Piece {
	/**
	 * Camp de la pièce.
	 * Valeurs possibles : "blanc" ou "noir"
	 */
	protected String camp;
	/**
	 * constructeur
	 * @param camp
	 */
	public Piece(String camp){
		this.camp=camp;
	}
	/**
	 * Test si le déplacement vers la case c est possible
	 * @param c case à tester
	 * @return vrai si le déplacement est possible, faux sinon
	 */
	protected boolean isDeplacementOk(Case c)
	{
		if(c.getPosition().getHauteur() < 1 || c.getPosition().getHauteur() > 8 || c.getPosition().getLargeur() <1 || c.getPosition().getLargeur() > 8)
			return false;
		if(c.estVide()&&(c.getPiece().camp==this.camp))
			return true;
		else
			return false;
		
	}
	
	public abstract ArrayList<Case> getDeplacementPossible(Case caseActuelle);
	
	
}
