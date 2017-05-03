package datastructures.custom.trees;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mman on 22.11.16.
 */
public class MyBinaryTree<T extends Comparable> implements IMyTree<T> {
    protected T value = null;
    protected MyBinaryTree<T> parent = null;
    protected MyBinaryTree<T> left = null;
    protected MyBinaryTree<T> right = null;

    public MyBinaryTree(T value) {
        this.value = value;
    }

    public MyBinaryTree(T value, MyBinaryTree<T> left, MyBinaryTree<T> right) {
        this(value);
        this.left = left;
        if (this.left != null) {
            this.left.parent = this;
        }
        this.right = right;
        if (this.right != null) {
            this.right.parent = this;
        }
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
        if (this.isLeaf()) {
            return value;
        }
        T max = value;
        T candidate = null;

        if (left != null) {
            candidate = left.maximum();
            if (max.compareTo(candidate) < 0) {
                max = candidate;
            }
        }
        if (right != null) {
            candidate = right.maximum();
            if (max.compareTo(candidate) < 0) {
                max = candidate;
            }
        }
        return max;
    }

    @Override
    public IMyTree search(T value) {
        if (this.value.compareTo(value) == 0) {
            return this;
        }
        IMyTree<T> candidate = null;
        if (left != null) {
            candidate = left.search(value);
            if (candidate != null) {
                return candidate;
            }
        }
        if (right != null) {
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
            traverseDFSIterative();
        } else if (TraverseStrategy.DFSRecursive == strategy) {
            traverseDFSRecursive();
        } else if (TraverseStrategy.BFSIterative == strategy) {
            traverseBFSIterative();
        } else if (TraverseStrategy.PreOrder == strategy) {
            traversePreOrder();
        } else if (TraverseStrategy.InOrder == strategy) {
            traverseInOrder();
        } else if (TraverseStrategy.PostOrder == strategy) {
            traversePostOrder();
        }
    }

    protected void traversePostOrder() {
        throw new NotImplementedException();
    }

    protected void traverseInOrder() {
        throw new NotImplementedException();
    }

    protected void traversePreOrder() {
        throw new NotImplementedException();
    }

    protected void traverseDFSRecursive() {
        print(this);
        if (left != null) {
            left.traverseDFSRecursive();
        }
        if (right != null) {
            right.traverseDFSRecursive();
        }
    }

    protected void traverseBFSIterative() {
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

    protected void traverseDFSIterative() {
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
    public IMyTree insert(T value) {
        throw new NotImplementedException();
    }

    @Override
    public boolean remove(T value) {
        throw new NotImplementedException();
    }

    @Override
    public int size() {
        if (this.isLeaf()) {
            return 1;
        }
        int size = 1;
        if (left != null) {
            size += left.size();
        }
        if (right != null) {
            size += right.size();
        }
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
            return 1;
        }
        return 1 + Math.max(left.height(), right.height());
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(this) > -1;
    }

    private int isBalanced(MyBinaryTree<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = isBalanced(node.left);
        if (leftHeight < 0) {
            return -1;
        }

        int rightHeight = isBalanced(node.right);
        if (rightHeight < 0) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
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

    public double calculateExpression() {
        if (this.value == null || !(this.value instanceof String)) {
            throw new IllegalArgumentException("Leaf value must be not-null string representing a number!");
        }
        String strValue = this.value.toString();

        if (this.isLeaf()) {
            if (!isNumeric(strValue)) {
                throw new IllegalArgumentException("Leaf value must be not-null string representing a number!");
            }
            return Double.parseDouble(strValue);
        }

        double leftRes = left.calculateExpression();
        double rightRes = right.calculateExpression();
        switch (strValue) {
            case "+":
                return leftRes + rightRes;
            case "-":
                return leftRes - rightRes;
            case "*":
                return leftRes * rightRes;
            default:
                throw new IllegalArgumentException("Node value must be +, - or *");
        }
    }

    public void swapChildren() {
        if (this.isLeaf()) {
            return;
        }
        MyBinaryTree tmp = left;
        left = right;
        right = tmp;
        left.swapChildren();
        right.swapChildren();
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

    public static void print(MyBinaryTree node) {
        System.out.println(node.value);
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("4"));
        System.out.println(isNumeric("k"));
        System.out.println(isNumeric("8.9"));
        System.out.println(isNumeric("->"));
        System.out.println(isNumeric("0.34"));
        System.out.println(isNumeric("50.76534"));

        AMyTree tr = new MyTree(10);
        tr.root.isLeaf(); // See, protected fields can be accessed by other classes in the package.
    }
}
