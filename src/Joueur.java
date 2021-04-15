import java.io.*;

public class Joueur implements Serializable {

	private int numjoueur;
	/**
	 * Constructeur qui donne le num�ro au Joueur
	 * @param i num�ro du joueur
	 */
	public Joueur(int i) {
		this.numjoueur = i;
	}
	
	/**
	 * Getteur du num�ro du joueur
	 * @return num�ro du joueur
	 */
	public int getLeJoueur(){
		return this.numjoueur;
	}
}
