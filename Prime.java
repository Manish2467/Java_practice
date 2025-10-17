    import java.util.Scanner;

    public class Prime {
        void check(int num){

            if (num <=1){
                System.out.println("the number is not prime");
            }

            boolean isprime = true;
            for(int i =2;i<=num/2;i++) {
                if (num % i == 0) {
                    //System.out.println(num +" is not a prime number");
                    isprime = false;
                    break;
                }
            }

                if(isprime){
                    System.out.println(num + " the number is prime number");
                }
                else {
                    System.out.println(num + " the number is not a prime ");
                }
            }


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Prime p = new Prime();
            String choice;

            do{
                System.out.println("enter the number");
                int a = sc.nextInt();
                p.check(a);
                sc.nextLine();

                System.out.println("do you want to continue??");
                choice = sc.nextLine();
            }while(choice.equalsIgnoreCase("Y"));
        }
    }
