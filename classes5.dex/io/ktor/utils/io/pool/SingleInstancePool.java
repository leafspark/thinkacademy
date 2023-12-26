package io.ktor.utils.io.pool;

import io.ktor.utils.io.pool.ObjectPool;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00028\u0000H$¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H$¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000bR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lio/ktor/utils/io/pool/SingleInstancePool;", "", "T", "<init>", "()V", "borrow", "()Ljava/lang/Object;", "", "dispose", "instance", "disposeInstance", "(Ljava/lang/Object;)V", "produceInstance", "recycle", "", "getCapacity", "()I", "capacity", "ktor-io", "Lio/ktor/utils/io/pool/ObjectPool;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Pool.kt */
public abstract class SingleInstancePool<T> implements ObjectPool<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater borrowed$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater disposed$FU;
    private volatile /* synthetic */ int borrowed = 0;
    private volatile /* synthetic */ int disposed = 0;
    private volatile /* synthetic */ Object instance = null;

    static {
        Class<SingleInstancePool> cls = SingleInstancePool.class;
        borrowed$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "borrowed");
        disposed$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "disposed");
    }

    /* access modifiers changed from: protected */
    public abstract void disposeInstance(T t);

    public final int getCapacity() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public abstract T produceInstance();

    public void close() {
        ObjectPool.DefaultImpls.close(this);
    }

    public final void recycle(T t) {
        Intrinsics.checkNotNullParameter(t, "instance");
        if (this.instance == t) {
            this.instance = null;
            if (disposed$FU.compareAndSet(this, 0, 1)) {
                disposeInstance(t);
                return;
            }
            throw new IllegalStateException("An instance is already disposed");
        } else if (this.instance != null || this.borrowed == 0) {
            throw new IllegalStateException("Unable to recycle irrelevant instance");
        } else {
            throw new IllegalStateException("Already recycled or an irrelevant instance tried to be recycled");
        }
    }

    public final void dispose() {
        Object obj;
        if (disposed$FU.compareAndSet(this, 0, 1) && (obj = this.instance) != null) {
            this.instance = null;
            disposeInstance(obj);
        }
    }

    public final T borrow() {
        int i;
        do {
            i = this.borrowed;
            if (i != 0) {
                throw new IllegalStateException("Instance is already consumed");
            }
        } while (!borrowed$FU.compareAndSet(this, i, 1));
        T produceInstance = produceInstance();
        this.instance = produceInstance;
        return produceInstance;
    }
}
