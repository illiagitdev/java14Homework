package main.java.task1;

import main.java.services.Utylits;

import java.util.concurrent.Semaphore;

/*
* Все должно выглядеть просто.
*
*  Cам проход через дверь
*
* можно реализовать с помощью второго класса - Door, который мог бы быть инициализирован с помощью конструктора
*
* CyclicBarrier, к примеру. Либо же использовать синфронайзд. И все. 2 класса (в которых по одному методу)
*
* и класс Main с методом main, спрашивающий количество гостей и вместительность. Массив посетителей совершенно не нужен,
*
* ведь посетители - это потоки, которые мы запускаем через Library.start() или run(), в цикле, который, кстати,
*
* можно реализовать через лямбду. Попробуй переделать, я еще раз проверю.
* */
public class Lib implements Runnable{
    private Semaphore semaphore;
    private Visitors[] visitors;

    public Lib() {
        initialize();
    }

    private void initialize() {
        System.out.print("Визначте скільки людей може перебувати в бібліотеці одночасно: ");
        int capacity = Utylits.getInt();
        System.out.print("Визначте скфльки людей хоче відвідати бібліотеку бібліотеці: ");
        int visitorsAmount = Utylits.getInt();
        semaphore=new Semaphore(capacity,true);
        visitors=new Visitors[visitorsAmount];
    }

    @Override
    public void run() {
        System.out.printf("This thread %s",Thread.currentThread().getName());
    }
}
