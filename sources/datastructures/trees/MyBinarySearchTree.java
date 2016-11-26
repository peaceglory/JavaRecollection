package sources.datastructures.trees;

/**
 * Created by mman on 25.11.16.
 */
public class MyBinarySearchTree<T extends Comparable> extends MyBinaryTree<T> {

    public MyBinarySearchTree(T value) {
        super(value);
    }

    @Override
    public T minimum() {
        MyBinaryTree current = this;
        while (current.left != null) {
            current = current.left;
        }
        return (T) current.value;
    }

    @Override
    public T maximum() {
        MyBinaryTree current = this;
        while (current.right != null) {
            current = current.right;
        }
        return (T) current.value;
    }

    @Override
    public IMyTree search(T value) {
        MyBinaryTree current = this;
        while (current != null) {
            if (current.value.compareTo(value) == 0) {
                return current;
            }
            if (current.value.compareTo(value) > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    @Override
    public IMyTree insert(T value) {
        if (this.value.compareTo(value) > 0) {
            if (left == null) {
                left = new MyBinarySearchTree<>(value);
                left.parent = this;
            } else {
                left.insert(value);
            }
        } else if (this.value.compareTo(value) < 0) {
            if (right == null) {
                right = new MyBinarySearchTree<>(value);
                right.parent = this;
            } else {
                right.insert(value);
            }
        }
        return this;
    }

    @Override
    public boolean remove(T value) {
        MyBinarySearchTree node = (MyBinarySearchTree) search(value);
        if (node == null) {
            return false;
        }

        if (node.isLeaf()) {
            if (node.parent == null) {
                return true; // Nothing to remove - it's a root leaf.
            }
            if (node.value.compareTo(node.parent.value) < 0) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
            node.parent = null;
        } else if ((node.left != null && node.right == null)
                || (node.left == null && node.right != null)) { // Has one child
            MyBinaryTree theOnlyChild = (node.left != null ? node.left : node.right);
            if (node.value.compareTo(node.parent.value) < 0) {
                node.parent.left = theOnlyChild;
            } else {
                node.parent.right = theOnlyChild;
            }
            theOnlyChild.parent = node.parent;
            node.parent = null;
            node.left = null;
            node.right = null;
        } else { // Has two children
            MyBinarySearchTree nextLarger = (MyBinarySearchTree) node.right.search(node.right.minimum());
            T tmp = (T) node.value;
            node.value = nextLarger.value;
            nextLarger.value = tmp;
            return nextLarger.remove((T) nextLarger.value);
        }

        return true;
    }
}
