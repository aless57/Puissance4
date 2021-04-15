import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

import java.io.*;

public class testJeu {

	/**
	 * M�thode qui teste simplement le constructeur de la classe Grille
	 */
	public void test_Grille_constructeur() {
		Grille g = new Grille();
		assertEquals("La taille de la grille n'est pas �gale � 6",6,g.getLesColonnes().size());
		assertEquals("Le joueur doit �tre le Joueur1",0,g.getJoueur());
	}
	/**
	 * M�thode qui teste simplement le constructeur de la classe Colonne
	 */
	public void test_Colonne_constructeur() {
		Colonne c = new Colonne();
		assertEquals("La colonne est bien vide",0,c.getCaseDeJeton().size());
	}
	
	/**
	 * M�thode qui teste simplement le constructeur de la classe Joueur et de la classe Jeton
	 */
	public void test_JetonJoueur_constructeur() {
		Joueur jj = new Joueur(1);
		Jeton j = new Jeton(jj);
		assertEquals("Le joueur doit �tre le num�ro 1",1,j.getJoueur());
	}
	
	/**
	 * M�thode qui teste la m�thode insererJeton de la classe Grille
	 */
	public void test_Grille_InsererJeton() {
		Grille g = new Grille();
		g.insererJeton(1);
		assertEquals("Le jeton doit �tre plac� dans la deuxieme colonne",0,g.getLesColonnes().get(1).getCaseDeJeton().get(0).getJoueur());
		assertEquals("Le joueur change",1,g.getJoueur());
	}
	
	/**
	 * M�thode qui teste la sauvegarde et le chargement de la classe Grille
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void test_Grille_sauvegarde_chargement() throws FileNotFoundException, IOException, ClassNotFoundException {
		Grille g = new Grille();
		g.insererJeton(0);
		g.insererJeton(1);
		g.sauvegarde();
		assertEquals("Le joueur dans la sauvegarde n'est pas le m�me que dans le jeu en cours",g.charger().getJoueur(),g.getJoueur());
	}
	
	/**
	 * M�thode qui teste la m�thode hauteurDeLaColonneLaPlusGrande de la classe Grille
	 */
	public void test_Grille_hauteurDeLaColonneLaPlusGrande() {
		Grille g = new Grille();
		g.insererJeton(1);
		g.insererJeton(1);
		g.insererJeton(1);
		g.insererJeton(2);
		g.insererJeton(4);
		g.insererJeton(4);
		g.insererJeton(5);
		assertEquals("La hauteur de colonne la plus grande doit �tre 3",3,g.hauteurDeLaColonneLaPlusGrande());
	}
	
	/**
	 * M�thode qui teste la m�thode moyenneCaseRemplie de la classe Grille
	 */
	public void test_Grille_moyenneCaseRemplie() {
		Grille g = new Grille();
		g.insererJeton(2);
		g.insererJeton(2);
		g.insererJeton(3);
		g.insererJeton(3);
		g.insererJeton(1);
		g.insererJeton(4);
		assertEquals("Le remplissage moyenne doit �tre 1.5","Remplissage moyen par colonnes contenant des jetons : 1.5",g.moyenneCaseRemplie());
		
	}
	
	/**
	 * M�thode qui teste la m�thode trierLesColonnes de la classe Grille
	 */
	public void test_Grille_trierLesColonnes() {
		Grille g = new Grille();
		g.insererJeton(1);
		g.insererJeton(1);
		g.insererJeton(1);
		g.insererJeton(2);
		g.insererJeton(0);
		g.insererJeton(0);
		assertEquals("La phrase n'est pas bonne ", "Num�ro colonnes tri�es par remplissage : 2(3), 1(2), 3(1), 4(0), 5(0), 6(0), ",g.tierLesColonnes());
		
	}
	
	/**
	 * M�thode qui teste la m�thode insererJeton de la classe Colonne
	 */
	public void test_Colonne_insererJeton() {
		Colonne c = new Colonne();
		c.insererJeton(0);
		c.insererJeton(1);
		assertEquals("La taille de la colonne est bien �gale � 0",2,c.getCaseDeJeton().size());
	}
	
	/**
	 * Main qui permet de lancer le libtest
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new testJeu(), args);
	}
}
