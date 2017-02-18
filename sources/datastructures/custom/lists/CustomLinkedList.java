package sources.datastructures.custom.lists;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mman on 22.10.16.
 */
public class CustomLinkedList {
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    private static class Node {
        private Object value = null;
        private Node next = null;

        private Node(Object value) {
            this.value = value;
        }
    }

    public CustomLinkedList() {
    }

    public void add(Object o) {
        Node newNode = new Node(o);
        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Object remove(int index) {
        if (!isIndexValid(index)) {
            throw new IndexOutOfBoundsException("Index is invalid: " + index);
        }

        size--;

        if (head == tail) {
            Object removedValue = head.value;
            head = tail = null;
            return removedValue;
        }

        Node current = head;
        Node previous = null;
        for (int count = 0; count != index; current = current.next) {
            previous = current;
            count++;
        }
        if (previous == null) { // Remove head
            head = current.next;
        } else { // Remove regular
            previous.next = current.next;
        }
        current.next = null;

        if (current == tail) { // Remove Tail
            tail = previous;
        }

        return current.value;
    }

    public boolean remove(Object value) {
        Node current = head;
        Node previous = null;
        while (current != null && !current.value.equals(value)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        size--;

        if (previous == null) { // Remove Head
            head = current.next;
        } else {
            if (current == tail) { // Remove Tail
                tail = previous;
            }
            previous.next = current.next;
        }
        current.next = null;

        return true;
    }

    public Object get(int index) {
        if (!isIndexValid(index)) {
            throw new IndexOutOfBoundsException("Index is invalid: " + index);
        }
        Node current = head;
        for (int count = 0; count != index; current = current.next) {
            count++;
        }
        return current.value;
    }

    public int size() {
        return this.size;
    }

    public void reverse(boolean iterative) {
        if (iterative) {
            reverseIterative();
        } else {
            reverseRecursive(null, head);
        }
    }

    private void reverseRecursive(Node prev, Node current) {
        if (current.next == null) {
            current.next = prev;
            head = current;
            return;
        }
        reverseRecursive(current, current.next);
        current.next = prev;
        if (prev == null) {
            tail = current;
        }
    }

    private void reverseIterative() {
        Node prev = null;
        Node curr = head;
        Node next = null;

        tail = head;
        do {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } while (next != null);
        head = prev;
    }

    public void removeDuplicates(boolean saveTime) {
        if (saveTime) { // O(N) time, O(N) space
            Set<Object> set = new HashSet<>(size);
            Node prev = null;
            for (Node curr = head; curr != null; ) {
                if (!set.add(curr.value)) {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                    size--;
                    continue;
                }
                prev = curr;
                curr = curr.next;
            }
        } else { // O(N^2) time, O(1) space
            for (Node first = head; first.next.next != null; ) {
                Node second = first;
                while (second.next != null) {
                    if (first.value.equals(second.next.value)) {
                        Node tmp = second.next.next;
                        second.next.next = null;
                        second.next = tmp;
                        size--;
                        continue;
                    }
                    second = second.next;
                }
                first = first.next;
            }
        }
    }

    private boolean isIndexValid(int index) {
        return index >= 0 && index < size;
    }
}
