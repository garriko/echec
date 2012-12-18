package projet_echec.echec.jeu;

import java.util.Vector;

/**
 * Cette classe abstraite permet de definir ce qu’il se passe sur l’echiquier avec comme classes filles : echiquierPassif et echiquierActif.
 * @author Kevin
 * @version 0.0.1
 * @see echiquierPassif,echiquierActif
 *
 * 
 */

public abstract class Echiquier {
	/**
	 * Plateau de jeu
	 */
	protected Vector<Case> plateau;
	/**
	 * Liste des pieces toujours sur le plateau
	 */
	protected Vector<Case> listePieceEnJeu;
	/**
	 * Liste des pieces prises
	 */
	protected Vector<Piece> listePiecePrises;
	
	
	/**
	 * Initialise l'echiquier de façon classique
	 */
	public Echiquier(){
		Variantes v = new Variantes("classique");
		this.plateau = new Vector<Case>(v.getPlateau());
		this.listePieceEnJeu = new Vector<Case>(v.getListePieces());
		this.listePiecePrises=new Vector<Piece>();
	}
	/**
	 * Initialise l'echiquier selon la variante v
	 * @param v variante utilisee pour la partie
	 */
	public Echiquier(Variantes v)
	{
		this.plateau = new Vector<Case>(v.getPlateau());
		this.listePieceEnJeu = new Vector<Case>(v.getListePieces());
		this.listePiecePrises=new Vector<Piece>();
	}
	
	/**
	 * Recherche la case se trouvant a la position p
	 * @param p
	 * @return
	 */
	public Case chercherCase(Position p){
		Case res=null;
		for(int i=0;i<plateau.size();i++)
			if(plateau.get(i).getPosition().equals(p))
				res = plateau.get(i);
		return res;
	}
	/**
	 * ajoute une case a listePieceEnJeu
	 * @param e
	 */
	public void ajouterPieceEnJeu(Case e){
		this.listePieceEnJeu.add(e);
	}
	/**
	 * Supprime une piece de listePieceEnJeu
	 * attention: la case doit appartenir a l'echiquier sinon la fonction ne fait rien
	 * @param e
	 */
	public void supprimerPieceEnJeu(Case e){
		this.listePieceEnJeu.remove(e);	
	}
	public Vector<Case> getPlateau() {
		return plateau;
	}
	public void setPlateau(Vector<Case> plateau) {
		this.plateau = plateau;
	}
	public Vector<Case> getListePieceEnJeu() {
		return listePieceEnJeu;
	}
	public void setListePieceEnJeu(Vector<Case> listePieceEnJeu) {
		this.listePieceEnJeu = listePieceEnJeu;
	}
	public Vector<Piece> getListePiecePrises() {
		return listePiecePrises;
	}
	public void setListePiecePrises(Vector<Piece> listePiecePrises) {
		this.listePiecePrises = listePiecePrises;
	}
	/**
	 * ajoute une case a listePiecePrises
	 * @param e
	 */
	public void ajouterPiecePrise(Piece e){
		this.listePiecePrises.add(e);
	}
	/**
	 * Supprime une piece de listePiecePrises
	 * attention: la case doit appartenir a l'echiquier sinon la fonction ne fait rien
	 * @param e
	 */
	public void supprimerPieceprises(Piece e){
		this.listePiecePrises.remove(e);	
	}
}
