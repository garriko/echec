/**
 * 
 */
package projet_echec.echec.jeu.piece;

import java.io.IOException;
import java.util.ArrayList;

import projet_echec.echec.exception.DeplacementException;
import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.EchiquierActif;
import projet_echec.echec.jeu.Piece;
import projet_echec.echec.jeu.Position;
import projet_echec.echec.jeu.Variantes;
import junit.framework.TestCase;

/**
 * @author Adrien
 *
 */
public class PionTest extends TestCase {
	
	public void testPresencePion(){
		Position p= new Position(1,1);
		Piece c= new Pion("noir");
		Case c1= new Case(p);
		c1.setPiece(c);
		assertEquals(c1.getPiece(),c);	
	}
	
	public void testdeplacerPion(){
		
		EchiquierActif E=null;
		try {
			E = new EchiquierActif();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		
		
		Position p= new Position(4,4);
		Case c1= new Case(p);
		Piece c= new Pion("noir");
		c1.setPiece(c);
		System.out.println(c1.estVide());
		
		Position ar= new Position(3,3);
		Case t2= new Case(ar);
		Piece d= new Tour("noir");
		t2.setPiece(d);
		//System.out.println(E.chercherCase(p).getPosition().getHauteur()+","+c1.getPosition().getLargeur());
		//System.out.println(c1.getPiece());
		//System.out.println(c1.getPiece().getDeplacementPossible(c1));
		
	
		try {
			E.deplacer(c1,t2);
		} catch (DeplacementException e) {
			e.toString();
		}
		
		
		
		
		/*
		Position ar1= new Position(4,1);
		Case t3= new Case(ar1);
		try {
			E.deplacer(t2,t3);
		} catch (DeplacementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		System.out.println("a la position:"+t2.getPosition().getHauteur()+","+t2.getPosition().getLargeur());
		System.out.println("on a bien :"+t2.getPiece());
		assertEquals(c,t2.getPiece());
	}
}
