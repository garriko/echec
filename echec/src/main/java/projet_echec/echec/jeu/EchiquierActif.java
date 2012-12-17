package projet_echec.echec.jeu;

import java.util.Timer;

/**
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Case, Echiquier
 * Cette classe permet de définir ce qu’il se passe sur l’échiquier lors d’une partie en cours.
 */
public class EchiquierActif extends Echiquier {
	/**
	 * Temps restant au joueur avant la fin de son tour 
	 */
	private Timer tempsRestant;
	/**
	 * Temps total du jeux depuis le début de la partie
	 */
	private Timer tempsTotal;
	/**
	 * Case séléctionné par le joueur ( via l'interface graphique)
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
	 */
	public EchiquierActif(Variantes V){
		super(V);
	}
	
	
	/**
	 * Test si on est en position d'échec
	 * @return true si l'un des joueurs est en echec
	 */
	public boolean echec(){
		boolean a;
		a=true;
		return a;
		//TODO : test echec
	}
	
	/**
	 * Test si on est en position d'échec et mat
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
	 * recupère la case selectionné envoyé par l'interface graphique
	 * @param caseSelectionne
	 */
	public void selectionnerCase(Case caseSelectionne){
		//TODO : selectionner case
		
	}
	/**
	 * Permet le déplacement des pièces
	 * @param caseDepart : le joueur a selectionné une pièce sur le plateau
	 * @param caseArrivee: le joueur a selectionné une case d'arrivée sur le plateau
	 */
	public void deplacer(Case caseDepart, Case caseArrivee){
		//TODO : deplacer
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
