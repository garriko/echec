package projet_echec.echec.jeu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import projet_echec.echec.wrapper.VariantWrapper;
import projet_echec.echec.wrapper.Wrapper;

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
	         FileOutputStream fileOut = new FileOutputStream(new String(nomVariante+".vech"));
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
           FileInputStream fileIn = new FileInputStream(new String(nomVariante+".gech"));
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
	 */
	public void ajouterPiece(Case c, Piece p){
		//TODO : Throws exception si la case n'existe pas ou contient déjà une pièce
	}
	
	/**
	 * Retire la piece contenue dans la case c du plateau
	 * 
	 * @param c case du plateau
	 */
	public void retirerPiece(Case c){
		//TODO : Throws exception si la case ne contient pas une pièce
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
}
