package main.java.task1;

import main.java.services.Utylits;

import java.util.concurrent.Semaphore;

public class Lib {
    public void runLib() {
        System.out.print("Визначте скільки людей може перебувати в бібліотеці одночасно: ");
        int capacity = Utylits.getPositiveInt();
        Semaphore semaphore = new Semaphore(capacity, true);
        System.out.print("Визначте скфльки людей хоче відвідати бібліотеку бібліотеці: ");
        int visitorsAmount = Utylits.getPositiveInt();
        long startPoint = System.currentTimeMillis();
        for (int i = 0; i < visitorsAmount; i++) {
            new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.printf("Прийшов до входу в бібліотеку. %s %s\n", threadName, System.currentTimeMillis() - startPoint);
                try {
                    semaphore.acquire();
                    System.out.printf("Зайшов у бібліотеку. %s %s\n", threadName, System.currentTimeMillis() - startPoint);
                    int reads = Utylits.randomWaitTime(5);
                    System.out.printf("Читає книгу (%s ms). %s \n", reads, threadName);
                    System.out.printf("Відвідувач вийшов з бібліотеки. %s %s\n", threadName, System.currentTimeMillis() - startPoint);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
