package sources.algorithms.sorting;

import java.util.Comparator;
import java.util.Objects;

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
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (Objects.isNull(comparator)) {
                    if (arr[min].compareTo(arr[j]) > 0) {
                        min = j;
                    }
                } else {
                    if (Objects.compare(arr[min], arr[j], comparator) > 0) {
                        min = j;
                    }
                }
            }
            Sorter.swap(arr, i, min);
        }
        return arr;
    }
}
