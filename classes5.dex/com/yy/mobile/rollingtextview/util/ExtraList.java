package com.yy.mobile.rollingtextview.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001!B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0006J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u0016\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\rH\u0016J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0002J\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\""}, d2 = {"Lcom/yy/mobile/rollingtextview/util/ExtraList;", "T", "", "list", "first", "last", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "Ljava/lang/Object;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "ExtraIterator", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ExtraList.kt */
public final class ExtraList<T> implements List<T>, KMappedMarker {
    private final T first;
    private final T last;
    private final List<T> list;
    private final int size;

    public void add(int i, T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public T remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(UnaryOperator<T> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public T set(int i, T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void sort(Comparator<? super T> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public ExtraList(List<? extends T> list2, T t, T t2) {
        int i;
        Intrinsics.checkNotNullParameter(list2, "list");
        this.list = list2;
        this.first = t;
        this.last = t2;
        if (t != null && t2 != null) {
            i = list2.size() + 2;
        } else if (t == null && t2 == null) {
            i = list2.size();
        } else {
            i = list2.size() + 1;
        }
        this.size = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExtraList(List list2, Object obj, Object obj2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list2, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : obj2);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public int getSize() {
        return this.size;
    }

    public boolean contains(Object obj) {
        return Intrinsics.areEqual(this.first, obj) || Intrinsics.areEqual(this.last, obj) || this.list.contains(obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public T get(int i) {
        T t;
        T t2;
        if (i == 0 && (t2 = this.first) != null) {
            return t2;
        }
        if (i == size() - 1 && (t = this.last) != null) {
            return t;
        }
        if (this.first != null) {
            return this.list.get(i - 1);
        }
        return this.list.get(i);
    }

    public int indexOf(Object obj) {
        T t = this.first;
        if (t != null && Intrinsics.areEqual(t, obj)) {
            return 0;
        }
        int indexOf = this.list.indexOf(obj);
        if (indexOf == -1) {
            T t2 = this.last;
            return (t2 == null || !Intrinsics.areEqual(t2, obj)) ? indexOf : size() - 1;
        } else if (this.first != null) {
            return indexOf + 1;
        } else {
            return indexOf;
        }
    }

    public boolean isEmpty() {
        return size() <= 0;
    }

    public Iterator<T> iterator() {
        return new ExtraIterator(0, 1, (DefaultConstructorMarker) null);
    }

    public int lastIndexOf(Object obj) {
        T t = this.last;
        if (t != null && Intrinsics.areEqual(t, obj)) {
            return size() - 1;
        }
        int lastIndexOf = this.list.lastIndexOf(obj);
        if (lastIndexOf == -1) {
            T t2 = this.first;
            if (t2 == null || !Intrinsics.areEqual(t2, obj)) {
                return lastIndexOf;
            }
            return 0;
        } else if (this.first != null) {
            return lastIndexOf + 1;
        } else {
            return lastIndexOf;
        }
    }

    public ListIterator<T> listIterator() {
        return new ExtraIterator(0, 1, (DefaultConstructorMarker) null);
    }

    public ListIterator<T> listIterator(int i) {
        return new ExtraIterator(this, i);
    }

    public List<T> subList(int i, int i2) {
        throw new IllegalStateException("Not Support");
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\u0016J\r\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yy/mobile/rollingtextview/util/ExtraList$ExtraIterator;", "", "index", "", "(Lcom/yy/mobile/rollingtextview/util/ExtraList;I)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ExtraList.kt */
    private final class ExtraIterator implements ListIterator<T>, KMappedMarker {
        private int index;

        public void add(T t) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void set(T t) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public ExtraIterator(ExtraList extraList, int i) {
            Intrinsics.checkNotNullParameter(extraList, "this$0");
            ExtraList.this = extraList;
            this.index = i;
            if (i < 0 || i > extraList.size()) {
                throw new ArrayIndexOutOfBoundsException("index should be in range [0," + extraList.size() + "] but now is " + this.index);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ExtraIterator(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(ExtraList.this, (i2 & 1) != 0 ? 0 : i);
        }

        public boolean hasNext() {
            return this.index < ExtraList.this.size();
        }

        public boolean hasPrevious() {
            return this.index > 0;
        }

        public T next() {
            if (hasNext()) {
                ExtraList<T> extraList = ExtraList.this;
                int i = this.index;
                this.index = i + 1;
                return extraList.get(i);
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.index;
        }

        public T previous() {
            if (hasPrevious()) {
                ExtraList<T> extraList = ExtraList.this;
                int i = this.index - 1;
                this.index = i;
                return extraList.get(i);
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.index - 1;
        }
    }
}
