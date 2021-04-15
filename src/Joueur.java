import java.io.*;

public class Joueur implements Serializable {

	private int numjoueur;
	/**
	 * Constructeur qui donne le numéro au Joueur
	 * @param i numéro du joueur
	 */
	public Joueur(int i) {
		this.numjoueur = i;
	}
	
	/**
	 * Getteur du numéro du joueur
	 * @return numéro du joueur
	 */
	public int getLeJoueur(){
		return this.numjoueur;
	}
}
