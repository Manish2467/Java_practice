import java.lang.Exception;
import java.net.ConnectException;
import java.sql.*   ;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Database {

    public static int choice(Scanner sc, String select){
        while(true) {
            System.out.println(select);
            try {
                int num = sc.nextInt();
                sc.nextLine();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Please provide number as input . Thank you!!!");
                sc.nextLine();
            }
        }
    }

    public static void fetch(Connection con) throws SQLException{
        String sql = "select * from user order by id desc";
        try( Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");  //database ko column ko name same hunu parxa

                System.out.println("ID: "+id+" Name: " + name + " Age: " + age);
            }

        }
    }

    public static void add(Connection con) throws SQLException{
        Scanner sc = new Scanner(System.in);
        //System.out.println("enter id:");
        //int id = sc.nextInt();
        //sc.nextLine();
        System.out.println("enter the name:");
        String name = sc.nextLine();
        System.out.println("Enter age ");
        int age = sc.nextInt();

        String insert = "insert into user (name,age) values (?,?)";
        try(PreparedStatement pstm = con.prepareStatement(insert)){
            //pstm.setInt(1,id);
            pstm.setString(1,name);
            pstm.setInt(2,age);
                                                                    //sql injection statement ma herne
                                                                // delete thapnu paro, update
             pstm.executeUpdate();
            System.out.println( " rows added successfully");
        }
    }

    public static void update(Connection con, Scanner sc) throws SQLException{
        System.out.println("enter user id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("enter user name");
        String name = sc.nextLine();
        System.out.println("enter user age");
        int age = sc.nextInt();
        String prompt = "update user set name = ?,age = ? where id = ?";
        try(PreparedStatement pstm = con.prepareStatement(prompt)){
            pstm.setString(1,name);
            pstm.setInt(2,age);
            pstm.setInt(3,id);
            pstm.executeUpdate();
            System.out.println("value updated successfully");
        }
        sc.nextLine();
    }

    public static void delete(Connection con, Scanner sc) throws  SQLException{
        System.out.println("enter the id of the user you want to delete: ");
        int id = sc.nextInt();
        String prompt = "delete from user where id = ?";
        try(PreparedStatement pstm = con.prepareStatement(prompt)){
            pstm.setInt(1,id);
            pstm.executeUpdate();
        }
        System.out.println("user deleted successfully");
        sc.nextLine();
    }


   /* public static String conti(Scanner sc,String prompt) {
        while(true) {
            System.out.println(prompt);
            String input = sc.nextLine();
            if (!input.isEmpty()) {
                try {
                    if(isNumeric(input)){
                        System.out.println("you cannot enter numeric value");
                    }
                    else{
                        return input;
                    }
                }
                catch (InputMismatchException e){
                    System.out.println("the error encountered " +e.getMessage());
                }
            } else {
                System.out.println("you cannot leave this empty");
            }
        }
    } */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        String url = "jdbc:mysql://localhost:3306/java_practice";
        String username = "root";
        String password = "Manish@12";
        String choose;


        try(Connection con = DriverManager.getConnection(url, username, password);) {


            do {

                int num = choice(sc, "enter 1 for adding ,2 for displaying, 3 for update and 4 for delete");


                switch (num) {
                    case 1:
                        add(con);
                        break;
                    case 2:
                        fetch(con);
                        break;
                    case 3:
                        update(con,sc);
                        break;
                    case 4:
                        delete(con,sc);
                        break;                          // user ko name number halda ni teslai string samjinxa,,  do you want to continue ma validation
                    default:
                        System.out.println("you have entered wrong choice");
                        break;
                }


                //choose = conti(sc, "do you want to continue?(yes/no)");
                System.out.println("do you want to continue?");
                choose = sc.nextLine();



            } while (choose.equalsIgnoreCase("y"));
            System.out.println("exiting");
        }                                                                   // a halda error ayo
        catch(SQLException e){
            System.out.println("eroor occurred"+e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("please provide valid details ");
        }

    }
}


// collection framework
// file


// excel bata read garera database ma halnu paro (name,rollno , email, password, class, school name) excel ma hunxa
// user table ra students details table login (email bata password handa ** aunu paro)


//lambda expression
// java stream


// class list