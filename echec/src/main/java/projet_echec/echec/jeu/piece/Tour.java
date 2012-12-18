package projet_echec.echec.jeu.piece;

import java.util.ArrayList;

import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.Piece;
import projet_echec.echec.jeu.Position;

/**
 * Cette classe definit les attributs de la piece Tour
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Piece
 * 
 */

public class Tour extends Piece{

	public Tour(String camp) {
		super(camp);
	}
	@Override
	/**
	 * renvoi la liste des positions possibles
	 */
	public ArrayList<Case> getDeplacementPossible(Case pos) {
			ArrayList<Case> lp = new ArrayList<Case>();
			Case h = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			Case d = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			Case b = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			Case g = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			
			for (int i=0;i<8;i++)
			{
				h.setPosition(new Position(h.getPosition().getHauteur()+1,h.getPosition().getLargeur()));
				d.setPosition(new Position(d.getPosition().getHauteur(),d.getPosition().getLargeur()+1));
				b.setPosition(new Position(b.getPosition().getHauteur()-1,b.getPosition().getLargeur()));
				g.setPosition(new Position(g.getPosition().getHauteur(),g.getPosition().getLargeur()-1));
				
				if(isDeplacementOk(h)){
					lp.add(h);}
					
				if(isDeplacementOk(d)){
					lp.add(d);}
				
				if(isDeplacementOk(b)){
					lp.add(b);}
				
				if(isDeplacementOk(g)){
					lp.add(g);}
			}
			return lp;
			}
	}


