package sources.datastructures.trees;

/**
 * Created by mman on 25.11.16.
 */
public class MyBinarySearchTree<T extends Comparable> extends MyBinaryTree<T> {

    public MyBinarySearchTree(T value) {
        super(value);
    }

    @Override
    public IMyTree search(T value) {
        if (this.value.compareTo(value) == 0) {
            return this;
        }
        if (this.value.compareTo(value) > 0) {
            if (left != null) {
                return left.search(value);
            }
            return null; // Not found.
        }
        if (right != null) {
            return right.search(value);
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
    public boolean delete(T value) {
        return false;
    }
}
