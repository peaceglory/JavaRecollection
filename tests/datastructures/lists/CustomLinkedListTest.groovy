package tests.datastructures.lists

import sources.datastructures.custom.lists.CustomLinkedList

/**
 * Created by mman on 22.10.16.
 */
class CustomLinkedListTest extends GroovyTestCase {

    void testAdd() {
        CustomLinkedList list = new CustomLinkedList();

        list.add("One");
        list.add("Two");
        list.add("Three");
        assert list.size() == 3;


    }

    void testRemove() {
        CustomLinkedList list = new CustomLinkedList();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        list.remove(3);
        assert list.size() == 4 && list.get(3) == "Five";

        list.remove(3);
        assert list.size() == 3 && list.get(2) == "Three";

        list.remove(0);
        assert list.size() == 2 && list.get(0) == "Two";

        list.remove(1);
        assert list.size() == 1 && list.get(0) == "Two";

        boolean excCaught = false;
        try {
            list.remove(10);
        } catch (IndexOutOfBoundsException iob) {
            excCaught = true;
        }
        assert excCaught;

        list.remove(0);
        assert list.size() == 0;
    }

    void testRemove1() {
        CustomLinkedList list = new CustomLinkedList();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");

        assert list.remove("One") && list.get(0) == "Two" && list.size() == 5;
        assert list.remove("Six") && list.get(list.size() - 1) == "Five" && list.size() == 4;
        assert list.remove("Four") && list.get(2) == "Five" && list.size() == 3;
        assert !list.remove("Ten") && list.get(2) == "Five" && list.size() == 3;
    }

    void testGet() {
        CustomLinkedList list = new CustomLinkedList();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        assert list.get(0) == "One";
        assert list.get(2) == "Three";
        assert list.get(4) == "Five";
    }

    void testReverse() {
        CustomLinkedList list = new CustomLinkedList();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        list.reverse(false);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    void testRemoveDuplicates() {
        CustomLinkedList list = new CustomLinkedList();
        list.add("A")
        list.add("B")
        list.add("A")
        list.add("A")
        list.add("C")

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        println "_________________________________"

        list.removeDuplicates(false);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
