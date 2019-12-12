package main.java.task2;

import main.java.services.Utylits;

import java.util.concurrent.Semaphore;

public class Library {
    private static Library library = null;
    private Visitors[] visitors;
    private static int visitorsAmount;
    private static Semaphore semaphore;

    private Library() {}

    public static Library getInstance() {
        if (library == null) {
            return library = new Library();
        }
        return library;
    }

    public void run() {
        initialize();
        Visitors.setSemaphore(semaphore);
        boolean stopCondition = true;
        for (int i = 0; i < visitorsAmount; i++) {
            visitors[i]=new Visitors(i);
        new Thread(visitors[i]).start();
        }
//        while (stopCondition) {
//
//        }
    }

    private void initialize() {
        System.out.print("Визначте скільки людей може перебувати в бібліотеці одночасно: ");
        int capacity = Utylits.getInt();
        System.out.print("Визначте скфльки людей хоче відвідати бібліотеку бібліотеці: ");
        visitorsAmount = Utylits.getInt();
        visitors=new Visitors[visitorsAmount];
        semaphore = new Semaphore(capacity);
    }
}
