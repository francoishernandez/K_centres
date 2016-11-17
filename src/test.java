
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class test {

	private static Fenetre f;
	private static Panel pan;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//algoDeTest = new XXX; //choix de l'algo

		Uniforme gen = new Uniforme();

		Instance instanceDeTest = gen.generer(4, 1);
		instanceDeTest.afficheText();

		//2 choix : soit charger soit g�n�rer

		//algoDeTest.resoudre(instanceDeTest);

		ArrayList<Point> sol = new ArrayList<Point>();
		sol.add(instanceDeTest.getPoints().get(0));
		sol.add(instanceDeTest.getPoints().get(1));
		
		//ceci est un commentaire de test
		//ceci est un deuxieme commentaire
		
		Solution solutionDeTest = new Solution(sol.size(),10,sol);

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



