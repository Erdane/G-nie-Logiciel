import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        String chemin = "C:\\Users\\mahob\\eclipse-workspace\\TD Génie Logiciel\\world_cities(1).csv";
        int rowsLoaded = ReaderCSV.load(chemin,',');
        System.out.println(rowsLoaded + " rows loaded");
        /*ArrayList<ArrayList<String>> data =
                loader.getData();
        for (ArrayList<String> line: data) {
          System.out.println(line);
        }*/
    }

}
