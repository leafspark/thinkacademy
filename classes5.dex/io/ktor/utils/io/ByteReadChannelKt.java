package io.ktor.utils.io;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a'\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001d\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004HHø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u001d\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001d\u0010\u0015\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a!\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"cancel", "", "Lio/ktor/utils/io/ByteReadChannel;", "copyAndClose", "", "dst", "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discard", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discardExact", "", "n", "(Lio/ktor/utils/io/ByteReadChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", "", "", "(Lio/ktor/utils/io/ByteReadChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFully", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRemaining", "Lio/ktor/utils/io/core/ByteReadPacket;", "readUTF8Line", "", "readUTF8LineTo", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteReadChannel.kt */
public final class ByteReadChannelKt {
    public static final Object readRemaining(ByteReadChannel byteReadChannel, Continuation<? super ByteReadPacket> continuation) {
        return byteReadChannel.readRemaining(HttpTimeout.INFINITE_TIMEOUT_MS, continuation);
    }

    public static final Object readFully(ByteReadChannel byteReadChannel, ChunkBuffer chunkBuffer, Continuation<? super Unit> continuation) {
        Buffer buffer = chunkBuffer;
        Object readFully = byteReadChannel.readFully(chunkBuffer, buffer.getLimit() - buffer.getWritePosition(), continuation);
        return readFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFully : Unit.INSTANCE;
    }

    public static final Object readUTF8LineTo(ByteReadChannel byteReadChannel, Appendable appendable, Continuation<? super Boolean> continuation) {
        return byteReadChannel.readUTF8LineTo(appendable, Integer.MAX_VALUE, continuation);
    }

    public static final Object readUTF8Line(ByteReadChannel byteReadChannel, Continuation<? super String> continuation) {
        return byteReadChannel.readUTF8Line(Integer.MAX_VALUE, continuation);
    }

    public static final boolean cancel(ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        return byteReadChannel.cancel((Throwable) null);
    }

    public static final Object discard(ByteReadChannel byteReadChannel, Continuation<? super Long> continuation) {
        return byteReadChannel.discard(HttpTimeout.INFINITE_TIMEOUT_MS, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object discardExact(io.ktor.utils.io.ByteReadChannel r4, long r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelKt$discardExact$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteReadChannelKt$discardExact$1 r0 = (io.ktor.utils.io.ByteReadChannelKt$discardExact$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteReadChannelKt$discardExact$1 r0 = new io.ktor.utils.io.ByteReadChannelKt$discardExact$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            long r5 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0042
        L_0x002c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.J$0 = r5
            r0.label = r3
            java.lang.Object r7 = r4.discard(r5, r0)
            if (r7 != r1) goto L_0x0042
            return r1
        L_0x0042:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            int r4 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x004f
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x004f:
            java.io.EOFException r4 = new java.io.EOFException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Unable to discard "
            r7.append(r0)
            r7.append(r5)
            java.lang.String r5 = " bytes"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelKt.discardExact(io.ktor.utils.io.ByteReadChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object discardExact$$forInline(ByteReadChannel byteReadChannel, long j, Continuation<? super Unit> continuation) {
        InlineMarker.mark(0);
        Object discard = byteReadChannel.discard(j, continuation);
        InlineMarker.mark(1);
        if (((Number) discard).longValue() == j) {
            return Unit.INSTANCE;
        }
        throw new EOFException("Unable to discard " + j + " bytes");
    }

    public static final Object readAvailable(ByteReadChannel byteReadChannel, byte[] bArr, Continuation<? super Integer> continuation) {
        return byteReadChannel.readAvailable(bArr, 0, bArr.length, continuation);
    }

    public static final Object readFully(ByteReadChannel byteReadChannel, byte[] bArr, Continuation<? super Unit> continuation) {
        Object readFully = byteReadChannel.readFully(bArr, 0, bArr.length, continuation);
        return readFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFully : Unit.INSTANCE;
    }

    public static final Object copyTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, Continuation<? super Long> continuation) {
        return ByteReadChannelJVMKt.copyTo(byteReadChannel, byteWriteChannel, HttpTimeout.INFINITE_TIMEOUT_MS, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: io.ktor.utils.io.ByteWriteChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object copyAndClose(io.ktor.utils.io.ByteReadChannel r4, io.ktor.utils.io.ByteWriteChannel r5, long r6, kotlin.coroutines.Continuation<? super java.lang.Long> r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1 r0 = (io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1 r0 = new io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r8 = io.ktor.utils.io.ByteReadChannelJVMKt.copyTo(r4, r5, r6, r0)
            if (r8 != r1) goto L_0x0045
            return r1
        L_0x0045:
            java.lang.Number r8 = (java.lang.Number) r8
            long r6 = r8.longValue()
            io.ktor.utils.io.ByteWriteChannelKt.close(r5)
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelKt.copyAndClose(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyAndClose$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = HttpTimeout.INFINITE_TIMEOUT_MS;
        }
        return copyAndClose(byteReadChannel, byteWriteChannel, j, continuation);
    }
}
