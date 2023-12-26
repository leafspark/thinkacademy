package io.ktor.utils.io.pool;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0002H\u0014R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/pool/ByteBufferPool;", "Lio/ktor/utils/io/pool/DefaultPool;", "Ljava/nio/ByteBuffer;", "capacity", "", "bufferSize", "(II)V", "getBufferSize", "()I", "clearInstance", "instance", "produceInstance", "validateInstance", "", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteBufferPools.kt */
public final class ByteBufferPool extends DefaultPool<ByteBuffer> {
    private final int bufferSize;

    public ByteBufferPool() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ByteBufferPool(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 2000 : i, (i3 & 2) != 0 ? 4096 : i2);
    }

    public final int getBufferSize() {
        return this.bufferSize;
    }

    public ByteBufferPool(int i, int i2) {
        super(i);
        this.bufferSize = i2;
    }

    /* access modifiers changed from: protected */
    public ByteBuffer produceInstance() {
        ByteBuffer allocate = ByteBuffer.allocate(this.bufferSize);
        Intrinsics.checkNotNull(allocate);
        return allocate;
    }

    /* access modifiers changed from: protected */
    public ByteBuffer clearInstance(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "instance");
        byteBuffer.clear();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        return byteBuffer;
    }

    /* access modifiers changed from: protected */
    public void validateInstance(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "instance");
        if (!(byteBuffer.capacity() == this.bufferSize)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (!(!byteBuffer.isDirect())) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }
}
