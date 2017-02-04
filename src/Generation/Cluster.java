package Generation;
import java.util.ArrayList;
import java.util.Random;
import Main.*;

public class Cluster extends Generateur {

	ArrayList<Point> centresClusters;
	int sigma;
	
	//On peut générer soit en donnant la liste des clusters :
	public Cluster(ArrayList<Point> centresClusters, int sigma){
		this.centresClusters = centresClusters;
		this.sigma = sigma;
	};
		
	//Soit en choisissant aléatoirement nbClusters :
	public Cluster(int nbClusters, int sigma){
		ArrayList<Point> centresClusters = new ArrayList<Point>(); 
		for (int i = 0; i < nbClusters; i++) {
			int x = 2*Main.marges + (int)Math.floor(Math.random()*(Main.resPx-4*Main.marges));
			int y = 2*Main.marges + (int)Math.floor(Math.random()*(Main.resPx-4*Main.marges));
			Point p = new Point(x,y);
			centresClusters.add(p);
		}
		this.centresClusters = centresClusters;
		this.sigma = sigma;
	};
	
	
	public Instance generer(int n, int k) {
		int nbClusters = centresClusters.size();
		ArrayList<Point> points = new ArrayList<Point>(); 
		int pClusters = n / nbClusters;
		int pRand = n % nbClusters;
		
		// Clusters :
		
		Random r = new Random();
		for (int i = 0; i < nbClusters; i++) {
			//centre :
			int yCentre = centresClusters.get(i).getY();
			int xCentre = centresClusters.get(i).getX();
			for (int j = 0; j < pClusters; j++) {
				int x = (int)Math.floor(r.nextGaussian()*sigma+xCentre);
				int y = (int)Math.floor(r.nextGaussian()*sigma+yCentre);
				Point p = new Point(Math.max(Math.min(x,Main.resPx-Main.marges),Main.marges),Math.max(Math.min(y,Main.resPx-Main.marges),Main.marges));
				points.add(p);
			}
		}
		
		// Points restants :
		
		for (int i = 0; i < pRand; i++) {
			int x = (int)Math.floor(Math.random()*Main.resPx);
			int y = (int)Math.floor(Math.random()*Main.resPx);
			Point p = new Point(x,y);
			points.add(p);
		}
		Instance rep = new Instance (n, k, points);
		return rep;
	}

}
