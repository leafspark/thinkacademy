package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001\u0000\u001a*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0010"}, d2 = {"ByteReadPacket", "Lio/ktor/utils/io/core/ByteReadPacket;", "bb", "Ljava/nio/ByteBuffer;", "release", "Lkotlin/Function1;", "", "array", "", "offset", "", "length", "block", "poolFor", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteReadPacketExtensions.kt */
public final class ByteReadPacketExtensionsKt {
    public static final ByteReadPacket ByteReadPacket(byte[] bArr, int i, int i2, Function1<? super byte[], Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        Intrinsics.checkNotNullParameter(function1, "block");
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(array, offset, length)");
        return ByteReadPacket(wrap, new ByteReadPacketExtensionsKt$ByteReadPacket$1(function1, bArr));
    }

    public static /* synthetic */ ByteReadPacket ByteReadPacket$default(ByteBuffer byteBuffer, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) ByteReadPacketExtensionsKt$ByteReadPacket$2.INSTANCE;
        }
        return ByteReadPacket(byteBuffer, function1);
    }

    public static final ByteReadPacket ByteReadPacket(ByteBuffer byteBuffer, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter(byteBuffer, "bb");
        Intrinsics.checkNotNullParameter(function1, "release");
        ObjectPool<ChunkBuffer> poolFor = poolFor(byteBuffer, function1);
        ChunkBuffer borrow = poolFor.borrow();
        borrow.resetForRead();
        return new ByteReadPacket(borrow, poolFor);
    }

    private static final ObjectPool<ChunkBuffer> poolFor(ByteBuffer byteBuffer, Function1<? super ByteBuffer, Unit> function1) {
        return new SingleByteBufferPool(byteBuffer, function1);
    }

    public static /* synthetic */ ByteReadPacket ByteReadPacket$default(byte[] bArr, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        Intrinsics.checkNotNullParameter(bArr, "array");
        Intrinsics.checkNotNullParameter(function1, "block");
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(array, offset, length)");
        return ByteReadPacket(wrap, new ByteReadPacketExtensionsKt$ByteReadPacket$1(function1, bArr));
    }
}
