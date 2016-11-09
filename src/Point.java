import java.util.ArrayList;

public class Point {

	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	int getX(){
		return x;
	}
	int getY(){
		return y;
	}
	
	String versString(){
		String rep = new String(x + ", " + y);
		return rep;
	}
	
	
	int distance (Point aComparer){
		return (int) Math.floor(Math.sqrt((x-aComparer.x)^2 + (y-aComparer.y^2)));
	}
	
	int distanceListe (ArrayList<Point> aComparer){
		int taille = aComparer.size();
		int rep = 0;
		for (int i = 0; i<taille; i++){
			int courant = this.distance(aComparer.get(i));
			if (courant > rep) {
				rep = courant;
			}
		}
		return rep;
	}
	
}
