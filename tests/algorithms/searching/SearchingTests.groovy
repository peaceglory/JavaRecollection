package tests.algorithms.searching

import sources.algorithms.searching.Searcher
import sources.algorithms.sorting.QuickSorter
import sources.algorithms.sorting.Sorter
import sources.utils.StopWatch
import sources.utils.ObjectUtils

/**
 * Created by mman on 13.12.16.
 */
class SearchingTests extends GroovyTestCase {
    private static final int SIZE = 1000000;

    void testLinearSearch() {
        Integer[] a = ObjectUtils.createRandomIntegerArray(SIZE);
        ObjectUtils.printArray(a);
        int key = 108;
        StopWatch timer = new StopWatch();
        timer.start();
        int found = Searcher.linearSearch(a, key);
        timer.stop();
        println "Found: " + found + " --- " + timer.getResult();
    }

    void testBinarySearchIter() {
        Integer[] a = ObjectUtils.createRandomIntegerArray(SIZE);

        Sorter<Integer> sorter = new QuickSorter<>();
        sorter.sort(a);
        ObjectUtils.printArray(a);

        StopWatch timer = new StopWatch();
        int key = 108; // Set value in debug mode if input is random.
        timer.start();
        int found = Searcher.binarySearchIter(a, key);
        timer.stop();
        println "--------------------------------------------------"
        println "Found: " + found + " --- " + timer.getResult();
    }

    void testBinarySearchRecur() {
        Integer[] a = ObjectUtils.createRandomIntegerArray(SIZE);

        Sorter<Integer> sorter = new QuickSorter<>();
        sorter.sort(a);
        ObjectUtils.printArray(a);

        StopWatch timer = new StopWatch();
        int key = 108; // Set value in debug mode if input is random.
        timer.start();
        int found = Searcher.binarySearchRecur(a, 0, a.length - 1, key);
        timer.stop();
        println "--------------------------------------------------"
        println "Found: " + found + " --- " + timer.getResult();
    }
}
