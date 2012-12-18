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
public class ReineTest extends TestCase {
	
		public void testPresenceReine(){
			Position p= new Position(1,1);
			Piece c= new Reine("noir",null);
			Case c1= new Case(p);
			c1.setPiece(c);
			assertEquals(c1.getPiece(),c);	
		}
		
		public void testdeplacerReine(){
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
			Piece c= new Reine("noir",null);
			Case c1= new Case(p);
			c1.setPiece(c);
			Position ar= new Position(4,4);
			Case t2= new Case(ar);
			try {
				E.deplacer(c1,t2);
			} catch (DeplacementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals(c,t2.getPiece());
		}
}
