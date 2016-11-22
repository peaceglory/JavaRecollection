package sources.datastructures.trees;

/**
 * Created by mman on 18.11.16.
 */
public interface IMyTree<T> {

    T minimum();

    T maximum();

    IMyTree<T> search(T value);

    void traverse(ITreeTraversor traversor);

    void insert(IMyTree<T> node);

    boolean delete(T nodeValue);

    boolean isLeaf();

    boolean hasParent();

    int size();

    int leaves();

    int maximumSiblings();

    int totalPathLength();
}
