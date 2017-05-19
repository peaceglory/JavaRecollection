package concurrency.misc;

/**
 * Created by mman on 19.05.17.
 */
public class ThreadLocalTest {
    private int notThreadLocal;
    private ThreadLocal<Integer> threadLocal;

    public ThreadLocalTest() {

    }

    public int getNotThreadLocal() {
        return notThreadLocal;
    }

    public void setNotThreadLocal(int notThreadLocal) {
        this.notThreadLocal = notThreadLocal;
    }

    public ThreadLocal<Integer> getThreadLocal() {
        return threadLocal;
    }

    public void setThreadLocal(ThreadLocal<Integer> threadLocal) {
        this.threadLocal = threadLocal;
    }
}
