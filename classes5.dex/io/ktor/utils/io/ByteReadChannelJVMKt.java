package io.ktor.utils.io;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.utils.io.internal.JoiningState;
import io.ktor.utils.io.internal.SequentialCopyToKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a%\u0010\r\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"copyTo", "", "Lio/ktor/utils/io/ByteReadChannel;", "dst", "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyToImpl", "joinTo", "", "closeOnEnd", "", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinToImplSuspend", "close", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteReadChannelJVM.kt */
public final class ByteReadChannelJVMKt {
    public static final Object joinTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, boolean z, Continuation<? super Unit> continuation) {
        if (!(byteWriteChannel != byteReadChannel)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!(byteReadChannel instanceof ByteBufferChannel) || !(byteWriteChannel instanceof ByteBufferChannel)) {
            Object joinToImplSuspend = joinToImplSuspend(byteReadChannel, byteWriteChannel, z, continuation);
            return joinToImplSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? joinToImplSuspend : Unit.INSTANCE;
        } else {
            Object joinFrom$ktor_io = ((ByteBufferChannel) byteWriteChannel).joinFrom$ktor_io((ByteBufferChannel) byteReadChannel, z, continuation);
            return joinFrom$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? joinFrom$ktor_io : Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: io.ktor.utils.io.ByteWriteChannel} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object joinToImplSuspend(io.ktor.utils.io.ByteReadChannel r6, io.ktor.utils.io.ByteWriteChannel r7, boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1 r0 = (io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1 r0 = new io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1
            r0.<init>(r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            boolean r8 = r0.Z$0
            java.lang.Object r6 = r0.L$0
            r7 = r6
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004e
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r0.L$0 = r7
            r0.Z$0 = r8
            r0.label = r3
            java.lang.Object r6 = copyTo(r6, r7, r4, r0)
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            if (r8 == 0) goto L_0x0054
            io.ktor.utils.io.ByteWriteChannelKt.close(r7)
            goto L_0x0057
        L_0x0054:
            r7.flush()
        L_0x0057:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelJVMKt.joinToImplSuspend(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object copyTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        if (!(byteReadChannel != byteWriteChannel)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (j == 0) {
            return Boxing.boxLong(0);
        } else {
            if ((byteReadChannel instanceof ByteBufferChannel) && (byteWriteChannel instanceof ByteBufferChannel)) {
                return ((ByteBufferChannel) byteWriteChannel).copyDirect$ktor_io((ByteBufferChannel) byteReadChannel, j, (JoiningState) null, continuation);
            }
            if (!(byteReadChannel instanceof ByteChannelSequentialBase) || !(byteWriteChannel instanceof ByteChannelSequentialBase)) {
                return copyToImpl(byteReadChannel, byteWriteChannel, j, continuation);
            }
            return SequentialCopyToKt.copyToSequentialImpl((ByteChannelSequentialBase) byteReadChannel, (ByteChannelSequentialBase) byteWriteChannel, HttpTimeout.INFINITE_TIMEOUT_MS, continuation);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: io.ktor.utils.io.ByteWriteChannel} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0098 A[SYNTHETIC, Splitter:B:23:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d1 A[Catch:{ all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f9 A[SYNTHETIC, Splitter:B:37:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object copyToImpl(io.ktor.utils.io.ByteReadChannel r21, io.ktor.utils.io.ByteWriteChannel r22, long r23, kotlin.coroutines.Continuation<? super java.lang.Long> r25) {
        /*
            r0 = r25
            boolean r1 = r0 instanceof io.ktor.utils.io.ByteReadChannelJVMKt$copyToImpl$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            io.ktor.utils.io.ByteReadChannelJVMKt$copyToImpl$1 r1 = (io.ktor.utils.io.ByteReadChannelJVMKt$copyToImpl$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            io.ktor.utils.io.ByteReadChannelJVMKt$copyToImpl$1 r1 = new io.ktor.utils.io.ByteReadChannelJVMKt$copyToImpl$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L_0x0073
            if (r3 == r7) goto L_0x0058
            if (r3 != r6) goto L_0x0050
            int r3 = r1.I$1
            long r8 = r1.J$1
            int r10 = r1.I$0
            long r11 = r1.J$0
            java.lang.Object r13 = r1.L$2
            io.ktor.utils.io.core.internal.ChunkBuffer r13 = (io.ktor.utils.io.core.internal.ChunkBuffer) r13
            java.lang.Object r14 = r1.L$1
            io.ktor.utils.io.ByteWriteChannel r14 = (io.ktor.utils.io.ByteWriteChannel) r14
            java.lang.Object r15 = r1.L$0
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0070 }
            r5 = r1
            r4 = r3
            r1 = r14
            r0 = r15
            r17 = r10
            r10 = r2
            r2 = r11
            r11 = r17
            goto L_0x00f5
        L_0x0050:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0058:
            long r8 = r1.J$1
            int r3 = r1.I$0
            long r10 = r1.J$0
            java.lang.Object r12 = r1.L$2
            r13 = r12
            io.ktor.utils.io.core.internal.ChunkBuffer r13 = (io.ktor.utils.io.core.internal.ChunkBuffer) r13
            java.lang.Object r12 = r1.L$1
            r14 = r12
            io.ktor.utils.io.ByteWriteChannel r14 = (io.ktor.utils.io.ByteWriteChannel) r14
            java.lang.Object r12 = r1.L$0
            io.ktor.utils.io.ByteReadChannel r12 = (io.ktor.utils.io.ByteReadChannel) r12
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0070 }
            goto L_0x00c8
        L_0x0070:
            r0 = move-exception
            goto L_0x0121
        L_0x0073:
            kotlin.ResultKt.throwOnFailure(r0)
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r0 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.pool.ObjectPool r0 = r0.getPool()
            java.lang.Object r0 = r0.borrow()
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = (io.ktor.utils.io.core.internal.ChunkBuffer) r0
            boolean r3 = r22.getAutoFlush()
            r3 = r3 ^ r7
            r13 = r0
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r0 = r21
            r1 = r22
            r2 = r23
        L_0x0092:
            long r14 = r2 - r11
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0112
            int r4 = r13.getCapacity()     // Catch:{ all -> 0x0103 }
            long r4 = (long) r4     // Catch:{ all -> 0x0103 }
            long r4 = java.lang.Math.min(r4, r14)     // Catch:{ all -> 0x0103 }
            int r4 = (int) r4     // Catch:{ all -> 0x0103 }
            r13.resetForWrite(r4)     // Catch:{ all -> 0x0103 }
            r8.L$0 = r0     // Catch:{ all -> 0x0103 }
            r8.L$1 = r1     // Catch:{ all -> 0x0103 }
            r8.L$2 = r13     // Catch:{ all -> 0x0103 }
            r8.J$0 = r2     // Catch:{ all -> 0x0103 }
            r8.I$0 = r10     // Catch:{ all -> 0x0103 }
            r8.J$1 = r11     // Catch:{ all -> 0x0103 }
            r8.label = r7     // Catch:{ all -> 0x0103 }
            java.lang.Object r4 = r0.readAvailable((io.ktor.utils.io.core.internal.ChunkBuffer) r13, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r8)     // Catch:{ all -> 0x0103 }
            if (r4 != r9) goto L_0x00ba
            return r9
        L_0x00ba:
            r14 = r1
            r1 = r8
            r17 = r11
            r12 = r0
            r0 = r4
            r19 = r2
            r2 = r9
            r3 = r10
            r8 = r17
            r10 = r19
        L_0x00c8:
            java.lang.Number r0 = (java.lang.Number) r0     // Catch:{ all -> 0x0070 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0070 }
            r4 = -1
            if (r0 == r4) goto L_0x0110
            r4 = r13
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0070 }
            r1.L$0 = r12     // Catch:{ all -> 0x0070 }
            r1.L$1 = r14     // Catch:{ all -> 0x0070 }
            r1.L$2 = r13     // Catch:{ all -> 0x0070 }
            r1.J$0 = r10     // Catch:{ all -> 0x0070 }
            r1.I$0 = r3     // Catch:{ all -> 0x0070 }
            r1.J$1 = r8     // Catch:{ all -> 0x0070 }
            r1.I$1 = r0     // Catch:{ all -> 0x0070 }
            r1.label = r6     // Catch:{ all -> 0x0070 }
            java.lang.Object r4 = r14.writeFully((io.ktor.utils.io.core.Buffer) r4, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r1)     // Catch:{ all -> 0x0070 }
            if (r4 != r2) goto L_0x00eb
            return r2
        L_0x00eb:
            r4 = r0
            r5 = r1
            r0 = r12
            r1 = r14
            r17 = r10
            r10 = r2
            r11 = r3
            r2 = r17
        L_0x00f5:
            long r14 = (long) r4
            long r8 = r8 + r14
            if (r11 == 0) goto L_0x0106
            int r4 = r0.getAvailableForRead()     // Catch:{ all -> 0x0103 }
            if (r4 != 0) goto L_0x0106
            r1.flush()     // Catch:{ all -> 0x0103 }
            goto L_0x0106
        L_0x0103:
            r0 = move-exception
            r14 = r1
            goto L_0x0121
        L_0x0106:
            r17 = r8
            r8 = r5
            r9 = r10
            r10 = r11
            r4 = 0
            r11 = r17
            goto L_0x0092
        L_0x0110:
            r11 = r8
            goto L_0x0113
        L_0x0112:
            r14 = r1
        L_0x0113:
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)     // Catch:{ all -> 0x0070 }
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r1 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.pool.ObjectPool r1 = r1.getPool()
            r13.release(r1)
            return r0
        L_0x0121:
            r14.close(r0)     // Catch:{ all -> 0x0125 }
            throw r0     // Catch:{ all -> 0x0125 }
        L_0x0125:
            r0 = move-exception
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r1 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.pool.ObjectPool r1 = r1.getPool()
            r13.release(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelJVMKt.copyToImpl(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
