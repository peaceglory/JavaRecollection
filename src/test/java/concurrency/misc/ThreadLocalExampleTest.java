package concurrency.misc;

import org.junit.Test;

/**
 * Created by mman on 19.05.17.
 */
public class ThreadLocalExampleTest {

    @Test
    public void testThreadLocal() {
        ThreadLocalExample.MyRunnable sharedRunnableInstance = new ThreadLocalExample.MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // wait for thread 1 to terminate
            thread2.join(); // wait for thread 2 to terminate
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
