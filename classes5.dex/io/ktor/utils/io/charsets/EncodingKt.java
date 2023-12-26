package io.ktor.utils.io.charsets;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferPrimitivesKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.core.internal.CharArraySequence;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a.\u0010\b\u001a\u00020\t*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010\u001a*\u0010\b\u001a\u00020\u0011*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\u00122\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u001a0\u0010\b\u001a\u00020\t*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a0\u0010\u0013\u001a\u00020\u0007*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0014H\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u0007*\u00060\nj\u0002`\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a,\u0010\u0016\u001a\u00020\u0017*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\u00122\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u0007\u001a,\u0010\u0018\u001a\u00020\u0017*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\u00122\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u0000\u001a0\u0010\u0019\u001a\u00020\u0007*\u00060\nj\u0002`\u000b2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0000\u001a\u0016\u0010\u001b\u001a\u00020\u0011*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\u0011\u001a\f\u0010\u001c\u001a\u00020\u001d*\u00020\u0005H\u0000¨\u0006\u001e"}, d2 = {"decode", "", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "input", "Lio/ktor/utils/io/core/Input;", "max", "", "encode", "", "Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "", "fromIndex", "toIndex", "dst", "Lio/ktor/utils/io/core/Output;", "Lio/ktor/utils/io/core/ByteReadPacket;", "", "encodeArrayImpl", "Lio/ktor/utils/io/core/Buffer;", "encodeCompleteImpl", "encodeToByteArrayImpl", "", "encodeToByteArrayImpl1", "encodeToImpl", "destination", "encodeUTF8", "sizeEstimate", "", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Encoding.kt */
public final class EncodingKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use writeText on Output instead.", replaceWith = @ReplaceWith(expression = "dst.writeText(input, fromIndex, toIndex, charset)", imports = {"io.ktor.utils.io.core.writeText"}))
    public static final void encode(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, Output output) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        Intrinsics.checkNotNullParameter(output, "dst");
        encodeToImpl(charsetEncoder, output, charSequence, i, i2);
    }

    public static /* synthetic */ byte[] encodeToByteArrayImpl$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encodeToByteArrayImpl(charsetEncoder, charSequence, i, i2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Internal API. Will be hidden in future releases. Use encodeToByteArray instead.", replaceWith = @ReplaceWith(expression = "encodeToByteArray(input, fromIndex, toIndex)", imports = {}))
    public static final byte[] encodeToByteArrayImpl(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        return CharsetJVMKt.encodeToByteArray(charsetEncoder, charSequence, i, i2);
    }

    public static /* synthetic */ ByteReadPacket encode$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encode(charsetEncoder, charSequence, i, i2);
    }

    public static /* synthetic */ String decode$default(CharsetDecoder charsetDecoder, Input input, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return decode(charsetDecoder, input, i);
    }

    public static final String decode(CharsetDecoder charsetDecoder, Input input, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        StringBuilder sb = new StringBuilder((int) Math.min((long) i, sizeEstimate(input)));
        CharsetJVMKt.decode(charsetDecoder, input, sb, i);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final int encodeArrayImpl(CharsetEncoder charsetEncoder, char[] cArr, int i, int i2, Buffer buffer) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "input");
        Intrinsics.checkNotNullParameter(buffer, "dst");
        int i3 = i2 - i;
        return CharsetJVMKt.encodeImpl(charsetEncoder, new CharArraySequence(cArr, i, i3), 0, i3, buffer);
    }

    public static /* synthetic */ byte[] encodeToByteArrayImpl1$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encodeToByteArrayImpl1(charsetEncoder, charSequence, i, i2);
    }

    public static final byte[] encodeToByteArrayImpl1(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        BytePacketBuilder bytePacketBuilder;
        byte[] readBytes$default;
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        if (i >= i2) {
            return UnsafeKt.EmptyByteArray;
        }
        ChunkBuffer borrow = ChunkBuffer.Companion.getPool().borrow();
        try {
            int encodeImpl = i + CharsetJVMKt.encodeImpl(charsetEncoder, charSequence, i, i2, borrow);
            if (encodeImpl == i2) {
                Buffer buffer = borrow;
                int writePosition = buffer.getWritePosition() - buffer.getReadPosition();
                readBytes$default = new byte[writePosition];
                BufferPrimitivesKt.readFully((Buffer) borrow, readBytes$default, 0, writePosition - 0);
            } else {
                bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
                bytePacketBuilder.appendSingleChunk$ktor_io(borrow.duplicate());
                encodeToImpl(charsetEncoder, bytePacketBuilder, charSequence, encodeImpl, i2);
                readBytes$default = StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, (Object) null);
            }
            borrow.release(ChunkBuffer.Companion.getPool());
            return readBytes$default;
        } catch (Throwable th) {
            borrow.release(ChunkBuffer.Companion.getPool());
            throw th;
        }
    }

    public static final long sizeEstimate(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input instanceof ByteReadPacket) {
            return input.getRemaining();
        }
        return Math.max(input.getRemaining(), 16);
    }

    public static final ByteReadPacket encode(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            encodeToImpl(charsetEncoder, bytePacketBuilder, charSequence, i, i2);
            return bytePacketBuilder.build();
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static final ByteReadPacket encodeUTF8(CharsetEncoder charsetEncoder, ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(byteReadPacket, "input");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            CharsetJVMKt.encodeUTF8(charsetEncoder, byteReadPacket, bytePacketBuilder);
            return bytePacketBuilder.build();
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static final void encode(CharsetEncoder charsetEncoder, char[] cArr, int i, int i2, Output output) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "input");
        Intrinsics.checkNotNullParameter(output, "dst");
        if (i < i2) {
            ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
            while (true) {
                try {
                    int encodeArrayImpl = encodeArrayImpl(charsetEncoder, cArr, i, i2, prepareWriteHead);
                    int i3 = 0;
                    if (encodeArrayImpl >= 0) {
                        i += encodeArrayImpl;
                        if (i < i2) {
                            i3 = encodeArrayImpl == 0 ? 8 : 1;
                        }
                        if (i3 > 0) {
                            prepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, prepareWriteHead);
                        } else {
                            output.afterHeadWrite();
                            encodeCompleteImpl(charsetEncoder, output);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } catch (Throwable th) {
                    output.afterHeadWrite();
                    throw th;
                }
            }
        }
    }

    private static final int encodeCompleteImpl(CharsetEncoder charsetEncoder, Output output) {
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        int i = 1;
        int i2 = 0;
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int limit = buffer.getLimit() - buffer.getWritePosition();
                i = CharsetJVMKt.encodeComplete(charsetEncoder, buffer) ? 0 : i + 1;
                i2 += limit - (buffer.getLimit() - buffer.getWritePosition());
                if (!(i > 0)) {
                    return i2;
                }
                prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static final int encodeToImpl(CharsetEncoder charsetEncoder, Output output, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(output, "destination");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        if (i >= i2) {
            return 0;
        }
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        int i3 = 0;
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int limit = buffer.getLimit() - buffer.getWritePosition();
                int encodeImpl = CharsetJVMKt.encodeImpl(charsetEncoder, charSequence, i, i2, buffer);
                if (encodeImpl >= 0) {
                    i += encodeImpl;
                    i3 += limit - (buffer.getLimit() - buffer.getWritePosition());
                    int i4 = i >= i2 ? 0 : encodeImpl == 0 ? 8 : 1;
                    if (i4 > 0) {
                        prepareWriteHead = UnsafeKt.prepareWriteHead(output, i4, prepareWriteHead);
                    } else {
                        output.afterHeadWrite();
                        return i3 + encodeCompleteImpl(charsetEncoder, output);
                    }
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } catch (Throwable th) {
                output.afterHeadWrite();
                throw th;
            }
        }
    }
}
