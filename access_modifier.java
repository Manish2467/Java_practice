import java.util.ArrayList;

public class access_modifier {

    private ArrayList<String> names = new ArrayList<>();
    public String age;
    protected String gender;

    void SetName(String name){
        names.add(name);
    }

    ArrayList<String> GetName(){
        return names;
    }

    
    public static void main(String[] args) {
        access_modifier a = new access_modifier();
        a.SetName("Manish");            // private access modifier
        a.SetName("Nikesh");
        
        for(String n : a.GetName()){
            System.out.println(n);
        }

        a.age = "12";               //public access modifier
        System.out.println(a.age);

    }
}
