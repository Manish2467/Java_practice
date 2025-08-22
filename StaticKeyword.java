



public class StaticKeyword {
    private String name;
    static int age;

    public void SetName(String n){
        this.name = n ;

    }

    

    public void GetName(){
        System.out.println(this.name);
    }
    public static void main(String[] args) {
        
        StaticKeyword sk = new StaticKeyword();
        sk.SetName("manish timsina"); 
        StaticKeyword.age = 12; 
        System.out.println(StaticKeyword.age);
        sk.GetName(); 

        StaticKeyword sk1 = new StaticKeyword();
        sk1.SetName("nikesh");
        //StaticKeyword.age = 13;
        sk1.GetName();
        System.out.println(StaticKeyword.age);

    }
}



/*
 * 
 * static keyword use garda chai class name hunxa object hudaina 
 * static le chai euta object le tyo value modify hano vane arko bata ni change hunxa sabai le eutai value modify hanne ho 
 * 
 * 
 */