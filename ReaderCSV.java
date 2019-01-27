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
		String ligne = "";
		try {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				for (char ch1 : ch) {
					if(ligne != null) {
							ligne =  br.readLine();
							System.out.println(ligne);
							al.add(ligne);
							count += 1;
					}
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
					System.out.println("Field " + (i+1) + " : " + fields[i]);
					nbrField += 1;
					}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return nbrField;
	}
	
	
}
