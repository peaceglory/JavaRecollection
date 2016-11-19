package tests.datastructures.trees

import sources.datastructures.trees.AMyTree
import sources.datastructures.trees.IMyTree
import sources.datastructures.trees.MyTree
/**
 * Created by mman on 18.11.16.
 */
class MyTreeTest extends GroovyTestCase {

    void testDFSRecursiveTraversor() {
        IMyTree<Integer> tree = createTree();
        tree.getDFSRecursiveTraversor().traverse();
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
}
