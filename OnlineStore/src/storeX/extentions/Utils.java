package storeX.extentions;

import java.util.Scanner;

public class Utils {
    public static String getStr(){
        Scanner input=new Scanner(System.in);
        return input.next();
    }

    public static String getStrLine(){
        Scanner input=new Scanner(System.in);
        return input.nextLine();
    }

    public static int getInt() {
        Scanner input=new Scanner(System.in);
        return input.hasNextInt()?input.nextInt():getInt();
    }

    public static float getFloat() {
        Scanner input=new Scanner(System.in);
        return input.hasNextFloat()?input.nextFloat():getFloat();
    }

}
