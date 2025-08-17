
public class access_modifier {

    private String names;
    public String age;
    protected String gender;

    void SetName(String name){
        this.names = name;
    }

    String GetName(){
        return names;
    }

    
    public static void main(String[] args) {
        access_modifier a = new access_modifier();
        a.SetName("Manish");            // private access modifier
        a.SetName("Nikesh");
        
        System.out.println(a.GetName());

        a.age = "12";               //public access modifier
        System.out.println(a.age);

    }
}
