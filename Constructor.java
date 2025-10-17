public class Constructor {
    private int age;
    private String name;


    public Constructor(){                   // default constructor
       // System.out.println("this is the constructor");
       age = 11;
       name = "manish";
    }

    public Constructor(String nam){
        this.name = nam;
        this.age = 12;
    }

    public void display(){
        System.out.println(age + name);
    }

    public static void main(String[] args) {
        Constructor obj1 = new Constructor("hari");
        obj1.display();

        Constructor obj2 = new Constructor();
        obj2.display();
    }
}

//object create gardai value assign garxa constructor le 