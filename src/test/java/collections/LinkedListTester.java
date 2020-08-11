package collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by mman on 19.05.17.
 */
class LinkedListTester {
    private List<String> testList;

    @BeforeEach
    void setUp() {
        testList = new LinkedList<>();
        testList.add("One");
        testList.add("Two");
        testList.add("Three");
        testList.add("Four");
        testList.add("Five");
    }

    @AfterEach
    void tearDown() {
        testList.clear();
        testList = null;
    }

    @Test
    void testLinkedListIterator() {
        ListIterator<String> liter = testList.listIterator();
        for (int i = 0; i < 3; i++) {
            liter.next();
        }
        liter.add("Before Four");
        liter.add("Before Four2");

        assertEquals("[One, Two, Three, Before Four, Before Four2, Four, Five]", testList.toString());
    }
}
