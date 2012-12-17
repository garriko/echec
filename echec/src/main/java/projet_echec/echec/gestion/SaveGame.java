package projet_echec.echec.gestion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import projet_echec.echec.jeu.Echiquier;




/**
 * Permet d'enregistrer ou de charger une partie et un échiquier
 * @author Kevin
 * @see Partie, Echiquier, Wrapper
 *
 */


public class SaveGame {
	
	/**
	 * Enregistre p et e (si non null)
	 * @param nomFichier Enregistre dans nomFichier.gech
	 * @throws IOException 
	 */
	public static void sauvegarder(String nomFichier, Partie p, Echiquier e) throws IOException
	{
		Wrapper w = new Wrapper(p,e);
	      try
	      {
	         FileOutputStream fileOut = new FileOutputStream(new String(nomFichier+".gech"));
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(w);
	         out.close();
	         fileOut.close();
	      }catch(IOException i)
	      {
	         throw i;
	      }
	}
	
	/**
	 * Charge le contenu de nomFichier.gech
	 * @param nomFichier
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void charger(String nomFichier) throws IOException, ClassNotFoundException
	{
		 try
         {
            FileInputStream fileIn = new FileInputStream(new String(nomFichier+".gech"));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Wrapper w = (Wrapper) in.readObject();
            in.close();
            fileIn.close();
        }
		 catch(IOException i)
        {
            throw i;
        }
		 catch(ClassNotFoundException c)
        {
            throw c;
        }
	}
}
