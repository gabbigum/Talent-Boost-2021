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
            throw new NullPointerException();
        }

        //    5
        //   / \
        //  4   7
        //     / \
        //    6   8
        //
        // when I want to delete root node -> find smallest leaf -> make it root -> delete the leaf - (mirror the action)

        return root;
    }

    public BinaryNode<T> search(T value) {
        return new BinaryNode<>();
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
