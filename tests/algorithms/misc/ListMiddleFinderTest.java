package tests.algorithms.misc;

import groovy.util.GroovyTestCase;
import sources.algorithms.misc.ListMiddleFinder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mman on 30.12.16.
 */
public class ListMiddleFinderTest extends GroovyTestCase {

    public void testFindMiddleInOnePassForArrayList() {
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

    public void testFindMiddleInOnePassForLinkedList() {
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
