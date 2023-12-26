package io.ktor.util;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0015\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0005\u001a\u00028\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lio/ktor/util/Entry;", "Key", "Value", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "setValue", "(Ljava/lang/Object;)V", "equals", "", "other", "", "hashCode", "", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CaseInsensitiveMap.kt */
final class Entry<Key, Value> implements Map.Entry<Key, Value>, KMutableMap.Entry {
    private final Key key;
    private Value value;

    public Entry(Key key2, Value value2) {
        this.key = key2;
        this.value = value2;
    }

    public Key getKey() {
        return this.key;
    }

    public Value getValue() {
        return this.value;
    }

    /* renamed from: setValue  reason: collision with other method in class */
    public void m16setValue(Value value2) {
        this.value = value2;
    }

    public Value setValue(Value value2) {
        setValue(value2);
        return getValue();
    }

    public int hashCode() {
        Object key2 = getKey();
        Intrinsics.checkNotNull(key2);
        Object value2 = getValue();
        Intrinsics.checkNotNull(value2);
        return key2.hashCode() + 527 + value2.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Intrinsics.areEqual(entry.getKey(), getKey()) || !Intrinsics.areEqual(entry.getValue(), getValue())) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
