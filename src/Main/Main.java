package Main;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import Generation.Cluster;
import Generation.Recuperer;
import Graphics.Fenetre;
import Graphics.Panel;
import Resolution.Deuxapprox;

public class Main {

	private static Fenetre f;
	private static Panel pan;
	public static int resPx = 700; //resolution des calculs en px
	public static int tailleFen = 700; //resolution des calculs en px
	// on doit avoir tailleFen > resPx
	public static int marges = 20; //marges pour affichage
	
	
	
	public static void main(String[] args) throws IOException {

		//CHOIX ALGO DE RESOLUTION
		Deuxapprox algoDeTest = new Deuxapprox();

		//CHOIX GENERATION DU PROBLEME
		Cluster gen = new Cluster(2, 30);
		
		Instance instanceDeTest = gen.generer(1000, 2);
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


		Solution solutionDeTest = algoDeTest.resoudre(instanceDeTest);

		solutionDeTest.afficheText();


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



