package tests.oop;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mman on 04.11.16.
 */
public class MainTest {
    public static void main(String[] args) {
        Map<String, String> strings = new HashMap<>();
        strings.put("FB", "Value1");
        strings.put("Ea", "Value2");
        System.out.println(strings);

        System.out.println("FB".hashCode());
        System.out.println("Ea".hashCode());

        Map<Integer, Integer> ints = new HashMap<>();
        Integer
    }
}
