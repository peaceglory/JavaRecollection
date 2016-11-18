package tests.datastructures.trees

import sources.datastructures.trees.IMyTree
import sources.datastructures.trees.MyTree
/**
 * Created by mman on 18.11.16.
 */
class MyTreeTest extends GroovyTestCase {

    void testTraverse() {
        IMyTree<Integer> tree = new MyTree<>(42,
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

        tree.getDFSRecursiveTraversor().traverse();
    }
}
