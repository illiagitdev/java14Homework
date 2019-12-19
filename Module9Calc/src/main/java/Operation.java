package main.java;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Operation {

    public void run() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        String[] signs = {"+", "-", "*", "/", "%", "==", ">", "<"};
        Callable<Object> task = () -> evaluate(getNumber(), getNumber(), getSigh(signs));

        //todo: FutureCallable<> futureCallable;
        Future future = executor.submit(task);
        try {
            if (!future.isDone()){
                executor.shutdownNow();
            }
            System.out.println(future.get() + " {returns in " + Thread.currentThread().getName() + '}');
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private Object evaluate(double val1, double val2, String sigh) {
        String result = " {calculate in " + Thread.currentThread().getName() + '}';
        switch (sigh) {
            case "+":
                return "a + b = " + (val1 + val2) + result;
            case "-":
                return "a - b = " + (val1 - val2) + result;
            case "*":
                return "a * b = " + (val1 * val2) + result;
            case "/":
                return "a / b = " + (val1 / val2) + result;
            case "%":
                return "a % b = " + (val1 % val2) + result;
            case "==":
                return "a == b = " + (val1 == val2) + result;
            case ">":
                return "a > b = " + (val1 > val2) + result;
            case "<":
                return "a < b = " + (val1 < val2) + result;
        }
        return -1;
    }

    private String getSigh(String[] signs) {
        System.out.println("Виберіть операцію:");
        Scanner input = new Scanner(System.in);
        IntStream.range(0, signs.length).mapToObj(i -> (i + 1) + ":  " + signs[i] + ",\t").forEach(System.out::print);
        return input.hasNext() ? input.nextLine() : getSigh(signs);
    }

    private double getNumber() {
        System.out.print("Введіть число: ");
        Scanner input = new Scanner(System.in);
        return input.hasNextDouble() ? input.nextDouble() : getNumber();
    }
}
