import java.io.Console;
import java.util.Scanner;

public class Task7 {
    /*
    Написать программу, в которой выполнены все шесть предыдущих заданий. Каждое задание выполняется в отдельной функции.
    В пределах этой же функции происходит ввод с консоли необходимых данных.
    +   Программа спрашивает у пользователя какую задачу он хочет решить (от 1 до 6).
    +----  Затем программа вызывает соответствующую функцию для решения этой задачи.
    +-  По окончанию решения задачи, программа спрашивает пользователя, хочет ли он продолжить решать задачи.
    +   Если да - опять спрашивает какую задачу
     */
    public static void main(String[] args) {
        boolean flag = true;
        do {
                    System.out.print("Яку задачу ви хочете вирішити (1-6):\n" +
                            "1 - Задача#1 ()\n" +
                            "2 - Задача#2 ()\n" +
                            "3 - Задача#3 ()\n" +
                            "4 - Задача#4 ()\n" +
                            "5 - Задача#5 ()\n" +
                            "6 - Задача#6 ()\n" +
                            "№ ");

            Scanner input = new Scanner(System.in);
            int selector = input.nextInt();

            switch (selector) {
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
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
            if (input.next().toLowerCase().equals("y")){
                continue;
            }else {
                flag = false;
            }
        }while (flag);
    }


}
