package projet_echec.echec.gestion;

import java.io.File;

public class GestionCatalogueVariante extends Gestion {

		
	/**
	 * Constructeur
	 */
	public GestionCatalogueVariante() {
		super();
		
	}

	@Override
	public void chargerListe() {
		File repertoire = new File("variantes/");

		String [] listefichiers; 

		int i; 
		listefichiers=repertoire.list(); 
		for(i=0;i<listefichiers.length;i++){ 
			if(listefichiers[i].endsWith(".vech")==true){ 
				listePartie.add(listefichiers[i].replaceFirst(".vech",""));   //On remplace .gech par rien
				 
			}
		}
	}
	
	public static void main(String[] args) {
		GestionCatalogueVariante gest = new GestionCatalogueVariante();
		gest.chargerListe();
		System.out.println(gest.getListePartie());
	}

}
