package tests.misc;

/**
 * Created by mman on 30.11.16.
 */
public class AutoCloseableResource implements  AutoCloseable {
    private String name;

    public AutoCloseableResource(String name) {
        this.name = name;
    }

    @Override
    public void close() throws Exception {
        System.out.println(name);
    }

    public static void main(String[] args) throws Exception {
        try (AutoCloseableResource r1 = new AutoCloseableResource("One");
             AutoCloseableResource r2 = new AutoCloseableResource("Two");) {
        } finally {
            System.out.println("Three");
        }
    }
}
