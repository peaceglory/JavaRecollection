package tests.datastructures.trees

import sources.datastructures.trees.MyBinarySearchTree
import sources.datastructures.trees.TraverseStrategy

/**
 * Created by mman on 25.11.16.
 */
class MyBinarySearchTreeTest extends GroovyTestCase {

    void testSearch() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        MyBinarySearchTree found = tree.search(10);
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        found = null;

        found = tree.search(1);
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        found = null;

        found = tree.search(45);
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        found = null;

        found = tree.search(8);
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        found = null;

        found = tree.search(70);
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        found = null;

        found = tree.search(333);
        assert found == null;
    }

    void testInsert() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        tree.insert(50);
        tree.traverse(TraverseStrategy.DFSRecursive);
    }

    void testRemove() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        assert tree.remove(7);
        tree.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        assert tree.search(7) == null;

        tree = createIntegerTree();
        assert tree.remove(33);
        tree.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        assert tree.search(33) == null;

        tree = createIntegerTree();
        assert tree.remove(88);
        tree.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        assert tree.search(88) == null;

        tree = createIntegerTree();
        assert tree.remove(45);
        tree.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        assert tree.search(45) == null;

        tree = createIntegerTree();
        assert tree.remove(90);
        tree.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        assert tree.search(90) == null;

        tree = createIntegerTree();
        assert tree.remove(10);
        tree.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        assert tree.search(10) == null;

        tree = createIntegerTree();
        assert !tree.remove(333);
        tree.traverse(TraverseStrategy.DFSRecursive);
        println "--------------------------------------"
        assert tree.search(333) == null;
    }

    void testMinimum() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        assertEquals(1, tree.minimum());
    }

    void testMaximum() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        assertEquals(150, tree.maximum());
    }

    void testSize() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        assertEquals(19, tree.size());
    }

    void testPreOrder() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        tree.traverse(TraverseStrategy.PreOrder);
    }

    void testInOrder() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        tree.traverse(TraverseStrategy.InOrder);
    }

    void testPostOrder() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        tree.traverse(TraverseStrategy.PostOrder);
    }

    void testFind() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        assertEquals(7, tree.find(5));
        assertEquals(11, tree.find(9));
        assertEquals(27, tree.find(11));
        assertEquals(33, tree.find(12));
        assertEquals(90, tree.find(16));
        assertEquals(99, tree.find(17));
    }

    public static MyBinarySearchTree createIntegerTree() {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(10);
        tree.insert(3).insert(15).insert(1).insert(6).insert(11).insert(45).insert(4).insert(8).insert(33).insert(88)
                .insert(7).insert(9).insert(70).insert(100).insert(90).insert(150).insert(27).insert(99);
        return tree;
    }
}
