package projet_echec.echec.gestion;

import java.util.ArrayList;

/**
 * GestionJeu gère le nombre de parties en cours.
 * <p>
 * Permet d'instancier une partie si le nombre de parties déjà existantes le permet.
 * Supprime les objets parties.
 *
 * @author Kevin
 * @version 0.0.1
 * @see Partie
 */

public class GestionJeu {
	/**
	 * Liste des parties
	 */
	private ArrayList<Partie> games;
	/**
	 * Nombre de parties en cours
	 */
	private int nbPartie;
	
	public GestionJeu(){
		games = new ArrayList<Partie>();
		nbPartie=0;
	}
	/**
	 * Crée une nouvelle partie si possible avec les paramètres fournis
	 * @param j1 Infos du joueur blanc
	 * @param j2 infos du joueur noir
	 * @param nomV nom de la variante
	 * @param optionsChoisies Options de la parties
	 * @return
	 */
	public Partie creerNewGame(Joueur j1, Joueur j2, String nomV,Options optionsChoisies){
		return null;
	}
	/**
	 * Supprime la partie choisie
	 * @param p partie à supprimer
	 */
	public void finPartie(Partie p){
		
	}
	/**
	 * Charge si possible le contenu de fichierCharge.pech
	 * @param fichierCharge 
	 */
	public void chargerPartie(String fichierCharge){
		
	}
}
