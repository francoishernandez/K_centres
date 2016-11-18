package Main;
import java.util.ArrayList;

public class Solution {

	int rayon;
	ArrayList<Point> centres;
	
	public int getK(){
		return centres.size();
	}
	public int getRayon(){
		return rayon;
	}
	public ArrayList<Point> getCentres(){
		return centres;
	}
	
	public Solution(int rayon, ArrayList<Point> centres){
		this.rayon = rayon;
		this.centres = centres;
	}
	
	public String versStringCentres(){
		String rep = new String(centres.get(0).versString());
		for (int i = 1; i<centres.size(); i++){
			rep = rep + ", " + centres.get(i).versString();
		}
		return rep;
	}
	
	public void afficheText(){
		System.out.println("Solution de rayon : " + rayon);
		System.out.println("Liste des " + centres.size() + " centres : " + versStringCentres());
	}
	
}
