package io.ktor.utils.io.jvm.nio;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.channels.Pipe;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"copyTo", "", "Lio/ktor/utils/io/ByteReadChannel;", "pipe", "Ljava/nio/channels/Pipe;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/channels/Pipe;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channel", "Ljava/nio/channels/WritableByteChannel;", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/channels/WritableByteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Writing.kt */
public final class WritingKt {
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009c, code lost:
        if (r8.isClosedForRead() == false) goto L_0x0081;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r8, java.nio.channels.WritableByteChannel r9, long r10, kotlin.coroutines.Continuation<? super java.lang.Long> r12) {
        /*
            boolean r0 = r12 instanceof io.ktor.utils.io.jvm.nio.WritingKt$copyTo$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            io.ktor.utils.io.jvm.nio.WritingKt$copyTo$1 r0 = (io.ktor.utils.io.jvm.nio.WritingKt$copyTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.jvm.nio.WritingKt$copyTo$1 r0 = new io.ktor.utils.io.jvm.nio.WritingKt$copyTo$1
            r0.<init>(r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r4) goto L_0x003e
            long r8 = r0.J$0
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r11
            r7 = r2
            r2 = r10
            r10 = r8
            r8 = r7
            goto L_0x0098
        L_0x003e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r12)
            r5 = 0
            int r12 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r12 < 0) goto L_0x0051
            r12 = r4
            goto L_0x0052
        L_0x0051:
            r12 = r3
        L_0x0052:
            if (r12 == 0) goto L_0x00a5
            boolean r12 = r9 instanceof java.nio.channels.SelectableChannel
            if (r12 == 0) goto L_0x006a
            r12 = r9
            java.nio.channels.SelectableChannel r12 = (java.nio.channels.SelectableChannel) r12
            boolean r12 = r12.isBlocking()
            if (r12 == 0) goto L_0x0062
            goto L_0x006a
        L_0x0062:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Non-blocking channels are not supported"
            r8.<init>(r9)
            throw r8
        L_0x006a:
            boolean r12 = r8.isClosedForRead()
            if (r12 == 0) goto L_0x0075
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            return r8
        L_0x0075:
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            io.ktor.utils.io.jvm.nio.WritingKt$copyTo$copy$1 r2 = new io.ktor.utils.io.jvm.nio.WritingKt$copyTo$copy$1
            r2.<init>(r10, r12, r9)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
        L_0x0081:
            long r5 = r12.element
            int r9 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r9 >= 0) goto L_0x009e
            r0.L$0 = r8
            r0.L$1 = r12
            r0.L$2 = r2
            r0.J$0 = r10
            r0.label = r4
            java.lang.Object r9 = r8.read(r3, r2, r0)
            if (r9 != r1) goto L_0x0098
            return r1
        L_0x0098:
            boolean r9 = r8.isClosedForRead()
            if (r9 == 0) goto L_0x0081
        L_0x009e:
            long r8 = r12.element
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)
            return r8
        L_0x00a5:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Limit shouldn't be negative: "
            r8.append(r9)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.nio.WritingKt.copyTo(io.ktor.utils.io.ByteReadChannel, java.nio.channels.WritableByteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, WritableByteChannel writableByteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = HttpTimeout.INFINITE_TIMEOUT_MS;
        }
        return copyTo(byteReadChannel, writableByteChannel, j, (Continuation<? super Long>) continuation);
    }

    public static final Object copyTo(ByteReadChannel byteReadChannel, Pipe pipe, long j, Continuation<? super Long> continuation) {
        Pipe.SinkChannel sink = pipe.sink();
        Intrinsics.checkNotNullExpressionValue(sink, "pipe.sink()");
        return copyTo(byteReadChannel, (WritableByteChannel) sink, j, continuation);
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, Pipe pipe, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = HttpTimeout.INFINITE_TIMEOUT_MS;
        }
        return copyTo(byteReadChannel, pipe, j, (Continuation<? super Long>) continuation);
    }
}
