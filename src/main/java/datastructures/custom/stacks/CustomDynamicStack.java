package datastructures.custom.stacks;

/**
 * Created by mman on 24.10.16.
 */
public class CustomDynamicStack {
    private int size = 0;
    private Node top = null;

    private static class Node {
        private Object value = null;
        private Node next = null;

        private Node(Object value) {
            this.value = value;
        }
    }

    public CustomDynamicStack() {
    }

    public CustomDynamicStack push(Object o) {
        Node newNode = new Node(o);
        newNode.next = top;
        top = newNode;
        size++;
        return this;
    }

    public Object pop() {
        Object topValue = null;
        if (size > 0) {
            size--;
            topValue = top.value;
            Node newTop = top.next;
            top.next = null;
            top = newTop;
        }
        return topValue;
    }

    public int size() {
        return this.size;
    }
}
