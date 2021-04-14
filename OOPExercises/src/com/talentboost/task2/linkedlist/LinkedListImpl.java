package com.talentboost.task2.linkedlist;

import com.talentboost.task2.IList;
import com.talentboost.task2.linkedlist.*;

public class LinkedListImpl implements ILinkedList, IList {

    private Node head;
    private Node tail;

    private int size;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addFront(int item) {
        Node currentHead = getHead();
        Node newNode = new Node(item);

        if (isEmpty()) {
            setHead(newNode);
            setTail(newNode);
        } else {
            newNode.setNext(currentHead);
            currentHead.setPrev(newNode);
            setHead(newNode);
        }
        size++;
    }

    @Override
    public void addBack(int item) {
        Node newNode = new Node(item);

        if (isEmpty()) {
            setHead(newNode);
            setTail(newNode);
        } else {
            Node currentTail = getTail();
            newNode.setPrev(currentTail);
            currentTail.setNext(newNode);
            setTail(newNode);
        }
        size++;
    }

    @Override
    public int removeFront() {
        int result;

        if (!isEmpty() && size < 2) {
            result = getHead().getItem();
            setHead(null);
            setTail(null);
        } else if (!isEmpty() && size >= 2) {
            result = getHead().getItem();
            setHead(getHead().getNext());
            getHead().setPrev(null);
        } else {
            throw new NullPointerException("Cannot remove non existing element.");
        }

        return result;
    }

    @Override
    public int removeBack() {
        int result;

        if (!isEmpty() && size < 2) {
            result = getTail().getItem();
            setTail(null);
            setHead(null);
        } else if (!isEmpty() && size >= 2) {
            Node newTail = getTail().getPrev();
            result = getTail().getItem();
            getTail().setPrev(null);
            setTail(newTail);
            newTail.setNext(null);
            size--;
        } else {
            throw new NullPointerException("Cannot remove non existing element.");
        }
        return result;
    }

    @Override
    public Integer get(int index) {
        if(isInvalidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node iterator = head;

        int currIndex = 0;
        int result = 0;

        while(iterator != null) {
            if(index == currIndex) {
                result = iterator.getItem();
                break;
            }

            iterator = iterator.getNext();
            currIndex++;
        }
        return result;
    }

    @Override
    public void put(int index, Integer value) {
        if(isInvalidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node iterator = head;

        int currIndex = 0;

        while(iterator != null) {
            if(index == currIndex) {
                iterator.setItem(value);
                break;
            }
            iterator = iterator.getNext();
            currIndex++;
        }
    }

    @Override
    public void append(Integer value) {
        addBack(value);
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isInvalidIndex(int index) {
        return index < 0 || index > size();
    }
}
