package algorithms.sorting;

import java.util.Comparator;

/**
 * Created by mman on 09.12.16.
 */
public interface Sorter<T extends Comparable> {

    T[] sort(T[] arr);

    T[] sort(T[] arr, Comparator<? super T> comparator);

    static <V> void swap(V[] arr, int i1, int i2) {
        V tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

}
