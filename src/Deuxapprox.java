import java.util.ArrayList;

public class Deuxapprox extends Algo {

	Solution resoudre(Instance I) {
		
		ArrayList<Point> Sol = new ArrayList<Point>();
		ArrayList<Point> pointsAtraiter = new ArrayList<Point>(I.points);
		Point pointInitial = pointsAtraiter.remove(0);
		Sol.add(pointInitial);
		
		for (int i = 1; i<I.k; i++){
			int distanceMax = 0;
			int indiceMax = 0;
			for (int j = 0; j<pointsAtraiter.size(); j++){
				int distanceJ = pointsAtraiter.get(j).distanceMinListe(Sol);
				if ( distanceJ > distanceMax ) {
					distanceMax = distanceJ;
					indiceMax = j;
				}
			}
			Point plusLoin = pointsAtraiter.remove(indiceMax);
			Sol.add(plusLoin);
		}
		
		//Calcul du rayon :
		
		int rayon = 0;
		for (int j = 0; j<pointsAtraiter.size(); j++){
			int distanceJ = pointsAtraiter.get(j).distanceMinListe(Sol);
			if ( distanceJ > rayon ) {
				rayon = distanceJ;
			}
		}
		
		
		Solution rep = new Solution (I.k,rayon,Sol);
		return rep;
	}

	
}

