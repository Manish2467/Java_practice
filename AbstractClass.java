abstract class Car{
    int num = 10;
    public abstract void drive();
    public abstract void fly();

    public void playMusic(){
        System.out.println("car music playing..");
    }
}

class Toyota extends Car{
    public void drive(){
        System.out.println("toyota drives...");
    }

    public void fly(){
        System.out.println("the car is flying..");
    }
    
    public void printNUm(){
        System.out.println(num);
    }
}



public class  AbstractClass  {
    public static void main(String[] args) {
        Toyota car = new Toyota();    //toyota ra car ko difference
        car.drive();
        car.playMusic();
        car.printNUm();
    }
}




/*
 * 
 * abstract class vanna le chai kunai pani method lai aile describe na garnu parda use hunxa 
 * object banauda direct abstract ko object bandaina 
 * object banauda abstract class obj_name = new Class();
 * abstract class ma bhako abstract method haru use garnai parxa jun class le extend garxa tesle
 * abstract class ma normal method matra huda ni error audaina 
 * abstract class ma jati pani abstract method haru huna pauxa
 * 
 */