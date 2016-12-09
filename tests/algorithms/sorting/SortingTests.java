package tests.algorithms.sorting;

import groovy.util.GroovyTestCase;
import sources.algorithms.RandomFactory;
import sources.algorithms.sorting.SelectionSorter;
import sources.algorithms.sorting.Sorter;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 * Created by mman on 09.12.16.
 */
public class SortingTests extends GroovyTestCase {

    public void testSelectionSort() {
        Integer[] a = RandomFactory.createRandomIntegerArray(10);
        printArray(a);

        Sorter<Integer> integerSorter = new SelectionSorter<>();
        integerSorter.sort(a);

        printArray(a);
        System.out.println("---------------------------------------");

        String[] s = RandomFactory.createRandomStringArray(10);
        printArray(s);

        Sorter<String> stringSorter = new SelectionSorter<>();
        stringSorter.sort(s);

        printArray(s);
        System.out.println("---------------------------------------");

        s = RandomFactory.createRandomStringArray(10);
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

    static void printArray(Object arr) {
        if (Objects.nonNull(arr)) {
            Class<?> clazz = arr.getClass();
            if (clazz.isArray()) {
                int l = Array.getLength(arr);
                for (int i = 0; i < l; i++) {
                    if (i == 0) {
                        System.out.print("[");
                    }
                    System.out.print(Array.get(arr, i));

                    if (i == l - 1) {
                        System.out.println("]");
                    } else {
                        System.out.print(", ");
                    }

                }
            }
        }
    }
}
