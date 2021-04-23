package main.org.talentboost.ads.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinarySearchTree<T extends Comparable<T>> {

    public BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T value) {
        root = insertRec(root, value);
    }

    private BinaryNode<T> insertRec(BinaryNode<T> root, T value) {
        if (root == null) {
            return new BinaryNode<>(value);
        }

        int comparison = root.value.compareTo(value);

        if (comparison > 0) {
            root.left = insertRec(root.left, value);
        } else if (comparison < 0) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void delete(T value) {
        root = deleteRec(root, value);
    }

    private BinaryNode<T> deleteRec(BinaryNode<T> root, T value) {
        if (root == null) {
            return null;
        } else if (value.compareTo(root.value) < 0) {
            root.left = deleteRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = deleteRec(root.right, value);
        } else {
            // case 1: no child
            if(root.left == null && root.right == null) {
                root = null;
                return root;
            }
            // case 2: 1 child
            if(root.left == null) {
                root.value = root.right.value;
                root.right = null;
            } else if(root.right == null) {
                root.value = root.left.value;
                root.left = null;
            } else {
                T temp = minValue(root.right);
                root.value = temp;
                root.right = deleteRec(root.right, temp);
            }
        }

        return root;
    }

    private T minValue(BinaryNode<T> root) {
        T minv = root.value;
        while(root.left != null) {
            minv = minValue(root.left);
            root = root.left;
        }
        return minv;
    }

    public BinaryNode<T> search(T value) {
        if(this.root == null || this.root.value.equals(value)) {
            return null;
        } else return recSearch(this.root, value);
    }

    private BinaryNode<T> recSearch(BinaryNode<T> root, T value) {
        if(root == null || this.root.value.equals(value)) {
            return null;
        } else if(root.value.equals(value)) {
            return root;
        } else if (value.compareTo(root.value) < 0) {
            return recSearch(root.left, value);
        } else {
            return recSearch(root.right, value);
        }

    }

    public void preOrder(BinaryNode<T> root) {
        if(root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(BinaryNode<T> root) {
        if(root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }


    private void inOrder(BinaryNode<T> root, List<T> list) {
        if(root == null) {
            return;
        }

        inOrder(root.left, list);
        System.out.println(root.value);
        list.add(root.value);
        inOrder(root.right, list);
    }


    public List<T> getOrderedValues() {
        List<T> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }
}
