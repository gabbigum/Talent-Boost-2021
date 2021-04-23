package test.org.talentboost.ads.trees;

import main.org.talentboost.ads.trees.BinaryNode;
import main.org.talentboost.ads.trees.BinarySearchTree;
import main.org.talentboost.ads.trees.TreeUtils;

import java.util.List;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTreeTest.testInsertion();
        BinarySearchTreeTest.testGetOrderedValues(); // Bonus points: uncomment and solve
        BinarySearchTreeTest.testDeletion();
        BinarySearchTreeTest.testDeleteWithOneChild();
        BinarySearchTreeTest.testDeleteWithTwoChildren();
    }

    private static void testInsertion() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        TreeUtils.assertNode(tree.root, null);

        tree.insert(10);
        TreeUtils.assertNode(tree.root, new BinaryNode<>(10));

        // try all-left insertions
        tree.insert(5);
        tree.insert(3);
        tree.insert(1);
        TreeUtils.assertNode(tree.root.left, new BinaryNode<>(5));
        TreeUtils.assertNode(tree.root.left.left, new BinaryNode<>(3));
        TreeUtils.assertNode(tree.root.left.left.left, new BinaryNode<>(1));

        // right insertion
        tree.insert(20);
        TreeUtils.assertNode(tree.root.right, new BinaryNode<>(20));

        // insertion somewhere in the middle
        tree.insert(4);
        TreeUtils.assertNode(tree.root.left.left.right, new BinaryNode<>(4));

        // insert an existing value (should do something benign, e.g. nothing)
        tree.insert(4);

        tree.preOrder(tree.root);
    }



    private static void testGetOrderedValues() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(23);
        tree.insert(16);
        tree.insert(100);

        List<Integer> expectedList = List.of(1, 3, 5, 10, 16, 23, 100);
        List<Integer> actualList   = tree.getOrderedValues();

        TreeUtils.assertList(actualList, expectedList);
    }

    private static void testDeleteWithTwoChildren() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(10);
        tree.insert(60);
        tree.insert(80);

        tree.delete(75); // has two children
    }

    private static void testDeleteWithOneChild() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(10);
        tree.insert(60);
        tree.insert(80);

        tree.delete(25); // has one child
    }

    private static void testDeletion() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(10);
        tree.insert(60);
        tree.insert(80);

        tree.delete(10); // leaf node
        BinaryNode<Integer> expectedTreeRoot =
                new BinaryNode<>(
                        50,
                        new BinaryNode<>(25, null, null),
                        new BinaryNode<>(
                                75,
                                new BinaryNode<>(
                                        60, null, null),
                                new BinaryNode<>(80, null, null)));

        TreeUtils.assertTree(tree.root, expectedTreeRoot);

        tree.delete(75); // non-leaf node (2 children)
        expectedTreeRoot =
                new BinaryNode<>(
                        50,
                        new BinaryNode<>(25, null, null),
                        new BinaryNode<>(
                                80,
                                new BinaryNode<>(
                                        60, null, null),
                                null));
        TreeUtils.assertTree(tree.root, expectedTreeRoot);
    }
}
