import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Exception;

public class Csv {
    public static void main(String[] args) {
        String line;
        String file = "data.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            while((line = br.readLine())!= null){
                String[] values =  line.split(",");
                for(String v : values){
                    System.out.print(v + " ");


                }
                System.out.println();

            }
        }

        catch(Exception e){
            System.out.println(e);
        }
    }
}
