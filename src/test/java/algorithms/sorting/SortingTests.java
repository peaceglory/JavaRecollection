package algorithms.sorting;

import utils.ArrayUtils;
import utils.StopWatch;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * Created by mman on 09.12.16.
 */
class SortingTests  {
    private static final int SIZE = 10;

    @Test
    void testSelectionSort() {
        testSortingIntegers(SIZE, new SelectionSorter<Integer>(), null);

//        testSortingStrings(SIZE, new SelectionSorter<String>(), null);

//        testSortingStrings(SIZE, new SelectionSorter<String>(), (str1, str2) -> {
//            if (str1.length() < str2.length()) {
//                return -1;
//            }
//            if (str1.length() > str2.length()) {
//                return 1;
//            }
//            return 0;
//        });
    }

    @Test
    void testInsertionSort() {
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

    @Test
    void testBubbleSort() {
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

    @Test
    void testMergeSort() {
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

    @Test
    void testQuickSort() {
        testSortingIntegers(SIZE, new QuickSorter<Integer>(), null);

//        testSortingIntegersInSortedArray(SIZE, new QuickSorter<Integer>(), null);

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
        Integer[] a = ArrayUtils.createRandomIntegerArray(size);
        ArrayUtils.printArray(a);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sorter.sort(a, comparator);
        stopWatch.stop();

        ArrayUtils.printArray(a);
        System.out.println("---------------------------------------");

        System.out.println(stopWatch.getResult() + "\n");
    }

    private void testSortingIntegersInSortedArray(int size, Sorter sorter, Comparator<Integer> comparator) {
        Integer[] a = ArrayUtils.createRandomIntegerArray(size);
        sorter.sort(a, comparator);
        ArrayUtils.printArray(a);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sorter.sort(a, comparator);
        stopWatch.stop();

        ArrayUtils.printArray(a);
        System.out.println("---------------------------------------");

        System.out.println(stopWatch.getResult() + "\n");
    }

    private void testSortingStrings(int size, Sorter sorter, Comparator<String> comparator) {
        String[] a = ArrayUtils.createRandomStringArray(size);
        ArrayUtils.printArray(a);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sorter.sort(a, comparator);
        stopWatch.stop();

        ArrayUtils.printArray(a);
        System.out.println("---------------------------------------");

        System.out.println(stopWatch.getResult() + "\n");
    }
}
