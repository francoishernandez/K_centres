
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class test {

	private static Fenetre f;
	private static Panel pan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deuxapprox algoDeTest = new Deuxapprox();
		
		ArrayList<Point> centresClusters = new ArrayList<Point>();
		centresClusters.add(new Point(30,30));
		centresClusters.add(new Point(80,80));
		Cluster gen = new Cluster(centresClusters);

		//2 choix : soit charger soit generer
		
		Instance instanceDeTest = gen.generer(51, 5);
		instanceDeTest.afficheText();

		
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



