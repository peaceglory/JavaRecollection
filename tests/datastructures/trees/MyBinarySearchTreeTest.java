package tests.datastructures.trees;

import org.testng.Assert;
import org.testng.annotations.Test;
import sources.datastructures.custom.trees.MyBinarySearchTree;
import sources.datastructures.custom.trees.TraverseStrategy;

/**
 * Created by mman on 25.11.16.
 */
public class MyBinarySearchTreeTest {

    @Test
    public void testSearch() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        MyBinarySearchTree found = (MyBinarySearchTree) tree.search(10);
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        found = null;

        found = ((MyBinarySearchTree) (tree.search(1)));
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        found = null;

        found = ((MyBinarySearchTree) (tree.search(45)));
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        found = null;

        found = ((MyBinarySearchTree) (tree.search(8)));
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        found = null;

        found = ((MyBinarySearchTree) (tree.search(70)));
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        found = null;

        found = ((MyBinarySearchTree) (tree.search(333)));
        assert found == null;
    }

    @Test
    public void testInsert() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        tree.insert(50);
        tree.traverse(TraverseStrategy.DFSRecursive);
    }

    @Test
    public void testRemove() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        assert tree.remove(7);
        tree.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        assert tree.search(7) == null;

        tree = createIntegerTree();
        assert tree.remove(33);
        tree.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        assert tree.search(33) == null;

        tree = createIntegerTree();
        assert tree.remove(88);
        tree.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        assert tree.search(88) == null;

        tree = createIntegerTree();
        assert tree.remove(45);
        tree.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        assert tree.search(45) == null;

        tree = createIntegerTree();
        assert tree.remove(90);
        tree.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        assert tree.search(90) == null;

        tree = createIntegerTree();
        assert tree.remove(10);
        tree.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        assert tree.search(10) == null;

        tree = createIntegerTree();
        assert !tree.remove(333);
        tree.traverse(TraverseStrategy.DFSRecursive);
        System.out.println("--------------------------------------");
        assert tree.search(333) == null;
    }

    @Test
    public void testMinimum() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        Assert.assertEquals(new Integer(1), new Integer(tree.minimum()));
    }

    @Test
    public void testMaximum() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        Assert.assertEquals(new Integer(150), new Integer(tree.maximum()));
    }

    @Test
    public void testSize() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        Assert.assertEquals(new Integer(19), new Integer(tree.size()));
    }

    @Test
    public void testPreOrder() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        tree.traverse(TraverseStrategy.PreOrder);
    }

    @Test
    public void testInOrder() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        tree.traverse(TraverseStrategy.InOrder);
    }

    @Test
    public void testPostOrder() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        tree.traverse(TraverseStrategy.PostOrder);
    }

    @Test
    public void testFind() {
        MyBinarySearchTree<Integer> tree = createIntegerTree();
        Assert.assertEquals(new Integer(7), new Integer(tree.find(5)));
        Assert.assertEquals(new Integer(11), new Integer(tree.find(9)));
        Assert.assertEquals(new Integer(27), new Integer(tree.find(11)));
        Assert.assertEquals(new Integer(33), new Integer(tree.find(12)));
        Assert.assertEquals(new Integer(90), new Integer(tree.find(16)));
        Assert.assertEquals(new Integer(99), new Integer(tree.find(17)));
    }

    public static MyBinarySearchTree createIntegerTree() {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(10);
        tree.insert(3).insert(15).insert(1).insert(6).insert(11).insert(45).insert(4).insert(8).insert(33).insert(88).insert(7).insert(9).insert(70).insert(100).insert(90).insert(150).insert(27).insert(99);
        return tree;
    }

}
