interface Shape{
   double area();
    double perimeter();

}

class Circle implements Shape{
    final double pi = 3.14;
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }


    public double area(){
        return pi*radius*radius;

    }

    public double perimeter(){
        return 2*pi*radius;
    }
}

class Rectangle implements Shape{
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    public double area(){
        return length*breadth;
    }

    public double perimeter(){
        return length+length+breadth+breadth;
    }
}

public class Interface {
    public static void main(String[] args) {
        Shape s = new Circle(3.44);
        System.out.println(s.area());
        System.out.println(s.perimeter());

        Shape r = new Rectangle(3,4);
        System.out.println(r.area());
        System.out.println(r.perimeter());

    }
}
