package collections;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by mman on 19.05.17.
 */
public class LinkedListTester {
    private List<String> testList;

    @Before
    public void setUp() {
        testList = new LinkedList<>();
        testList.add("One");
        testList.add("Two");
        testList.add("Three");
        testList.add("Four");
        testList.add("Five");
    }

    @Test
    public void testLinkedListIterator() {
        ListIterator<String> liter = testList.listIterator();
        for (int i = 0; i < 3; i++) {
            liter.next();
        }
        liter.add("Before Four");
        liter.add("Before Four2");

        Assert.assertEquals("[One, Two, Three, Before Four, Before Four2, Four, Five]", testList.toString());
    }

    @After
    public void cleanUp() {
        testList.clear();
        testList = null;
    }
}
