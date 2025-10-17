

public class Inheritance extends Vehicle {
    public static void main(String[] args) {
        Inheritance inh = new Inheritance();
        inh.setName("ford");
        inh.setNum(12);
        System.out.println(inh.getName());
        System.out.println(inh.getNumber());
    }
}
