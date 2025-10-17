import java.util.Scanner;

class student{
    String name;
    int grade;

    public student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }
}



public class Marray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of an array");
        int size = sc.nextInt();
        sc.nextLine();

        student[] stds = new student[size];         // yo chai hami le student ko object ko array banako

        for(int i = 0;i<size;i++){
            System.out.println("enter name of the student: ");
            String name = sc.nextLine();

            System.out.println("enter the class of the student: ");
            int grade = sc.nextInt();
            sc.nextLine();

            stds[i] = new student(name,grade);


        }

        for(student s : stds){      // for-each-loop (class_name name : object_name)
            System.out.println("Name: "+s.name+" Grade: "+s.grade);
        }


    }
}
