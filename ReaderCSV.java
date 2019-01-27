import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderCSV {
	
	static char sep;
	static ArrayList<String> al = new ArrayList<String>();
	static ArrayList<String> al1 = new ArrayList<String>();
	static File f = new File("C:\\Users\\mahob\\eclipse-workspace\\TD Génie Logiciel\\world_cities(1).csv");
	static char[] ch = new char[(int)f.length()];
	
	public static int load(String filename,char sep) throws IOException {
		int count = 0;
		int i = 0;
		String ligne = "";
		boolean keeprunning = true;
		
		
		try {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				
				//while(keeprunning) { 
				for (char ch1 : ch) {
					if(ligne != null) {
					//if (ligne.endsWith("\n")){
						//for (i=0; i<f.length(); i++) {
							ligne =  br.readLine();
							System.out.println(ligne);
							al.add(ligne);
						//al1.addAll(al);
							count += 1;
					}
					//}
			       
					/*if (ligne == null) {
						keeprunning = false;
					}*/
					i++;
				}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						}
		
		return count;
	}
	
	
	public static int fieldCount(String filename) throws IOException {
		int nbrField = 0;
		BufferedReader br;
		String[] fields; //Tableau de string pour chaque champs
		
		try {
			br = new BufferedReader(new FileReader(filename));
			String ligne = br.readLine();
			fields = ligne.split(",");
			for (int i = 0; i<fields.length; i++) {
				if (fields[i] != null) {
					nbrField += 1;
					}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return nbrField;
	}
	
	
}
