package algorithms.sorting;

import utils.ObjectUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mman on 10.12.16.
 */
public class MergeSorter<T extends Comparable> implements Sorter<T> {

    @Override
    public T[] sort(T[] arr) {
        return sort(arr, null);
    }

    @Override
    public T[] sort(T[] arr, Comparator<? super T> comparator) {
        if (arr.length <= 1) {
            return arr;
        }
        T[] arr1 = Arrays.copyOfRange(arr, 0, arr.length >> 1); // number >> 1 = number / 2
        T[] arr2 = Arrays.copyOfRange(arr, arr.length >> 1, arr.length);
        sort(arr1, comparator);
        sort(arr2, comparator);
        merge(arr, arr1, arr2, comparator);
        return arr;
    }

    private static <V extends Comparable> void merge(V[] arr, V[] arr1, V[] arr2, Comparator<? super V> comparator) {
        int i = 0;
        int iFirst = 0;
        int iSecond = 0;

        while (iFirst < arr1.length && iSecond < arr2.length) {
            if (ObjectUtils.compare(arr1[iFirst], arr2[iSecond], comparator) < 0) {
                arr[i++] = arr1[iFirst++];
            } else {
                arr[i++] = arr2[iSecond++];
            }
        }

        // Any remaining elements.
        while (iFirst < arr1.length) {
            arr[i++] = arr1[iFirst++];
        }
        while (iSecond < arr2.length) {
            arr[i++] = arr2[iSecond++];
        }
    }
}
