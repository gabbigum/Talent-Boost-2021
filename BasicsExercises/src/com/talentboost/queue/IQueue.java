package com.talentboost.queue;

public interface IQueue {

    void enqueue(int item);
    int dequeue(int item);
    int peek();
    int size();
}
