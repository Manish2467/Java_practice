public class Polymorphism {
    int num1;
    int num2;


    public int add(int n1, int n2){
        return n1+n2;   
    }

    public int add(int l1, int l2, int l3){
        return l1+l2+l3;
    }
    public static void main(String[] args) {
        Polymorphism poly = new Polymorphism();

        System.out.println(poly.add(1,2));
        System.out.println(poly.add(1,2,3));
    }
}


// same class ma overriding mildaina

// overriding herne
