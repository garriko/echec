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
	
	@Override
	public void supprimerPartie(String nomPartie) throws Exception {
		listePartie.remove(nomPartie);
        File file = new File("variantes/"+nomPartie+".vech");

        if (!file.exists()) {
            throw new Exception("le fichier est introuvable !");
        }
//Tester les propriétés et les droits sur le fichier
        if (!file.canWrite()) {
            throw new Exception("Droit insuffisant pour accéder au fichier");
        }

       file.delete();
		
	}

/*	
	public static void main(String[] args) {
		GestionCatalogueVariante gest = new GestionCatalogueVariante();
		gest.chargerListe();
		System.out.println(gest.getListePartie());
	}
*/

}
