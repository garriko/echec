package projet_echec.echec.exception;

import projet_echec.echec.jeu.Case;

/**
 * Exception renvoyee si le deplacement de la piece selectionnee est impossible
 * @author Kevin
 * @see Echiquier, EchiquierActif , {@link Case}, {@link Exception}
 */

public class DeplacementException extends Exception{

	/**
	 * 
	 */
	public DeplacementException() {
		super();
		
	}

	public String toString() {
		return new String("Deplacement impossible");
	}


}
