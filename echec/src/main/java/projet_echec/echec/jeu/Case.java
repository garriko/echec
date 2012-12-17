package projet_echec.echec.jeu;

/**
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Position, Pièce, Variante, EchiquierActif, EchiquierPassif
 *
 * Cette classe permet de définir ce qu’il se passe dans une case: elle peut contenir n'importe qu'elle pièce
 */

public class Case {
	/**
	 * permet de mettre une piece sur la case
	 */
	private Piece piece;
	/**
	 * permet de donner la position de la case
	 */
	private Position position;
	/**
	 * permet d'envoyer le nom de l'image à mettre pour l'interface graphique
	 */
	private  String img;
	
	/**
	 * constructeur
	 * @param position
	 */
	public Case(Position pos){
		this.position=pos;
	}
	
	/**
	 * permet de savoir si il y a une pièce sur la case ou non
	 * @return true si la case est vide
	 */
	public boolean estVide(){
		//TODO: faire test estVide()
		boolean a;
		a= true;
		return a;		
	}
	/**
	 * permet de savoir si un pion à atteint le bout du plateau pour le changer en une autre pièce
	 * @return true si le pion est au bout du plateau
	 */
	public boolean pionBoutEchiquier(){
		//TODO: savoir si un pion est au bout de l'échiquier
		boolean a;
		a= true;
		return a;
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
