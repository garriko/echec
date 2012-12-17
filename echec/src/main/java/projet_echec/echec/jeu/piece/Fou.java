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
 * Cette classe sert à définir les attributs de la pièce Fou.
 * 
 */

public class Fou extends Piece {

	public Fou(String camp) {
		super(camp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Case> getDeplacementPossible(Case pos) {
		ArrayList<Case> lp = new ArrayList<Case>();
		Case hg = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
		Case hd = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
		Case bg = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
		Case bd = new Case(new Position(pos.getPosition().getHauteur(),pos.getPosition().getLargeur()));
		
		for (int i=0;i<8;i++)
		{
			hd.setPosition(new Position(hd.getPosition().getHauteur()+1,hd.getPosition().getLargeur()+1));
			hg.setPosition(new Position(hg.getPosition().getHauteur()+1,hg.getPosition().getLargeur()-1));
			bd.setPosition(new Position(bd.getPosition().getHauteur()-1,bd.getPosition().getLargeur()+1));
			bg.setPosition(new Position(bg.getPosition().getHauteur()-1,bg.getPosition().getLargeur()-1));
			
			if(isDeplacementOk(hd)){
				lp.add(hd);}
				
			if(isDeplacementOk(hg)){
				lp.add(hg);}
			
			if(isDeplacementOk(bd)){
				lp.add(bd);}
			
			if(isDeplacementOk(bg)){
				lp.add(bg);}
		}
		return lp;
		}
	}

