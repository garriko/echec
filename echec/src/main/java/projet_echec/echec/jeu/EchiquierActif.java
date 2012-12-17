package projet_echec.echec.jeu;

import java.util.ArrayList;
import java.util.Timer;

/**
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Case, Echiquier
 * Cette classe permet de definir ce qu’il se passe sur l’echiquier lors d’une partie en cours.
 */
public class EchiquierActif extends Echiquier {
	/**
	 * Temps restant au joueur avant la fin de son tour 
	 */
	private Timer tempsRestant;
	/**
	 * Temps total du jeu depuis le debut de la partie
	 */
	private Timer tempsTotal;
	/**
	 * Case selectionnee par le joueur ( via l'interface graphique)
	 */
	private Case caseSelectionne;
	/**
	 * case ou se situe le roi blanc
	 */
	private Case caseRoiBlanc;
	/**
	 * case ou se situe le roi noir
	 */
	private Case caseRoiNoir;
	
	
	/**
	 * constructeur de la classe
	 */
	public EchiquierActif(){
		super();
	}
	
	/**
	 * constructeur de la classe
	 * @param V variante choisie
	 */
	public EchiquierActif(Variantes V){
		super(V);
	}
	
	
	/**
	 * Test si on est en position d'echec
	 * @return true si l'un des joueurs est en echec
	 */
	public boolean echec(){
		boolean a;
		a=true;
		return a;
		//TODO : test echec
	}
	
	/**
	 * Test si on est en position d'echec et mat
	 * @return true si l'un des joueurs est en echec et mat
	 */
	public boolean echecEtMat(){
		boolean a;
		a=true;
		return a;
		//TODO :test echec et mat
		
	}
	/**
	 * Test si on est en position de pat
	 * @return true si l'un des joueurs est en pat
	 */
	public boolean pat(){
		boolean a;
		a=true;
		return a;
		//TODO : pat
	}
	/**
	 * recupere la case selectionne envoye par l'interface graphique
	 * @param caseSelectionne
	 */
	public void selectionnerCase(Case caseSelectionne){
		//TODO : selectionner case
		
	}
	/**
	 * Permet le deplacement des pieces
	 * @param caseDepart : le joueur a selectionne une piece sur le plateau
	 * @param caseArrivee: le joueur a selectionne une case d'arrivee sur le plateau
	 */
	public void deplacer(Case caseDepart, Case caseArrivee){
		//TODO : deplacer
	}
	
	/**
	 * Methode utile pour la classe Pion. Renvoie 0,1 ou 2 cases selon la presence d'une piece adverse en diagonale par rapport a la
	 * direction d'avancee du pion
	 * @param caseActuelle case du pion
	 * @return 0,1 ou 2 cases
	 */

	public ArrayList<Case>[] presenceAdversaireDiagonale(Case caseActuelle){
		ArrayList<Case> res=new ArrayList<Case>();
		if(caseActuelle.getPiece().getCamp()=="blanc"){
			Case c0 = chercherCase(new Position(caseActuelle.getPosition().getHauteur()+1,caseActuelle.getPosition().getLargeur()-1));
			if(!c0.estVide())
				if(c0.getPiece().getCamp()!="blanc")
					res.add(c0);
			Case c1 = chercherCase(new Position(caseActuelle.getPosition().getHauteur()+1,caseActuelle.getPosition().getLargeur()+1));
			if(!c1.estVide())
				if(c1.getPiece().getCamp()!="blanc")
					res.add(c1);
		}
		else
		{
			Case c0 = chercherCase(new Position(caseActuelle.getPosition().getHauteur()+1,caseActuelle.getPosition().getLargeur()-1));
			if(!c0.estVide())
				if(c0.getPiece().getCamp()=="blanc")
					res.add(c0);
			Case c1 = chercherCase(new Position(caseActuelle.getPosition().getHauteur()+1,caseActuelle.getPosition().getLargeur()+1));
			if(!c1.estVide())
				if(c1.getPiece().getCamp()=="blanc")
					res.add(c1);
			
		}
		return null;
	}
	
	/**
	 * Filtre la liste selon la presence d'une pièce du meme camp
	 * @param camp camp de la piece de la case de depart
	 * @param casePossible Liste des cases possibles, a filtrer
	 * @return Liste filtree
	 */
	private ArrayList<Case> filtrerDeplacementPossible(String camp,ArrayList<Case> casePossible)
	{
		//TODO : implémenter la méthode
		return null;
	}
	
	
	/**
	 * getter/setter
	 */
	public Timer getTempsRestant() {
		return tempsRestant;
	}

	public void setTempsRestant(Timer tempsRestant) {
		this.tempsRestant = tempsRestant;
	}

	public Timer getTempsTotal() {
		return tempsTotal;
	}

	public void setTempsTotal(Timer tempsTotal) {
		this.tempsTotal = tempsTotal;
	}

	public Case getCaseSelectionne() {
		return caseSelectionne;
	}

	public void setCaseSelectionne(Case caseSelectionne) {
		this.caseSelectionne = caseSelectionne;
	}

	public Case getCaseRoiBlanc() {
		return caseRoiBlanc;
	}

	public void setCaseRoiBlanc(Case caseRoiBlanc) {
		this.caseRoiBlanc = caseRoiBlanc;
	}

	public Case getCaseRoiNoir() {
		return caseRoiNoir;
	}

	public void setCaseRoiNoir(Case caseRoiNoir) {
		this.caseRoiNoir = caseRoiNoir;
	}
	
	
}
