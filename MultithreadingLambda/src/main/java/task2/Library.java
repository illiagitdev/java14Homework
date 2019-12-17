package main.java.task2;

import main.java.services.Utylits;

import java.util.concurrent.Semaphore;
/*
 Cам проход через дверь можно реализовать с помощью второго класса - Door, который мог бы быть инициализирован с
 помощью конструктора CyclicBarrier, к примеру. Либо же использовать синфронайзд. И все. 2 класса (в которых по одному
 методу) и класс Main с методом main, спрашивающий количество гостей и вместительность.

 */
public class Library {
    public void runLibrary() {
        System.out.print("Визначте скільки людей може перебувати в бібліотеці одночасно: ");
        int capacity = Utylits.getInt();
        Semaphore semaphore = new Semaphore(capacity, true);
        System.out.print("Визначте скфльки людей хоче відвідати бібліотеку бібліотеці: ");
        int visitorsAmount = Utylits.getInt();
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
