package Main;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Instance {

	int n; // Nombre de points
	int k; // Nombre de centres attendus
	ArrayList<Point> points; // Liste des n points

	public ArrayList<Point> getPoints(){
		return points;
	}
	public int getN(){
		return n;
	}
	public int getK(){
		return k;
	}
	
	public Instance(int n, int k, ArrayList<Point> points){
		this.n = n;
		this.k = k;
		this.points = points;
	}
	
	// Evaluation pour l'instance courante du rayon minimal pour une liste de centres
	public int calculRayon(ArrayList<Point> centres){
		int rep = 0;
		for (int j = 0; j<n; j++){
			int distanceJ = points.get(j).distanceMinListe(centres);
			if ( distanceJ > rep ) {
				rep = distanceJ;
			}
		}
		return rep;
	}

	// Pour affichage et export
	public String versStringPoints(){
		String rep = new String(points.get(0).versString());
		for (int i = 1; i<n; i++){
			rep = rep + "," + points.get(i).versString();
		}
		return rep;
	}
	
	// Pour affichage et export
	public void afficheText(){
		System.out.println("Nombre de points : " + n);
		System.out.println("Nombre de centres : " + k);
		System.out.println("Liste des points : " + versStringPoints());
	}
	
	// Export d'une liste d'instances
	public void createFile(String name, ArrayList<Instance> instances) throws IOException{
		int nbTests = instances.size();
		FileWriter fw = new FileWriter("instances/"+name+".txt");
		fw.write(nbTests+"\n"+"\n");
		for (int i = 0; i<nbTests; i++){
			int nbI = instances.get(i).getN();
			int nbC = instances.get(i).getK();
			fw.write(nbI+","+nbC+"\n");
			fw.write(instances.get(i).versStringPoints()+"\n"+"\n");
		}
		fw.flush();
		fw.close();
	}
	
	// Export d'une instance unique
	public void createFile(String name) throws IOException{
		ArrayList<Instance> instances = new ArrayList<Instance>();
		instances.add(this);
		this.createFile(name, instances);
	}
	
}
