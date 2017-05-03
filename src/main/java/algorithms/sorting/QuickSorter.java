package algorithms.sorting;

import utils.ObjectUtils;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mman on 12.12.16.
 */
public class QuickSorter<T extends Comparable> implements Sorter<T> {
    private ThreadLocalRandom generator = ThreadLocalRandom.current().current();

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
        sort(arr, comparator, p + 1, to);
        return arr;
    }

    private static <T extends Comparable> int partition(T[] arr, Comparator<? super T> comparator, int from, int to) {
        T pivot = arr[from]; // This is only OK if the input is random. Otherwise use random pivot or median - (from + to) / 2
        int findBigger = from - 1; // This will increase until it finds an element that is bigger than pivot
        int findSmaller = to + 1; // This will decrease until it finds an element that is smaller than pivot

        while (true) {
            do {
                findBigger++;
            } while (ObjectUtils.compare(arr[findBigger], pivot, comparator) < 0);

            do {
                findSmaller--;
            } while (ObjectUtils.compare(arr[findSmaller], pivot, comparator) > 0);

            if (findBigger < findSmaller) {
                Sorter.swap(arr, findBigger, findSmaller);
            } else {
                return findSmaller;
            }
        }
    }

    private int randomizedPartition(T[] arr, Comparator<? super T> cmp, int left, int right) {
        int swapIndex = left + generator.nextInt(right - left) + 1;
        Sorter.swap(arr, left, swapIndex);
        return partition(arr, cmp, swapIndex, right);
    }
}
