package main.java;

import java.util.Scanner;

public class Operation {

    public void getInput() {
        String[] signs = {"+", "-", "*", "/", "%", "==", ">", "<"};
        while (true){double val1 = getNumber();
        double val2 = getNumber();
        String sigh = getSigh(signs);
        System.out.println("Main thread " + Thread.currentThread().getName());
        new Thread(() -> {
            evaluate(val1, val2, sigh);
        }).start();}
    }

    private void evaluate(double val1, double val2, String sigh) {
        switch (sigh) {
            case "+": {
                        System.out.println("a + b = " + (val1 + val2) + "  " + Thread.currentThread().getName());
                break;
            }
            case "-": {
                        System.out.println("a - b = " + (val1 - val2) + "  " + Thread.currentThread().getName());
                break;
            }
            case "*": {
                        System.out.println("a * b = " + (val1 * val2) + "  " + Thread.currentThread().getName());
                break;
            }
            case "/": {
                        System.out.println("a / b = " + (val1 / val2) + "  " + Thread.currentThread().getName());
                break;
            }
            case "%": {
                        System.out.println("a % b = " + (val1 % val2) + "  " + Thread.currentThread().getName());
                break;
            }
            case "==": {
                        System.out.println("a == b = " + (val1 == val2) + "  " + Thread.currentThread().getName());
                break;
            }
            case ">": {
                        System.out.println("a > b = " + (val1 > val2) + "  " + Thread.currentThread().getName());
                break;
            }
            case "<": {
                System.out.println("a < b = " + (val1 < val2) + "  " + Thread.currentThread().getName());
                break;
            }
            default: {
                System.out.println("No such operation!" + "  " + Thread.currentThread().getName());
                break;
            }
        }
    }

    private String getSigh(String[] signs) {
        System.out.println("Виберіть операцію:");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < signs.length; i++)
            System.out.print((i + 1)+"  " + signs[i]+",\t");
        return input.hasNext() ? input.nextLine() : getSigh(signs);
    }

    private double getNumber() {
        System.out.print("Введіть число: ");
        Scanner input = new Scanner(System.in);
        return input.hasNextDouble() ? input.nextDouble() : getNumber();
    }
}
