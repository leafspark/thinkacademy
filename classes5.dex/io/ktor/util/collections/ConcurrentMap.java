package io.ktor.util.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\b\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J!\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u001a\u001a\u00028\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010 J\u0013\u0010#\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u001f\u0010*\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010+J\u001e\u0010,\u001a\u00020\u00182\u0014\u0010-\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.H\u0016J\u0017\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010'J\b\u00100\u001a\u000201H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b0\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u00062"}, d2 = {"Lio/ktor/util/collections/ConcurrentMap;", "Key", "Value", "", "initialCapacity", "", "(I)V", "delegate", "Ljava/util/concurrent/ConcurrentHashMap;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "computeIfAbsent", "key", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "containsKey", "", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "isEmpty", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "toString", "", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConcurrentMapJvm.kt */
public final class ConcurrentMap<Key, Value> implements Map<Key, Value>, KMutableMap {
    private final ConcurrentHashMap<Key, Value> delegate;

    public ConcurrentMap() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public ConcurrentMap(int i) {
        this.delegate = new ConcurrentHashMap<>(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConcurrentMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 32 : i);
    }

    public final /* bridge */ Set<Map.Entry<Key, Value>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Set<Key> keySet() {
        return getKeys();
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<Value> values() {
        return getValues();
    }

    public final Value computeIfAbsent(Key key, Function0<? extends Value> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return this.delegate.computeIfAbsent(key, new ConcurrentMap$$ExternalSyntheticLambda0(function0));
    }

    /* access modifiers changed from: private */
    /* renamed from: computeIfAbsent$lambda-0  reason: not valid java name */
    public static final Object m17computeIfAbsent$lambda0(Function0 function0, Object obj) {
        Intrinsics.checkNotNullParameter(function0, "$block");
        return function0.invoke();
    }

    public int getSize() {
        return this.delegate.size();
    }

    public boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.delegate.containsValue(obj);
    }

    public Value get(Object obj) {
        return this.delegate.get(obj);
    }

    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    public Set<Map.Entry<Key, Value>> getEntries() {
        Set<Map.Entry<Key, Value>> entrySet = this.delegate.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "delegate.entries");
        return entrySet;
    }

    public Set<Key> getKeys() {
        Set<Key> keySet = this.delegate.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "delegate.keys");
        return keySet;
    }

    public Collection<Value> getValues() {
        Collection<Value> values = this.delegate.values();
        Intrinsics.checkNotNullExpressionValue(values, "delegate.values");
        return values;
    }

    public void clear() {
        this.delegate.clear();
    }

    public Value put(Key key, Value value) {
        return this.delegate.put(key, value);
    }

    public void putAll(Map<? extends Key, ? extends Value> map) {
        Intrinsics.checkNotNullParameter(map, "from");
        this.delegate.putAll(map);
    }

    public Value remove(Object obj) {
        return this.delegate.remove(obj);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        return Intrinsics.areEqual(obj, this.delegate);
    }

    public String toString() {
        return "ConcurrentMapJvm by " + this.delegate;
    }
}
