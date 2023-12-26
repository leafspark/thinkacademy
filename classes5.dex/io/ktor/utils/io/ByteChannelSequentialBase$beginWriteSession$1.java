package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0019\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"io/ktor/utils/io/ByteChannelSequentialBase$beginWriteSession$1", "Lio/ktor/utils/io/WriterSuspendSession;", "flush", "", "request", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "min", "", "tryAwait", "n", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "written", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteChannelSequential.kt */
public final class ByteChannelSequentialBase$beginWriteSession$1 implements WriterSuspendSession {
    final /* synthetic */ ByteChannelSequentialBase this$0;

    ByteChannelSequentialBase$beginWriteSession$1(ByteChannelSequentialBase byteChannelSequentialBase) {
        this.this$0 = byteChannelSequentialBase;
    }

    public ChunkBuffer request(int i) {
        if (this.this$0.getAvailableForWrite() == 0) {
            return null;
        }
        return this.this$0.getWritable().prepareWriteHead(i);
    }

    public void written(int i) {
        this.this$0.getWritable().afterHeadWrite();
        this.this$0.afterWrite(i);
    }

    public void flush() {
        this.this$0.flush();
    }

    public Object tryAwait(int i, Continuation<? super Unit> continuation) {
        if (this.this$0.getAvailableForWrite() >= i) {
            return Unit.INSTANCE;
        }
        Object awaitAtLeastNBytesAvailableForWrite$ktor_io = this.this$0.awaitAtLeastNBytesAvailableForWrite$ktor_io(i, continuation);
        return awaitAtLeastNBytesAvailableForWrite$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitAtLeastNBytesAvailableForWrite$ktor_io : Unit.INSTANCE;
    }
}
