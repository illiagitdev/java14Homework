package task1;

import java.sql.Time;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

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
            System.out.printf("Зайшов у бібліотеку. Відвідувач № %d %s\n", id, System.currentTimeMillis() - now);
            System.out.printf("Читає книгу. Відвідувач № %d %s\n", id, System.currentTimeMillis() - now);
            reading();
            semaphore.release();
            System.out.printf("Відвідувач вийшов з бібліотеки. Відвідувач № %d %s\n", id, System.currentTimeMillis() - now);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void reading() {
        Random random = new Random();
        int result = random.nextInt(5) + 1;
        try {
            TimeUnit.SECONDS.sleep(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
