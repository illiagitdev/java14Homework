package main.java.task2;

import main.java.services.Utylits;

import java.util.concurrent.Semaphore;

public class LibraryDoor {
    private static LibraryDoor library = null;
    private Visitors[] visitors;
    private static int visitorsAmount;
    private static Semaphore semaphoreCapacity;

    private LibraryDoor() {
        initialize();
    }

    public static LibraryDoor getInstance() {
        if (library == null) {
            return library = new LibraryDoor();
        }
        return library;
    }

    public void run() {
        Visitors.setSemaphore(semaphoreCapacity);
        for (int i = 0; i < visitorsAmount; i++) {
            visitors[i] = new Visitors();
            visitors[i].setId(i);
            new Thread(visitors[i]).start();
        }
    }

    private void initialize() {
        System.out.print("Визначте скільки людей може перебувати в бібліотеці одночасно: ");
        int capacity = Utylits.getPositiveInt();
        semaphoreCapacity = new Semaphore(capacity);
        System.out.print("Визначте скфльки людей хоче відвідати бібліотеку бібліотеці: ");
        visitorsAmount = Utylits.getPositiveInt();
        visitors = new Visitors[visitorsAmount];
    }
}
