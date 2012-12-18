package projet_echec.echec.wrapper;

import projet_echec.echec.gestion.Partie;
import projet_echec.echec.gestion.SaveGame;
import projet_echec.echec.jeu.Echiquier;
import projet_echec.echec.jeu.EchiquierActif;
import projet_echec.echec.jeu.EchiquierPassif;
/**
 * Rassemble la partie et l'echiquier pour permettre l'enregistrement grace a la classe SaveGame
 * @author Kevin
 * @see SaveGame , {@link Partie}, {@link Echiquier}, {@link EchiquierActif}, {@link EchiquierPassif} 
 */
public class Wrapper implements java.io.Serializable {
	/**
	 * partie que l'on veut enregistrer
	 */
	private Partie p;
	/**
	 * echiquier a enregistrer
	 */
	private Echiquier e;

	/**
	 * initialise le wrapper pour permettre l'enregistrement
	 * @param p partie a enregistrer
	 * @param e echiquier a enregistrer
	 */
	public Wrapper(Partie p, Echiquier e){
		this.p=p;
		this.e=e;
	}
	
	/**
	 * get partie
	 * Utile pour recuperer la partie chargee
	 * @return Partie
	 */
	public Partie getP() {
		return p;
	}
	
	/**
	 * get echiquier
	 * Utile pour recuperer l'echiquier charge
	 * @return Echiquier
	 */
	public Echiquier getE() {
		return e;
	}

}