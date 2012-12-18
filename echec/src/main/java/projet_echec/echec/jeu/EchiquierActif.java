package projet_echec.echec.jeu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Vector;

import projet_echec.echec.exception.DeplacementException;

/**
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Case, Echiquier
 * Cette classe permet de definir ce qu’il se passe sur l’echiquier lors d’une partie en cours.
 */
public class EchiquierActif extends Echiquier {
	/**
	 * Temps restant au joueur avant la fin de son tour 
	 */
	private Timer tempsRestant;
	/**
	 * Temps total du jeu depuis le debut de la partie
	 */
	private Timer tempsTotal;
	/**
	 * Case selectionnee par le joueur ( via l'interface graphique)
	 */
	private Case caseSelectionne;
	/**
	 * case ou se situe le roi blanc
	 */
	private Case caseRoiBlanc;
	/**
	 * case ou se situe le roi noir
	 */
	private Case caseRoiNoir;
	
	
	/**
	 * constructeur de la classe
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public EchiquierActif() throws ClassNotFoundException, IOException{
		super();
	}
	
	/**
	 * constructeur de la classe
	 * @param V variante choisie
	 */
	public EchiquierActif(Variantes V){
		super(V);
	}
	
	/**
	 * regarde si la case e est menace par le camp c
	 * @param c
	 * @param e
	 * @return 
	 */
	public boolean estMenace(String c, Case e){
		boolean estmenace= false;
		Vector<Case> listePieceAdverse= new Vector<Case>();
		if (c=="noir")
		{
			listePieceAdverse= listerPiecesNoires(this.listePieceEnJeu);
			
		}
		else if(c=="blanc")
		{
			listePieceAdverse= listerPiecesBlanches(this.listePieceEnJeu);
		}
		else 
		{//TODO: creer une exeption
		}
		for(int i=0;i<listePieceAdverse.size();i++){//pour toutes les pieces adverses
			
			for (int j=0;j<listePieceAdverse.get(i).getPiece().getDeplacementPossible(listePieceAdverse.get(i)).size();i++){//pour tous les deplacements de chaque piece
			if (listePieceAdverse.get(i).getPiece().getDeplacementPossible(listePieceAdverse.get(i)).get(j).equals(e)){//la case e est égale a la case que l'on veut tester
				estmenace=true;
			}
		}
	}
		return estmenace;
	}
	/**
	 * Test si on est en position d'echec
	 * @return 0 si pas d'echec, 1 si echec, 2 si echec et mat. puis 1 si noir et 2 si blanc
	 * donc echec au roi noir: 11
	 * 		echec et mat au roi blanc: 22
	 * 		pas echec=0
	 */
	public int echec(){
		int a= 0;
		if(estMenace("noir",caseRoiNoir)) {
			a=11;
			}
		if(estMenace("blanc",caseRoiBlanc)){
			a=12;
		}
		if(a==11 && echecEtMat("noir")){a=21;}
		
		if(a==12 && echecEtMat("blanc")){a=22;}
		
		return a;	
	}
	/**
	 * renvoi la liste des pieces blanches
	 * @param liste
	 * @return
	 */
	
	/**
	 * Test si on est en position d'echec et mat
	 * @param camp camp du joueuru a tester
	 * @return true si le camp camp est en echec et mat
	 */
	public boolean echecEtMat(String camp){
		int compteurCaseMenacee=0;
		//test si le roi peut se deplacer
		if(camp=="noir"){
			ArrayList<Case> casePossible = filtrerDeplacementPossible(camp,caseRoiNoir.getPiece().getDeplacementPossible(caseRoiNoir));
			for (int i=0;i<casePossible.size()+1;i++)
			{
				if(estMenace("blanc",casePossible.get(i))){
					compteurCaseMenacee++;
				}
				
			}
			if(compteurCaseMenacee==casePossible.size()){
				//TODO :test si des pieces peuvent se mettre sur la trajectoire du roi
			}
		}
		else{
			ArrayList<Case> casePossible = filtrerDeplacementPossible(camp,caseRoiBlanc.getPiece().getDeplacementPossible(caseRoiBlanc));
			for (int i=0;i<casePossible.size()+1;i++)
			{
				if(estMenace("noir",casePossible.get(i))){
					compteurCaseMenacee++;
				}
				
			}
			if(compteurCaseMenacee==casePossible.size()){
				//TODO : test si des pieces peuvent se mettre sur la trajectoire du roi
			}
		}
		
		
		
		
		
		
		return true;
		
		
	}
	/**
	 * Test si on est en position de pat
	 * @return true si l'un des joueurs est en pat
	 */
	public boolean pat(){
		boolean a;
		a=true;
		return a;
		//TODO : pat
	}
	/**
	 * recupere la case selectionne envoye par l'interface graphique
	 * @param caseSelectionne
	 */
	public void selectionnerCase(Case caseSelectionne){
		//TODO : selectionner case
		
	}
	/**
	 * Permet le deplacement des pieces
	 * @param caseDepart : le joueur a selectionne une piece sur le plateau
	 * @param caseArrivee: le joueur a selectionne une case d'arrivee sur le plateau
	 * @throws DeplacementException 
	 */
	public void deplacer(Case caseDepart, Case caseArrivee) throws DeplacementException{
		//TODO : modifier deplacement pour roi en echec
		ArrayList<Case> plop = new ArrayList<Case>();
		plop = caseDepart.getPiece().getDeplacementPossible(caseDepart);//donne les déplacements possible de la piece présent sur la case depart
		plop = filtrerDeplacementPossible(caseDepart.getPiece().getCamp(), plop);//filtre si il n'y pas de pieces
		if(plop.contains(caseArrivee)){
			if(!caseArrivee.estVide())//si il y a une case a l'arrivee
			{
				this.listePiecePrises.add(caseArrivee.getPiece());//on ajoute la piece dans la liste des pieces prises
				
				for(int j=0; j< listePieceEnJeu.size();j++)//pour toutes les pieces en jeu
					if(listePieceEnJeu.get(j).equals(caseArrivee))//si il y a une case egale a la case d'arrivee
						listePieceEnJeu.remove(j);//on la supprime
				changerCase(caseDepart,caseArrivee);
			}
			
		}
		else
			throw new DeplacementException();
	}
	
