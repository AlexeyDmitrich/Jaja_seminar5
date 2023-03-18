import java.util.Scanner;

public class input {
    static Scanner input = new Scanner(System.in);
    public static int Int(String usersText){
        System.out.println(usersText);
        int value = input.nextInt();
        return value;
    }
    public static String Str(String usersText){
        System.out.println(usersText);
        String value = input.next();
        return value;
    }

    public static double Double(String usersText) {
        System.out.println(usersText);
        double value = java.lang.Double.parseDouble(input.next());
        return value;
    }

}