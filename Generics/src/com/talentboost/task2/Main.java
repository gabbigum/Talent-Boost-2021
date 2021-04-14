package com.talentboost.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<KeyValue<Integer, String>> pairs = new ArrayList<>();
        Set<Integer> keyList = Set.of(1, 2);

        KeyValue<Integer, String> pair1 = new KeyValue<>(1, "Hi");
        KeyValue<Integer, String> pair2 = new KeyValue<>(2, "Hi bla bla");
        KeyValue<Integer, String> pair3 = new KeyValue<>(3, "Hi whats up");

        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);

        Object[] result = pair2.values(pairs, keyList);

        for (var key : result) {
            System.out.println(key);
        }
    }
}
