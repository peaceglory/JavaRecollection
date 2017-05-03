package algorithms.misc;

import java.util.List;

/**
 * Created by mman on 30.12.16.
 */
public class ListMiddleFinder {

    public static <T> T findMiddleInOnePass(List<T> list) {
        int lazy = 0;
        for (int eager = 0; eager < list.size() - 1; ) {
            eager++;
            if (eager % 2 == 0) {
                lazy++;
            }
        }
        return list.get(lazy);
    }
}
