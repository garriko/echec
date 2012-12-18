package projet_echec.echec.jeu;

import java.util.Vector;

/**
 * 
 * @author Kevin
 * @version 0.0.1
 * @see 
 *
 * Cette classe abstraite permet de définir ce qu’il se passe sur l’échiquier avec comme classes filles : échiquier passif et échiquier actif (cf. Echiquier actif et Echiquier passif).
 */

public abstract class Echiquier {
	/**
	 * Plateau de jeu
	 */
	protected Vector<Case> plateau;
	/**
	 * Liste des pièces toujours sur le plateau
	 */
	protected Vector<Case> listePieceEnJeu;
	/**
	 * Liste des pièces prises
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
	 * @param v variante utilisée pour la partie
	 */
	public Echiquier(Variantes v)
	{
		this.plateau = new Vector<Case>(v.getPlateau());
		this.listePieceEnJeu = new Vector<Case>(v.getListePieces());
		this.listePiecePrises=new Vector<Piece>();
	}
	
	/**
	 * Recherche la case se trouvant à la position p
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
	 * ajouter une piece au vector<case>
	 */
	public void ajouterPieceEnJeu(Case e){
		this.listePieceEnJeu.add(e);
	}
	/**
	 * supprimer une piece a listePieceEnJeu
	 */
	public void supprimerPieceEnJeu(Case e){
		this.listePieceEnJeu.remove(e);
	}
}
