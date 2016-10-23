package sources;

/**
 * Created by mman on 22.10.16.
 */
public class CustomDoubleLinkedList {
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    private static class Node {
        private Object value = null;
        private Node next = null;
        private Node prev = null;

        private Node(Object value) {
            this.value = value;
        }
    }

    public CustomDoubleLinkedList() {
    }

    public void add(Object o) {
        Node newNode = new Node(o);
        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
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
        for (int count = 0; count != index; current = current.next) {
            count++;
        }
        if (current.prev == null) { // Remove head
            head = current.next;
            head.prev = null;
        } else { // Remove regular
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
        current.next = null;

        if (current == tail) { // Remove Tail
            tail = current.prev;
        }

        return current.value;
    }

    public boolean remove(Object value) {
        Node current = head;
        while (current != null && !current.value.equals(value)) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        size--;

        if (current.prev == null) { // Remove Head
            head = current.next;
        } else {
            if (current == tail) { // Remove Tail
                tail = current.prev;
            }
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
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

    private boolean isIndexValid(int index) {
        return index >= 0 && index < size;
    }
}
