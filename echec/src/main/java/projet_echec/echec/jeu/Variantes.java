package projet_echec.echec.jeu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import projet_echec.echec.exception.CaseErrorException;
import projet_echec.echec.exception.EmptyCaseException;
import projet_echec.echec.exception.FullCaseException;
import projet_echec.echec.jeu.piece.Cavalier;
import projet_echec.echec.jeu.piece.Fou;
import projet_echec.echec.jeu.piece.Pion;
import projet_echec.echec.jeu.piece.Reine;
import projet_echec.echec.jeu.piece.Roi;
import projet_echec.echec.jeu.piece.Tour;
import projet_echec.echec.wrapper.VariantWrapper;


/**
 * Cette classe gere les placements initiaux des pieces.
 * @author Kevin
 * @version 0.0.1
 * @see Case
 *  
 */


public class Variantes {

	private Vector<Case> plateau;
	private Vector<Case> listePieces;
	
	/**
	 * Constructeur par defaut de la classe Variantes
	 * Initialise le plateau et la liste des pieces.
	 * A utiliser pour creer une variante.
	 * 
	 */
	public Variantes() {
		plateau = new Vector<Case>();
		for(int h=1;h<=8;h++)
			for(int l=1;l<=8;l++)
				plateau.add(new Case(new Position(h,l)));
		listePieces=new Vector<Case>();
	}
	
	/**
	 * Constructeur de la classe Variantes
	 * Initialise le plateau et la liste des pieces selon la variante choisie
	 * 
	 * @param nomVariante nom de la variante choisie
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Variantes(String nomVariante) throws ClassNotFoundException, IOException{
		VariantWrapper w = chargerVariante(nomVariante);
		plateau = w.getPlateau();
		listePieces=w.getListePieces();
	}
	
	/**
	 * Enregistre la variante dans un fichier nomVariante.vech
	 * @param nomVariante
	 * @throws IOException 
	 */
	public void saveVariante(String nomVariante) throws IOException
	{
		VariantWrapper w = new VariantWrapper(plateau,listePieces);
	      try
	      {
	         FileOutputStream fileOut = new FileOutputStream(new String("variantes/"+nomVariante+".vech"));
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(w);
	         out.close();
	         fileOut.close();
	      }catch(IOException i) //Si le fichier n'est pas trouvé
	      {
	         throw i;
	      }
	}
	
	/**
	 * Charge la variante situee dans le fichier nomVariante.vech
	 * @param nomVariante
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public VariantWrapper chargerVariante(String nomVariante) throws IOException, ClassNotFoundException{
		VariantWrapper w;
		 try
        {
           FileInputStream fileIn = new FileInputStream(new String("variantes/"+nomVariante+".vech"));
           ObjectInputStream in = new ObjectInputStream(fileIn);
           w = (VariantWrapper) in.readObject();
           in.close();
           fileIn.close();
       }
		 catch(IOException i) //Si le fichier n'est pas trouvé
       {
           throw i;
       }
		 catch(ClassNotFoundException c) //Si le contenu du fichier est incorrect
       {
           throw c;
       }
		 return w;
		
	}
	
	/**
	 * Place la piece p dans la case c du plateau
	 * 
	 * @param c case du plateau
	 * @param p pièce à ajouter
	 * @throws FullCaseException 
	 * @throws CaseErrorException 
	 */
	public void ajouterPiece(Case c, Piece p) throws FullCaseException, CaseErrorException{
		for(int i=0;i<plateau.size();i++){
			Case currentCase = plateau.get(i);
			if(currentCase.equals(c))
				if(currentCase.estVide())
					currentCase.setPiece(p);
				else
					throw new FullCaseException();
			else
				throw new CaseErrorException();
		}
	}
	
	/**
	 * Retire la piece contenue dans la case c du plateau
	 * 
	 * @param c case du plateau
	 * @throws EmptyCaseException 
	 * @throws CaseErrorException 
	 */
	public void retirerPiece(Case c) throws EmptyCaseException, CaseErrorException{
		//TODO : Throws exception si la case ne contient pas une pièce
		for(int i=0;i<plateau.size();i++){
			Case currentCase = plateau.get(i);
			if(currentCase.equals(c))
				if(currentCase.estVide())
					throw new EmptyCaseException();
				else
					currentCase.setPiece(null);
			else
				throw new CaseErrorException();
		}
	}
	
	
	/**
	 * 
	 * @return Renvoie l'echiquier de la variante
	 */
	public Vector<Case> getPlateau() {
		return plateau;
	}
	/**
	 * 
	 * @return Renvoie la liste des pieces utilisees dans la variante
	 */
	public Vector<Case> getListePieces() {
		return listePieces;
	}
/*
	public static void main(String[] args) {
		Variantes v =new Variantes();
		try {
			v.ajouterPiece(new Case(new Position(1,1)), new Tour("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(1,2)), new Cavalier("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(1,3)), new Fou("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(1,4)), new Reine("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(1,5)), new Roi("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(1,6)), new Fou("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(1,7)), new Cavalier("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(1,8)), new Tour("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(2,1)), new Pion("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(2,2)), new Pion("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(2,3)), new Pion("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(2,4)), new Pion("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(2,5)), new Pion("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(2,6)), new Pion("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		

		
		try {
			v.ajouterPiece(new Case(new Position(2,7)), new Pion("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(2,8)), new Pion("blanc",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(8,1)), new Tour("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(8,2)), new Cavalier("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(8,3)), new Fou("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(8,4)), new Reine("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(8,5)), new Roi("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(8,6)), new Fou("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(8,7)), new Cavalier("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(8,8)), new Tour("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(7,1)), new Pion("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(7,2)), new Pion("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(7,3)), new Pion("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(7,4)), new Pion("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(7,5)), new Pion("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(7,6)), new Pion("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		

		
		try {
			v.ajouterPiece(new Case(new Position(7,7)), new Pion("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.ajouterPiece(new Case(new Position(7,8)), new Pion("noir",null));
		} catch (FullCaseException e) {
			
			e.toString();
		} catch (CaseErrorException e) {
			
			e.toString();
		}
		
		try {
			v.saveVariante("classique");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	*/
}
