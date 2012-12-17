package projet_echec.echec.gestion;

import projet_echec.echec.jeu.Echiquier;
/**
 * Rassemble la partie et l'échiquier pour permettre l'enregistrement grâce à la classe SaveGame
 * @author Kevin
 * @see SaveGame,Partie,Echiquier
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
	public Partie getP() {
		return p;
	}


	public Echiquier getE() {
		return e;
	}

}