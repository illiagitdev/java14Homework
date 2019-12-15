package main.java.task2;

import main.java.services.Utylits;

public class PassDoor {
    public void enterLibrary(double passDor) {
        synchronized (this) {
            System.out.printf("Відвідувач підійшов до дверей ззовні. %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
            System.out.printf("Відвідувач проходить крізь двері всередину. %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
            Utylits.waitTime(passDor);
            System.out.printf("Відвідувач пройшов крізь двері всередину. %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
        }
    }

    public void exitLibrary(double passDor) {
        synchronized (this) {
            System.out.printf("Відвідувач підійшов до дверей зсередини. %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
            System.out.printf("Відвідувач проходить крізь двері назовні. %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
            Utylits.waitTime(passDor);
            System.out.printf("Відвідувач пройшов крізь двері назовні. %d %s\n", Thread.currentThread().getId(), Thread.currentThread().getName());
       }
    }
}
