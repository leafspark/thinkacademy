package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.ByteBuffersKt;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedSendChannelException;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0011\u0010\f\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u000f0\u0011¢\u0006\u0002\b\u0013H\u0017¢\u0006\u0002\u0010\u0014J@\u0010\u0015\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2'\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0016¢\u0006\u0002\b\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010#J$\u0010!\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H\u0016J\u0019\u0010%\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010&\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010#J!\u0010'\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001fH\u0002J-\u0010-\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010.\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010#J$\u0010.\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H\u0016J\u0019\u0010/\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u00100\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u00101\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010#J%\u00102\u001a\u00020\n2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\u0011H@ø\u0001\u0000¢\u0006\u0002\u00103R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialJVM;", "Lio/ktor/utils/io/ByteChannelSequentialBase;", "initial", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "autoFlush", "", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Z)V", "attachedJob", "Lkotlinx/coroutines/Job;", "attachJob", "", "job", "awaitContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookAhead", "R", "visitor", "Lkotlin/Function1;", "Lio/ktor/utils/io/LookAheadSession;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "lookAheadSuspend", "Lkotlin/Function2;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "min", "", "consumer", "Ljava/nio/ByteBuffer;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", "dst", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "block", "readAvailableSuspend", "readFully", "readFullySuspend", "rc0", "(Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReadAvailable", "tryWriteAvailable", "src", "write", "writeAvailable", "writeAvailableSuspend", "writeFully", "writeFullySuspend", "writeWhile", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Session", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteChannelSequentialJVM.kt */
public final class ByteChannelSequentialJVM extends ByteChannelSequentialBase {
    /* access modifiers changed from: private */
    public volatile Job attachedJob;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialJVM(ChunkBuffer chunkBuffer, boolean z) {
        super(chunkBuffer, z, (ObjectPool) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(chunkBuffer, "initial");
    }

    public void attachJob(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.attachedJob = job;
        Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new ByteChannelSequentialJVM$attachJob$1(this), 2, (Object) null);
    }

