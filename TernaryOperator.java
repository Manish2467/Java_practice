import java.util.Scanner;

public class TernaryOperator {
    public static void main() {
       /* int age = 10;
        String result = (age > 9) ? "Yes" : "No";
        System.out.println(result);
        */

        System.out.println("enter the age to check if he/she is eligible for voting or not: ");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        String result = (age > 18) ? "yes he/she is eligible":"no not eligible";
        System.out.println(result);
    }
}
