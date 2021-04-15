import java.io.*;
import java.util.*;

public class lejeu {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		System.out.println("Bienvenue dans l'interface Puissance 4 for fun ! ");
		System.out.println("Celui-ci à été créé par DEMANGE Alessi et ATLAOUI Tom !");
		System.out.println("Que le premier joueur place son pion ! Choisi la colonne entre 1 et 7 où \ntu veux que ton pion aille");
		Scanner sc = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Grille g = new Grille();
			System.out.println("Sauvegarder, reprendre ou jouer ? (S/R/J)");
			String selection = sc.nextLine();
			while (!selection.equals("S") &&  !selection.equals("R") && !selection.equals("J")) {
				System.out.println("Entre une vraie valeur (S/R/J)");
				selection = sc.nextLine();				
			}
			while (!selection.equals("A")) {
				if (selection.equals("S")) {
					g.sauvegarde();
					System.out.println("Voila l'état de la grille après la sauvegarde : ");
					g.affichage();
					System.out.println(g.tierLesColonnes());
					System.out.println(g.moyenneCaseRemplie());
				}
				else if (selection.equals("R")) {
					g = g.charger();
					g.affichage();
					System.out.println(g.tierLesColonnes());
					System.out.println(g.moyenneCaseRemplie());
					System.out.println("Entrer la colonne où vous voulez entrer le pion.");
					int numcolonne = sc.nextInt();
					while (numcolonne<1 || numcolonne>6) {
						System.out.println("Entre une vraie valeur (entre 1 et 6)");
						numcolonne = sc2.nextInt();
					}
					g.insererJeton(numcolonne-1);
					}
				else {
						g.affichage();
						System.out.println(g.tierLesColonnes());
						System.out.println(g.moyenneCaseRemplie());
						System.out.println("Entrer la colonne où vous voulez entrer le pion.");
						int numcolonne = sc.nextInt();
						while (numcolonne<1 || numcolonne>6) {
							System.out.println("Entre une vraie valeur (entre 1 et 6)");
							numcolonne = sc2.nextInt();
						}
						g.insererJeton(numcolonne-1);	
				}
				selection = "";
				System.out.println("Sauvegarder, reprendre ou jouer ? (S/R/J) ou arreter ? (A)");
				selection = scanner.nextLine();
				while (!selection.equals("S") &&  !selection.equals("R") && !selection.equals("J") && !selection.contentEquals("A")) {
					System.out.println("Entre une vraie valeur (S/R/J/A)");
					selection = scanner.nextLine();				
				}
				for (int y=0;y<10;y++) {
					System.out.println("");
				}
		}
			System.out.println("Fini !");
			g = g.charger();
			System.out.println("Voila l'état de ta grille : ");
			g.affichage();
			System.out.println(g.tierLesColonnes());
			System.out.println(g.moyenneCaseRemplie());
	}
}
