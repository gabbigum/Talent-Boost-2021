package main.org.talentboost.ads.trees;

import java.util.List;

public class TreeUtils {
    public static <T extends Comparable<T>> void assertNode(BinaryNode<T> actual, BinaryNode<T> expected) {
        if (actual == null && expected == null) {
            return; // correct
        }
        else if (actual == null) {
            throw new IllegalStateException("Node is null, expected non-null with value ["+expected.value+"]");
        }
        else if (expected == null) {
            throw new IllegalStateException("Node is non-null, expected null");
        }
        else if (actual.value.compareTo(expected.value) != 0) {
            throw new IllegalStateException("Node contains ["+actual.value+"], expected ["+expected.value+"]");
        }
    }

    public static <T extends Comparable<T>> void assertList(List<T> actual, List<T> expected) {
        if (expected.size() != actual.size()) {
            throw new IllegalStateException("Sizes differ: expected: "+expected.size()+", Actual: "+actual.size());
        }
        else {
            for (int i = 0 ; i < expected.size() ; i++) {
                if (!expected.get(i).equals(actual.get(i))) {
                    throw new IllegalStateException("Values differ at index: "+i+". Expected: "+expected.get(i)
                            +". Actual: "+actual.get(i)+".");
                }
            }
        }
    }

    public static <T extends Comparable<T>> void assertTree(BinaryNode<T> actualRoot, BinaryNode<T> expectedRoot) {
        if (!TreeUtils.assertTreeRec(actualRoot, expectedRoot)) {
            throw new IllegalStateException("Trees do not equal.");
        }
    }

    private static <T extends Comparable<T>> boolean assertTreeRec(BinaryNode<T> actualRoot, BinaryNode<T> expectedRoot) {
        if (actualRoot == null && expectedRoot == null) {
            return true;
        }
        else if (actualRoot == null || expectedRoot == null) {
            return false;
        }
        else {
            return actualRoot.value == expectedRoot.value &&
                    assertTreeRec(actualRoot.left, expectedRoot.left) &&
                    assertTreeRec(actualRoot.right, expectedRoot.right);
        }
    }
}
