package misc;

import java.util.LinkedList;

/**
 * Created by mman on 22.10.16.
 */
public class LinkedListTest {

    public static void main(String[] args) {
        final int PREFILL_COUNT = 100_000;
        final int LOOP_COUNT = 300_000_000;
        final LinkedList<Integer> lst = new LinkedList<Integer>();
        final Integer val = 1;

        for ( int i = 0; i < PREFILL_COUNT; ++i )
            lst.add( 35 );

        long then = System.currentTimeMillis();
        for ( int i = 0; i < LOOP_COUNT; ++i )
        {
            for ( int j = 0; j < 5; ++j )
                lst.addFirst( val );
            for ( int j = 0; j < 5; ++j )
                lst.removeLast();
        }
        long now = System.currentTimeMillis();

        System.out.println("IT all took: " + (now - then)/1000 + " sec.");
    }
}
