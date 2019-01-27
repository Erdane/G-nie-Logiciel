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
	
	public static int load(String filename,char sep) throws IOException {
		int count = 0;
		int i = 0;
		String ligne = null;
		boolean keeprunning = true;
		File f = new File("C:\\Users\\mahob\\eclipse-workspace\\TD Génie Logiciel\\world_cities(1).csv");
		char[] ch = new char[(int)f.length()];
		
		try {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				ligne = br.readLine();
				//while(keeprunning) { 
				for (char ch1 : ch) {
					if(ligne != null) {
					//if (ligne.endsWith("\n")){
						al.add(ligne);
						//al1.addAll(al);
						count += 1;
					}
			       
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
	
	
}
