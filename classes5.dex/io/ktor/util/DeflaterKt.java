package io.ktor.util;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0002\u001a3\u0010\u0013\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a.\u0010\u0019\u001a\u00020\b*\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u001a.\u0010\u0019\u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u001a\u0015\u0010\u001c\u001a\u00020\u0007*\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010!\u001a\u0014\u0010\"\u001a\u00020\u0007*\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000fH\u0002\u001a\u0014\u0010#\u001a\u00020\u0007*\u00020 2\u0006\u0010\u0015\u001a\u00020\u000fH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"GZIP_HEADER_PADDING", "", "getGZIP_HEADER_PADDING", "()[B", "GZIP_MAGIC", "", "deflateTo", "", "Lio/ktor/utils/io/ByteReadChannel;", "destination", "Lio/ktor/utils/io/ByteWriteChannel;", "gzip", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;ZLio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/zip/Deflater;", "outBuffer", "deflateWhile", "deflater", "buffer", "predicate", "Lkotlin/Function0;", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deflated", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "putGzipHeader", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putGzipTrailer", "crc", "Ljava/util/zip/Checksum;", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/util/zip/Checksum;Ljava/util/zip/Deflater;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setInputBuffer", "updateKeepPosition", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Deflater.kt */
public final class DeflaterKt {
    private static final byte[] GZIP_HEADER_PADDING = new byte[7];
    public static final short GZIP_MAGIC = -29921;

    public static final byte[] getGZIP_HEADER_PADDING() {
        return GZIP_HEADER_PADDING;
    }

    private static final void deflateTo(Deflater deflater, ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            byteBuffer.position(byteBuffer.position() + deflater.deflate(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()));
        }
    }

    private static final void setInputBuffer(Deflater deflater, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            deflater.setInput(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            return;
        }
        throw new IllegalArgumentException("buffer need to be array-backed".toString());
    }

    public static final void updateKeepPosition(Checksum checksum, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(checksum, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        if (byteBuffer.hasArray()) {
            checksum.update(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            return;
        }
        throw new IllegalArgumentException("buffer need to be array-backed".toString());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0077 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object putGzipHeader(io.ktor.utils.io.ByteWriteChannel r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.util.DeflaterKt$putGzipHeader$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.util.DeflaterKt$putGzipHeader$1 r0 = (io.ktor.util.DeflaterKt$putGzipHeader$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.util.DeflaterKt$putGzipHeader$1 r0 = new io.ktor.util.DeflaterKt$putGzipHeader$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0078
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006a
        L_0x0040:
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005d
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = -29921(0xffffffffffff8b1f, float:NaN)
            short r7 = (short) r7
            short r7 = java.lang.Short.reverseBytes(r7)
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r6.writeShort(r7, r0)
            if (r7 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r7 = 8
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r6.writeByte(r7, r0)
            if (r7 != r1) goto L_0x006a
            return r1
        L_0x006a:
            byte[] r7 = GZIP_HEADER_PADDING
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r6, r7, r0)
            if (r6 != r1) goto L_0x0078
            return r1
        L_0x0078:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.putGzipHeader(io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.util.zip.Deflater} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object putGzipTrailer(io.ktor.utils.io.ByteWriteChannel r7, java.util.zip.Checksum r8, java.util.zip.Deflater r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.util.DeflaterKt$putGzipTrailer$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.util.DeflaterKt$putGzipTrailer$1 r0 = (io.ktor.util.DeflaterKt$putGzipTrailer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.util.DeflaterKt$putGzipTrailer$1 r0 = new io.ktor.util.DeflaterKt$putGzipTrailer$1
            r0.<init>(r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0071
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$1
            r9 = r7
            java.util.zip.Deflater r9 = (java.util.zip.Deflater) r9
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005b
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r10)
            long r5 = r8.getValue()
            int r8 = (int) r5
            int r8 = java.lang.Integer.reverseBytes(r8)
            r0.L$0 = r7
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r8 = r7.writeInt(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            int r8 = r9.getTotalIn()
            int r8 = java.lang.Integer.reverseBytes(r8)
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r7 = r7.writeInt(r8, r0)
            if (r7 != r1) goto L_0x0071
            return r1
        L_0x0071:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.putGzipTrailer(io.ktor.utils.io.ByteWriteChannel, java.util.zip.Checksum, java.util.zip.Deflater, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object deflateWhile(io.ktor.utils.io.ByteWriteChannel r6, java.util.zip.Deflater r7, java.nio.ByteBuffer r8, kotlin.jvm.functions.Function0<java.lang.Boolean> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.util.DeflaterKt$deflateWhile$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.util.DeflaterKt$deflateWhile$1 r0 = (io.ktor.util.DeflaterKt$deflateWhile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.util.DeflaterKt$deflateWhile$1 r0 = new io.ktor.util.DeflaterKt$deflateWhile$1
            r0.<init>(r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r6 = r0.L$3
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            java.lang.Object r7 = r0.L$2
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r0.L$1
            java.util.zip.Deflater r8 = (java.util.zip.Deflater) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r9 = (io.ktor.utils.io.ByteWriteChannel) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r4 = r9
            r9 = r6
            r6 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x004b
        L_0x0040:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r10)
        L_0x004b:
            java.lang.Object r10 = r9.invoke()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0071
            r8.clear()
            deflateTo(r7, r8)
            r8.flip()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.L$3 = r9
            r0.label = r3
            java.lang.Object r10 = r6.writeFully((java.nio.ByteBuffer) r8, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r10 != r1) goto L_0x004b
            return r1
        L_0x0071:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.deflateWhile(io.ktor.utils.io.ByteWriteChannel, java.util.zip.Deflater, java.nio.ByteBuffer, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.nio.ByteBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.util.zip.Deflater} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: io.ktor.utils.io.pool.ObjectPool<java.nio.ByteBuffer>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0163 A[Catch:{ all -> 0x022c }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0193 A[Catch:{ all -> 0x01c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01ce A[SYNTHETIC, Splitter:B:73:0x01ce] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01d4 A[Catch:{ all -> 0x022c }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0200 A[SYNTHETIC, Splitter:B:81:0x0200] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x022b A[SYNTHETIC, Splitter:B:90:0x022b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object deflateTo(io.ktor.utils.io.ByteReadChannel r17, io.ktor.utils.io.ByteWriteChannel r18, boolean r19, io.ktor.utils.io.pool.ObjectPool<java.nio.ByteBuffer> r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r0 = r18
            r1 = r19
            r2 = r21
            boolean r3 = r2 instanceof io.ktor.util.DeflaterKt$deflateTo$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            io.ktor.util.DeflaterKt$deflateTo$1 r3 = (io.ktor.util.DeflaterKt$deflateTo$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            io.ktor.util.DeflaterKt$deflateTo$1 r3 = new io.ktor.util.DeflaterKt$deflateTo$1
            r3.<init>(r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 0
            r11 = 1
            if (r5 == 0) goto L_0x0107
            if (r5 == r11) goto L_0x00e0
            if (r5 == r9) goto L_0x00b2
            if (r5 == r8) goto L_0x008b
            if (r5 == r7) goto L_0x005e
            if (r5 != r6) goto L_0x0056
            java.lang.Object r0 = r3.L$3
            r1 = r0
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            java.lang.Object r0 = r3.L$2
            r4 = r0
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4
            java.lang.Object r0 = r3.L$1
            r5 = r0
            java.util.zip.Deflater r5 = (java.util.zip.Deflater) r5
            java.lang.Object r0 = r3.L$0
            r3 = r0
            io.ktor.utils.io.pool.ObjectPool r3 = (io.ktor.utils.io.pool.ObjectPool) r3
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0052 }
            goto L_0x0219
        L_0x0052:
            r0 = move-exception
            r13 = r3
            goto L_0x0230
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005e:
            boolean r0 = r3.Z$0
            java.lang.Object r1 = r3.L$5
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            java.lang.Object r5 = r3.L$4
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r7 = r3.L$3
            java.util.zip.Deflater r7 = (java.util.zip.Deflater) r7
            java.lang.Object r8 = r3.L$2
            java.util.zip.CRC32 r8 = (java.util.zip.CRC32) r8
            java.lang.Object r9 = r3.L$1
            io.ktor.utils.io.pool.ObjectPool r9 = (io.ktor.utils.io.pool.ObjectPool) r9
            java.lang.Object r11 = r3.L$0
            io.ktor.utils.io.ByteWriteChannel r11 = (io.ktor.utils.io.ByteWriteChannel) r11
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0085 }
            r13 = r9
            r2 = r11
            r11 = r7
            r16 = r5
            r5 = r4
            r4 = r16
            goto L_0x01fe
        L_0x0085:
            r0 = move-exception
            r4 = r5
            r5 = r7
            r13 = r9
            goto L_0x0230
        L_0x008b:
            boolean r0 = r3.Z$0
            java.lang.Object r1 = r3.L$6
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            java.lang.Object r5 = r3.L$5
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r11 = r3.L$4
            java.util.zip.Deflater r11 = (java.util.zip.Deflater) r11
            java.lang.Object r12 = r3.L$3
            java.util.zip.CRC32 r12 = (java.util.zip.CRC32) r12
            java.lang.Object r13 = r3.L$2
            io.ktor.utils.io.pool.ObjectPool r13 = (io.ktor.utils.io.pool.ObjectPool) r13
            java.lang.Object r14 = r3.L$1
            io.ktor.utils.io.ByteWriteChannel r14 = (io.ktor.utils.io.ByteWriteChannel) r14
            java.lang.Object r15 = r3.L$0
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0102 }
        L_0x00ac:
            r2 = r1
            r1 = r0
            r0 = r14
            r14 = r15
            goto L_0x0144
        L_0x00b2:
            boolean r0 = r3.Z$0
            java.lang.Object r1 = r3.L$6
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            java.lang.Object r5 = r3.L$5
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r11 = r3.L$4
            java.util.zip.Deflater r11 = (java.util.zip.Deflater) r11
            java.lang.Object r12 = r3.L$3
            java.util.zip.CRC32 r12 = (java.util.zip.CRC32) r12
            java.lang.Object r13 = r3.L$2
            io.ktor.utils.io.pool.ObjectPool r13 = (io.ktor.utils.io.pool.ObjectPool) r13
            java.lang.Object r14 = r3.L$1
            io.ktor.utils.io.ByteWriteChannel r14 = (io.ktor.utils.io.ByteWriteChannel) r14
            java.lang.Object r15 = r3.L$0
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0102 }
            r16 = r1
            r1 = r0
            r0 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r4
            r4 = r3
            r3 = r16
            goto L_0x018b
        L_0x00e0:
            boolean r0 = r3.Z$0
            java.lang.Object r1 = r3.L$6
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            java.lang.Object r5 = r3.L$5
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r11 = r3.L$4
            java.util.zip.Deflater r11 = (java.util.zip.Deflater) r11
            java.lang.Object r12 = r3.L$3
            java.util.zip.CRC32 r12 = (java.util.zip.CRC32) r12
            java.lang.Object r13 = r3.L$2
            io.ktor.utils.io.pool.ObjectPool r13 = (io.ktor.utils.io.pool.ObjectPool) r13
            java.lang.Object r14 = r3.L$1
            io.ktor.utils.io.ByteWriteChannel r14 = (io.ktor.utils.io.ByteWriteChannel) r14
            java.lang.Object r15 = r3.L$0
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x0102 }
            goto L_0x00ac
        L_0x0102:
            r0 = move-exception
            r4 = r5
        L_0x0104:
            r5 = r11
            goto L_0x0230
        L_0x0107:
            kotlin.ResultKt.throwOnFailure(r2)
            java.util.zip.CRC32 r12 = new java.util.zip.CRC32
            r12.<init>()
            java.util.zip.Deflater r5 = new java.util.zip.Deflater
            r2 = -1
            r5.<init>(r2, r11)
            java.lang.Object r2 = r20.borrow()
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r13 = r20.borrow()
            java.nio.ByteBuffer r13 = (java.nio.ByteBuffer) r13
            if (r1 == 0) goto L_0x0154
            r14 = r17
            r3.L$0 = r14     // Catch:{ all -> 0x014c }
            r3.L$1 = r0     // Catch:{ all -> 0x014c }
            r15 = r20
            r3.L$2 = r15     // Catch:{ all -> 0x014a }
            r3.L$3 = r12     // Catch:{ all -> 0x014a }
            r3.L$4 = r5     // Catch:{ all -> 0x014a }
            r3.L$5 = r2     // Catch:{ all -> 0x014a }
            r3.L$6 = r13     // Catch:{ all -> 0x014a }
            r3.Z$0 = r1     // Catch:{ all -> 0x014a }
            r3.label = r11     // Catch:{ all -> 0x014a }
            java.lang.Object r11 = putGzipHeader(r0, r3)     // Catch:{ all -> 0x014a }
            if (r11 != r4) goto L_0x0140
            return r4
        L_0x0140:
            r11 = r5
            r5 = r2
            r2 = r13
            r13 = r15
        L_0x0144:
            r16 = r5
            r5 = r4
            r4 = r16
            goto L_0x015d
        L_0x014a:
            r0 = move-exception
            goto L_0x014f
        L_0x014c:
            r0 = move-exception
            r15 = r20
        L_0x014f:
            r4 = r2
            r1 = r13
            r13 = r15
            goto L_0x0230
        L_0x0154:
            r14 = r17
            r15 = r20
            r11 = r5
            r5 = r4
            r4 = r2
            r2 = r13
            r13 = r15
        L_0x015d:
            boolean r15 = r14.isClosedForRead()     // Catch:{ all -> 0x022c }
            if (r15 != 0) goto L_0x01ce
            r4.clear()     // Catch:{ all -> 0x022c }
            r3.L$0 = r14     // Catch:{ all -> 0x022c }
            r3.L$1 = r0     // Catch:{ all -> 0x022c }
            r3.L$2 = r13     // Catch:{ all -> 0x022c }
            r3.L$3 = r12     // Catch:{ all -> 0x022c }
            r3.L$4 = r11     // Catch:{ all -> 0x022c }
            r3.L$5 = r4     // Catch:{ all -> 0x022c }
            r3.L$6 = r2     // Catch:{ all -> 0x022c }
            r3.Z$0 = r1     // Catch:{ all -> 0x022c }
            r3.label = r9     // Catch:{ all -> 0x022c }
            java.lang.Object r15 = r14.readAvailable((java.nio.ByteBuffer) r4, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r3)     // Catch:{ all -> 0x022c }
            if (r15 != r5) goto L_0x017f
            return r5
        L_0x017f:
            r16 = r3
            r3 = r2
            r2 = r15
            r15 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r5
            r5 = r4
            r4 = r16
        L_0x018b:
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x01c8 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x01c8 }
            if (r2 <= 0) goto L_0x01bf
            r5.flip()     // Catch:{ all -> 0x01c8 }
            r2 = r13
            java.util.zip.Checksum r2 = (java.util.zip.Checksum) r2     // Catch:{ all -> 0x01c8 }
            updateKeepPosition(r2, r5)     // Catch:{ all -> 0x01c8 }
            setInputBuffer(r12, r5)     // Catch:{ all -> 0x01c8 }
            io.ktor.util.DeflaterKt$deflateTo$2 r2 = new io.ktor.util.DeflaterKt$deflateTo$2     // Catch:{ all -> 0x01c8 }
            r2.<init>(r12)     // Catch:{ all -> 0x01c8 }
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch:{ all -> 0x01c8 }
            r4.L$0 = r15     // Catch:{ all -> 0x01c8 }
            r4.L$1 = r0     // Catch:{ all -> 0x01c8 }
            r4.L$2 = r14     // Catch:{ all -> 0x01c8 }
            r4.L$3 = r13     // Catch:{ all -> 0x01c8 }
            r4.L$4 = r12     // Catch:{ all -> 0x01c8 }
            r4.L$5 = r5     // Catch:{ all -> 0x01c8 }
            r4.L$6 = r3     // Catch:{ all -> 0x01c8 }
            r4.Z$0 = r1     // Catch:{ all -> 0x01c8 }
            r4.label = r8     // Catch:{ all -> 0x01c8 }
            java.lang.Object r2 = deflateWhile(r0, r12, r3, r2, r4)     // Catch:{ all -> 0x01c8 }
            if (r2 != r11) goto L_0x01bf
            return r11
        L_0x01bf:
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            goto L_0x015d
        L_0x01c8:
            r0 = move-exception
            r1 = r3
            r4 = r5
            r5 = r12
            r13 = r14
            goto L_0x0230
        L_0x01ce:
            java.lang.Throwable r8 = r14.getClosedCause()     // Catch:{ all -> 0x022c }
            if (r8 != 0) goto L_0x022b
            r11.finish()     // Catch:{ all -> 0x022c }
            io.ktor.util.DeflaterKt$deflateTo$4 r8 = new io.ktor.util.DeflaterKt$deflateTo$4     // Catch:{ all -> 0x022c }
            r8.<init>(r11)     // Catch:{ all -> 0x022c }
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8     // Catch:{ all -> 0x022c }
            r3.L$0 = r0     // Catch:{ all -> 0x022c }
            r3.L$1 = r13     // Catch:{ all -> 0x022c }
            r3.L$2 = r12     // Catch:{ all -> 0x022c }
            r3.L$3 = r11     // Catch:{ all -> 0x022c }
            r3.L$4 = r4     // Catch:{ all -> 0x022c }
            r3.L$5 = r2     // Catch:{ all -> 0x022c }
            r3.L$6 = r10     // Catch:{ all -> 0x022c }
            r3.Z$0 = r1     // Catch:{ all -> 0x022c }
            r3.label = r7     // Catch:{ all -> 0x022c }
            java.lang.Object r7 = deflateWhile(r0, r11, r2, r8, r3)     // Catch:{ all -> 0x022c }
            if (r7 != r5) goto L_0x01f7
            return r5
        L_0x01f7:
            r8 = r12
            r16 = r2
            r2 = r0
            r0 = r1
            r1 = r16
        L_0x01fe:
            if (r0 == 0) goto L_0x021f
            java.util.zip.Checksum r8 = (java.util.zip.Checksum) r8     // Catch:{ all -> 0x021c }
            r3.L$0 = r13     // Catch:{ all -> 0x021c }
            r3.L$1 = r11     // Catch:{ all -> 0x021c }
            r3.L$2 = r4     // Catch:{ all -> 0x021c }
            r3.L$3 = r1     // Catch:{ all -> 0x021c }
            r3.L$4 = r10     // Catch:{ all -> 0x021c }
            r3.L$5 = r10     // Catch:{ all -> 0x021c }
            r3.label = r6     // Catch:{ all -> 0x021c }
            java.lang.Object r0 = putGzipTrailer(r2, r8, r11, r3)     // Catch:{ all -> 0x021c }
            if (r0 != r5) goto L_0x0217
            return r5
        L_0x0217:
            r5 = r11
            r3 = r13
        L_0x0219:
            r13 = r3
            r11 = r5
            goto L_0x021f
        L_0x021c:
            r0 = move-exception
            goto L_0x0104
        L_0x021f:
            r11.end()
            r13.recycle(r4)
            r13.recycle(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x022b:
            throw r8     // Catch:{ all -> 0x022c }
        L_0x022c:
            r0 = move-exception
            r1 = r2
            goto L_0x0104
        L_0x0230:
            r5.end()
            r13.recycle(r4)
            r13.recycle(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.deflateTo(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, boolean, io.ktor.utils.io.pool.ObjectPool, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object deflateTo$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, boolean z, ObjectPool<ByteBuffer> objectPool, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        return deflateTo(byteReadChannel, byteWriteChannel, z, objectPool, continuation);
    }

    public static /* synthetic */ ByteReadChannel deflated$default(ByteReadChannel byteReadChannel, boolean z, ObjectPool<ByteBuffer> objectPool, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i & 4) != 0) {
            coroutineContext = (CoroutineContext) Dispatchers.getUnconfined();
        }
        return deflated(byteReadChannel, z, objectPool, coroutineContext);
    }

    public static final ByteReadChannel deflated(ByteReadChannel byteReadChannel, boolean z, ObjectPool<ByteBuffer> objectPool, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return CoroutinesKt.writer((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new DeflaterKt$deflated$1(byteReadChannel, z, objectPool, (Continuation<? super DeflaterKt$deflated$1>) null)).getChannel();
    }

    public static /* synthetic */ ByteWriteChannel deflated$default(ByteWriteChannel byteWriteChannel, boolean z, ObjectPool<ByteBuffer> objectPool, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i & 4) != 0) {
            coroutineContext = (CoroutineContext) Dispatchers.getUnconfined();
        }
        return deflated(byteWriteChannel, z, objectPool, coroutineContext);
    }

    public static final ByteWriteChannel deflated(ByteWriteChannel byteWriteChannel, boolean z, ObjectPool<ByteBuffer> objectPool, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return CoroutinesKt.reader((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, true, (Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object>) new DeflaterKt$deflated$2(byteWriteChannel, z, objectPool, (Continuation<? super DeflaterKt$deflated$2>) null)).getChannel();
    }
}
