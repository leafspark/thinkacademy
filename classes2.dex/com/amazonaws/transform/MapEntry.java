package com.amazonaws.transform;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V v) {
        this.value = v;
        return v;
    }

    public K setKey(K k) {
        this.key = k;
        return k;
    }
}
