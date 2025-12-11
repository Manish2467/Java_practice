import com.mysql.cj.exceptions.ConnectionIsClosedException;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

// date matra herne, time matra ni herne created_at

public class UserLogin {
    public static void adminlogin(Scanner sc,String url,String username,String password) {
        try {
            System.out.println("enter email and password");
            String em = sc.nextLine();
            String pass = sc.nextLine();

            try (Connection con = DriverManager.getConnection(url, username, password)) {
                String query = "select * from student where email = ? and password = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, em);
                ps.setString(2, pass);

                ResultSet rs = ps.executeQuery();

                if (em.equals("admin@gmail.com") && pass.equals("admin")) {
                    System.out.println("admin logged in ");
                    String choice2;
                    do {
                        System.out.println("1) add student, 2) view student, 3)count age");
                        int choice = sc.nextInt();
                        sc.nextLine();
//                if (choice == 1){
//                    System.out.println("enter the number of students you want to add:");
//                    int num = sc.nextInt();
//                    sc.nextLine();
//                    for(int i =0;i<num;i++) {
//                        addstudent(sc, con);
//                    }
//                }
//                else if(choice == 2){
//                    viewstudent(con);
//                }
//                else{
//                    System.out.println("invalid choice");
//                }


                        switch (choice) {
                            case 1:
                                addstudent(sc, con);
                                break;
                            case 2:
                                viewstudent(con);
                                break;
                            case 3:
                                countage(con);
                                break;
                            default:
                                System.out.println("invalid choice");
                                break;
                        }
                        System.out.println("do you want to continue?");
                        choice2 = sc.nextLine();
                    } while (choice2.equalsIgnoreCase("y"));
                } else {
                    System.out.println("incorrect email or password");
                }
            }
        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }

    }

    public static void addstudent(Scanner sc,Connection con) {
        try {
            System.out.println("enter name,email ,password and age to add student");
            String nam = sc.nextLine();
            String em = sc.nextLine();
            if (!em.contains("@gmail.com")) {
                System.out.println("invalid email");
                return;
            }
            String pass = sc.nextLine();
            int age = sc.nextInt();
            sc.nextLine();

            String query = "insert into student(name,email,password,age) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nam);
            ps.setString(2, em);
            ps.setString(3, pass);
            ps.setInt(4, age);

            ps.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("you have entered wrong details");
        }
    }

    public static void viewdetails(Connection con,String id , String pass){
        try {
            String query = "select * from student where id = ? and password = ?";  // view  arkai method banayera , login paxi view choice , id bata view garaunu paro login gare paxi
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            System.out.printf("%-5s %-15s %-25s %-15s %-5s %-15s%n", "id", "name", "email", "password", "age", "Created_At");
            if (rs.next()) {
                System.out.printf("%-5d %-15s %-25s %-15s %-5d %-15s%n", rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getInt("age"),rs.getTimestamp("created_at").toLocalDateTime().toLocalDate());
            } else {
                System.out.println("invalid email or password");
            }
        }
        catch (SQLException e){
            System.out.println("you have entered wrong details");
        }
    }

    public static void viewstudent(Connection con){
        try {
            String query = "select * from student";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.printf("%-5s %-15s %-25s %-15s %-5s %-15s%n", "id", "name", "email", "password", "age", "Created_At");

            while (rs.next()) {
                // System.out.println("-------------------------------------------------------------------");
                System.out.printf("%-5d %-15s %-25s %-15s %-5d %-15s%n", rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getInt("age"), rs.getTimestamp("created_at"));
            }
        }
        catch (SQLException ex) {
            System.out.println("you have entered wrong details");
        }
    }

    public static void studentlogin(Scanner sc,String url,String username,String password) {
        try {
            System.out.println("enter id and password of the student");
            String id = sc.nextLine();
            String pass = sc.nextLine();
            try (Connection con = DriverManager.getConnection(url, username, password)) {
                String choice1;
                do {
                    System.out.println("enter 1 for view details and 2 for logout");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            viewdetails(con, id, pass);
                            break;
                        case 2:
                            System.out.println("Logging out ........");
                            break;
                        default:
                            System.out.println("invalid choice");
                            break;
                    }
                    System.out.println("Do you want to continue?");
                    choice1 = sc.nextLine();

                } while (choice1.equalsIgnoreCase("y"));
            }
        }
        catch (SQLException ex) {
            System.out.println("you have entered wrong details");
        }
    }

    public static void countage(Connection con) {
        try {
            String query = "select age , count(*) as count from student group by age";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("Age count: " + rs.getInt("age") + " :-> " + rs.getInt("count"));
            }
        }
        catch (SQLException ex) {
            System.out.println("you have entered wrong details");
        }
    }

    static void main()   {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/school";
        String username = "root";
        String password = "password";
        String choice2;
        do {
            System.out.println("Enter 1 for admin login and 2 for student login");
            //System.out.println("enter the choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    adminlogin(sc, url, username, password);
                    break;
                case 2:
                    studentlogin(sc, url, username, password);
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;

            }

            System.out.println("do you want to continue?");
            choice2 = sc.nextLine();
        } while (choice2.equalsIgnoreCase("y"));


    }

}
