package tests.misc;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mman on 30.11.16.
 */
public class GenericsAndCollectionsTests {

    public static void testOne() {
        Collection<String> col = new ArrayList<>();
        col.add("One");
        col.add("Two");
        col.add("Three");
        System.out.println(col);

        col.remove(0);
        System.out.println(col);

        assert "[One, Two, Three]".equals(col.toString());
    }

    public static void main(String[] args) {
        testOne();
    }
}
