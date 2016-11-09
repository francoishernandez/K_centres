
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

		//2 choix : soit charger soit générer

		//algoDeTest.resoudre(instanceDeTest);
		
		ArrayList<Point> sol = new ArrayList<Point>();
		sol.add(new Point(10,10));
		sol.add(new Point(20,10));
		
		Solution solutionDeTest = new Solution(2,10,sol);
		
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
			System.err.println(e);
		}

	}
}

//AFFICHAGE DANS LE MAIN



