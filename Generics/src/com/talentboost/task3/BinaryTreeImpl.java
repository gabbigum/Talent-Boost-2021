package com.talentboost.task3;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeImpl {

    private Node root;
    private List<Node> tree;
    private NumberComparator numComparator;

    public BinaryTreeImpl(Number value) {
        tree = new LinkedList<>();
        root = new Node(value);
        numComparator = new NumberComparator();

        tree.add(root);
    }

    public void add(Number value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node root, Number value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        int compResult = numComparator.compare(root.getValue(), value);

        if (compResult == 1) {
            root.setLeft(addRecursive(root.getLeft(), value));
        } else if (compResult == -1) {
            root.setRight(addRecursive(root.getRight(), value));
        } else if (compResult == 0) {
            return root;
        }

        return root;
    }

    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeImpl tree = new BinaryTreeImpl(5);
        tree.add(3);
        tree.add(8);
        tree.add(11);
        tree.add(8);
        tree.add(7);
        tree.add(2);
        tree.add(1);
    }
}
