package projet_echec.echec.wrapper;

import java.util.Vector;

import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.Piece;
import projet_echec.echec.jeu.Variantes;
/**
 * Rassemble la plateau et la liste des cases contenant des pieces pour permettre l'enregistrement grace a la classe Variante
 * @author Kevin
 * @see Variantes , {@link Vector} , {@link Piece}
 */
public class VariantWrapper implements java.io.Serializable{
	/**
	 * plateau de jeu a sauvegarder
	 */
	private Vector<Case> plateau;
	/**
	 * listes des cases a save
	 */
	private Vector<Case> listePieces;
	/**
	 * @param plateau plateau a sauver
	 * @param listePieces liste de cases a sauver
	 */
	public VariantWrapper(Vector<Case> plateau, Vector<Case> listePieces) {
		this.plateau = plateau;
		this.listePieces = listePieces;
	}
	/**
	 * @return the plateau
	 */
	public Vector<Case> getPlateau() {
		return plateau;
	}
	/**
	 * @param plateau the plateau to set
	 */
	public void setPlateau(Vector<Case> plateau) {
		this.plateau = plateau;
	}
	/**
	 * @return the listePieces
	 */
	public Vector<Case> getListePieces() {
		return listePieces;
	}
	/**
	 * @param listePieces the listePieces to set
	 */
	public void setListePieces(Vector<Case> listePieces) {
		this.listePieces = listePieces;
	}
	
	
	
}