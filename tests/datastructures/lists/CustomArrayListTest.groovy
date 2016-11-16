package tests.datastructures.lists

import sources.datastructures.lists.CustomArrayList

/**
 * Created by mman on 20.10.16.
 */
class CustomArrayListTest extends groovy.util.GroovyTestCase {

    void testAdd() {
        CustomArrayList l = new CustomArrayList(6);

        l.add(0, "Zero");
        l.add(1, "One");
        l.add(2, "Two");
        l.add(3, "Three");
        l.add(4, "Four");
        l.add(1, "NewOne");

        printArray(l);
    }

    void testAdd1() {
        CustomArrayList l = new CustomArrayList(6);
        l.add("Zero");
        l.add("One");
        l.add("Two")
        l.add("Three");
        l.add("Four");
        l.add("Five");
        printArray(l);
    }

    void testSize() {
        CustomArrayList l = new CustomArrayList(7);

        l.add(0, "Zero");
        l.add(1, "One");
        l.add(2, "Two");
        l.add(3, "Three");
        l.add(4, "Four");
        l.add(1, "NewOne");

        assert l.size() == 6;
    }

    void testIsEmpty() {
        CustomArrayList l = new CustomArrayList(6);
        assert l.isEmpty();

        l.add("HAHA");
        assert ! l.isEmpty();
    }

    void testIndexOf() {
        CustomArrayList l = new CustomArrayList(7);

        l.add(0, "Zero");
        l.add(1, "One");
        l.add(2, "Two");
        l.add(3, "Three");
        l.add(4, "Four");

        assert l.indexOf("Two") == 2;
        assert l.indexOf(new Object()) == -1;
        assert l.indexOf(null) == -1;

        l.add(1, "NewOne");
        assert l.indexOf("NewOne") == 1;

        l.add(2, null);
        assert l.indexOf(null) == 2;
    }

    void testContains() {
        CustomArrayList l = new CustomArrayList(7);

        l.add(0, "Zero");
        l.add(1, null);
        l.add(2, "Two");
        l.add(3, "Three");
        l.add(4, "Four");

        assert l.contains("Three");
        assert ! l.contains("Nine");
        assert l.contains(null);
    }

    void testRemove() {
        CustomArrayList l = new CustomArrayList(7);

        l.add(0, "Zero");
        l.add(1, null);
        l.add(2, "Two");
        l.add(3, "Three");
        l.add(4, "Four");

        assert l.remove(0) == "Zero";
        assert l.remove(0) == null;
        assert l.remove(1).equals("Three");
        assert l.remove(1).equals("Four");
    }

    void testRemove1() {
        CustomArrayList l = new CustomArrayList(7);

        l.add(0, "Zero");
        l.add(1, null);
        l.add(2, "Two");
        l.add(3, "Three");
        l.add(4, "Four");

        assert l.remove("Zero");
        assert l.remove("Three");
        assert l.remove(null);
        assert ! l.remove("haha");
    }

    void testReverse() {
        CustomArrayList list = new CustomArrayList();
        for (long i = 0; i <= 10; i++) {
            list.add(new Long(i));
        }
//        for (int j = 0; j < list.size(); j++) {
//            System.out.print(list.get(j) + " ");
//            if (j % 50 == 0) {
//                System.out.println();
//            }
//        }

        long then = System.currentTimeMillis();
        list.reverse();
        long now = System.currentTimeMillis();

//        System.out.println("\n\n\n\n\n\n");
//
//        for (int k = 0; k < list.size(); k++) {
//            System.out.print(list.get(k) + " ");
//            if (k % 50 == 0) {
//                System.out.println();
//            }
//        }
        println "Reverse took: " + (now-then)/1000 + " sec.";
    }

    private void printArray(CustomArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
