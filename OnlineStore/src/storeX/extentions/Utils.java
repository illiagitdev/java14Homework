package storeX.extentions;

import java.util.Scanner;

public class Utils {
    private static Scanner input=new Scanner(System.in);

    public static String getStr(){
        return input.nextLine();
    }

    public static int getInt() {
        return input.hasNextInt()?input.nextInt():getInt();
    }
}