	/**
	 * Methode utile pour la classe Pion. Renvoie 0,1 ou 2 cases selon la presence d'une piece adverse en diagonale par rapport a la
	 * direction d'avancee du pion
	 * @param caseActuelle case du pion
	 * @return 0,1 ou 2 cases
	 */

	public ArrayList<Case>[] presenceAdversaireDiagonale(Case caseActuelle){
		ArrayList<Case> res=new ArrayList<Case>();
		if(caseActuelle.getPiece().getCamp()=="blanc"){
			Case c0 = chercherCase(new Position(caseActuelle.getPosition().getHauteur()+1,caseActuelle.getPosition().getLargeur()-1));
			if(!c0.estVide())
				if(c0.getPiece().getCamp()!="blanc")
					res.add(c0);
			Case c1 = chercherCase(new Position(caseActuelle.getPosition().getHauteur()+1,caseActuelle.getPosition().getLargeur()+1));
			if(!c1.estVide())
				if(c1.getPiece().getCamp()!="blanc")
					res.add(c1);
		}
		else
		{
			Case c0 = chercherCase(new Position(caseActuelle.getPosition().getHauteur()+1,caseActuelle.getPosition().getLargeur()-1));
			if(!c0.estVide())
				if(c0.getPiece().getCamp()=="blanc")
					res.add(c0);
			Case c1 = chercherCase(new Position(caseActuelle.getPosition().getHauteur()+1,caseActuelle.getPosition().getLargeur()+1));
			if(!c1.estVide())
				if(c1.getPiece().getCamp()=="blanc")
					res.add(c1);
			
		}
		return null;
	}
	
	/**
	 * Filtre la liste selon la presence d'une pièce du meme camp
	 * @param camp camp de la piece de la case de depart
	 * @param casePossible Liste des cases possibles, a filtrer
	 * @return Liste filtree
	 */
	private ArrayList<Case> filtrerDeplacementPossible(String camp,ArrayList<Case> casePossible)
	{
		//TODO : implémenter la méthode
		return null;
	}
	
public Vector<Case> listerPiecesBlanches(Vector<Case> liste){
		
		Vector<Case> listepiece= new Vector<Case>();
		for(int i=0;i<liste.size();i++){// Pour toutes les pieces en jeu
			if (liste.get(i).getPiece().getCamp()=="blanc"){//si dans la liste la piece est blanche
				listepiece.add(liste.get(i));//ajoute dans la liste des pieces adverses les pieces noires
			}
		}
			return listepiece;		
	}
	/**
	 * renvoi la liste des pieces noir
	 */
public static Vector<Case> listerPiecesNoires(Vector<Case> liste){
		
		Vector<Case> listepiece= new Vector<Case>();
		for(int i=0;i<liste.size();i++){// Pour toutes les pieces en jeu
			if (liste.get(i).getPiece().getCamp()=="noir"){//si dans la liste la piece est noires
				listepiece.add(liste.get(i));//ajoute dans la liste des pieces adverses les pieces noires
			}
		}
			return listepiece;		
	}
	
	
	/**
	 * getter/setter
	 */
	public Timer getTempsRestant() {
		return tempsRestant;
	}

	public void setTempsRestant(Timer tempsRestant) {
		this.tempsRestant = tempsRestant;
	}

	public Timer getTempsTotal() {
		return tempsTotal;
	}

	public void setTempsTotal(Timer tempsTotal) {
		this.tempsTotal = tempsTotal;
	}

	public Case getCaseSelectionne() {
		return caseSelectionne;
	}

	public void setCaseSelectionne(Case caseSelectionne) {
		this.caseSelectionne = caseSelectionne;
	}

	public Case getCaseRoiBlanc() {
		return caseRoiBlanc;
	}

	public void setCaseRoiBlanc(Case caseRoiBlanc) {
		this.caseRoiBlanc = caseRoiBlanc;
	}

	public Case getCaseRoiNoir() {
		return caseRoiNoir;
	}

	public void setCaseRoiNoir(Case caseRoiNoir) {
		this.caseRoiNoir = caseRoiNoir;
	}
	

	public static void main(String[] args) {
		EchiquierActif E=null;
		System.out.println("test");
		try {
			E = new EchiquierActif();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		finally{
			
			System.out.println(E.echec());
		}
	}
}
