import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        boolean flag = true;
        do {
            System.out.print("Яку задачу ви хочете вирішити (1-6):\n" +
                    "1 - Задача#1 (Перечислення від 1 до введеного Х)\n" +
                    "2 - Задача#2 (Рисує прямокутник з символів)\n" +
                    "3 - Задача#3 (Рисує квадрат з символів/Задача#2)\n" +
                    "4 - Задача#4 (Виводить максимальне з двох чисел (int, float))\n" +
                    "5 - Задача#5 (Задача#1 чурез рекурсію)\n" +
                    "6 - Задача#6 (Задача#2 чурез рекурсію)\n" +
                    "№ ");

            Scanner input = new Scanner(System.in);
            int selector = input.nextInt();

            switch (selector) {
                case 1: {
                    doTask1();
                    break;
                }
                case 2:
                case 3: {
                    doTask2();
                    break;
                }
                case 4: {
                    doTask4();
                    break;
                }
                case 5: {
                    doTask5();
                    break;
                }
                case 6: {
                    break;
                }
                default: {
                    System.out.println("Might be typo, try again.");
                    break;
                }
            }

            System.out.println("Продовжити розв'язувати задачі? (y/n)");
            if (input.next().toLowerCase().equals("y")) {
                System.out.flush();
            } else {
                flag = false;
            }
        } while (flag);
    }

    private static void doTask4() {//todo:nnnnn
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

    /**
     * Draws square or rectangle by choice
     */
    private static void doTask2() {
        int height;
        int width;
        int type;
        boolean flag = true;

        System.out.print("Яку фігуру малювати?\n" +
                "1 - прямокутник\n" +
                "2 - квадрат\n# ");
        type = getIntInput();
        while (flag) {
            if (type == 1) {
                System.out.print("Введіть висоту: ");
                height = getIntInput();
                System.out.print("Введіть ширину: ");
                width = getIntInput();
                drawRectangle(height, width);
                flag = false;
            }
            if (type == 2) {
                System.out.print("Введіть висоту: ");
                height = getIntInput();
                drawRectangle(height);
                flag = false;
            }
        }
    }

    /**
     * Draws square with side H
     */
    private static void drawRectangle(int h) {
        drawRectangle(h, h);
    }

    /**
     * draws rectangle with width W and heights H
     */
    private static void drawRectangle(int h, int w) {
        char filling = 43;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(filling);
            }
            System.out.println();
        }
    }

    /**
     * counts numbers with recursion
     */
    private static void doTask5() {
        System.out.print("Введіть число: ");
        int value = getIntInput();
        printValue(value);
    }

    //  function for Task5 through recursion
    private static void printValue(int value) {
        if (value == 1) {
            System.out.println(value);
        } else {
            printValue(value - 1);
            System.out.println(value);
        }
    }

    /**
     * Counts numbers in loop
     */
    private static void doTask1() {
        System.out.print("Введіть число: ");
        int value = getIntInput();
        for (int i = 1; i <= value; i++) {
            System.out.println(i);
        }
    }

    /**
     * returns int with check for correct input
     */
    private static int getIntInput() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            if (input.hasNextInt()) {
                flag = false;
            } else {
                System.out.print("\nRepeat input: ");
                input.next();
            }
        }
        return input.nextInt();
    }
}
