package projet_echec.echec.gestion;

import java.util.Vector;


/**
 * 
 * La classe Gestion permet de gérer la liste des sauvegardes
 * <p>
 * Les classes {@link GestionCatalogueRevoir} et {@link GestionCatalogueCharger} en héritent.
 * <b>Classe abstraite</b>
 * 
 * 
 * @author Kevin
 * @version 0.0.1
 * @see GestionCatalogueCharger , GestionCatalogueRevoir
 */

public abstract class Gestion {
	/**
	 * Liste des parties pouvant être chargées
	 */
	protected Vector<String> listePartie;
	/**
	 * partie sélectionnée par l'utilisateur
	 */
	protected String partieSelect;
	
	public Gestion(){
		
	}
	/**
	 * Charge la liste de toutes les parties disponibles
	 */
	public abstract void chargerListe();
	
	/**
	 * Supprime de la liste (et du disque dur) la partie correspondant à nomPartie
	 * @param nomPartie Nom de la partie à supprimer
	 */
	public abstract void supprimerPartie(String nomPartie);
	
}
