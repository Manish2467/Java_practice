import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    public static void main(String[] args) {
        try{
            FileWriter fwrite = new FileWriter("firstfile.txt");
            fwrite.write("hello my name is manish timsina");
            fwrite.close();
            System.out.println("you have successfully written in the file");
        }
        catch (IOException e){
            System.out.println("you have encountered an error");

        }
    }
}


// file close garne herne

// **finally ra try with resource herne
// csv read garne