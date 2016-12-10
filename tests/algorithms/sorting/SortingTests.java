package tests.algorithms.sorting;

import groovy.util.GroovyTestCase;
import sources.algorithms.sorting.InsertionSorter;
import sources.algorithms.sorting.SelectionSorter;
import sources.algorithms.sorting.Sorter;
import sources.utils.Utils;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;

/**
 * Created by mman on 09.12.16.
 */
public class SortingTests extends GroovyTestCase {

    public void testSelectionSort() {
        Integer[] a = Utils.createRandomIntegerArray(10);
        printArray(a);

        Sorter<Integer> integerSorter = new SelectionSorter<>();
        integerSorter.sort(a);

        printArray(a);
        System.out.println("---------------------------------------");

        String[] s = Utils.createRandomStringArray(10);
        printArray(s);

        Sorter<String> stringSorter = new SelectionSorter<>();
        stringSorter.sort(s);

        printArray(s);
        System.out.println("---------------------------------------");

        s = Utils.createRandomStringArray(10);
        printArray(s);

        stringSorter.sort(s, (str1, str2) -> {
            if (str1.length() < str2.length()) {
                return -1;
            }
            if (str1.length() > str2.length()) {
                return 1;
            }
            return 0;
        });

        printArray(s);
    }

    public void testInsertionSort() {
        Integer[] a = Utils.createRandomIntegerArray(10);
        printArray(a);

        InsertionSorter<Integer> integerSorter = new InsertionSorter<>();
        integerSorter.sort(a);

        printArray(a);
        System.out.println("---------------------------------------");

        String[] s = Utils.createRandomStringArray(10);
        printArray(s);

        Sorter<String> stringSorter = new InsertionSorter<>();
        stringSorter.sort(s);

        printArray(s);
        System.out.println("---------------------------------------");

        s = Utils.createRandomStringArray(10);
        printArray(s);

        stringSorter.sort(s, (str1, str2) -> {
            if (str1.length() < str2.length()) {
                return -1;
            }
            if (str1.length() > str2.length()) {
                return 1;
            }
            return 0;
        });

        printArray(s);
    }
}
