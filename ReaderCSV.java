import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderCSV {
	
	static char sep;
	static String enter = System.getProperty("line.separator");
	static ArrayList<String> al = new ArrayList<String>();
	static ArrayList<String> arrayFields = new ArrayList<String>();
	static File f = new File("C:\\Users\\mahob\\eclipse-workspace\\TD Génie Logiciel\\Institutions.csv");
	static char[] ch = new char[(int)f.length()];
	
	
	
	public static int load(String filename,char sep) throws IOException {
		int count = 0;
		int i;
		String ligne = "";
		char charToDelete = '/';
		char[] ligneToChar;
		try {
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(new FileReader(filename));
				for (@SuppressWarnings("unused") char ch1 : ch) {
					ligne =  br.readLine();
					
					if(ligne != null) {	
						//Effacer les '/' s'il n'y a rien après (pour l'affichage des url)
						ligneToChar = ligne.toCharArray();
						for (i=0;i<ligneToChar.length;i++) {
							
							if (ligneToChar[i]==(charToDelete) && ligneToChar[i+1]==(sep)) {
								int indSup = ligne.indexOf(charToDelete);
								ligne = ligne.substring(indSup,indSup) + ligne.substring(0);
							}
							//Effacer les guillemets s'il y a plusieurs données dans un seul champ, mais il ne fonctionne pas 
							if (ligneToChar[i]==(',') && ligneToChar[i+1]==('\"')) {
								int indSup1 = ligne.indexOf(ligneToChar[i+1]);
								int j = i;
								while (ligneToChar[j]!=('\"') && ligneToChar[j+1] != (',')) {
									j++;
								}
								int indSup2 = ligne.indexOf((ligneToChar[j]));
								ligne = ligne.substring(indSup1,indSup1) + ligne.substring(indSup2,indSup2) + ligne.substring(0);
							}
						}
						al.add(ligne);
						al.add(enter);
						count += 1;
					}
					
				}
			} catch (NullPointerException | FileNotFoundException e) {
						System.out.println(e.getMessage());
				}
		
		return count;
	}

	
	
	public static int fieldCount(String filename) throws IOException {
		int nbrField = 0;
		int nbrFieldMax = 0;
		int i = 0;
		BufferedReader br;
		String ligne = "";
		String[] fields;//Tableau de string pour chaque champs
		
		try {
			br = new BufferedReader(new FileReader(filename));				
			for (@SuppressWarnings("unused") char ch2 :ch) {
				ligne = br.readLine();
				if (ligne !=null) {	
					fields  = ligne.split(",");
					
					nbrField = fields.length;
					if (nbrFieldMax < nbrField) {
						nbrFieldMax = nbrField;
					}
					
					i = 0;	
					while(i<fields.length) {
						arrayFields.add(fields[i]);
						i++;
					}
					
					
					
				}
			}
		} catch (NullPointerException | FileNotFoundException e) {
			System.out.println(e.getMessage());
			}
		
		return nbrFieldMax;
	}
	
	
	

	public static ArrayList<ArrayList<String>> getData(String filename) {
		ArrayList<ArrayList<String>> allArrays = new ArrayList<ArrayList<String>>();
		try {
		allArrays.add(al);
		} catch (NullPointerException e) {
			System.out.println("al pointe vers null ! " + e.getMessage());
		}
		return allArrays;
	}
	
}
