import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ReaderCSV {
	
	static char sep;
	static ArrayList<String> al = new ArrayList<String>();
	static ArrayList<String> arrayFields = new ArrayList<String>();
	static File f = new File("C:\\Users\\mahob\\eclipse-workspace\\TD Génie Logiciel\\world_cities(1).csv");
	static char[] ch = new char[(int)f.length()];
	
	public static int load(String filename,char sep) throws IOException {
		int count = 0;
		int i;
		String ligne = "";
		try {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				for (char ch1 : ch) {
					ligne =  br.readLine();
					if(ligne != null) {		
							al.add(ligne);
							count += 1;
					}
				}
				i=0;
				while (i<al.size()) {
					for (String elem : al) {
						System.out.println("Row " + (i+1) + " : " + elem);
						i++;
					}
				}
			} catch (FileNotFoundException e) {
						e.printStackTrace();
				}
		
		return count;
	}
	
	
	public static int fieldCount(String filename) throws IOException {
		int nbrField = 0;
		int i = 0;
		BufferedReader br;
		String ligne = "";
		String[] fields;//Tableau de string pour chaque champs
		
		try {
			br = new BufferedReader(new FileReader(filename));				
			for (char ch2 :ch) {
				ligne = br.readLine();
				if (ligne !=null) {	
					fields  = ligne.split(",");
					i = 0;
					while(i<fields.length) {
						arrayFields.add(fields[i]);
						nbrField += 1;
						i++;
					}
				}
			}
			i=0;
			while (i<arrayFields.size()) {
				for (String elem : arrayFields) {
				
						System.out.println("Field " + (i+1) + " : " + elem );
						i++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		
		return nbrField;
	}
	
	
}
