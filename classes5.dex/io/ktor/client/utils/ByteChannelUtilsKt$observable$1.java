package io.ktor.client.utils;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.utils.ByteChannelUtilsKt$observable$1", f = "ByteChannelUtils.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3}, l = {23, 24, 26, 31}, m = "invokeSuspend", n = {"$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "read", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "$this$useInstance$iv", "instance$iv"}, s = {"L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "I$0", "L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1"})
/* compiled from: ByteChannelUtils.kt */
final class ByteChannelUtilsKt$observable$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $contentLength;
    final /* synthetic */ Function3<Long, Long, Continuation<? super Unit>, Object> $listener;
    final /* synthetic */ ByteReadChannel $this_observable;
    int I$0;
    long J$0;
    long J$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteChannelUtilsKt$observable$1(Long l, ByteReadChannel byteReadChannel, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super ByteChannelUtilsKt$observable$1> continuation) {
        super(2, continuation);
        this.$contentLength = l;
        this.$this_observable = byteReadChannel;
        this.$listener = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> byteChannelUtilsKt$observable$1 = new ByteChannelUtilsKt$observable$1(this.$contentLength, this.$this_observable, this.$listener, continuation);
        byteChannelUtilsKt$observable$1.L$0 = obj;
        return (Continuation) byteChannelUtilsKt$observable$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: io.ktor.utils.io.pool.ObjectPool<byte[]>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r1 = r20
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r2 == 0) goto L_0x00b5
            if (r2 == r8) goto L_0x008c
            if (r2 == r7) goto L_0x0061
            if (r2 == r6) goto L_0x002d
            if (r2 != r5) goto L_0x0025
            java.lang.Object r2 = r1.L$1
            java.lang.Object r0 = r1.L$0
            r3 = r0
            io.ktor.utils.io.pool.ObjectPool r3 = (io.ktor.utils.io.pool.ObjectPool) r3
            kotlin.ResultKt.throwOnFailure(r21)     // Catch:{ all -> 0x0022 }
            goto L_0x01a0
        L_0x0022:
            r0 = move-exception
            goto L_0x01aa
        L_0x0025:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x002d:
            long r9 = r1.J$1
            long r11 = r1.J$0
            java.lang.Object r2 = r1.L$5
            byte[] r2 = (byte[]) r2
            java.lang.Object r13 = r1.L$4
            java.lang.Object r14 = r1.L$3
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            java.lang.Object r15 = r1.L$2
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            java.lang.Object r5 = r1.L$1
            io.ktor.utils.io.pool.ObjectPool r5 = (io.ktor.utils.io.pool.ObjectPool) r5
            java.lang.Object r3 = r1.L$0
            io.ktor.utils.io.WriterScope r3 = (io.ktor.utils.io.WriterScope) r3
            kotlin.ResultKt.throwOnFailure(r21)     // Catch:{ all -> 0x005c }
            r17 = r9
            r10 = r1
            r1 = r2
            r9 = r6
            r6 = r17
            r2 = r13
            r19 = r14
            r14 = r3
            r3 = r5
            r4 = r11
            r11 = r19
            r12 = r15
            goto L_0x0164
        L_0x005c:
            r0 = move-exception
            r3 = r5
            r2 = r13
            goto L_0x01aa
        L_0x0061:
            int r2 = r1.I$0
            long r3 = r1.J$1
            long r9 = r1.J$0
            java.lang.Object r5 = r1.L$5
            byte[] r5 = (byte[]) r5
            java.lang.Object r11 = r1.L$4
            java.lang.Object r12 = r1.L$3
            kotlin.jvm.functions.Function3 r12 = (kotlin.jvm.functions.Function3) r12
            java.lang.Object r13 = r1.L$2
            io.ktor.utils.io.ByteReadChannel r13 = (io.ktor.utils.io.ByteReadChannel) r13
            java.lang.Object r14 = r1.L$1
            io.ktor.utils.io.pool.ObjectPool r14 = (io.ktor.utils.io.pool.ObjectPool) r14
            java.lang.Object r15 = r1.L$0
            io.ktor.utils.io.WriterScope r15 = (io.ktor.utils.io.WriterScope) r15
            kotlin.ResultKt.throwOnFailure(r21)     // Catch:{ all -> 0x0087 }
            r7 = r9
            r6 = r14
            r14 = r15
            r10 = r1
            r15 = r13
            goto L_0x0136
        L_0x0087:
            r0 = move-exception
            r2 = r11
            r3 = r14
            goto L_0x01aa
        L_0x008c:
            long r2 = r1.J$1
            long r4 = r1.J$0
            java.lang.Object r9 = r1.L$5
            byte[] r9 = (byte[]) r9
            java.lang.Object r10 = r1.L$4
            java.lang.Object r11 = r1.L$3
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            java.lang.Object r12 = r1.L$2
            io.ktor.utils.io.ByteReadChannel r12 = (io.ktor.utils.io.ByteReadChannel) r12
            java.lang.Object r13 = r1.L$1
            io.ktor.utils.io.pool.ObjectPool r13 = (io.ktor.utils.io.pool.ObjectPool) r13
            java.lang.Object r14 = r1.L$0
            io.ktor.utils.io.WriterScope r14 = (io.ktor.utils.io.WriterScope) r14
            kotlin.ResultKt.throwOnFailure(r21)     // Catch:{ all -> 0x00b0 }
            r8 = r21
            r6 = r2
            r2 = r10
            r3 = r13
            r10 = r1
            goto L_0x0104
        L_0x00b0:
            r0 = move-exception
            r2 = r10
            r3 = r13
            goto L_0x01aa
        L_0x00b5:
            kotlin.ResultKt.throwOnFailure(r21)
            java.lang.Object r2 = r1.L$0
            io.ktor.utils.io.WriterScope r2 = (io.ktor.utils.io.WriterScope) r2
            io.ktor.utils.io.pool.ObjectPool r3 = io.ktor.utils.io.pool.ByteArrayPoolKt.getByteArrayPool()
            java.lang.Long r4 = r1.$contentLength
            io.ktor.utils.io.ByteReadChannel r5 = r1.$this_observable
            kotlin.jvm.functions.Function3<java.lang.Long, java.lang.Long, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r9 = r1.$listener
            java.lang.Object r10 = r3.borrow()
            r11 = r10
            byte[] r11 = (byte[]) r11     // Catch:{ all -> 0x01a8 }
            if (r4 == 0) goto L_0x00d4
            long r12 = r4.longValue()     // Catch:{ all -> 0x01a8 }
            goto L_0x00d6
        L_0x00d4:
            r12 = -1
        L_0x00d6:
            r14 = r2
            r2 = r10
            r6 = 0
            r10 = r1
            r17 = r12
            r12 = r5
            r4 = r17
            r19 = r11
            r11 = r9
            r9 = r19
        L_0x00e5:
            boolean r16 = r12.isClosedForRead()     // Catch:{ all -> 0x0022 }
            if (r16 != 0) goto L_0x016e
            r10.L$0 = r14     // Catch:{ all -> 0x0022 }
            r10.L$1 = r3     // Catch:{ all -> 0x0022 }
            r10.L$2 = r12     // Catch:{ all -> 0x0022 }
            r10.L$3 = r11     // Catch:{ all -> 0x0022 }
            r10.L$4 = r2     // Catch:{ all -> 0x0022 }
            r10.L$5 = r9     // Catch:{ all -> 0x0022 }
            r10.J$0 = r4     // Catch:{ all -> 0x0022 }
            r10.J$1 = r6     // Catch:{ all -> 0x0022 }
            r10.label = r8     // Catch:{ all -> 0x0022 }
            java.lang.Object r8 = io.ktor.utils.io.ByteReadChannelKt.readAvailable(r12, r9, r10)     // Catch:{ all -> 0x0022 }
            if (r8 != r0) goto L_0x0104
            return r0
        L_0x0104:
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ all -> 0x0022 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0022 }
            io.ktor.utils.io.ByteWriteChannel r13 = r14.getChannel()     // Catch:{ all -> 0x0022 }
            r10.L$0 = r14     // Catch:{ all -> 0x0022 }
            r10.L$1 = r3     // Catch:{ all -> 0x0022 }
            r10.L$2 = r12     // Catch:{ all -> 0x0022 }
            r10.L$3 = r11     // Catch:{ all -> 0x0022 }
            r10.L$4 = r2     // Catch:{ all -> 0x0022 }
            r10.L$5 = r9     // Catch:{ all -> 0x0022 }
            r10.J$0 = r4     // Catch:{ all -> 0x0022 }
            r10.J$1 = r6     // Catch:{ all -> 0x0022 }
            r10.I$0 = r8     // Catch:{ all -> 0x0022 }
            r15 = 2
            r10.label = r15     // Catch:{ all -> 0x0022 }
            r15 = 0
            java.lang.Object r13 = r13.writeFully(r9, r15, r8, r10)     // Catch:{ all -> 0x0022 }
            if (r13 != r0) goto L_0x012b
            return r0
        L_0x012b:
            r15 = r12
            r12 = r11
            r11 = r2
            r2 = r8
            r17 = r6
            r6 = r3
            r7 = r4
            r3 = r17
            r5 = r9
        L_0x0136:
            long r1 = (long) r2
            long r1 = r1 + r3
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r1)     // Catch:{ all -> 0x016a }
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)     // Catch:{ all -> 0x016a }
            r10.L$0 = r14     // Catch:{ all -> 0x016a }
            r10.L$1 = r6     // Catch:{ all -> 0x016a }
            r10.L$2 = r15     // Catch:{ all -> 0x016a }
            r10.L$3 = r12     // Catch:{ all -> 0x016a }
            r10.L$4 = r11     // Catch:{ all -> 0x016a }
            r10.L$5 = r5     // Catch:{ all -> 0x016a }
            r10.J$0 = r7     // Catch:{ all -> 0x016a }
            r10.J$1 = r1     // Catch:{ all -> 0x016a }
            r9 = 3
            r10.label = r9     // Catch:{ all -> 0x016a }
            java.lang.Object r3 = r12.invoke(r3, r4, r10)     // Catch:{ all -> 0x016a }
            if (r3 != r0) goto L_0x015a
            return r0
        L_0x015a:
            r3 = r6
            r17 = r1
            r1 = r5
            r4 = r7
            r2 = r11
            r11 = r12
            r12 = r15
            r6 = r17
        L_0x0164:
            r9 = r1
            r8 = 1
            r1 = r20
            goto L_0x00e5
        L_0x016a:
            r0 = move-exception
            r3 = r6
            r2 = r11
            goto L_0x01aa
        L_0x016e:
            java.lang.Throwable r1 = r12.getClosedCause()     // Catch:{ all -> 0x0022 }
            io.ktor.utils.io.ByteWriteChannel r8 = r14.getChannel()     // Catch:{ all -> 0x0022 }
            r8.close(r1)     // Catch:{ all -> 0x0022 }
            if (r1 != 0) goto L_0x01a0
            r8 = 0
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x01a0
            java.lang.Long r1 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)     // Catch:{ all -> 0x0022 }
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)     // Catch:{ all -> 0x0022 }
            r10.L$0 = r3     // Catch:{ all -> 0x0022 }
            r10.L$1 = r2     // Catch:{ all -> 0x0022 }
            r5 = 0
            r10.L$2 = r5     // Catch:{ all -> 0x0022 }
            r10.L$3 = r5     // Catch:{ all -> 0x0022 }
            r10.L$4 = r5     // Catch:{ all -> 0x0022 }
            r10.L$5 = r5     // Catch:{ all -> 0x0022 }
            r5 = 4
            r10.label = r5     // Catch:{ all -> 0x0022 }
            java.lang.Object r1 = r11.invoke(r1, r4, r10)     // Catch:{ all -> 0x0022 }
            if (r1 != r0) goto L_0x01a0
            return r0
        L_0x01a0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0022 }
            r3.recycle(r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01a8:
            r0 = move-exception
            r2 = r10
        L_0x01aa:
            r3.recycle(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.utils.ByteChannelUtilsKt$observable$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
