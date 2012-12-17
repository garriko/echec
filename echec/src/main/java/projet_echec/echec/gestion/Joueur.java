package projet_echec.echec.gestion;

/**
 * Joueur contient toutes les informations sur les joueurs
 * 
 * 
 * @author Kevin
 * @version 0.0.1
 * @see Partie
 */

public class Joueur {
	private String nom;
	private boolean modeAide;
	
	/**
	 * @param nom nom du joueur
	 * @param modeAide mode aide activé ou non
	 */
	public Joueur(String nom, boolean modeAide) {
		this.setNom(nom);
		this.setModeAide(modeAide);
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the modeAide
	 */
	public boolean isModeAide() {
		return modeAide;
	}

	/**
	 * @param modeAide the modeAide to set
	 */
	public void setModeAide(boolean modeAide) {
		this.modeAide = modeAide;
	}
	
	
	
}
