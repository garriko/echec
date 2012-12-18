package projet_echec.echec.jeu;

import com.sun.org.apache.xpath.internal.operations.Equals;

import projet_echec.echec.jeu.piece.Pion;

/**
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Position, Piece, Variante, EchiquierActif, EchiquierPassif
 *
 * Cette classe permet de definir ce qu’il se passe dans une case: elle peut contenir n'importe quelle piece
 */

public class Case {
	/**
	 * Piece contenue dans la case
	 */
	private Piece piece;
	/**
	 * Position de la case
	 */
	private Position position;
	/**
	 * permet d'envoyer le nom de l'image a mettre pour l'interface graphique
	 */
	private  String img;
	
	/**
	 * constructeur
	 * @param pos
	 */
	public Case(Position pos){
		this.position=pos;
	}
	
	/**
	 * permet de savoir si il y a une piece sur la case ou non
	 * @return true si la case est vide, false sinon
	 */
	public boolean estVide(){
		boolean a= false;
		if (this.getPiece()==null);
			a=true;
		return a;		
	}
	/**
	 * permet de savoir si un pion a atteint le bout du plateau pour le changer en une autre piece
	 * @return la case contenant le pion si le pion est au bout du plateau
	 */
	public Case pionBoutEchiquier(){
		
		Case IlYAUnPion = null;
		for (int i=1;i<9;i++)
		{
			Position phaut= new Position(1,i);
			Case haut= new Case(phaut);//crée une case qui parcourt le haut de l'échiquier
			Position pbas= new Position(8,i);
			Case bas= new Case(pbas);//crée une case qui parcourt le bas de l'échiquier
			Piece piontestn= new Pion("noir");//piece pion noir qui test l'égalité
			Piece piontestb= new Pion("blanc");//piece pion blanc qui test l'égalité
			if (haut.getPiece()==piontestn||haut.getPiece()==piontestb){
				IlYAUnPion=haut;
				//si l'égalité est vérifié (il y a un pion en haut de l'échiquier) alors on renvoit la case de se pion
			}
			if(bas.getPiece()==piontestn||bas.getPiece()==piontestb){
				IlYAUnPion=bas;//si l'égalité est vérifié (il y a un pion en bas de l'échiquier) alors on renvoit la case de se pion
			}
		}
		return IlYAUnPion;//on retourne la case du pion.(=null si pas de pion)
	}
	
	public boolean equals(Case c) {
		
		if (c.getPosition().equals(this.getPosition())){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * getters/setters
	 */
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
