package Main;
import java.util.ArrayList;

public class Instance {

	int n;
	int k;
	ArrayList<Point> points;

	public ArrayList<Point> getPoints(){
		return points;
	}
	public int getN(){
		return n;
	}
	public int getK(){
		return k;
	}
	
	public Instance(int n, int k, ArrayList<Point> points){
		this.n = n;
		this.k = k;
		this.points = points;
	}
	
	public int calculRayon(ArrayList<Point> centres){
		int rep = 0;
		for (int j = 0; j<n; j++){
			int distanceJ = points.get(j).distanceMinListe(centres);
			if ( distanceJ > rep ) {
				rep = distanceJ;
			}
		}
		return rep;
	}

	public String versStringPoints(){
		String rep = new String(points.get(0).versString());
		for (int i = 1; i<n; i++){
			rep = rep + "," + points.get(i).versString();
		}
		return rep;
	}
	
	public void afficheText(){
		System.out.println("Nombre de points : " + n);
		System.out.println("Nombre de centres : " + k);
		System.out.println("Liste des points : " + versStringPoints());
	}

	
}
