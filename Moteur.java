import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Moteur {

	private String nomFichier = "mini.descr"; //fichier .descr qui sera lu pour la création de l'automate
	private char meta; //meta caractere pour arreter la saisie
	private ArrayList<Character> alphabetEntree; //liste du vocabulaire d'entree
	private ArrayList<Character> sorties; //liste du vocabulaire de sortie
	private char nbEtats; //nombre d'états dans l'AEF
	private ArrayList<Character> etatInit; //liste des etats init de l'AEF
	private ArrayList<Character> etatsAcceptants; //liste des etats acceptant
	private ArrayList<Character> transitions; //liste des transitions

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

	//Ensemble des méthodes d'affichage des éléments constituant l'AEF
	public void afficheMetaChar(){
		System.out.println("Meta caractere : " + this.meta);
	}

	public void afficheAlphabetEntree() {
		for (int i = 0; i < this.alphabetEntree.size(); i++) {
			System.out.println("Alphabet d'entree : "
					+ this.alphabetEntree.get(i));
		}
	}
	
	public void afficheAlphabetSotie(){
		for (int i = 0; i < this.sorties.size(); i++) {
			System.out.println("Alphabet de sortie : "
					+ this.sorties.get(i));
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
	
	public void afficheEtatsAcceptants(){
		for (int i = 0; i < this.etatsAcceptants.size(); i++) {
			System.out.println("Etat(s) acceptant(s) : "
					+ this.etatsAcceptants.get(i));
		}
	}
	
	public void afficheTransitions(){
		for (int i = 0; i < this.transitions.size(); i++) {
			System.out.println("Transition(s) : "
					+ this.transitions.get(i));
		}
	}

	//Ensemble des getters sur les variables d'instance du moteur AEF
	public ArrayList<Character> getAlphabetEntree() {
		return this.alphabetEntree;
	}

	public String getNomFichier() {
		return nomFichier;
	}


	public char getMeta() {
		return meta;
	}


	public ArrayList<Character> getSorties() {
		return sorties;
	}


	public char getNbEtats() {
		return nbEtats;
	}


	public ArrayList<Character> getEtatInit() {
		return etatInit;
	}


	public ArrayList<Character> getEtatsAcceptants() {
		return etatsAcceptants;
	}

	public ArrayList<Character> getTransitions() {
		return transitions;
	}

}
