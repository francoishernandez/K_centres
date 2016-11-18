package Generation;
import java.util.ArrayList;
import Main.*;

public class Uniforme extends Generateur {

	public Uniforme(){};
	
	public Instance generer(int n, int k) {
		ArrayList<Point> points = new ArrayList<Point>(); 
		for (int i = 0; i < n; i++) {
			int x = Main.marges + (int)Math.floor(Math.random()*(Main.resPx-2*Main.marges));
			int y = Main.marges + (int)Math.floor(Math.random()*(Main.resPx-2*Main.marges));
			Point p = new Point(x,y);
			points.add(p);
		}
		Instance rep = new Instance (n, k, points);
		return rep;
	}

}
