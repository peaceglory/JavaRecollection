package algorithms.misc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IntegerAdder {

    public List<Integer> add(final List<Integer> list1, final List<Integer> list2) {
        final List<Integer> outcome = new LinkedList<>();

        final Iterator<Integer> iter1 = list1.iterator();
        final Iterator<Integer> iter2 = list2.iterator();

        if (list1.size() >= list2.size()) {
            int save = 0;
            while (iter1.hasNext()) {
                int left = 0;
                final int current1 = iter1.next();
                final int current2 = iter2.hasNext() ? iter2.next() : 0;
                int sum = current1 + current2 + save;
                left = sum % 10;
                save = sum >= 10 ? 1 : 0;
                outcome.add(left);
            }
            if (save == 1) {
                outcome.add(1);
            }
        } else {
            return add(list2, list1);
        }


        return outcome;
    }
}
