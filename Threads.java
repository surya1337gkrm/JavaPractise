
class Thread1 extends Thread {

    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        for (int i = 0; i < 5; i++) {
            System.out.println("In Thread 1. Iteration: " + i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        // System.out.println(Thread.currentThread());
        for (int i = 0; i < 5; i++) {
            System.out.println("In Thread 2. Iteration: " + i);
        }
        // System.out.println("In Thread 2.");
    }
}

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        // System.out.println(Thread.currentThread());
        // System.out.println(Thread.currentThread().getName());

        System.out.println("Main");

        Thread1 t1 = new Thread1("Thread-One");
        // Thread2 t2 = new Thread2();
        // t2.setPriority(10);
        t1.setDaemon(true);
        t1.start();
        // t1.join();
        // t2.start();
        System.out.println("End");
    }
}
