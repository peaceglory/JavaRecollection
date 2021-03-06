package datastructures.custom.trees;

/**
 * Created by mman on 18.11.16.
 */
public interface IMyTree<T> {

    T minimum();

    T maximum();

    IMyTree<T> search(T value);

    void traverse(TraverseStrategy strategy);

    IMyTree<T> insert(T value);

    boolean remove(T value);

    boolean isLeaf();

    boolean hasParent();

    int size();

    int leaves();

    int maximumSiblings();

    int totalPathLength();

    int height();

    boolean isBalanced();
}
