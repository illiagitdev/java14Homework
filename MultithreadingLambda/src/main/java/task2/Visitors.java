package main.java.task2;

import main.java.services.Utylits;

import java.util.concurrent.Semaphore;

public class Visitors implements Runnable {
    private int id;
    private static Semaphore semaphore;
    private static long now = System.currentTimeMillis();

    public Visitors() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setSemaphore(Semaphore semaphore) {
        Visitors.semaphore = semaphore;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Відвідувач " + id);
        System.out.printf("Прийшов до входу в бібліотеку. %s {%s ms}\n", Thread.currentThread().getName(), System.currentTimeMillis() - now);
        try {
            if (semaphore.availablePermits() == 0) {
                System.out.printf("Очікує входу в бібліотеку. %s {%s ms}\n", Thread.currentThread().getName(), System.currentTimeMillis() - now);
            }
            semaphore.acquire();
            (new PassDoor()).enterLibrary(0.5);
            System.out.printf("Зайшов у бібліотеку. %s {%s ms}\n", Thread.currentThread().getName(), System.currentTimeMillis() - now);
            System.out.printf("Читає книгу. %s {%s ms}\n", Thread.currentThread().getName(), System.currentTimeMillis() - now);
            Utylits.randomWaitTime(5);
            (new PassDoor()).exitLibrary(0.5);
            semaphore.release();
            System.out.printf("Відвідувач вийшов з бібліотеки. %s {%s ms}\n", Thread.currentThread().getName(), System.currentTimeMillis() - now);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
