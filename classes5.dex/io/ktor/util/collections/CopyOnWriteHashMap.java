package io.ktor.util.collections;

import io.ktor.util.InternalAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@InternalAPI
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u00002!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\r\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u000eJ \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/util/collections/CopyOnWriteHashMap;", "", "K", "V", "<init>", "()V", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "producer", "computeIfAbsent", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CopyOnWriteHashMap.kt */
public final class CopyOnWriteHashMap<K, V> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater current$FU = AtomicReferenceFieldUpdater.newUpdater(CopyOnWriteHashMap.class, Object.class, "current");
    private volatile /* synthetic */ Object current = MapsKt.emptyMap();

    public final V put(K k, V v) {
        Map map;
        HashMap hashMap;
        V put;
        Intrinsics.checkNotNullParameter(k, "key");
        Intrinsics.checkNotNullParameter(v, "value");
        do {
            map = (Map) this.current;
            if (map.get(k) == v) {
                return v;
            }
            hashMap = new HashMap(map);
            put = hashMap.put(k, v);
        } while (!current$FU.compareAndSet(this, map, hashMap));
        return put;
    }

    public final V get(K k) {
        Intrinsics.checkNotNullParameter(k, "key");
        return ((Map) this.current).get(k);
    }

    public final void set(K k, V v) {
        Intrinsics.checkNotNullParameter(k, "key");
        Intrinsics.checkNotNullParameter(v, "value");
        put(k, v);
    }

    public final V remove(K k) {
        Map map;
        HashMap hashMap;
        V remove;
        Intrinsics.checkNotNullParameter(k, "key");
        do {
            map = (Map) this.current;
            if (map.get(k) == null) {
                return null;
            }
            hashMap = new HashMap(map);
            remove = hashMap.remove(k);
        } while (!current$FU.compareAndSet(this, map, hashMap));
        return remove;
    }

    public final V computeIfAbsent(K k, Function1<? super K, ? extends V> function1) {
        Map map;
        HashMap hashMap;
        V invoke;
        Intrinsics.checkNotNullParameter(k, "key");
        Intrinsics.checkNotNullParameter(function1, "producer");
        do {
            map = (Map) this.current;
            V v = map.get(k);
            if (v != null) {
                return v;
            }
            hashMap = new HashMap(map);
            invoke = function1.invoke(k);
            hashMap.put(k, invoke);
        } while (!current$FU.compareAndSet(this, map, hashMap));
        return invoke;
    }
}
