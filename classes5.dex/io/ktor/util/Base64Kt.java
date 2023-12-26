package io.ktor.util;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputArraysKt;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\f\u001a\n\u0010\n\u001a\u00020\r*\u00020\u0001\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\f\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\r\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0001\u001a\r\u0010\u0010\u001a\u00020\u0005*\u00020\u0005H\b\u001a\r\u0010\u0011\u001a\u00020\t*\u00020\u0007H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"BASE64_ALPHABET", "", "BASE64_INVERSE_ALPHABET", "", "BASE64_MASK", "", "BASE64_MASK_INT", "", "BASE64_PAD", "", "decodeBase64Bytes", "Lio/ktor/utils/io/core/Input;", "Lio/ktor/utils/io/core/ByteReadPacket;", "", "decodeBase64String", "encodeBase64", "fromBase64", "toBase64", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Base64.kt */
public final class Base64Kt {
    private static final String BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    /* access modifiers changed from: private */
    public static final int[] BASE64_INVERSE_ALPHABET;
    private static final byte BASE64_MASK = 63;
    private static final int BASE64_MASK_INT = 63;
    private static final char BASE64_PAD = '=';

    static {
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[i] = StringsKt.indexOf$default((CharSequence) BASE64_ALPHABET, (char) i, 0, false, 6, (Object) null);
        }
        BASE64_INVERSE_ALPHABET = iArr;
    }

    public static final String encodeBase64(byte[] bArr) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i3 = 3;
        char[] cArr = new char[(((bArr.length * 8) / 6) + 3)];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i4 + 3;
            if (i6 > bArr.length) {
                break;
            }
            byte b = (bArr[i4 + 2] & UByte.MAX_VALUE) | ((bArr[i4] & UByte.MAX_VALUE) << 16) | ((bArr[i4 + 1] & UByte.MAX_VALUE) << 8);
            int i7 = 3;
            while (-1 < i7) {
                cArr[i5] = BASE64_ALPHABET.charAt((b >> (i7 * 6)) & 63);
                i7--;
                i5++;
            }
            i4 = i6;
        }
        int length = bArr.length - i4;
        if (length == 0) {
            return StringsKt.concatToString(cArr, 0, i5);
        }
        if (length == 1) {
            i = ((bArr[i4] & UByte.MAX_VALUE) << 16) | 0;
        } else {
            i = ((bArr[i4 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i4] & UByte.MAX_VALUE) << 16);
        }
        int i8 = i | 0;
        int i9 = ((3 - length) * 8) / 6;
        if (i9 <= 3) {
            while (true) {
                i2 = i5 + 1;
                cArr[i5] = BASE64_ALPHABET.charAt((i8 >> (i3 * 6)) & 63);
                if (i3 == i9) {
                    break;
                }
                i3--;
                i5 = i2;
            }
            i5 = i2;
        }
        int i10 = 0;
        while (i10 < i9) {
            cArr[i5] = BASE64_PAD;
            i10++;
            i5++;
        }
        return StringsKt.concatToString(cArr, 0, i5);
    }

    public static final String encodeBase64(ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        return encodeBase64(io.ktor.utils.io.core.StringsKt.readBytes$default(byteReadPacket, 0, 1, (Object) null));
    }

    public static final String decodeBase64String(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] decodeBase64Bytes = decodeBase64Bytes(str);
        return new String(decodeBase64Bytes, 0, decodeBase64Bytes.length, Charsets.UTF_8);
    }

    public static final char toBase64(int i) {
        return BASE64_ALPHABET.charAt(i);
    }

    public static final byte fromBase64(byte b) {
        return (byte) (((byte) BASE64_INVERSE_ALPHABET[b & UByte.MAX_VALUE]) & BASE64_MASK);
    }

    public static final String encodeBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            io.ktor.utils.io.core.StringsKt.writeText$default((Output) bytePacketBuilder, (CharSequence) str, 0, 0, (Charset) null, 14, (Object) null);
            return encodeBase64(bytePacketBuilder.build());
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static final byte[] decodeBase64Bytes(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            Output output = bytePacketBuilder;
            int lastIndex = StringsKt.getLastIndex(str);
            while (true) {
                if (-1 >= lastIndex) {
                    str2 = "";
                    break;
                }
                if (!(str.charAt(lastIndex) == '=')) {
                    str2 = str.substring(0, lastIndex + 1);
                    Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
                    break;
                }
                lastIndex--;
            }
            io.ktor.utils.io.core.StringsKt.writeText$default(output, (CharSequence) str2, 0, 0, (Charset) null, 14, (Object) null);
            return io.ktor.utils.io.core.StringsKt.readBytes(decodeBase64Bytes(bytePacketBuilder.build()));
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static final Input decodeBase64Bytes(ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            byte[] bArr = new byte[4];
            while (byteReadPacket.getRemaining() > 0) {
                int readAvailable$default = InputArraysKt.readAvailable$default((Input) byteReadPacket, bArr, 0, 0, 6, (Object) null);
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i < 4) {
                    i2 |= ((byte) (((byte) BASE64_INVERSE_ALPHABET[bArr[i] & UByte.MAX_VALUE]) & BASE64_MASK)) << ((3 - i3) * 6);
                    i++;
                    i3++;
                }
                int i4 = 2;
                int i5 = 4 - readAvailable$default;
                if (i5 <= 2) {
                    while (true) {
                        bytePacketBuilder.writeByte((byte) ((i2 >> (i4 * 8)) & 255));
                        if (i4 == i5) {
                            break;
                        }
                        i4--;
                    }
                }
            }
            return bytePacketBuilder.build();
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
