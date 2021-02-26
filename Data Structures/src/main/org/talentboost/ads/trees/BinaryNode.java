package main.org.talentboost.ads.trees;

public class BinaryNode<T extends Comparable<T>> {
    public BinaryNode(T value) {
        this.value = value;
    }

    public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(){
        this.value = null;
    }

    public T value;
    public BinaryNode<T> left = null;
    public BinaryNode<T> right = null;
}
