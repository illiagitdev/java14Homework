package task2;

import services.Utylits;

import java.util.concurrent.Semaphore;

public class Visitors implements Runnable {
    /*
    Каждый поток должен писать в консоль что он(человек) делает.
    - пришел ко входу в библиотеку
    - ждет входа в библиотеку (происходит только если нет места на момент прихода
    к библиотеке)
    - вошел в библиотеку
    - читает книгу (поток должен делать это действие рандомное кол-во времени от 1
    до 5 секунд)
    - вышел из библиотеки
     */
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
            PassDoor.enterLibrary(0.5);
            System.out.printf("Зайшов у бібліотеку. Відвідувач № %d %s\n", id, System.currentTimeMillis() - now);
            System.out.printf("Читає книгу. Відвідувач № %d %s\n", id, System.currentTimeMillis() - now);
            Utylits.randomWaitTime(5);
            PassDoor.exitLibrary(0.5);
            semaphore.release();
            System.out.printf("Відвідувач вийшов з бібліотеки. Відвідувач № %d %s\n", id, System.currentTimeMillis() - now);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
