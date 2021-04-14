package main.org.talentboost.ads.lists;

public class NodeUtils<T> {

    /**
     * Implement a class NodeUtils in package org.talentboost.ads.lists.
     * This is a utility class that executes operations onto a Node<T> (which represents a LinkedList).
     * It should have methods for:
     * - Inserting a value onto a given index of the list
     * - Pushing a value to the end of the list
     * - Delete an element with a given value from the list
     * <p>
     * - Getting the size of the list
     * - there might be a problem with the positions
     * <p>
     * - complete the implementation and test
     */

    private Node<T> head;
    private int size;

    public NodeUtils(Node<T> head) {
        this.head = head;
    }

    public static <T> Node<T> insert(Node<T> head, T value, int position) {
        Node<T> iterator = head;
        Node<T> prevNode = null;

        Node<T> newNode = new Node<>();
        newNode.value = value;

        int currentPos = 1;

        while (iterator != null) {
            prevNode = iterator;
            iterator = iterator.next;
            if (currentPos == position) {
                newNode.next = prevNode.next;
                prevNode.next = newNode;
                break;
            }
            currentPos++;
        }

        return head;
    }

    public static <T> Node<T> push(Node<T> head, T value) {
        Node<T> iterator = head;

        Node<T> newNode = new Node<>();
        newNode.value = value;

        while (iterator.next != null) {
            iterator = iterator.next;
        }

        iterator.next = newNode;
        return head;
    }

    public static <T> Node<T> delete(Node<T> head, int position) {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        Node<T> iterator = head;

        int currentPos = 1;

        while (iterator != null) {
            if (position == currentPos) {
                iterator.next = iterator.next.next;
            }
            iterator = iterator.next;
            currentPos++;
        }
        return head;
    }


    public static <T> int size(Node<T> head) {
        int size = 0; // it might be a good idea to keep the size in object variable

        Node<T> iterator = head;

        while (iterator.next != null) {
            size++;
            iterator = iterator.next;
        }
        return size;
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>();
        head.value = 5;
        push(head, 10);
        push(head, 20);
        push(head, 25);
        push(head, 30);

        insert(head, 50, 2);
        delete(head, 2);

    }
}
