
public class AccessModifier {

    private String names;
    public String age;
    protected String gender;

    void setName(String name){
        this.names = name;
    }

    String getName(){
        return names;
    }

    
    public static void main(String[] args) {
        AccessModifier a = new AccessModifier();
        AccessModifier b = new AccessModifier();
        a.setName("Manish");            // private access modifier
        b.setName("Nikesh");
        
        System.out.println(a.getName());
        System.out.println(b.getName());

        a.age = "12";               //public access modifier
        System.out.println(a.age);

    }
}
