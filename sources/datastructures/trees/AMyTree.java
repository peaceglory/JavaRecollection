package sources.datastructures.trees;

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
    public void traverse(ITreeTraversor traversor) {
        traversor.traverse();
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

    public ITreeTraversor getBFSIterativeTraversor() {
        return new BFSIterativeTraversor();
    }

    public ITreeTraversor getDFSIterativeTraversor() {
        return new DFSIterativeTraversor();
    }

    public ITreeTraversor getDFSRecursiveTraversor() {
        return new DFSRecursiveTraversor();
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

        private boolean hasParent() {
            return parent != null;
        }

        private boolean isLeaf() {
            return children.isEmpty();
        }

        private int size() {
            if (isLeaf()) {
                return 1;
            }
            int sum = 1;
            for (Node<T> n : children) {
                sum += n.size();
            }
            return sum;
        }

        private int leaves() {
            if (isLeaf()) {
                return 1;
            }
            int sum = 0;
            for (Node<T> n : children) {
                sum += n.leaves();
            }
            return sum;
        }

        private int maximumSiblings() {
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

        private int totalPathLenght() {
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

        private T minimum() {
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

        private T maximum() {
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
    }

    private class BFSIterativeTraversor implements ITreeTraversor {

        @Override
        public void traverse() {
            traverse(root);
        }

        private void traverse(Node<T> node) {
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
    }

    private class DFSIterativeTraversor implements ITreeTraversor {

        @Override
        public void traverse() {
            traverse(root);
        }

        private void traverse(Node<T> node) {
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
    }

    private class DFSRecursiveTraversor implements ITreeTraversor {

        @Override
        public void traverse() {
            traverse(root);
        }

        private void traverse(Node node) {
            print(node);
            if (node.isLeaf()) {
                return;
            }
            ListIterator<Node<T>> iter = node.children.listIterator();
            while (iter.hasNext()) {
                traverse(iter.next());
            }
        }
    }

    private static void print(Node node) {
        System.out.println(node.value);
    }
}
