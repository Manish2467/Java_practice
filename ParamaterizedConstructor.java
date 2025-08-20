public class ParamaterizedConstructor {
    private int age;
    private String name;


    public ParamaterizedConstructor(int a, String n){
        this.age = a ;
        this.name = n;
    }

    public ParamaterizedConstructor(int a){
        this.age = a;
    }

    public void display(){
        System.out.println(age + " " + name);
    }

    public static void main(String[] args) {
        ParamaterizedConstructor para = new ParamaterizedConstructor(11, "manish");
        ParamaterizedConstructor para1 = new ParamaterizedConstructor(12);
        para.display();
        para1.display();
    }
    
}
