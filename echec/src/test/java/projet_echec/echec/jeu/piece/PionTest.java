/**
 * 
 */
package projet_echec.echec.jeu.piece;

import java.io.IOException;

import projet_echec.echec.exception.DeplacementException;
import projet_echec.echec.jeu.Case;
import projet_echec.echec.jeu.EchiquierActif;
import projet_echec.echec.jeu.Piece;
import projet_echec.echec.jeu.Position;
import junit.framework.TestCase;

/**
 * @author Adrien
 *
 */
public class PionTest extends TestCase {
	
	public void testPresencePion(){
		Position p= new Position(1,1);
		Piece c= new Pion("noir",null);
		Case c1= new Case(p);
		c1.setPiece(c);
		assertEquals(c1.getPiece(),c);	
	}
	
	public void testdeplacerPion(){
		EchiquierActif E=null;
		try {
			E = new EchiquierActif();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Position p= new Position(1,1);
		Piece c= new Pion("noir",null);
		Case c1= new Case(p);
		c1.setPiece(c);
		Position ar= new Position(3,1);
		Case t2= new Case(ar);
		try {
			E.deplacer(c1,t2);
		} catch (DeplacementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Position ar1= new Position(4,1);
		Case t3= new Case(ar1);
		try {
			E.deplacer(t2,t3);
		} catch (DeplacementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(c,t3.getPiece());
	}
}
