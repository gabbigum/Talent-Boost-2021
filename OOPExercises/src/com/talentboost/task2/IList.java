package com.talentboost.task2;

public interface IList {
    Integer get(int index);
    void put(int index, Integer value);
    void append(Integer value);
    int size();
}
