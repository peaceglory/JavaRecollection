package sources.datastructures.trees;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by mman on 18.11.16.
 */
public abstract class AMyTree<T> implements IMyTree<T> {
    protected Node<T> root;

    public AMyTree(T rootValue) {
        if (rootValue == null) {
            throw new IllegalArgumentException("Value cannot be null!");
        }
        root = new Node<>(rootValue);
    }

    @Override
    public IMyTree<T> minimum() {
        throw new NotImplementedException();
    }

    @Override
    public IMyTree<T> maximum() {
        throw new NotImplementedException();
    }

    @Override
    public IMyTree<T> predecessor(T value) {
        throw new NotImplementedException();
    }

    @Override
    public IMyTree<T> successor(T value) {
        throw new NotImplementedException();
    }

    @Override
    public IMyTree<T> search(T value) {
        throw new NotImplementedException();
    }

    @Override
    public void traverse(ITreeTraversor traversor) {
        traversor.traverse();
    }

    @Override
    public void insert(IMyTree<T> node) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(T nodeValue) {
        throw new NotImplementedException();
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

    public ITreeTraversor getBFSIterativeTraversor() {
        return new BFSIterativeTraversor();
    }

    public ITreeTraversor getBFSRecursiveTraversor() {
        return new BFSRecursiveTraversor();
    }

    public ITreeTraversor getDFSIterativeTraversor() {
        return new DFSIterativeTraversor();
    }

    public ITreeTraversor getDFSRecursiveTraversor() {
        return new DFSRecursiveTraversor();
    }

    protected static class Node<T> {
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

        private int size() {
            if (this.children.isEmpty()) {
                return 1;
            }
            int sum = 1;
            for (Node<T> n : children) {
                sum += n.size();
            }
            return sum;
        }

        private int leaves() {
            if (this.children.isEmpty()) {
                return 1;
            }
            int sum = 0;
            for (Node<T> n : children) {
                sum += n.leaves();
            }
            return sum;
        }

        private int maximumSiblings() {
            if (this.children.isEmpty()) {
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
    }

    private class BFSIterativeTraversor implements ITreeTraversor {

        @Override
        public void traverse() {

        }
    }

    private class BFSRecursiveTraversor implements ITreeTraversor {

        @Override
        public void traverse() {

        }
    }

    private class DFSIterativeTraversor implements ITreeTraversor {

        @Override
        public void traverse() {

        }
    }

    private class DFSRecursiveTraversor implements ITreeTraversor {

        @Override
        public void traverse() {
            traverse(root);
        }

        private void traverse(Node node) {
            print(node);
            if (node.children.isEmpty()) {
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
