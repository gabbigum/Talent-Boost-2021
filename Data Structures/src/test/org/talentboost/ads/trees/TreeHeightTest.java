package test.org.talentboost.ads.trees;


import main.org.talentboost.ads.trees.BinaryNode;
import main.org.talentboost.ads.trees.TreeHeightUtil;

public class TreeHeightTest {
    public static void main(String[] args) {
        // 0-node case
        assertValue(1, TreeHeightUtil.getHeight(new BinaryNode<Integer>(0)));

        // sample tree case
        BinaryNode<Integer> sampleTreeRoot =
                new BinaryNode<>(
                        50,
                        new BinaryNode<>(25, null, null),
                        new BinaryNode<>(
                                75,
                                new BinaryNode<>(
                                        60, null, null),
                                new BinaryNode<>(80, null, null)));

        TreeHeightUtil.getHeight(sampleTreeRoot);
        assertValue(TreeHeightUtil.getHeight(sampleTreeRoot), 3);
    }

    private static void assertValue(int expected, int actual) {
        if (expected != actual) {
            throw new IllegalStateException("Expected: " + expected + ", but got" + actual + ".");
        }
    }
}
