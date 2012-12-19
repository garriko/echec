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
public class ReineTest extends TestCase {
	
		public void testPresenceReine(){
			Position p= new Position(1,1);
			Piece c= new Reine("noir");
			Case c1= new Case(p);
			c1.setPiece(c);
			assertEquals(c1.getPiece(),c);	
		}
		
		public void testdeplacerReine(){
			
			EchiquierActif E=null;
			try {
				E = new EchiquierActif();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			Position p= new Position(4,4);
			Piece c= new Reine("noir");
			Case c1= new Case(p);
			c1.setPiece(c);						
			Position ar= new Position(7,1);
			Piece pie= new Tour("blanc");
			Case t2= new Case(ar);
			t2.setPiece(pie);
			System.out.println(E.getListePieceEnJeu().size());
			try {
				E.deplacer(c1,t2);
			} catch (DeplacementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("doit renvoyer null");
			System.out.println(c1.getPiece());	
			System.out.println("si les deux valeurs suivante sont egale c'est gagne");
			System.out.println(c);
			System.out.println(t2.getPiece());
			
			System.out.println(E.getListePiecePrises());
			System.out.println(E.getListePieceEnJeu().size());
			assertTrue(c.equals(t2.getPiece()));
		}
}
