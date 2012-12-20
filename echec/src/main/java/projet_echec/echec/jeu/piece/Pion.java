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

	/**
	 * 
	 */
	private static final long serialVersionUID = -7909555113524307989L;
	private boolean dejaBouge;

	public Pion(String camp) {
		super(camp);
		this.dejaBouge=false;
	}
	
	
	@Override
	//public ArrayList<Case> getDeplacementPossible(Case pos){return null;}
	
	public ArrayList<Case> getDeplacementPossible(Case pos) {
		
		ArrayList<Case> lp = new ArrayList<Case>();
		
		if(this.dejaBouge == false)
		{
			if(pos.getPiece().getCamp()=="blanc")
			{
				Case c0 = new Case(new Position(pos.getPosition().getHauteur()+1,pos.getPosition().getLargeur()+0));
				if(isDeplacementOk(c0))
					lp.add(c0);
				
				Case c1 = new Case(new Position(pos.getPosition().getHauteur()+2,pos.getPosition().getLargeur()+0));
				if(isDeplacementOk(c1))
					lp.add(c1);
				
				Case diagd = new Case(new Position(pos.getPosition().getHauteur()+1,pos.getPosition().getLargeur()+1));
				if(isDeplacementOk(diagd))
					lp.add(diagd);
				
				Case diagg = new Case(new Position(pos.getPosition().getHauteur()+1,pos.getPosition().getLargeur()-1));
				if(isDeplacementOk(diagg))
					lp.add(diagg);
			}
			else
			{
				Case c0 = new Case(new Position(pos.getPosition().getHauteur()-1,pos.getPosition().getLargeur()+0));
				if(isDeplacementOk(c0))
					lp.add(c0);
				
				Case c1 = new Case(new Position(pos.getPosition().getHauteur()-2,pos.getPosition().getLargeur()+0));
				if(isDeplacementOk(c1))
					lp.add(c1);
				
				Case diagd = new Case(new Position(pos.getPosition().getHauteur()-1,pos.getPosition().getLargeur()+1));
				if(isDeplacementOk(diagd))
					lp.add(diagd);
				
				Case diagg = new Case(new Position(pos.getPosition().getHauteur()-1,pos.getPosition().getLargeur()-1));
				if(isDeplacementOk(diagg))
					lp.add(diagg);
			}
			this.dejaBouge = true;
		}
		else
		{
			if(pos.getPiece().getCamp()=="blanc")
			{
			Case c0 = new Case(new Position(pos.getPosition().getHauteur()+1,pos.getPosition().getLargeur()+0));
			if(isDeplacementOk(c0))
				lp.add(c0);
			
			Case diagd = new Case(new Position(pos.getPosition().getHauteur()+1,pos.getPosition().getLargeur()+1));
			if(isDeplacementOk(diagd))
				lp.add(diagd);
			
			Case diagg = new Case(new Position(pos.getPosition().getHauteur()+1,pos.getPosition().getLargeur()-1));
			if(isDeplacementOk(diagg))
				lp.add(diagg);
			}
			else
			{
			Case c0 = new Case(new Position(pos.getPosition().getHauteur()-1,pos.getPosition().getLargeur()+0));
			if(isDeplacementOk(c0))
				lp.add(c0);
			
			Case diagd = new Case(new Position(pos.getPosition().getHauteur()-1,pos.getPosition().getLargeur()+1));
			if(isDeplacementOk(diagd))
				lp.add(diagd);
			
			Case diagg = new Case(new Position(pos.getPosition().getHauteur()-1,pos.getPosition().getLargeur()-1));
			if(isDeplacementOk(diagg))
				lp.add(diagg);
			
			}
		}
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
