import java.io.IOException;


public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Moteur moteur= new Moteur();
		
		moteur.lectureFichier("mini.descr");
		moteur.afficheAlphabetEntree();
		moteur.afficheEtatInit();
		moteur.afficheNombreEtat();
	}



}
