package misctests;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by mman on 24.10.16.
 */
public class ListIterTest {
    public static void main(String[] args) {
        LinkedList<String> staff = new LinkedList<String>();
        ListIterator<String> iterator = staff.listIterator();
        iterator.add("Tom");
        iterator.add("Diana");
        iterator.add("Harry");
        iterator = staff.listIterator();
        if (iterator.next().equals("Tom")) { iterator.remove(); }
        while (iterator.hasNext()) { System.out.println(iterator.next()); }
    }
}
