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
	protected Vector<Piece> listePieceEnJeu;
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
		this.listePieceEnJeu = new Vector<Piece>(v.getListePieces());
		this.listePiecePrises=new Vector<Piece>();
	}
	/**
	 * Initialise l'echiquier selon la variante v
	 * @param v variante utilisee pour la partie
	 */
	public Echiquier(Variantes v)
	{
		this.plateau = new Vector<Case>(v.getPlateau());
		this.listePieceEnJeu = new Vector<Piece>(v.getListePieces());
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
}
