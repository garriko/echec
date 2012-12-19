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
public class TourTest extends TestCase {
	
	public void testPresenceTour(){
		Position p= new Position(1,1);
		Piece c= new Tour("noir");
		Case c1= new Case(p);
		c1.setPiece(c);
		assertEquals(c1.getPiece(),c);	
	}
	
	
	
	
	public void testdeplacerTour(){
		/**
		 * met les pieces sur des cases
		 */
		
		EchiquierActif E=null;
		Piece t= new Tour("blanc");
		
		try {
			E = new EchiquierActif();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		Position p= new Position(1,1);
		t=E.chercherCase(p).getPiece();
		Position ar= new Position(2,1);
		
		
		try {
			E.deplacer(E.chercherCase(p),E.chercherCase(ar));
			
		} catch (DeplacementException e) {
			e.printStackTrace();
		}
		
		assertEquals(t,E.chercherCase(ar).getPiece());
		
	}

}
