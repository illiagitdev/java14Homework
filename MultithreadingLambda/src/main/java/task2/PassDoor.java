package main.java.task2;

import main.java.services.Utylits;

public class PassDoor {
    public static void enterLibrary(double passDor) {
        System.out.printf("Відвідувач підійшов до дверей ззовні. Відвідувач № %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
        System.out.printf("Відвідувач проходить крізь двері всередину. Відвідувач № %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
        Utylits.waitTime(passDor);
        System.out.printf("Відвідувач пройшов крізо двері всередину. Відвідувач № %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
    }

    public static void exitLibrary(double passDor) {
        System.out.printf("Відвідувач підійшов до дверей зсередини. Відвідувач № %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
        Lock
        System.out.printf("Відвідувач проходить крізь двері назовні. Відвідувач № %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
        Utylits.waitTime(passDor);
        System.out.printf("Відвідувач пройшов крізо двері назовні. Відвідувач № %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
    }

}