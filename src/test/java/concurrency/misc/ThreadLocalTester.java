package concurrency.misc;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by mman on 19.05.17.
 */
class ThreadLocalTester {

    @Test
    void threadLocal_UniqueValueForEachThread() throws InterruptedException {
        final ThreadLocalTest tlt = new ThreadLocalTest();


        Thread t1 = new Thread(() -> {
            ThreadLocal<Integer> local = new ThreadLocal<>();
            local.set(1);
            tlt.setThreadLocal(local);
        });

        t1.setName("FIRST");

        int[] finalResult = new int[1];

        Thread t2 = new Thread(() -> {
            ThreadLocal<Integer> local = new ThreadLocal<>();
            local.set(2);
            tlt.setThreadLocal(local);

            try {
                t1.start();
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            finalResult[0] = tlt.getThreadLocal().get();
        });

        t2.setName("SECOND");

        t2.start();
        t2.join();
        assertEquals(2, finalResult[0]);
    }

    @Test
    void notThreadLocal_SharedValueForAllThreads() throws InterruptedException {
        final ThreadLocalTest tlt = new ThreadLocalTest();

        Thread t1 = new Thread(() -> tlt.setNotThreadLocal(1));

        Thread t2 = new Thread();

        t1.start();
        t1.join();
        assertEquals(1, tlt.getNotThreadLocal());

        t2.start();
        t2.join();
        assertEquals(1, tlt.getNotThreadLocal());
    }
}
