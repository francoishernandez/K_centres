package Resolution;
import java.util.ArrayList;
import Main.*;

public class DeuxApprox extends Algo {

	public Solution resoudre(Instance I) {
		
		// On construit notre Solution Sol progressivement
		ArrayList<Point> Sol = new ArrayList<Point>();
		ArrayList<Point> pointsAtraiter = new ArrayList<Point>(I.getPoints());
		// On commence par choisir un premier noeud quelconque qui sera notre premier centre
		Point pointInitial = pointsAtraiter.remove(0);
		Sol.add(pointInitial);
		
		// Tant qu'on a pas K centres, on rajoute des centres à notre solution :
		for (int i = 1; i<I.getK(); i++){
			// On cherche parmis les noeuds non encore choisis le noeud le plus éloigné de notre ensemble de centres 
			int distanceMax = 0;
			int indiceMax = 0;
			for (int j = 0; j<pointsAtraiter.size(); j++){
				int distanceJ = pointsAtraiter.get(j).distanceMinListe(Sol);
				if ( distanceJ > distanceMax ) {
					distanceMax = distanceJ;
					indiceMax = j;
				}
			}
			// On ajoute le centre à notre solution et on l'enlève de la liste des points restants
			Point plusLoin = pointsAtraiter.remove(indiceMax);
			Sol.add(plusLoin);
		}
		
		// On calcule le score et on renvoie la solution
		int rayon = I.calculRayon(Sol);
		Solution rep = new Solution (rayon,Sol);
		return rep;
	}

	
}

