package com.yanzhenjie.andserver.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class LinkedCaseInsensitiveMap<V> implements Map<String, V>, Serializable, Cloneable {
    /* access modifiers changed from: private */
    public final HashMap<String, String> mCaseInsensitiveKeys;
    private final Locale mLocale;
    private final LinkedHashMap<String, V> mSource;

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<String, V> entry) {
        return false;
    }

    public LinkedCaseInsensitiveMap() {
        this((Locale) null);
    }

    public LinkedCaseInsensitiveMap(Locale locale) {
        this(16, locale);
    }

    public LinkedCaseInsensitiveMap(int i) {
        this(i, (Locale) null);
    }

    public LinkedCaseInsensitiveMap(int i, Locale locale) {
        this.mSource = new LinkedHashMap<String, V>(i) {
            public boolean containsKey(Object obj) {
                return LinkedCaseInsensitiveMap.this.containsKey(obj);
            }

            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<String, V> entry) {
                boolean removeEldestEntry = LinkedCaseInsensitiveMap.this.removeEldestEntry(entry);
                if (removeEldestEntry) {
                    LinkedCaseInsensitiveMap.this.mCaseInsensitiveKeys.remove(LinkedCaseInsensitiveMap.this.convertKey(entry.getKey()));
                }
                return removeEldestEntry;
            }
        };
        this.mCaseInsensitiveKeys = new HashMap<>(i);
        this.mLocale = locale == null ? Locale.getDefault() : locale;
    }

    private LinkedCaseInsensitiveMap(LinkedCaseInsensitiveMap<V> linkedCaseInsensitiveMap) {
        this.mSource = (LinkedHashMap) linkedCaseInsensitiveMap.mSource.clone();
        this.mCaseInsensitiveKeys = (HashMap) linkedCaseInsensitiveMap.mCaseInsensitiveKeys.clone();
        this.mLocale = linkedCaseInsensitiveMap.mLocale;
    }

    public int size() {
        return this.mSource.size();
    }

    public boolean isEmpty() {
        return this.mSource.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return (obj instanceof String) && this.mCaseInsensitiveKeys.containsKey(convertKey((String) obj));
    }

    public boolean containsValue(Object obj) {
        return this.mSource.containsValue(obj);
    }

    public V get(Object obj) {
        String str;
        if (!(obj instanceof String) || (str = this.mCaseInsensitiveKeys.get(convertKey((String) obj))) == null) {
            return null;
        }
        return this.mSource.get(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r1.mCaseInsensitiveKeys.get(convertKey((java.lang.String) r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V getOrDefault(java.lang.Object r2, V r3) {
        /*
            r1 = this;
            boolean r0 = r2 instanceof java.lang.String
            if (r0 == 0) goto L_0x001b
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r1.mCaseInsensitiveKeys
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r1.convertKey(r2)
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x001b
            java.util.LinkedHashMap<java.lang.String, V> r3 = r1.mSource
            java.lang.Object r2 = r3.get(r2)
            return r2
        L_0x001b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.andserver.util.LinkedCaseInsensitiveMap.getOrDefault(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public V put(String str, V v) {
        String put = this.mCaseInsensitiveKeys.put(convertKey(str), str);
        if (put != null && !put.equals(str)) {
            this.mSource.remove(put);
        }
        return this.mSource.put(str, v);
    }

    public void putAll(Map<? extends String, ? extends V> map) {
        if (!map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                put((String) next.getKey(), next.getValue());
            }
        }
    }

    public V remove(Object obj) {
        String remove;
        if (!(obj instanceof String) || (remove = this.mCaseInsensitiveKeys.remove(convertKey((String) obj))) == null) {
            return null;
        }
        return this.mSource.remove(remove);
    }

    public void clear() {
        this.mCaseInsensitiveKeys.clear();
        this.mSource.clear();
    }

    public Set<String> keySet() {
        return this.mSource.keySet();
    }

    public Collection<V> values() {
        return this.mSource.values();
    }

    public Set<Map.Entry<String, V>> entrySet() {
        return this.mSource.entrySet();
    }

    public LinkedCaseInsensitiveMap<V> clone() {
        return new LinkedCaseInsensitiveMap<>(this);
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

    public Locale getLocale() {
        return this.mLocale;
    }

    /* access modifiers changed from: protected */
    public String convertKey(String str) {
        return str.toLowerCase(getLocale());
    }
}
