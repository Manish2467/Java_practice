import java.util.Scanner;

abstract class Vehicles{
   public abstract void start();
   public abstract void stop();
   public void fuelType(){
       System.out.println("fuel type");
   }
}

interface Serviceable{
    void serviceDetails();
}

class Cars extends Vehicles implements Serviceable{
    private String name;
    private int number;
    private int year;
    String brand;

    /*public Cars(){
        System.out.println("this is default constructor");
    }
    public Cars(String nam , int num, int year){
        this.name = nam;
        this.number = num;
        this.year = year;
    }*/

    public void setName(Scanner sc){
        System.out.println("enter the name of the car");
        brand = sc.nextLine();
        System.out.println("enter the name of the car");
        name = sc.nextLine();

        System.out.println("enter number of car");
        number = sc.nextInt();
        System.out.println("enter year :");
        year = sc.nextInt();
        System.out.println("the car brand is : "+brand+" the number is : "+number+" the year is : "+year);

    }
    public void start(){
        System.out.println(name+" is starting and it's number is "+number);
    }

    public void stop(){
        System.out.println("car is stopping");
    }

    public void fuelType(){
        System.out.println("the car uses diesel");
    }

    public void serviceDetails(){
        System.out.println("Model: "+name+" brand: "+number+" year: "+ year);
    }
}

class  Bike extends Vehicles implements Serviceable{
    private String name;
    private int cc;

    public Bike(String nam, int cc){
        this.name = nam;
        this.cc = cc;
    }
    public void start(){
        System.out.println("the bike is starting");
    }
    public void stop(){
        System.out.println("the bike is stopping");
    }
    public void fuelType(){
        System.out.println("the bike uses petrol");
    }
    public void serviceDetails(){
        System.out.println(name+" and cc is : "+cc);
    }
}


public class VehicleManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Vehicles veh = new Cars("toyota",12,2012);
        //Serviceable s = new Cars("bmw",12, 2012);
        Cars cr = new Cars();
        Vehicles veh = new Cars();
        Serviceable s = new Cars();
        cr.setName(sc);
        cr.start();
        veh.stop();
        veh.fuelType();
        s.serviceDetails();

        Vehicles bik = new Bike("honda",125);   // kina vehicles nai lekhnu paro
        Serviceable s1 = new Bike("honda",125);
        bik.start();
        bik.stop();
        bik.fuelType();
        s1.serviceDetails();
    }
}
