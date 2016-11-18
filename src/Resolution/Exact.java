package Resolution;
import java.util.ArrayList;
import Main.*;

public class Exact extends Algo {

	public Solution resoudre(Instance I) {
		return appelRec(I, I.getPoints(), I.getK(), new ArrayList<Point>());
	}

	Solution appelRec(Instance I, ArrayList<Point> pointsRestants, int kRestant, ArrayList<Point> sol){
		int nbRestants = pointsRestants.size();
		if (kRestant == 0) {
			int score = I.calculRayon(sol);
			return new Solution(score, sol);
		}
		else {
			int meilleurScore = Integer.MAX_VALUE;
			ArrayList<Point> meilleureSol = new ArrayList<Point>();
			for (int i=0; i < nbRestants; i++){
				ArrayList<Point> copieSol = new ArrayList<Point>(sol);
				ArrayList<Point> copieRestants = new ArrayList<Point>(pointsRestants);
				copieSol.add(copieRestants.remove(i));
				Solution solRec = appelRec(I, copieRestants, kRestant-1, copieSol);
				if (solRec.getRayon()<meilleurScore){
					meilleurScore = solRec.getRayon();
					meilleureSol = solRec.getCentres();
				}
			}
			return new Solution(meilleurScore, meilleureSol);
		}
	}
	
}
