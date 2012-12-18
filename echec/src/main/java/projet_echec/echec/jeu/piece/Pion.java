package projet_echec.echec.jeu.piece;

import java.util.ArrayList;
import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.Piece;
import projet_echec.echec.jeu.Position;


/**
 * Cette classe definit les attributs de la piece Pion.
 * 
 * @author Kevin
 * @version 0.0.1
 * @see Piece
 * 
 */

public class Pion extends Piece implements java.io.Serializable {

	private boolean dejaBouge;

	public Pion(String camp, String img) {
		super(camp,img);
		dejaBouge=false;
	}
	
	
	@Override
	public ArrayList<Case> getDeplacementPossible(Case pos){return null;}
	
	public ArrayList<Case> getDeplacementPossible(Case pos, ArrayList<Case> caseDiagonale) {
		// TODO Auto-generated method stub
		ArrayList<Case> lp = new ArrayList<Case>();
		if(dejaBouge == false)
		{
			if(pos.getPiece().getCamp()=="blanc")
			{
			Case c0 = new Case(new Position(pos.getPosition().getHauteur()+1,pos.getPosition().getLargeur()+0));
			if(isDeplacementOk(c0))
				lp.add(c0);
			
			Case c1 = new Case(new Position(pos.getPosition().getHauteur()+2,pos.getPosition().getLargeur()+0));
			if(isDeplacementOk(c1))
				lp.add(c1);
			}
			else
			{
				Case c0 = new Case(new Position(pos.getPosition().getHauteur()-1,pos.getPosition().getLargeur()+0));
				if(isDeplacementOk(c0))
					lp.add(c0);
				
				Case c1 = new Case(new Position(pos.getPosition().getHauteur()-2,pos.getPosition().getLargeur()+0));
				if(isDeplacementOk(c1))
					lp.add(c1);
			}
			dejaBouge = true;
		}
		else
		{
			if(pos.getPiece().getCamp()=="blanc")
			{
			Case c0 = new Case(new Position(pos.getPosition().getHauteur()+1,pos.getPosition().getLargeur()+0));
			if(isDeplacementOk(c0))
				lp.add(c0);
			}
			else
			{
			Case c0 = new Case(new Position(pos.getPosition().getHauteur()-1,pos.getPosition().getLargeur()+0));
			if(isDeplacementOk(c0))
				lp.add(c0);
			}
		}
		lp.addAll(caseDiagonale);
		return lp;
	}

	/**
	 * @return dejaBouge
	 */
	public boolean isDejaBouge() {
		return dejaBouge;
	}

	/**
	 * @param dejaBouge dejaBouge to set
	 */
	public void setDejaBouge(boolean dejaBouge) {
		this.dejaBouge = dejaBouge;
	}

}
