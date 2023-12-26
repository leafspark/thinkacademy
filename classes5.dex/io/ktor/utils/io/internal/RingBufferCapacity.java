package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u000203B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0013J\r\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0013J\r\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0015J\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u0015J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u0013J\u0015\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b \u0010\u001fJ\u0015\u0010!\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b#\u0010\u001fJ\u0015\u0010$\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b$\u0010\u001fJ\u0015\u0010%\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b%\u0010\"R&\u0010*\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00018Æ\u0002@Â\u0002X\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u0004R&\u0010-\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00018Æ\u0002@Â\u0002X\u000e¢\u0006\f\u001a\u0004\b+\u0010(\"\u0004\b,\u0010\u0004R&\u00100\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b.\u0010(\"\u0004\b/\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0002\u00101¨\u00062"}, d2 = {"Lio/ktor/utils/io/internal/RingBufferCapacity;", "", "totalCapacity", "<init>", "(I)V", "n", "", "completeRead", "remaining", "update", "", "completeReadOverflow", "(III)Ljava/lang/Void;", "completeWrite", "pending", "completeWriteOverflow", "(II)Ljava/lang/Void;", "", "flush", "()Z", "forceLockForRelease", "()V", "isEmpty", "isFull", "resetForRead", "resetForWrite", "", "toString", "()Ljava/lang/String;", "tryLockForRelease", "tryReadAtLeast", "(I)I", "tryReadAtMost", "tryReadExact", "(I)Z", "tryWriteAtLeast", "tryWriteAtMost", "tryWriteExact", "value", "getAvailableForRead", "()I", "setAvailableForRead", "availableForRead", "getAvailableForWrite", "setAvailableForWrite", "availableForWrite", "getPendingToFlush", "setPendingToFlush", "pendingToFlush", "I", "ktor-io", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RingBufferCapacity.kt */
public final class RingBufferCapacity {
    public static final /* synthetic */ AtomicIntegerFieldUpdater _availableForRead$FU$internal;
    public static final /* synthetic */ AtomicIntegerFieldUpdater _availableForWrite$FU$internal;
    static final /* synthetic */ AtomicIntegerFieldUpdater _pendingToFlush$FU;
    public volatile /* synthetic */ int _availableForRead$internal = 0;
    public volatile /* synthetic */ int _availableForWrite$internal;
    volatile /* synthetic */ int _pendingToFlush;
    private final int totalCapacity;

