public class Main {
    public static void main(String[] args) {
        Runnable runnable=new RunClass();

        Thread thread = new Thread("not main");
        thread.start();

        Thread thread1=new Thread(runnable);
        thread1.start();

        threadInfo(thread);
        threadInfo(thread1);
        threadInfo(Thread.currentThread());
    }

    public static void threadInfo(Thread thread) {
        System.out.println(thread.getName());
        System.out.println(thread.getThreadGroup().getName());
    }


}
