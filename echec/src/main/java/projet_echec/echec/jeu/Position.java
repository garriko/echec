	package projet_echec.echec.jeu;
/**
 * Cette classe permet de donner les coordonnees de chaque case
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Case
 * 
 */
public class Position implements java.io.Serializable {
	/**
	 * donne la position en hauteur de la case sur le plateau
	 */
	int hauteur;
	/**
	 * donne la position en largeur de la case sur le plateau
	 */
	int largeur;
	/**
	 * constructeur
	 * @param hauteur
	 * @param largeur
	 */
	public Position(int hauteur, int largeur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	
	public boolean equals(Position p) {
		if(this.hauteur==p.hauteur && this.largeur==p.largeur)
			return true;
		else
			return false;
	}
	
	/**
	 * getters/setters
	 */
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	

	

}
