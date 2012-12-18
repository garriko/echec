package projet_echec.echec.gestion;

/**
 * Options centralise toutes les options pour une partie.
 * 
 * 
 * @author Kevin
 * @see Partie
 * @version 0.0.1
 *
 */

public class Options {
	private int dureeTourJ1;
	private int dureeTourJ2;
	private boolean aideJ2;
	private boolean aideJ1;
	private boolean rotationEchiquier;
	/**
	 * @param dureeTourJ1
	 * @param dureeTourJ2
	 * @param aideJ2
	 * @param aideJ1
	 * @param rotationEchiquier
	 */
	public Options(int dureeTourJ1, int dureeTourJ2, boolean aideJ2,
		boolean aideJ1, boolean rotationEchiquier) {
		this.dureeTourJ1 = dureeTourJ1;
		this.dureeTourJ2 = dureeTourJ2;
		this.aideJ2 = aideJ2;
		this.aideJ1 = aideJ1;
		this.rotationEchiquier = rotationEchiquier;
	}
	
	
	/**
	 * Getter
	 * @return duree du tour du joueur 1
	 */
	public int getDureeTourJ1() {
		return dureeTourJ1;
	}
	/**
	 * 
	 * @param dureeTourJ1 duree du tour a affecter pour le joueur 1
	 */
	public void setDureeTourJ1(int dureeTourJ1) {
		this.dureeTourJ1 = dureeTourJ1;
	}
	/**
	 * Getter
	 * @return duree du tour du joueur 1
	 */
	public int getDureeTourJ2() {
		return dureeTourJ2;
	}
	/**
	 * 
	 * @param dureeTourJ1 duree du tour a affecter pour le joueur 2
	 */
	public void setDureeTourJ2(int dureeTourJ2) {
		this.dureeTourJ2 = dureeTourJ2;
	}
	/**
	 * vrai si le mode aide est active pour le joueur 1, faux sinon
	 * @return boolean
	 */
	public boolean isAideJ2() {
		return aideJ2;
	}
	/**
	 * set aideJ2
	 * @param aideJ2 valeur a affecter
	 */
	public void setAideJ2(boolean aideJ2) {
		this.aideJ2 = aideJ2;
	}
	/**
	 * vrai si le mode aide est active pour le joueur 1, faux sinon
	 * @return boolean
	 */
	public boolean isAideJ1() {
		return aideJ1;
	}
	/**
	 * set aideJ1
	 * @param aideJ1 valeur a affecter
	 */
	public void setAideJ1(boolean aideJ1) {
		this.aideJ1 = aideJ1;
	}
	/**
	 * vrai si la rotation de l'echiquier a ete coche
	 * @return un booleen
	 */
	public boolean isRotationEchiquier() {
		return rotationEchiquier;
	}
	/**
	 * set rotation de l'echiquier
	 * @param rotationEchiquier vrai pour activer, faux pour desactiver
	 */
	public void setRotationEchiquier(boolean rotationEchiquier) {
		this.rotationEchiquier = rotationEchiquier;
	}
	
	
	
}
