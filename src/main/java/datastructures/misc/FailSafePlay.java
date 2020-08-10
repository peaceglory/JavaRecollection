package datastructures.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class FailSafePlay {

    // ConcurrentHashMap is fail-safe (no exceptions on modification while iterating)
    // but is weakly consistent (no guarantee on if newly added data will be visited by the iterator)
    public List<String> iterateAndModify(ConcurrentMap<String, String> map, String insertKey, String inserValue) {
        final List<String> keysPrinted = new ArrayList<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry);
            keysPrinted.add(entry.getKey());
            map.put(insertKey, inserValue);
        }

        return keysPrinted;
    }
}
