import java.util.ArrayList;
import java.util.List;

public class ListPractice {
    static void main() {
        List<String> names = new ArrayList<>();
        for(String name : names){
            System.out.println(name);
        }
        System.out.println("\n");

        names.add("manish");
        names.add(0,"hari");

        for(String name : names){
            System.out.println(name);
        }
        System.out.println("\n");

        names.set(0,"gaurab");
        for(String name : names){
            System.out.println(name);
        }
        System.out.println("\n");

        names.remove(0);
        names.remove("manish");
        for(String name : names){
            System.out.println(name);
        }
        System.out.println("\n");
    }
}

// list is an interface we cannot create object of interface
//    so arraylist is the class which implements list so we create new object of arraylist

