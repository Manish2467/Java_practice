import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.Exception;

public class CsvReader {
    static void main() throws FileNotFoundException {
        String file = "data.csv";
        String line ;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){  //why??
            while ((line = br.readLine()) != null) {
//                line.split(",");
//                System.out.println(line);

                String[] values = line.split(",");
                for(String valu : values){
                    System.out.print(valu+" ");
                }
                System.out.println(" ");
            }

        }
        catch (Exception e){
            System.out.println("Error in reading spreadsheet"+e.getMessage());

        }
    }
}
