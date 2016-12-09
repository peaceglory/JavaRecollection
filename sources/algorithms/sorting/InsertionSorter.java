package sources.algorithms.sorting;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by mman on 09.12.16.
 */
public class InsertionSorter<T extends Comparable> implements Sorter<T> {

    @Override
    public T[] sort(T[] arr) {
        return sort(arr, null);
    }

    @Override
    public T[] sort(T[] arr, Comparator<? super T> comparator) {
        for (int i = 1; i < arr.length; i++) {
            T hold = arr[i];
            int j = i;
            if (Objects.isNull(comparator)) {
                for (; j > 0 && hold.compareTo(arr[j - 1]) < 0; j--) {
                    arr[j] = arr[j - 1];
                }
            } else {
                for (; j > 0 && Objects.compare(hold, arr[j - 1], comparator) < 0; j--) {
                    arr[j] = arr[j - 1];
                }
            }
            arr[j] = hold;
        }
        return arr;
    }
}
