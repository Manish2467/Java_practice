import java.io.*;
import java.sql.*   ;
import java.util.InputMismatchException;
import java.util.Scanner;


// **docker desktop halera check garne

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
        String sql = "select * from student order by id desc";
        try( Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");  //database ko column ko name same hunu parxa

                System.out.println("ID: "+id+" Name: " + first_name + " last name: " + last_name);
            }

        }
    }


    // aggregate functions, get user details by id , ternary operator


    public static void add(Connection con) throws SQLException{
        Scanner sc = new Scanner(System.in);
        //System.out.println("enter id:");
        //int id = sc.nextInt();
        //sc.nextLine();
        System.out.println("enter the name:");
        String first_name = sc.nextLine();
        System.out.println("Enter last name: ");
        String last_name = sc.nextLine();
        System.out.println("enter the id:");
        int id = sc.nextInt();

        String insert = "insert into student (first_name,last_name,id) values (?,?,?)";
        try(PreparedStatement pstm = con.prepareStatement(insert)){
            //pstm.setInt(1,id);
            pstm.setString(1,first_name);
            pstm.setString(2,last_name);
            pstm.setInt(3,id);
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
        String first_name = sc.nextLine();
        System.out.println("enter user last_name");
        String last_name = sc.nextLine();
        String prompt = "update student set first_name = ?,last_name = ? where id = ?";
        try(PreparedStatement pstm = con.prepareStatement(prompt)){
            pstm.setString(1,first_name);
            pstm.setString(2,last_name);
            pstm.setInt(3,id);
            pstm.executeUpdate();
            System.out.println("value updated successfully");
        }
        sc.nextLine();
    }

    public static void delete(Connection con, Scanner sc) throws  SQLException{
        System.out.println("enter the id of the user you want to delete: ");
        int id = sc.nextInt();
        String prompt = "delete from student where id = ?";
        try(PreparedStatement pstm = con.prepareStatement(prompt)){
            pstm.setInt(1,id);
            pstm.executeUpdate();
        }
        System.out.println("user deleted successfully");
        sc.nextLine();
    }

    public static void Csvwriter(Connection con, Scanner sc) throws SQLException, IOException {
        String file = "data.csv";
        String query = "insert into student (first_name,last_name,id) values (?,?,?)";
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(file)); PreparedStatement ps = con.prepareStatement(query)){
            //line = br.readLine();
            while((line = br.readLine())!=null){
                String[] values = line.split(",");
                ps.setString(1,values[0]);
                ps.setString(2,values[1]);
                ps.setInt(3,Integer.parseInt(values[2]));

                ps.addBatch();
            }
            ps.executeBatch();
            System.out.println("CSV data successfully inserted into database.");
        }



    }

    public static void Csvinsert(Connection con, Scanner sc) throws SQLException, IOException {
        String file = "data.csv";


        try(FileWriter fw = new FileWriter(file,true)){
            System.out.println("enter the number of student you want to insert: ");
            int no = sc.nextInt();
            sc.nextLine();
            for(int i=0;i<no;i++){
                System.out.println("enter student first name: ");
                String fname = sc.nextLine();
                System.out.println("enter student last name: ");
                String lname = sc.nextLine();
                System.out.println("enter student id: ");
                int iid = sc.nextInt();
                sc.nextLine();

                fw.append(fname).append(",").append(lname).append(",").append(Integer.toString(iid)).append("\n");
            }
            System.out.println("csv updated successfully");
        }
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


        String url = "jdbc:mysql://localhost:3306/myDB";
        String username = "root";
        String password = "password";
        String choose;


        try(Connection con = DriverManager.getConnection(url, username, password);) {


            do {

                int num = choice(sc, "enter 1 for adding ,2 for displaying, 3 for update ,4 for delete , 5 for csv import and 6 for csv entry");


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
                        break;// user ko name number halda ni teslai string samjinxa,,  do you want to continue ma validation
                    case 5:
                        Csvwriter(con,sc);
                        break;
                    case 6:
                        Csvinsert(con,sc);
                        break;
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
        catch(IOException e){
            System.out.println("IO error occured");
        }

    }
}


// collection framework
// file


// excel bata read garera database ma halnu paro (name,rollno , email, password, class, school name) excel ma hunxa
// user table ra students details table login (email bata password handa ** aunu paro)
//database ko data export to excel

//lambda expression
// java stream


// class list