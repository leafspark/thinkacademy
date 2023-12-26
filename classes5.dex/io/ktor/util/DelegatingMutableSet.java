package io.ktor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003BE\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\tJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0013\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001fH\u0002J\u0015\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u0016\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\"\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014*\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014*\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016R\u001f\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\u0007X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\b\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lio/ktor/util/DelegatingMutableSet;", "From", "To", "", "delegate", "convertTo", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "convert", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "equals", "other", "", "hashCode", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "toString", "", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DelegatingMutableSet.kt */
public class DelegatingMutableSet<From, To> implements Set<To>, KMutableSet {
    private final Function1<To, From> convert;
    /* access modifiers changed from: private */
    public final Function1<From, To> convertTo;
    /* access modifiers changed from: private */
    public final Set<From> delegate;
    private final int size;

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public DelegatingMutableSet(Set<From> set, Function1<? super From, ? extends To> function1, Function1<? super To, ? extends From> function12) {
        Intrinsics.checkNotNullParameter(set, "delegate");
        Intrinsics.checkNotNullParameter(function1, "convertTo");
        Intrinsics.checkNotNullParameter(function12, "convert");
        this.delegate = set;
        this.convertTo = function1;
        this.convert = function12;
        this.size = set.size();
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public Collection<From> convert(Collection<? extends To> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Iterable<Object> iterable = collection;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object invoke : iterable) {
            arrayList.add(this.convert.invoke(invoke));
        }
        return (List) arrayList;
    }

    public Collection<To> convertTo(Collection<? extends From> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Iterable<Object> iterable = collection;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object invoke : iterable) {
            arrayList.add(this.convertTo.invoke(invoke));
        }
        return (List) arrayList;
    }

    public int getSize() {
        return this.size;
    }

    public boolean add(To to) {
        return this.delegate.add(this.convert.invoke(to));
    }

    public boolean addAll(Collection<? extends To> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.delegate.addAll(convert(collection));
    }

    public void clear() {
        this.delegate.clear();
    }

    public boolean remove(Object obj) {
        return this.delegate.remove(this.convert.invoke(obj));
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.delegate.removeAll(convert(collection));
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.delegate.retainAll(convert(collection));
    }

    public boolean contains(Object obj) {
        return this.delegate.contains(this.convert.invoke(obj));
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.delegate.containsAll(convert(collection));
    }

    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    public Iterator<To> iterator() {
        return new DelegatingMutableSet$iterator$1(this);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Set)) {
            return false;
        }
        Collection convertTo2 = convertTo(this.delegate);
        if (!((Set) obj).containsAll(convertTo2) || !convertTo2.containsAll((Collection) obj)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return convertTo(this.delegate).toString();
    }
}
