package Generation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Main.*;

public class Recuperer extends Generateur {

	public Recuperer(){}

	@Override
	public Instance generer(int n, int k) {
		// TODO Auto-generated method stub
		return null;
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

}
