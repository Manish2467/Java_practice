import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array");
        int size = sc.nextInt();
        int[] num = new int[size];
        String[] name = new String[size];
        System.out.println("enter the value then name to be stored in array");
        for(int i=0;i<size;i++){
            num[i] = sc.nextInt();
            sc.nextLine();
            name[i] = sc.nextLine();
        }

        for(int i=0;i<size;i++){
            System.out.println(num[i]);
            System.out.println(name[i]);
        }

    }
}
