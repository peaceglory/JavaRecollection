package concurrency.misc;

public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {
        private int notThreadLocal;
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));

            synchronized (MyRunnable.class) {
                notThreadLocal = (int) (Math.random() * 100D);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(Thread.currentThread().getName() + " | threadLocal: " + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + " | notThreadLocal: " + notThreadLocal);
        }
    }
}
