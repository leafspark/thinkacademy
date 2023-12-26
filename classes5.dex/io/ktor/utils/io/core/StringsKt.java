package io.ktor.utils.io.core;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.internal.CharArraySequence;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.EncodeResult;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\r\u0010\t\u001a\u00020\n*\u00020\u000bH\b\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0010\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0003\u001a\u001e\u0010\u0011\u001a\u00020\r*\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00102\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u0007\u001a.\u0010\u0014\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010 \u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\"\u0010!\u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\"\u001a\u00020\u0003H\u0007\u001a \u0010!\u001a\u00020\u0015*\u00020\u00102\u0006\u0010#\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a \u0010$\u001a\u00020\u0015*\u00020\u00102\u0006\u0010\b\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a \u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a \u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u00102\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u001e\u0010'\u001a\u00020\n*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010(\u001a\u00020\u0015*\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a$\u0010*\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u001d\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a(\u0010*\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a,\u0010,\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u001d\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a0\u0010,\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a$\u0010.\u001a\u00020\u0003*\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020+H\u0002\u001a\u001b\u0010/\u001a\u00020\r*\u00020\u00152\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\b\u001a4\u00100\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a4\u00100\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002062\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a$\u00107\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002062\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0002¨\u00068"}, d2 = {"bufferLimitExceeded", "", "limit", "", "prematureEndOfStream", "size", "", "prematureEndOfStreamToReadChars", "charactersCount", "isAsciiChar", "", "", "readBytes", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "n", "Lio/ktor/utils/io/core/Input;", "readBytesOf", "min", "max", "readText", "", "Lio/ktor/utils/io/core/Buffer;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "decoder", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "readTextExact", "readTextExactBytes", "bytes", "bytesCount", "readTextExactCharacters", "readUTF8Line", "estimate", "readUTF8LineTo", "readUTF8UntilDelimiter", "delimiters", "readUTF8UntilDelimiterTo", "Lio/ktor/utils/io/core/Output;", "readUTF8UntilDelimiterToSlowUtf8", "decoded0", "readUTFUntilDelimiterToSlowAscii", "toByteArray", "writeText", "", "text", "", "fromIndex", "toIndex", "", "writeTextUtf8", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Strings.kt */
public final class StringsKt {
    private static final boolean isAsciiChar(char c) {
        return c <= 127;
    }

    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return kotlin.text.StringsKt.encodeToByteArray(str);
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        return CharsetJVMKt.encodeToByteArray(newEncoder, str, 0, str.length());
    }

    public static final byte[] toByteArray(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return kotlin.text.StringsKt.encodeToByteArray(str);
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        return CharsetJVMKt.encodeToByteArray(newEncoder, str, 0, str.length());
    }

    public static /* synthetic */ String readUTF8Line$default(ByteReadPacket byteReadPacket, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 16;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readUTF8Line(byteReadPacket, i, i2);
    }

    public static /* synthetic */ String readUTF8Line$default(Input input, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 16;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readUTF8Line(input, i, i2);
    }

    public static final String readUTF8Line(Input input, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        StringBuilder sb = new StringBuilder(i);
        if (readUTF8LineTo(input, sb, i2)) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ String readUTF8UntilDelimiter$default(Input input, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiter(input, str, i);
    }

    public static final String readUTF8UntilDelimiter(Input input, String str, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(str, "delimiters");
        StringBuilder sb = new StringBuilder();
        readUTF8UntilDelimiterTo(input, (Appendable) sb, str, i);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ int readUTF8UntilDelimiterTo$default(Input input, Appendable appendable, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiterTo(input, appendable, str, i);
    }

    public static /* synthetic */ int readUTF8UntilDelimiterTo$default(Input input, Output output, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiterTo(input, output, str, i);
    }

    public static final int readUTF8UntilDelimiterTo(Input input, Output output, String str, int i) {
        long readUntilDelimiters;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(output, "out");
        Intrinsics.checkNotNullParameter(str, "delimiters");
        int length = str.length();
        if (length == 1) {
            if (str.charAt(0) <= 127) {
                readUntilDelimiters = ScannerKt.readUntilDelimiter(input, (byte) str.charAt(0), output);
                return (int) readUntilDelimiters;
            }
        }
        if (length == 2) {
            if (str.charAt(0) <= 127) {
                if (str.charAt(1) <= 127) {
                    readUntilDelimiters = ScannerKt.readUntilDelimiters(input, (byte) str.charAt(0), (byte) str.charAt(1), output);
                    return (int) readUntilDelimiters;
                }
            }
        }
        return readUTFUntilDelimiterToSlowAscii(input, str, i, output);
    }

    public static /* synthetic */ byte[] readBytes$default(ByteReadPacket byteReadPacket, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            long remaining = byteReadPacket.getRemaining();
            if (remaining <= 2147483647L) {
                i = (int) remaining;
            } else {
                throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
            }
        }
        return readBytes(byteReadPacket, i);
    }

    public static final byte[] readBytes(ByteReadPacket byteReadPacket, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (i == 0) {
            return UnsafeKt.EmptyByteArray;
        }
        byte[] bArr = new byte[i];
        InputArraysKt.readFully((Input) byteReadPacket, bArr, 0, i);
        return bArr;
    }

    public static final byte[] readBytes(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return readBytesOf(input, i, i);
    }

    public static final byte[] readBytes(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return readBytesOf$default(input, 0, 0, 3, (Object) null);
    }

    public static /* synthetic */ byte[] readBytesOf$default(Input input, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readBytesOf(input, i, i2);
    }

    public static final byte[] readBytesOf(Input input, int i, int i2) {
        int readAvailable;
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (i == i2 && i == 0) {
            return UnsafeKt.EmptyByteArray;
        }
        int i3 = 0;
        if (i == i2) {
            byte[] bArr = new byte[i];
            InputArraysKt.readFully(input, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = new byte[((int) RangesKt.coerceAtLeast(RangesKt.coerceAtMost((long) i2, EncodingKt.sizeEstimate(input)), (long) i))];
        while (i3 < i2 && (readAvailable = InputArraysKt.readAvailable(input, bArr2, i3, Math.min(i2, bArr2.length) - i3)) > 0) {
            i3 += readAvailable;
            if (bArr2.length == i3) {
                bArr2 = Arrays.copyOf(bArr2, i3 * 2);
                Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(this, newSize)");
            }
        }
        if (i3 < i) {
            throw new EOFException("Not enough bytes available to read " + i + " bytes: " + (i - i3) + " more required");
        } else if (i3 == bArr2.length) {
            return bArr2;
        } else {
            byte[] copyOf = Arrays.copyOf(bArr2, i3);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            return copyOf;
        }
    }

    public static /* synthetic */ int readText$default(Input input, Appendable appendable, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, appendable, charset, i);
    }

    public static final int readText(Input input, Appendable appendable, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(appendable, "out");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        return CharsetJVMKt.decode(newDecoder, input, appendable, i);
    }

    public static /* synthetic */ String readText$default(Input input, CharsetDecoder charsetDecoder, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, charsetDecoder, i);
    }

    @Deprecated(message = "Use CharsetDecoder.decode instead", replaceWith = @ReplaceWith(expression = "decoder.decode(this, max)", imports = {"io.ktor.utils.io.charsets.decode"}))
    public static final String readText(Input input, CharsetDecoder charsetDecoder, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charsetDecoder, "decoder");
        return EncodingKt.decode(charsetDecoder, input, i);
    }

    public static /* synthetic */ String readText$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, charset, i);
    }

    public static final String readText(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        return EncodingKt.decode(newDecoder, input, i);
    }

    public static final String readText(Buffer buffer, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        StringBuilder sb = new StringBuilder();
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        CharsetJVMKt.decodeBuffer(newDecoder, buffer, sb, true, i);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String readText$default(Buffer buffer, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(buffer, charset, i);
    }

    public static /* synthetic */ String readTextExact$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExact(input, charset, i);
    }

    @Deprecated(message = "Use readTextExactCharacters instead.", replaceWith = @ReplaceWith(expression = "readTextExactCharacters(n, charset)", imports = {}))
    public static final String readTextExact(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        return readTextExactCharacters(input, i, charset);
    }

    public static /* synthetic */ String readTextExactCharacters$default(Input input, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactCharacters(input, i, charset);
    }

    public static final String readTextExactCharacters(Input input, int i, Charset charset) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        String readText = readText(input, charset, i);
        if (readText.length() >= i) {
            return readText;
        }
        prematureEndOfStreamToReadChars(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ String readTextExactBytes$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactBytes(input, charset, i);
    }

    @Deprecated(message = "Parameters order is changed.", replaceWith = @ReplaceWith(expression = "readTextExactBytes(bytes, charset)", imports = {}))
    public static final String readTextExactBytes(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        return readTextExactBytes(input, i, charset);
    }

    public static /* synthetic */ String readTextExactBytes$default(Input input, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactBytes(input, i, charset);
    }

    public static final String readTextExactBytes(Input input, int i, Charset charset) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        return CharsetJVMKt.decodeExactBytes(newDecoder, input, i);
    }

    public static /* synthetic */ void writeText$default(Output output, CharSequence charSequence, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(output, charSequence, i, i2, charset);
    }

    public static final void writeText(Output output, CharSequence charSequence, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        if (charset == Charsets.UTF_8) {
            writeTextUtf8(output, charSequence, i, i2);
            return;
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        EncodingKt.encodeToImpl(newEncoder, output, charSequence, i, i2);
    }

    public static /* synthetic */ void writeText$default(Output output, char[] cArr, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(output, cArr, i, i2, charset);
    }

    public static final void writeText(Output output, char[] cArr, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "text");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        if (charset == Charsets.UTF_8) {
            writeTextUtf8(output, new CharArraySequence(cArr, 0, cArr.length), i, i2);
            return;
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        EncodingKt.encode(newEncoder, cArr, i, i2, output);
    }

    private static final Void bufferLimitExceeded(int i) {
        throw new BufferLimitExceededException("Too many characters before delimiter: limit " + i + " exceeded");
    }

    public static final Void prematureEndOfStream(int i) {
        throw new EOFException("Premature end of stream: expected " + i + " bytes");
    }

    public static final Void prematureEndOfStream(long j) {
        throw new EOFException("Premature end of stream: expected " + j + " bytes");
    }

    private static final Void prematureEndOfStreamToReadChars(int i) {
        throw new EOFException("Not enough input bytes to read " + i + " characters.");
    }

    public static final String readUTF8Line(ByteReadPacket byteReadPacket, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (byteReadPacket.getEndOfInput()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(i);
        if (readUTF8LineTo(byteReadPacket, sb, i2)) {
            return sb.toString();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: int} */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x015e, code lost:
        r6.discardExact(((r13 - r11) - r16) + 1);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x015e A[EDGE_INSN: B:159:0x015e->B:99:0x015e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0152 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x00f0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0079 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x017a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x012d A[Catch:{ all -> 0x01a5, all -> 0x01b0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean readUTF8LineTo(io.ktor.utils.io.core.Input r20, java.lang.Appendable r21, int r22) {
        /*
            r1 = r20
            r0 = r21
            r2 = r22
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "out"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r3)
            if (r4 != 0) goto L_0x001b
            r5 = r3
            r8 = 0
            goto L_0x01e8
        L_0x001b:
            r6 = r3
            r9 = r6
            r7 = 0
            r8 = 0
            r10 = 0
        L_0x0020:
            r11 = r4
            io.ktor.utils.io.core.Buffer r11 = (io.ktor.utils.io.core.Buffer) r11     // Catch:{ all -> 0x0200 }
            int r12 = r11.getWritePosition()     // Catch:{ all -> 0x0200 }
            int r11 = r11.getReadPosition()     // Catch:{ all -> 0x0200 }
            int r12 = r12 - r11
            if (r12 < r6) goto L_0x01b3
            r6 = r4
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6     // Catch:{ all -> 0x01a5 }
            java.nio.ByteBuffer r9 = r6.m184getMemorySK3TCg8()     // Catch:{ all -> 0x01a5 }
            int r11 = r6.getReadPosition()     // Catch:{ all -> 0x01a5 }
            int r12 = r6.getWritePosition()     // Catch:{ all -> 0x01a5 }
            r13 = r11
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0044:
            r18 = -1
            if (r13 >= r12) goto L_0x0181
            byte r5 = r9.get(r13)     // Catch:{ all -> 0x01a5 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            r3 = r5 & 128(0x80, float:1.794E-43)
            r19 = r9
            r9 = 13
            if (r3 != 0) goto L_0x0095
            if (r14 != 0) goto L_0x008c
            char r3 = (char) r5     // Catch:{ all -> 0x01a5 }
            if (r3 != r9) goto L_0x0063
            if (r7 == 0) goto L_0x0060
        L_0x005d:
            r3 = 0
            r10 = 1
            goto L_0x0077
        L_0x0060:
            r3 = 1
            r7 = 1
            goto L_0x0077
        L_0x0063:
            r5 = 10
            if (r3 != r5) goto L_0x006c
            r3 = 0
            r10 = 1
            r17 = 1
            goto L_0x0077
        L_0x006c:
            if (r7 == 0) goto L_0x006f
            goto L_0x005d
        L_0x006f:
            if (r8 == r2) goto L_0x0083
            int r8 = r8 + 1
            r0.append(r3)     // Catch:{ all -> 0x01a5 }
            r3 = 1
        L_0x0077:
            if (r3 != 0) goto L_0x017a
            int r13 = r13 - r11
            r6.discardExact(r13)     // Catch:{ all -> 0x01a5 }
        L_0x007d:
            r3 = r17
            r9 = r18
            goto L_0x0188
        L_0x0083:
            bufferLimitExceeded(r22)     // Catch:{ all -> 0x01a5 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x01a5 }
            r0.<init>()     // Catch:{ all -> 0x01a5 }
            throw r0     // Catch:{ all -> 0x01a5 }
        L_0x008c:
            io.ktor.utils.io.core.internal.UTF8Kt.malformedByteCount(r14)     // Catch:{ all -> 0x01a5 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x01a5 }
            r0.<init>()     // Catch:{ all -> 0x01a5 }
            throw r0     // Catch:{ all -> 0x01a5 }
        L_0x0095:
            if (r14 != 0) goto L_0x00bf
            r3 = 128(0x80, float:1.794E-43)
            r15 = r5
            r5 = 1
        L_0x009b:
            r9 = 7
            if (r5 >= r9) goto L_0x00ab
            r9 = r15 & r3
            if (r9 == 0) goto L_0x00ab
            int r9 = ~r3     // Catch:{ all -> 0x01a5 }
            r15 = r15 & r9
            int r3 = r3 >> 1
            int r14 = r14 + 1
            int r5 = r5 + 1
            goto L_0x009b
        L_0x00ab:
            int r3 = r14 + -1
            int r5 = r12 - r13
            if (r14 <= r5) goto L_0x00ba
            int r13 = r13 - r11
            r6.discardExact(r13)     // Catch:{ all -> 0x01a5 }
            r9 = r14
            r3 = r17
            goto L_0x0188
        L_0x00ba:
            r16 = r14
            r14 = r3
            goto L_0x017a
        L_0x00bf:
            int r3 = r15 << 6
            r5 = r5 & 127(0x7f, float:1.78E-43)
            r15 = r3 | r5
            int r14 = r14 + -1
            if (r14 != 0) goto L_0x017a
            boolean r3 = io.ktor.utils.io.core.internal.UTF8Kt.isBmpCodePoint(r15)     // Catch:{ all -> 0x01a5 }
            if (r3 == 0) goto L_0x0102
            char r3 = (char) r15     // Catch:{ all -> 0x01a5 }
            if (r3 != r9) goto L_0x00da
            if (r7 == 0) goto L_0x00d7
        L_0x00d4:
            r3 = 0
            r10 = 1
            goto L_0x00ee
        L_0x00d7:
            r3 = 1
            r7 = 1
            goto L_0x00ee
        L_0x00da:
            r5 = 10
            if (r3 != r5) goto L_0x00e3
            r3 = 0
            r10 = 1
            r17 = 1
            goto L_0x00ee
        L_0x00e3:
            if (r7 == 0) goto L_0x00e6
            goto L_0x00d4
        L_0x00e6:
            if (r8 == r2) goto L_0x00f9
            int r8 = r8 + 1
            r0.append(r3)     // Catch:{ all -> 0x01a5 }
            r3 = 1
        L_0x00ee:
            if (r3 != 0) goto L_0x0153
            int r13 = r13 - r11
            int r13 = r13 - r16
            r3 = 1
            int r13 = r13 + r3
            r6.discardExact(r13)     // Catch:{ all -> 0x01a5 }
            goto L_0x007d
        L_0x00f9:
            bufferLimitExceeded(r22)     // Catch:{ all -> 0x01a5 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x01a5 }
            r0.<init>()     // Catch:{ all -> 0x01a5 }
            throw r0     // Catch:{ all -> 0x01a5 }
        L_0x0102:
            boolean r3 = io.ktor.utils.io.core.internal.UTF8Kt.isValidCodePoint(r15)     // Catch:{ all -> 0x01a5 }
            if (r3 == 0) goto L_0x0171
            int r3 = io.ktor.utils.io.core.internal.UTF8Kt.highSurrogate(r15)     // Catch:{ all -> 0x01a5 }
            char r3 = (char) r3     // Catch:{ all -> 0x01a5 }
            if (r3 != r9) goto L_0x0117
            if (r7 == 0) goto L_0x0114
        L_0x0111:
            r3 = 0
            r10 = 1
            goto L_0x012b
        L_0x0114:
            r3 = 1
            r7 = 1
            goto L_0x012b
        L_0x0117:
            r5 = 10
            if (r3 != r5) goto L_0x0120
            r3 = 0
            r10 = 1
            r17 = 1
            goto L_0x012b
        L_0x0120:
            if (r7 == 0) goto L_0x0123
            goto L_0x0111
        L_0x0123:
            if (r8 == r2) goto L_0x0168
            int r8 = r8 + 1
            r0.append(r3)     // Catch:{ all -> 0x01a5 }
            r3 = 1
        L_0x012b:
            if (r3 == 0) goto L_0x015e
            int r3 = io.ktor.utils.io.core.internal.UTF8Kt.lowSurrogate(r15)     // Catch:{ all -> 0x01a5 }
            char r3 = (char) r3     // Catch:{ all -> 0x01a5 }
            if (r3 != r9) goto L_0x013c
            if (r7 == 0) goto L_0x0139
        L_0x0136:
            r3 = 0
            r10 = 1
            goto L_0x0150
        L_0x0139:
            r3 = 1
            r7 = 1
            goto L_0x0150
        L_0x013c:
            r5 = 10
            if (r3 != r5) goto L_0x0145
            r3 = 0
            r10 = 1
            r17 = 1
            goto L_0x0150
        L_0x0145:
            if (r7 == 0) goto L_0x0148
            goto L_0x0136
        L_0x0148:
            if (r8 == r2) goto L_0x0155
            int r8 = r8 + 1
            r0.append(r3)     // Catch:{ all -> 0x01a5 }
            r3 = 1
        L_0x0150:
            if (r3 != 0) goto L_0x0153
            goto L_0x015e
        L_0x0153:
            r15 = 0
            goto L_0x017a
        L_0x0155:
            bufferLimitExceeded(r22)     // Catch:{ all -> 0x01a5 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x01a5 }
            r0.<init>()     // Catch:{ all -> 0x01a5 }
            throw r0     // Catch:{ all -> 0x01a5 }
        L_0x015e:
            int r13 = r13 - r11
            int r13 = r13 - r16
            r3 = 1
            int r13 = r13 + r3
            r6.discardExact(r13)     // Catch:{ all -> 0x01a5 }
            goto L_0x007d
        L_0x0168:
            bufferLimitExceeded(r22)     // Catch:{ all -> 0x01a5 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x01a5 }
            r0.<init>()     // Catch:{ all -> 0x01a5 }
            throw r0     // Catch:{ all -> 0x01a5 }
        L_0x0171:
            io.ktor.utils.io.core.internal.UTF8Kt.malformedCodePoint(r15)     // Catch:{ all -> 0x01a5 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x01a5 }
            r0.<init>()     // Catch:{ all -> 0x01a5 }
            throw r0     // Catch:{ all -> 0x01a5 }
        L_0x017a:
            int r13 = r13 + 1
            r9 = r19
            r3 = 1
            goto L_0x0044
        L_0x0181:
            int r12 = r12 - r11
            r6.discardExact(r12)     // Catch:{ all -> 0x01a5 }
            r3 = r17
            r9 = 0
        L_0x0188:
            if (r3 <= 0) goto L_0x018d
            r6.discardExact(r3)     // Catch:{ all -> 0x01a5 }
        L_0x018d:
            if (r10 == 0) goto L_0x0191
            r6 = 0
            goto L_0x0197
        L_0x0191:
            r3 = 1
            int r5 = kotlin.ranges.RangesKt.coerceAtLeast(r9, r3)     // Catch:{ all -> 0x01a5 }
            r6 = r5
        L_0x0197:
            r3 = r4
            io.ktor.utils.io.core.Buffer r3 = (io.ktor.utils.io.core.Buffer) r3     // Catch:{ all -> 0x01b0 }
            int r5 = r3.getWritePosition()     // Catch:{ all -> 0x01b0 }
            int r3 = r3.getReadPosition()     // Catch:{ all -> 0x01b0 }
            int r12 = r5 - r3
            goto L_0x01b3
        L_0x01a5:
            r0 = move-exception
            r2 = r4
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x01b0 }
            r2.getWritePosition()     // Catch:{ all -> 0x01b0 }
            r2.getReadPosition()     // Catch:{ all -> 0x01b0 }
            throw r0     // Catch:{ all -> 0x01b0 }
        L_0x01b0:
            r0 = move-exception
            r3 = 1
            goto L_0x0202
        L_0x01b3:
            if (r12 != 0) goto L_0x01bd
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r4)     // Catch:{ all -> 0x01ba }
            goto L_0x01d9
        L_0x01ba:
            r0 = move-exception
            r3 = 0
            goto L_0x0202
        L_0x01bd:
            if (r12 < r6) goto L_0x01d2
            r3 = r4
            io.ktor.utils.io.core.Buffer r3 = (io.ktor.utils.io.core.Buffer) r3     // Catch:{ all -> 0x01ba }
            int r5 = r3.getCapacity()     // Catch:{ all -> 0x01ba }
            int r3 = r3.getLimit()     // Catch:{ all -> 0x01ba }
            int r5 = r5 - r3
            r3 = 8
            if (r5 >= r3) goto L_0x01d0
            goto L_0x01d2
        L_0x01d0:
            r3 = r4
            goto L_0x01d9
        L_0x01d2:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r4)     // Catch:{ all -> 0x01ba }
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r6)     // Catch:{ all -> 0x01ba }
        L_0x01d9:
            if (r3 != 0) goto L_0x01dd
            r3 = 0
            goto L_0x01e1
        L_0x01dd:
            r4 = r3
            r3 = 1
            if (r6 > 0) goto L_0x0020
        L_0x01e1:
            if (r3 == 0) goto L_0x01e6
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r4)
        L_0x01e6:
            r3 = r9
            r5 = 1
        L_0x01e8:
            if (r3 > r5) goto L_0x01f7
            if (r8 > 0) goto L_0x01f5
            boolean r0 = r20.getEndOfInput()
            if (r0 != 0) goto L_0x01f3
            goto L_0x01f5
        L_0x01f3:
            r3 = 0
            goto L_0x01f6
        L_0x01f5:
            r3 = r5
        L_0x01f6:
            return r3
        L_0x01f7:
            prematureEndOfStream((int) r3)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0200:
            r0 = move-exception
            r5 = r3
        L_0x0202:
            if (r3 == 0) goto L_0x0207
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r4)
        L_0x0207:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.StringsKt.readUTF8LineTo(io.ktor.utils.io.core.Input, java.lang.Appendable, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readUTF8UntilDelimiterTo(io.ktor.utils.io.core.Input r17, java.lang.Appendable r18, java.lang.String r19, int r20) {
        /*
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "out"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            java.lang.String r4 = "delimiters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            r4 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r4)
            r6 = 0
            if (r5 != 0) goto L_0x0022
            r7 = r6
            goto L_0x008f
        L_0x0022:
            r7 = r6
            r8 = r7
        L_0x0024:
            r9 = r5
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch:{ all -> 0x009c }
            java.nio.ByteBuffer r10 = r9.m184getMemorySK3TCg8()     // Catch:{ all -> 0x009c }
            int r11 = r9.getReadPosition()     // Catch:{ all -> 0x009c }
            int r12 = r9.getWritePosition()     // Catch:{ all -> 0x009c }
            r13 = r11
        L_0x0034:
            if (r13 >= r12) goto L_0x0075
            byte r14 = r10.get(r13)     // Catch:{ all -> 0x009c }
            r14 = r14 & 255(0xff, float:3.57E-43)
            r15 = r14 & 128(0x80, float:1.794E-43)
            r4 = 128(0x80, float:1.794E-43)
            if (r15 == r4) goto L_0x006d
            char r4 = (char) r14     // Catch:{ all -> 0x009c }
            r14 = r2
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ all -> 0x009c }
            r15 = 2
            r16 = r8
            r8 = 0
            boolean r8 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r14, (char) r4, (boolean) r6, (int) r15, (java.lang.Object) r8)     // Catch:{ all -> 0x009c }
            if (r8 == 0) goto L_0x0053
            r4 = r6
            r8 = 1
            goto L_0x005d
        L_0x0053:
            if (r7 == r3) goto L_0x0064
            int r7 = r7 + 1
            r0.append(r4)     // Catch:{ all -> 0x009c }
            r8 = r16
            r4 = 1
        L_0x005d:
            if (r4 != 0) goto L_0x0060
            goto L_0x006f
        L_0x0060:
            int r13 = r13 + 1
            r4 = 1
            goto L_0x0034
        L_0x0064:
            bufferLimitExceeded(r20)     // Catch:{ all -> 0x009c }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x009c }
            r0.<init>()     // Catch:{ all -> 0x009c }
            throw r0     // Catch:{ all -> 0x009c }
        L_0x006d:
            r16 = r8
        L_0x006f:
            int r13 = r13 - r11
            r9.discardExact(r13)     // Catch:{ all -> 0x009c }
            r4 = r6
            goto L_0x007e
        L_0x0075:
            r16 = r8
            int r12 = r12 - r11
            r9.discardExact(r12)     // Catch:{ all -> 0x009c }
            r8 = r16
            r4 = 1
        L_0x007e:
            if (r4 != 0) goto L_0x0082
            r4 = 1
            goto L_0x0089
        L_0x0082:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r5)     // Catch:{ all -> 0x0099 }
            if (r4 != 0) goto L_0x0096
            r4 = r6
        L_0x0089:
            if (r4 == 0) goto L_0x008e
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        L_0x008e:
            r6 = r8
        L_0x008f:
            if (r6 != 0) goto L_0x0095
            int r7 = readUTF8UntilDelimiterToSlowUtf8((io.ktor.utils.io.core.Input) r1, (java.lang.Appendable) r0, (java.lang.String) r2, (int) r3, (int) r7)
        L_0x0095:
            return r7
        L_0x0096:
            r5 = r4
            r4 = 1
            goto L_0x0024
        L_0x0099:
            r0 = move-exception
            r4 = r6
            goto L_0x009e
        L_0x009c:
            r0 = move-exception
            r4 = 1
        L_0x009e:
            if (r4 == 0) goto L_0x00a3
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        L_0x00a3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.StringsKt.readUTF8UntilDelimiterTo(io.ktor.utils.io.core.Input, java.lang.Appendable, java.lang.String, int):int");
    }

    private static final void writeTextUtf8(Output output, CharSequence charSequence, int i, int i2) {
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int r2 = UTF8Kt.m304encodeUTF8lBXzO7A(buffer.m184getMemorySK3TCg8(), charSequence, i, i2, buffer.getWritePosition(), buffer.getLimit());
                short r3 = EncodeResult.m293component1Mh2AYeg(r2);
                short r22 = EncodeResult.m294component2Mh2AYeg(r2);
                short s = r3 & UShort.MAX_VALUE;
                i += s;
                buffer.commitWritten(r22 & UShort.MAX_VALUE);
                int i3 = (s != 0 || i >= i2) ? i < i2 ? 1 : 0 : 8;
                if (i3 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int readUTFUntilDelimiterToSlowAscii(io.ktor.utils.io.core.Input r18, java.lang.String r19, int r20, io.ktor.utils.io.core.Output r21) {
        /*
            r1 = r18
            r0 = r19
            r2 = r20
            r3 = r21
            r4 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r4)
            if (r5 != 0) goto L_0x0013
            r6 = 0
            r7 = 0
            goto L_0x009f
        L_0x0013:
            r7 = 0
            r8 = 0
        L_0x0015:
            r9 = r5
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch:{ all -> 0x00b3 }
            int r10 = r9.getWritePosition()     // Catch:{ all -> 0x00b3 }
            int r11 = r9.getReadPosition()     // Catch:{ all -> 0x00b3 }
            int r10 = r10 - r11
            java.nio.ByteBuffer r11 = r9.m184getMemorySK3TCg8()     // Catch:{ all -> 0x00b3 }
            int r12 = r9.getReadPosition()     // Catch:{ all -> 0x00b3 }
            int r13 = r9.getWritePosition()     // Catch:{ all -> 0x00b3 }
            r14 = r12
        L_0x002e:
            if (r14 >= r13) goto L_0x0072
            byte r15 = r11.get(r14)     // Catch:{ all -> 0x00b3 }
            r15 = r15 & 255(0xff, float:3.57E-43)
            r4 = r15 & 128(0x80, float:1.794E-43)
            r6 = 128(0x80, float:1.794E-43)
            if (r4 == r6) goto L_0x0069
            char r4 = (char) r15     // Catch:{ all -> 0x00b3 }
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00b3 }
            r15 = 2
            r16 = r8
            r8 = 0
            r17 = r11
            r11 = 0
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r6, (char) r4, (boolean) r11, (int) r15, (java.lang.Object) r8)     // Catch:{ all -> 0x00b3 }
            if (r4 == 0) goto L_0x0050
            r4 = r11
            r8 = 1
            goto L_0x0057
        L_0x0050:
            if (r7 == r2) goto L_0x0060
            int r7 = r7 + 1
            r8 = r16
            r4 = 1
        L_0x0057:
            if (r4 != 0) goto L_0x005a
            goto L_0x006c
        L_0x005a:
            int r14 = r14 + 1
            r11 = r17
            r4 = 1
            goto L_0x002e
        L_0x0060:
            bufferLimitExceeded(r20)     // Catch:{ all -> 0x00b3 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x00b3 }
            r0.<init>()     // Catch:{ all -> 0x00b3 }
            throw r0     // Catch:{ all -> 0x00b3 }
        L_0x0069:
            r16 = r8
            r11 = 0
        L_0x006c:
            int r14 = r14 - r12
            r9.discardExact(r14)     // Catch:{ all -> 0x00b3 }
            r4 = r11
            goto L_0x007c
        L_0x0072:
            r16 = r8
            r11 = 0
            int r13 = r13 - r12
            r9.discardExact(r13)     // Catch:{ all -> 0x00b3 }
            r8 = r16
            r4 = 1
        L_0x007c:
            int r6 = r9.getWritePosition()     // Catch:{ all -> 0x00b3 }
            int r12 = r9.getReadPosition()     // Catch:{ all -> 0x00b3 }
            int r6 = r6 - r12
            int r10 = r10 - r6
            if (r10 <= 0) goto L_0x008e
            r9.rewind(r10)     // Catch:{ all -> 0x00b3 }
            io.ktor.utils.io.core.OutputKt.writeFully(r3, r9, r10)     // Catch:{ all -> 0x00b3 }
        L_0x008e:
            if (r4 != 0) goto L_0x0092
            r4 = 1
            goto L_0x0099
        L_0x0092:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r5)     // Catch:{ all -> 0x00b0 }
            if (r4 != 0) goto L_0x00ac
            r4 = r11
        L_0x0099:
            if (r4 == 0) goto L_0x009e
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        L_0x009e:
            r6 = r8
        L_0x009f:
            if (r6 != 0) goto L_0x00ab
            boolean r4 = r18.getEndOfInput()
            if (r4 != 0) goto L_0x00ab
            int r7 = readUTF8UntilDelimiterToSlowUtf8((io.ktor.utils.io.core.Input) r1, (io.ktor.utils.io.core.Output) r3, (java.lang.String) r0, (int) r2, (int) r7)
        L_0x00ab:
            return r7
        L_0x00ac:
            r5 = r4
            r4 = 1
            goto L_0x0015
        L_0x00b0:
            r0 = move-exception
            r4 = r11
            goto L_0x00b5
        L_0x00b3:
            r0 = move-exception
            r4 = 1
        L_0x00b5:
            if (r4 == 0) goto L_0x00ba
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        L_0x00ba:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.StringsKt.readUTFUntilDelimiterToSlowAscii(io.ktor.utils.io.core.Input, java.lang.String, int, io.ktor.utils.io.core.Output):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x01e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.io.core.Input r17, io.ktor.utils.io.core.Output r18, java.lang.String r19, int r20, int r21) {
        /*
            r1 = r17
            r0 = r20
            r2 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r2)
            if (r3 != 0) goto L_0x0011
            r3 = r21
            r1 = r2
            r9 = r1
            goto L_0x01d2
        L_0x0011:
            r5 = r2
            r6 = r5
            r4 = r3
            r3 = r21
        L_0x0016:
            r8 = r4
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.io.core.Buffer) r8     // Catch:{ all -> 0x01e1 }
            int r9 = r8.getWritePosition()     // Catch:{ all -> 0x01e1 }
            int r8 = r8.getReadPosition()     // Catch:{ all -> 0x01e1 }
            int r9 = r9 - r8
            if (r9 < r5) goto L_0x0196
            r5 = r4
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0186 }
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x0186 }
            int r8 = r5.getReadPosition()     // Catch:{ all -> 0x0186 }
            int r6 = r6 - r8
            java.nio.ByteBuffer r8 = r5.m184getMemorySK3TCg8()     // Catch:{ all -> 0x0186 }
            int r9 = r5.getReadPosition()     // Catch:{ all -> 0x0186 }
            int r10 = r5.getWritePosition()     // Catch:{ all -> 0x0186 }
            r11 = r9
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x0040:
            if (r11 >= r10) goto L_0x014f
            byte r15 = r8.get(r11)     // Catch:{ all -> 0x0186 }
            r15 = r15 & 255(0xff, float:3.57E-43)
            r2 = r15 & 128(0x80, float:1.794E-43)
            r7 = 2
            if (r2 != 0) goto L_0x007f
            if (r12 != 0) goto L_0x0076
            char r2 = (char) r15     // Catch:{ all -> 0x0186 }
            r15 = r19
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ all -> 0x0186 }
            r16 = r8
            r1 = 0
            r8 = 0
            boolean r2 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r15, (char) r2, (boolean) r1, (int) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x0186 }
            if (r2 == 0) goto L_0x0060
            r1 = 0
            goto L_0x0065
        L_0x0060:
            if (r3 == r0) goto L_0x006d
            int r3 = r3 + 1
            r1 = 1
        L_0x0065:
            if (r1 != 0) goto L_0x0145
            int r11 = r11 - r9
            r5.discardExact(r11)     // Catch:{ all -> 0x0186 }
        L_0x006b:
            r1 = -1
            goto L_0x00a2
        L_0x006d:
            bufferLimitExceeded(r20)     // Catch:{ all -> 0x0186 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0186 }
            r0.<init>()     // Catch:{ all -> 0x0186 }
            throw r0     // Catch:{ all -> 0x0186 }
        L_0x0076:
            io.ktor.utils.io.core.internal.UTF8Kt.malformedByteCount(r12)     // Catch:{ all -> 0x0186 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0186 }
            r0.<init>()     // Catch:{ all -> 0x0186 }
            throw r0     // Catch:{ all -> 0x0186 }
        L_0x007f:
            r16 = r8
            if (r12 != 0) goto L_0x00aa
            r1 = 128(0x80, float:1.794E-43)
            r13 = r15
            r2 = 1
        L_0x0087:
            r7 = 7
            if (r2 >= r7) goto L_0x0097
            r7 = r13 & r1
            if (r7 == 0) goto L_0x0097
            int r7 = ~r1     // Catch:{ all -> 0x0186 }
            r13 = r13 & r7
            int r1 = r1 >> 1
            int r12 = r12 + 1
            int r2 = r2 + 1
            goto L_0x0087
        L_0x0097:
            int r1 = r12 + -1
            int r2 = r10 - r11
            if (r12 <= r2) goto L_0x00a5
            int r11 = r11 - r9
            r5.discardExact(r11)     // Catch:{ all -> 0x0186 }
            r1 = r12
        L_0x00a2:
            r8 = 0
            goto L_0x0155
        L_0x00a5:
            r14 = r12
            r8 = 0
            r12 = r1
            goto L_0x0146
        L_0x00aa:
            int r1 = r13 << 6
            r2 = r15 & 127(0x7f, float:1.78E-43)
            r13 = r1 | r2
            int r12 = r12 + -1
            if (r12 != 0) goto L_0x0145
            boolean r1 = io.ktor.utils.io.core.internal.UTF8Kt.isBmpCodePoint(r13)     // Catch:{ all -> 0x0186 }
            if (r1 == 0) goto L_0x00e3
            char r1 = (char) r13     // Catch:{ all -> 0x0186 }
            r2 = r19
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x0186 }
            r8 = 0
            r13 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (char) r1, (boolean) r13, (int) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x0186 }
            if (r1 == 0) goto L_0x00c9
            r1 = 0
            goto L_0x00ce
        L_0x00c9:
            if (r3 == r0) goto L_0x00da
            int r3 = r3 + 1
            r1 = 1
        L_0x00ce:
            if (r1 != 0) goto L_0x00d8
            int r11 = r11 - r9
            int r11 = r11 - r14
            r1 = 1
            int r11 = r11 + r1
            r5.discardExact(r11)     // Catch:{ all -> 0x0186 }
            goto L_0x006b
        L_0x00d8:
            r8 = 0
            goto L_0x011e
        L_0x00da:
            bufferLimitExceeded(r20)     // Catch:{ all -> 0x0186 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0186 }
            r0.<init>()     // Catch:{ all -> 0x0186 }
            throw r0     // Catch:{ all -> 0x0186 }
        L_0x00e3:
            boolean r1 = io.ktor.utils.io.core.internal.UTF8Kt.isValidCodePoint(r13)     // Catch:{ all -> 0x0186 }
            if (r1 == 0) goto L_0x013c
            int r1 = io.ktor.utils.io.core.internal.UTF8Kt.highSurrogate(r13)     // Catch:{ all -> 0x0186 }
            char r1 = (char) r1     // Catch:{ all -> 0x0186 }
            r2 = r19
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x0186 }
            r8 = 0
            r15 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (char) r1, (boolean) r15, (int) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x0186 }
            if (r1 == 0) goto L_0x00fc
            r1 = 0
            goto L_0x0101
        L_0x00fc:
            if (r3 == r0) goto L_0x0133
            int r3 = r3 + 1
            r1 = 1
        L_0x0101:
            if (r1 == 0) goto L_0x0129
            int r1 = io.ktor.utils.io.core.internal.UTF8Kt.lowSurrogate(r13)     // Catch:{ all -> 0x0186 }
            char r1 = (char) r1     // Catch:{ all -> 0x0186 }
            r2 = r19
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x0186 }
            r8 = 0
            r13 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (char) r1, (boolean) r8, (int) r7, (java.lang.Object) r13)     // Catch:{ all -> 0x0186 }
            if (r1 == 0) goto L_0x0116
            r1 = r8
            goto L_0x011b
        L_0x0116:
            if (r3 == r0) goto L_0x0120
            int r3 = r3 + 1
            r1 = 1
        L_0x011b:
            if (r1 != 0) goto L_0x011e
            goto L_0x012a
        L_0x011e:
            r13 = r8
            goto L_0x0146
        L_0x0120:
            bufferLimitExceeded(r20)     // Catch:{ all -> 0x0186 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0186 }
            r0.<init>()     // Catch:{ all -> 0x0186 }
            throw r0     // Catch:{ all -> 0x0186 }
        L_0x0129:
            r8 = 0
        L_0x012a:
            int r11 = r11 - r9
            int r11 = r11 - r14
            r1 = 1
            int r11 = r11 + r1
            r5.discardExact(r11)     // Catch:{ all -> 0x0186 }
            r1 = -1
            goto L_0x0155
        L_0x0133:
            bufferLimitExceeded(r20)     // Catch:{ all -> 0x0186 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0186 }
            r0.<init>()     // Catch:{ all -> 0x0186 }
            throw r0     // Catch:{ all -> 0x0186 }
        L_0x013c:
            io.ktor.utils.io.core.internal.UTF8Kt.malformedCodePoint(r13)     // Catch:{ all -> 0x0186 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0186 }
            r0.<init>()     // Catch:{ all -> 0x0186 }
            throw r0     // Catch:{ all -> 0x0186 }
        L_0x0145:
            r8 = 0
        L_0x0146:
            int r11 = r11 + 1
            r2 = 1
            r1 = r17
            r8 = r16
            goto L_0x0040
        L_0x014f:
            r8 = 0
            int r10 = r10 - r9
            r5.discardExact(r10)     // Catch:{ all -> 0x0186 }
            r1 = r8
        L_0x0155:
            int r2 = r5.getWritePosition()     // Catch:{ all -> 0x0186 }
            int r7 = r5.getReadPosition()     // Catch:{ all -> 0x0186 }
            int r2 = r2 - r7
            int r6 = r6 - r2
            if (r6 <= 0) goto L_0x016a
            r5.rewind(r6)     // Catch:{ all -> 0x0186 }
            r2 = r18
            io.ktor.utils.io.core.OutputKt.writeFully(r2, r5, r6)     // Catch:{ all -> 0x0186 }
            goto L_0x016c
        L_0x016a:
            r2 = r18
        L_0x016c:
            r5 = -1
            if (r1 != r5) goto L_0x0171
            r5 = r8
            goto L_0x0177
        L_0x0171:
            r5 = 1
            int r1 = kotlin.ranges.RangesKt.coerceAtLeast(r1, r5)     // Catch:{ all -> 0x0186 }
            r5 = r1
        L_0x0177:
            r1 = r4
            io.ktor.utils.io.core.Buffer r1 = (io.ktor.utils.io.core.Buffer) r1     // Catch:{ all -> 0x0191 }
            int r6 = r1.getWritePosition()     // Catch:{ all -> 0x0191 }
            int r1 = r1.getReadPosition()     // Catch:{ all -> 0x0191 }
            int r9 = r6 - r1
            r6 = r5
            goto L_0x0199
        L_0x0186:
            r0 = move-exception
            r1 = r4
            io.ktor.utils.io.core.Buffer r1 = (io.ktor.utils.io.core.Buffer) r1     // Catch:{ all -> 0x0191 }
            r1.getWritePosition()     // Catch:{ all -> 0x0191 }
            r1.getReadPosition()     // Catch:{ all -> 0x0191 }
            throw r0     // Catch:{ all -> 0x0191 }
        L_0x0191:
            r0 = move-exception
            r2 = 1
            r1 = r17
            goto L_0x01e3
        L_0x0196:
            r2 = r18
            r8 = 0
        L_0x0199:
            if (r9 != 0) goto L_0x01a5
            r1 = r17
            io.ktor.utils.io.core.internal.ChunkBuffer r7 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r4)     // Catch:{ all -> 0x01a2 }
            goto L_0x01c3
        L_0x01a2:
            r0 = move-exception
            r2 = r8
            goto L_0x01e3
        L_0x01a5:
            r1 = r17
            if (r9 < r5) goto L_0x01bc
            r7 = r4
            io.ktor.utils.io.core.Buffer r7 = (io.ktor.utils.io.core.Buffer) r7     // Catch:{ all -> 0x01a2 }
            int r9 = r7.getCapacity()     // Catch:{ all -> 0x01a2 }
            int r7 = r7.getLimit()     // Catch:{ all -> 0x01a2 }
            int r9 = r9 - r7
            r7 = 8
            if (r9 >= r7) goto L_0x01ba
            goto L_0x01bc
        L_0x01ba:
            r7 = r4
            goto L_0x01c3
        L_0x01bc:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r4)     // Catch:{ all -> 0x01a2 }
            io.ktor.utils.io.core.internal.ChunkBuffer r7 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r5)     // Catch:{ all -> 0x01a2 }
        L_0x01c3:
            if (r7 != 0) goto L_0x01c7
            r7 = r8
            goto L_0x01cb
        L_0x01c7:
            r4 = r7
            if (r5 > 0) goto L_0x01de
            r7 = 1
        L_0x01cb:
            if (r7 == 0) goto L_0x01d0
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r4)
        L_0x01d0:
            r1 = r6
            r9 = 1
        L_0x01d2:
            if (r1 > r9) goto L_0x01d5
            return r3
        L_0x01d5:
            prematureEndOfStream((int) r1)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x01de:
            r2 = 1
            goto L_0x0016
        L_0x01e1:
            r0 = move-exception
            r9 = r2
        L_0x01e3:
            if (r2 == 0) goto L_0x01e8
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r4)
        L_0x01e8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.StringsKt.readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.io.core.Input, io.ktor.utils.io.core.Output, java.lang.String, int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x01d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.io.core.Input r17, java.lang.Appendable r18, java.lang.String r19, int r20, int r21) {
        /*
            r1 = r17
            r0 = r18
            r2 = r20
            r3 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r3)
            if (r4 != 0) goto L_0x0013
            r4 = r21
            r1 = r3
            r8 = r1
            goto L_0x01bf
        L_0x0013:
            r6 = r3
            r7 = r6
            r5 = r4
            r4 = r21
        L_0x0018:
            r9 = r5
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch:{ all -> 0x01ce }
            int r10 = r9.getWritePosition()     // Catch:{ all -> 0x01ce }
            int r9 = r9.getReadPosition()     // Catch:{ all -> 0x01ce }
            int r10 = r10 - r9
            if (r10 < r6) goto L_0x0185
            r6 = r5
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6     // Catch:{ all -> 0x0175 }
            java.nio.ByteBuffer r7 = r6.m184getMemorySK3TCg8()     // Catch:{ all -> 0x0175 }
            int r9 = r6.getReadPosition()     // Catch:{ all -> 0x0175 }
            int r10 = r6.getWritePosition()     // Catch:{ all -> 0x0175 }
            r11 = r9
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x0039:
            if (r11 >= r10) goto L_0x0155
            byte r15 = r7.get(r11)     // Catch:{ all -> 0x0175 }
            r15 = r15 & 255(0xff, float:3.57E-43)
            r3 = r15 & 128(0x80, float:1.794E-43)
            r8 = 2
            if (r3 != 0) goto L_0x007b
            if (r12 != 0) goto L_0x0072
            char r3 = (char) r15     // Catch:{ all -> 0x0175 }
            r15 = r19
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ all -> 0x0175 }
            r16 = r7
            r1 = 0
            r7 = 0
            boolean r7 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r15, (char) r3, (boolean) r1, (int) r8, (java.lang.Object) r7)     // Catch:{ all -> 0x0175 }
            if (r7 == 0) goto L_0x0059
            r1 = 0
            goto L_0x0061
        L_0x0059:
            if (r4 == r2) goto L_0x0069
            int r4 = r4 + 1
            r0.append(r3)     // Catch:{ all -> 0x0175 }
            r1 = 1
        L_0x0061:
            if (r1 != 0) goto L_0x014b
            int r11 = r11 - r9
            r6.discardExact(r11)     // Catch:{ all -> 0x0175 }
        L_0x0067:
            r1 = -1
            goto L_0x009e
        L_0x0069:
            bufferLimitExceeded(r20)     // Catch:{ all -> 0x0175 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0175 }
            r0.<init>()     // Catch:{ all -> 0x0175 }
            throw r0     // Catch:{ all -> 0x0175 }
        L_0x0072:
            io.ktor.utils.io.core.internal.UTF8Kt.malformedByteCount(r12)     // Catch:{ all -> 0x0175 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0175 }
            r0.<init>()     // Catch:{ all -> 0x0175 }
            throw r0     // Catch:{ all -> 0x0175 }
        L_0x007b:
            r16 = r7
            if (r12 != 0) goto L_0x00a7
            r1 = 128(0x80, float:1.794E-43)
            r13 = r15
            r3 = 1
        L_0x0083:
            r7 = 7
            if (r3 >= r7) goto L_0x0093
            r7 = r13 & r1
            if (r7 == 0) goto L_0x0093
            int r7 = ~r1     // Catch:{ all -> 0x0175 }
            r13 = r13 & r7
            int r1 = r1 >> 1
            int r12 = r12 + 1
            int r3 = r3 + 1
            goto L_0x0083
        L_0x0093:
            int r1 = r12 + -1
            int r3 = r10 - r11
            if (r12 <= r3) goto L_0x00a2
            int r11 = r11 - r9
            r6.discardExact(r11)     // Catch:{ all -> 0x0175 }
            r1 = r12
        L_0x009e:
            r3 = -1
            r15 = 0
            goto L_0x015c
        L_0x00a2:
            r14 = r12
            r15 = 0
            r12 = r1
            goto L_0x014c
        L_0x00a7:
            int r1 = r13 << 6
            r3 = r15 & 127(0x7f, float:1.78E-43)
            r13 = r1 | r3
            int r12 = r12 + -1
            if (r12 != 0) goto L_0x014b
            boolean r1 = io.ktor.utils.io.core.internal.UTF8Kt.isBmpCodePoint(r13)     // Catch:{ all -> 0x0175 }
            if (r1 == 0) goto L_0x00e3
            char r1 = (char) r13     // Catch:{ all -> 0x0175 }
            r3 = r19
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0175 }
            r7 = 0
            r13 = 0
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r3, (char) r1, (boolean) r13, (int) r8, (java.lang.Object) r7)     // Catch:{ all -> 0x0175 }
            if (r3 == 0) goto L_0x00c6
            r1 = 0
            goto L_0x00ce
        L_0x00c6:
            if (r4 == r2) goto L_0x00da
            int r4 = r4 + 1
            r0.append(r1)     // Catch:{ all -> 0x0175 }
            r1 = 1
        L_0x00ce:
            if (r1 != 0) goto L_0x00d8
            int r11 = r11 - r9
            int r11 = r11 - r14
            r1 = 1
            int r11 = r11 + r1
            r6.discardExact(r11)     // Catch:{ all -> 0x0175 }
            goto L_0x0067
        L_0x00d8:
            r15 = 0
            goto L_0x0124
        L_0x00da:
            bufferLimitExceeded(r20)     // Catch:{ all -> 0x0175 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0175 }
            r0.<init>()     // Catch:{ all -> 0x0175 }
            throw r0     // Catch:{ all -> 0x0175 }
        L_0x00e3:
            boolean r1 = io.ktor.utils.io.core.internal.UTF8Kt.isValidCodePoint(r13)     // Catch:{ all -> 0x0175 }
            if (r1 == 0) goto L_0x0142
            int r1 = io.ktor.utils.io.core.internal.UTF8Kt.highSurrogate(r13)     // Catch:{ all -> 0x0175 }
            char r1 = (char) r1     // Catch:{ all -> 0x0175 }
            r3 = r19
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0175 }
            r7 = 0
            r15 = 0
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r3, (char) r1, (boolean) r15, (int) r8, (java.lang.Object) r7)     // Catch:{ all -> 0x0175 }
            if (r3 == 0) goto L_0x00fc
            r1 = 0
            goto L_0x0104
        L_0x00fc:
            if (r4 == r2) goto L_0x0139
            int r4 = r4 + 1
            r0.append(r1)     // Catch:{ all -> 0x0175 }
            r1 = 1
        L_0x0104:
            if (r1 == 0) goto L_0x012f
            int r1 = io.ktor.utils.io.core.internal.UTF8Kt.lowSurrogate(r13)     // Catch:{ all -> 0x0175 }
            char r1 = (char) r1     // Catch:{ all -> 0x0175 }
            r3 = r19
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0175 }
            r7 = 0
            r15 = 0
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r3, (char) r1, (boolean) r15, (int) r8, (java.lang.Object) r7)     // Catch:{ all -> 0x0175 }
            if (r3 == 0) goto L_0x0119
            r1 = r15
            goto L_0x0121
        L_0x0119:
            if (r4 == r2) goto L_0x0126
            int r4 = r4 + 1
            r0.append(r1)     // Catch:{ all -> 0x0175 }
            r1 = 1
        L_0x0121:
            if (r1 != 0) goto L_0x0124
            goto L_0x0130
        L_0x0124:
            r13 = r15
            goto L_0x014c
        L_0x0126:
            bufferLimitExceeded(r20)     // Catch:{ all -> 0x0175 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0175 }
            r0.<init>()     // Catch:{ all -> 0x0175 }
            throw r0     // Catch:{ all -> 0x0175 }
        L_0x012f:
            r15 = 0
        L_0x0130:
            int r11 = r11 - r9
            int r11 = r11 - r14
            r1 = 1
            int r11 = r11 + r1
            r6.discardExact(r11)     // Catch:{ all -> 0x0175 }
            r1 = -1
            goto L_0x015b
        L_0x0139:
            bufferLimitExceeded(r20)     // Catch:{ all -> 0x0175 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0175 }
            r0.<init>()     // Catch:{ all -> 0x0175 }
            throw r0     // Catch:{ all -> 0x0175 }
        L_0x0142:
            io.ktor.utils.io.core.internal.UTF8Kt.malformedCodePoint(r13)     // Catch:{ all -> 0x0175 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0175 }
            r0.<init>()     // Catch:{ all -> 0x0175 }
            throw r0     // Catch:{ all -> 0x0175 }
        L_0x014b:
            r15 = 0
        L_0x014c:
            int r11 = r11 + 1
            r3 = 1
            r1 = r17
            r7 = r16
            goto L_0x0039
        L_0x0155:
            r15 = 0
            int r10 = r10 - r9
            r6.discardExact(r10)     // Catch:{ all -> 0x0175 }
            r1 = r15
        L_0x015b:
            r3 = -1
        L_0x015c:
            if (r1 != r3) goto L_0x0160
            r6 = r15
            goto L_0x0166
        L_0x0160:
            r3 = 1
            int r1 = kotlin.ranges.RangesKt.coerceAtLeast(r1, r3)     // Catch:{ all -> 0x0175 }
            r6 = r1
        L_0x0166:
            r1 = r5
            io.ktor.utils.io.core.Buffer r1 = (io.ktor.utils.io.core.Buffer) r1     // Catch:{ all -> 0x0180 }
            int r3 = r1.getWritePosition()     // Catch:{ all -> 0x0180 }
            int r1 = r1.getReadPosition()     // Catch:{ all -> 0x0180 }
            int r10 = r3 - r1
            r7 = r6
            goto L_0x0186
        L_0x0175:
            r0 = move-exception
            r1 = r5
            io.ktor.utils.io.core.Buffer r1 = (io.ktor.utils.io.core.Buffer) r1     // Catch:{ all -> 0x0180 }
            r1.getWritePosition()     // Catch:{ all -> 0x0180 }
            r1.getReadPosition()     // Catch:{ all -> 0x0180 }
            throw r0     // Catch:{ all -> 0x0180 }
        L_0x0180:
            r0 = move-exception
            r3 = 1
            r1 = r17
            goto L_0x01d0
        L_0x0185:
            r15 = 0
        L_0x0186:
            if (r10 != 0) goto L_0x0192
            r1 = r17
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r5)     // Catch:{ all -> 0x018f }
            goto L_0x01b0
        L_0x018f:
            r0 = move-exception
            r3 = r15
            goto L_0x01d0
        L_0x0192:
            r1 = r17
            if (r10 < r6) goto L_0x01a9
            r3 = r5
            io.ktor.utils.io.core.Buffer r3 = (io.ktor.utils.io.core.Buffer) r3     // Catch:{ all -> 0x018f }
            int r8 = r3.getCapacity()     // Catch:{ all -> 0x018f }
            int r3 = r3.getLimit()     // Catch:{ all -> 0x018f }
            int r8 = r8 - r3
            r3 = 8
            if (r8 >= r3) goto L_0x01a7
            goto L_0x01a9
        L_0x01a7:
            r3 = r5
            goto L_0x01b0
        L_0x01a9:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)     // Catch:{ all -> 0x018f }
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r6)     // Catch:{ all -> 0x018f }
        L_0x01b0:
            if (r3 != 0) goto L_0x01b4
            r8 = r15
            goto L_0x01b8
        L_0x01b4:
            r5 = r3
            if (r6 > 0) goto L_0x01cb
            r8 = 1
        L_0x01b8:
            if (r8 == 0) goto L_0x01bd
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        L_0x01bd:
            r1 = r7
            r8 = 1
        L_0x01bf:
            if (r1 > r8) goto L_0x01c2
            return r4
        L_0x01c2:
            prematureEndOfStream((int) r1)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x01cb:
            r3 = 1
            goto L_0x0018
        L_0x01ce:
            r0 = move-exception
            r8 = r3
        L_0x01d0:
            if (r3 == 0) goto L_0x01d5
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        L_0x01d5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.StringsKt.readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.io.core.Input, java.lang.Appendable, java.lang.String, int, int):int");
    }
}
