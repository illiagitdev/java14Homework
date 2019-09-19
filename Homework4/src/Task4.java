import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int x = 5;
        int y = 12;
        getMax(x, y);

        float a = 12.32f;
        float b = 54.345f;
        getMax(a, b);
    }

    /**
     * returns max of two int values
     */
    private static void getMax(int x, int y) {
        int result = (x >= y) ? x : y;
        System.out.println("Максимальне число з '" + x + "' '" + y + "' :" + result);
    }

    /**
     * returns max of two float values
     */
    private static void getMax(float x, float y) {
        float result = (x >= y) ? x : y;
        System.out.println("Максимальне число з '" + x + "' '" + y + "' :" + result);
    }
}
