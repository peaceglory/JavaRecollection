package tests.algorithms.sorting;

import groovy.util.GroovyTestCase;
import sources.algorithms.RandomFactory;
import sources.algorithms.sorting.SelectionSorter;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 * Created by mman on 09.12.16.
 */
public class SortingTests extends GroovyTestCase {

    public void testSelectionSort() {
        Integer[] a = RandomFactory.createRandomIntegerArray(10);
        printArray(a);

        new SelectionSorter().sort(a);

        printArray(a);
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
