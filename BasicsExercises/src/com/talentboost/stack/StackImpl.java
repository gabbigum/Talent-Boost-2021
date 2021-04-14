package com.talentboost.stack;

import com.talentboost.linkedlist.LinkedListImpl;

public class StackImpl implements IStack {

    private LinkedListImpl stack;

    public StackImpl() {
        stack = new LinkedListImpl();
    }

    @Override
    public void push(int item) {
        stack.addBack(item);
    }

    @Override
    public int peek() {
        return (stack.getTail() != null) ? stack.getTail().getItem() : -1;
    }

    @Override
    public int pop() {
        return stack.removeBack();
    }

    @Override
    public int size() {
        return stack.getSize();
    }
}
