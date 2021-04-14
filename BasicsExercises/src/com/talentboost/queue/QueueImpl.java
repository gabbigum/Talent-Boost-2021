package com.talentboost.queue;

import com.talentboost.linkedlist.LinkedListImpl;

public class QueueImpl implements IQueue {

    private LinkedListImpl queue;

    public QueueImpl() {
        queue = new LinkedListImpl();
    }

    @Override
    public void enqueue(int item) {
        queue.addFront(item);
    }

    @Override
    public int dequeue(int item) {
        return queue.removeBack();
    }

    @Override
    public int peek() {
        return (queue.getTail() != null) ? queue.getTail().getItem() : -1;
    }

    @Override
    public int size() {
        return queue.getSize();
    }
}
