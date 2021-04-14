package main.org.talentboost.ads.trees;

public class TreeHeightUtil {

    public static <T extends Comparable<T>> int getHeight(BinaryNode<T> root) {
        if (root == null) {
            return 0;
        } else {
            int maxDepthLeft = getHeight(root.left);
            int maxDepthRight = getHeight(root.right);

            return 1 + Math.max(maxDepthLeft, maxDepthRight);
        }
    }
}
