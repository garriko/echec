package projet_echec.echec.gestion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import projet_echec.echec.jeu.Echiquier;
import projet_echec.echec.wrapper.Wrapper;




/**
 * Permet d'enregistrer ou de charger une partie et un echiquier
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
	         FileOutputStream fileOut = new FileOutputStream(new String("partie en cours/"+nomFichier+".gech"));
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
	 * Charge le contenu de nomFichier.gech
	 * @param nomFichier
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @return un Wrapper contenant une Partie et un Echiquier
	 */
	public static Wrapper charger(String nomFichier) throws IOException, ClassNotFoundException
	{
		Wrapper w;
		 try
         {
            FileInputStream fileIn = new FileInputStream(new String("partie en cours/"+nomFichier+".gech"));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            w = (Wrapper) in.readObject();
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
}
