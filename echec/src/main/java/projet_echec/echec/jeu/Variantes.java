package projet_echec.echec.jeu;

import java.util.Vector;

/**
 * Cette classe gere les placements initiaux des pieces.
 * @author Kevin
 * @version 0.0.1
 * @see Case
 *  
 */


public class Variantes {

	private Vector<Case> plateau;
	private Vector<Case> listePieces;
	
	/**
	 * Constructeur par defaut de la classe Variantes
	 * Initialise le plateau et la liste des pieces.
	 * A utiliser pour creer une variante.
	 * 
	 */
	public Variantes() {
		
	}
	
	/**
	 * Constructeur de la classe Variantes
	 * Initialise le plateau et la liste des pieces selon la variante choisie
	 * 
	 * @param nomVariante nom de la variante choisie
	 */
	public Variantes(String nomVariante){
		
	}
	
	/**
	 * Enregistre la variante dans un fichier nomVariante.vech
	 * @param nomVariante
	 */
	public void saveVariante(String nomVariante){
		
	}
	
	/**
	 * Charge la variante situee dans le fichier nomVariante.vech
	 * @param nomVariante
	 */
	public void chargerVariante(String nomVariante){
		
	}
	
	/**
	 * Place la piece p dans la case c du plateau
	 * 
	 * @param c case du plateau
	 * @param p pièce à ajouter
	 */
	public void ajouterPiece(Case c, Piece p){
		//TODO : Throws exception si la case n'existe pas ou contient déjà une pièce
	}
	
	/**
	 * Retire la piece contenue dans la case c du plateau
	 * 
	 * @param c case du plateau
	 */
	public void retirerPiece(Case c){
		//TODO : Throws exception si la case ne contient pas une pièce
	}
	
	
	/**
	 * 
	 * @return Renvoie l'echiquier de la variante
	 */
	public Vector<Case> getPlateau() {
		return plateau;
	}
	/**
	 * 
	 * @return Renvoie la liste des pieces utilisees dans la variante
	 */
	public Vector<Case> getListePieces() {
		return listePieces;
	}
}
