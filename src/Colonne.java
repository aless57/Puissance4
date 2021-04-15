import java.io.*;
import java.util.*;

public class Colonne implements Serializable, Comparable<Colonne>{

	private ArrayList<Jeton> caseDeJeton;
	
	/**
	 * Constructeur qui permet l'initialisé l'ArrayList des Jetons avec une taille variable
	 */
	public Colonne() {
		this.caseDeJeton = new ArrayList<Jeton>();
	}
	
	/**
	 * Getteur de la taille d'une colonne de jetons
	 * @return taille de la colonne de jetons
	 */
	public int tailleDeLaColonne() {
		return this.caseDeJeton.size();
	}
	
	/**
	 * Methode qui insère un jeton dans la colonne choisie 
	 * @param joueur int : le numero du joueur en cours
	 */
	public void insererJeton(int joueur) {
		this.caseDeJeton.add(new Jeton(new Joueur(joueur)));
	}
	
	/**
	 * Getteur de l'ArrayList de jetons
	 * @return ArrayList de jetons
	 */
	public ArrayList<Jeton> getCaseDeJeton() {
		return caseDeJeton;
	}
	
	/**
	 * Réecriture de la méthode compareTo de l'interface Comparable
	 * qui va permettre de trier les colonnes pour la méthode trierLesColonnes de la classe Grille
	 */
	@Override
	public int compareTo(Colonne c) {
		if (this.tailleDeLaColonne()<c.tailleDeLaColonne()) {
			return 1;
		}
		else if (c.tailleDeLaColonne()<this.tailleDeLaColonne()) {
			return -1;
		}
		
		return 0;
	}
}
