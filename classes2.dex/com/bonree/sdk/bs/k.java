package com.bonree.sdk.bs;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k<K, V> extends ConcurrentHashMap<K, V> {
    public k() {
    }

    private k(int i) {
        super(i);
    }

    public k(Map<? extends K, ? extends V> map) {
        super(map);
    }

    private k(int i, float f) {
        super(i, f);
    }

    private k(int i, float f, int i2) {
        super(i, f, i2);
    }

    public final V put(K k, V v) {
        if (k == null || v == null) {
            return null;
        }
        return super.put(k, v);
    }

    public final V get(Object obj) {
        if (obj == null) {
            return null;
        }
        return super.get(obj);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        if (map != null) {
            try {
                if (map.size() > 0) {
                    Iterator<? extends K> it = map.keySet().iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next == null || map.get(next) == null) {
                            it.remove();
                        }
                    }
                    super.putAll(map);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        return super.remove(obj);
    }
}
