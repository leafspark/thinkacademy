package io.ktor.utils.io.pool;

import io.flutter.embedding.android.KeyboardMap;
import io.ktor.utils.io.pool.ObjectPool;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 $*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001$B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\r\u0010\u001b\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u0013\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u000f\u0010\u001f\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u0012J\u0015\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lio/ktor/utils/io/pool/DefaultPool;", "T", "", "Lio/ktor/utils/io/pool/ObjectPool;", "capacity", "", "(I)V", "getCapacity", "()I", "instances", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "maxIndex", "next", "", "shift", "top", "", "borrow", "()Ljava/lang/Object;", "clearInstance", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "dispose", "", "disposeInstance", "(Ljava/lang/Object;)V", "popTop", "produceInstance", "pushTop", "index", "recycle", "tryPop", "tryPush", "", "(Ljava/lang/Object;)Z", "validateInstance", "Companion", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultPool.kt */
public abstract class DefaultPool<T> implements ObjectPool<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final AtomicLongFieldUpdater<DefaultPool<?>> Top;
    private final int capacity;
    private final AtomicReferenceArray<T> instances;
    private final int maxIndex;
    private final int[] next;
    private final int shift;
    /* access modifiers changed from: private */
    public volatile long top;

    /* access modifiers changed from: protected */
    public T clearInstance(T t) {
        Intrinsics.checkNotNullParameter(t, "instance");
        return t;
    }

    /* access modifiers changed from: protected */
    public void disposeInstance(T t) {
        Intrinsics.checkNotNullParameter(t, "instance");
    }

    /* access modifiers changed from: protected */
    public abstract T produceInstance();

    /* access modifiers changed from: protected */
    public void validateInstance(T t) {
        Intrinsics.checkNotNullParameter(t, "instance");
    }

    public DefaultPool(int i) {
        this.capacity = i;
        boolean z = false;
        if (i > 0) {
            if (i <= 536870911 ? true : z) {
                int highestOneBit = Integer.highestOneBit((i * 4) - 1) * 2;
                this.maxIndex = highestOneBit;
                this.shift = Integer.numberOfLeadingZeros(highestOneBit) + 1;
                this.instances = new AtomicReferenceArray<>(highestOneBit + 1);
                this.next = new int[(highestOneBit + 1)];
                return;
            }
            throw new IllegalArgumentException(("capacity should be less or equal to 536870911 but it is " + i).toString());
        }
        throw new IllegalArgumentException(("capacity should be positive but it is " + i).toString());
    }

    public void close() {
        ObjectPool.DefaultImpls.close(this);
    }

    public final int getCapacity() {
        return this.capacity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = clearInstance(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T borrow() {
        /*
            r1 = this;
            java.lang.Object r0 = r1.tryPop()
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r1.clearInstance(r0)
            if (r0 != 0) goto L_0x0010
        L_0x000c:
            java.lang.Object r0 = r1.produceInstance()
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.pool.DefaultPool.borrow():java.lang.Object");
    }

    public final void recycle(T t) {
        Intrinsics.checkNotNullParameter(t, "instance");
        validateInstance(t);
        if (!tryPush(t)) {
            disposeInstance(t);
        }
    }

    public final void dispose() {
        while (true) {
            Object tryPop = tryPop();
            if (tryPop != null) {
                disposeInstance(tryPop);
            } else {
                return;
            }
        }
    }

    private final boolean tryPush(T t) {
        int identityHashCode = ((System.identityHashCode(t) * -1640531527) >>> this.shift) + 1;
        for (int i = 0; i < 8; i++) {
            if (this.instances.compareAndSet(identityHashCode, (Object) null, t)) {
                pushTop(identityHashCode);
                return true;
            }
            identityHashCode--;
            if (identityHashCode == 0) {
                identityHashCode = this.maxIndex;
            }
        }
        return false;
    }

    private final T tryPop() {
        int popTop = popTop();
        if (popTop == 0) {
            return null;
        }
        return this.instances.getAndSet(popTop, (Object) null);
    }

    private final void pushTop(int i) {
        long j;
        long j2;
        if (i > 0) {
            do {
                j = this.top;
                j2 = ((long) i) | ((((j >> 32) & KeyboardMap.kValueMask) + 1) << 32);
                this.next[i] = (int) (KeyboardMap.kValueMask & j);
            } while (!Top.compareAndSet(this, j, j2));
            return;
        }
        throw new IllegalArgumentException("index should be positive".toString());
    }

    private final int popTop() {
        long j;
        long j2;
        int i;
        do {
            j = this.top;
            if (j == 0) {
                return 0;
            }
            j2 = ((j >> 32) & KeyboardMap.kValueMask) + 1;
            i = (int) (KeyboardMap.kValueMask & j);
            if (i == 0) {
                return 0;
            }
        } while (!Top.compareAndSet(this, j, (j2 << 32) | ((long) this.next[i])));
        return i;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lio/ktor/utils/io/pool/DefaultPool$Companion;", "", "()V", "Top", "Ljava/util/concurrent/atomic/AtomicLongFieldUpdater;", "Lio/ktor/utils/io/pool/DefaultPool;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultPool.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        AtomicLongFieldUpdater<DefaultPool<?>> newUpdater = AtomicLongFieldUpdater.newUpdater(DefaultPool.class, DefaultPool$Companion$Top$1.INSTANCE.getName());
        Intrinsics.checkNotNullExpressionValue(newUpdater, "newUpdater(Owner::class.java, p.name)");
        Top = newUpdater;
    }
}
