package io.ktor.util;

import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005\u001a\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b\u001a\u001d\u0010\u000b\u001a\u00020\u0005*\u00020\f2\u0006\u0010\t\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u000b\u001a\u00020\u0005*\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\f\b\u0002\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"NONCE_SIZE_IN_BYTES", "", "digits", "", "generateNonce", "", "size", "hex", "", "bytes", "s", "build", "Lio/ktor/util/Digest;", "(Lio/ktor/util/Digest;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "string", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lio/ktor/util/Digest;Ljava/lang/String;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "io/ktor/util/CryptoKt")
/* compiled from: Crypto.kt */
final /* synthetic */ class CryptoKt__CryptoKt {
    private static final char[] digits = CharsetKt.toCharArray("0123456789abcdef");

    public static final String hex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        char[] cArr = new char[(bArr.length * 2)];
        char[] cArr2 = digits;
        int i = 0;
        for (byte b : bArr) {
            byte b2 = b & UByte.MAX_VALUE;
            int i2 = i + 1;
            cArr[i] = cArr2[b2 >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return StringsKt.concatToString(cArr);
    }

    public static final byte[] hex(String str) {
        Intrinsics.checkNotNullParameter(str, "s");
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Integer.parseInt(String.valueOf(str.charAt(i2 + 1)), CharsKt.checkRadix(16)) | (Integer.parseInt(String.valueOf(str.charAt(i2)), CharsKt.checkRadix(16)) << 4));
        }
        return bArr;
    }

    @InternalAPI
    public static final Object build(Digest digest, byte[] bArr, Continuation<? super byte[]> continuation) {
        digest.plusAssign(bArr);
        return digest.build(continuation);
    }

    public static /* synthetic */ Object build$default(Digest digest, String str, Charset charset, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return CryptoKt.build(digest, str, charset, continuation);
    }

    public static final byte[] generateNonce(int i) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        while (bytePacketBuilder.getSize() < i) {
            try {
                io.ktor.utils.io.core.StringsKt.writeText$default((Output) bytePacketBuilder, (CharSequence) CryptoKt.generateNonce(), 0, 0, (Charset) null, 14, (Object) null);
            } catch (Throwable th) {
                bytePacketBuilder.release();
                throw th;
            }
        }
        return io.ktor.utils.io.core.StringsKt.readBytes(bytePacketBuilder.build(), i);
    }

    @InternalAPI
    public static final Object build(Digest digest, String str, Charset charset, Continuation<? super byte[]> continuation) {
        byte[] bArr;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            bArr = StringsKt.encodeToByteArray(str);
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            bArr = CharsetJVMKt.encodeToByteArray(newEncoder, str, 0, str.length());
        }
        digest.plusAssign(bArr);
        return digest.build(continuation);
    }
}
