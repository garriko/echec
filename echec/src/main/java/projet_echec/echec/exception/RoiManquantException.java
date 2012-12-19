package projet_echec.echec.exception;

import projet_echec.echec.gestion.GestionJeu;
import projet_echec.echec.jeu.Variantes;


/**
 * Exception cree s'il manque un roi sur l'echiquier (personnalisation)
 * @author Kevin
 * @see Variantes ,  Roi
 */
public class RoiManquantException extends Exception {
	/**
	 * 
	 */
	public RoiManquantException() {
		super();
		
	}
	
	@Override
	public String toString() {
	
		return new String("Il n'y pas assez de rois pour enregistrer la variante");
	}
}
