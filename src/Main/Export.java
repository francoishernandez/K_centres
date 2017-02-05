package Main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.SwingUtilities;
import Generation.*;
import Graphics.*;
import Resolution.*;
import java.io.FileWriter;
import java.io.IOException;

public class Export {

	private static Fenetre f;
	private static Panel pan;
	public static int resPx = 700; //resolution des calculs en px
	public static int tailleFen = 700; //resolution des calculs en px (on doit avoir tailleFen > resPx)
	public static int marges = 50; //marges pour affichage
	private static FileWriter fw;

	public static void main(String[] args) throws IOException {


		// CHOIX ALGO DE RESOLUTION

		//DeuxApprox algoDeTest = new DeuxApprox();
		//Descente algoDeTest = new Descente(new DeuxApprox());
		//Exact algoDeTest = new Exact();
		Dominant algoDeTest = new Dominant();

		// CHOIX DU NOMBRE DE NOEUDS
		int nbNoeuds = 100;

		// CHOIX DU NOMBRE DE CENTRES
		int k = 10;

		// CHOIX GENERATION DU PROBLEME 

		Cluster gen = new Cluster(10, 15); // (NbClusters, tailleClusters)
		//Uniforme gen = new Uniforme();
		//Importer gen = new Importer("test", 0); // (nomFichier, numéro de l'instance à charger dans ce fichier) Ne prends pas en compte les choix de nb de noeuds et de centres.

		// SAUVEGARDE DE L'INSTANCE
		boolean sauvegarde = false;
		String nomSauvegarde = new String("clusters");

		// ----------------------------------------

		int[] K = {3, 5, 10, 20};
		int[] n = {10, 25, 50, 100, 150, 200};
		int[] res = new int[n.length];

		fw = new FileWriter("export/perf"+algoDeTest.getClass().getName()+".csv");
		fw.write("k, ");
		for (int i=0; i<n.length; i++){
			fw.write(n[i]+", ");
		}
		fw.write("\n");

		for (int i=0; i<K.length; i++){
			for (int j=0; j<10; j++){
				for (int l=0; l<n.length; l++){
					System.out.println("K = "+K[i]+", N = "+n[l]+", #"+j);
					// Initialisation de l'instance
					Instance instanceDeTest = gen.generer(n[l], K[i]);

					// Timer pour temps d'éxécution
					long t1 = System.currentTimeMillis();

					// Résolution
					if(K[i] <= instanceDeTest.n){
						Solution solutionDeTest = algoDeTest.resoudre(instanceDeTest);
						solutionDeTest.afficheText();


						// Affichage temps d'éxecution
						long t2 = System.currentTimeMillis();
						float secondes = (float)(t2-t1)/1000;
						System.out.println("Nombre d'instances : "+ n[l]);
						System.out.println("Temps d'éxecution : " + secondes + " secondes.");

						res[l] = solutionDeTest.rayon;
						
						//fw.write(solutionDeTest.rayon+", ");
					} else {
						
						res[l] = 0;
						
						//fw.write(" , ");
					}
				}
				
				fw.write(K[i]+", ");
				for(int o=0; o<res.length;o++){
					fw.write(res[o]+", ");
				}
				
				fw.write("\n");
			}
		}

		fw.close();

	}
}



