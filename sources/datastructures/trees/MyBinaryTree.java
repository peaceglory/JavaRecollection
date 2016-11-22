package sources.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mman on 22.11.16.
 */
public class MyBinaryTree<T extends Comparable> implements IMyTree<T> {
    private T value = null;
    private MyBinaryTree<T> parent = null;
    private MyBinaryTree<T> left = null;
    private MyBinaryTree<T> right = null;

    public MyBinaryTree(T value) {
        this.value = value;
    }

    public MyBinaryTree(T value, MyBinaryTree<T> left, MyBinaryTree<T> right) {
        this(value);
        this.left = left;
        this.left.parent = this;
        this.right = right;
        this.right.parent = this;
    }

    @Override
    public T minimum() {
        if (this.isLeaf()) {
            return value;
        }
        T min = value;
        T candidate = null;
        if (left != null) {
            candidate = left.minimum();
            if (min.compareTo(candidate) > 0) {
                min = candidate;
            }
        }
        if (right != null) {
            candidate = right.minimum();
            if (min.compareTo(candidate) > 0) {
                min = candidate;
            }
        }
        return min;
    }

    @Override
    public T maximum() {
        return null;
    }

    @Override
    public IMyTree search(T value) {
        if  (this.value.compareTo(value) == 0) {
            return this;
        }
        IMyTree<T> candidate = null;
        if (left != null) {
            candidate = left.search(value);
            if (candidate != null) {
                return candidate;
            }
        }
        if (this.right != null) {
            candidate = right.search(value);
            if (candidate != null) {
                return candidate;
            }
        }
        return null;
    }

    @Override
    public void traverse(ITreeTraversor traversor) {

    }

    @Override
    public void insert(IMyTree node) {

    }

    @Override
    public boolean delete(T nodeValue) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int leaves() {
        return 0;
    }

    @Override
    public int maximumSiblings() {
        return 0;
    }

    @Override
    public int totalPathLength() {
        return 0;
    }

    @Override
    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public boolean hasParent() {
        return parent != null;
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

    private class BFSIterativeTraversor implements ITreeTraversor {
        @Override
        public void traverse() {
            traverse(MyBinaryTree.this);
        }

        private void traverse(MyBinaryTree<T> root) {
            Queue<MyBinaryTree<T>> queue = new LinkedList<>();
            queue.add(root);
            MyBinaryTree<T> head = null;
            while (!queue.isEmpty()) {
                head = queue.poll();
                print(head);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
        }
    }

    private class DFSIterativeTraversor implements ITreeTraversor {
        @Override
        public void traverse() {
            traverse(MyBinaryTree.this);
        }

        private void traverse(MyBinaryTree<T> root) {
        }
    }

    private class DFSRecursiveTraversor implements ITreeTraversor {
        @Override
        public void traverse() {
            traverse(MyBinaryTree.this);
        }

        private void traverse(MyBinaryTree<T> root) {
        }
    }

    public void addLeft(MyBinaryTree<T> left) {
        if (this.left != null) {
            throw new IllegalArgumentException("This node already has left child");
        }
        this.left = left;
    }

    public void addRight(MyBinaryTree<T> right) {
        if (this.right != null) {
            throw new IllegalArgumentException("This node already has right child");
        }
        this.right = right;
    }

    private static void print(MyBinaryTree node) {
        System.out.println(node.value);
    }
}
