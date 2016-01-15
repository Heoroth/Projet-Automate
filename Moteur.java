import java.util.ArrayList;


public class Moteur {
	//Attributs de la classe Moteur
	
	//Nom du fichier .descr
    String nomDescr;
    //Alphabet d'entrée
    ArrayList<String> alphabetEntree;
    //Nombre d'etats
    int nbEtats;
    //Etat initial
    ArrayList<String> etatInit;

	//Constructeur vide (on sait jamais)
	//public Moteur(){}
	
	//Constructeur pour la classe moteur
	/*public Moteur(String nomDescr, ArrayList<String> alphabetEntree, int nbEtats, ArrayList<String> etatInit){
		this.nomDescr = nomDescr;
		this.alphabetEntree = new ArrayList<String>();
		this.nbEtats = nbEtats;
		this.etatInit = new ArrayList<String>(); 
	}*/
	
	//constructeur pour test
	public Moteur(){
		this.nomDescr = "mini.descr";
		this.alphabetEntree = new ArrayList<String>();
		this.alphabetEntree.add("a");
		this.nbEtats = 1;
		this.etatInit = new ArrayList<String>(); 
		if(this.nbEtats == 1){
			this.etatInit.add("0");
		} 
	}

	public void afficheAlphabetEntree(){
		for(int i = 0; i<this.alphabetEntree.size(); i++){
			System.out.println("Alphabet d'entree : " + this.alphabetEntree.get(i));
		}
	}
	
	public void afficheNombreEtat(){
		System.out.println("Il y a : " + this.nbEtats + " etats");
	}
	
	public void afficheEtatInit(){
		for(int i = 0; i<this.etatInit.size(); i++){
			System.out.println("Etat initial/initiaux : " + this.etatInit.get(i));
		}
	}
    
		
}
