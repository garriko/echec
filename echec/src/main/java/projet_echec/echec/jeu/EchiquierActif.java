package projet_echec.echec.jeu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import projet_echec.echec.exception.DeplacementException;
import projet_echec.echec.jeu.piece.Pion;
import projet_echec.echec.jeu.piece.Roi;

/**
 * 
 * @author Adrien
 * @version 0.0.1
 * @see Case, Echiquier
 * Cette classe permet de definir ce qu’il se passe sur l’echiquier lors d’une partie en cours.
 */
public class EchiquierActif extends Echiquier {
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

	private String campActif;


	/**
	 * constructeur de la classe
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public EchiquierActif() throws ClassNotFoundException, IOException{
		super();
		campActif = new String("blanc");
		findKings();
	}

	/**
	 * constructeur de la classe
	 * @param V variante choisie
	 */
	public EchiquierActif(Variantes V){
		super(V);
		campActif = new String("blanc");
		findKings();
	}
	/**
	 * Cherche les rois sur l'echiquier
	 * @return
	 */
	public void findKings(){
		for(int i=0;i<plateau.size();i++){
			if(!plateau.get(i).estVide())
				if(plateau.get(i).getPiece().getClass().getSimpleName().equals(new String("Roi")))
					if(plateau.get(i).getPiece().getCamp()=="noir")
						caseRoiNoir=plateau.get(i);
					else
						caseRoiBlanc=plateau.get(i);
		}
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
		{//TODO: creer une exception
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
	 * regarde si la case e est menace par le camp c
	 * @param c
	 * @param e
	 * @return liste de piece qui menace la case
	 */
	public Vector<Case> estMenacePar(String c, Case e){
		Vector<Case> listePieceAdverse= new Vector<Case>();
		Vector<Case> listePieceMenacante= new Vector<Case>();
		if (c=="noir")
		{
			listePieceAdverse= listerPiecesNoires(this.listePieceEnJeu);

		}
		else if(c=="blanc")
		{
			listePieceAdverse= listerPiecesBlanches(this.listePieceEnJeu);
		}
		else 
		{//TODO: creer une exception
		}
		for(int i=0;i<listePieceAdverse.size();i++){//pour toutes les pieces adverses

			for (int j=0;j<listePieceAdverse.get(i).getPiece().getDeplacementPossible(listePieceAdverse.get(i)).size();i++){//pour tous les deplacements de chaque piece
				if (listePieceAdverse.get(i).getPiece().getDeplacementPossible(listePieceAdverse.get(i)).get(j).equals(e)){//la case e est égale a la case que l'on veut tester
					listePieceMenacante.add(listePieceAdverse.get(i));
				}
			}
		}
		return listePieceMenacante;
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
	 * @param camp camp du joueur a tester
	 * @return true si le camp camp est en echec et mat
	 */
	public boolean echecEtMat(String camp){
		int compteurCaseMenacee=0;
		Vector<Case> listePieceMenacante = new Vector<Case>();
		Vector<Case> listePieceDefendent = new Vector<Case>();
		ArrayList<Case>  listeCaseDeplacementMenacant= new ArrayList<Case>();
		ArrayList<Case> listeCaseDeplacementDefendent= new ArrayList<Case>();

		boolean estenechecetmat=true;
		//test si le roi peut se deplacer

		if(camp=="noir"){//si le Roi noir est en echec
			ArrayList<Case> casePossible = filtrerDeplacementPossible(camp,this.caseRoiNoir.getPiece().getDeplacementPossible(this.caseRoiNoir));
			for (int i=0;i<casePossible.size()+1;i++)
			{
				if(estMenace("blanc",casePossible.get(i))){
					compteurCaseMenacee++;
				}
			}
			if(compteurCaseMenacee==casePossible.size()){
				listePieceMenacante = estMenacePar("blanc",this.caseRoiNoir);//on a ici la liste de cases (contenant les pieces) menacant le Roi
				listePieceDefendent= listerPiecesNoires(this.listePieceEnJeu);;//on a ici la liste de cases qui peuvent potentiellement defendre le Roi
			}
			for (int i=0;i<listePieceMenacante.size();i++){//pour toutes les cases de pieces qui menacent

				listeCaseDeplacementMenacant.add(listePieceMenacante.get(i));
			}
			for (int j=0;j<listePieceDefendent.size();j++){//pour toutes les cases de pieces qui defendent
				listeCaseDeplacementDefendent=listePieceDefendent.get(j).getPiece().getDeplacementPossible(listePieceDefendent.get(j));;
			}
			for (int j=0;j<listeCaseDeplacementMenacant.size();j++){
				if(listeCaseDeplacementDefendent.contains(listeCaseDeplacementMenacant.get(j))){
					estenechecetmat=false;
				}
			}

		}
		else{
			ArrayList<Case> casePossible = filtrerDeplacementPossible(camp,this.caseRoiBlanc.getPiece().getDeplacementPossible(this.caseRoiBlanc));
			for (int i=0;i<casePossible.size();i++)
			{
				if(estMenace("noir",casePossible.get(i))){
					compteurCaseMenacee++;
				}
			}
			if(compteurCaseMenacee==casePossible.size()){
				listePieceMenacante = estMenacePar("noir",this.caseRoiBlanc);//on a ici la liste de cases (contenant les pieces) menacant le Roi
				listePieceDefendent= listerPiecesBlanches(this.listePieceEnJeu);;//on a ici la liste de cases qui peuvent potentiellement defendre le Roi
			}
			for (int i=0;i<listePieceMenacante.size();i++){//pour toutes les cases de pieces qui menacent
				listeCaseDeplacementMenacant=listePieceMenacante.get(i).getPiece().getDeplacementPossible(listePieceMenacante.get(i));
				listeCaseDeplacementMenacant.add(listePieceMenacante.get(i));
			}
			for (int j=0;j<listePieceDefendent.size();j++){//pour toutes les cases de pieces qui defendent
				listeCaseDeplacementDefendent=listePieceDefendent.get(j).getPiece().getDeplacementPossible(listePieceDefendent.get(j));;
			}
			for (int j=0;j<listeCaseDeplacementMenacant.size();j++){
				if(listeCaseDeplacementDefendent.contains(listeCaseDeplacementMenacant.get(j))){
					estenechecetmat=false;
				}
			}

		}
		return estenechecetmat;	
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
	 * @return "rien" si il n'y a pas eu de deplacement, le deplacement en notation algebrique sinon
	 * @throws DeplacementException 
	 */
	public String selectionnerCase(Case caseSelectionne) throws DeplacementException{

		System.out.println(caseSelectionne.getPosition().getHauteur()+","+caseSelectionne.getPosition().getLargeur());

		if(this.caseSelectionne==null)
		{
			System.out.println("1");
			if(!caseSelectionne.estVide())
			{			
				System.out.println("11");
				if(caseSelectionne.getPiece().getCamp().equals(campActif))
				{
					System.out.println("111");
					this.caseSelectionne=caseSelectionne;
					//System.out.println(this.caseSelectionne.getPiece());
					return "rien";
				}
				else{
					System.out.println("112");
					return "rien";
				}
			}
			else
			{
				System.out.println("12");
				return "rien";
			}

		}
		else
		{
			System.out.println("2");
			if(this.caseSelectionne.equals(caseSelectionne))
			{
				System.out.println("21");
				this.caseSelectionne=null;
				return "rien";
			}
			else
			{
				System.out.println("22");
				String dep;
				dep = deplacer(this.caseSelectionne,caseSelectionne);
				this.caseSelectionne=null;
				if(!dep.equals("rien"))
					if(campActif.equals("blanc"))
						campActif = new String("noir");
					else
						campActif = new String("blanc");
				return dep;
			}

		}


	}
	/**
	 * Permet le deplacement des pieces
	 * @param caseDepart : le joueur a selectionne une piece sur le plateau
	 * @param caseArrivee: le joueur a selectionne une case d'arrivee sur le plateau
	 * @throws DeplacementException 
	 */
	public String deplacer(Case caseDepart, Case caseArrivee) throws DeplacementException
	{
		String res=getNotationAlgebrique(caseDepart, caseArrivee);;
		Case sauvegardecasearrive = caseArrivee;
		deplacersanscondition(caseDepart,caseArrivee);
		if(campActif=="noir")
		{
			if(echec()!=11 && echec()!=21){
				mangerPiece(caseArrivee);//pas echec donc le deplacement se fait
				return res;
			}
			else
			{	
				deplacersanscondition(caseArrivee,caseDepart);
				caseArrivee=sauvegardecasearrive;
				//attention: il n'y as pas de deplacement effectif
				return "rien";
			}

		
		}
		else
		{
		if(echec()!=12 && echec()!=22){ //Si le deplacement ne provoque pas de mise en danger du roi
				mangerPiece(caseArrivee);
				return res;
			}
			else{
				deplacersanscondition(caseArrivee,caseDepart);	
				caseArrivee=sauvegardecasearrive;
				return "rien";
			}
			
		}
			
		
		
	}

	public void mangerPiece(Case caseArrivee )
	{
		if(!caseArrivee.estVide())//si il y a une case a l'arrivee
		{
			this.listePiecePrises.add(caseArrivee.getPiece());//on ajoute la piece dans la liste des pieces prises

			for(int j=0; j< listePieceEnJeu.size();j++)//pour toutes les pieces en jeu
				if(this.listePieceEnJeu.get(j).equals(caseArrivee))//si il y a une case egale a la case d'arrivee
					this.listePieceEnJeu.remove(j);//on la supprime
		}
	}


	/**
	 * fait un deplacement sans test d'echec
	 * @param caseDepart
	 * @param caseArrivee
	 */
	public void deplacersanscondition(Case caseDepart, Case caseArrivee){
		ArrayList<Case> plop = new ArrayList<Case>();

		plop = caseDepart.getPiece().getDeplacementPossible(caseDepart);//donne les déplacements possible de la piece présent sur la case depart

		plop = filtrerDeplacementPossible(caseDepart.getPiece().getCamp(), plop);//filtre si il n'y pas de pieces


		if(caseDepart.getPiece().getClass().getSimpleName().equals(new String("Pion"))){
			filtrerpresenceAdversaireDiagonale(caseDepart,plop);
		}

		for(int i=0; i< plop.size();i++){

			if(plop.get(i).getPosition().equals(caseArrivee.getPosition())){
				if(caseDepart.getPiece().getClass().getSimpleName().equals("Roi"))
				{
					if(caseDepart.getPiece().getCamp().equals("noir"))
						this.caseRoiNoir.setPosition(caseArrivee.getPosition());
					if(caseDepart.getPiece().getCamp().equals("blanc"))
						this.caseRoiBlanc.setPosition(caseArrivee.getPosition());
				}
				changerCase(caseDepart, caseArrivee);
			}
		}
	}

	
	
	public String getNotationAlgebrique(Case caseDepart, Case caseArrivee){
		String nota = new String();
		nota = nota.concat(String.valueOf(caseDepart.getPosition().getHauteur())+String.valueOf(caseDepart.getPosition().getLargeur()));
		
		if(caseArrivee.estVide())
			nota= nota.concat("-");
		else
			nota= nota.concat("x");
		
		nota = nota.concat(String.valueOf(caseArrivee.getPosition().getHauteur())+String.valueOf(caseArrivee.getPosition().getLargeur()));
		
		return nota;
	}


	/**
	 * Methode utile pour la classe Pion. modifie le fetdeplacementPossible selon la presence d'une piece adverse en diagonale par rapport a la
	 * direction d'avancee du pion
	 * @param caseActuelle :case du pion
	 * @param res : le getdeplacement de la piece
	 */

	private void filtrerpresenceAdversaireDiagonale(Case caseActuelle,ArrayList<Case> casePossible){
		//System.out.println(casePossible.size());
		for(int i=0; i < casePossible.size();i++){
			//System.out.println(i);
			Case c = casePossible.get(i);
			//System.out.println(c.getPosition().getHauteur()+","+c.getPosition().getLargeur());
			//System.out.println(caseActuelle.getPosition().getLargeur());
			if(c.getPosition().getLargeur()==caseActuelle.getPosition().getLargeur()+1 || c.getPosition().getLargeur()==caseActuelle.getPosition().getLargeur()-1)
			{
				if(c.estVide())
				{
					casePossible.remove(c);
					i--;
				}
				else if(c.getPiece().getCamp().equals(caseActuelle.getPiece().getCamp()))
				{
					casePossible.remove(c);
					i--;
				}

			}
		}

	}

	/**
	 * Filtre la liste selon la presence d'une pièce du meme camp
	 * @param camp camp de la piece de la case de depart
	 * @param casePossible Liste des cases possibles, a filtrer
	 * @return Liste filtree
	 */
	private ArrayList<Case> filtrerDeplacementPossible(String camp,ArrayList<Case> casePossible)
	{
		Case caseplateau;
		for(int i=0;i<(casePossible.size());i++){
			caseplateau=chercherCase(casePossible.get(i).getPosition());
			System.out.println(caseplateau);

			if((!caseplateau.estVide())){
				System.out.println(caseplateau.getPosition().getHauteur()+","+caseplateau.getPosition().getLargeur());
				System.out.println(caseplateau.getPiece().getCamp());
				if(caseplateau.getPiece().getCamp().equals(camp))
				{
					casePossible.remove(casePossible.get(i));
					i--;
				}
			}	
		}
		return casePossible;
	}

	public static Vector<Case> listerPiecesBlanches(Vector<Case> liste){

		Vector<Case> listepiece= new Vector<Case>();
		for(int i=0;i<liste.size();i++){// Pour toutes les pieces en jeu
			if(!liste.get(i).estVide())
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
			if(!liste.get(i).estVide())
				if (liste.get(i).getPiece().getCamp()=="noir"){//si dans la liste la piece est noires
					listepiece.add(liste.get(i));//ajoute dans la liste des pieces adverses les pieces noires
				}
		}
		return listepiece;		
	}


	/**
	 * getter/setter
	 */


	public Case getCaseSelectionne() {
		return caseSelectionne;
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



}
