package projet_echec.echec.gestion;

import java.util.Vector;


/**
 * 
 * La classe Gestion permet de gerer la liste des sauvegardes
 * <p>
 * Les classes {@link GestionCatalogueRevoir} et {@link GestionCatalogueCharger} en heritent.
 * <b>Classe abstraite</b>
 * 
 * 
 * @author Kevin
 * @version 0.1
 * @see GestionCatalogueCharger, GestionCatalogueRevoir
 */

public abstract class Gestion {
	/**
	 * Liste des parties pouvant etre chargees
	 */
	protected Vector<String> listePartie;
	/**
	 * partie selectionnee par l'utilisateur
	 */
	protected String partieSelect;
	
	public Gestion(){
		
	}
	/**
	 * Charge la liste de toutes les parties disponibles
	 */
	public abstract void chargerListe();
	
	/**
	 * Supprime de la liste (et du disque dur) la partie correspondant a nomPartie
	 * @param nomPartie Nom de la partie a supprimer
	 */
	public abstract void supprimerPartie(String nomPartie);
	
}
