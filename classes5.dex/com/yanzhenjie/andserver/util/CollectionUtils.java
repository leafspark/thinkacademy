package com.yanzhenjie.andserver.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public abstract class CollectionUtils {
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static List arrayToList(Object obj) {
        return Arrays.asList(ObjectUtils.toObjectArray(obj));
    }

    public static <E> void mergeArrayIntoCollection(Object obj, Collection<E> collection) {
        if (collection != null) {
            for (Object add : ObjectUtils.toObjectArray(obj)) {
                collection.add(add);
            }
            return;
        }
        throw new IllegalArgumentException("Collection must not be null");
    }

    public static <K, V> void mergePropertiesIntoMap(Properties properties, Map<K, V> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map must not be null");
        } else if (properties != null) {
            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String str = (String) propertyNames.nextElement();
                Object obj = properties.get(str);
                if (obj == null) {
                    obj = properties.getProperty(str);
                }
                map.put(str, obj);
            }
        }
    }

    public static boolean contains(Iterator<?> it, Object obj) {
        if (it == null) {
            return false;
        }
        while (it.hasNext()) {
            if (ObjectUtils.nullSafeEquals(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(Enumeration<?> enumeration, Object obj) {
        if (enumeration == null) {
            return false;
        }
        while (enumeration.hasMoreElements()) {
            if (ObjectUtils.nullSafeEquals(enumeration.nextElement(), obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsInstance(Collection<?> collection, Object obj) {
        if (collection == null) {
            return false;
        }
        for (Object obj2 : collection) {
            if (obj2 == obj) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsAny(Collection<?> collection, Collection<?> collection2) {
        if (!isEmpty(collection) && !isEmpty(collection2)) {
            for (Object contains : collection2) {
                if (collection.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static <E> E findFirstMatch(Collection<?> collection, Collection<E> collection2) {
        if (!isEmpty(collection) && !isEmpty((Collection<?>) collection2)) {
            for (E next : collection2) {
                if (collection.contains(next)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static <T> T findValueOfType(Collection<?> collection, Class<T> cls) {
        if (isEmpty(collection)) {
            return null;
        }
        T t = null;
        for (T next : collection) {
            if (cls == null || cls.isInstance(next)) {
                if (t != null) {
                    return null;
                }
                t = next;
            }
        }
        return t;
    }

    public static Object findValueOfType(Collection<?> collection, Class<?>[] clsArr) {
        if (!isEmpty(collection) && !ObjectUtils.isEmpty((Object[]) clsArr)) {
            for (Class<?> findValueOfType : clsArr) {
                Object findValueOfType2 = findValueOfType(collection, findValueOfType);
                if (findValueOfType2 != null) {
                    return findValueOfType2;
                }
            }
        }
        return null;
    }

    public static boolean hasUniqueObject(Collection<?> collection) {
        if (isEmpty(collection)) {
            return false;
        }
        Object obj = null;
        boolean z = false;
        for (Object next : collection) {
            if (!z) {
                obj = next;
                z = true;
            } else if (obj != next) {
                return false;
            }
        }
        return true;
    }

    public static Class<?> findCommonElementType(Collection<?> collection) {
        if (isEmpty(collection)) {
            return null;
        }
        Class<?> cls = null;
        for (Object next : collection) {
            if (next != null) {
                if (cls == null) {
                    cls = next.getClass();
                } else if (cls != next.getClass()) {
                    return null;
                }
            }
        }
        return cls;
    }

    public static <A, E extends A> A[] toArray(Enumeration<E> enumeration, A[] aArr) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList.toArray(aArr);
    }

    public static <E> Iterator<E> toIterator(Enumeration<E> enumeration) {
        return new EnumerationIterator(enumeration);
    }

    public static <K, V> MultiValueMap<K, V> toMultiValueMap(Map<K, List<V>> map) {
        return new MultiValueMapAdapter(map);
    }

    public static <K, V> MultiValueMap<K, V> unmodifiableMultiValueMap(MultiValueMap<? extends K, ? extends V> multiValueMap) {
        Assert.notNull(multiValueMap, "'map' must not be null");
        LinkedHashMap linkedHashMap = new LinkedHashMap(multiValueMap.size());
        for (Map.Entry entry : multiValueMap.entrySet()) {
            linkedHashMap.put(entry.getKey(), Collections.unmodifiableList((List) entry.getValue()));
        }
        return toMultiValueMap(Collections.unmodifiableMap(linkedHashMap));
    }

    private static class EnumerationIterator<E> implements Iterator<E> {
        private final Enumeration<E> enumeration;

        public EnumerationIterator(Enumeration<E> enumeration2) {
            this.enumeration = enumeration2;
        }

        public boolean hasNext() {
            return this.enumeration.hasMoreElements();
        }

        public E next() {
            return this.enumeration.nextElement();
        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    private static class MultiValueMapAdapter<K, V> implements MultiValueMap<K, V>, Serializable {
        private final Map<K, List<V>> mMap;

        public MultiValueMapAdapter(Map<K, List<V>> map) {
            Assert.notNull(map, "'map' must not be null");
            this.mMap = map;
        }

        public void add(K k, V v) {
            List list = this.mMap.get(k);
            if (list == null) {
                list = new LinkedList();
                this.mMap.put(k, list);
            }
            list.add(v);
        }

        public V getFirst(K k) {
            List list = this.mMap.get(k);
            if (list != null) {
                return list.get(0);
            }
            return null;
        }

        public void set(K k, V v) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(v);
            this.mMap.put(k, linkedList);
        }

        public void setAll(Map<K, V> map) {
            for (Map.Entry next : map.entrySet()) {
                set(next.getKey(), next.getValue());
            }
        }

        public Map<K, V> toSingleValueMap() {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.mMap.size());
            for (Map.Entry next : this.mMap.entrySet()) {
                linkedHashMap.put(next.getKey(), ((List) next.getValue()).get(0));
            }
            return linkedHashMap;
        }

        public int size() {
            return this.mMap.size();
        }

        public boolean isEmpty() {
            return this.mMap.isEmpty();
        }

        public boolean containsKey(Object obj) {
            return this.mMap.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return this.mMap.containsValue(obj);
        }

        public List<V> get(Object obj) {
            return this.mMap.get(obj);
        }

        public List<V> put(K k, List<V> list) {
            return this.mMap.put(k, list);
        }

        public List<V> remove(Object obj) {
            return this.mMap.remove(obj);
        }

        public void putAll(Map<? extends K, ? extends List<V>> map) {
            this.mMap.putAll(map);
        }

        public void clear() {
            this.mMap.clear();
        }

        public Set<K> keySet() {
            return this.mMap.keySet();
        }

        public Collection<List<V>> values() {
            return this.mMap.values();
        }

        public Set<Map.Entry<K, List<V>>> entrySet() {
            return this.mMap.entrySet();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return this.mMap.equals(obj);
        }

        public int hashCode() {
            return this.mMap.hashCode();
        }

        public String toString() {
            return this.mMap.toString();
        }
    }
}
