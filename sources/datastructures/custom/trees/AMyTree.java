package sources.datastructures.custom.trees;

import java.util.*;

/**
 * Created by mman on 18.11.16.
 */
public abstract class AMyTree<T extends Comparable> implements IMyTree<T> {
    protected Node<T> root;

    public AMyTree(T rootValue) {
        if (rootValue == null) {
            throw new IllegalArgumentException("Value cannot be null!");
        }
        root = new Node<>(rootValue);
    }

    protected AMyTree(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException("Root cannot be null!");
        }
        this.root = root;
    }

    @Override
    public T minimum() {
        return root.minimum();
    }

    @Override
    public T maximum() {
        return root.maximum();
    }

    @Override
    public void traverse(TraverseStrategy strategy) {
        if (TraverseStrategy.DFSIterative == strategy) {
            traverseDSFIterative(root);
        } else if (TraverseStrategy.DFSRecursive == strategy) {
            traverseDSFRecursive(root);
        } else if (TraverseStrategy.BFSIterative == strategy) {
            traverseBSFIterative(root);
        }
    }

    private void traverseBSFIterative(Node<T> node) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(node);
        Node<T> head = null;
        while (!queue.isEmpty()) {
            head = queue.poll();
            print(head);
            if (!head.isLeaf()) {
                for (Node<T> n : head.children) {
                    queue.add(n);
                }
            }
        }
    }

    private void traverseDSFRecursive(Node<T> node) {
        print(node);
        if (node.isLeaf()) {
            return;
        }
        ListIterator<Node<T>> iter = node.children.listIterator();
        while (iter.hasNext()) {
            traverseDSFRecursive(iter.next());
        }
    }

    private void traverseDSFIterative(Node<T> node) {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(node);
        Node<T> top = null;
        while (!stack.isEmpty()) {
            top = stack.pop();
            print(top);
            if (!top.isLeaf()) {
                for (Node<T> n : top.children) {
                    stack.push(n);
                }
            }
        }
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }
        return root.size();
    }

    @Override
    public int leaves() {
        if (root == null) {
            return 0;
        }
        return root.leaves();
    }

    @Override
    public int maximumSiblings() {
        if (root == null) {
            return 0;
        }
        return root.maximumSiblings();
    }

    @Override
    public int totalPathLength() {
        if (root == null) {
            return 0;
        }
        return root.totalPathLenght();
    }

    @Override
    public int height() {
        if (root == null) {
            return 0;
        }
        return root.height();
    }

    protected static class Node<T extends Comparable> {
        private T value = null;
        private Node<T> parent = null;
        private List<Node<T>> children = new ArrayList<>();

        private Node(T value) {
            this.value = value;
        }

        protected void addChild(Node<T> child) {
            if (child == null) {
                throw new IllegalArgumentException("Child cannot be null!");
            }
            if (child.hasParent()) {
                throw new IllegalArgumentException("This node already has a parent!");
            }
            child.parent = this;
            children.add(child);
        }

        public boolean hasParent() {
            return parent != null;
        }

        public boolean isLeaf() {
            return children.isEmpty();
        }

        protected int size() {
            if (isLeaf()) {
                return 1;
            }
            int sum = 1;
            for (Node<T> n : children) {
                sum += n.size();
            }
            return sum;
        }

        protected int leaves() {
            if (isLeaf()) {
                return 1;
            }
            int sum = 0;
            for (Node<T> n : children) {
                sum += n.leaves();
            }
            return sum;
        }

        protected int maximumSiblings() {
            if (isLeaf()) {
                return 0;
            }
            int currMax = this.children.size();
            int candidate = -1;
            for (Node<T> n : children) {
                candidate = n.maximumSiblings();
                currMax = Math.max(currMax, candidate);
            }
            return currMax;
        }

        protected int totalPathLenght() {
            if (isLeaf()) {
                int ancestors = 1;
                Node<T> currNode = this;
                while (currNode.hasParent()) {
                    currNode = currNode.parent;
                    ancestors++;
                }
                return ancestors;
            }
            int totalPathLength = 0;
            for (Node<T> n : children) {
                totalPathLength += n.totalPathLenght();
            }
            return totalPathLength;
        }

        protected T minimum() {
            if (isLeaf()) {
                return value;
            }
            T min = value;
            for (Node<T> n : children) {
                T candidate = n.minimum();
                if (min.compareTo(candidate) > 0) {
                    min = candidate;
                }
            }
            return min;
        }

        protected T maximum() {
            if (isLeaf()) {
                return value;
            }
            T max = value;
            for (Node<T> n : children) {
                T candidate = n.maximum();
                if (max.compareTo(candidate) < 0) {
                    max = candidate;
                }
            }
            return max;
        }

        public Node<T> search(T value) {
            if (this.value.compareTo(value) == 0) {
                return this;
            }
            Node<T> result = null;
            if (!isLeaf()) {
                for (Node<T> n : children) {
                    result = n.search(value);
                    if (result != null) {
                        break;
                    }
                }
            }
            return result;
        }

        public int height() {
            if (isLeaf()) {
                int height = 1;
                Node current = this;
                while (current.hasParent()) {
                    current = current.parent;
                    height++;
                }
                return height;
            }
            int height = 1;
            for (Node n : children) {
                int candidate = n.height();
                height = Math.max(height, candidate);
            }
            return height;
        }
    }

    private static void print(Node node) {
        System.out.println(node.value);
    }
}
