package projet_echec.echec.jeu;

import java.io.IOException;


/**
 * Cette classe permet de definir ce qu’il se passe sur l’echiquier lorsque l'on veut revoir une partie.
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Case, Echiquier 
 */
public class EchiquierPassif extends Echiquier {
	/**
	 * definit le mode de lecture d'une partie ("auto" ou "manuel")
	 */
	String modeLecture;
	/**
	 * lorsque le mode "auto" est active, cette variable defini le temps de chaque tour.
	 */
	public int cadence;
	
	/**
	 * constructeur
	 * @param fichierCharger
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public EchiquierPassif(String fichierCharger) throws ClassNotFoundException, IOException{
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
