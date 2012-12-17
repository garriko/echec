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
	
	// Getters et setters
	
	public int getDureeTourJ1() {
		return dureeTourJ1;
	}
	public void setDureeTourJ1(int dureeTourJ1) {
		this.dureeTourJ1 = dureeTourJ1;
	}
	public int getDureeTourJ2() {
		return dureeTourJ2;
	}
	public void setDureeTourJ2(int dureeTourJ2) {
		this.dureeTourJ2 = dureeTourJ2;
	}
	public boolean isAideJ2() {
		return aideJ2;
	}
	public void setAideJ2(boolean aideJ2) {
		this.aideJ2 = aideJ2;
	}
	public boolean isAideJ1() {
		return aideJ1;
	}
	public void setAideJ1(boolean aideJ1) {
		this.aideJ1 = aideJ1;
	}
	public boolean isRotationEchiquier() {
		return rotationEchiquier;
	}
	public void setRotationEchiquier(boolean rotationEchiquier) {
		this.rotationEchiquier = rotationEchiquier;
	}
	
	
	
}
