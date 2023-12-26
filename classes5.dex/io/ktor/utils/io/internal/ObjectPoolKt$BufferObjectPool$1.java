package io.ktor.utils.io.internal;

import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.pool.DefaultPool;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014¨\u0006\u0007"}, d2 = {"io/ktor/utils/io/internal/ObjectPoolKt$BufferObjectPool$1", "Lio/ktor/utils/io/pool/DefaultPool;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "disposeInstance", "", "instance", "produceInstance", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ObjectPool.kt */
public final class ObjectPoolKt$BufferObjectPool$1 extends DefaultPool<ReadWriteBufferState.Initial> {
    ObjectPoolKt$BufferObjectPool$1(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public ReadWriteBufferState.Initial produceInstance() {
        return new ReadWriteBufferState.Initial(ObjectPoolKt.getBufferPool().borrow(), 0, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void disposeInstance(ReadWriteBufferState.Initial initial) {
        Intrinsics.checkNotNullParameter(initial, "instance");
        ObjectPoolKt.getBufferPool().recycle(initial.backingBuffer);
    }
}
