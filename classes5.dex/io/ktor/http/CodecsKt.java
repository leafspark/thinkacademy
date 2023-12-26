package io.ktor.http;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.util.date.GMTDateParser;
import io.ktor.utils.io.charsets.EncodingKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0002\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002\u001a0\u0010\u0019\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002\u001a,\u0010\u001a\u001a\u00020\u000f*\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\f\b\u0002\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018\u001a6\u0010\u001b\u001a\u00020\u000f*\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\f\b\u0002\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u000f\u001a\u0014\u0010\u001d\u001a\u00020\u000f*\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u0015\u001a\f\u0010\u001f\u001a\u00020\u000f*\u00020\u000fH\u0000\u001a\n\u0010 \u001a\u00020\u000f*\u00020\u000f\u001a,\u0010!\u001a\u00020\u000f*\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00152\f\b\u0002\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018\u001a \u0010#\u001a\u00020$*\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$0'H\u0002\u001a\f\u0010(\u001a\u00020\u000f*\u00020\u0004H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"HEX_ALPHABET", "", "", "OAUTH_SYMBOLS", "", "URL_ALPHABET", "URL_ALPHABET_CHARS", "URL_PROTOCOL_PART", "VALID_PATH_PART", "charToHexDigit", "", "c2", "hexDigitToChar", "digit", "decodeImpl", "", "", "start", "end", "prefixEnd", "plusIsSpace", "", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "decodeScan", "decodeURLPart", "decodeURLQueryComponent", "encodeOAuth", "encodeURLParameter", "spaceToPlus", "encodeURLParameterValue", "encodeURLPath", "encodeURLQueryComponent", "encodeFull", "forEach", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "block", "Lkotlin/Function1;", "percentEncode", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Codecs.kt */
public final class CodecsKt {
    private static final List<Character> HEX_ALPHABET = CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', 'f'), new CharRange('A', 'F')), new CharRange('0', '9'));
    /* access modifiers changed from: private */
    public static final List<Byte> OAUTH_SYMBOLS;
    /* access modifiers changed from: private */
    public static final List<Byte> URL_ALPHABET;
    private static final List<Character> URL_ALPHABET_CHARS = CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', GMTDateParser.ZONE), new CharRange('A', 'Z')), new CharRange('0', '9'));
    /* access modifiers changed from: private */
    public static final List<Byte> URL_PROTOCOL_PART;
    private static final List<Character> VALID_PATH_PART = CollectionsKt.listOf(new Character[]{':', '@', '!', Character.valueOf(Typography.dollar), Character.valueOf(Typography.amp), '\'', '(', ')', Character.valueOf(GMTDateParser.ANY), '+', ',', ';', '=', '-', '.', '_', '~'});

    private static final int charToHexDigit(char c) {
        boolean z = true;
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        char c2 = 'A';
        if (!('A' <= c && c < 'G')) {
            c2 = 'a';
            if ('a' > c || c >= 'g') {
                z = false;
            }
            if (!z) {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    private static final char hexDigitToChar(int i) {
        boolean z = false;
        if (i >= 0 && i < 10) {
            z = true;
        }
        return (char) (z ? i + 48 : ((char) (i + 65)) - 10);
    }

    static {
        Iterable<Character> plus = CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', GMTDateParser.ZONE), new CharRange('A', 'Z')), new CharRange('0', '9'));
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
        for (Character charValue : plus) {
            arrayList.add(Byte.valueOf((byte) charValue.charValue()));
        }
        URL_ALPHABET = (List) arrayList;
        Iterable<Character> listOf = CollectionsKt.listOf(new Character[]{':', '/', '?', '#', '[', ']', '@', '!', Character.valueOf(Typography.dollar), Character.valueOf(Typography.amp), '\'', '(', ')', Character.valueOf(GMTDateParser.ANY), ',', ';', '=', '-', '.', '_', '~', '+'});
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        for (Character charValue2 : listOf) {
            arrayList2.add(Byte.valueOf((byte) charValue2.charValue()));
        }
        URL_PROTOCOL_PART = (List) arrayList2;
        Iterable<Character> listOf2 = CollectionsKt.listOf(new Character[]{'-', '.', '_', '~'});
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf2, 10));
        for (Character charValue3 : listOf2) {
            arrayList3.add(Byte.valueOf((byte) charValue3.charValue()));
        }
        OAUTH_SYMBOLS = (List) arrayList3;
    }

    public static /* synthetic */ String encodeURLQueryComponent$default(String str, boolean z, boolean z2, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            charset = Charsets.UTF_8;
        }
        return encodeURLQueryComponent(str, z, z2, charset);
    }

    public static final String encodeURLQueryComponent(String str, boolean z, boolean z2, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        StringBuilder sb = new StringBuilder();
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        forEach(EncodingKt.encode$default(newEncoder, str, 0, 0, 6, (Object) null), new CodecsKt$encodeURLQueryComponent$1$1(z2, sb, z));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String encodeURLPath(String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder();
        Charset charset = Charsets.UTF_8;
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt == '/' || URL_ALPHABET_CHARS.contains(Character.valueOf(charAt)) || VALID_PATH_PART.contains(Character.valueOf(charAt))) {
                sb.append(charAt);
                i2++;
            } else {
                if (charAt == '%' && (i = i2 + 2) < str.length()) {
                    List<Character> list = HEX_ALPHABET;
                    int i3 = i2 + 1;
                    if (list.contains(Character.valueOf(str.charAt(i3))) && list.contains(Character.valueOf(str.charAt(i)))) {
                        sb.append(charAt);
                        sb.append(str.charAt(i3));
                        sb.append(str.charAt(i));
                        i2 += 3;
                    }
                }
                int i4 = CharsKt.isSurrogate(charAt) ? 2 : 1;
                CharsetEncoder newEncoder = charset.newEncoder();
                Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
                int i5 = i4 + i2;
                forEach(EncodingKt.encode(newEncoder, str, i2, i5), new CodecsKt$encodeURLPath$1$1(sb));
                i2 = i5;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String encodeOAuth(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return encodeURLParameter$default(str, false, 1, (Object) null);
    }

    public static /* synthetic */ String encodeURLParameter$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return encodeURLParameter(str, z);
    }

    public static final String encodeURLParameter(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder();
        CharsetEncoder newEncoder = Charsets.UTF_8.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "UTF_8.newEncoder()");
        forEach(EncodingKt.encode$default(newEncoder, str, 0, 0, 6, (Object) null), new CodecsKt$encodeURLParameter$1$1(sb, z));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String encodeURLParameterValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return encodeURLParameter(str, true);
    }

