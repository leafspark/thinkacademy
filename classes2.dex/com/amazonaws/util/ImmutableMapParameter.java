package com.amazonaws.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ImmutableMapParameter<K, V> implements Map<K, V> {
    private static final String DUPLICATED_KEY_MESSAGE = "Duplicate keys are provided.";
    private static final String UNMODIFIABLE_MESSAGE = "This is an immutable map.";
    private final Map<K, V> map;

    private ImmutableMapParameter(Map<K, V> map2) {
        this.map = map2;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k, V v) {
        return new ImmutableMapParameter<>(Collections.singletonMap(k, v));
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k, V v, K k2, V v2) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, k, v);
        putAndWarnDuplicateKeys(hashMap, k2, v2);
        return new ImmutableMapParameter<>(hashMap);
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, k, v);
        putAndWarnDuplicateKeys(hashMap, k2, v2);
        putAndWarnDuplicateKeys(hashMap, k3, v3);
        return new ImmutableMapParameter<>(hashMap);
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, k, v);
        putAndWarnDuplicateKeys(hashMap, k2, v2);
        putAndWarnDuplicateKeys(hashMap, k3, v3);
        putAndWarnDuplicateKeys(hashMap, k4, v4);
        return new ImmutableMapParameter<>(hashMap);
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, k, v);
        putAndWarnDuplicateKeys(hashMap, k2, v2);
        putAndWarnDuplicateKeys(hashMap, k3, v3);
        putAndWarnDuplicateKeys(hashMap, k4, v4);
        putAndWarnDuplicateKeys(hashMap, k5, v5);
        return new ImmutableMapParameter<>(hashMap);
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return this.map.entrySet();
    }

    public V get(Object obj) {
        return this.map.get(obj);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<K> keySet() {
        return this.map.keySet();
    }

    public int size() {
        return this.map.size();
    }

    public Collection<V> values() {
        return this.map.values();
    }

    public void clear() {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public V put(K k, V v) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public void putAll(Map<? extends K, ? extends V> map2) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public V remove(Object obj) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    /* access modifiers changed from: private */
    public static <K, V> void putAndWarnDuplicateKeys(Map<K, V> map2, K k, V v) {
        if (!map2.containsKey(k)) {
            map2.put(k, v);
            return;
        }
        throw new IllegalArgumentException(DUPLICATED_KEY_MESSAGE);
    }

    public static class Builder<K, V> {
        private final Map<K, V> entries = new HashMap();

        public Builder<K, V> put(K k, V v) {
            ImmutableMapParameter.putAndWarnDuplicateKeys(this.entries, k, v);
            return this;
        }

        public ImmutableMapParameter<K, V> build() {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.entries);
            return new ImmutableMapParameter<>(hashMap);
        }
    }
}
