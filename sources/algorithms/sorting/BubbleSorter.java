package sources.algorithms.sorting;

import java.util.Comparator;

/**
 * Created by mman on 10.12.16.
 */
public class BubbleSorter<T extends Comparable> implements Sorter<T> {

    @Override
    public T[] sort(T[] arr) {
        return sort(arr, null);
    }

    @Override
    public T[] sort(T[] arr, Comparator<? super T> comparator) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator == null) {
                    if (arr[j].compareTo(arr[j + 1]) > 0) {
                        Sorter.swap(arr, j, j + 1);
                    }
                } else {
                    if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                        Sorter.swap(arr, j, j + 1);
                    }
                }
            }
        }
        return arr;
    }
}
