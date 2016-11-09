import java.util.ArrayList;

public class Instance {

	int n;
	int k;
	ArrayList<Point> points;

	ArrayList<Point> getPoints(){
		return points;
	}
	int getN(){
		return n;
	}
	
	Instance(int n, int k, ArrayList<Point> points){
		this.n = n;
		this.k = k;
		this.points = points;
	}

	String versStringPoints(){
		String rep = new String(points.get(1).versString());
		for (int i = 1; i<n; i++){
			rep = rep + ", " + points.get(i).versString();
		}
		return rep;
	}
	
	void afficheText(){
		System.out.println("Nombre de points : " + n);
		System.out.println("Nombre de centres : " + k);
		System.out.println("Liste des points : " + versStringPoints());
	}
	
}
