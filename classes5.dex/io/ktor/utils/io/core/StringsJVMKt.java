package io.ktor.utils.io.core;

import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\b\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0000¨\u0006\u000f"}, d2 = {"String", "", "bytes", "", "offset", "", "length", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "getCharsInternal", "", "dst", "", "dstOffset", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: StringsJVM.kt */
public final class StringsJVMKt {
    public static final String String(byte[] bArr, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        return new String(bArr, i, i2, charset);
    }

    public static /* synthetic */ String String$default(byte[] bArr, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        return new String(bArr, i, i2, charset);
    }

    public static final void getCharsInternal(String str, char[] cArr, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "dst");
        str.getChars(0, str.length(), cArr, i);
    }
}
