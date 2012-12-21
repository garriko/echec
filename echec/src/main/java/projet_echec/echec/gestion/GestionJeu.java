package projet_echec.echec.gestion;

import java.io.IOException;
import java.util.ArrayList;

import projet_echec.echec.exception.GameException;
import projet_echec.echec.jeu.Echiquier;
import projet_echec.echec.jeu.EchiquierActif;
import projet_echec.echec.jeu.Variantes;
import projet_echec.echec.wrapper.Wrapper;


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
	private static ArrayList<Partie> games;
	/**
	 * Nombre de parties en cours
	 */
	private static int nbPartie=0;
	
	public GestionJeu(){
		games = new ArrayList<Partie>();
		
	}
	/**
	 * Cree une nouvelle partie et un echiquier si possible avec les parametres fournis
	 * @param j1 Infos du joueur blanc
	 * @param j2 infos du joueur noir
	 * @param nomV nom de la variante
	 * @param optionsChoisies Options de la parties
	 * @return 
	 * @throws GameException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static Wrapper creerNewGame(Joueur j1, Joueur j2, String nomV,Options optionsChoisies) throws GameException, ClassNotFoundException, IOException{
		Wrapper w;
		if(nbPartie==4)
			throw new GameException();
		else
		{
			Partie p = new Partie(j1,j2,nomV,optionsChoisies);
			Variantes v= new Variantes(nomV);
			Echiquier e = new EchiquierActif(v);
			w = new Wrapper(p,e);
			
			games.add(p);
			nbPartie++;
		}
		
		return w;
	}
	
	/**
	 * Charge si possible le contenu de fichierCharge.pech
	 * @param fichierCharge 
	 * @return un wrapper contenant la partie et l'echiquier
	 * @throws GameException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static Wrapper chargerGame(String fichierCharge) throws GameException, ClassNotFoundException, IOException
	{
		Wrapper w;
		if(nbPartie==4)
			throw new GameException();
		else
		{
			w = SaveGame.chargerEnCours(fichierCharge);
			games.add(w.getP());
			nbPartie++;
			return w;
		}
	}
	/**
	 * Supprime la partie choisie
	 * @param p partie a supprimer
	 */
	public static void finPartie(Partie p){
		games.remove(p);
		nbPartie--;
	}

	public static int getNbParties(){
		return nbPartie;
	}

}
