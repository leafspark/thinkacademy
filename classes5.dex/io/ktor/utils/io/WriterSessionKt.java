package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a#\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a%\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001ao\u0010\u0012\u001a\u00020\u0006*\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00060\u0014HHø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0004*\u00020\nH\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"writeBufferFallback", "Lio/ktor/utils/io/core/Buffer;", "writeBufferSuspend", "session", "Lio/ktor/utils/io/WriterSuspendSession;", "desiredSpace", "", "(Lio/ktor/utils/io/WriterSuspendSession;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeWriting", "", "Lio/ktor/utils/io/ByteWriteChannel;", "buffer", "written", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeWritingFallback", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestWriteBuffer", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "block", "Lkotlin/Function3;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", "freeSpace", "", "startOffset", "endExclusive", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeSessionFor", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WriterSession.kt */
public final class WriterSessionKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: kotlin.jvm.functions.Function3<? super io.ktor.utils.io.bits.Memory, ? super java.lang.Long, ? super java.lang.Long, java.lang.Integer>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object write(io.ktor.utils.io.ByteWriteChannel r10, int r11, kotlin.jvm.functions.Function3<? super io.ktor.utils.io.bits.Memory, ? super java.lang.Long, ? super java.lang.Long, java.lang.Integer> r12, kotlin.coroutines.Continuation<? super java.lang.Integer> r13) {
        /*
            boolean r0 = r13 instanceof io.ktor.utils.io.WriterSessionKt$write$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            io.ktor.utils.io.WriterSessionKt$write$1 r0 = (io.ktor.utils.io.WriterSessionKt$write$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.WriterSessionKt$write$1 r0 = new io.ktor.utils.io.WriterSessionKt$write$1
            r0.<init>(r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x003d
            if (r2 == r3) goto L_0x0034
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0034:
            java.lang.Object r10 = r0.L$0
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00c0
        L_0x003d:
            java.lang.Object r10 = r0.L$0
            java.lang.Integer r10 = (java.lang.Integer) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00aa
        L_0x0045:
            java.lang.Object r10 = r0.L$1
            r12 = r10
            kotlin.jvm.functions.Function3 r12 = (kotlin.jvm.functions.Function3) r12
            java.lang.Object r10 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r10 = (io.ktor.utils.io.ByteWriteChannel) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0062
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r13)
            r0.L$0 = r10
            r0.L$1 = r12
            r0.label = r5
            java.lang.Object r13 = requestWriteBuffer(r10, r11, r0)
            if (r13 != r1) goto L_0x0062
            return r1
        L_0x0062:
            io.ktor.utils.io.core.Buffer r13 = (io.ktor.utils.io.core.Buffer) r13
            if (r13 != 0) goto L_0x006c
            io.ktor.utils.io.core.Buffer$Companion r11 = io.ktor.utils.io.core.Buffer.Companion
            io.ktor.utils.io.core.Buffer r13 = r11.getEmpty()
        L_0x006c:
            r11 = 0
            r2 = 0
            java.nio.ByteBuffer r6 = r13.m184getMemorySK3TCg8()     // Catch:{ all -> 0x00ae }
            io.ktor.utils.io.bits.Memory r6 = io.ktor.utils.io.bits.Memory.m39boximpl(r6)     // Catch:{ all -> 0x00ae }
            int r7 = r13.getWritePosition()     // Catch:{ all -> 0x00ae }
            long r7 = (long) r7     // Catch:{ all -> 0x00ae }
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)     // Catch:{ all -> 0x00ae }
            int r8 = r13.getLimit()     // Catch:{ all -> 0x00ae }
            long r8 = (long) r8     // Catch:{ all -> 0x00ae }
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)     // Catch:{ all -> 0x00ae }
            java.lang.Object r12 = r12.invoke(r6, r7, r8)     // Catch:{ all -> 0x00ae }
            java.lang.Number r12 = (java.lang.Number) r12     // Catch:{ all -> 0x00ae }
            int r11 = r12.intValue()     // Catch:{ all -> 0x00ae }
            r13.commitWritten(r11)     // Catch:{ all -> 0x00ae }
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)     // Catch:{ all -> 0x00ae }
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            r0.L$0 = r12
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r10 = completeWriting(r10, r13, r11, r0)
            if (r10 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            r10 = r12
        L_0x00aa:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            return r10
        L_0x00ae:
            r12 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            r0.L$0 = r12
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r10 = completeWriting(r10, r13, r11, r0)
            if (r10 != r1) goto L_0x00bf
            return r1
        L_0x00bf:
            r10 = r12
        L_0x00c0:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.WriterSessionKt.write(io.ktor.utils.io.ByteWriteChannel, int, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object write$$forInline(ByteWriteChannel byteWriteChannel, int i, Function3<? super Memory, ? super Long, ? super Long, Integer> function3, Continuation<? super Integer> continuation) {
        int i2;
        InlineMarker.mark(0);
        Object requestWriteBuffer = requestWriteBuffer(byteWriteChannel, i, continuation);
        InlineMarker.mark(1);
        Buffer buffer = (Buffer) requestWriteBuffer;
        if (buffer == null) {
            buffer = Buffer.Companion.getEmpty();
        }
        try {
            i2 = ((Number) function3.invoke(Memory.m39boximpl(buffer.m184getMemorySK3TCg8()), Long.valueOf((long) buffer.getWritePosition()), Long.valueOf((long) buffer.getLimit()))).intValue();
            try {
                buffer.commitWritten(i2);
                Integer valueOf = Integer.valueOf(i2);
                InlineMarker.finallyStart(1);
                InlineMarker.mark(0);
                completeWriting(byteWriteChannel, buffer, i2, continuation);
                InlineMarker.mark(1);
                InlineMarker.finallyEnd(1);
                return valueOf;
            } catch (Throwable th) {
                th = th;
                InlineMarker.finallyStart(1);
                InlineMarker.mark(0);
                completeWriting(byteWriteChannel, buffer, i2, continuation);
                InlineMarker.mark(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i2 = 0;
            InlineMarker.finallyStart(1);
            InlineMarker.mark(0);
            completeWriting(byteWriteChannel, buffer, i2, continuation);
            InlineMarker.mark(1);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function3 function3, Continuation continuation, int i2, Object obj) {
        int i3;
        if ((i2 & 1) != 0) {
            i = 1;
        }
        InlineMarker.mark(0);
        Object requestWriteBuffer = requestWriteBuffer(byteWriteChannel, i, continuation);
        InlineMarker.mark(1);
        Buffer buffer = (Buffer) requestWriteBuffer;
        if (buffer == null) {
            buffer = Buffer.Companion.getEmpty();
        }
        try {
            i3 = ((Number) function3.invoke(Memory.m39boximpl(buffer.m184getMemorySK3TCg8()), Long.valueOf((long) buffer.getWritePosition()), Long.valueOf((long) buffer.getLimit()))).intValue();
            try {
                buffer.commitWritten(i3);
                Integer valueOf = Integer.valueOf(i3);
                InlineMarker.finallyStart(1);
                InlineMarker.mark(0);
                completeWriting(byteWriteChannel, buffer, i3, continuation);
                InlineMarker.mark(1);
                InlineMarker.finallyEnd(1);
                return valueOf;
            } catch (Throwable th) {
                th = th;
                InlineMarker.finallyStart(1);
                InlineMarker.mark(0);
                completeWriting(byteWriteChannel, buffer, i3, continuation);
                InlineMarker.mark(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i3 = 0;
            InlineMarker.finallyStart(1);
            InlineMarker.mark(0);
            completeWriting(byteWriteChannel, buffer, i3, continuation);
            InlineMarker.mark(1);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final Object completeWriting(ByteWriteChannel byteWriteChannel, Buffer buffer, int i, Continuation<? super Unit> continuation) {
        if (byteWriteChannel instanceof HasWriteSession) {
            ((HasWriteSession) byteWriteChannel).endWriteSession(i);
            return Unit.INSTANCE;
        }
        Object completeWritingFallback = completeWritingFallback(byteWriteChannel, buffer, continuation);
        return completeWritingFallback == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? completeWritingFallback : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: io.ktor.utils.io.core.Buffer} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object completeWritingFallback(io.ktor.utils.io.ByteWriteChannel r4, io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1 r0 = (io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1 r0 = new io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0049
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5 instanceof io.ktor.utils.io.core.internal.ChunkBuffer
            if (r6 == 0) goto L_0x0057
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.writeFully((io.ktor.utils.io.core.Buffer) r5, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r4 != r1) goto L_0x0049
            return r1
        L_0x0049:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = (io.ktor.utils.io.core.internal.ChunkBuffer) r5
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r4 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.pool.ObjectPool r4 = r4.getPool()
            r5.release(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0057:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.String r5 = "Only ChunkBuffer instance is supported."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.WriterSessionKt.completeWritingFallback(io.ktor.utils.io.ByteWriteChannel, io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object writeBufferSuspend(io.ktor.utils.io.WriterSuspendSession r4, int r5, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.Buffer> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1 r0 = (io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1 r0 = new io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            int r5 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.WriterSuspendSession r4 = (io.ktor.utils.io.WriterSuspendSession) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0048
        L_0x0030:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.tryAwait(r5, r0)
            if (r6 != r1) goto L_0x0048
            return r1
        L_0x0048:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = r4.request(r5)
            if (r5 == 0) goto L_0x0051
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5
            goto L_0x0058
        L_0x0051:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = r4.request(r3)
            r5 = r4
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5
        L_0x0058:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.WriterSessionKt.writeBufferSuspend(io.ktor.utils.io.WriterSuspendSession, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Buffer writeBufferFallback() {
        ChunkBuffer borrow = ChunkBuffer.Companion.getPool().borrow();
        ChunkBuffer chunkBuffer = borrow;
        chunkBuffer.resetForWrite();
        chunkBuffer.reserveEndGap(8);
        return borrow;
    }

    private static final WriterSuspendSession writeSessionFor(ByteWriteChannel byteWriteChannel) {
        if (byteWriteChannel instanceof HasWriteSession) {
            return ((HasWriteSession) byteWriteChannel).beginWriteSession();
        }
        return null;
    }

    public static final Object requestWriteBuffer(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Buffer> continuation) {
        WriterSuspendSession beginWriteSession = byteWriteChannel instanceof HasWriteSession ? ((HasWriteSession) byteWriteChannel).beginWriteSession() : null;
        if (beginWriteSession == null) {
            return writeBufferFallback();
        }
        ChunkBuffer request = beginWriteSession.request(i);
        if (request != null) {
            return request;
        }
        return writeBufferSuspend(beginWriteSession, i, continuation);
    }
}
