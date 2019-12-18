package main.java.services;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Utylits {
    public static int getPositiveInt() {
        int result = 0;
        Scanner input = new Scanner(System.in);
        result = input.hasNextInt() ? input.nextInt() : getPositiveInt();
        if(result < 0) {
            System.out.print("Value >= 0, enter again: ");
            return getPositiveInt();
        }
        return result;
    }

    public static int randomWaitTime(int seconds) {
        Random random = new Random();
        int result = (int) (random.nextDouble() * seconds * 1000);
        try {
            TimeUnit.MILLISECONDS.sleep(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void waitTime(double passDor) {
        try {
            TimeUnit.MILLISECONDS.sleep((long) (passDor * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
