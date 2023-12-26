package io.ktor.utils.io.jvm.javaio;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a+\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\fH\u0007¢\u0006\u0002\b\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"copyTo", "", "Ljava/io/InputStream;", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Ljava/io/InputStream;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toByteReadChannel", "Lio/ktor/utils/io/ByteReadChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "", "toByteReadChannelWithArrayPool", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Reading.kt */
public final class ReadingKt {
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.L$2 = r4;
        r5.J$0 = r2;
        r5.J$1 = r12;
        r5.J$2 = r10;
        r5.I$0 = r7;
        r5.label = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a6, code lost:
        if (r1.writeFully(r4, r8, r7, r5) != r6) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a8, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a9, code lost:
        r14 = r0;
        r0 = r7;
        r16 = r10;
        r10 = r12;
        r12 = r16;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b8 A[EDGE_INSN: B:49:0x00b8->B:37:0x00b8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object copyTo(java.io.InputStream r19, io.ktor.utils.io.ByteWriteChannel r20, long r21, kotlin.coroutines.Continuation<? super java.lang.Long> r23) {
        /*
            r0 = r21
            r2 = r23
            boolean r3 = r2 instanceof io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1 r3 = (io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1 r3 = new io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r8 = 0
            r9 = 1
            if (r5 == 0) goto L_0x005d
            if (r5 != r9) goto L_0x0055
            int r0 = r3.I$0
            long r5 = r3.J$2
            long r10 = r3.J$1
            long r12 = r3.J$0
            java.lang.Object r1 = r3.L$2
            byte[] r1 = (byte[]) r1
            java.lang.Object r7 = r3.L$1
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            java.lang.Object r14 = r3.L$0
            java.io.InputStream r14 = (java.io.InputStream) r14
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0052 }
            r16 = r4
            r4 = r1
            r1 = r7
            r17 = r5
            r5 = r3
            r6 = r16
            r2 = r12
            r12 = r17
            goto L_0x00b0
        L_0x0052:
            r0 = move-exception
            goto L_0x00c9
        L_0x0055:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005d:
            kotlin.ResultKt.throwOnFailure(r2)
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0066
            r2 = r9
            goto L_0x0067
        L_0x0066:
            r2 = r8
        L_0x0067:
            if (r2 == 0) goto L_0x00d1
            io.ktor.utils.io.pool.ObjectPool r2 = io.ktor.utils.io.pool.ByteArrayPoolKt.getByteArrayPool()
            java.lang.Object r2 = r2.borrow()
            byte[] r2 = (byte[]) r2
            int r5 = r2.length     // Catch:{ all -> 0x00c7 }
            long r10 = (long) r5
            r5 = r3
            r12 = r6
            r6 = r4
            r4 = r2
            r2 = r0
            r0 = r19
            r1 = r20
        L_0x007e:
            int r7 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x00b8
            long r14 = r2 - r12
            long r14 = java.lang.Math.min(r14, r10)     // Catch:{ all -> 0x00c4 }
            int r7 = (int) r14     // Catch:{ all -> 0x00c4 }
            int r7 = r0.read(r4, r8, r7)     // Catch:{ all -> 0x00c4 }
            r14 = -1
            if (r7 == r14) goto L_0x00b8
            if (r7 <= 0) goto L_0x007e
            r5.L$0 = r0     // Catch:{ all -> 0x00c4 }
            r5.L$1 = r1     // Catch:{ all -> 0x00c4 }
            r5.L$2 = r4     // Catch:{ all -> 0x00c4 }
            r5.J$0 = r2     // Catch:{ all -> 0x00c4 }
            r5.J$1 = r12     // Catch:{ all -> 0x00c4 }
            r5.J$2 = r10     // Catch:{ all -> 0x00c4 }
            r5.I$0 = r7     // Catch:{ all -> 0x00c4 }
            r5.label = r9     // Catch:{ all -> 0x00c4 }
            java.lang.Object r14 = r1.writeFully(r4, r8, r7, r5)     // Catch:{ all -> 0x00c4 }
            if (r14 != r6) goto L_0x00a9
            return r6
        L_0x00a9:
            r14 = r0
            r0 = r7
            r16 = r10
            r10 = r12
            r12 = r16
        L_0x00b0:
            long r8 = (long) r0     // Catch:{ all -> 0x00c4 }
            long r8 = r8 + r10
            r10 = r12
            r0 = r14
            r12 = r8
            r8 = 0
            r9 = 1
            goto L_0x007e
        L_0x00b8:
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r12)     // Catch:{ all -> 0x00c4 }
            io.ktor.utils.io.pool.ObjectPool r1 = io.ktor.utils.io.pool.ByteArrayPoolKt.getByteArrayPool()
            r1.recycle(r4)
            return r0
        L_0x00c4:
            r0 = move-exception
            r1 = r4
            goto L_0x00c9
        L_0x00c7:
            r0 = move-exception
            r1 = r2
        L_0x00c9:
            io.ktor.utils.io.pool.ObjectPool r2 = io.ktor.utils.io.pool.ByteArrayPoolKt.getByteArrayPool()
            r2.recycle(r1)
            throw r0
        L_0x00d1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Limit shouldn't be negative: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.ReadingKt.copyTo(java.io.InputStream, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(InputStream inputStream, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = HttpTimeout.INFINITE_TIMEOUT_MS;
        }
        return copyTo(inputStream, byteWriteChannel, j, continuation);
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannel$default(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) Dispatchers.getIO();
        }
        return toByteReadChannel(inputStream, coroutineContext, objectPool);
    }

    public static final ByteReadChannel toByteReadChannel(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool<ByteBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        return CoroutinesKt.writer((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new ReadingKt$toByteReadChannel$1(objectPool, inputStream, (Continuation<? super ReadingKt$toByteReadChannel$1>) null)).getChannel();
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannelWithArrayPool$default(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool<byte[]> objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) Dispatchers.getIO();
        }
        if ((i & 2) != 0) {
            objectPool = ByteArrayPoolKt.getByteArrayPool();
        }
        return toByteReadChannelWithArrayPool(inputStream, coroutineContext, objectPool);
    }

    public static final ByteReadChannel toByteReadChannelWithArrayPool(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool<byte[]> objectPool) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        return CoroutinesKt.writer((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new ReadingKt$toByteReadChannel$2(objectPool, inputStream, (Continuation<? super ReadingKt$toByteReadChannel$2>) null)).getChannel();
    }
}
