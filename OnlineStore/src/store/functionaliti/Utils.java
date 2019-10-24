package store.functionaliti;

import java.util.Scanner;

public class Utils {
    public static void readFile(String path){

    }

    public static int getInt() {
        Scanner scan=new Scanner(System.in);
        int in=scan.hasNextInt()?scan.nextInt():getInt();
        return in;
    }

    public static String getStr() {
        Scanner scan=new Scanner(System.in);
        String in=scan.next();
        return in;
    }
}
