package Resolution;

import java.util.ArrayList;

import Main.*;

public class Descente {

	public Solution resoudre(Instance I) {
		
		DeuxApprox init = new DeuxApprox();
		Solution solInit = init.resoudre(I);
		int k = I.getK();
		int n = I.getN();
		ArrayList<Point> points = I.getPoints();
		int r = solInit.getRayon();
		ArrayList<Point> centres = solInit.getCentres();
		
		System.out.println("Avant Descente : rayon = " + r);
		
		// Pour chaque centre, on va essayer de le permuter tour à tour avec les autres points de l'instance.
		// Si la permutation améliore la solution, on la retient et on recommence.
		// On s'arrête quand plus aucun échange n'améliore la solution.
		
		boolean onContinue = true;
		while (onContinue) {
			onContinue = false; // On s'arrête quand on arrive plus à progresser
			for (int i = 0; i<k; i++){ // On essaie pour chaque centre 
				boolean ceCentreEstBon = true;
				Point centreCourant = centres.remove(0); 
				for (int j = 0; j<n; j++){ // On essaie de remplacer le centre par les points de l'instance
					centres.add(points.get(j));
					int rCourant = I.calculRayon(centres);
					if (rCourant < r){ // Si la permutation améliore la solution :
						r = rCourant;
						onContinue = true; // On continue l'algo
						ceCentreEstBon = false;
						i = k; // On sort des boucles
						j = n; // On sort des boucles
					}
					else {
					centres.remove(k-1);
					}
				}
				if (ceCentreEstBon){ // Si aucune permutation ne fonctionne, on garde le centre
					centres.add(centreCourant);
				}
			}
		}
		
		Solution sol = new Solution(r, centres);
		return sol;
		
	}
}
