package utils;

import java.util.Comparator;

/**
 * Created by mman on 10.12.16.
 */
public class ObjectUtils {

    public static <T extends Comparable> int compare(T v1, T v2, Comparator<? super T> comparator) {
        if (comparator == null) {
            if (v1.compareTo(v2) > 0) {
                return 1;
            }
            if (v1.compareTo(v2) < 0) {
                return -1;
            }
        } else {
            if (comparator.compare(v1, v2) > 0) {
                return 1;
            }
            if (comparator.compare(v1, v2) < 0) {
                return -1;
            }
        }
        return 0;
    }
}
