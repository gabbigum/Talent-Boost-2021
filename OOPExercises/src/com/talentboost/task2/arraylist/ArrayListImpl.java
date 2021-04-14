package com.talentboost.task2.arraylist;

import com.talentboost.task2.IList;

public class ArrayListImpl implements IList {

    private Integer[] array;
    private int size;

    public ArrayListImpl(int capacity) {
        array = new Integer[capacity];
    }

    @Override
    public Integer get(int index) {
        if(isInvalidIndex(index) || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    @Override
    public void put(int index, Integer value) {
        if(isInvalidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    @Override
    public void append(Integer value) {
        if(isInvalidIndex(size)) {
            throw new IndexOutOfBoundsException();
        }
        array[size] = value;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isInvalidIndex(int index) {
        return index < 0 || index >= array.length;
    }
}
