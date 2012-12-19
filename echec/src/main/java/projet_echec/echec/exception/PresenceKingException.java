package projet_echec.echec.exception;

import projet_echec.echec.gestion.GestionJeu;
import projet_echec.echec.jeu.Variantes;
import projet_echec.echec.wrapper.VariantWrapper;

/**
 * Exception cree on tente de placer un deuxieme roi de la meme couleur
 * @author Kevin
 * @see Variantes, {@link VariantWrapper}
 */
public class PresenceKingException extends Exception{
	/**
	 * 
	 */
	public PresenceKingException() {
		super();
		
	}
	
	@Override
	public String toString() {
	
		return new String("Deja un roi dans ce camp");
	}
}
