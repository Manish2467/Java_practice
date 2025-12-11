import java.util.Scanner;

public class StudentGrade {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println("enter the marks of the student: ");
            int marks = sc.nextInt();
            sc.nextLine();
            if (marks == 0) {
                System.out.println("the student is absent");
            } else {
                String result = (marks >= 40) ? "pass" : "fail";
                System.out.println(result);

                String grade = marks >= 85 ? "A" :
                        marks >= 75 ? "B" :
                                marks >= 55 ? "C" :
                                        marks >= 45 ? "D" : "E";
                System.out.println(grade);

            }
            System.out.println("do you want to continue:y/n");
            choice = sc.nextLine();

        } while (choice.equals("y")) ;
    }
}
