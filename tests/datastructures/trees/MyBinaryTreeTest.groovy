package tests.datastructures.trees

import sources.datastructures.trees.IMyTree
import sources.datastructures.trees.MyBinaryTree

/**
 * Created by mman on 22.11.16.
 */
class MyBinaryTreeTest extends GroovyTestCase {
    
    void testMinimum() {
    
    }

    void testMaximum() {

    }

    void testSearch() {
        MyBinaryTree<Integer> root = createIntegerTree();
        MyBinaryTree<Integer> found = root.search(88);
        assert found != null;
        found.getBFSIterativeTraversor().traverse();

        found = root.search(111);
        assert found == null;
    }

    void testBFSIterativeTraversor() {
        MyBinaryTree<Integer> root = createIntegerTree();
        root.getBFSIterativeTraversor().traverse();
    }

    void testInsert() {

    }

    void testDelete() {

    }

    void testSize() {

    }

    void testLeaves() {

    }

    void testMaximumSiblings() {

    }

    void testTotalPathLength() {

    }

    void testAddLeft() {

    }

    void testAddRight() {

    }

    void testIsLeaf() {
        IMyTree<Integer> root = createIntegerTree();
        IMyTree<Integer> leaf = root.search(41);
        assertEquals(true, leaf.isLeaf());
    }

    void testHasParent() {

    }

    private static MyBinaryTree<Integer> createIntegerTree() {
        return new MyBinaryTree<>(10,
            new MyBinaryTree(25,
                new MyBinaryTree(16,
                    new MyBinaryTree(70),
                    new MyBinaryTree(24,
                        new MyBinaryTree(81,
                            new MyBinaryTree(92),
                            new MyBinaryTree(100)
                        ),
                        new MyBinaryTree(34)
                    )
                ),
                new MyBinaryTree(33,
                    new MyBinaryTree(41),
                    new MyBinaryTree(50)
                )
            ),
            new MyBinaryTree(11,
                new MyBinaryTree(27),
                new MyBinaryTree(88,
                    new MyBinaryTree(61,
                        new MyBinaryTree(58),
                        new MyBinaryTree(77)
                    ),
                    new MyBinaryTree(39)
                )
            )
        )
    }
}
