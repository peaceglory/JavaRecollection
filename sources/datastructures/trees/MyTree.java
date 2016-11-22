package sources.datastructures.trees;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by mman on 16.11.16.
 */
public class MyTree<T extends Comparable> extends AMyTree<T> {

    public MyTree(T rootValue) {
        super(rootValue);
    }

    public MyTree(T root, MyTree<T>... children) {
        this(root);
        for (MyTree child : children) {
            this.root.addChild(child.root);
        }
    }

    private MyTree(Node<T> root) {
        super(root);

    }

    @Override
    public IMyTree<T> search(T value) {
        Node<T> found = root.search(value);
        if (found != null) {
            IMyTree<T> subtree = new MyTree(found);
            return subtree;
        }
        return null;
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
    public boolean isLeaf() {
        return root.isLeaf();
    }

    @Override
    public boolean hasParent() {
        return root.hasParent();
    }
}
