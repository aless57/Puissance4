import java.io.*;
import java.util.*;

public class Grille implements Serializable {
	
	private ArrayList<Colonne> lescolonnes; //Liste de colonnes pour afficher la grille
	private int joueur; //0 pour J1 et 1 pour J2
	
	/**
	 * Constructeur de la classe Grille qui initialise le nombre de grille a 7 et donne le tour au joueur 1
	 */
	public Grille() {
		this.lescolonnes = new ArrayList<Colonne>(6); //La Grille poss�de 7 colonnes
		for (int i=0;i<6;i++) {
			lescolonnes.add(new Colonne());
		}
		this.joueur=0;
	}
	
	/**
	 * Getteur du joueur en cours 
	 * @return joueur
	 */
	public int getJoueur() {
		return this.joueur;
	}
	
	/**
	 * Getteur de l'ArrayList des Colonnes
	 * @return ArrayList des colonnes
	 */
	public ArrayList<Colonne> getLesColonnes(){
		return this.lescolonnes;
	}
	/**
	 * M�thode qui sert � inserer un jeton � une certaine colonne et qui change le tour du joueur
	 * @param numColonne num�ro de la colonne que o� l'on veut inserer le jeton (de 0 � 6)
	 */
	public void insererJeton(int numColonne) {
		this.lescolonnes.get(numColonne).insererJeton(joueur);
		if (this.joueur==0) {
			this.joueur=1;
		}
		else {
			this.joueur=0;
		}
	}
	
	/**
	 * M�thode qui retourne la hauteur de la colonne la plus grande
	 * @return la hateur de la colonne la plus grande
	 */
	public int hauteurDeLaColonneLaPlusGrande() {
		int res = lescolonnes.get(0).getCaseDeJeton().size();
		for (int i = 1 ; i<this.lescolonnes.size() ; i++) {
			if (lescolonnes.get(i).getCaseDeJeton().size() > res) {
				res=lescolonnes.get(i).getCaseDeJeton().size();
			}
		}
		return res;
	}
	
	/**
	 * M�thode qui sert � l'affichage de la grille avec les jetons
	 */
	public void affichage() {
		int hauteurmax = this.hauteurDeLaColonneLaPlusGrande();
		String laffichage = "";
		for (int i=0; i<this.lescolonnes.size();i++) {
			laffichage += "+-";
		}
		laffichage += "+\n";
		for (int y=hauteurDeLaColonneLaPlusGrande(); y>0;y--) {
			laffichage += "|";
			for (int w=0; w<this.lescolonnes.size();w++) { 
				if(lescolonnes.get(w).getCaseDeJeton().size()>=y) {
					laffichage += lescolonnes.get(w).getCaseDeJeton().get(y-1).getJoueur();
				}
				else {
					laffichage += " ";
				}
				laffichage += "|";
			}
			laffichage += "\n";
			for (int u=0; u<this.lescolonnes.size(); u++) {
				laffichage += "+-";
			}
			laffichage += "+\n";	
		}
		System.out.println(laffichage); 
	}
	
	/**
	 * M�thode qui permet de sauvegarder une partie en cours
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void sauvegarde() throws FileNotFoundException, IOException {
		System.out.println("Je te sauvegarde la partie si possible...");
		try{
			ObjectOutputStream fichier = new ObjectOutputStream(new FileOutputStream("sauvegarde.txt"));
			fichier.writeObject(this);
			fichier.close();
		}catch (IOException e) {
			System.out.println("Probleme � l'ouverture du fichier");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Autre erreur hors de l'ouverture du fichier");
			e.printStackTrace();
		}	
	}

	/**
	 * M�thode qui permet de charger une partie sauvegard� depuis un fichier
	 * @return	l'�tat de la grille dans la sauvegarde
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Grille charger() throws IOException, ClassNotFoundException {
		System.out.println("Je te charge ta derni�re partie si possible...");
		ObjectInputStream fichier = new ObjectInputStream(new FileInputStream("sauvegarde.txt"));
		Grille g=(Grille)(fichier.readObject());
		fichier.close();
		return g;
	}
	/**
	 * M�thode qui permet de tier les Colonnes par rapport � leur taille
	 * @return La phrase qui nous montre que les colonnes sont tri�es par ordre croissant
	 */
	public String tierLesColonnes() {
		ArrayList<Colonne> listeTriee = (ArrayList<Colonne>) this.lescolonnes.clone();
		Collections.sort(listeTriee);
		String bellephrase ="";
		for (int i=0;i<listeTriee.size();i++) {
			bellephrase += (this.lescolonnes.indexOf(listeTriee.get(i))+1)+"("+listeTriee.get(i).getCaseDeJeton().size()+"), ";
		}
		return ("Num�ro colonnes tri�es par remplissage : "+bellephrase);
	}
	/**
	 * M�thode qui permet de renvoyer la moyenne des cases remplies
	 * @return La moyenne des cases remplies
	 */
	public String moyenneCaseRemplie() {
		double moyenne=0;
		double division=0;
		for (int i=0;i<6;i++) {
			moyenne+=this.lescolonnes.get(i).getCaseDeJeton().size();
			if (this.lescolonnes.get(i).getCaseDeJeton().size() > 0) {
				division+=1;
			}
		}
		return("Remplissage moyen par colonnes contenant des jetons : "+moyenne/division);
	}
}