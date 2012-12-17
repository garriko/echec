package projet_echec.echec.gestion;

import projet_echec.echec.jeu.Echiquier;


/**
 * Permet d'enregistrer ou de charger une partie et un échiquier
 * @author Kevin
 * @see Partie, Echiquier
 *
 */
public class Wrapper implements java.io.Serializable {
	private Partie p;
	private Echiquier e;
	
	public Wrapper(){
		this.p= null;
		this.e= null;
	}
	
	
	public Wrapper(Partie p, Echiquier e){
		this.p=p;
		this.e=e;
	}
	/**
	 * Enregistre p et e (si non null)
	 * @param nomFichier Enregistre dans nomFichier.gech
	 */
	public void sauvegarder(String nomFichier)
	{
		
	}
	
	/**
	 * Charge le contenu de nomFichier.gech
	 * @param nomFichier
	 */
	public static void charger(String nomFichier)
	{
		
	}
}
