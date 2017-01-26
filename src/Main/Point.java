package Main;
import java.util.ArrayList;

public class Point {

	//Coordonnées
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
	
	
	//Distance du point courant au point aComparer
	public int distance (Point aComparer){
		return (int) Math.ceil(Math.sqrt(Math.pow(x-aComparer.getX(),2) + Math.pow(y-aComparer.getY(),2)));
	}
	
	//Distance minimale du point courant à une liste de points aComparer
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
	
}
