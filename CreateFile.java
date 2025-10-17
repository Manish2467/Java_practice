import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        File f = new File("firstfile.txt");
        try{
            if(f.createNewFile()){
                System.out.println("the file is created "+f.getName());
            }
            else{
                System.out.println("you already have the file with same name");
            }
        }
        catch (IOException e){
            System.out.println("you have encountered an error");
        }

    }
}
