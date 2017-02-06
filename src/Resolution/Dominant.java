package Resolution;
import java.util.ArrayList;
import java.util.Collections;

import Main.*;

public class Dominant {

	public Solution resoudre(Instance I) {
		
		
		// On commence par calculer la liste des distances entre tous les points
		ArrayList<Integer> listeDistances = new ArrayList<Integer>();
		int n = I.getN();
		for (int i=0; i<n; i++){
			Point pointCourant = I.getPoints().get(i);
			for (int j=0; j<n; j++){
				if (i!=j){
					int d = pointCourant.distance(I.getPoints().get(j));
					listeDistances.add(d);
				}
			}
		}
		// On trie les distances par ordre croissant
		Collections.sort(listeDistances);
		
		// On va utiliser la première distance de la liste pour essayer de trouver une solution.
		// Tant qu'on a pas trouvé de solution, on continue avec la distance suivante.
		// L'aglo s'arrête forcément (avec la distance la plus grande un seul centre suffit
		// à couvrir tous les points, donc on trouve forcément une solution)
		int i = 0;
		while(true){

			// on notera d la distance courante
			int d = listeDistances.get(i);
			ArrayList<Point> C = new ArrayList<Point>();
			
			// Pour trouver une solution on construit notre liste centre par centre :
			// On choisit à chaque fois le point qui possède le plus de voisins (à la distance d) non couverts
			for (int k=0; k<I.getK(); k++){
				Point e = I.maxSommetsNonCouverts(C, d);
				C.add(e);
			}
			
			// Une fois notre liste de K centres construite, on vérifie si elle est solution de l'instance à la distance d
			if (I.estCouvert(C, d)){
				// Si oui, on peut calculer le score exact de la solution (meilleur ou égal à la distance d) et la renvoyer
				int rayon = I.calculRayon(C);
				Solution sol = new Solution(rayon,C);
				return sol;
			}
			// Sinon, on passe à la distance suivante
			i++;
		}
	}
	
}
