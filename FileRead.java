import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
    public static void main(String[] args) {
        try{
            File f = new File("firstfile.txt");
            Scanner sc = new Scanner(f);
                while (sc.hasNextLine()) {
                    String data = sc.nextLine();
                    System.out.println(data);
                }


        } catch (FileNotFoundException e) {
            System.out.println("you have encountered an error");
        }
    }
}
