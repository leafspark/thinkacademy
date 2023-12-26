package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.WriterSuspendSession;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0001\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0019\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lio/ktor/utils/io/internal/WriteSessionImpl;", "Lio/ktor/utils/io/WriterSuspendSession;", "channel", "Lio/ktor/utils/io/ByteBufferChannel;", "(Lio/ktor/utils/io/ByteBufferChannel;)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "current", "locked", "", "ringBufferCapacity", "Lio/ktor/utils/io/internal/RingBufferCapacity;", "view", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "begin", "", "complete", "flush", "request", "min", "tryAwait", "n", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitJoinSwitch", "written", "writtenFailed", "", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WriteSessionImpl.kt */
public final class WriteSessionImpl implements WriterSuspendSession {
    private ByteBuffer byteBuffer = ChunkBuffer.Companion.getEmpty().m184getMemorySK3TCg8();
    private ByteBufferChannel current;
    private int locked;
    private RingBufferCapacity ringBufferCapacity = this.current.currentState$ktor_io().capacity;
    private ChunkBuffer view = ChunkBuffer.Companion.getEmpty();

    public WriteSessionImpl(ByteBufferChannel byteBufferChannel) {
        Intrinsics.checkNotNullParameter(byteBufferChannel, "channel");
        this.current = byteBufferChannel.resolveChannelInstance$ktor_io();
    }

    public final void begin() {
        ByteBufferChannel resolveChannelInstance$ktor_io = this.current.resolveChannelInstance$ktor_io();
        this.current = resolveChannelInstance$ktor_io;
        ByteBuffer byteBuffer2 = resolveChannelInstance$ktor_io.setupStateForWrite$ktor_io();
        if (byteBuffer2 != null) {
            this.byteBuffer = byteBuffer2;
            ChunkBuffer ChunkBuffer$default = BufferUtilsJvmKt.ChunkBuffer$default(this.current.currentState$ktor_io().backingBuffer, (ObjectPool) null, 2, (Object) null);
            this.view = ChunkBuffer$default;
            BufferUtilsJvmKt.resetFromContentToWrite(ChunkBuffer$default, this.byteBuffer);
            this.ringBufferCapacity = this.current.currentState$ktor_io().capacity;
        }
    }

    public final void complete() {
        int i = this.locked;
        if (i > 0) {
            this.ringBufferCapacity.completeRead(i);
            this.locked = 0;
        }
        this.current.restoreStateAfterWrite$ktor_io();
        this.current.tryTerminate$ktor_io();
    }

    public ChunkBuffer request(int i) {
        int tryWriteAtLeast = this.locked + this.ringBufferCapacity.tryWriteAtLeast(0);
        this.locked = tryWriteAtLeast;
        if (tryWriteAtLeast < i) {
            return null;
        }
        this.current.prepareWriteBuffer$ktor_io(this.byteBuffer, tryWriteAtLeast);
        if (this.byteBuffer.remaining() < i) {
            return null;
        }
        BufferUtilsJvmKt.resetFromContentToWrite(this.view, this.byteBuffer);
        return this.view;
    }

    public void written(int i) {
        int i2;
        if (i < 0 || i > (i2 = this.locked)) {
            writtenFailed(i);
            throw new KotlinNothingValueException();
        }
        this.locked = i2 - i;
        this.current.bytesWrittenFromSession$ktor_io(this.byteBuffer, this.ringBufferCapacity, i);
    }

    private final Void writtenFailed(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Written bytes count shouldn't be negative: " + i);
        }
        throw new IllegalStateException("Unable to mark " + i + " bytes as written: only " + this.locked + " were pre-locked.");
    }

    public Object tryAwait(int i, Continuation<? super Unit> continuation) {
        if (this.current.getJoining$ktor_io() != null) {
            Object tryAwaitJoinSwitch = tryAwaitJoinSwitch(i, continuation);
            return tryAwaitJoinSwitch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? tryAwaitJoinSwitch : Unit.INSTANCE;
        }
        int i2 = this.locked;
        if (i2 >= i) {
            return Unit.INSTANCE;
        }
        if (i2 > 0) {
            this.ringBufferCapacity.completeRead(i2);
            this.locked = 0;
        }
        Object tryWriteSuspend$ktor_io = this.current.tryWriteSuspend$ktor_io(i, continuation);
        return tryWriteSuspend$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? tryWriteSuspend$ktor_io : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object tryAwaitJoinSwitch(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = (io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = new io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.internal.WriteSessionImpl r5 = (io.ktor.utils.io.internal.WriteSessionImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0060
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            int r6 = r4.locked
            if (r6 <= 0) goto L_0x0045
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r4.ringBufferCapacity
            r2.completeRead(r6)
            r6 = 0
            r4.locked = r6
        L_0x0045:
            r4.flush()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r6.restoreStateAfterWrite$ktor_io()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r6.tryTerminate$ktor_io()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r6.tryWriteSuspend$ktor_io(r5, r0)
            if (r5 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r5 = r4
        L_0x0060:
            io.ktor.utils.io.ByteBufferChannel r6 = r5.current
            io.ktor.utils.io.ByteBufferChannel r6 = r6.resolveChannelInstance$ktor_io()
            r5.current = r6
            java.nio.ByteBuffer r6 = r6.setupStateForWrite$ktor_io()
            if (r6 != 0) goto L_0x006f
            goto L_0x0090
        L_0x006f:
            r5.byteBuffer = r6
            io.ktor.utils.io.ByteBufferChannel r6 = r5.current
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r6.currentState$ktor_io()
            java.nio.ByteBuffer r6 = r6.backingBuffer
            r0 = 2
            r1 = 0
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = io.ktor.utils.io.core.BufferUtilsJvmKt.ChunkBuffer$default(r6, r1, r0, r1)
            r5.view = r6
            java.nio.ByteBuffer r0 = r5.byteBuffer
            io.ktor.utils.io.core.BufferUtilsJvmKt.resetFromContentToWrite(r6, r0)
            io.ktor.utils.io.ByteBufferChannel r6 = r5.current
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r6.currentState$ktor_io()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.capacity
            r5.ringBufferCapacity = r6
        L_0x0090:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.WriteSessionImpl.tryAwaitJoinSwitch(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void flush() {
        this.current.flush();
    }
}