    public Object writeAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        int tryWriteAvailable = tryWriteAvailable(byteBuffer);
        if (tryWriteAvailable <= 0) {
            if (byteBuffer.hasRemaining()) {
                return writeAvailableSuspend(byteBuffer, continuation);
            }
            tryWriteAvailable = 0;
        }
        return Boxing.boxInt(tryWriteAvailable);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v4 java.lang.Object), (r7v1 java.lang.Object) binds: [B:19:0x005d, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeAvailableSuspend(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0060
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0052
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r4, r0)
            if (r7 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r2 = r5
        L_0x0052:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.writeAvailable((java.nio.ByteBuffer) r6, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r0)
            if (r7 != r1) goto L_0x0060
            return r1
        L_0x0060:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.writeAvailableSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object writeFully(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        tryWriteAvailable(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return Unit.INSTANCE;
        }
        Object writeFullySuspend = writeFullySuspend(byteBuffer, continuation);
        return writeFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFullySuspend : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeFullySuspend(java.nio.ByteBuffer r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0051
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r4
        L_0x003e:
            boolean r6 = r5.hasRemaining()
            if (r6 == 0) goto L_0x0059
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r2.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L_0x0051
            return r1
        L_0x0051:
            int r6 = r2.tryWriteAvailable(r5)
            r2.afterWrite(r6)
            goto L_0x003e
        L_0x0059:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.writeFullySuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int tryWriteAvailable(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        int availableForWrite = getAvailableForWrite();
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause == null) {
                closedCause = (Throwable) new ClosedSendChannelException("Channel closed for write");
            }
            throw closedCause;
        }
        if (remaining != 0) {
            if (remaining <= availableForWrite) {
                OutputArraysJVMKt.writeFully(getWritable(), byteBuffer);
            } else if (availableForWrite != 0) {
                int limit = byteBuffer.limit();
                byteBuffer.limit(byteBuffer.position() + availableForWrite);
                OutputArraysJVMKt.writeFully(getWritable(), byteBuffer);
                byteBuffer.limit(limit);
                remaining = availableForWrite;
            }
            afterWrite(remaining);
            return remaining;
        }
        remaining = 0;
        afterWrite(remaining);
        return remaining;
    }

    public Object readAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        int tryReadAvailable = tryReadAvailable(byteBuffer);
        if (tryReadAvailable != 0) {
            return Boxing.boxInt(tryReadAvailable);
        }
        if (!byteBuffer.hasRemaining()) {
            return Boxing.boxInt(0);
        }
        return readAvailableSuspend(byteBuffer, continuation);
    }

    public int readAvailable(int i, Function1<? super ByteBuffer, Unit> function1) {
        int readPosition;
        int writePosition;
        Intrinsics.checkNotNullParameter(function1, "block");
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        } else if (getAvailableForRead() < i) {
            return -1;
        } else {
            prepareFlushedBytes();
            Input readable = getReadable();
            ChunkBuffer prepareRead = readable.prepareRead(i);
            if (prepareRead != null) {
                int readPosition2 = prepareRead.getReadPosition();
                try {
                    Buffer buffer = prepareRead;
                    ByteBuffer r4 = buffer.m184getMemorySK3TCg8();
                    int readPosition3 = buffer.getReadPosition();
                    int writePosition2 = buffer.getWritePosition() - readPosition3;
                    ByteBuffer r42 = Memory.m50slice87lwejk(r4, readPosition3, writePosition2);
                    int position = r42.position();
                    function1.invoke(r42);
                    int position2 = r42.position() - position;
                    if (r42.limit() == writePosition2) {
                        buffer.discardExact(r42.position());
                        if (readPosition >= readPosition2) {
                            if (readPosition != writePosition) {
                                readable.setHeadPosition(readPosition);
                            }
                            return position2;
                        }
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                } finally {
                    readPosition = prepareRead.getReadPosition();
                    if (readPosition >= readPosition2) {
                        if (readPosition == prepareRead.getWritePosition()) {
                            readable.ensureNext(prepareRead);
                        } else {
                            readable.setHeadPosition(readPosition);
                        }
                        throw th;
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("Buffer's position shouldn't be rewinded");
                }
            } else {
                StringsKt.prematureEndOfStream(i);
                throw new KotlinNothingValueException();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAvailableSuspend(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0052
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.await(r4, r0)
            if (r7 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r2 = r5
        L_0x0052:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0060
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L_0x0060:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.readAvailable((java.nio.ByteBuffer) r6, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r0)
            if (r7 != r1) goto L_0x006e
            return r1
        L_0x006e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.readAvailableSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object readFully(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        int tryReadAvailable = tryReadAvailable(byteBuffer);
        if (tryReadAvailable == -1) {
            throw new EOFException("Channel closed");
        } else if (!byteBuffer.hasRemaining()) {
            return Boxing.boxInt(tryReadAvailable);
        } else {
            return readFullySuspend(byteBuffer, tryReadAvailable, continuation);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readFullySuspend(java.nio.ByteBuffer r8, int r9, kotlin.coroutines.Continuation<? super java.lang.Integer> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            java.nio.ByteBuffer r9 = (java.nio.ByteBuffer) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r9
            r9 = r8
            r8 = r6
            goto L_0x0058
        L_0x0037:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r7
        L_0x0043:
            boolean r10 = r8.hasRemaining()
            if (r10 == 0) goto L_0x0077
            r0.L$0 = r2
            r0.L$1 = r8
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r10 = r2.await(r3, r0)
            if (r10 != r1) goto L_0x0058
            return r1
        L_0x0058:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            java.lang.String r4 = "Channel closed"
            if (r10 == 0) goto L_0x0071
            int r10 = r2.tryReadAvailable(r8)
            r5 = -1
            if (r10 == r5) goto L_0x006b
            int r9 = r9 + r10
            goto L_0x0043
        L_0x006b:
            java.io.EOFException r8 = new java.io.EOFException
            r8.<init>(r4)
            throw r8
        L_0x0071:
            java.io.EOFException r8 = new java.io.EOFException
            r8.<init>(r4)
            throw r8
        L_0x0077:
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.readFullySuspend(java.nio.ByteBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int tryReadAvailable(ByteBuffer byteBuffer) {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        } else if (getClosed() && getAvailableForRead() == 0) {
            return -1;
        } else {
            if (!getReadable().canRead()) {
                prepareFlushedBytes();
            }
            int readAvailable = ByteBuffersKt.readAvailable(getReadable(), byteBuffer);
            afterRead(readAvailable);
            return readAvailable;
        }
    }

    @Deprecated(message = "Use read { } instead.")
    public <R> R lookAhead(Function1<? super LookAheadSession, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "visitor");
        return function1.invoke(new Session(this));
    }

    @Deprecated(message = "Use read { } instead.")
    public <R> Object lookAheadSuspend(Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return function2.invoke(new Session(this), continuation);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialJVM$Session;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "channel", "Lio/ktor/utils/io/ByteChannelSequentialJVM;", "(Lio/ktor/utils/io/ByteChannelSequentialJVM;)V", "awaitAtLeast", "", "n", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumed", "", "request", "Ljava/nio/ByteBuffer;", "skip", "atLeast", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ByteChannelSequentialJVM.kt */
    private static final class Session implements LookAheadSuspendSession {
        private final ByteChannelSequentialJVM channel;

        public Session(ByteChannelSequentialJVM byteChannelSequentialJVM) {
            Intrinsics.checkNotNullParameter(byteChannelSequentialJVM, "channel");
            this.channel = byteChannelSequentialJVM;
        }

        public Object awaitAtLeast(int i, Continuation<? super Boolean> continuation) {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause == null) {
                return this.channel.await(i, continuation);
            }
            throw closedCause;
        }

        public void consumed(int i) {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause == null) {
                this.channel.discard(i);
                return;
            }
            throw closedCause;
        }

        public ByteBuffer request(int i, int i2) {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            } else if (this.channel.isClosedForRead()) {
                return null;
            } else {
                if (this.channel.getReadable().getEndOfInput()) {
                    this.channel.prepareFlushedBytes();
                }
                ChunkBuffer head = this.channel.getReadable().getHead();
                Buffer buffer = head;
                if (buffer.getWritePosition() - buffer.getReadPosition() < i2 + i) {
                    return null;
                }
                ByteBuffer slice = head.m184getMemorySK3TCg8().slice();
                slice.position(head.getReadPosition() + i);
                slice.limit(head.getWritePosition());
                return slice;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object read(int r9, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            java.lang.String r0 = "Buffer's position shouldn't be rewinded"
            boolean r1 = r11 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$read$1
            if (r1 == 0) goto L_0x0016
            r1 = r11
            io.ktor.utils.io.ByteChannelSequentialJVM$read$1 r1 = (io.ktor.utils.io.ByteChannelSequentialJVM$read$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r11 = r1.label
            int r11 = r11 - r3
            r1.label = r11
            goto L_0x001b
        L_0x0016:
            io.ktor.utils.io.ByteChannelSequentialJVM$read$1 r1 = new io.ktor.utils.io.ByteChannelSequentialJVM$read$1
            r1.<init>(r8, r11)
        L_0x001b:
            java.lang.Object r11 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x003f
            if (r3 != r5) goto L_0x0037
            int r9 = r1.I$0
            java.lang.Object r10 = r1.L$1
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r1 = r1.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r1 = (io.ktor.utils.io.ByteChannelSequentialJVM) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0059
        L_0x0037:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r9 < 0) goto L_0x0046
            r11 = r5
            goto L_0x0047
        L_0x0046:
            r11 = r4
        L_0x0047:
            if (r11 == 0) goto L_0x0100
            r1.L$0 = r8
            r1.L$1 = r10
            r1.I$0 = r9
            r1.label = r5
            java.lang.Object r11 = r8.await(r9, r1)
            if (r11 != r2) goto L_0x0058
            return r2
        L_0x0058:
            r1 = r8
        L_0x0059:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00e4
            io.ktor.utils.io.core.ByteReadPacket r11 = r1.getReadable()
            io.ktor.utils.io.core.Input r11 = (io.ktor.utils.io.core.Input) r11
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = r11.prepareRead(r9)
            if (r1 == 0) goto L_0x00db
            int r9 = r1.getReadPosition()
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x00c0 }
            java.nio.ByteBuffer r3 = r2.m184getMemorySK3TCg8()     // Catch:{ all -> 0x00c0 }
            int r6 = r2.getReadPosition()     // Catch:{ all -> 0x00c0 }
            int r7 = r2.getWritePosition()     // Catch:{ all -> 0x00c0 }
            int r7 = r7 - r6
            java.nio.ByteBuffer r3 = io.ktor.utils.io.bits.Memory.m50slice87lwejk((java.nio.ByteBuffer) r3, (int) r6, (int) r7)     // Catch:{ all -> 0x00c0 }
            r10.invoke(r3)     // Catch:{ all -> 0x00c0 }
            int r10 = r3.limit()     // Catch:{ all -> 0x00c0 }
            if (r10 != r7) goto L_0x008f
            r4 = r5
        L_0x008f:
            if (r4 == 0) goto L_0x00b4
            int r10 = r3.position()     // Catch:{ all -> 0x00c0 }
            r2.discardExact(r10)     // Catch:{ all -> 0x00c0 }
            int r10 = r1.getReadPosition()
            if (r10 < r9) goto L_0x00ae
            int r9 = r1.getWritePosition()
            if (r10 != r9) goto L_0x00a8
            r11.ensureNext(r1)
            goto L_0x00ab
        L_0x00a8:
            r11.setHeadPosition(r10)
        L_0x00ab:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00ae:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r0)
            throw r9
        L_0x00b4:
            java.lang.String r10 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c0 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00c0 }
            r2.<init>(r10)     // Catch:{ all -> 0x00c0 }
            throw r2     // Catch:{ all -> 0x00c0 }
        L_0x00c0:
            r10 = move-exception
            int r2 = r1.getReadPosition()
            if (r2 < r9) goto L_0x00d5
            int r9 = r1.getWritePosition()
            if (r2 != r9) goto L_0x00d1
            r11.ensureNext(r1)
            goto L_0x00d4
        L_0x00d1:
            r11.setHeadPosition(r2)
        L_0x00d4:
            throw r10
        L_0x00d5:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r0)
            throw r9
        L_0x00db:
            io.ktor.utils.io.core.StringsKt.prematureEndOfStream((int) r9)
            kotlin.KotlinNothingValueException r9 = new kotlin.KotlinNothingValueException
            r9.<init>()
            throw r9
        L_0x00e4:
            java.io.EOFException r10 = new java.io.EOFException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Channel closed while "
            r11.append(r0)
            r11.append(r9)
            java.lang.String r9 = " bytes expected"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            throw r10
        L_0x0100:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Failed requirement."
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.read(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object awaitContent(Continuation<? super Unit> continuation) {
        Object await = await(1, continuation);
        return await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? await : Unit.INSTANCE;
    }

    public int writeAvailable(int i, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause == null) {
                closedCause = (Throwable) new ClosedSendChannelException("Channel closed for write");
            }
            throw closedCause;
        }
        boolean z = false;
        if (getAvailableForWrite() < i) {
            return 0;
        }
        Output writable = getWritable();
        try {
            Buffer prepareWriteHead = writable.prepareWriteHead(i);
            ByteBuffer r2 = prepareWriteHead.m184getMemorySK3TCg8();
            int writePosition = prepareWriteHead.getWritePosition();
            int limit = prepareWriteHead.getLimit() - writePosition;
            ByteBuffer r22 = Memory.m50slice87lwejk(r2, writePosition, limit);
            int position = r22.position();
            function1.invoke(r22);
            int position2 = r22.position() - position;
            if (r22.limit() == limit) {
                int position3 = r22.position();
                prepareWriteHead.commitWritten(position3);
                if (position3 >= 0) {
                    z = true;
                }
                if (z) {
                    return position2;
                }
                throw new IllegalStateException("The returned value shouldn't be negative".toString());
            }
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        } finally {
            writable.afterHeadWrite();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0091 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b3 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object write(int r6, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$write$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialJVM$write$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$write$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialJVM$write$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$write$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r0 = (io.ktor.utils.io.ByteChannelSequentialJVM) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0065
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r5.getClosed()
            if (r8 == 0) goto L_0x0055
            java.lang.Throwable r6 = r5.getClosedCause()
            if (r6 != 0) goto L_0x0054
            kotlinx.coroutines.channels.ClosedSendChannelException r6 = new kotlinx.coroutines.channels.ClosedSendChannelException
            java.lang.String r7 = "Channel closed for write"
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
        L_0x0054:
            throw r6
        L_0x0055:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r8 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r6, r0)
            if (r8 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r0 = r5
        L_0x0065:
            io.ktor.utils.io.core.BytePacketBuilder r8 = r0.getWritable()
            io.ktor.utils.io.core.Output r8 = (io.ktor.utils.io.core.Output) r8
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = r8.prepareWriteHead(r6)
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6     // Catch:{ all -> 0x00bf }
            java.nio.ByteBuffer r1 = r6.m184getMemorySK3TCg8()     // Catch:{ all -> 0x00bf }
            int r2 = r6.getWritePosition()     // Catch:{ all -> 0x00bf }
            int r4 = r6.getLimit()     // Catch:{ all -> 0x00bf }
            int r4 = r4 - r2
            java.nio.ByteBuffer r1 = io.ktor.utils.io.bits.Memory.m50slice87lwejk((java.nio.ByteBuffer) r1, (int) r2, (int) r4)     // Catch:{ all -> 0x00bf }
            r7.invoke(r1)     // Catch:{ all -> 0x00bf }
            int r7 = r1.limit()     // Catch:{ all -> 0x00bf }
            r2 = 0
            if (r7 != r4) goto L_0x008e
            r7 = r3
            goto L_0x008f
        L_0x008e:
            r7 = r2
        L_0x008f:
            if (r7 == 0) goto L_0x00b3
            int r7 = r1.position()     // Catch:{ all -> 0x00bf }
            r6.commitWritten(r7)     // Catch:{ all -> 0x00bf }
            if (r7 < 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r3 = r2
        L_0x009c:
            if (r3 == 0) goto L_0x00a7
            r8.afterHeadWrite()
            r0.afterWrite(r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00a7:
            java.lang.String r6 = "The returned value shouldn't be negative"
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00bf }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00bf }
            r7.<init>(r6)     // Catch:{ all -> 0x00bf }
            throw r7     // Catch:{ all -> 0x00bf }
        L_0x00b3:
            java.lang.String r6 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00bf }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00bf }
            r7.<init>(r6)     // Catch:{ all -> 0x00bf }
            throw r7     // Catch:{ all -> 0x00bf }
        L_0x00bf:
            r6 = move-exception
            r8.afterHeadWrite()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.write(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009e A[Catch:{ all -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a0 A[Catch:{ all -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a3 A[Catch:{ all -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeWhile(kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, java.lang.Boolean> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r11 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r11 = (kotlin.jvm.internal.Ref.BooleanRef) r11
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r4 = (io.ktor.utils.io.ByteChannelSequentialJVM) r4
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x006e
        L_0x0036:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r12)
            r4 = r10
        L_0x0042:
            boolean r12 = r4.getClosed()
            if (r12 == 0) goto L_0x0058
            java.lang.Throwable r11 = r4.getClosedCause()
            if (r11 != 0) goto L_0x0057
            kotlinx.coroutines.channels.ClosedSendChannelException r11 = new kotlinx.coroutines.channels.ClosedSendChannelException
            java.lang.String r12 = "Channel closed for write"
            r11.<init>(r12)
            java.lang.Throwable r11 = (java.lang.Throwable) r11
        L_0x0057:
            throw r11
        L_0x0058:
            kotlin.jvm.internal.Ref$BooleanRef r12 = new kotlin.jvm.internal.Ref$BooleanRef
            r12.<init>()
            r0.L$0 = r4
            r0.L$1 = r11
            r0.L$2 = r12
            r0.label = r3
            java.lang.Object r2 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r2 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r2 = r11
            r11 = r12
        L_0x006e:
            io.ktor.utils.io.core.BytePacketBuilder r12 = r4.getWritable()
            io.ktor.utils.io.core.Output r12 = (io.ktor.utils.io.core.Output) r12
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = r12.prepareWriteHead(r3)
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x00d6 }
            java.nio.ByteBuffer r6 = r5.m184getMemorySK3TCg8()     // Catch:{ all -> 0x00d6 }
            int r7 = r5.getWritePosition()     // Catch:{ all -> 0x00d6 }
            int r8 = r5.getLimit()     // Catch:{ all -> 0x00d6 }
            int r8 = r8 - r7
            java.nio.ByteBuffer r6 = io.ktor.utils.io.bits.Memory.m50slice87lwejk((java.nio.ByteBuffer) r6, (int) r7, (int) r8)     // Catch:{ all -> 0x00d6 }
            java.lang.Object r7 = r2.invoke(r6)     // Catch:{ all -> 0x00d6 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x00d6 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x00d6 }
            r11.element = r7     // Catch:{ all -> 0x00d6 }
            int r7 = r6.limit()     // Catch:{ all -> 0x00d6 }
            r9 = 0
            if (r7 != r8) goto L_0x00a0
            r7 = r3
            goto L_0x00a1
        L_0x00a0:
            r7 = r9
        L_0x00a1:
            if (r7 == 0) goto L_0x00ca
            int r6 = r6.position()     // Catch:{ all -> 0x00d6 }
            r5.commitWritten(r6)     // Catch:{ all -> 0x00d6 }
            if (r6 < 0) goto L_0x00ad
            r9 = r3
        L_0x00ad:
            if (r9 == 0) goto L_0x00be
            r12.afterHeadWrite()
            r4.afterWrite(r6)
            boolean r11 = r11.element
            if (r11 != 0) goto L_0x00bc
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00bc:
            r11 = r2
            goto L_0x0042
        L_0x00be:
            java.lang.String r11 = "The returned value shouldn't be negative"
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00d6 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00d6 }
            r0.<init>(r11)     // Catch:{ all -> 0x00d6 }
            throw r0     // Catch:{ all -> 0x00d6 }
        L_0x00ca:
            java.lang.String r11 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00d6 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00d6 }
            r0.<init>(r11)     // Catch:{ all -> 0x00d6 }
            throw r0     // Catch:{ all -> 0x00d6 }
        L_0x00d6:
            r11 = move-exception
            r12.afterHeadWrite()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.writeWhile(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
