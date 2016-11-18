package sources.datastructures.trees;

/**
 * Created by mman on 16.11.16.
 */
public class MyTree<T> extends AMyTree<T> {

    public MyTree(T rootValue) {
        super(rootValue);
    }

    public MyTree(T root, MyTree<T>... children) {
        this(root);
        for (MyTree child : children) {
            this.root.addChild(child.root);
        }
    }
}
