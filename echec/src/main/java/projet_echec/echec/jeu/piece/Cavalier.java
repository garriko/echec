package projet_echec.echec.jeu.piece;
import java.util.ArrayList;

import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.Piece;
import projet_echec.echec.jeu.Position;


/**
 * 
 * @author Kevin
 * @version 0.0.1
 * @see Piece
 * Cette classe sert à définir les attributs de la pièce Cavalier.
 * 
 */

public class Cavalier extends Piece{

	
	
	public Cavalier(String camp) {
		super(camp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Case> getDeplacementPossible(Case pos) {
		ArrayList<Case> lp = new ArrayList<Case>();
		//On teste chacune des cases possibles
		Case c0 = new Case(new Position(pos.getPosition().getHauteur()+2,pos.getPosition().getLargeur()+1));
		if(isDeplacementOk(c0))
			lp.add(c0);
		
		Case c1 = new Case(new Position(pos.getPosition().getHauteur()+2,pos.getPosition().getLargeur()-1));
		if(isDeplacementOk(c1))
			lp.add(c1);
		
		Case c2 = new Case(new Position(pos.getPosition().getHauteur()+1,pos.getPosition().getLargeur()+2));
		if(isDeplacementOk(c2))
			lp.add(c2);
		
		Case c3 = new Case(new Position(pos.getPosition().getHauteur()+1,pos.getPosition().getLargeur()-2));
		if(isDeplacementOk(c3))
			lp.add(c3);
		
		Case c4 = new Case(new Position(pos.getPosition().getHauteur()-2,pos.getPosition().getLargeur()-1));
		if(isDeplacementOk(c4))
			lp.add(c4);
		
		Case c5 = new Case(new Position(pos.getPosition().getHauteur()-2,pos.getPosition().getLargeur()+1));
		if(isDeplacementOk(c5))
			lp.add(c5);
		
		Case c6 = new Case(new Position(pos.getPosition().getHauteur()-1,pos.getPosition().getLargeur()-2));
		if(isDeplacementOk(c6))
			lp.add(c6);
		
		Case c7 = new Case(new Position(pos.getPosition().getHauteur()-1,pos.getPosition().getLargeur()+2));
		if(isDeplacementOk(c7))
			lp.add(c7);
		
		return lp;
	}

}
