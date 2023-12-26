package io.ktor.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0016\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0011\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0016\u0010\u0016\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0016\u0010\u001b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\u0016\u0010\u001c\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lio/ktor/util/CaseInsensitiveSet;", "", "", "initial", "", "(Ljava/lang/Iterable;)V", "()V", "backingMap", "Lio/ktor/util/CaseInsensitiveMap;", "", "size", "", "getSize", "()I", "add", "element", "addAll", "elements", "", "clear", "", "contains", "containsAll", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
@InternalAPI
/* compiled from: CaseInsensitiveSet.kt */
public final class CaseInsensitiveSet implements Set<String>, KMutableSet {
    private final CaseInsensitiveMap<Boolean> backingMap;

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public CaseInsensitiveSet() {
        this.backingMap = new CaseInsensitiveMap<>();
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return contains((String) obj);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return remove((String) obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CaseInsensitiveSet(Iterable<String> iterable) {
        this();
        Intrinsics.checkNotNullParameter(iterable, "initial");
        CollectionsKt.addAll(this, iterable);
    }

    public boolean add(String str) {
        Intrinsics.checkNotNullParameter(str, "element");
        if (this.backingMap.containsKey(str)) {
            return false;
        }
        this.backingMap.put(str, true);
        return true;
    }

    public int getSize() {
        return this.backingMap.size();
    }

    public boolean remove(String str) {
        Intrinsics.checkNotNullParameter(str, "element");
        return Intrinsics.areEqual(this.backingMap.remove((Object) str), true);
    }

    public boolean addAll(Collection<? extends String> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        boolean z = false;
        for (String add : collection) {
            if (add(add)) {
                z = true;
            }
        }
        return z;
    }

    public void clear() {
        this.backingMap.clear();
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.backingMap.keySet().removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.backingMap.keySet().retainAll(collection);
    }

    public boolean contains(String str) {
        Intrinsics.checkNotNullParameter(str, "element");
        return this.backingMap.containsKey(str);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.backingMap.keySet().containsAll(collection);
    }

    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    public Iterator<String> iterator() {
        return this.backingMap.keySet().iterator();
    }
}
