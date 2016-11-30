package tests.misc;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by mman on 22.10.16.
 */
public class LinkedListIteration {
    public static void main(String[] args) {
        final List<Integer> lst = new LinkedList<>();
        for ( int i = 0; i < 1000000; ++i )
            lst.add( i );
        long sum = 0;
        long then = System.currentTimeMillis();
        ListIterator<Integer> iter = lst.listIterator();
        int i = 0;
        while (iter.hasNext()) {
            sum += iter.next();
            lst.get(i++);
        }
//        for ( int i = 0; i < 1_000_000; ++i )
//            sum += lst.get( i );
        long now = System.currentTimeMillis();

        System.out.println("IT all took: " + (now - then)/1000 + " sec. Sum: " + sum);
    }
}
