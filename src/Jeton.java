import java.io.*;

public class Jeton implements Serializable {

	private Joueur joueur; //0 pour J1 et 1 pour J2
	
	/**
	 * Constucteur de Jeton avec un paramètre qui donne le joueur au jeton
	 * @param i joueur
	 */
	public Jeton(Joueur i) {
		this.joueur = i;
	}
	
	/**
	 * Getteur qui donne le numéro du joueur en rapport avec le jeton en cours
	 * @return numéro du jeton
	 */
	public int getJoueur() {
		return this.joueur.getLeJoueur();
	}
}
