package Resolution;
import java.util.ArrayList;
import java.util.Collections;

import Main.*;

public class Dominant {

	public Solution resoudre(Instance I) {
		
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
		Collections.sort(listeDistances);
		
		
		ArrayList<Point> C = new ArrayList<Point>();
		
		//while
		
		// A FINIR !
		return null;
		
	}
	
}
