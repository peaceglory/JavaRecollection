package datastructures.custom.lists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by mman on 18.02.17.
 */
public class LinkedListUtils {

    public static void removeDuplicates(List list) {
        Set s = new HashSet(list);
        list.clear();
        s.forEach(e -> list.add(e));


//        for (int first = 0; first < list.size() - 1; first++) {
//            for (int second = first + 1; second < list.size(); second++) {
//                if (list.get(first).equals(list.get(second))) {
//                    list.remove(second);
//                }
//            }
//
//        }

//        ListIterator iter1 = list.listIterator();
//        while (iter1.hasNext()) {
//            if (iter1.nextIndex() == list.size() - 1) {
//                break;
//            }
//            Object e1 = iter1.next();
//            ListIterator iter2 = list.listIterator(iter1.nextIndex());
//            while (iter2.hasNext()) {
//                Object e2 = iter2.next();
//                if (e1.equals(e2)) {
//                    iter2.remove();
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("A");
        list.add("C");

        list.forEach(System.out::println);
        System.out.println("----------------------------------------");
        removeDuplicates(list);
        list.forEach(System.out::println);
    }
}
