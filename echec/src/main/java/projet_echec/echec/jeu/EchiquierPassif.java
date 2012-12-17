package projet_echec.echec.jeu;
/**
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Case, Echiquier
 * Cette classe permet de définir ce qu’il se passe sur l’échiquier lorsque l'on veut revoir une partie.
 */
public class EchiquierPassif extends Echiquier {
	/**
	 * définit le mode de lecture d'une partie ("auto" ou "manuel")
	 */
	String modeLecture;
	/**
	 * lorsque le mode "auto" est activé, cette variable défini le temps de chaque tour.
	 */
	public int cadence;
	
	/**
	 * constructeur
	 * @param fichierCharger
	 */
	public EchiquierPassif(String fichierCharger){
		super();
	}
	
	/**
	 * getter/setter
	 */
	public String getModeLecture() {
		return modeLecture;
	}


	public void setModeLecture(String modeLecture) {
		this.modeLecture = modeLecture;
	}


	public int getCadence() {
		return cadence;
	}


	public void setCadence(int cadence) {
		this.cadence = cadence;
	}

}
