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

    void testDelete() {

    }

    public static MyBinarySearchTree createIntegerTree() {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(10);
        tree.insert(3).insert(15).insert(1).insert(6).insert(11).insert(45).insert(4).insert(8).insert(33).insert(88)
                .insert(7).insert(9).insert(70).insert(100).insert(99).insert(150)
        return tree;
    }
}
