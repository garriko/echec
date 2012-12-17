package projet_echec.echec.gestion;

/**
 * Rassemble toutes les informations de la partie
 *  
 * @author Kevin
 * @see Options, Joueur, GestionJeu
 *
 */

public class Partie {
	private Joueur jBlanc;
	private Joueur jNoir;
	private String nomVariante;
	private String deplacement;
	private Options listeOptions;
	
	
	/**
	 * @param jBlanc Joueur 1
	 * @param jNoir	Joueur 2
	 * @param nomVariante Nom de la variante utilisée pour le placement initial
	 * @param listeOptions Liste des options utilisées pour la partie
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
	 * @param dep deplacement effectué ce tour
	 */
	public void ajoutDeplacement(String dep){
		
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
