package datastructures.misc;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mman on 02.02.17.
 */
public class Ordered implements Comparable<Ordered> {
    private int order;
    private String name;

    public Ordered(int order, String name) {
        this.order = order;
        this.name = name;
    }

    @Override
    public int compareTo(Ordered other) {
        return this.order - other.order;
    }

    public static void main(String[] args) {
        Set<Ordered> s = new TreeSet<>();
        s.add(new Ordered(9, "Melina"));
        s.add(new Ordered(3, "Sonia"));

        /*
         * This is considered a duplicate value. TreeSet uses TreeMap. Generally Map recognizes duplicate keys in terms of equals,
         * but with sorted maps like TreeMap duplicate keys are recognized in terms of compareTo or compare. The compareTo
         * method in this class uses only the 'int order' field to determine equality so according to TreeMap
         * key(9,Melina)->value(Object1) should be replaced with key(9,Melina)->value(Object2). In terms of TreeSet
         * the duplicate key(9,Jaqueline) is not allowed.
         */
        s.add(new Ordered(9, "Jaquelina"));
        s.add(new Ordered(11, "Alais"));

        s.forEach(o -> System.out.println(o.name));
    }
}


