package store.functionaliti;


import java.util.Scanner;

public class Utils {
    public static int getInt() {
        Scanner scan=new Scanner(System.in);
        return   scan.hasNextInt()?scan.nextInt():getInt();
    }

    public static String getStr() {
        Scanner scan=new Scanner(System.in);
        return scan.next();
    }
}
