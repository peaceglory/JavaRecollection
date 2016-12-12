package sources.algorithms.sorting;

import sources.utils.Utils;

import java.util.Comparator;

/**
 * Created by mman on 12.12.16.
 */
public class QuickSorter<T extends Comparable> implements Sorter<T> {
    @Override
    public T[] sort(T[] arr) {
        return sort(arr, null);
    }

    @Override
    public T[] sort(T[] arr, Comparator<? super T> comparator) {
        return sort(arr, comparator, 0, arr.length - 1);
    }

    private T[] sort(T[] arr, Comparator<? super T> comparator, int from, int to) {
        if (from >= to) {
            return arr;
        }
        int p = partition(arr, comparator, from, to);
        sort(arr, comparator, from, p);
        sort(arr, comparator, from + 1, to);
        return arr;
    }

    private int partition(T[] arr, Comparator<? super T> comparator, int from, int to) {
        T pivot = arr[from];
        int i = from - 1;
        int j = to + 1;

        while (true) {
            do {
                i++;
            } while (Utils.compare(arr[i], pivot, comparator) < 0);

            do {
                j--;
            } while (Utils.compare(arr[j], pivot, comparator) > 0);

            if (i < j) {
                Sorter.swap(arr, i, j);
            } else {
                return j;
            }
        }
    }
}
