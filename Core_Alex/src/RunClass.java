public class RunClass implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "runnable from class");
    }
}
