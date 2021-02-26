package com.talentboost.task2;

import java.util.*;

public class KeyValue<K, V> {

    private K key;
    private V value;


    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Object[] values(Collection<KeyValue<K, V>> kvCollection, Set<K> keys) {
        List<V> result = new ArrayList<>();
        for(var entry : kvCollection) {
            if(keys.contains(entry.getKey())) {
                result.add(entry.getValue());
            }
        }
        return result.toArray();
    }

    public static void main(String[] args) {

    }
}
