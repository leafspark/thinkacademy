package io.ktor.util;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u001c\u0010\n\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0005\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0001¨\u0006\u000f"}, d2 = {"copy", "Ljava/nio/ByteBuffer;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "size", "", "decodeString", "", "charset", "Ljava/nio/charset/Charset;", "moveTo", "destination", "limit", "moveToByteArray", "", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: NIO.kt */
public final class NIOKt {
    public static /* synthetic */ int moveTo$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return moveTo(byteBuffer, byteBuffer2, i);
    }

    public static final int moveTo(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer2, "destination");
        int min = Math.min(i, Math.min(byteBuffer.remaining(), byteBuffer2.remaining()));
        if (min == byteBuffer.remaining()) {
            byteBuffer2.put(byteBuffer);
        } else {
            int limit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + min);
            byteBuffer2.put(byteBuffer);
            byteBuffer.limit(limit);
        }
        return min;
    }

    public static final byte[] moveToByteArray(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static /* synthetic */ String decodeString$default(ByteBuffer byteBuffer, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return decodeString(byteBuffer, charset);
    }

    public static final String decodeString(ByteBuffer byteBuffer, Charset charset) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        String charBuffer = charset.decode(byteBuffer).toString();
        Intrinsics.checkNotNullExpressionValue(charBuffer, "charset.decode(this).toString()");
        return charBuffer;
    }

    public static /* synthetic */ ByteBuffer copy$default(ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = byteBuffer.remaining();
        }
        return copy(byteBuffer, i);
    }

    public static final ByteBuffer copy(ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        ByteBuffer allocate = ByteBuffer.allocate(i);
        ByteBuffer slice = byteBuffer.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "this@copy.slice()");
        Intrinsics.checkNotNullExpressionValue(allocate, "this@apply");
        moveTo$default(slice, allocate, 0, 2, (Object) null);
        allocate.clear();
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(size).apply {\n …ly)\n        clear()\n    }");
        return allocate;
    }

    public static final ByteBuffer copy(ByteBuffer byteBuffer, ObjectPool<ByteBuffer> objectPool, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        ByteBuffer borrow = objectPool.borrow();
        borrow.limit(i);
        ByteBuffer slice = byteBuffer.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "this@copy.slice()");
        moveTo$default(slice, borrow, 0, 2, (Object) null);
        borrow.flip();
        return borrow;
    }

    public static /* synthetic */ ByteBuffer copy$default(ByteBuffer byteBuffer, ObjectPool objectPool, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.remaining();
        }
        return copy(byteBuffer, objectPool, i);
    }
}
