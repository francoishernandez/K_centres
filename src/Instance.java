import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

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
	/*
	void getFromFile(String name) throws FileNotFoundException{
		FileReader fr = new FileReader(name);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		
		int nbInstances = 
		
		
		String[] strs = line.trim().split(", ");
		
		ArrayList<int> temp = new ArrayList<int>();
		
		
	}*/
	
}
