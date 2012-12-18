package projet_echec.echec.exception;

import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.Variantes;

/**
 * Exception renvoyee si la case selectionnee est vide (dans retirerPiece de {@link Variantes})
 * @author Kevin
 * @see Variantes , {@link Case} , {@link Exception}
 */

public class EmptyCaseException extends Exception{
	
	public EmptyCaseException() {
		super();
		
	}

	public String toString() {
		return new String("Case vide");
	}
}
