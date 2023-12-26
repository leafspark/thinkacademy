package io.ktor.util.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\fJ\u0016\u0010\u0012\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0002J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\u0016\u0010\u0017\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\u0016\u0010\u0018\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"io/ktor/util/collections/ConcurrentSetKt$ConcurrentSet$1", "", "delegate", "Lio/ktor/util/collections/ConcurrentMap;", "", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "contains", "containsAll", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConcurrentSet.kt */
public final class ConcurrentSetKt$ConcurrentSet$1 implements Set<Key>, KMutableSet {
    private final ConcurrentMap<Key, Unit> delegate = new ConcurrentMap<>(0, 1, (DefaultConstructorMarker) null);

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    ConcurrentSetKt$ConcurrentSet$1() {
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public boolean add(Key key) {
        Intrinsics.checkNotNullParameter(key, "element");
        if (this.delegate.containsKey(key)) {
            return false;
        }
        this.delegate.put(key, Unit.INSTANCE);
        return true;
    }

    public boolean addAll(Collection<? extends Key> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object add : iterable) {
            if (!add(add)) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        this.delegate.clear();
    }

    public Iterator<Key> iterator() {
        return this.delegate.keySet().iterator();
    }

    public boolean remove(Object obj) {
        return (obj == null || this.delegate.remove(obj) == null) ? false : true;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object remove : iterable) {
            if (!remove(remove)) {
                return false;
            }
        }
        return true;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Set linkedHashSet = new LinkedHashSet();
        for (Key next : this.delegate.keySet()) {
            if (!collection.contains(next)) {
                linkedHashSet.add(next);
            }
        }
        return removeAll(linkedHashSet);
    }

    public int getSize() {
        return this.delegate.size();
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.delegate.containsKey(obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return collection.containsAll(this.delegate.keySet());
    }

    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }
}
