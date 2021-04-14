package com.talentboost.task2.linkedlist;

public interface ILinkedList {
    /**
     * Adds element to the front of the linked list.
     * @param item
     */
    void addFront(int item);

    /**
     * Adds element to the back of the linked list.
     * @param item
     */
    void addBack(int item);

    /**
     * Removes element from the front of the linked list.
     * @returns the removed element.
     */
    int removeFront();

    /**
     * Removes element from the back of the linked list.
     * @returns the removed element.
     */
    int removeBack();
}
