package projet_echec.echec.gestion;

/**
 * Rassemble toutes les informations de la partie
 *  
 * @author Kevin
 * @see Options, Joueur, GestionJeu
 *
 */

public class Partie {
	/**
	 * Joueur 1
	 */
	private Joueur jBlanc;
	/**
	 * Joueur 2
	 */
	private Joueur jNoir;
	/**
	 * Nom de la variante utilisee pour le placement initial
	 */
	private String nomVariante;
	/**
	 * Rassemble tout les deplacement de la partie
	 */
	private String deplacement;
	/**
	 * Liste des options utilisees pour la partie
	 */
	private Options listeOptions;
	
	
	/**
	 * @param jBlanc Joueur 1
	 * @param jNoir	Joueur 2
	 * @param nomVariante Nom de la variante utilisee pour le placement initial
	 * @param listeOptions Liste des options utilisees pour la partie
	 */
	public Partie(Joueur jBlanc, Joueur jNoir, String nomVariante,
			Options listeOptions) {
		this.jBlanc = jBlanc;
		this.jNoir = jNoir;
		this.nomVariante = nomVariante;
		this.listeOptions = listeOptions;
		this.deplacement = new String();
	}
	
	/**
	 * Ajoute dep au String deplacement 
	 * @param dep deplacement effectue ce tour
	 */
	public void ajoutDeplacement(String dep){
		String newDepl = this.deplacement.concat(dep);
		this.deplacement=newDepl;
	}
	
	public String lireDeplacement(){
		String depActuel = this.deplacement.substring(0, 5);
		this.deplacement = this.deplacement.substring(6, this.deplacement.length());
		return depActuel;
	}
	
	//Getters et setters
	public Joueur getjBlanc() {
		return jBlanc;
	}

	public void setjBlanc(Joueur jBlanc) {
		this.jBlanc = jBlanc;
	}

	public Joueur getjNoir() {
		return jNoir;
	}

	public void setjNoir(Joueur jNoir) {
		this.jNoir = jNoir;
	}

	public String getNomVariante() {
		return nomVariante;
	}

	public void setNomVariante(String nomVariante) {
		this.nomVariante = nomVariante;
	}

	public Options getListeOptions() {
		return listeOptions;
	}

	public void setListeOptions(Options listeOptions) {
		this.listeOptions = listeOptions;
	}


}
