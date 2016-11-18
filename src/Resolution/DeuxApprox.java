package Resolution;
import java.util.ArrayList;
import Main.*;

public class DeuxApprox extends Algo {

	public Solution resoudre(Instance I) {
		
		ArrayList<Point> Sol = new ArrayList<Point>();
		ArrayList<Point> pointsAtraiter = new ArrayList<Point>(I.getPoints());
		Point pointInitial = pointsAtraiter.remove(0);
		Sol.add(pointInitial);
		
		for (int i = 1; i<I.getK(); i++){
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
		
		int rayon = I.calculRayon(Sol);
		Solution rep = new Solution (rayon,Sol);
		return rep;
	}

	
}

