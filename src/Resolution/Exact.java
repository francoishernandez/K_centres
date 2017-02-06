package Resolution;
import java.util.ArrayList;
import Main.*;

public class Exact extends Algo {

	public Solution resoudre(Instance I) {
		// On procédera par récursivité sur 
		return appelRec(I, I.getPoints(), I.getK(), new ArrayList<Point>());
	}

	// appelRec renvoie une solution optimale (minimisant le rayon) pour l'instance I sachant
	// qu'une liste sol de centres est déjà fixée et qu'il reste kRestant centres à choisir parmis la liste pointsRestants
	Solution appelRec(Instance I, ArrayList<Point> pointsRestants, int kRestant, ArrayList<Point> sol){
		int nbRestants = pointsRestants.size();
		if (kRestant == 0) {
			// Si il n'y a plus de centres à rajouter, on renvoie la solution telle qu'elle est
			int score = I.calculRayon(sol);
			return new Solution(score, sol);
		}
		else {
			int meilleurScore = Integer.MAX_VALUE;
			ArrayList<Point> meilleureSol = new ArrayList<Point>();
			// On parcourt tous les points possibles et on suppose tour à tour qu'on en choisi un
			for (int i=0; i < nbRestants; i++){
				ArrayList<Point> copieSol = new ArrayList<Point>(sol);
				ArrayList<Point> copieRestants = new ArrayList<Point>(pointsRestants);
				copieSol.add(copieRestants.remove(i));
				// Dans le cadre de notre hypothèse, on cherche le meilleur score obtensible
				Solution solRec = appelRec(I, copieRestants, kRestant-1, copieSol);
				if (solRec.getRayon()<meilleurScore){
					meilleurScore = solRec.getRayon();
					meilleureSol = solRec.getCentres();
				}
				// On garde le point qui a le meilleur score obtensible le plus élevé
			}
			return new Solution(meilleurScore, meilleureSol);
		}
	}
	
}
