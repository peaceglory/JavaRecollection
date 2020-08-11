package algorithms.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Created by mman on 30.12.16.
 */
class ListMiddleFinderTest {

    @Test
    void testFindMiddleInOnePassForArrayList() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");

        System.out.printf("Middle: %s", ListMiddleFinder.findMiddleInOnePass(list));
    }

    @Test
    void testFindMiddleInOnePassForLinkedList() {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");

        System.out.printf("Middle: %s", ListMiddleFinder.findMiddleInOnePass(list));
    }
}
