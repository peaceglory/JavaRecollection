package sources.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mman on 16.11.16.
 */
public class MyTree<T> {
    private Node<T> root = null;

    public MyTree(T rootValue) {
	if (rootValue == null) {
	    throw new IllegalArgumentException("Value cannot be null!");	
	}
        root = new Node<T>(rootValue);
    }

    public MyTree(T rootValue, T... childrenValue) {

    }

    private static class Node<T> {
        private T value = null;
        private List<Node<T>> children = new ArrayList<>();

        private Node(T value) {
            this.value = value;
        }
    }
}
