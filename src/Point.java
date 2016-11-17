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
		String rep = new String(x + "," + y);
		return rep;
	}
	
	
	int distance (Point aComparer){
		return (int) Math.floor(Math.sqrt(Math.pow(x-aComparer.getX(),2) + Math.pow(y-aComparer.getY(),2)));
	}
	
	int distanceMinListe (ArrayList<Point> aComparer){
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
