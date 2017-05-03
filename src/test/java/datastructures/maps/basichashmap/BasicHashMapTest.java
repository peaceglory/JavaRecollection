package datastructures.maps.basichashmap;

import datastructures.custom.maps.BasicHashMap;
import datastructures.custom.maps.BasicMap;

/**
 * Created by mman on 10.02.17.
 */
public class BasicHashMapTest {

    public static void main(String[] args) {
        BasicMap<String, String> map = new BasicHashMap<>(5, 0.5f);

        map.put("One", "ValueOne");
        map.put("Two", "ValueTwo");
        map.put("Three", "ValueThree");
        map.put("Four", "ValueFour");
        map.put("Five", "ValueFive");

        System.out.println(map.get("One"));
        System.out.println(map.get("Four"));
        System.out.println(map.get("Two"));
        System.out.println(map.get("Three"));
        System.out.println(map.get(null));
        System.out.println(map.get("Nine"));
    }
}
