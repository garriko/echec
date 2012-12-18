package projet_echec.echec.gestion;

import java.util.ArrayList;

import projet_echec.echec.exception.GameException;


/**
 * GestionJeu gere le nombre de parties en cours.
 * <p>
 * Permet d'instancier une partie si le nombre de parties deja existantes le permet.
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
	private static int nbPartie=0;
	
	public GestionJeu(){
		games = new ArrayList<Partie>();
		
	}
	/**
	 * Cree une nouvelle partie si possible avec les parametres fournis
	 * @param j1 Infos du joueur blanc
	 * @param j2 infos du joueur noir
	 * @param nomV nom de la variante
	 * @param optionsChoisies Options de la parties
	 * @return
	 * @throws GameException 
	 */
	public Partie creerNewGame(Joueur j1, Joueur j2, String nomV,Options optionsChoisies) throws GameException{
		Partie p;
		if(nbPartie==4)
			throw new GameException();
		else
		{
			p = new Partie(j1,j2,nomV,optionsChoisies);
			games.add(p);
			nbPartie++;
		}
		
		return p;
	}
	/**
	 * Supprime la partie choisie
	 * @param p partie a supprimer
	 */
	public void finPartie(Partie p){
		games.remove(p);
		nbPartie--;
	}
	/**
	 * Charge si possible le contenu de fichierCharge.pech
	 * @param fichierCharge 
	 */
	public void chargerPartie(String fichierCharge)
	{
		
	}
}
