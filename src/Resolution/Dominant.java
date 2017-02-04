package Resolution;
import java.util.ArrayList;
import java.util.Collections;

import Main.*;

// A COMMENTER

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
		
		boolean cont = true; 
		int i = 0;
		while(cont){
			
			int d = listeDistances.get(i);
			ArrayList<Point> C = new ArrayList<Point>();
			
			for (int k=0; k<I.getK(); k++){
				Point e = I.maxSommetsNonCouverts(C, d);
				C.add(e);
			}
			
			if (I.estCouvert(C, d)){
				int rayon = I.calculRayon(C);
				Solution sol = new Solution(rayon,C);
				return sol;
			}
			
			i++;
			
		}
		return null;	
	}
	
}
