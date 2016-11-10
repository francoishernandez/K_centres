import java.util.ArrayList;

public class Solution {

	int k;
	int rayon;
	ArrayList<Point> centres;
	
	int getK(){
		return k;
	}
	int getRayon(){
		return rayon;
	}
	ArrayList<Point> getCentres(){
		return centres;
	}
	
	Solution(int k, int rayon, ArrayList<Point> centres){
		this.k = k;
		this.rayon = rayon;
		this.centres = centres;
	}
	
	String versStringCentres(){
		String rep = new String(centres.get(0).versString());
		for (int i = 1; i<k; i++){
			rep = rep + ", " + centres.get(i).versString();
		}
		return rep;
	}
	
	void afficheText(){
		System.out.println("Solution de rayon : " + rayon);
		System.out.println("Liste des " + k + " centres : " + versStringCentres());
	}
	
}
