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
	private Case caseRoiBlanc=new Case(new Position(12,12));;
	/**
	 * case ou se situe le roi noir
	 */
	private Case caseRoiNoir=new Case(new Position(12,12));

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
					if(plateau.get(i).getPiece().getCamp().equals("noir")){
						caseRoiNoir.setPosition(plateau.get(i).getPosition());
						caseRoiNoir.setPiece(new Roi("noir"));
					}
					else if(plateau.get(i).getPiece().getCamp().equals("blanc"))
						{
						caseRoiBlanc.setPosition(plateau.get(i).getPosition());
						caseRoiBlanc.setPiece(new Roi("blanc"));
						}
		}
	}

	/**
	 * regarde si la case e est menace par le camp c
	 * @param c
	 * @param e
	 * @return 
	 */
	public boolean estMenace(String camp, Case e){
		boolean estmenace= false;
		Vector<Case> listePieceAdverse= new Vector<Case>();
		if (camp.equals("noir"))
		{
			
			listePieceAdverse= listerPiecesNoires(this.listePieceEnJeu);
		}
		else if(camp.equals("blanc"))
		{
			
			listePieceAdverse= listerPiecesBlanches(this.listePieceEnJeu);
		}
		else 
		{
			System.out.println("case noirblanc");
		}
		
	
		for(int i=0;i<listePieceAdverse.size();i++)//pour toutes les pieces adverses
		{
			ArrayList<Case> deplacementPieceAdverse = filtreGeneral(listePieceAdverse.get(i));
			for (int j=0;j<deplacementPieceAdverse.size();j++){//pour tous les deplacements possibles de la piece courante
				if (deplacementPieceAdverse.get(j).getPosition().equals(e.getPosition())){//Si les deux cases ont la même position
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
	public Vector<Case> estMenacePar(String camp, Case e){
		Vector<Case> listePieceAdverse= new Vector<Case>();
		Vector<Case> listePieceMenacante= new Vector<Case>();
		System.out.println(e.getPiece());
		if (camp.equals("noir"))
		{
			listePieceAdverse= listerPiecesNoires(this.listePieceEnJeu);

		}
		else if(camp.equals("blanc"))
		{
			listePieceAdverse= listerPiecesBlanches(this.listePieceEnJeu);
		}
		else 
		{//TODO: creer une exception
		}
		for(int i=0;i<listePieceAdverse.size();i++){//pour toutes les pieces adverses

			ArrayList<Case> deplacementPieceAdverse = filtreGeneral(listePieceAdverse.get(i));
			for (int j=0;j<deplacementPieceAdverse.size();j++){//pour tous les deplacements de chaque piece
				if (deplacementPieceAdverse.get(j).getPosition().equals(e.getPosition())){//la case e est égale a la case que l'on veut tester
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
		if(estMenace("blanc",caseRoiNoir)) {
			System.out.println("echec roi noir");
			a=11;
		}
		if(estMenace("noir",caseRoiBlanc)){
			a=12;
			System.out.println("echec roi blanc");
		}
		/*if(a==11 && echecEtMat("noir")){a=21;}

		if(a==12 && echecEtMat("blanc")){a=22;}
		System.out.println("résultat fonction echec : "+ a);
		*/
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
	/*	int compteurCaseMenacee=0;
		Vector<Case> listePieceMenacante = new Vector<Case>();
		Vector<Case> listePieceDefendent = new Vector<Case>();
		ArrayList<Case>  listeCaseDeplacementMenacant= new ArrayList<Case>();
		ArrayList<Case> listeCaseDeplacementDefendent= new ArrayList<Case>();
*/
		boolean estEnEchecMat=true;
		//test si le roi peut se deplacer

		if(camp.equals("noir")){//si le Roi noir est en echec
			
			Vector<Case> pieceDispo = listerPiecesNoires(listePieceEnJeu);
			
			
			for(int i=0; i < pieceDispo.size(); i++)
			{
				ArrayList<Case> deplacementPossiblePiece = filtreGeneral(pieceDispo.get(i));
				for(int j=0;j<deplacementPossiblePiece.size();j++){
					try {
						Case tmp = new Case(new Position(deplacementPossiblePiece.get(j).getPosition().getHauteur(), deplacementPossiblePiece.get(j).getPosition().getLargeur()));
						tmp.setPiece(deplacementPossiblePiece.get(j).getPiece());
						//TODO : Peut buguer
						if(!deplacer(pieceDispo.get(i),deplacementPossiblePiece.get(j)).equals("rien"))
						{
							deplacer(deplacementPossiblePiece.get(j),tmp);
							deplacementPossiblePiece.get(j).setPiece(tmp.getPiece());
							estEnEchecMat=false;
							
						}
						else{
							deplacer(deplacementPossiblePiece.get(j),tmp);
							deplacementPossiblePiece.get(j).setPiece(tmp.getPiece());
						}
					} catch (DeplacementException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			
			
			/*ArrayList<Case> casePossible = filtreGeneral(caseRoiNoir);
			for (int i=0;i<casePossible.size();i++)
			{
				if(estMenace("blanc",casePossible.get(i))){
					compteurCaseMenacee++;
				}
			}
			System.out.println("compteur case menacee" + compteurCaseMenacee);
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
					estEnEchecMat=false;
				}
			}
*/
		}
		else{

			Vector<Case> pieceDispo = listerPiecesBlanches(listePieceEnJeu);


			for(int i=0; i < pieceDispo.size(); i++)
			{
				ArrayList<Case> deplacementPossiblePiece = filtreGeneral(pieceDispo.get(i));
				for(int j=0;j<deplacementPossiblePiece.size();j++){
					try {
						Case tmp = new Case(new Position(deplacementPossiblePiece.get(j).getPosition().getHauteur(), deplacementPossiblePiece.get(j).getPosition().getLargeur()));
						tmp.setPiece(deplacementPossiblePiece.get(j).getPiece());
						//TODO : Peut buguer
						if(!deplacer(pieceDispo.get(i),deplacementPossiblePiece.get(j)).equals("rien"))
						{
							deplacer(deplacementPossiblePiece.get(j),tmp);
							deplacementPossiblePiece.get(j).setPiece(tmp.getPiece());
							estEnEchecMat=false;

						}
						else{
							deplacer(deplacementPossiblePiece.get(j),tmp);
							deplacementPossiblePiece.get(j).setPiece(tmp.getPiece());
						}
					} catch (DeplacementException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			/*ArrayList<Case> casePossible = filtrerDeplacementPossible(camp,this.caseRoiBlanc.getPiece().getDeplacementPossible(this.caseRoiBlanc));
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
					estEnEchecMat=false;
				}
			}
			 	*/
		}
		return estEnEchecMat;	
	}
	/**
	 * Test si on est en position de pat
	 * @return true si l'un des joueurs est en pat
	 */
	public boolean pat(){
		boolean a = true;
		if(!this.estMenace("noir", this.caseRoiBlanc))
		{
			for(int i=0;i<getListePieceEnJeu().size();i++){
				if(listerPiecesBlanches(getListePieceEnJeu()).get(i).getPiece().getDeplacementPossible(listerPiecesBlanches(getListePieceEnJeu()).get(i)).size()!=0)
				{
					a=false;
				}
			}
		}
		if(!this.estMenace("blanc", this.caseRoiNoir))
		{
			for(int i=0;i<getListePieceEnJeu().size();i++){
				if(listerPiecesNoires(getListePieceEnJeu()).get(i).getPiece().getDeplacementPossible(listerPiecesNoires(getListePieceEnJeu()).get(i)).size()!=0)
				{
					a=false;
				}
			}
		}
		return a;
	}
	/**
	 * recupere la case selectionne envoye par l'interface graphique
	 * @param caseSelectionne
	 * @return "rien" si il n'y a pas eu de deplacement, le deplacement en notation algebrique sinon
	 * @throws DeplacementException 
	 */
	public String selectionnerCase(Case caseSelectionne) throws DeplacementException{
		
		
		//System.out.println(caseSelectionne.getPosition().getHauteur()+","+caseSelectionne.getPosition().getLargeur());
/*
		System.out.println("---------------------------------");
		System.out.println(getCaseRoiBlanc().getPosition().getHauteur()+","+getCaseRoiBlanc().getPosition().getLargeur());
		System.out.println(getCaseRoiNoir().getPosition().getHauteur()+","+getCaseRoiNoir().getPosition().getLargeur());
		System.out.println("---------------------------------");
*/
		if(this.caseSelectionne==null)
		{
			//System.out.println("1");
			if(!caseSelectionne.estVide())
			{			
				//System.out.println("11");
				if(caseSelectionne.getPiece().getCamp().equals(campActif))
				{
					//System.out.println("111");
					this.caseSelectionne=caseSelectionne;
					//System.out.println(this.caseSelectionne.getPiece());
					
					return "rien";
				}
				else{
					
					
					return "rien";
				}
			}
			else
			{
				
				
				return "rien";
			}

		}
		else
		{
			//System.out.println("2");
			if(this.caseSelectionne.equals(caseSelectionne))
			{
				
				//System.out.println("21");
				this.caseSelectionne=null;
				
				return "rien";
			}
			else
			{
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

		String res=getNotationAlgebrique(caseDepart, caseArrivee);
		
		Case sauvegardeArrivee = new Case(new Position(caseArrivee.getPosition().getHauteur(),caseArrivee.getPosition().getLargeur()));
		sauvegardeArrivee.setPiece(caseArrivee.getPiece());
		

		if(deplacerReussi(caseDepart,caseArrivee))
		{
			return res;

		}
		else
		{	
			return "rien";
		}


	}
	
	public void validerDeplacement(Position depart,Case caseDepart,Case caseSauvegardeArrivee)
	{
	/*	if(!caseSauvegardeArrivee.estVide())//si il y a une piece a l'arrivee
		{
			System.out.println(caseSauvegardeArrivee.getPiece());
			this.listePiecePrises.add(caseSauvegardeArrivee.getPiece());//on ajoute la piece dans la liste des pieces prises

			for(int j=0; j< listePieceEnJeu.size();j++)//pour toutes les pieces en jeu
				if(this.listePieceEnJeu.get(j).getPosition().equals(caseSauvegardeArrivee.getPosition()))//si il y a une case egale a la case d'arrivee
					this.listePieceEnJeu.remove(j);//on la supprime
		}*/
		
		if(!caseSauvegardeArrivee.estVide())//si il y a une piece a l'arrivee
		{
			
			this.listePiecePrises.add(caseSauvegardeArrivee.getPiece());//on ajoute la piece dans la liste des pieces prises

			for(int j=0; j< listePieceEnJeu.size();j++)//pour toutes les pieces en jeu
				if(this.listePieceEnJeu.get(j).getPosition().equals(caseSauvegardeArrivee.getPosition()))//si il y a une case egale a la case d'arrivee
					this.listePieceEnJeu.remove(j);//on la supprime
		}
		if(caseDepart.getPiece().getClass().getSimpleName().equals("Roi"))
		{
			
			if(caseDepart.getPiece().getCamp().equals("noir"))
			{
				
				this.caseRoiNoir.setPosition(caseSauvegardeArrivee.getPosition());
			}
			else
			{
				
				this.caseRoiBlanc.setPosition(caseSauvegardeArrivee.getPosition());
			}
		}
		if(!caseDepart.getPiece().isDejaBouge())
			caseDepart.getPiece().setDejaBouge(true);
	}

	/**
	 * fait un deplacement sans test d'echec
	 * @param caseDepart
	 * @param caseArrivee
	 */
	public boolean deplacerReussi(Case caseDepart, Case caseArrivee){
		ArrayList<Case> plop = new ArrayList<Case>();
		boolean depEffectue = false;
		
		plop= filtreGeneral(caseDepart);
		

		for(int i=0; i< plop.size();i++){

			if(plop.get(i).getPosition().equals(caseArrivee.getPosition())){
				Case sauvegardeArrivee = new Case(new Position(caseArrivee.getPosition().getHauteur(),caseArrivee.getPosition().getLargeur()));
				Piece p = changerCase(caseDepart, caseArrivee);
				sauvegardeArrivee.setPiece(p);
				System.out.println(sauvegardeArrivee.getPiece());
				System.out.println(caseDepart.getPiece());
				for(int j=0; j< listePieceEnJeu.size();j++)//pour toutes les pieces en jeu
					if(this.listePieceEnJeu.get(j).getPosition().equals(caseDepart.getPosition()))
					{
						this.listePieceEnJeu.get(j).setPosition(new Position(sauvegardeArrivee.getPosition().getHauteur(),sauvegardeArrivee.getPosition().getLargeur()));//on met a jour la position
					}
				if(caseArrivee.getPiece().getClass().getSimpleName().equals("Roi"))
				{
					
					if(caseArrivee.getPiece().getCamp().equals("noir"))
					{
						
						this.caseRoiNoir.setPosition(sauvegardeArrivee.getPosition());
					}
					else
					{
						
						this.caseRoiBlanc.setPosition(sauvegardeArrivee.getPosition());
					}
				}
				System.out.println(caseArrivee.getPiece().getCamp());
				int res = echec();
				if(res==11 && campActif.equals("noir")){
					System.out.println("mise en echec a cause du deplacement");
					changerCase(caseArrivee,caseDepart);
					for(int j=0; j< listePieceEnJeu.size();j++)//pour toutes les pieces en jeu
						if(this.listePieceEnJeu.get(j).getPosition().equals(new Position(sauvegardeArrivee.getPosition().getHauteur(),sauvegardeArrivee.getPosition().getLargeur())))
						{
							this.listePieceEnJeu.get(j).setPosition(caseDepart.getPosition());//on met a jour la position
						}
					if(caseDepart.getPiece().getClass().getSimpleName().equals("Roi"))
					{
						
						if(caseDepart.getPiece().getCamp().equals("noir"))
						{
							
							this.caseRoiNoir.setPosition(caseDepart.getPosition());
						}
						else
						{
							
							this.caseRoiBlanc.setPosition(caseDepart.getPosition());
						}
					}
					
					
				}
				else if(res==12 && campActif.equals("blanc")){
					System.out.println("mise en echec a cause du deplacement");
					changerCase(caseArrivee,caseDepart);
					for(int j=0; j< listePieceEnJeu.size();j++)//pour toutes les pieces en jeu
						if(this.listePieceEnJeu.get(j).getPosition().equals(new Position(sauvegardeArrivee.getPosition().getHauteur(),sauvegardeArrivee.getPosition().getLargeur())))
						{
							this.listePieceEnJeu.get(j).setPosition(caseDepart.getPosition());//on met a jour la position
						}
				}
				else
				{
				validerDeplacement(caseDepart.getPosition(),caseArrivee,sauvegardeArrivee);
				depEffectue=true;
				}
			}
		}
		
		
		
		return depEffectue;
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

public ArrayList<Case> filtreGeneral(Case caseDepart){
	ArrayList<Case> plop = new ArrayList<Case>();
	
	plop = caseDepart.getPiece().getDeplacementPossible(caseDepart);//donne les déplacements possible de la piece présent sur la case depart
	
	if(caseDepart.getPiece().getClass().getSimpleName().equals(new String("Fou"))){
		filtrePourFou(caseDepart, plop);
		
	}

	if(caseDepart.getPiece().getClass().getSimpleName().equals(new String("Tour"))){
		filtrePourTour(caseDepart, plop);
		
	}

	if(caseDepart.getPiece().getClass().getSimpleName().equals(new String("Reine"))){
		filtrePourReine(caseDepart, plop);
	}
	
	plop = filtrerDeplacementPossible(caseDepart.getPiece().getCamp(), plop);//filtre si il n'y pas de pieces


	
	if(caseDepart.getPiece().getClass().getSimpleName().equals(new String("Pion"))){
		filtrerpresenceAdversaireDiagonale(caseDepart,plop);
		
	}
	
	
	return plop;

}




/**
 * Methode utile pour la classe Pion. modifie le fetdeplacementPossible selon la presence d'une piece adverse en diagonale par rapport a la
 * direction d'avancee du pion
 * @param caseActuelle :case du pion
 * @param res : le getdeplacement de la piece
 */

private void filtrerpresenceAdversaireDiagonale(Case caseActuelle,ArrayList<Case> casePossible){

	for(int i=0; i < casePossible.size();i++)
	{

		Case c = casePossible.get(i);
		Case caseEchiquier=chercherCase(c.getPosition());
		
		if(caseEchiquier.getPosition().getLargeur()==caseActuelle.getPosition().getLargeur()+1 || caseEchiquier.getPosition().getLargeur()==caseActuelle.getPosition().getLargeur()-1)
		{
			if(caseEchiquier.estVide())
			{
				casePossible.remove(c);
				i--;
			}
			else if(caseEchiquier.getPiece().getCamp().equals(caseActuelle.getPiece().getCamp()))
			{
				casePossible.remove(c);
				i--;
			}

		}
		else
		{
			if(!caseEchiquier.estVide())
			{
				casePossible.remove(c);
				i--;
			}	

		}

	}

}
private void filtrePourFou(Case caseActuelle,ArrayList<Case> casePossible){

	ArrayList<Case> diagBasGauche= new ArrayList<Case>();
	ArrayList<Case> diagBasDroit= new ArrayList<Case>();
	ArrayList<Case> diagHautGauche= new ArrayList<Case>();
	ArrayList<Case> diagHautDroite= new ArrayList<Case>();

	for(int i=0; i < casePossible.size();i++){
		Case c = casePossible.get(i);			
		if(caseActuelle.getPosition().getHauteur()>c.getPosition().getHauteur() && caseActuelle.getPosition().getLargeur()>c.getPosition().getLargeur())
		{
			diagBasGauche.add(c);
		}

		if(caseActuelle.getPosition().getHauteur()>c.getPosition().getHauteur() && caseActuelle.getPosition().getLargeur()<c.getPosition().getLargeur())
		{
			diagBasDroit.add(c);
		}
		if(caseActuelle.getPosition().getHauteur()<c.getPosition().getHauteur() && caseActuelle.getPosition().getLargeur()>c.getPosition().getLargeur())
		{
			diagHautGauche.add(c);				
		}
		if(caseActuelle.getPosition().getHauteur()<c.getPosition().getHauteur() && caseActuelle.getPosition().getLargeur()<c.getPosition().getLargeur())
		{
			diagHautDroite.add(c);
		}
	}

	for(int i=0; i < diagBasGauche.size();i++){
		Case caseEchi = chercherCase(diagBasGauche.get(i).getPosition());
		if(!caseEchi.estVide())
			for(int j=0; j < diagBasGauche.size();j++){
				if(diagBasGauche.get(i).getPosition().getLargeur()>diagBasGauche.get(j).getPosition().getLargeur())
				{
					diagBasGauche.remove(diagBasGauche.get(j));
					j--;

				}
				/*if(!diagBasGauche.get(i).estVide()){
				System.out.println("attention");
				for(int j=0; j < diagBasGauche.size()-1;j++){
					if(diagBasGauche.get(i).getPosition().getLargeur()>diagBasGauche.get(j).getPosition().getLargeur())
					{
						diagBasGauche.remove(diagBasGauche.get(j));
						j--;

					}
				}}
			diagBasGauche.remove(diagBasGauche.get(i));*/
			}
	}

	for(int i=0; i < diagBasDroit.size();i++){
		Case caseEchi = chercherCase(diagBasDroit.get(i).getPosition());
		if(!caseEchi.estVide())
			for(int j=0; j < diagBasDroit.size();j++){
				if(diagBasDroit.get(i).getPosition().getLargeur()<diagBasDroit.get(j).getPosition().getLargeur())
				{
					diagBasDroit.remove(diagBasDroit.get(j));
					j--;

				}
			}
	}

	for(int i=0; i < diagHautGauche.size();i++){
		Case caseEchi = chercherCase(diagHautGauche.get(i).getPosition());
		if(!caseEchi.estVide())
		{
				for(int j=0; j < diagHautGauche.size();j++){
				if(diagHautGauche.get(i).getPosition().getLargeur()>diagHautGauche.get(j).getPosition().getLargeur())
				{
					diagHautGauche.remove(diagHautGauche.get(j));
					j--;

				}
			}
		}
	}

	for(int i=0; i < diagHautDroite.size();i++){
		Case caseEchi = chercherCase(diagHautDroite.get(i).getPosition());
		if(!caseEchi.estVide())
			for(int j=0; j < diagHautDroite.size();j++){
				if(diagHautDroite.get(i).getPosition().getLargeur()<diagHautDroite.get(j).getPosition().getLargeur())
				{
					diagHautDroite.remove(diagHautDroite.get(j));
					j--;

				}
			}
	}


	casePossible.clear();
	casePossible.addAll(diagBasGauche);
	casePossible.addAll(diagBasDroit);
	casePossible.addAll(diagHautGauche);
	casePossible.addAll(diagHautDroite);
}

private void filtrePourReine(Case caseActuelle,ArrayList<Case> casePossible){
	ArrayList<Case> diagonale= new ArrayList<Case>();
	ArrayList<Case> droite= new ArrayList<Case>();
	
	for(int i=0; i < casePossible.size();i++){
		Case c = casePossible.get(i);			
		if(c.getPosition().getHauteur()==caseActuelle.getPosition().getHauteur() ||c.getPosition().getLargeur()==caseActuelle.getPosition().getLargeur())
			droite.add(c);
		else
			diagonale.add(c);
	}
	filtrePourTour(caseActuelle, droite);
	filtrePourFou(caseActuelle, diagonale);
	casePossible.clear();
	casePossible.addAll(droite);
	casePossible.addAll(diagonale);
}



private void filtrePourTour(Case caseActuelle,ArrayList<Case> casePossible){

	ArrayList<Case> caseGauche= new ArrayList<Case>();
	ArrayList<Case> caseDroite= new ArrayList<Case>();
	ArrayList<Case> caseHaut= new ArrayList<Case>();
	ArrayList<Case> caseBas= new ArrayList<Case>();

	for(int i=0; i < casePossible.size();i++){
		Case c = casePossible.get(i);			
		if(caseActuelle.getPosition().getHauteur()==c.getPosition().getHauteur() && caseActuelle.getPosition().getLargeur()>c.getPosition().getLargeur())
		{
			caseGauche.add(c);
		}

		if(caseActuelle.getPosition().getHauteur()==c.getPosition().getHauteur() && caseActuelle.getPosition().getLargeur()<c.getPosition().getLargeur())
		{
			caseDroite.add(c);
		}
		if(caseActuelle.getPosition().getHauteur()<c.getPosition().getHauteur() && caseActuelle.getPosition().getLargeur()==c.getPosition().getLargeur())
		{
			caseHaut.add(c);				
		}
		if(caseActuelle.getPosition().getHauteur()>c.getPosition().getHauteur() && caseActuelle.getPosition().getLargeur()==c.getPosition().getLargeur())
		{
			caseBas.add(c);
		}
	}

	for(int i=0; i < caseGauche.size();i++){
		Case caseEchi = chercherCase(caseGauche.get(i).getPosition());
		if(!caseEchi.estVide())
			for(int j=0; j < caseGauche.size();j++){
				if(caseGauche.get(i).getPosition().getLargeur()>caseGauche.get(j).getPosition().getLargeur())
				{
					caseGauche.remove(caseGauche.get(j));
					j--;

				}
				/*if(!diagBasGauche.get(i).estVide()){
				System.out.println("attention");
				for(int j=0; j < diagBasGauche.size()-1;j++){
					if(diagBasGauche.get(i).getPosition().getLargeur()>diagBasGauche.get(j).getPosition().getLargeur())
					{
						diagBasGauche.remove(diagBasGauche.get(j));
						j--;

					}
				}}
			diagBasGauche.remove(diagBasGauche.get(i));*/
			}
	}

	for(int i=0; i < caseDroite.size();i++){
		Case caseEchi = chercherCase(caseDroite.get(i).getPosition());
		if(!caseEchi.estVide())
			for(int j=0; j < caseDroite.size();j++){
				if(caseDroite.get(i).getPosition().getLargeur()<caseDroite.get(j).getPosition().getLargeur())
				{
					caseDroite.remove(caseDroite.get(j));
					j--;

				}
			}
	}

	for(int i=0; i < caseHaut.size();i++){

		Case caseEchi = chercherCase(caseHaut.get(i).getPosition());
		if(!caseEchi.estVide())
		{
			
			for(int j=0; j < caseHaut.size();j++){
				if(caseHaut.get(i).getPosition().getHauteur()<caseHaut.get(j).getPosition().getHauteur())
				{

					caseHaut.remove(caseHaut.get(j));
					j--;

				}
			}
		}
	}

	for(int i=0; i < caseBas.size();i++){
		Case caseEchi = chercherCase(caseBas.get(i).getPosition());
		if(!caseEchi.estVide())
			for(int j=0; j < caseBas.size();j++){
				if(caseBas.get(i).getPosition().getHauteur()>caseBas.get(j).getPosition().getHauteur())
				{
					caseBas.remove(caseBas.get(j));
					j--;

				}
			}
	}



	casePossible.clear();
	casePossible.addAll(caseGauche);
	casePossible.addAll(caseDroite);
	casePossible.addAll(caseHaut);
	casePossible.addAll(caseBas);
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
	for(int i=0;i<(casePossible.size());i++)
	{

		caseplateau=chercherCase(casePossible.get(i).getPosition());

		if((!caseplateau.estVide())){
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
		if(!liste.get(i).estVide()){
			
			if (liste.get(i).getPiece().getCamp().equals("blanc")){//si dans la liste la piece est blanche
			
				listepiece.add(liste.get(i));//ajoute dans la liste des pieces adverses les pieces noires
			}
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
			if (liste.get(i).getPiece().getCamp().equals("noir")){//si dans la liste la piece est noires
				listepiece.add(liste.get(i));//ajoute dans la liste des pieces adverses les pieces noires
			}
	}
	return listepiece;		
}

public Position pionBoutEchiquier(){

	Position IlYAUnPion = null;
	for (int i=1;i<9;i++)
	{			
		if (chercherCase(new Position(1,i)).getPiece().equals(new Pion("noir")))
			IlYAUnPion= new Position(1,i);//si l'égalité est vérifié (il y a un pion en haut de l'échiquier) alors on renvoit la case de se pion
		if (chercherCase(new Position(8,i)).getPiece().equals(new Pion("blanc")))
			IlYAUnPion= new Position(8,i);//si l'égalité est vérifié (il y a un pion en haut de l'échiquier) alors on renvoit la case de se pion
	}

	return IlYAUnPion;//on retourne la case du pion.(=null si pas de pion)
}
public boolean pionBoutEchiquiertest(){

	boolean IlYAUnPion = false;
	for (int i=1;i<9;i++)
	{			
		if (chercherCase(new Position(1,i)).getPiece().equals(new Pion("noir")))
			IlYAUnPion= true;
		if (chercherCase(new Position(8,i)).getPiece().equals(new Pion("blanc")))
			IlYAUnPion= true;
			}

	return IlYAUnPion;//on retourne la case du pion.(=null si pas de pion)
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

public String getCampActif(){
	return campActif;
}

}
