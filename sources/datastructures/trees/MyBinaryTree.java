package sources.datastructures.trees;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mman on 22.11.16.
 */
public class MyBinaryTree<T extends Comparable> implements IMyTree<T> {
    private T value = null;
    private MyBinaryTree<T> parent = null;
    private MyBinaryTree<T> left = null;
    private MyBinaryTree<T> right = null;
    private int size = -1;

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
        T candidate = left.minimum();
        if (min.compareTo(candidate) > 0) {
            min = candidate;
        }
        candidate = right.minimum();
        if (min.compareTo(candidate) > 0) {
            min = candidate;
        }
        return min;
    }

    @Override
    public T maximum() {
        if (this.isLeaf()) {
            return value;
        }
        T max = value;
        T candidate = left.maximum();
        if (max.compareTo(candidate) < 0) {
            max = candidate;
        }
        candidate = right.maximum();
        if (max.compareTo(candidate) < 0) {
            max = candidate;
        }
        return max;
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
    public void traverse(TraverseStrategy strategy) {
        if (TraverseStrategy.DFSIterative == strategy) {
            traverseDSFIterative();
        } else if (TraverseStrategy.DFSRecursive == strategy) {
            traverseDSFRecursive();
        } else if (TraverseStrategy.BFSIterative == strategy) {
            traverseBSFIterative();
        }
    }

    private void traverseDSFRecursive() {
        print(this);
        if (isLeaf()) {
            return;
        }
        left.traverseDSFRecursive();
        right.traverseDSFRecursive();
    }

    private void traverseBSFIterative() {
        Queue<MyBinaryTree<T>> queue = new LinkedList<>();
        queue.add(this);
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

    private void traverseDSFIterative() {
        Stack<MyBinaryTree<T>> stack = new Stack<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            MyBinaryTree<T> top = stack.pop();
            print(top);
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
        }
    }

    @Override
    public void insert(IMyTree node) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(T nodeValue) {
        throw new NotImplementedException();
    }

    @Override
    public int size() {
        if (this.size > -1) { // It's been computed already.
            return this.size;
        }
        // Compute size.
        if (this.isLeaf()) {
            return 1;
        }
        int size = 1;
        size += left.size();
        size += right.size();
        this.size = size;
        return size;
    }

    @Override
    public int leaves() {
        if (this.isLeaf()) {
            return 1;
        }
        int leaves = 0;
        leaves += left.leaves();
        leaves += right.leaves();
        return leaves;
    }

    @Override
    public int height() {
        if (this.isLeaf()) {
            int height = 1;
            MyBinaryTree current = this;
            while (current.hasParent()) {
                current = current.parent;
                height++;
            }
            return height;
        }
        return Math.max(left.height(), right.height());
    }

    @Override
    public int maximumSiblings() {
        return 2; // It's a binary tree.
    }

    @Override
    public int totalPathLength() {
        if (this.isLeaf()) {
            int pathLength = 1;
            MyBinaryTree current = this;
            while (current.hasParent()) {
                current = current.parent;
                pathLength++;
            }
            return pathLength;
        }
        int totalPathLength = left.totalPathLength();
        totalPathLength += right.totalPathLength();
        return totalPathLength;
    }

    @Override
    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public boolean hasParent() {
        return parent != null;
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
