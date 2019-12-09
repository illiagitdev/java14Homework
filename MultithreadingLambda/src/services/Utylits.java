package task1;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Utylits {
    public static int getInt(){
        Scanner input=new Scanner(System.in);
        return input.hasNextInt()?input.nextInt():getInt();
    }

    public void randomWaitTime(int seconds) {
        Random random = new Random();
        int result = random.nextInt(seconds) + 1;
        try {
            TimeUnit.SECONDS.sleep(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
