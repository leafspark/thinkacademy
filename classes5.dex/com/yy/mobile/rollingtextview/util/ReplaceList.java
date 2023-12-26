package com.yy.mobile.rollingtextview.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001+BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0016\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0017H\u0016J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0002J\u0015\u0010%\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006,"}, d2 = {"Lcom/yy/mobile/rollingtextview/util/ReplaceList;", "T", "", "list", "first", "last", "firstReplacePosition", "Lkotlin/Function0;", "", "lastReplacePosition", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "firstIdx", "getLast", "lastIdx", "getList", "()Ljava/util/List;", "size", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "ReplaceIterator", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ReplaceList.kt */
public final class ReplaceList<T> implements List<T>, KMappedMarker {
    private final T first;
    private int firstIdx;
    private final T last;
    private int lastIdx;
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

    public ReplaceList(List<? extends T> list2, T t, T t2, Function0<Integer> function0, Function0<Integer> function02) {
        Intrinsics.checkNotNullParameter(list2, "list");
        Intrinsics.checkNotNullParameter(function0, "firstReplacePosition");
        Intrinsics.checkNotNullParameter(function02, "lastReplacePosition");
        this.list = list2;
        this.first = t;
        this.last = t2;
        this.size = list2.size();
        this.firstIdx = -1;
        this.lastIdx = -1;
        if (t != null) {
            this.firstIdx = ((Number) function0.invoke()).intValue();
        }
        if (t2 != null) {
            this.lastIdx = ((Number) function02.invoke()).intValue();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReplaceList(List list2, Object obj, Object obj2, Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list2, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : obj2, function0, function02);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final List<T> getList() {
        return this.list;
    }

    public final T getFirst() {
        return this.first;
    }

    public final T getLast() {
        return this.last;
    }

    public int getSize() {
        return this.size;
    }

    public boolean contains(Object obj) {
        Iterable<Object> iterable = this;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (Object areEqual : iterable) {
            if (Intrinsics.areEqual(areEqual, obj)) {
                return true;
            }
        }
        return false;
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

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r0 = r1.last;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T get(int r2) {
        /*
            r1 = this;
            int r0 = r1.firstIdx
            if (r2 != r0) goto L_0x0009
            T r0 = r1.first
            if (r0 == 0) goto L_0x0009
            goto L_0x0018
        L_0x0009:
            int r0 = r1.lastIdx
            if (r2 != r0) goto L_0x0012
            T r0 = r1.last
            if (r0 == 0) goto L_0x0012
            goto L_0x0018
        L_0x0012:
            java.util.List<T> r0 = r1.list
            java.lang.Object r0 = r0.get(r2)
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.mobile.rollingtextview.util.ReplaceList.get(int):java.lang.Object");
    }

    public int indexOf(Object obj) {
        int i = 0;
        for (Object areEqual : this) {
            if (Intrinsics.areEqual(areEqual, obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() <= 0;
    }

    public Iterator<T> iterator() {
        return new ReplaceIterator(0, 1, (DefaultConstructorMarker) null);
    }

    public int lastIndexOf(Object obj) {
        List list2 = this;
        ListIterator listIterator = list2.listIterator(list2.size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.areEqual(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator<T> listIterator() {
        return new ReplaceIterator(0, 1, (DefaultConstructorMarker) null);
    }

    public ListIterator<T> listIterator(int i) {
        return new ReplaceIterator(this, i);
    }

    public List<T> subList(int i, int i2) {
        throw new IllegalStateException("Not support");
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\u0016J\r\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yy/mobile/rollingtextview/util/ReplaceList$ReplaceIterator;", "", "index", "", "(Lcom/yy/mobile/rollingtextview/util/ReplaceList;I)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ReplaceList.kt */
    private final class ReplaceIterator implements ListIterator<T>, KMappedMarker {
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

        public ReplaceIterator(ReplaceList replaceList, int i) {
            Intrinsics.checkNotNullParameter(replaceList, "this$0");
            ReplaceList.this = replaceList;
            this.index = i;
            if (i < 0 || i > replaceList.size()) {
                throw new ArrayIndexOutOfBoundsException("index should be in range [0," + replaceList.size() + "] but now is " + this.index);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ReplaceIterator(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(ReplaceList.this, (i2 & 1) != 0 ? 0 : i);
        }

        public boolean hasNext() {
            return this.index < ReplaceList.this.size();
        }

        public boolean hasPrevious() {
            return this.index > 0;
        }

        public T next() {
            if (hasNext()) {
                ReplaceList<T> replaceList = ReplaceList.this;
                int i = this.index;
                this.index = i + 1;
                return replaceList.get(i);
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.index;
        }

        public T previous() {
            if (hasPrevious()) {
                ReplaceList<T> replaceList = ReplaceList.this;
                int i = this.index - 1;
                this.index = i;
                return replaceList.get(i);
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.index - 1;
        }
    }
}
