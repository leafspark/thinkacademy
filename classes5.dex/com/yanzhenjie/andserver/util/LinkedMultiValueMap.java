package com.yanzhenjie.andserver.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LinkedMultiValueMap<K, V> implements MultiValueMap<K, V>, Cloneable {
    private final Map<K, List<V>> mSource;

    public LinkedMultiValueMap() {
        this.mSource = new LinkedHashMap();
    }

    public LinkedMultiValueMap(int i) {
        this.mSource = new LinkedHashMap(i);
    }

    public LinkedMultiValueMap(Map<K, List<V>> map) {
        this.mSource = new LinkedHashMap(map);
    }

    public void add(K k, V v) {
        List list = this.mSource.get(k);
        if (list == null) {
            list = new LinkedList();
            this.mSource.put(k, list);
        }
        list.add(v);
    }

    public V getFirst(K k) {
        List list = this.mSource.get(k);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    public void set(K k, V v) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(v);
        this.mSource.put(k, linkedList);
    }

    public void setAll(Map<K, V> map) {
        for (Map.Entry next : map.entrySet()) {
            set(next.getKey(), next.getValue());
        }
    }

    public Map<K, V> toSingleValueMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.mSource.size());
        for (Map.Entry next : this.mSource.entrySet()) {
            linkedHashMap.put(next.getKey(), ((List) next.getValue()).get(0));
        }
        return linkedHashMap;
    }

    public int size() {
        return this.mSource.size();
    }

    public boolean isEmpty() {
        return this.mSource.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.mSource.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.mSource.containsValue(obj);
    }

    public List<V> get(Object obj) {
        return this.mSource.get(obj);
    }

    public List<V> put(K k, List<V> list) {
        return this.mSource.put(k, list);
    }

    public List<V> remove(Object obj) {
        return this.mSource.remove(obj);
    }

    public void putAll(Map<? extends K, ? extends List<V>> map) {
        this.mSource.putAll(map);
    }

    public void clear() {
        this.mSource.clear();
    }

    public Set<K> keySet() {
        return this.mSource.keySet();
    }

    public Collection<List<V>> values() {
        return this.mSource.values();
    }

    public Set<Map.Entry<K, List<V>>> entrySet() {
        return this.mSource.entrySet();
    }

    public LinkedMultiValueMap<K, V> clone() {
        return new LinkedMultiValueMap<>(this);
    }

    public boolean equals(Object obj) {
        return this.mSource.equals(obj);
    }

    public int hashCode() {
        return this.mSource.hashCode();
    }

    public String toString() {
        return this.mSource.toString();
    }

    public LinkedMultiValueMap<K, V> deepCopy() {
        LinkedMultiValueMap<K, V> linkedMultiValueMap = new LinkedMultiValueMap<>(this.mSource.size());
        for (Map.Entry next : this.mSource.entrySet()) {
            linkedMultiValueMap.put((K) next.getKey(), (List<V>) new LinkedList((Collection) next.getValue()));
        }
        return linkedMultiValueMap;
    }
}
