package Main;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

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
