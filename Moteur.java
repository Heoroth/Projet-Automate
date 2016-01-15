import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Moteur {

	String nomFichier = "mini.descr";
	char meta;
	ArrayList<Character> alphabetEntree; // vocabulaire d'entree
	ArrayList<Character> sorties;
	char nbEtats;
	ArrayList<Character> etatInit;
	ArrayList<Character> F;
	ArrayList<Character> T;

	// constructeur
	public Moteur() {

		this.alphabetEntree = new ArrayList<Character>();
		this.sorties = new ArrayList<Character>();
		this.etatInit = new ArrayList<Character>();
		if (etatInit.size() == 0) {
			etatInit.add('0');
		}

	}

	public void lectureFichier(String fichier) {

		try {

			String ligne;
			BufferedReader str = new BufferedReader(new FileReader(nomFichier));
			ligne = str.readLine();
			int i = 0;
			while (ligne != null && i < ligne.length()) {
				if (ligne.charAt(i) != ' ' && ligne.charAt(i) != '"'
						&& ligne.charAt(0) == 'M' && i > 0) {
					meta = ligne.charAt(i);
					i++;
				} else if (ligne.charAt(i) != ' ' && ligne.charAt(i) != '"'
						&& ligne.charAt(0) == 'V' && i > 0) {
					alphabetEntree.add(ligne.charAt(i));
					i++;
				} else if (ligne.charAt(i) != ' ' && ligne.charAt(i) != '"'
						&& ligne.charAt(0) == 'O' && i > 0) {
					// O.add(ligne.charAt(i));
					i++;
				} else if (ligne.charAt(i) != ' ' && ligne.charAt(0) == 'E'
						&& i > 0) {
					nbEtats = (ligne.charAt(i));
					i++;
				} else if (ligne.charAt(i) != ' ' && ligne.charAt(i) != '"'
						&& ligne.charAt(0) == 'I' && i > 0) {// a definir les
																// conditions
																// pour I
					etatInit.add(ligne.charAt(i));
					i++;
				} else if (ligne.charAt(i) != ' ' && ligne.charAt(0) == 'F'
						&& i > 0) {
					// F.add(ligne.charAt(i));
					i++;
				}

				else {
					i++;
				}
				// read the next line

				if (i == ligne.length()) {

					// System.out.println("ligne" + ligne);
					i = 0;
					ligne = str.readLine();
				}

			}

			str.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void afficheAlphabetEntree() {
		for (int i = 0; i < this.alphabetEntree.size(); i++) {
			System.out.println("Alphabet d'entree : "
					+ this.alphabetEntree.get(i));
		}
	}

	public void afficheNombreEtat() {
		System.out.println("Il y a : " + this.nbEtats + " etats");
	}

	public void afficheEtatInit() {
		for (int i = 0; i < this.etatInit.size(); i++) {
			System.out.println("Etat initial/initiaux : "
					+ this.etatInit.get(i));
		}
	}

}
