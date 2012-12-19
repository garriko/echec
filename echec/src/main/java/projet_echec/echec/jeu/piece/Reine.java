package projet_echec.echec.jeu.piece;
import java.util.ArrayList;

import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.Piece;
import projet_echec.echec.jeu.Position;

/**
 * Cette classe definit les attributs de la piece Reine
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Piece
 *  
 */

public class Reine extends Piece implements java.io.Serializable{

	public Reine(String camp) {
		super(camp);
	}

	@Override
	/**
	 * renvoi la liste des positions possibles
	 */
	public ArrayList<Case> getDeplacementPossible(Case pos) {
		ArrayList<Case> lp = new ArrayList<Case>();
		
		
		for (int i=0;i<8;i++)
		{
			Case hg = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			Case hd = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			Case bg = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			Case bd = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			Case h = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			Case d = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			Case b = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			Case g = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
			
			hd.setPosition(new Position(hd.getPosition().getHauteur()+1+i,hd.getPosition().getLargeur()+1+i));
			hg.setPosition(new Position(hg.getPosition().getHauteur()+1+i,hg.getPosition().getLargeur()-1-i));
			bd.setPosition(new Position(bd.getPosition().getHauteur()-1-i,bd.getPosition().getLargeur()+1+i));
			bg.setPosition(new Position(bg.getPosition().getHauteur()-1-i,bg.getPosition().getLargeur()-1-i));
			h.setPosition(new Position(h.getPosition().getHauteur()+1+i,h.getPosition().getLargeur()));
			d.setPosition(new Position(d.getPosition().getHauteur(),d.getPosition().getLargeur()+1+i));
			b.setPosition(new Position(b.getPosition().getHauteur()-1-i,b.getPosition().getLargeur()));
			g.setPosition(new Position(g.getPosition().getHauteur(),g.getPosition().getLargeur()-1-i));
			
			if(isDeplacementOk(hd)){
				lp.add(hd);
				//System.out.println("position de la piece :"+hd.getPosition().getHauteur()+","+hd.getPosition().getLargeur());
				}
				
			if(isDeplacementOk(hg)){
				lp.add(hg);}
			
			if(isDeplacementOk(bd)){
				lp.add(bd);}
			
			if(isDeplacementOk(bg)){
				lp.add(bg);}
			
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
