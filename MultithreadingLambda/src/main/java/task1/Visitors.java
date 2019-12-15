package main.java.task1;

import main.java.services.Utylits;

import java.util.concurrent.Semaphore;

public class Visitors implements Runnable {
    private int id;
    private static Semaphore semaphore;
    private static long now = System.currentTimeMillis();

    public Visitors(int id) {
        this.id = id;
    }

    public static void setSemaphore(Semaphore semaphore) {
        Visitors.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.printf("Прийшов до входу в бібліотеку. Відвідувач № %d %s\n", id, System.currentTimeMillis() - now);
        try {
            if (semaphore.availablePermits() == 0) {
                System.out.printf("Очікує входу в бібліотеку. Відвідувач № %d %s\n", id, System.currentTimeMillis() - now);
            }
            semaphore.acquire();
            System.out.printf("Зайшов у бібліотеку. Відвідувач № %d %s\n", id, System.currentTimeMillis() - now);
            System.out.printf("Читає книгу. Відвідувач № %d %s\n", id, System.currentTimeMillis() - now);
            Utylits.randomWaitTime(5);
            semaphore.release();
            System.out.printf("Відвідувач вийшов з бібліотеки. Відвідувач № %d %s\n", id, System.currentTimeMillis() - now);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
