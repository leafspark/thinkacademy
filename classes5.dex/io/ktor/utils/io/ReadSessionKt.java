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
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001ao\u0010\b\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00062K\u0010\n\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000bHHø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u0002H\b\u001a\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001d\u0010\u0018\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001f\u0010\u001a\u001a\u0004\u0018\u00010\u0004*\u00020\u00152\u0006\u0010\t\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"completeReadingFromBuffer", "", "Lio/ktor/utils/io/ByteReadChannel;", "buffer", "Lio/ktor/utils/io/core/Buffer;", "bytesRead", "", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "desiredSize", "block", "Lkotlin/Function3;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", "source", "", "start", "endExclusive", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readSessionFor", "Lio/ktor/utils/io/SuspendableReadSession;", "requestBuffer", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestBufferFallback", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "requestBufferSuspend", "(Lio/ktor/utils/io/SuspendableReadSession;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadSession.kt */
public final class ReadSessionKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: kotlin.jvm.functions.Function3<? super io.ktor.utils.io.bits.Memory, ? super java.lang.Long, ? super java.lang.Long, java.lang.Integer>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object read(io.ktor.utils.io.ByteReadChannel r8, int r9, kotlin.jvm.functions.Function3<? super io.ktor.utils.io.bits.Memory, ? super java.lang.Long, ? super java.lang.Long, java.lang.Integer> r10, kotlin.coroutines.Continuation<? super java.lang.Integer> r11) {
        /*
            boolean r0 = r11 instanceof io.ktor.utils.io.ReadSessionKt$read$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.utils.io.ReadSessionKt$read$1 r0 = (io.ktor.utils.io.ReadSessionKt$read$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ReadSessionKt$read$1 r0 = new io.ktor.utils.io.ReadSessionKt$read$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x005b
            if (r2 == r5) goto L_0x004e
            if (r2 == r4) goto L_0x003d
            if (r2 == r3) goto L_0x0034
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            java.lang.Object r8 = r0.L$0
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c5
        L_0x003d:
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9
            java.lang.Object r10 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r10 = (io.ktor.utils.io.ByteReadChannel) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x004b }
            goto L_0x00ad
        L_0x004b:
            r8 = move-exception
            goto L_0x00b6
        L_0x004e:
            java.lang.Object r8 = r0.L$1
            r10 = r8
            kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r8 = (io.ktor.utils.io.ByteReadChannel) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006b
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.L$0 = r8
            r0.L$1 = r10
            r0.label = r5
            java.lang.Object r11 = requestBuffer(r8, r9, r0)
            if (r11 != r1) goto L_0x006b
            return r1
        L_0x006b:
            io.ktor.utils.io.core.Buffer r11 = (io.ktor.utils.io.core.Buffer) r11
            if (r11 != 0) goto L_0x0076
            io.ktor.utils.io.core.Buffer$Companion r9 = io.ktor.utils.io.core.Buffer.Companion
            io.ktor.utils.io.core.Buffer r9 = r9.getEmpty()
            goto L_0x0077
        L_0x0076:
            r9 = r11
        L_0x0077:
            java.nio.ByteBuffer r11 = r9.m184getMemorySK3TCg8()     // Catch:{ all -> 0x00b2 }
            io.ktor.utils.io.bits.Memory r11 = io.ktor.utils.io.bits.Memory.m39boximpl(r11)     // Catch:{ all -> 0x00b2 }
            int r2 = r9.getReadPosition()     // Catch:{ all -> 0x00b2 }
            long r5 = (long) r2     // Catch:{ all -> 0x00b2 }
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)     // Catch:{ all -> 0x00b2 }
            int r5 = r9.getWritePosition()     // Catch:{ all -> 0x00b2 }
            long r5 = (long) r5     // Catch:{ all -> 0x00b2 }
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)     // Catch:{ all -> 0x00b2 }
            java.lang.Object r10 = r10.invoke(r11, r2, r5)     // Catch:{ all -> 0x00b2 }
            java.lang.Number r10 = (java.lang.Number) r10     // Catch:{ all -> 0x00b2 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x00b2 }
            r0.L$0 = r8     // Catch:{ all -> 0x00b2 }
            r0.L$1 = r9     // Catch:{ all -> 0x00b2 }
            r0.I$0 = r10     // Catch:{ all -> 0x00b2 }
            r0.label = r4     // Catch:{ all -> 0x00b2 }
            java.lang.Object r11 = completeReadingFromBuffer(r8, r9, r10, r0)     // Catch:{ all -> 0x00b2 }
            if (r11 != r1) goto L_0x00aa
            return r1
        L_0x00aa:
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x00ad:
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)     // Catch:{ all -> 0x004b }
            return r8
        L_0x00b2:
            r10 = move-exception
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x00b6:
            r11 = 0
            r0.L$0 = r8
            r2 = 0
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r9 = completeReadingFromBuffer(r10, r9, r11, r0)
            if (r9 != r1) goto L_0x00c5
            return r1
        L_0x00c5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt.read(io.ktor.utils.io.ByteReadChannel, int, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    private static final Object read$$forInline(ByteReadChannel byteReadChannel, int i, Function3<? super Memory, ? super Long, ? super Long, Integer> function3, Continuation<? super Integer> continuation) {
        InlineMarker.mark(0);
        Object requestBuffer = requestBuffer(byteReadChannel, i, continuation);
        InlineMarker.mark(1);
        Buffer buffer = (Buffer) requestBuffer;
        if (buffer == null) {
            buffer = Buffer.Companion.getEmpty();
        }
        try {
            int intValue = ((Number) function3.invoke(Memory.m39boximpl(buffer.m184getMemorySK3TCg8()), Long.valueOf((long) buffer.getReadPosition()), Long.valueOf((long) buffer.getWritePosition()))).intValue();
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, buffer, intValue, continuation);
            InlineMarker.mark(1);
            return Integer.valueOf(intValue);
        } catch (Throwable th) {
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, buffer, 0, continuation);
            InlineMarker.mark(1);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static /* synthetic */ Object read$default(ByteReadChannel byteReadChannel, int i, Function3 function3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        InlineMarker.mark(0);
        Object requestBuffer = requestBuffer(byteReadChannel, i, continuation);
        InlineMarker.mark(1);
        Buffer buffer = (Buffer) requestBuffer;
        if (buffer == null) {
            buffer = Buffer.Companion.getEmpty();
        }
        try {
            int intValue = ((Number) function3.invoke(Memory.m39boximpl(buffer.m184getMemorySK3TCg8()), Long.valueOf((long) buffer.getReadPosition()), Long.valueOf((long) buffer.getWritePosition()))).intValue();
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, buffer, intValue, continuation);
            InlineMarker.mark(1);
            return Integer.valueOf(intValue);
        } catch (Throwable th) {
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, buffer, 0, continuation);
            InlineMarker.mark(1);
            throw th;
        }
    }

    public static final Object requestBuffer(ByteReadChannel byteReadChannel, int i, Continuation<? super Buffer> continuation) {
        SuspendableReadSession suspendableReadSession;
        if (byteReadChannel instanceof SuspendableReadSession) {
            suspendableReadSession = (SuspendableReadSession) byteReadChannel;
        } else {
            suspendableReadSession = byteReadChannel instanceof HasReadSession ? ((HasReadSession) byteReadChannel).startReadSession() : null;
        }
        if (suspendableReadSession == null) {
            return requestBufferFallback(byteReadChannel, i, continuation);
        }
        ChunkBuffer request = suspendableReadSession.request(RangesKt.coerceAtMost(i, 8));
        if (request != null) {
            return request;
        }
        return requestBufferSuspend(suspendableReadSession, i, continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestBufferSuspend(io.ktor.utils.io.SuspendableReadSession r4, int r5, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.Buffer> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1 r0 = (io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1 r0 = new io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.SuspendableReadSession r4 = (io.ktor.utils.io.SuspendableReadSession) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.await(r5, r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = r4.request(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt.requestBufferSuspend(io.ktor.utils.io.SuspendableReadSession, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestBufferFallback(io.ktor.utils.io.ByteReadChannel r15, int r16, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.internal.ChunkBuffer> r17) {
        /*
            r0 = r17
            boolean r1 = r0 instanceof io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1 r1 = (io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1 r1 = new io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1
            r1.<init>(r0)
        L_0x001b:
            r12 = r1
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r1 = r12.L$0
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = (io.ktor.utils.io.core.internal.ChunkBuffer) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0076
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r0)
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r0 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.pool.ObjectPool r0 = r0.getPool()
            java.lang.Object r0 = r0.borrow()
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = (io.ktor.utils.io.core.internal.ChunkBuffer) r0
            java.nio.ByteBuffer r4 = r0.m184getMemorySK3TCg8()
            int r2 = r0.getWritePosition()
            long r5 = (long) r2
            r7 = 0
            r2 = r16
            long r9 = (long) r2
            r2 = r0
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2
            int r11 = r2.getLimit()
            int r2 = r2.getWritePosition()
            int r11 = r11 - r2
            long r13 = (long) r11
            r12.L$0 = r0
            r12.label = r3
            r2 = r15
            r3 = r4
            r4 = r5
            r6 = r7
            r8 = r9
            r10 = r13
            java.lang.Object r2 = r2.m27peekTolBXzO7A(r3, r4, r6, r8, r10, r12)
            if (r2 != r1) goto L_0x0074
            return r1
        L_0x0074:
            r1 = r0
            r0 = r2
        L_0x0076:
            java.lang.Number r0 = (java.lang.Number) r0
            long r2 = r0.longValue()
            int r0 = (int) r2
            r1.commitWritten(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt.requestBufferFallback(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final SuspendableReadSession readSessionFor(ByteReadChannel byteReadChannel) {
        if (byteReadChannel instanceof HasReadSession) {
            return ((HasReadSession) byteReadChannel).startReadSession();
        }
        return null;
    }

    public static final Object completeReadingFromBuffer(ByteReadChannel byteReadChannel, Buffer buffer, int i, Continuation<? super Unit> continuation) {
        if (i >= 0) {
            boolean z = byteReadChannel instanceof HasReadSession;
            SuspendableReadSession startReadSession = z ? ((HasReadSession) byteReadChannel).startReadSession() : null;
            if (startReadSession != null) {
                startReadSession.discard(i);
                if (z) {
                    ((HasReadSession) byteReadChannel).endReadSession();
                }
                return Unit.INSTANCE;
            } else if (!(buffer instanceof ChunkBuffer) || buffer == ChunkBuffer.Companion.getEmpty()) {
                return Unit.INSTANCE;
            } else {
                ((ChunkBuffer) buffer).release(ChunkBuffer.Companion.getPool());
                Object discard = byteReadChannel.discard((long) i, continuation);
                return discard == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? discard : Unit.INSTANCE;
            }
        } else {
            throw new IllegalStateException(("bytesRead shouldn't be negative: " + i).toString());
        }
    }
}
