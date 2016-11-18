package Main;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import Generation.*;
import Graphics.*;
import Resolution.*;

public class Main {

	private static Fenetre f;
	private static Panel pan;
	public static int resPx = 700; //resolution des calculs en px
	public static int tailleFen = 700; //resolution des calculs en px (on doit avoir tailleFen > resPx)
	public static int marges = 50; //marges pour affichage
	
	public static void main(String[] args) throws IOException {

		
		//CHOIX ALGO DE RESOLUTION
		//DeuxApprox algoDeTest = new DeuxApprox();
		Exact algoDeTest = new Exact();
		
		//CHOIX GENERATION DU PROBLEME
		//Cluster gen = new Cluster(20, 20);
		Uniforme gen = new Uniforme();
		
		//CHOIX DU NOMBRE DE NOEUDS
		int nbNoeuds = 40;
		
		//CHOIX DU NOMBRE DE CENTRES
		int k = 4;
		
		
		// ----------------------------------------
		
		
		Instance instanceDeTest = gen.generer(nbNoeuds, k);
		instanceDeTest.afficheText();

		Recuperer test = new Recuperer();

		ArrayList<Instance> instances = new ArrayList<Instance>();
		instances.add(instanceDeTest);
		instances.add(instanceDeTest);

		test.createFile("test", instances);
		ArrayList<Instance> instancesRecup = test.getFromFile("test");
		for (int i=0; i< instancesRecup.size(); i++){
			instancesRecup.get(i).afficheText();
		}

		long t1 = System.currentTimeMillis();

		Solution solutionDeTest = algoDeTest.resoudre(instanceDeTest);
		solutionDeTest.afficheText();

		long t2 = System.currentTimeMillis();
		float secondes = (float)(t2-t1)/1000;
		System.out.println("Temps d'éxecution : " + secondes + " secondes.");

		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					try {
						f = new Fenetre();
					} catch (IOException e) {
						e.printStackTrace();
					}

					pan = new Panel(instanceDeTest, solutionDeTest);

					f.add(pan);
				}
			});
		}

		catch(Exception e){
			System.err.println("Erreur a la creation de l'interface Swing.");
			System.err.println(e);
		}

	}
}

//AFFICHAGE DANS LE MAIN



