package Main;
import java.util.ArrayList;

public class Solution {

	// Liste des centres choisis
	ArrayList<Point> centres;
	// Rayon minimal pour lequel tous les points du problème sont couverts par les disques
	int rayon;
	
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
	
	// Pour affichage et export
	public String versStringCentres(){
		String rep = new String(centres.get(0).versString());
		for (int i = 1; i<centres.size(); i++){
			rep = rep + ", " + centres.get(i).versString();
		}
		return rep;
	}
	
	// Pour affichage et export
	public void afficheText(){
		System.out.println("Solution de rayon : " + rayon);
		System.out.println("Liste des " + centres.size() + " centres : " + versStringCentres());
	}
	
	
}
