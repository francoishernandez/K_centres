package Main;
import java.util.ArrayList;

public class Point {

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
	
	public String versString(){
		String rep = new String(x + "," + y);
		return rep;
	}
	
	
	public int distance (Point aComparer){
		return (int) Math.ceil(Math.sqrt(Math.pow(x-aComparer.getX(),2) + Math.pow(y-aComparer.getY(),2)));
	}
	
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
