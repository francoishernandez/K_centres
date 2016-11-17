import java.util.ArrayList;
import java.util.Random;

public class Cluster extends Generateur {

	ArrayList<Point> centresClusters;
	
	Cluster(ArrayList<Point> centresClusters){this.centresClusters = centresClusters;};
	
	Instance generer(int n, int k) {
		int nbClusters = centresClusters.size();
		ArrayList<Point> points = new ArrayList<Point>(); 
		int pClusters = n / nbClusters;
		int pRand = n % nbClusters;
		
		// Clusters :
		
		Random r = new Random();
		for (int i = 0; i < nbClusters; i++) {
			//centre :
			int yCentre = centresClusters.get(i).y;
			int xCentre = centresClusters.get(i).x;
			for (int j = 0; j < pClusters; j++) {
				int x = (int)Math.floor(r.nextGaussian()*10+xCentre);
				int y = (int)Math.floor(r.nextGaussian()*10+yCentre);
				Point p = new Point(Math.max(Math.min(x,100),0),Math.max(Math.min(y,100),0));
				points.add(p);
			}
		}
		
		// Points restants :
		
		for (int i = 0; i < pRand; i++) {
			int x = (int)Math.floor(Math.random()*100);
			int y = (int)Math.floor(Math.random()*100);
			Point p = new Point(x,y);
			points.add(p);
		}
		Instance rep = new Instance (n, k, points);
		return rep;
	}

}
