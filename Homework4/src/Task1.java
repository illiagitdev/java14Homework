import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("Введыть число: ");
        Scanner input =new Scanner(System.in);
        int value= input.nextInt();

        for (int i = 1; i <= value; i++) {
            System.out.println(i);
        }
    }
}
