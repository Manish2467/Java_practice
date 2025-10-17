public class Exception {
    public static void main(String[] args) {
        try{
            int num = Integer.parseInt("manish");
        }
        catch (NumberFormatException a){
            System.out.println("you have encountered an exception");
        }
        finally{
            System.out.println("hello this is the finally ");
        }
    }
}  