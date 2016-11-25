package tests.datastructures.trees

import sources.datastructures.trees.MyBinaryTree
import sources.datastructures.trees.TraverseStrategy

/**
 * Created by mman on 22.11.16.
 */
class MyBinaryTreeTest extends GroovyTestCase {
    
    void testMinimum() {
        MyBinaryTree<Integer> root = createIntegerTree();
        assertEquals(10, root.minimum());
    }

    void testMaximum() {
        MyBinaryTree<Integer> root = createIntegerTree();
        assertEquals(100, root.maximum());
    }

    void testSearch() {
        MyBinaryTree<Integer> root = createIntegerTree();
        MyBinaryTree<Integer> found = root.search(88);
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);

        found = root.search(111);
        assert found == null;
    }

    void testBFSIterativeTraversor() {
        MyBinaryTree<Integer> root = createIntegerTree();
        root.traverse(TraverseStrategy.BFSIterative);
    }

    void testDFSIterativeTraversor() {
        MyBinaryTree<Integer> root = createIntegerTree();
        root.traverse(TraverseStrategy.DFSIterative);
    }

    void testDFSRecursiveTraversor() {
        MyBinaryTree<Integer> root = createIntegerTree();
        root.traverse(TraverseStrategy.DFSRecursive);
    }

    void testInsert() {

    }

    void testDelete() {

    }

    void testSize() {
        MyBinaryTree<Integer> root = createIntegerTree();
        assertEquals(19, root.size());
    }

    void testLeaves() {
        MyBinaryTree<Integer> root = createIntegerTree();
        assertEquals(10, root.leaves());
    }

    void testMaximumSiblings() {
        MyBinaryTree<Integer> root = createIntegerTree();
        assertEquals(2, root.maximumSiblings());
    }

    void testTotalPathLength() {
        MyBinaryTree<Integer> root = createIntegerTree();
        assertEquals(46, root.totalPathLength());
    }

    void testAddLeft() {

    }

    void testAddRight() {

    }

    void testIsLeaf() {
        MyBinaryTree<Integer> root = createIntegerTree();
        MyBinaryTree<Integer> node = root.search(41);
        assertTrue(node.isLeaf());

        node = root.search(88);
        assertFalse(node.isLeaf());
    }

    void testHasParent() {
        MyBinaryTree<Integer> root = createIntegerTree();
        MyBinaryTree<Integer> node = root.search(41);
        assertTrue(node.hasParent());

        node = root.search(10);
        assertFalse(node.hasParent());
    }

    void testHeight() {
        MyBinaryTree<Integer> root = createIntegerTree();
        assertEquals(6, root.height());
    }

    void testExpressionTree() {
        MyBinaryTree<String> expressionTree =
                new MyBinaryTree<>("*",
                    new MyBinaryTree<String>("+",
                        new MyBinaryTree<String>("3"),
                        new MyBinaryTree<String>("4")
                    ),
                    new MyBinaryTree<String>("5")
                ); // (3+4) * 5

        assertEquals(35, expressionTree.calculateExpression());
    }

    public static MyBinaryTree<Integer> createIntegerTree() {
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
