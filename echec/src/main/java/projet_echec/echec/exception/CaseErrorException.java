package projet_echec.echec.exception;

import projet_echec.echec.jeu.Variantes;


/**
 * Exception renvoyee si la case contient deja une piece (classe {@link Variantes})
 * @author Kevin
 * @see Exception, {@link Variantes}
 *
 */
public class CaseErrorException extends Exception {

	public CaseErrorException() {
		super();
		
	}
	
	@Override
	public String toString() {
	
		return new String("Case inexistante");
	}
	
}
