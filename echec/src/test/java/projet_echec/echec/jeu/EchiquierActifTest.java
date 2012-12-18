package projet_echec.echec.jeu;

import java.io.IOException;
import java.util.Vector;

import junit.framework.TestCase;

import projet_echec.echec.jeu.piece.Fou;
import projet_echec.echec.jeu.piece.Reine;
import projet_echec.echec.jeu.piece.Roi;
import projet_echec.echec.jeu.piece.Tour;
import projet_echec.echec.jeu.EchiquierActif;
import projet_echec.echec.jeu.Case;

public class EchiquierActifTest extends TestCase{
	
	/**
	 * test si lors d'une situation d'echec, la fonction testEchec() renvoit true
	 */
	public void testEchec(){
		EchiquierActif E=null;
		try {
			E = new EchiquierActif();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue( E.echec());
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
	
	public void  testestMenace(){
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
		Piece c= new Tour("noir",null);
		Case c1= new Case(p);
		c1.setPiece(c);
		
		Position q= new Position(1,3);
		Case q1= new Case(q);
		
		assertTrue(E.estMenace("blanc",q1));
		
	}		
	
	public void testlisterPiecesNoires(){
		
		Vector<Case> listepiece= new Vector<Case>();
		Position p= new Position(1,1);
		Piece c= new Fou("noir",null);
		Case c1= new Case(p);
		c1.setPiece(c);
		listepiece.add(c1);
		Position p1= new Position(1,2);
		Piece c2= new Roi("blanc",null);
		Case c3= new Case(p1);
		c3.setPiece(c2);
		listepiece.add(c3);
		Position q= new Position(1,3);
		Piece f= new Reine("blanc",null);
		Case f1= new Case(q);
		f1.setPiece(f);
		listepiece.add(f1);
		
		listepiece= EchiquierActif.listerPiecesNoires(listepiece);
		Vector<Case> listepiecetest= new Vector<Case>();
		listepiecetest.add(c1);
		
		assertEquals(listepiecetest,listepiece);
		
	}
		
	}
	
	

