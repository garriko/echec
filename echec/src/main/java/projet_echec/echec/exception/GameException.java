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
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new String("Le nombre de parties simultanees est deja atteint");
	}
	
}
