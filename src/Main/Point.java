package Main;
import java.util.ArrayList;

public class Point {

	// Coordonnées
	int x;
	int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	// Pour affichage et export
	public String versString(){
		String rep = new String(x + "," + y);
		return rep;
	}
	
	
	// Distance du point courant au point aComparer
	public int distance (Point aComparer){
		return (int) Math.ceil(Math.sqrt(Math.pow(x-aComparer.getX(),2) + Math.pow(y-aComparer.getY(),2)));
	}
	
	// Distance minimale du point courant à une liste de points aComparer
	public int distanceMinListe (ArrayList<Point> aComparer){
		int taille = aComparer.size();
		int rep = Integer.MAX_VALUE;
		for (int i = 0; i<taille; i++){
			int courant = this.distance(aComparer.get(i));
			//System.out.println(courant);
			if (courant < rep) {
				rep = courant;
			}
		}
		
		return rep;
	}
	
	// Nécessaire pour l'algo dominant.
	// Détermine si le point est couvert par les points centres et le rayon rayon
	public boolean estCouvert(ArrayList<Point> centres, int rayon){
		int distMin = this.distanceMinListe(centres);
		return (distMin <= rayon);
	}
	
	// Nécessaire pour l'algo dominant.
	// Donne la liste des voisins du point courant pour un rayon donné
	public ArrayList<Point> voisins(ArrayList<Point> points, int rayon){
		ArrayList<Point> rep = new ArrayList<Point>();
		for (int i = 0; i<points.size(); i++){
			// Pb créer une nouvelle instance du point comparé ?
			if (this.distance(points.get(i))<=rayon){
				rep.add(points.get(i));
			}
		}
		return rep;
	}
	
	// Nécessaire pour l'algo dominant.
	// Le nombre de voisins non couverts par une liste de centres avec un rayon donné
	public int nbVoisinsNonCouverts(ArrayList<Point> points, ArrayList<Point> centres, int rayon){
		ArrayList<Point> voisins = this.voisins(points, rayon);
		int rep = 0;
		for (int i = 0; i<voisins.size(); i++){ 
			if (!(voisins.get(i).estCouvert(centres, rayon))){
				rep++;
			}
		}
		return rep;
	}
	
}
