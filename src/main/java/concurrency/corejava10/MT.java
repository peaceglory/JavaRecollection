package concurrency.corejava10;

/**
 * Created by mman on 01.02.17.
 */
public class MT extends Thread {
    private final Object monitor = new Object();
    private volatile boolean flag = true;

    public class Ha {

    }

    @Override
    public void run() {
        System.out.println("Running " + getName());
        try {
            synchronized (monitor) {
                while (flag) {
                    monitor.wait();
                }
                System.out.println("hahah");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": I was interrupted!");
        }
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MT();
        t.setName("Miro");
        t.start();
        System.out.println("Running " + Thread.currentThread().getName());
        Thread.sleep(20000);
        t.interrupt();
    }
}
