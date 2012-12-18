package projet_echec.echec.exception;

import projet_echec.echec.gestion.GestionJeu;


/**
 * Exception cree si trop de parties sont jouees en meme temps
 * @author Kevin
 * @see GestionJeu
 */
public class GameException extends Exception {

	/**
	 * 
	 */
	public GameException() {
		super();
		
	}
	
	@Override
	public String toString() {
	
		return new String("Le nombre de parties simultanees est deja atteint");
	}
	
}
