package algorithms.sorting;

import utils.ObjectUtils;

import java.util.Comparator;

/**
 * Created by mman on 09.12.16.
 */
public class SelectionSorter<T extends Comparable> implements Sorter<T> {

    @Override
    public T[] sort(T[] arr) {
        return sort(arr, null);
    }

    @Override
    public T[] sort(T[] arr, Comparator<? super T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (ObjectUtils.compare(arr[min], arr[j], comparator) > 0) {
                    min = j;
                }
            }
            Sorter.swap(arr, i, min);
        }
        return arr;
    }
}
