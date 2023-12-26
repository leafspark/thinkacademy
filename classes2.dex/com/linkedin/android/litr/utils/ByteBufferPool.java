package com.linkedin.android.litr.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/linkedin/android/litr/utils/ByteBufferPool;", "", "isDirect", "", "(Z)V", "bufferQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/nio/ByteBuffer;", "allocateByteBuffer", "capacity", "", "clear", "", "get", "put", "byteBuffer", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ByteBufferPool.kt */
public final class ByteBufferPool {
    private final LinkedBlockingQueue<ByteBuffer> bufferQueue;
    private final boolean isDirect;

    public ByteBufferPool() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public ByteBufferPool(boolean z) {
        this.isDirect = z;
        this.bufferQueue = new LinkedBlockingQueue<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ByteBufferPool(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final ByteBuffer get(int i) {
        ByteBuffer poll = this.bufferQueue.poll();
        if (poll != null) {
            if (poll.capacity() < i) {
                poll = allocateByteBuffer(i);
            }
            if (poll != null) {
                return poll;
            }
        }
        return allocateByteBuffer(i);
    }

    public final void put(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
        byteBuffer.clear();
        this.bufferQueue.put(byteBuffer);
    }

    public final void clear() {
        this.bufferQueue.clear();
    }

    private final ByteBuffer allocateByteBuffer(int i) {
        if (this.isDirect) {
            ByteBuffer order = ByteBuffer.allocateDirect(i).order(ByteOrder.LITTLE_ENDIAN);
            Intrinsics.checkNotNullExpressionValue(order, "ByteBuffer.allocateDirec…(ByteOrder.LITTLE_ENDIAN)");
            return order;
        }
        ByteBuffer order2 = ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order2, "ByteBuffer.allocate(capa…(ByteOrder.LITTLE_ENDIAN)");
        return order2;
    }
}
