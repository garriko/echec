	package projet_echec.echec.jeu;
/**
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Case
 * Cette classe permet de donné les coordonnés de chaque pièce
 *
 */
public class Position {
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
