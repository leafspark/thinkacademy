package io.ktor.utils.io.core;

import com.wushuangtech.library.GlobalVideoConfig;
import io.agora.rtc.Constants;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.EncodeResult;
import io.ktor.utils.io.core.internal.NumbersKt;
import io.ktor.utils.io.core.internal.UTF8Kt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a$\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0007\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\fH\u0007\u001a&\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0007\u001a(\u0010\r\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\f2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u0000\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012\u001a'\u0010\u000e\u001a\u00020\u000f*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0007\u001a\f\u0010\u0019\u001a\u00020\u000f*\u00020\u0005H\u0007\u001a\f\u0010\u001a\u001a\u00020\u0005*\u00020\u0005H\u0007\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001bH\u0007\u001a\u0014\u0010\u001c\u001a\u00020\u000f*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003H\u0007\u001a1\u0010\u001d\u001a\u00020\u000f*\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001f2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010!\u001a6\u0010\"\u001a\u00020\u0003*\u00020\u00052\n\u0010#\u001a\u00060$j\u0002`%2\n\u0010&\u001a\u00060'j\u0002`(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u0003H\u0007\u001a\f\u0010,\u001a\u00020\u0003*\u00020\u0005H\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"appendFailed", "", "length", "", "append", "Lio/ktor/utils/io/core/Buffer;", "c", "", "csq", "", "start", "end", "", "appendChars", "fill", "", "times", "value", "", "Lkotlin/UByte;", "fill-sEu17AQ", "(Lio/ktor/utils/io/core/Buffer;IB)V", "n", "", "v", "flush", "makeView", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "pushBack", "readFully", "dst", "", "offset", "(Lio/ktor/utils/io/core/Buffer;[Ljava/lang/Byte;II)V", "readText", "decoder", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "lastBuffer", "", "max", "tryPeek", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BufferCompatibility.kt */
public final class BufferCompatibilityKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Does nothing.")
    public static final void flush(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
    }

    /* renamed from: fill-sEu17AQ  reason: not valid java name */
    public static final void m185fillsEu17AQ(Buffer buffer, int i, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "$this$fill");
        fill(buffer, i, b);
    }

    @Deprecated(message = "Use fill with n with type Int")
    public static final void fill(Buffer buffer, long j, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j < 2147483647L) {
            fill(buffer, (int) j, b);
        } else {
            NumbersKt.failLongToIntConversion(j, "n");
            throw new KotlinNothingValueException();
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use rewind instead", replaceWith = @ReplaceWith(expression = "rewind(n)", imports = {}))
    public static final void pushBack(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        buffer.rewind(i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use duplicate instead", replaceWith = @ReplaceWith(expression = "duplicate()", imports = {}))
    public static final Buffer makeView(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.duplicate();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use duplicate instead", replaceWith = @ReplaceWith(expression = "duplicate()", imports = {}))
    public static final ChunkBuffer makeView(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return chunkBuffer.duplicate();
    }

    public static /* synthetic */ int appendChars$default(Buffer buffer, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return appendChars(buffer, charSequence, i, i2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This is no longer supported. Use a packet builder to append characters instead.")
    public static final Buffer append(Buffer buffer, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        throw new IllegalStateException("This is no longer supported. Use a packet builder to append characters instead.".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This is no longer supported. Use a packet builder to append characters instead.")
    public static final Buffer append(Buffer buffer, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        throw new IllegalStateException("This is no longer supported. Use a packet builder to append characters instead.".toString());
    }

    private static final Void appendFailed(int i) {
        throw new BufferLimitExceededException("Not enough free space available to write " + i + " character(s).");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This is no longer supported. Use a packet builder to append characters instead.")
    public static final Buffer append(Buffer buffer, char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "csq");
        throw new IllegalStateException("This is no longer supported. Use a packet builder to append characters instead.".toString());
    }

    public static /* synthetic */ int readText$default(Buffer buffer, CharsetDecoder charsetDecoder, Appendable appendable, boolean z, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(buffer, charsetDecoder, appendable, z, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This is no longer supported. Read from a packet instead.")
    public static final int readText(Buffer buffer, CharsetDecoder charsetDecoder, Appendable appendable, boolean z, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(charsetDecoder, "decoder");
        Intrinsics.checkNotNullParameter(appendable, "out");
        return CharsetJVMKt.decodeBuffer(charsetDecoder, buffer, appendable, z, i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use tryPeekByte instead", replaceWith = @ReplaceWith(expression = "tryPeekByte()", imports = {}))
    public static final int tryPeek(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.tryPeekByte();
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, Byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        readFully(buffer, bArr, i, i2);
    }

    public static final void fill(Buffer buffer, int i, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        boolean z = true;
        if (i >= 0) {
            if (i > buffer.getLimit() - buffer.getWritePosition()) {
                z = false;
            }
            if (z) {
                MemoryJvmKt.m62fillJT6ljtQ(buffer.m184getMemorySK3TCg8(), buffer.getWritePosition(), i, b);
                buffer.commitWritten(i);
                return;
            }
            throw new IllegalArgumentException(("times shouldn't be greater than the write remaining space: " + i + " > " + (buffer.getLimit() - buffer.getWritePosition())).toString());
        }
        throw new IllegalArgumentException(("times shouldn't be negative: " + i).toString());
    }

    public static final int appendChars(Buffer buffer, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "csq");
        int r8 = UTF8Kt.m304encodeUTF8lBXzO7A(buffer.m184getMemorySK3TCg8(), charSequence, i, i2, buffer.getWritePosition(), buffer.getLimit());
        short r10 = EncodeResult.m300getCharactersMh2AYeg(r8) & UShort.MAX_VALUE;
        buffer.commitWritten(EncodeResult.m299getBytesMh2AYeg(r8) & UShort.MAX_VALUE);
        return i + r10;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This is no longer supported. Use a packet builder to append characters instead.")
    public static final Buffer append(Buffer buffer, char c) {
        int i;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit();
        boolean z = false;
        if (c >= 0 && c < 128) {
            r0.put(writePosition, (byte) c);
            i = 1;
        } else {
            if (128 <= c && c < 2048) {
                r0.put(writePosition, (byte) (((c >> 6) & 31) | 192));
                r0.put(writePosition + 1, (byte) ((c & '?') | 128));
                i = 2;
            } else {
                if (2048 <= c && c < 0) {
                    r0.put(writePosition, (byte) (((c >> 12) & 15) | 224));
                    r0.put(writePosition + 1, (byte) (((c >> 6) & 63) | Constants.ERR_WATERMARK_ARGB));
                    r0.put(writePosition + 2, (byte) ((c & '?') | 128));
                    i = 3;
                } else {
                    if (0 <= c && c < 0) {
                        z = true;
                    }
                    if (z) {
                        r0.put(writePosition, (byte) (((c >> 18) & 7) | GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH));
                        r0.put(writePosition + 1, (byte) (((c >> 12) & 63) | Constants.ERR_WATERMARK_ARGB));
                        r0.put(writePosition + 2, (byte) (((c >> 6) & 63) | Constants.ERR_WATERMARK_ARGB));
                        r0.put(writePosition + 3, (byte) ((c & '?') | 128));
                        i = 4;
                    } else {
                        UTF8Kt.malformedCodePoint(c);
                        throw new KotlinNothingValueException();
                    }
                }
            }
        }
        if (i <= limit - writePosition) {
            buffer.commitWritten(i);
            return buffer;
        }
        appendFailed(1);
        throw new KotlinNothingValueException();
    }

    public static final void readFully(Buffer buffer, Byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "dst");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3 + i] = Byte.valueOf(r0.get(i3 + readPosition));
            }
            buffer.discardExact(i2);
            return;
        }
        throw new EOFException("Not enough bytes available to read " + i2 + " bytes");
    }
}
