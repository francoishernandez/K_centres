package Generation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Main.*;

public class Importer extends Generateur {

	public Importer(){}
	
	String nomFichier;
	int numeroInstance;

	@Override
	public Instance generer(int n, int k){
		try {
		ArrayList<Instance> instancesRecup = this.getFromFile(nomFichier);
		return instancesRecup.get(numeroInstance);
		} 
		catch(Exception e){
			System.err.println("Erreur à l'import des instances.");
			System.err.println(e);
			return null;
		}
	}
	
	public Importer(String nomFichier, int numeroInstance){
		this.nomFichier = nomFichier;
		this.numeroInstance = numeroInstance;
	}

	public ArrayList<Instance> getFromFile(String name) throws IOException{
		FileReader fr = new FileReader("instances/"+name+".txt");
		BufferedReader br = new BufferedReader(fr);

		String firstline = br.readLine();

		int nbTests = Integer.parseInt(firstline);
		System.out.println(nbTests);

		String empty = br.readLine();

		ArrayList<Integer> nbInstances = new ArrayList<Integer>();
		ArrayList<Integer> nbCentres = new ArrayList<Integer>();
		ArrayList<Instance> instances = new ArrayList<Instance>();

		for (int i = 0; i<nbTests;i++){
			String[] integersInString = br.readLine().split(",");
			int a[] = new int[integersInString.length];
			for (int j = 0; j< integersInString.length; j++){
				a[j] = Integer.parseInt(integersInString[j]);
			}
			integersInString = br.readLine().split(",");
			int b[] = new int[integersInString.length];
			for (int j = 0; j< integersInString.length; j++){
				b[j] = Integer.parseInt(integersInString[j]);
			}
			ArrayList<Point> points = new ArrayList<Point>();
			for (int k = 0; k<b.length; k=k+2){
				Point p = new Point(b[k],b[k+1]);
				points.add(p);
			}
			Instance instance = new Instance(a[0],a[1],points);
			instances.add(instance);
			empty = br.readLine();
		}

		return instances;

	}


}
