package projet_echec.echec.jeu;

import projet_echec.echec.jeu.piece.Tour;

/**
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Position, Piece, Variante, EchiquierActif, EchiquierPassif
 *
 * Cette classe permet de definir ce qu’il se passe dans une case: elle peut contenir n'importe quelle piece
 */

public class Case implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private String img;
	
	/**
	 * constructeur
	 * @param pos
	 */
	public Case(Position pos){
		this.position=pos;
		piece =null;
		
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
	//TODO : y repenser
	/*public Case pionBoutEchiquier(){
		
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
	}*/
	
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
		if(piece==null){
			if((position.getHauteur()+position.getLargeur()) % 2 == 0)
				setImg("images/casegrise.png");
			else
				setImg("images/caseblanche.png");
		}
		else
		{
			if(piece.getClass().getSimpleName().equals(new String("Pion")))
			{
				if(piece.getCamp()=="blanc")
					if((position.getHauteur()+position.getLargeur()) % 2 == 0)
						setImg("images/Pieces/pasAuto/121.png");
					else
						setImg("images/Pieces/pasAuto/111.png");
				else
					if((position.getHauteur()+position.getLargeur()) % 2 == 0)
						setImg("images/Pieces/pasAuto/221.png");
					else
						setImg("images/Pieces/pasAuto/211.png");
			}

			if (piece.getClass().getSimpleName().equals(new String("Tour")))
			{

				if(piece.getCamp()=="blanc")
					if((position.getHauteur()+position.getLargeur()) % 2 == 0)
						setImg("images/Pieces/pasAuto/122.png");
					else
						setImg("images/Pieces/pasAuto/112.png");
				else
					if((position.getHauteur()+position.getLargeur()) % 2 == 0)
						setImg("images/Pieces/pasAuto/222.png");
					else
						setImg("images/Pieces/pasAuto/212.png");
			}

			if(piece.getClass().getSimpleName().equals(new String("Fou")))
			{
				if(piece.getCamp()=="blanc")
					if((position.getHauteur()+position.getLargeur() )% 2 == 0)
						setImg("images/Pieces/pasAuto/124.png");
					else
						setImg("images/Pieces/pasAuto/114.png");
				else
					if((position.getHauteur()+position.getLargeur()) % 2 == 0)
						setImg("images/Pieces/pasAuto/224.png");
					else
						setImg("images/Pieces/pasAuto/214.png");
			}

			if(piece.getClass().getSimpleName().equals(new String("Cavalier")))
			{
				if(piece.getCamp()=="blanc")
					if((position.getHauteur()+position.getLargeur()) % 2 == 0)
						setImg("images/Pieces/pasAuto/123.png");
					else
						setImg("images/Pieces/pasAuto/113.png");
				else
					if((position.getHauteur()+position.getLargeur()) % 2 == 0)
						setImg("images/Pieces/pasAuto/223.png");
					else
						setImg("images/Pieces/pasAuto/213.png");
			}

			if(piece.getClass().getSimpleName().equals(new String("Reine")))
			{
				if(piece.getCamp()=="blanc")
					if((position.getHauteur()+position.getLargeur()) % 2 == 0)
						setImg("images/Pieces/pasAuto/126.png");
					else
						setImg("images/Pieces/pasAuto/116.png");
				else
					if((position.getHauteur()+position.getLargeur()) % 2 == 0)
						setImg("images/Pieces/pasAuto/226.png");
					else
						setImg("images/Pieces/pasAuto/216.png");
			}

			if(piece.getClass().getSimpleName().equals(new String("Roi")))
			{
				if(piece.getCamp()=="blanc")
					if((position.getHauteur()+position.getLargeur()) % 2 == 0)
						setImg("images/Pieces/pasAuto/125.png");
					else
						setImg("images/Pieces/pasAuto/115.png");
				else
					if((position.getHauteur()+position.getLargeur()) % 2 == 0)
						setImg("images/Pieces/pasAuto/225.png");
					else
						setImg("images/Pieces/pasAuto/215.png");
			}
		}
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	public static void main(String[] args) {

	
		Case c = new Case(new Position(5,4));
		c.setPiece(new Tour("noir"));
		//c.setImg("images/Pieces/pasAuto/222.png");
		System.out.println((c.getPosition().getHauteur()+c.getPosition().getLargeur()) % 2);
		System.out.println(c.getImg());
		
	}	
	
}