    public static /* synthetic */ String decodeURLQueryComponent$default(String str, int i, int i2, boolean z, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        return decodeURLQueryComponent(str, i, i2, z, charset);
    }

    public static final String decodeURLQueryComponent(String str, int i, int i2, boolean z, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        return decodeScan(str, i, i2, z, charset);
    }

    public static /* synthetic */ String decodeURLPart$default(String str, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            charset = Charsets.UTF_8;
        }
        return decodeURLPart(str, i, i2, charset);
    }

    public static final String decodeURLPart(String str, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        return decodeScan(str, i, i2, false, charset);
    }

    private static final String decodeScan(String str, int i, int i2, boolean z, Charset charset) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (z && charAt == '+')) {
                return decodeImpl(str, i, i2, i3, z, charset);
            }
        }
        if (i == 0 && i2 == str.length()) {
            return str.toString();
        }
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    private static final String decodeImpl(CharSequence charSequence, int i, int i2, int i3, boolean z, Charset charset) {
        int i4 = i2 - i;
        if (i4 > 255) {
            i4 /= 3;
        }
        StringBuilder sb = new StringBuilder(i4);
        if (i3 > i) {
            sb.append(charSequence, i, i3);
        }
        byte[] bArr = null;
        while (i3 < i2) {
            char charAt = charSequence.charAt(i3);
            if (z && charAt == '+') {
                sb.append(' ');
            } else if (charAt == '%') {
                if (bArr == null) {
                    bArr = new byte[((i2 - i3) / 3)];
                }
                int i5 = 0;
                while (i3 < i2 && charSequence.charAt(i3) == '%') {
                    int i6 = i3 + 2;
                    if (i6 < i2) {
                        int i7 = i3 + 1;
                        int charToHexDigit = charToHexDigit(charSequence.charAt(i7));
                        int charToHexDigit2 = charToHexDigit(charSequence.charAt(i6));
                        if (charToHexDigit == -1 || charToHexDigit2 == -1) {
                            throw new URLDecodeException("Wrong HEX escape: %" + charSequence.charAt(i7) + charSequence.charAt(i6) + ", in " + charSequence + ", at " + i3);
                        }
                        bArr[i5] = (byte) ((charToHexDigit * 16) + charToHexDigit2);
                        i3 += 3;
                        i5++;
                    } else {
                        throw new URLDecodeException("Incomplete trailing HEX escape: " + charSequence.subSequence(i3, charSequence.length()).toString() + ", in " + charSequence + " at " + i3);
                    }
                }
                sb.append(new String(bArr, 0, i5, charset));
            } else {
                sb.append(charAt);
            }
            i3++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    /* access modifiers changed from: private */
    public static final String percentEncode(byte b) {
        StringBuilder sb = new StringBuilder(3);
        byte b2 = b & UByte.MAX_VALUE;
        sb.append('%');
        sb.append(hexDigitToChar(b2 >> 4));
        sb.append(hexDigitToChar(b2 & 15));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void forEach(io.ktor.utils.io.core.ByteReadPacket r6, kotlin.jvm.functions.Function1<? super java.lang.Byte, kotlin.Unit> r7) {
        /*
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r6, r0)
            if (r1 != 0) goto L_0x000a
            goto L_0x002f
        L_0x000a:
            r2 = 0
            r3 = r1
            io.ktor.utils.io.core.Buffer r3 = (io.ktor.utils.io.core.Buffer) r3     // Catch:{ all -> 0x0033 }
        L_0x000e:
            int r4 = r3.getWritePosition()     // Catch:{ all -> 0x0033 }
            int r5 = r3.getReadPosition()     // Catch:{ all -> 0x0033 }
            if (r4 <= r5) goto L_0x001a
            r4 = r0
            goto L_0x001b
        L_0x001a:
            r4 = r2
        L_0x001b:
            if (r4 == 0) goto L_0x0029
            byte r4 = r3.readByte()     // Catch:{ all -> 0x0033 }
            java.lang.Byte r4 = java.lang.Byte.valueOf(r4)     // Catch:{ all -> 0x0033 }
            r7.invoke(r4)     // Catch:{ all -> 0x0033 }
            goto L_0x000e
        L_0x0029:
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r6, r1)     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x000a
        L_0x002f:
            return
        L_0x0030:
            r7 = move-exception
            r0 = r2
            goto L_0x0034
        L_0x0033:
            r7 = move-exception
        L_0x0034:
            if (r0 == 0) goto L_0x0039
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x0039:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CodecsKt.forEach(io.ktor.utils.io.core.ByteReadPacket, kotlin.jvm.functions.Function1):void");
    }
}
