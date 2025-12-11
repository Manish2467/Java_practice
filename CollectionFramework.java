import java.util.*;

public class CollectionFramework {
    static void main() {
        List<String> names = new ArrayList<>(); // duplicates ni allow garxa //arraylist kina
        names.add("manish");
        names.add("hari");
        System.out.println(names.get(0));
        names.add("abcd");
        names.add(1,"gopal");
        System.out.println(names.size());
        names.remove("manish");

        for(String nam : names){
            System.out.println(nam);
        }




        Set<String> emails = new HashSet<>();  // set le chai duplicate ledaina // hashset kina
        emails.add("manish@gmail.com");
        emails.add("hari@gmail.com");
        emails.add("manish@gmail.com");


        for(String email : emails){
            System.out.println(email);
        }


        Map<Integer,String> nameid = new HashMap<>();  // key value pair store garxa  // hastmap kina
        nameid.put(1,"manish");
        nameid.put(2,"hari");
        nameid.put(3,"manish");

        System.out.println(nameid.get(1));  // get ani key value

        for(Map.Entry<Integer, String> entry : nameid.entrySet()){
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }

    }
}

// collection bhitra methods haru kk hunxa
// collection framework ko video (