package datastructures.maps.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mman on 04.11.16.
 */
public class MapTestMain {
    public static void main(String[] args) {
        Map<String, String> strings = new HashMap<>();
        strings.put("FB", "Value1"); // Keys have same hashcode but are not equal, so the bucket becomes a linked list.
        strings.put("Ea", "Value2");
        System.out.println(strings);

        System.out.println("FB".hashCode());
        System.out.println("FB".hashCode());

        Map<Integer, Integer> ints = new HashMap<>();
        Integer first = new Integer(1);
        Integer second = new Integer(1);
        System.out.println(first.hashCode() + ": " + first.equals(second));
        System.out.println(second.hashCode() + ": " + second.equals(first));

    }
}
