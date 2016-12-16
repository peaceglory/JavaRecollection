package sources.algorithms.searching;

/**
 * Created by mman on 13.12.16.
 */
public class Searcher {

    public static <T extends Comparable> int linearSearch(T[] arr, T key) {
        for (int i = 0; i < arr.length; i++) {
            if (key.compareTo(arr[i]) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Array must first be sorted.
     * @param arr
     * @param key
     * @param <T>
     * @return Index of the found element or -1 if not found.
     */
    public static <T extends Comparable> int binarySearchIter(T[] arr, T key) {
        int from = 0;
        int to = arr.length - 1;

        while (from <= to) {
            int mid = (from + to) / 2; // Or the overflow safe variants: from + ((to - from) / 2) OR (from + to) >>> 1
            if (key.compareTo(arr[mid]) > 0) {
                from = mid + 1;
            } else if (key.compareTo(arr[mid]) < 0) {
                to = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * Array must first be sorted.
     * @param arr
     * @param key
     * @param <T>
     * @return Index of the found element or -1 if not found.
     */
    public static <T extends Comparable> int binarySearchRecur(T[] arr, int from, int to, T key) {
        if (from > to) {
            return -1;
        }

        int mid = (from + to) / 2;

        if (key.compareTo(arr[mid]) > 0) {
            return binarySearchRecur(arr, mid + 1, to, key);
        }
        if (key.compareTo(arr[mid]) < 0) {
            return binarySearchRecur(arr, from, mid - 1, key);
        }

        return mid;
    }
}
