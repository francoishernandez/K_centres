import java.util.ArrayList;

public class Uniforme extends Generateur {

	Uniforme(){};
	
	Instance generer(int n, int k) {
		ArrayList<Point> points = new ArrayList<Point>(); 
		for (int i = 0; i < n; i++) {
			int x = (int)Math.floor(Math.random()*100);
			int y = (int)Math.floor(Math.random()*100);
			Point p = new Point(x,y);
			points.add(p);
		}
		Instance rep = new Instance (n, k, points);
		return rep;
	}

}
