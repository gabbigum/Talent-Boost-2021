package com.talentboost.stack;

public interface IStack {
    /**
     * Push element onto the stack.
     * @param item
     */
    void push(int item);

    /**
     * Peek an element from the stack.
     * @return the picked element.
     */
    int peek();

    /**
     * Pop the last element from the stack.
     * @return the popped element.
     */
    int pop();

    /**
     * Return the size of the stack.
     * @return
     */
    int size();
}
