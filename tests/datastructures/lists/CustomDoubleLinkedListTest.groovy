package tests.datastructures.lists

import sources.datastructures.custom.lists.CustomDoubleLinkedList
/**
 * Created by mman on 23.10.16.
 */
class CustomDoubleLinkedListTest extends GroovyTestCase {

    void testAdd() {
        CustomDoubleLinkedList list = new CustomDoubleLinkedList();

        list.add("One");
        list.add("Two");
        list.add("Three");
        assert list.size() == 3;
    }

    void testRemoveByIndex() {
        CustomDoubleLinkedList list = new CustomDoubleLinkedList();
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

    void testRemoveByValue() {

    }

    void testReverse() {
        CustomDoubleLinkedList list = new CustomDoubleLinkedList();

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
}
