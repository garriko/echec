package projet_echec.echec.exception;

import projet_echec.echec.jeu.Variantes;


/**
 * Exception renvoyee si la case contient deja une piece (classe {@link Variantes})
 * @author Kevin
 * @see Exception, {@link Variantes}
 *
 */
public class FullCaseException extends Exception {
	public FullCaseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		// TODO Auto-generated method stub
		return new String("Case déjà occupée");
	}


}
