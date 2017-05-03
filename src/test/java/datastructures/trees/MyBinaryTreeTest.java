package datastructures.trees;

import org.testng.Assert;
import org.testng.annotations.Test;
import datastructures.custom.trees.MyBinaryTree;
import datastructures.custom.trees.TraverseStrategy;

/**
 * Created by mman on 22.11.16.
 */
public class MyBinaryTreeTest  {

    @Test
    public void testMinimum() {
        MyBinaryTree<Integer> root = createIntegerTree();
        Assert.assertEquals(new Integer(10), new Integer(root.minimum()));
    }

    @Test
    public void testMaximum() {
        MyBinaryTree<Integer> root = createIntegerTree();
        Assert.assertEquals(new Integer(100), new Integer(root.maximum()));
    }

    @Test
    public void testSearch() {
        MyBinaryTree<Integer> root = createIntegerTree();
        MyBinaryTree<Integer> found = (MyBinaryTree<Integer>) root.search(88);
        assert found != null;
        found.traverse(TraverseStrategy.DFSRecursive);

        found = ((MyBinaryTree<Integer>) (root.search(111)));
        assert found == null;
    }

    @Test
    public void testBFSIterativeTraversor() {
        MyBinaryTree<Integer> root = createIntegerTree();
        root.traverse(TraverseStrategy.BFSIterative);
    }

    @Test
    public void testDFSIterativeTraversor() {
        MyBinaryTree<Integer> root = createIntegerTree();
        root.traverse(TraverseStrategy.DFSIterative);
    }

    @Test
    public void testDFSRecursiveTraversor() {
        MyBinaryTree<Integer> root = createIntegerTree();
        root.traverse(TraverseStrategy.DFSRecursive);
    }

    @Test
    public void testInsert() {

    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testSize() {
        MyBinaryTree<Integer> root = createIntegerTree();
        Assert.assertEquals(new Integer(19), new Integer(root.size()));
    }

    @Test
    public void testLeaves() {
        MyBinaryTree<Integer> root = createIntegerTree();
        Assert.assertEquals(new Integer(10), new Integer(root.leaves()));
    }

    @Test
    public void testMaximumSiblings() {
        MyBinaryTree<Integer> root = createIntegerTree();
        Assert.assertEquals(new Integer(2), new Integer(root.maximumSiblings()));
    }

    @Test
    public void testTotalPathLength() {
        MyBinaryTree<Integer> root = createIntegerTree();
        Assert.assertEquals(new Integer(46), new Integer(root.totalPathLength()));
    }

    @Test
    public void testAddLeft() {

    }

    @Test
    public void testAddRight() {

    }

    @Test
    public void testIsLeaf() {
        MyBinaryTree<Integer> root = createIntegerTree();
        MyBinaryTree<Integer> node = (MyBinaryTree<Integer>) root.search(41);
        Assert.assertTrue(node.isLeaf());

        node = ((MyBinaryTree<Integer>) (root.search(88)));
        Assert.assertFalse(node.isLeaf());
    }

    @Test
    public void testHasParent() {
        MyBinaryTree<Integer> root = createIntegerTree();
        MyBinaryTree<Integer> node = (MyBinaryTree<Integer>) root.search(41);
        Assert.assertTrue(node.hasParent());

        node = ((MyBinaryTree<Integer>) (root.search(10)));
        Assert.assertFalse(node.hasParent());
    }

    @Test
    public void testHeight() {
        MyBinaryTree<Integer> root = createIntegerTree();
        Assert.assertEquals(new Integer(6), new Integer(root.height()));
    }

    @Test
    public void testExpressionTree() {
        MyBinaryTree<String> expressionTree = new MyBinaryTree<>("*", new MyBinaryTree<String>("+", new MyBinaryTree<String>("3"), new MyBinaryTree<String>("4")), new MyBinaryTree<String>("5"));// (3+4) * 5

        Assert.assertEquals(new Double(35), expressionTree.calculateExpression());
    }

    @Test
    public void testSwapChildren() {
        MyBinaryTree<Integer> root = createIntegerTree();
        root.swapChildren();
        root.traverse(TraverseStrategy.BFSIterative);
    }

    @Test
    public void testIsBalanced() {
        MyBinaryTree<Integer> balanced = createBalancedTree();
        MyBinaryTree<Integer> unBalanced = createUnbalancedTree();

        Assert.assertTrue(balanced.isBalanced());
        Assert.assertFalse(unBalanced.isBalanced());
    }

    private static MyBinaryTree<Integer> createIntegerTree() {
        return new MyBinaryTree(10,
                    new MyBinaryTree(25,
                        new MyBinaryTree(16,
                                new MyBinaryTree(70),
                                new MyBinaryTree(24,
                                        new MyBinaryTree(81,
                                                new MyBinaryTree(92),
                                                new MyBinaryTree(100)),
                                        new MyBinaryTree(34))),
                            new MyBinaryTree(33,
                                    new MyBinaryTree(41),
                                    new MyBinaryTree(50))),
                new MyBinaryTree(11,
                        new MyBinaryTree(27),
                        new MyBinaryTree(88,
                                new MyBinaryTree(61,
                                        new MyBinaryTree(58),
                                        new MyBinaryTree(77)),
                                new MyBinaryTree(39))));
    }

    private static MyBinaryTree<Integer> createBalancedTree() {
        return new MyBinaryTree(10,
                new MyBinaryTree(25,
                        new MyBinaryTree(16,
                                null,
                                new MyBinaryTree(33)
                        ),
                        new MyBinaryTree(26)
                ),
                new MyBinaryTree(40,
                        new MyBinaryTree(41),
                        null
                )
        );
    }

    private static MyBinaryTree<Integer> createUnbalancedTree() {
        return new MyBinaryTree(10,
                    new MyBinaryTree(25,
                            new MyBinaryTree(16,
                                    null,
                                    new MyBinaryTree(33)
                            ),
                            null
                    ),
                    null
              );
    }

}
