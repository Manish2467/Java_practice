import java.util.Scanner;



public class OddEven {



    public void check(int num){
        if (num % 2 == 0) {
            System.out.println(num + " is a even number");
        }
        else{
            System.out.println(num + " is a odd number");
        }
    }


    public static void main(String[] args) {
        String choice;
        Scanner sc = new Scanner(System.in);
        OddEven ch = new OddEven();

        do {
            int a = sc.nextInt();
            ch.check(a);

            sc.nextLine();
            System.out.println("do you want to continue?");
            choice = sc.nextLine();
        }while(choice.equals("Y"));
    }
}


// try catch halnu paro float value