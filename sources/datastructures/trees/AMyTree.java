package sources.datastructures.trees;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

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
        traversor.traverse(this);
    }

    @Override
    public void insert(IMyTree<T> node) {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(T nodeValue) {
        throw new NotImplementedException();
    }

    protected static class Node<T> {
        protected T value = null;
        protected Node<T> parent = null;
        protected List<Node<T>> children = new ArrayList<>();

        protected Node(T value) {
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

        protected boolean hasParent() {
            return parent != null;
        }
    }
}