    static {
        Class<RingBufferCapacity> cls = RingBufferCapacity.class;
        _availableForRead$FU$internal = AtomicIntegerFieldUpdater.newUpdater(cls, "_availableForRead$internal");
        _availableForWrite$FU$internal = AtomicIntegerFieldUpdater.newUpdater(cls, "_availableForWrite$internal");
        _pendingToFlush$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "_pendingToFlush");
    }

    public RingBufferCapacity(int i) {
        this.totalCapacity = i;
        this._availableForWrite$internal = i;
        this._pendingToFlush = 0;
    }

    public final int getAvailableForRead() {
        return this._availableForRead$internal;
    }

    private final void setAvailableForRead(int i) {
        this._availableForRead$internal = i;
    }

    public final int getAvailableForWrite() {
        return this._availableForWrite$internal;
    }

    private final void setAvailableForWrite(int i) {
        this._availableForWrite$internal = i;
    }

    public final int getPendingToFlush() {
        return this._pendingToFlush;
    }

    public final void setPendingToFlush(int i) {
        this._pendingToFlush = i;
    }

    public final void resetForWrite() {
        this._availableForRead$internal = 0;
        this._pendingToFlush = 0;
        this._availableForWrite$internal = this.totalCapacity;
    }

    public final void resetForRead() {
        this._availableForRead$internal = this.totalCapacity;
        this._availableForWrite$internal = 0;
        this._pendingToFlush = 0;
    }

    private final Void completeReadOverflow(int i, int i2, int i3) {
        throw new IllegalArgumentException("Completed read overflow: " + i + " + " + i3 + " = " + i2 + " > " + this.totalCapacity);
    }

    private final Void completeWriteOverflow(int i, int i2) {
        throw new IllegalArgumentException("Complete write overflow: " + i + " + " + i2 + " > " + this.totalCapacity);
    }

    public final boolean flush() {
        int andSet = _pendingToFlush$FU.getAndSet(this, 0);
        if (andSet == 0) {
            if (this._availableForRead$internal > 0) {
                return true;
            }
            return false;
        } else if (_availableForRead$FU$internal.addAndGet(this, andSet) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public final void forceLockForRelease() {
        _availableForWrite$FU$internal.getAndSet(this, 0);
    }

    public final boolean isEmpty() {
        return this._availableForWrite$internal == this.totalCapacity;
    }

    public final boolean isFull() {
        return this._availableForWrite$internal == 0;
    }

    public String toString() {
        return "RingBufferCapacity[read: " + this._availableForRead$internal + ", write: " + this._availableForWrite$internal + ", flush: " + this._pendingToFlush + ", capacity: " + this.totalCapacity + ']';
    }

    public final int tryReadAtLeast(int i) {
        int i2;
        do {
            i2 = this._availableForRead$internal;
            if (i2 < i) {
                return 0;
            }
        } while (!_availableForRead$FU$internal.compareAndSet(this, i2, 0));
        return i2;
    }

    public final boolean tryReadExact(int i) {
        int i2;
        do {
            i2 = this._availableForRead$internal;
            if (i2 < i) {
                return false;
            }
        } while (!_availableForRead$FU$internal.compareAndSet(this, i2, i2 - i));
        return true;
    }

    public final int tryReadAtMost(int i) {
        int i2;
        int min;
        do {
            i2 = this._availableForRead$internal;
            min = Math.min(i, i2);
            if (min == 0) {
                return 0;
            }
        } while (!_availableForRead$FU$internal.compareAndSet(this, i2, i2 - min));
        return Math.min(i, i2);
    }

    public final int tryWriteAtLeast(int i) {
        int i2;
        do {
            i2 = this._availableForWrite$internal;
            if (i2 < i) {
                return 0;
            }
        } while (!_availableForWrite$FU$internal.compareAndSet(this, i2, 0));
        return i2;
    }

    public final boolean tryWriteExact(int i) {
        int i2;
        do {
            i2 = this._availableForWrite$internal;
            if (i2 < i) {
                return false;
            }
        } while (!_availableForWrite$FU$internal.compareAndSet(this, i2, i2 - i));
        return true;
    }

    public final int tryWriteAtMost(int i) {
        int i2;
        int min;
        do {
            i2 = this._availableForWrite$internal;
            min = Math.min(i, i2);
            if (min == 0) {
                return 0;
            }
        } while (!_availableForWrite$FU$internal.compareAndSet(this, i2, i2 - min));
        return Math.min(i, i2);
    }

    public final void completeRead(int i) {
        int i2;
        int i3;
        do {
            i2 = this._availableForWrite$internal;
            i3 = i2 + i;
            if (i3 > this.totalCapacity) {
                completeReadOverflow(i2, i3, i);
                throw new KotlinNothingValueException();
            }
        } while (!_availableForWrite$FU$internal.compareAndSet(this, i2, i3));
    }

    public final void completeWrite(int i) {
        int i2;
        int i3;
        do {
            i2 = this._pendingToFlush;
            i3 = i2 + i;
            if (i3 > this.totalCapacity) {
                completeWriteOverflow(i2, i);
                throw new KotlinNothingValueException();
            }
        } while (!_pendingToFlush$FU.compareAndSet(this, i2, i3));
    }

    public final boolean tryLockForRelease() {
        int i;
        do {
            i = this._availableForWrite$internal;
            if (this._pendingToFlush > 0 || this._availableForRead$internal > 0 || i != this.totalCapacity) {
                return false;
            }
        } while (!_availableForWrite$FU$internal.compareAndSet(this, i, 0));
        return true;
    }
}
