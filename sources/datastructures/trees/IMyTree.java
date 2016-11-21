package sources.datastructures.trees;

/**
 * Created by mman on 18.11.16.
 */
public interface IMyTree<T> {

    IMyTree<T> minimum();

    IMyTree<T> maximum();

    IMyTree<T> predecessor(T value);

    IMyTree<T> successor(T value);

    IMyTree<T> search(T value);

    void traverse(ITreeTraversor traversor);

    void insert(IMyTree<T> node);

    boolean delete(T nodeValue);

    int size();

    int leaves();

    int maximumSiblings();

    int totalPathLength();
}
