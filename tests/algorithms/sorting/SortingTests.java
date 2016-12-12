package tests.algorithms.sorting;

import groovy.util.GroovyTestCase;
import sources.algorithms.sorting.*;
import sources.utils.StopWatch;
import sources.utils.Utils;

import java.util.Comparator;

/**
 * Created by mman on 09.12.16.
 */
public class SortingTests extends GroovyTestCase {
    private static final int SIZE = 4;

    public void testSelectionSort() {
        testSortingIntegers(SIZE, new InsertionSorter<Integer>(), null);

//        testSortingStrings(SIZE, new InsertionSorter<String>(), null);

//        testSortingStrings(SIZE, new InsertionSorter<String>(), (str1, str2) -> {
//            if (str1.length() < str2.length()) {
//                return -1;
//            }
//            if (str1.length() > str2.length()) {
//                return 1;
//            }
//            return 0;
//        });
    }

    public void testInsertionSort() {
        testSortingIntegers(SIZE, new InsertionSorter<Integer>(), null);

//        testSortingStrings(SIZE, new InsertionSorter<String>(), null);

//        testSortingStrings(SIZE, new InsertionSorter<String>(), (str1, str2) -> {
//            if (str1.length() < str2.length()) {
//                return -1;
//            }
//            if (str1.length() > str2.length()) {
//                return 1;
//            }
//            return 0;
//        });
    }

    public void testBubbleSort() {
        testSortingIntegers(SIZE, new BubbleSorter<Integer>(), null);

//        testSortingStrings(SIZE, new BubbleSorter<String>(), null);

//        testSortingStrings(SIZE, new BubbleSorter<String>(), (str1, str2) -> {
//            if (str1.length() < str2.length()) {
//                return -1;
//            }
//            if (str1.length() > str2.length()) {
//                return 1;
//            }
//            return 0;
//        });
    }

    public void testMergeSort() {
        testSortingIntegers(SIZE, new MergeSorter<Integer>(), null);

//        testSortingStrings(SIZE, new MergeSorter<String>(), null);

//        testSortingStrings(SIZE, new MergeSorter<String>(), (str1, str2) -> {
//            if (str1.length() < str2.length()) {
//                return -1;
//            }
//            if (str1.length() > str2.length()) {
//                return 1;
//            }
//            return 0;
//        });
    }

    public void testQuickSort() {
        testSortingIntegers(SIZE, new QuickSorter<Integer>(), null);

//        testSortingStrings(SIZE, new QuickSorter<String>(), null);

//        testSortingStrings(SIZE, new QuickSorter<String>(), (str1, str2) -> {
//            if (str1.length() < str2.length()) {
//                return -1;
//            }
//            if (str1.length() > str2.length()) {
//                return 1;
//            }
//            return 0;
//        });
    }

    private void testSortingIntegers(int size, Sorter sorter, Comparator<Integer> comparator) {
        Integer[] a = Utils.createRandomIntegerArray(size);
        Utils.printArray(a);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sorter.sort(a, comparator);
        stopWatch.stop();

        Utils.printArray(a);
        System.out.println("---------------------------------------");

        System.out.println(stopWatch.getResult() + "\n");
    }

    private void testSortingStrings(int size, Sorter sorter, Comparator<String> comparator) {
        String[] a = Utils.createRandomStringArray(size);
        Utils.printArray(a);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sorter.sort(a, comparator);
        stopWatch.stop();

        Utils.printArray(a);
        System.out.println("---------------------------------------");

        System.out.println(stopWatch.getResult() + "\n");
    }
}
