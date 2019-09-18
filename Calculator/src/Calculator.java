import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int numberD;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        numberD = input.nextInt();

        System.out.println("\n" + "Binary number: " + convertString(numberD, 2) +
                "\nOctal number: " + convertString(numberD, 8) +
                "\nHexadecimal number: " + convertString(numberD, 16));
    }

    static final char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static public String convertString(int value, int base) {
        String result = "";
        int x;
        while (value > 0) {
            x = value % base;
            result = hexa[x] + result;
            value /= base;
        }
        switch (base) {
            case 2: {
                result = "0b" + result;
                break;
            }
            case 8: {
                result = "0" + result;
                break;
            }
            case 16: {
                result = "0x" + result;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}
