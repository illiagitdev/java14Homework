package main.java.task2;

import main.java.services.Utylits;

public class PassDoor {
    public void enterLibrary(double passDor) {
        synchronized (this) {
            System.out.printf("Відвідувач підійшов до дверей ззовні.%s\n", Thread.currentThread().getName());
            System.out.printf("Відвідувач проходить крізь двері всередину. %s\n", Thread.currentThread().getName());
            Utylits.waitTime(passDor);
            System.out.printf("Відвідувач пройшов крізь двері всередини. %s\n", Thread.currentThread().getName());
        }
    }

    public void exitLibrary(double passDor) {
        synchronized (this) {
            System.out.printf("Відвідувач підійшов до дверей зсередини. %s\n", Thread.currentThread().getName());
            System.out.printf("Відвідувач проходить крізь двері назовні. %s\n", Thread.currentThread().getName());
            Utylits.waitTime(passDor);
            System.out.printf("Відвідувач пройшов крізь двері назовні. %s\n", Thread.currentThread().getName());
       }
    }
}
