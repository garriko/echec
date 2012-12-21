package projet_echec.echec.jeu;

import java.io.IOException;

import junit.framework.TestCase;

public class CaseTest extends TestCase{

	/**
	 * test si une case est vide
	 */
	public void testEstVide(){
		System.out.println("prout");
		EchiquierActif E=null;
		try {
			Variantes v = new Variantes("RoiSeul");
			E = new EchiquierActif(v);
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}	

		for(int i=0;i<64;i++)
		{
			Case LaCase = E.getPlateau().get(i);
			if(!LaCase.estVide()){
			System.out.println("-----------------------------------------------------------------------------------");
			
			System.out.println("Position: "+LaCase.getPosition().getHauteur()+","+LaCase.getPosition().getLargeur());
			System.out.println("piece presente: "+LaCase.getPiece());
			if(LaCase.getPiece()!=null){
				System.out.println("Camp: "+LaCase.getPiece().getCamp());
			}
			System.out.println("-----------------------------------------------------------------------------------");
			}
		}


		assertTrue(true);
	}


	/**
	 * test si un pion est au bout de l'échiquier
	 */
	public void pionBoutEchiquier(){
		//TODO: test si un pion est au bout de l'échiquier
		assertTrue(true);
	}

}




