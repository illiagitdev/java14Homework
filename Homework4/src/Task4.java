import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Введіть перше число: ");
        int x=input.nextInt();
        System.out.print("Введіть друге число: ");
        int y=input.nextInt();

        int result=getMax(x,y);
        System.out.println("Максимальне число: "+result);
    }

    private static int getMax(int x, int y) {
        return (x>=y)? x:y;
    }

    private static float getMax(float x, float y) {
        return (x>=y)? x:y;
    }
}
