package io.ktor.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0015\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010!\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\u001f\u0010%\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\u00020\u00182\u0014\u0010(\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000)H\u0016J\u0017\u0010*\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\"R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lio/ktor/util/CaseInsensitiveMap;", "Value", "", "", "", "()V", "delegate", "Lio/ktor/util/CaseInsensitiveString;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "containsKey", "", "key", "containsValue", "value", "(Ljava/lang/Object;)Z", "equals", "other", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "hashCode", "isEmpty", "put", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CaseInsensitiveMap.kt */
public final class CaseInsensitiveMap<Value> implements Map<String, Value>, KMutableMap {
    private final Map<CaseInsensitiveString, Value> delegate = new LinkedHashMap();

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return containsKey((String) obj);
    }

    public final /* bridge */ Set<Map.Entry<String, Value>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Value get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return get((String) obj);
    }

    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    public final /* bridge */ Value remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return remove((String) obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<Value> values() {
        return getValues();
    }

    public int getSize() {
        return this.delegate.size();
    }

    public boolean containsKey(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.delegate.containsKey(new CaseInsensitiveString(str));
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.delegate.containsValue(obj);
    }

    public Value get(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.delegate.get(TextKt.caseInsensitive(str));
    }

    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    public void clear() {
        this.delegate.clear();
    }

    public Value put(String str, Value value) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.delegate.put(TextKt.caseInsensitive(str), value);
    }

    public Value remove(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.delegate.remove(TextKt.caseInsensitive(str));
    }

    public Set<String> getKeys() {
        return new DelegatingMutableSet<>(this.delegate.keySet(), CaseInsensitiveMap$keys$1.INSTANCE, CaseInsensitiveMap$keys$2.INSTANCE);
    }

    public Set<Map.Entry<String, Value>> getEntries() {
        return new DelegatingMutableSet<>(this.delegate.entrySet(), CaseInsensitiveMap$entries$1.INSTANCE, CaseInsensitiveMap$entries$2.INSTANCE);
    }

    public Collection<Value> getValues() {
        return this.delegate.values();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CaseInsensitiveMap)) {
            return false;
        }
        return Intrinsics.areEqual(((CaseInsensitiveMap) obj).delegate, this.delegate);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public void putAll(Map<? extends String, ? extends Value> map) {
        Intrinsics.checkNotNullParameter(map, "from");
        for (Map.Entry next : map.entrySet()) {
            put((String) next.getKey(), next.getValue());
        }
    }
}
