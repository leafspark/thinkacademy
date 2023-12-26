package io.ktor.utils.io.jvm.javaio;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.utils.io.ByteReadChannel;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"copyTo", "", "Lio/ktor/utils/io/ByteReadChannel;", "out", "Ljava/io/OutputStream;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/io/OutputStream;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Writing.kt */
public final class WritingKt {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ab A[Catch:{ all -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r19, java.io.OutputStream r20, long r21, kotlin.coroutines.Continuation<? super java.lang.Long> r23) {
        /*
            r0 = r21
            r2 = r23
            boolean r3 = r2 instanceof io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1 r3 = (io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1 r3 = new io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r8 = 0
            r9 = 1
            if (r5 == 0) goto L_0x005b
            if (r5 != r9) goto L_0x0053
            long r0 = r3.J$2
            long r5 = r3.J$1
            long r10 = r3.J$0
            java.lang.Object r7 = r3.L$2
            byte[] r7 = (byte[]) r7
            java.lang.Object r12 = r3.L$1
            java.io.OutputStream r12 = (java.io.OutputStream) r12
            java.lang.Object r13 = r3.L$0
            io.ktor.utils.io.ByteReadChannel r13 = (io.ktor.utils.io.ByteReadChannel) r13
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0050 }
            r16 = r4
            r4 = r3
            r3 = r7
            r6 = r5
            r5 = r16
            r17 = r0
            r1 = r12
            r0 = r13
            r12 = r17
            goto L_0x00a2
        L_0x0050:
            r0 = move-exception
            goto L_0x00cf
        L_0x0053:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r2)
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0064
            r2 = r9
            goto L_0x0065
        L_0x0064:
            r2 = r8
        L_0x0065:
            if (r2 == 0) goto L_0x00d7
            io.ktor.utils.io.pool.ObjectPool r2 = io.ktor.utils.io.pool.ByteArrayPoolKt.getByteArrayPool()
            java.lang.Object r2 = r2.borrow()
            byte[] r2 = (byte[]) r2
            int r5 = r2.length     // Catch:{ all -> 0x00cd }
            long r10 = (long) r5
            r12 = r2
            r5 = r4
            r4 = r3
            r2 = r0
            r0 = r19
            r1 = r20
        L_0x007b:
            int r13 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r13 >= 0) goto L_0x00be
            long r13 = r2 - r6
            long r13 = java.lang.Math.min(r13, r10)     // Catch:{ all -> 0x00ca }
            int r13 = (int) r13     // Catch:{ all -> 0x00ca }
            r4.L$0 = r0     // Catch:{ all -> 0x00ca }
            r4.L$1 = r1     // Catch:{ all -> 0x00ca }
            r4.L$2 = r12     // Catch:{ all -> 0x00ca }
            r4.J$0 = r2     // Catch:{ all -> 0x00ca }
            r4.J$1 = r6     // Catch:{ all -> 0x00ca }
            r4.J$2 = r10     // Catch:{ all -> 0x00ca }
            r4.label = r9     // Catch:{ all -> 0x00ca }
            java.lang.Object r13 = r0.readAvailable(r12, r8, r13, r4)     // Catch:{ all -> 0x00ca }
            if (r13 != r5) goto L_0x009b
            return r5
        L_0x009b:
            r16 = r2
            r3 = r12
            r2 = r13
            r12 = r10
            r10 = r16
        L_0x00a2:
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x00bb }
            int r2 = r2.intValue()     // Catch:{ all -> 0x00bb }
            r14 = -1
            if (r2 == r14) goto L_0x00b9
            if (r2 <= 0) goto L_0x00b2
            r1.write(r3, r8, r2)     // Catch:{ all -> 0x00bb }
            long r14 = (long) r2
            long r6 = r6 + r14
        L_0x00b2:
            r16 = r12
            r12 = r3
            r2 = r10
            r10 = r16
            goto L_0x007b
        L_0x00b9:
            r12 = r3
            goto L_0x00be
        L_0x00bb:
            r0 = move-exception
            r7 = r3
            goto L_0x00cf
        L_0x00be:
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)     // Catch:{ all -> 0x00ca }
            io.ktor.utils.io.pool.ObjectPool r1 = io.ktor.utils.io.pool.ByteArrayPoolKt.getByteArrayPool()
            r1.recycle(r12)
            return r0
        L_0x00ca:
            r0 = move-exception
            r7 = r12
            goto L_0x00cf
        L_0x00cd:
            r0 = move-exception
            r7 = r2
        L_0x00cf:
            io.ktor.utils.io.pool.ObjectPool r1 = io.ktor.utils.io.pool.ByteArrayPoolKt.getByteArrayPool()
            r1.recycle(r7)
            throw r0
        L_0x00d7:
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
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.WritingKt.copyTo(io.ktor.utils.io.ByteReadChannel, java.io.OutputStream, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, OutputStream outputStream, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = HttpTimeout.INFINITE_TIMEOUT_MS;
        }
        return copyTo(byteReadChannel, outputStream, j, continuation);
    }
}
