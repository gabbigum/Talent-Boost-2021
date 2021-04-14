package com.talentboost.task3;

public class Node<T> {

    private Node left;
    private Node right;

    private Number value;

    public Node(Number value) {
        this.value = value;
    }

    public Number getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
