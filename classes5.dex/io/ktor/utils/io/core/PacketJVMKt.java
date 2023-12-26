package io.ktor.utils.io.core;

import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.utils.AtomicKt;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t\u001a*\u0010\n\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0001H\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003*\n\u0010\u0011\"\u00020\u00122\u00020\u0012¨\u0006\u0013"}, d2 = {"PACKET_MAX_COPY_SIZE", "", "getPACKET_MAX_COPY_SIZE", "()I", "readByteBuffer", "Ljava/nio/ByteBuffer;", "Lio/ktor/utils/io/core/ByteReadPacket;", "n", "direct", "", "readText", "decoder", "Ljava/nio/charset/CharsetDecoder;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "max", "EOFException", "Ljava/io/EOFException;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PacketJVM.kt */
public final class PacketJVMKt {
    private static final int PACKET_MAX_COPY_SIZE = AtomicKt.getIOIntProperty("max.copy.size", 500);

    public static final int getPACKET_MAX_COPY_SIZE() {
        return PACKET_MAX_COPY_SIZE;
    }

    public static /* synthetic */ ByteBuffer readByteBuffer$default(ByteReadPacket byteReadPacket, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            long remaining = byteReadPacket.getRemaining();
            if (remaining <= 2147483647L) {
                i = (int) remaining;
            } else {
                throw new IllegalArgumentException("Unable to make a ByteBuffer: packet is too big");
            }
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        return readByteBuffer(byteReadPacket, i, z);
    }

    public static final ByteBuffer readByteBuffer(ByteReadPacket byteReadPacket, int i, boolean z) {
        String str;
        ByteBuffer byteBuffer;
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (z) {
            byteBuffer = ByteBuffer.allocateDirect(i);
            str = "allocateDirect(n)";
        } else {
            byteBuffer = ByteBuffer.allocate(i);
            str = "allocate(n)";
        }
        Intrinsics.checkNotNullExpressionValue(byteBuffer, str);
        ByteBuffersKt.readFully(byteReadPacket, byteBuffer);
        byteBuffer.clear();
        return byteBuffer;
    }

    public static /* synthetic */ int readText$default(ByteReadPacket byteReadPacket, CharsetDecoder charsetDecoder, Appendable appendable, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(byteReadPacket, charsetDecoder, appendable, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate parameters order", replaceWith = @ReplaceWith(expression = "readText(out, decoder, max)", imports = {}))
    public static final int readText(ByteReadPacket byteReadPacket, CharsetDecoder charsetDecoder, Appendable appendable, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(charsetDecoder, "decoder");
        Intrinsics.checkNotNullParameter(appendable, "out");
        return CharsetJVMKt.decode(charsetDecoder, byteReadPacket, appendable, i);
    }
}
