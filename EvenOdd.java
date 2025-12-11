import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            int a = sc.nextInt();

            if (a % 2 == 0) {
                System.out.println(a + " is even number");
            } else {
                System.out.println(a + " is odd number");
            }
            System.out.println("do you want to continue");
            choice = sc.next();
        }while(choice.equalsIgnoreCase("Y"));
    }
}
