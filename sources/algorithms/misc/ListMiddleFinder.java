package sources.algorithms.misc;

import java.util.List;

/**
 * Created by mman on 30.12.16.
 */
public class ListMiddleFinder {

    public static <T> T findMiddleInOnePass(List<T> list) {
        int midPointer = 0;
        for (int i = 0; i < list.size() - 1; ) {
            i++;
            if (i % 2 == 0) {
                midPointer++;
            }
        }
        return list.get(midPointer);
    }
}
