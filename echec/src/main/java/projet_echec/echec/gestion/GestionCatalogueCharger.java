package projet_echec.echec.gestion;

import java.io.File;

/**
 * 
 * GestionCatalogueCharger gere les sauvegardes des parties non terminees.
 * <p>
 * GestionCatalogueCharger herite de {@link Gestion}.
 * 
 * 
 * @author Kevin
 * @see Gestion
 * @version 0.1
 */

public class GestionCatalogueCharger extends Gestion {

	
	
	/**
	 * Constructeur par defaut
	 */
	public GestionCatalogueCharger() {
		super();
		
	}
	
	/**
	 * Charge la liste des parties non terminees
	 */
	@Override
	public void chargerListe() {
	
		File repertoire = new File("partie en cours/");

		String [] listefichiers; 

		int i; 
		listefichiers=repertoire.list(); 
		for(i=0;i<listefichiers.length;i++){ 
			if(listefichiers[i].endsWith(".gech")==true){ 
				listePartie.add(listefichiers[i].replaceFirst(".gech",""));   //On remplace .gech par rien
				 
			}
		}
		
	}
	



}
