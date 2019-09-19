import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        System.out.print("Введіть число: ");
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();

        printValue(value);
    }

    //  first variation
    private static void printValue(int value) {
            if(value==1){
                System.out.println(value);
            }else {
                printValue(value-1);
                System.out.println(value);
            }
    }
}
