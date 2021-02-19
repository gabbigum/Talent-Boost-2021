package com.talentboost.linkedlist;

public class Node {

    private int item;
    private Node next;
    private Node prev;

    public Node(int item) {
        this.item = item;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getItem() {
        return item;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }
}
