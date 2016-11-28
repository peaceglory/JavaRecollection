package tests.datastructures.trees

import sources.datastructures.trees.AMyTree
import sources.datastructures.trees.IMyTree
import sources.datastructures.trees.MyTree
import sources.datastructures.trees.TraverseStrategy

/**
 * Created by mman on 18.11.16.
 */
class MyTreeTest extends GroovyTestCase {

    void testBFSIterativeTraversor() {
        IMyTree<String> stringTree = createStringTree();
        stringTree.traverse(TraverseStrategy.BFSIterative);
    }

    void testDFSIterativeTraversor() {
        IMyTree<String> stringTree = createStringTree();
        stringTree.traverse(TraverseStrategy.DFSIterative);
    }

    void testDFSRecursiveTraversor() {
        IMyTree<Integer> tree = createTree();
        tree.traverse(TraverseStrategy.DFSRecursive);

        IMyTree<String> stringTree = createStringTree();
        stringTree.traverse(TraverseStrategy.DFSRecursive);
    }

    void testSize() {
        IMyTree<Integer> tree = createTree();
        assertEquals(16, tree.size());
    }

    void testLeaves() {
        IMyTree<Integer> tree = createTree();
        assertEquals(7, tree.leaves());
    }

    void testMaximumSiblings() {
        IMyTree<Integer> tree = createTree2();
        assertEquals(4, tree.maximumSiblings());
    }

    void testTotalPathLength() {
        IMyTree<Integer> tree = createTree2();
        assertEquals(50, tree.totalPathLength());
    }

    void testMinimum() {
        IMyTree<Integer> tree = createTree2();
        assertEquals(4, tree.minimum());

        IMyTree<String> tree2 = createStringTree();
        assertEquals("A", tree2.minimum());
    }

    void testMaximum() {
        IMyTree<Integer> tree = createTree2();
        assertEquals(144, tree.maximum());

        IMyTree<String> tree2 = createStringTree();
        assertEquals("Z", tree2.maximum());
    }

    void testSearch() {
        IMyTree<Integer> tree = createTree2();
        AMyTree<Integer> subtree = tree.search(51);
        assert subtree != null;
        subtree.traverse(TraverseStrategy.DFSRecursive);

        subtree = tree.search(55);
        assert subtree == null;

        IMyTree<String> tree2 = createStringTree();
        AMyTree<String> subtree2 = tree2.search("C");
        assert subtree2 != null;
        subtree2.traverse(TraverseStrategy.DFSRecursive);

        subtree2 = tree2.search("Y");
        assert subtree2 == null;
    }

    void testHeight() {
        IMyTree<Integer> tree = createTree2();
        assert tree.height() == 6;
    }

    private static AMyTree<Integer> createTree() {
        return new MyTree<>(42,
                new MyTree(16,
                        new MyTree(8,
                                new MyTree(24),
                                new MyTree(18),
                                new MyTree(15)
                        )
                ),
                new MyTree(100,
                        new MyTree(33,
                                new MyTree(12,
                                        new MyTree(10)
                                ),
                                new MyTree(11)
                        )
                ),
                new MyTree(9,
                        new MyTree(51,
                                new MyTree(56),
                                new MyTree(66,
                                        new MyTree(74)
                                )
                        )
                )
        );
    }

    private static AMyTree<Integer> createTree2() {
        return new MyTree<>(42,
                new MyTree(16,
                        new MyTree(8,
                                new MyTree(24),
                                new MyTree(18,
                                    new MyTree(99)
                                ),
                                new MyTree(15)
                        )
                ),
                new MyTree(100,
                        new MyTree(33,
                                new MyTree(12,
                                        new MyTree(10)
                                ),
                                new MyTree(11)
                        )
                ),
                new MyTree(9,
                        new MyTree(51,
                                new MyTree(56),
                                new MyTree(66,
                                        new MyTree(74,
                                            new MyTree(4), new MyTree(14), new MyTree(44), new MyTree(144),
                                        )
                                )
                        )
                )
        );
    }

    private static AMyTree<String> createStringTree() {
        return new MyTree<>("R",
                new MyTree("A",
                    new MyTree("C",
                        new MyTree("K"),
                        new MyTree("X"),
                        new MyTree("E"),
                        new MyTree("Q",
                            new MyTree("D")
                        )
                    ),
                    new MyTree("Z")
                ),
                new MyTree("F",
                    new MyTree("W",
                        new MyTree("B",
                            new MyTree("G")
                        ),
                    ),
                    new MyTree("N")
                ),
                new MyTree("H",
                    new MyTree("L",
                        new MyTree("J",
                            new MyTree("O"),
                            new MyTree("S"),
                            new MyTree("P",
                                new MyTree("I")
                            )
                        )
                    )
                )
        );
    }
}
