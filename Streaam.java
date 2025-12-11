import java.util.List;

public class Streaam {
    static void main() {
        List<String> names = List.of("manish", "jenish", "laxu", "mandeep", "manoj");

//        names.stream()
//                .filter(n -> n.length()>3)
//                .map(String :: toUpperCase)
//                .forEach(System.out::println);   //names.forEach(names -> system.out::println(names));
//    }

        List<String> nam = names.stream()
                .filter(n -> n.startsWith("m"))
                .map(String::toUpperCase)
                .toList();
        System.out.println(nam);
    }
}


// stream chai data lai clean sort garna help garxa aafai chai data store gardaina
// source -> intermediate node -> terminal operation
//aggregate function le chai stream use garxa

// aggregate functions le chai multiple value bata euta answer dinxa