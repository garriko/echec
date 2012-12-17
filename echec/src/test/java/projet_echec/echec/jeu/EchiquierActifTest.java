package projet_echec.echec.jeu;

import junit.framework.TestCase;

import projet_echec.echec.jeu.piece.Cavalier;
import projet_echec.echec.jeu.piece.Fou;
import projet_echec.echec.jeu.piece.Pion;
import projet_echec.echec.jeu.piece.Reine;
import projet_echec.echec.jeu.piece.Roi;
import projet_echec.echec.jeu.piece.Tour;

public class EchiquierActifTest extends TestCase{
	
	/**
	 * test si lors d'une situation d'echec, la fonction testEchec() renvoit true
	 */
	public void testEchec(){
		
		assertTrue( true );
		//TODO : test echec
		
	}
	
	/**
	 * test si lors d'une situation d'echec et mat, la fonction echecEtMat() renvoit true
	 */
	public void testechecEtMat(){
		
		assertTrue( true );
		//TODO : test echec et mat
	}
	
	/**
	 * test si lors d'une situation de pat, la fonction pat() renvoit true
	 */
	public void testpat(){
		
		assertTrue( true );
		//TODO :test pat
		
	}
	/**
	 * test lorsque l'interface renvoi une case Selectionné que l'on recupère bien la valeur dans CaseSelectionné
	 */
	public void testselectionnerCase(){
		
		assertTrue( true );
		//TODO : test selectionner case
	}
	
	/**
	 * test lorsque l'on sélectionne deux cases l'un aprés l'autre, qu el'on déplace la pièce de la première à la deuxième case
	 */
	public void testdeplacerTour(){
		/**
		 * met les pieces sur des cases
		 */
		
		EchiquierActif E= new EchiquierActif();
		
		Position p= new Position(1,1);
		Piece t= new Tour("noir");
		Case t1= new Case(p);
		t1.setPiece(t);
		Position ar= new Position(3,1);
		Case t2= new Case(ar);
		E.deplacer(t1,t2);
		assertEquals(t,t2.getPiece());
	}
		
	public void testdeplacerCavalier(){
		EchiquierActif E= new EchiquierActif();
		Position p= new Position(1,1);
		Piece c= new Cavalier("noir");
		Case c1= new Case(p);
		c1.setPiece(c);
		Position ar= new Position(3,2);
		Case t2= new Case(ar);
		E.deplacer(c1,t2);
		assertEquals(c,t2.getPiece());
	}
		
	public void testdeplacerFou(){
		EchiquierActif E= new EchiquierActif();
		Position p= new Position(1,1);
		Piece c= new Fou("noir");
		Case c1= new Case(p);
		c1.setPiece(c);
		Position ar= new Position(3,3);
		Case t2= new Case(ar);
		E.deplacer(c1,t2);
		assertEquals(c,t2.getPiece());
	}
	
	
	public void testdeplacerRoi(){
		EchiquierActif E= new EchiquierActif();
		Position p= new Position(1,1);
		Piece c= new Roi("noir");
		Case c1= new Case(p);
		c1.setPiece(c);
		Position ar= new Position(2,2);
		Case t2= new Case(ar);
		E.deplacer(c1,t2);
		assertEquals(c,t2.getPiece());
	}
		
	public void testdeplacerReine(){
		EchiquierActif E= new EchiquierActif();
		Position p= new Position(1,1);
		Piece c= new Reine("noir");
		Case c1= new Case(p);
		c1.setPiece(c);
		Position ar= new Position(4,4);
		Case t2= new Case(ar);
		E.deplacer(c1,t2);
		assertEquals(c,t2.getPiece());
	}
		
	public void testdeplacerPion(){
		EchiquierActif E= new EchiquierActif();
		Position p= new Position(1,1);
		Piece c= new Pion("noir");
		Case c1= new Case(p);
		c1.setPiece(c);
		Position ar= new Position(3,1);
		Case t2= new Case(ar);
		E.deplacer(c1,t2);
		Position ar1= new Position(4,1);
		Case t3= new Case(ar1);
		E.deplacer(t2,t3);
		assertEquals(c,t3.getPiece());
	}
		
	}
	
	

