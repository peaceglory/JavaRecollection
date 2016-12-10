package tests.algorithms.sorting;

import groovy.util.GroovyTestCase;
import sources.algorithms.sorting.BubbleSorter;
import sources.algorithms.sorting.InsertionSorter;
import sources.algorithms.sorting.SelectionSorter;
import sources.algorithms.sorting.Sorter;
import sources.utils.Utils;

/**
 * Created by mman on 09.12.16.
 */
public class SortingTests extends GroovyTestCase {

    public void testSelectionSort() {
        Integer[] a = Utils.createRandomIntegerArray(10);
        Utils.printArray(a);

        Sorter<Integer> integerSorter = new SelectionSorter<>();
        integerSorter.sort(a);

        Utils.printArray(a);
        System.out.println("---------------------------------------");

        String[] s = Utils.createRandomStringArray(10);
        Utils.printArray(s);

        Sorter<String> stringSorter = new SelectionSorter<>();
        stringSorter.sort(s);

        Utils.printArray(s);
        System.out.println("---------------------------------------");

        s = Utils.createRandomStringArray(10);
        Utils.printArray(s);

        stringSorter.sort(s, (str1, str2) -> {
            if (str1.length() < str2.length()) {
                return -1;
            }
            if (str1.length() > str2.length()) {
                return 1;
            }
            return 0;
        });

        Utils.printArray(s);
    }

    public void testInsertionSort() {
        Integer[] a = Utils.createRandomIntegerArray(10);
        Utils.printArray(a);

        Sorter<Integer> integerSorter = new InsertionSorter<>();
        integerSorter.sort(a);

        Utils.printArray(a);
        System.out.println("---------------------------------------");

        String[] s = Utils.createRandomStringArray(10);
        Utils.printArray(s);

        Sorter<String> stringSorter = new InsertionSorter<>();
        stringSorter.sort(s);

        Utils.printArray(s);
        System.out.println("---------------------------------------");

        s = Utils.createRandomStringArray(10);
        Utils.printArray(s);

        stringSorter.sort(s, (str1, str2) -> {
            if (str1.length() < str2.length()) {
                return -1;
            }
            if (str1.length() > str2.length()) {
                return 1;
            }
            return 0;
        });

        Utils.printArray(s);
    }

    public void testBubbleSort() {
        Integer[] a = Utils.createRandomIntegerArray(10);
        Utils.printArray(a);

        Sorter<Integer> integerSorter = new BubbleSorter<>();
        integerSorter.sort(a);

        Utils.printArray(a);
        System.out.println("---------------------------------------");

        String[] s = Utils.createRandomStringArray(10);
        Utils.printArray(s);

        Sorter<String> stringSorter = new BubbleSorter<>();
        stringSorter.sort(s);

        Utils.printArray(s);
        System.out.println("---------------------------------------");

        s = Utils.createRandomStringArray(10);
        Utils.printArray(s);

        stringSorter.sort(s, (str1, str2) -> {
            if (str1.length() < str2.length()) {
                return -1;
            }
            if (str1.length() > str2.length()) {
                return 1;
            }
            return 0;
        });

        Utils.printArray(s);
    }
}
