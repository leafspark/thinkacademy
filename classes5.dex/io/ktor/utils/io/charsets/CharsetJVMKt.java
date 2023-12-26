package io.ktor.utils.io.charsets;

import com.tekartik.sqflite.Constant;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0015\u001a\u00020\u0001*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u001b\u001a\u00020\u0001\u001a6\u0010\u001c\u001a\u00020\u0001*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u001b\u001a\u00020\u0001H\u0000\u001a\u001e\u0010!\u001a\u00020\u0012*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0001\u001a \u0010#\u001a\u00020\u0012*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0001H\u0002\u001a \u0010$\u001a\u00020\u0012*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0001H\u0002\u001a\u0018\u0010%\u001a\u00020 *\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0018\u001a\u00020\u001dH\u0000\u001a0\u0010&\u001a\u00020\u0001*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u001dH\u0000\u001a*\u0010*\u001a\u00020+*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u0001\u001a(\u0010,\u001a\u00020+*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0001H\u0002\u001a\u001e\u0010-\u001a\u00020.*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020/2\u0006\u0010\u0018\u001a\u000200\u001a\f\u00101\u001a\u00020.*\u000202H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010\u0007\u001a\u00060\bj\u0002`\t*\u00060\nj\u0002`\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001d\u0010\u0007\u001a\u00060\bj\u0002`\t*\u00060\u000ej\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0010\"\u0019\u0010\u0011\u001a\u00020\u0012*\u00060\bj\u0002`\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014*\n\u00103\"\u00020\b2\u00020\b*\n\u00104\"\u00020\n2\u00020\n*\n\u00105\"\u00020\u000e2\u00020\u000e*\n\u00106\"\u0002072\u000207¨\u00068"}, d2 = {"DECODE_CHAR_BUFFER_SIZE", "", "EmptyByteBuffer", "Ljava/nio/ByteBuffer;", "EmptyCharBuffer", "Ljava/nio/CharBuffer;", "kotlin.jvm.PlatformType", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "getCharset", "(Ljava/nio/charset/CharsetDecoder;)Ljava/nio/charset/Charset;", "Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "(Ljava/nio/charset/CharsetEncoder;)Ljava/nio/charset/Charset;", "name", "", "getName", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "decode", "input", "Lio/ktor/utils/io/core/Input;", "dst", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "max", "decodeBuffer", "Lio/ktor/utils/io/core/Buffer;", "out", "lastBuffer", "", "decodeExactBytes", "inputLength", "decodeImplByteBuffer", "decodeImplSlow", "encodeComplete", "encodeImpl", "", "fromIndex", "toIndex", "encodeToByteArray", "", "encodeToByteArraySlow", "encodeUTF8", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/core/Output;", "throwExceptionWrapped", "Ljava/nio/charset/CoderResult;", "Charset", "CharsetDecoder", "CharsetEncoder", "Charsets", "Lkotlin/text/Charsets;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CharsetJVM.kt */
public final class CharsetJVMKt {
    private static final int DECODE_CHAR_BUFFER_SIZE = 8192;
    private static final ByteBuffer EmptyByteBuffer;
    private static final CharBuffer EmptyCharBuffer = CharBuffer.allocate(0);

    public static /* synthetic */ void Charset$annotations() {
    }

    public static final String getName(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "<this>");
        String name = charset.name();
        Intrinsics.checkNotNullExpressionValue(name, "name()");
        return name;
    }

    public static final Charset getCharset(CharsetEncoder charsetEncoder) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Charset charset = charsetEncoder.charset();
        Intrinsics.checkNotNullExpressionValue(charset, "charset()");
        return charset;
    }

    public static final byte[] encodeToByteArray(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        if (!(charSequence instanceof String)) {
            return encodeToByteArraySlow(charsetEncoder, charSequence, i, i2);
        }
        if (i == 0 && i2 == charSequence.length()) {
            byte[] bytes = ((String) charSequence).getBytes(charsetEncoder.charset());
            Intrinsics.checkNotNullExpressionValue(bytes, "input as java.lang.String).getBytes(charset())");
            return bytes;
        }
        String substring = ((String) charSequence).substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes2 = substring.getBytes(charsetEncoder.charset());
        Intrinsics.checkNotNullExpressionValue(bytes2, "input.substring(fromInde…ring).getBytes(charset())");
        return bytes2;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encodeToByteArray(charsetEncoder, charSequence, i, i2);
    }

    private static final byte[] encodeToByteArraySlow(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        ByteBuffer encode = charsetEncoder.encode(CharBuffer.wrap(charSequence, i, i2));
        byte[] bArr = null;
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            byte[] array = encode.array();
            if (array.length == encode.remaining()) {
                bArr = array;
            }
        }
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[encode.remaining()];
        encode.get(bArr2);
        return bArr2;
    }

    public static final int encodeImpl(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, Buffer buffer) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        Intrinsics.checkNotNullParameter(buffer, "dst");
        CharBuffer wrap = CharBuffer.wrap(charSequence, i, i2);
        int remaining = wrap.remaining();
        ByteBuffer r6 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        ByteBuffer r62 = Memory.m50slice87lwejk(r6, writePosition, limit);
        boolean z = false;
        CoderResult encode = charsetEncoder.encode(wrap, r62, false);
        if (encode.isMalformed() || encode.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(encode, Constant.PARAM_RESULT);
            throwExceptionWrapped(encode);
        }
        if (r62.limit() == limit) {
            z = true;
        }
        if (z) {
            buffer.commitWritten(r62.position());
            return remaining - wrap.remaining();
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v50, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v55, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v56, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v57, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v58, resolved type: io.ktor.utils.io.core.internal.ChunkBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v59, resolved type: int} */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        r27.afterHeadWrite();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0210, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r27.afterHeadWrite();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0214, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
        r27.afterHeadWrite();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x028a, code lost:
        r0 = r7.position() - r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x028c, code lost:
        if (r0 < 0) goto L_0x02a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0290, code lost:
        if (r0 > r23) goto L_0x02a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0292, code lost:
        r3 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0294, code lost:
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
        r3.commitWritten(r0);
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0297, code lost:
        r3.release(io.ktor.utils.io.core.internal.ChunkBuffer.Companion.getPool());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02a0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02a1, code lost:
        r3 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
        io.ktor.utils.io.internal.jvm.ErrorsKt.wrongBufferPositionChangeError(r0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02ac, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02c2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02c3, code lost:
        r3 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f2, code lost:
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r14.discardExact(r13 - r16);
        r20 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015f, code lost:
        r14.discardExact(((r13 - r16) - r19) + 1);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void encodeUTF8(java.nio.charset.CharsetEncoder r25, io.ktor.utils.io.core.ByteReadPacket r26, io.ktor.utils.io.core.Output r27) {
        /*
            r0 = r25
            r1 = r26
            r2 = r27
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.nio.charset.Charset r3 = getCharset((java.nio.charset.CharsetEncoder) r25)
            java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8
            if (r3 != r4) goto L_0x0021
            r2.writePacket(r1)
            return
        L_0x0021:
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r3 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.pool.ObjectPool r3 = r3.getPool()
            java.lang.Object r3 = r3.borrow()
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = (io.ktor.utils.io.core.internal.ChunkBuffer) r3
            r4 = r3
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x02ea }
            int r5 = r4.getLimit()     // Catch:{ all -> 0x02ea }
            int r4 = r4.getWritePosition()     // Catch:{ all -> 0x02ea }
            int r5 = r5 - r4
            r6 = 1
            if (r5 < 0) goto L_0x003e
            r7 = r6
            goto L_0x003f
        L_0x003e:
            r7 = 0
        L_0x003f:
            if (r7 == 0) goto L_0x02c6
            java.nio.ByteBuffer r7 = r3.m184getMemorySK3TCg8()     // Catch:{ all -> 0x02ea }
            java.nio.ByteBuffer r7 = r7.duplicate()     // Catch:{ all -> 0x02ea }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x02ea }
            int r8 = r3.getWritePosition()     // Catch:{ all -> 0x02ea }
            int r9 = r3.getLimit()     // Catch:{ all -> 0x02ea }
            r7.limit(r9)     // Catch:{ all -> 0x02ea }
            r7.position(r8)     // Catch:{ all -> 0x02ea }
            java.nio.CharBuffer r9 = r7.asCharBuffer()     // Catch:{ all -> 0x02ea }
        L_0x005e:
            long r10 = r26.getRemaining()     // Catch:{ all -> 0x02ea }
            r12 = 0
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            java.lang.String r11 = "Buffer's limit change is not allowed"
            java.lang.String r12 = "cr"
            if (r10 <= 0) goto L_0x0221
            r9.clear()     // Catch:{ all -> 0x02ea }
            io.ktor.utils.io.core.internal.ChunkBuffer r10 = r1.prepareReadHead$ktor_io(r6)     // Catch:{ all -> 0x02ea }
            if (r10 != 0) goto L_0x0077
            goto L_0x0221
        L_0x0077:
            r14 = r10
            io.ktor.utils.io.core.Buffer r14 = (io.ktor.utils.io.core.Buffer) r14     // Catch:{ all -> 0x02ea }
            java.nio.ByteBuffer r15 = r14.m184getMemorySK3TCg8()     // Catch:{ all -> 0x02ea }
            int r16 = r14.getReadPosition()     // Catch:{ all -> 0x02ea }
            int r4 = r14.getWritePosition()     // Catch:{ all -> 0x02ea }
            r13 = r16
            r17 = 0
            r18 = 0
            r19 = 0
        L_0x008e:
            r20 = -1
            if (r13 >= r4) goto L_0x0181
            byte r6 = r15.get(r13)     // Catch:{ all -> 0x02ea }
            r6 = r6 & 255(0xff, float:3.57E-43)
            r21 = r15
            r15 = r6 & 128(0x80, float:1.794E-43)
            if (r15 != 0) goto L_0x00cd
            if (r17 != 0) goto L_0x00c4
            char r6 = (char) r6     // Catch:{ all -> 0x02ea }
            boolean r15 = r9.hasRemaining()     // Catch:{ all -> 0x02ea }
            if (r15 == 0) goto L_0x00ac
            r9.put(r6)     // Catch:{ all -> 0x02ea }
            r6 = 1
            goto L_0x00ad
        L_0x00ac:
            r6 = 0
        L_0x00ad:
            if (r6 != 0) goto L_0x00bc
            int r13 = r13 - r16
            r14.discardExact(r13)     // Catch:{ all -> 0x02ea }
            r22 = r3
            r23 = r5
            r24 = r8
            goto L_0x018e
        L_0x00bc:
            r22 = r3
            r23 = r5
            r24 = r8
            goto L_0x0174
        L_0x00c4:
            io.ktor.utils.io.core.internal.UTF8Kt.malformedByteCount(r17)     // Catch:{ all -> 0x02ea }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x02ea }
            r0.<init>()     // Catch:{ all -> 0x02ea }
            throw r0     // Catch:{ all -> 0x02ea }
        L_0x00cd:
            if (r17 != 0) goto L_0x0101
            r15 = 128(0x80, float:1.794E-43)
            r22 = r3
            r23 = r5
            r24 = r8
            r3 = r17
            r5 = 1
        L_0x00da:
            r8 = 7
            if (r5 >= r8) goto L_0x00ea
            r8 = r6 & r15
            if (r8 == 0) goto L_0x00ea
            int r8 = ~r15
            r6 = r6 & r8
            int r15 = r15 >> 1
            int r3 = r3 + 1
            int r5 = r5 + 1
            goto L_0x00da
        L_0x00ea:
            int r5 = r3 + -1
            int r8 = r4 - r13
            if (r3 <= r8) goto L_0x00f9
            int r13 = r13 - r16
            r14.discardExact(r13)     // Catch:{ all -> 0x02c2 }
            r20 = r3
            goto L_0x018e
        L_0x00f9:
            r19 = r3
            r17 = r5
            r18 = r6
            goto L_0x0174
        L_0x0101:
            r22 = r3
            r23 = r5
            r24 = r8
            int r3 = r18 << 6
            r5 = r6 & 127(0x7f, float:1.78E-43)
            r3 = r3 | r5
            int r17 = r17 + -1
            if (r17 != 0) goto L_0x0172
            boolean r5 = io.ktor.utils.io.core.internal.UTF8Kt.isBmpCodePoint(r3)     // Catch:{ all -> 0x02c2 }
            if (r5 == 0) goto L_0x012f
            char r3 = (char) r3     // Catch:{ all -> 0x02c2 }
            boolean r5 = r9.hasRemaining()     // Catch:{ all -> 0x02c2 }
            if (r5 == 0) goto L_0x0122
            r9.put(r3)     // Catch:{ all -> 0x02c2 }
            r3 = 1
            goto L_0x0123
        L_0x0122:
            r3 = 0
        L_0x0123:
            if (r3 != 0) goto L_0x015c
            int r13 = r13 - r16
            int r13 = r13 - r19
            r3 = 1
            int r13 = r13 + r3
            r14.discardExact(r13)     // Catch:{ all -> 0x02c2 }
            goto L_0x018e
        L_0x012f:
            boolean r5 = io.ktor.utils.io.core.internal.UTF8Kt.isValidCodePoint(r3)     // Catch:{ all -> 0x02c2 }
            if (r5 == 0) goto L_0x0169
            int r5 = io.ktor.utils.io.core.internal.UTF8Kt.highSurrogate(r3)     // Catch:{ all -> 0x02c2 }
            char r5 = (char) r5     // Catch:{ all -> 0x02c2 }
            boolean r6 = r9.hasRemaining()     // Catch:{ all -> 0x02c2 }
            if (r6 == 0) goto L_0x0145
            r9.put(r5)     // Catch:{ all -> 0x02c2 }
            r5 = 1
            goto L_0x0146
        L_0x0145:
            r5 = 0
        L_0x0146:
            if (r5 == 0) goto L_0x015f
            int r3 = io.ktor.utils.io.core.internal.UTF8Kt.lowSurrogate(r3)     // Catch:{ all -> 0x02c2 }
            char r3 = (char) r3     // Catch:{ all -> 0x02c2 }
            boolean r5 = r9.hasRemaining()     // Catch:{ all -> 0x02c2 }
            if (r5 == 0) goto L_0x0158
            r9.put(r3)     // Catch:{ all -> 0x02c2 }
            r3 = 1
            goto L_0x0159
        L_0x0158:
            r3 = 0
        L_0x0159:
            if (r3 != 0) goto L_0x015c
            goto L_0x015f
        L_0x015c:
            r18 = 0
            goto L_0x0174
        L_0x015f:
            int r13 = r13 - r16
            int r13 = r13 - r19
            r3 = 1
            int r13 = r13 + r3
            r14.discardExact(r13)     // Catch:{ all -> 0x02c2 }
            goto L_0x018e
        L_0x0169:
            io.ktor.utils.io.core.internal.UTF8Kt.malformedCodePoint(r3)     // Catch:{ all -> 0x02c2 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x02c2 }
            r0.<init>()     // Catch:{ all -> 0x02c2 }
            throw r0     // Catch:{ all -> 0x02c2 }
        L_0x0172:
            r18 = r3
        L_0x0174:
            int r13 = r13 + 1
            r15 = r21
            r3 = r22
            r5 = r23
            r8 = r24
            r6 = 1
            goto L_0x008e
        L_0x0181:
            r22 = r3
            r23 = r5
            r24 = r8
            int r4 = r4 - r16
            r14.discardExact(r4)     // Catch:{ all -> 0x02c2 }
            r20 = 0
        L_0x018e:
            int r3 = r10.getReadPosition()     // Catch:{ all -> 0x02c2 }
            r1.setHeadPosition(r3)     // Catch:{ all -> 0x02c2 }
            r9.flip()     // Catch:{ all -> 0x02c2 }
            boolean r3 = r9.hasRemaining()     // Catch:{ all -> 0x02c2 }
            if (r3 == 0) goto L_0x0215
            r3 = 0
            r4 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r2, r4, r3)     // Catch:{ all -> 0x02c2 }
            r3 = 1
        L_0x01a5:
            r4 = r5
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0210 }
            java.nio.ByteBuffer r6 = r4.m184getMemorySK3TCg8()     // Catch:{ all -> 0x0210 }
            int r8 = r4.getWritePosition()     // Catch:{ all -> 0x0210 }
            int r10 = r4.getLimit()     // Catch:{ all -> 0x0210 }
            int r10 = r10 - r8
            java.nio.ByteBuffer r6 = io.ktor.utils.io.bits.Memory.m50slice87lwejk((java.nio.ByteBuffer) r6, (int) r8, (int) r10)     // Catch:{ all -> 0x0210 }
            r8 = 0
            java.nio.charset.CoderResult r13 = r0.encode(r9, r6, r8)     // Catch:{ all -> 0x0210 }
            boolean r8 = r13.isUnmappable()     // Catch:{ all -> 0x0210 }
            if (r8 != 0) goto L_0x01ca
            boolean r8 = r13.isMalformed()     // Catch:{ all -> 0x0210 }
            if (r8 == 0) goto L_0x01d0
        L_0x01ca:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r12)     // Catch:{ all -> 0x0210 }
            throwExceptionWrapped(r13)     // Catch:{ all -> 0x0210 }
        L_0x01d0:
            boolean r8 = r13.isOverflow()     // Catch:{ all -> 0x0210 }
            if (r8 == 0) goto L_0x01df
            boolean r8 = r6.hasRemaining()     // Catch:{ all -> 0x0210 }
            if (r8 == 0) goto L_0x01df
            r8 = 1
            int r3 = r3 + r8
            goto L_0x01e0
        L_0x01df:
            r3 = 1
        L_0x01e0:
            int r8 = r6.limit()     // Catch:{ all -> 0x0210 }
            if (r8 != r10) goto L_0x01e8
            r8 = 1
            goto L_0x01e9
        L_0x01e8:
            r8 = 0
        L_0x01e9:
            if (r8 == 0) goto L_0x0206
            int r6 = r6.position()     // Catch:{ all -> 0x0210 }
            r4.commitWritten(r6)     // Catch:{ all -> 0x0210 }
            boolean r4 = r9.hasRemaining()     // Catch:{ all -> 0x0210 }
            if (r4 == 0) goto L_0x01fa
            r4 = r3
            goto L_0x01fb
        L_0x01fa:
            r4 = 0
        L_0x01fb:
            if (r4 <= 0) goto L_0x0202
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r2, r4, r5)     // Catch:{ all -> 0x0210 }
            goto L_0x01a5
        L_0x0202:
            r27.afterHeadWrite()     // Catch:{ all -> 0x02c2 }
            goto L_0x0215
        L_0x0206:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0210 }
            java.lang.String r1 = r11.toString()     // Catch:{ all -> 0x0210 }
            r0.<init>(r1)     // Catch:{ all -> 0x0210 }
            throw r0     // Catch:{ all -> 0x0210 }
        L_0x0210:
            r0 = move-exception
            r27.afterHeadWrite()     // Catch:{ all -> 0x02c2 }
            throw r0     // Catch:{ all -> 0x02c2 }
        L_0x0215:
            if (r20 <= 0) goto L_0x0218
            goto L_0x0227
        L_0x0218:
            r3 = r22
            r5 = r23
            r8 = r24
            r6 = 1
            goto L_0x005e
        L_0x0221:
            r22 = r3
            r23 = r5
            r24 = r8
        L_0x0227:
            r9.clear()     // Catch:{ all -> 0x02c2 }
            r9.flip()     // Catch:{ all -> 0x02c2 }
            r1 = 0
            r3 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r2, r3, r1)     // Catch:{ all -> 0x02c2 }
            r3 = 1
        L_0x0234:
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x02bb }
            java.nio.ByteBuffer r5 = r4.m184getMemorySK3TCg8()     // Catch:{ all -> 0x02bb }
            int r6 = r4.getWritePosition()     // Catch:{ all -> 0x02bb }
            int r8 = r4.getLimit()     // Catch:{ all -> 0x02bb }
            int r8 = r8 - r6
            java.nio.ByteBuffer r5 = io.ktor.utils.io.bits.Memory.m50slice87lwejk((java.nio.ByteBuffer) r5, (int) r6, (int) r8)     // Catch:{ all -> 0x02bb }
            r6 = 1
            java.nio.charset.CoderResult r10 = r0.encode(r9, r5, r6)     // Catch:{ all -> 0x02bb }
            boolean r6 = r10.isMalformed()     // Catch:{ all -> 0x02bb }
            if (r6 != 0) goto L_0x0259
            boolean r6 = r10.isUnmappable()     // Catch:{ all -> 0x02bb }
            if (r6 == 0) goto L_0x025f
        L_0x0259:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)     // Catch:{ all -> 0x02bb }
            throwExceptionWrapped(r10)     // Catch:{ all -> 0x02bb }
        L_0x025f:
            boolean r6 = r10.isOverflow()     // Catch:{ all -> 0x02bb }
            if (r6 == 0) goto L_0x0268
            r6 = 1
            int r3 = r3 + r6
            goto L_0x026a
        L_0x0268:
            r6 = 1
            r3 = 0
        L_0x026a:
            int r10 = r5.limit()     // Catch:{ all -> 0x02bb }
            if (r10 != r8) goto L_0x0272
            r8 = r6
            goto L_0x0273
        L_0x0272:
            r8 = 0
        L_0x0273:
            if (r8 == 0) goto L_0x02ad
            int r5 = r5.position()     // Catch:{ all -> 0x02bb }
            r4.commitWritten(r5)     // Catch:{ all -> 0x02bb }
            if (r3 <= 0) goto L_0x0283
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r2, r3, r1)     // Catch:{ all -> 0x02bb }
            goto L_0x0234
        L_0x0283:
            r27.afterHeadWrite()     // Catch:{ all -> 0x02c2 }
            int r0 = r7.position()     // Catch:{ all -> 0x02c2 }
            int r0 = r0 - r24
            if (r0 < 0) goto L_0x02a1
            r5 = r23
            if (r0 > r5) goto L_0x02a1
            r3 = r22
            r3.commitWritten(r0)     // Catch:{ all -> 0x02ea }
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r0 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.pool.ObjectPool r0 = r0.getPool()
            r3.release(r0)
            return
        L_0x02a1:
            r3 = r22
            r1 = 0
            io.ktor.utils.io.internal.jvm.ErrorsKt.wrongBufferPositionChangeError(r0, r1)     // Catch:{ all -> 0x02ea }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x02ea }
            r0.<init>()     // Catch:{ all -> 0x02ea }
            throw r0     // Catch:{ all -> 0x02ea }
        L_0x02ad:
            r3 = r22
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x02b9 }
            java.lang.String r1 = r11.toString()     // Catch:{ all -> 0x02b9 }
            r0.<init>(r1)     // Catch:{ all -> 0x02b9 }
            throw r0     // Catch:{ all -> 0x02b9 }
        L_0x02b9:
            r0 = move-exception
            goto L_0x02be
        L_0x02bb:
            r0 = move-exception
            r3 = r22
        L_0x02be:
            r27.afterHeadWrite()     // Catch:{ all -> 0x02ea }
            throw r0     // Catch:{ all -> 0x02ea }
        L_0x02c2:
            r0 = move-exception
            r3 = r22
            goto L_0x02eb
        L_0x02c6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ea }
            r0.<init>()     // Catch:{ all -> 0x02ea }
            java.lang.String r1 = "size "
            r0.append(r1)     // Catch:{ all -> 0x02ea }
            r1 = 0
            r0.append(r1)     // Catch:{ all -> 0x02ea }
            java.lang.String r1 = " is greater than buffer's remaining capacity "
            r0.append(r1)     // Catch:{ all -> 0x02ea }
            r0.append(r5)     // Catch:{ all -> 0x02ea }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02ea }
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x02ea }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02ea }
            r1.<init>(r0)     // Catch:{ all -> 0x02ea }
            throw r1     // Catch:{ all -> 0x02ea }
        L_0x02ea:
            r0 = move-exception
        L_0x02eb:
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r1 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.pool.ObjectPool r1 = r1.getPool()
            r3.release(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.CharsetJVMKt.encodeUTF8(java.nio.charset.CharsetEncoder, io.ktor.utils.io.core.ByteReadPacket, io.ktor.utils.io.core.Output):void");
    }

    public static /* synthetic */ int decodeBuffer$default(CharsetDecoder charsetDecoder, Buffer buffer, Appendable appendable, boolean z, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = Integer.MAX_VALUE;
        }
        return decodeBuffer(charsetDecoder, buffer, appendable, z, i);
    }

    public static final Charset getCharset(CharsetDecoder charsetDecoder) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Charset charset = charsetDecoder.charset();
        Intrinsics.checkNotNull(charset);
        return charset;
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int decode(java.nio.charset.CharsetDecoder r12, io.ktor.utils.io.core.Input r13, java.lang.Appendable r14, int r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 8192(0x2000, float:1.14794E-41)
            java.nio.CharBuffer r1 = java.nio.CharBuffer.allocate(r0)
            r2 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r13, r2)
            r4 = 0
            if (r3 != 0) goto L_0x001f
            goto L_0x00f3
        L_0x001f:
            r5 = r2
            r7 = r5
            r6 = r4
        L_0x0022:
            r8 = r3
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.io.core.Buffer) r8     // Catch:{ all -> 0x0131 }
            int r9 = r8.getWritePosition()     // Catch:{ all -> 0x0131 }
            int r8 = r8.getReadPosition()     // Catch:{ all -> 0x0131 }
            int r9 = r9 - r8
            if (r9 < r5) goto L_0x00bf
            r5 = r3
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x00b4 }
            int r8 = r15 - r6
            if (r8 != 0) goto L_0x0039
            r5 = r4
            goto L_0x009b
        L_0x0039:
            java.nio.ByteBuffer r9 = r5.m184getMemorySK3TCg8()     // Catch:{ all -> 0x00b4 }
            int r10 = r5.getReadPosition()     // Catch:{ all -> 0x00b4 }
            int r11 = r5.getWritePosition()     // Catch:{ all -> 0x00b4 }
            int r11 = r11 - r10
            java.nio.ByteBuffer r9 = io.ktor.utils.io.bits.Memory.m50slice87lwejk((java.nio.ByteBuffer) r9, (int) r10, (int) r11)     // Catch:{ all -> 0x00b4 }
            r1.clear()     // Catch:{ all -> 0x00b4 }
            if (r8 >= r0) goto L_0x0052
            r1.limit(r8)     // Catch:{ all -> 0x00b4 }
        L_0x0052:
            java.nio.charset.CoderResult r8 = r12.decode(r9, r1, r4)     // Catch:{ all -> 0x00b4 }
            r1.flip()     // Catch:{ all -> 0x00b4 }
            int r10 = r1.remaining()     // Catch:{ all -> 0x00b4 }
            int r6 = r6 + r10
            r10 = r1
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x00b4 }
            r14.append(r10)     // Catch:{ all -> 0x00b4 }
            boolean r10 = r8.isMalformed()     // Catch:{ all -> 0x00b4 }
            if (r10 != 0) goto L_0x0070
            boolean r10 = r8.isUnmappable()     // Catch:{ all -> 0x00b4 }
            if (r10 == 0) goto L_0x0078
        L_0x0070:
            java.lang.String r10 = "rc"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)     // Catch:{ all -> 0x00b4 }
            throwExceptionWrapped(r8)     // Catch:{ all -> 0x00b4 }
        L_0x0078:
            boolean r8 = r8.isUnderflow()     // Catch:{ all -> 0x00b4 }
            if (r8 == 0) goto L_0x0087
            boolean r8 = r9.hasRemaining()     // Catch:{ all -> 0x00b4 }
            if (r8 == 0) goto L_0x0087
            int r7 = r7 + 1
            goto L_0x0088
        L_0x0087:
            r7 = r2
        L_0x0088:
            int r8 = r9.limit()     // Catch:{ all -> 0x00b4 }
            if (r8 != r11) goto L_0x0090
            r8 = r2
            goto L_0x0091
        L_0x0090:
            r8 = r4
        L_0x0091:
            if (r8 == 0) goto L_0x00a8
            int r8 = r9.position()     // Catch:{ all -> 0x00b4 }
            r5.discardExact(r8)     // Catch:{ all -> 0x00b4 }
            r5 = r7
        L_0x009b:
            r8 = r3
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.io.core.Buffer) r8     // Catch:{ all -> 0x0131 }
            int r9 = r8.getWritePosition()     // Catch:{ all -> 0x0131 }
            int r8 = r8.getReadPosition()     // Catch:{ all -> 0x0131 }
            int r9 = r9 - r8
            goto L_0x00bf
        L_0x00a8:
            java.lang.String r12 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b4 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00b4 }
            r14.<init>(r12)     // Catch:{ all -> 0x00b4 }
            throw r14     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            r12 = move-exception
            r14 = r3
            io.ktor.utils.io.core.Buffer r14 = (io.ktor.utils.io.core.Buffer) r14     // Catch:{ all -> 0x0131 }
            r14.getWritePosition()     // Catch:{ all -> 0x0131 }
            r14.getReadPosition()     // Catch:{ all -> 0x0131 }
            throw r12     // Catch:{ all -> 0x0131 }
        L_0x00bf:
            if (r9 != 0) goto L_0x00ca
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r13, r3)     // Catch:{ all -> 0x00c6 }
            goto L_0x00e6
        L_0x00c6:
            r12 = move-exception
            r2 = r4
            goto L_0x0132
        L_0x00ca:
            if (r9 < r5) goto L_0x00df
            r8 = r3
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.io.core.Buffer) r8     // Catch:{ all -> 0x00c6 }
            int r9 = r8.getCapacity()     // Catch:{ all -> 0x00c6 }
            int r8 = r8.getLimit()     // Catch:{ all -> 0x00c6 }
            int r9 = r9 - r8
            r8 = 8
            if (r9 >= r8) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            r8 = r3
            goto L_0x00e6
        L_0x00df:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r13, r3)     // Catch:{ all -> 0x00c6 }
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r13, r5)     // Catch:{ all -> 0x00c6 }
        L_0x00e6:
            if (r8 != 0) goto L_0x00e9
            goto L_0x00ed
        L_0x00e9:
            if (r5 > 0) goto L_0x012e
            r4 = r2
            r3 = r8
        L_0x00ed:
            if (r4 == 0) goto L_0x00f2
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r13, r3)
        L_0x00f2:
            r4 = r6
        L_0x00f3:
            r1.clear()
            int r13 = r15 - r4
            if (r13 == 0) goto L_0x012d
            if (r13 >= r0) goto L_0x00ff
            r1.limit(r13)
        L_0x00ff:
            java.nio.ByteBuffer r13 = EmptyByteBuffer
            java.nio.charset.CoderResult r13 = r12.decode(r13, r1, r2)
            r1.flip()
            int r3 = r1.remaining()
            int r4 = r4 + r3
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.append(r3)
            boolean r3 = r13.isUnmappable()
            if (r3 != 0) goto L_0x011f
            boolean r3 = r13.isMalformed()
            if (r3 == 0) goto L_0x0127
        L_0x011f:
            java.lang.String r3 = "cr"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)
            throwExceptionWrapped(r13)
        L_0x0127:
            boolean r13 = r13.isOverflow()
            if (r13 != 0) goto L_0x00f3
        L_0x012d:
            return r4
        L_0x012e:
            r3 = r8
            goto L_0x0022
        L_0x0131:
            r12 = move-exception
        L_0x0132:
            if (r2 == 0) goto L_0x0137
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r13, r3)
        L_0x0137:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.CharsetJVMKt.decode(java.nio.charset.CharsetDecoder, io.ktor.utils.io.core.Input, java.lang.Appendable, int):int");
    }

    private static final String decodeImplByteBuffer(CharsetDecoder charsetDecoder, Input input, int i) {
        CharBuffer allocate = CharBuffer.allocate(i);
        ByteBuffer r5 = Memory.m50slice87lwejk(input.m224getHeadMemorySK3TCg8(), input.getHead().getReadPosition(), i);
        CoderResult decode = charsetDecoder.decode(r5, allocate, true);
        if (decode.isMalformed() || decode.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(decode, "rc");
            throwExceptionWrapped(decode);
        }
        allocate.flip();
        input.discardExact(r5.position());
        String charBuffer = allocate.toString();
        Intrinsics.checkNotNullExpressionValue(charBuffer, "cb.toString()");
        return charBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String decodeImplSlow(java.nio.charset.CharsetDecoder r17, io.ktor.utils.io.core.Input r18, int r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.nio.CharBuffer r3 = java.nio.CharBuffer.allocate(r19)
            r4 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r4)
            java.lang.String r6 = "rc"
            if (r5 != 0) goto L_0x0017
            r9 = r2
            r7 = 0
            goto L_0x00fc
        L_0x0017:
            r9 = r2
            r8 = r4
            r11 = r8
            r10 = 0
        L_0x001b:
            r12 = r5
            io.ktor.utils.io.core.Buffer r12 = (io.ktor.utils.io.core.Buffer) r12     // Catch:{ all -> 0x0156 }
            int r13 = r12.getWritePosition()     // Catch:{ all -> 0x0156 }
            int r12 = r12.getReadPosition()     // Catch:{ all -> 0x0156 }
            int r13 = r13 - r12
            if (r13 < r8) goto L_0x00c7
            r8 = r5
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.io.core.Buffer) r8     // Catch:{ all -> 0x00bc }
            boolean r12 = r3.hasRemaining()     // Catch:{ all -> 0x00bc }
            if (r12 == 0) goto L_0x00ad
            if (r9 != 0) goto L_0x0036
            goto L_0x00ad
        L_0x0036:
            java.nio.ByteBuffer r10 = r8.m184getMemorySK3TCg8()     // Catch:{ all -> 0x00bc }
            int r12 = r8.getReadPosition()     // Catch:{ all -> 0x00bc }
            int r13 = r8.getWritePosition()     // Catch:{ all -> 0x00bc }
            int r13 = r13 - r12
            java.nio.ByteBuffer r10 = io.ktor.utils.io.bits.Memory.m50slice87lwejk((java.nio.ByteBuffer) r10, (int) r12, (int) r13)     // Catch:{ all -> 0x00bc }
            int r12 = r10.limit()     // Catch:{ all -> 0x00bc }
            int r14 = r10.position()     // Catch:{ all -> 0x00bc }
            int r15 = r12 - r14
            if (r15 < r9) goto L_0x0055
            r15 = r4
            goto L_0x0056
        L_0x0055:
            r15 = 0
        L_0x0056:
            if (r15 == 0) goto L_0x005d
            int r7 = r14 + r9
            r10.limit(r7)     // Catch:{ all -> 0x00bc }
        L_0x005d:
            java.nio.charset.CoderResult r7 = r0.decode(r10, r3, r15)     // Catch:{ all -> 0x00bc }
            boolean r16 = r7.isMalformed()     // Catch:{ all -> 0x00bc }
            if (r16 != 0) goto L_0x006d
            boolean r16 = r7.isUnmappable()     // Catch:{ all -> 0x00bc }
            if (r16 == 0) goto L_0x0073
        L_0x006d:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)     // Catch:{ all -> 0x00bc }
            throwExceptionWrapped(r7)     // Catch:{ all -> 0x00bc }
        L_0x0073:
            boolean r7 = r7.isUnderflow()     // Catch:{ all -> 0x00bc }
            if (r7 == 0) goto L_0x0082
            boolean r7 = r10.hasRemaining()     // Catch:{ all -> 0x00bc }
            if (r7 == 0) goto L_0x0082
            int r11 = r11 + 1
            goto L_0x0083
        L_0x0082:
            r11 = r4
        L_0x0083:
            r10.limit(r12)     // Catch:{ all -> 0x00bc }
            int r7 = r10.position()     // Catch:{ all -> 0x00bc }
            int r7 = r7 - r14
            int r9 = r9 - r7
            int r7 = r10.limit()     // Catch:{ all -> 0x00bc }
            if (r7 != r13) goto L_0x0094
            r7 = r4
            goto L_0x0095
        L_0x0094:
            r7 = 0
        L_0x0095:
            if (r7 == 0) goto L_0x00a1
            int r7 = r10.position()     // Catch:{ all -> 0x00bc }
            r8.discardExact(r7)     // Catch:{ all -> 0x00bc }
            r8 = r11
            r10 = r15
            goto L_0x00ae
        L_0x00a1:
            java.lang.String r0 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00bc }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00bc }
            r2.<init>(r0)     // Catch:{ all -> 0x00bc }
            throw r2     // Catch:{ all -> 0x00bc }
        L_0x00ad:
            r8 = 0
        L_0x00ae:
            r7 = r5
            io.ktor.utils.io.core.Buffer r7 = (io.ktor.utils.io.core.Buffer) r7     // Catch:{ all -> 0x0156 }
            int r12 = r7.getWritePosition()     // Catch:{ all -> 0x0156 }
            int r7 = r7.getReadPosition()     // Catch:{ all -> 0x0156 }
            int r13 = r12 - r7
            goto L_0x00c7
        L_0x00bc:
            r0 = move-exception
            r2 = r5
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x0156 }
            r2.getWritePosition()     // Catch:{ all -> 0x0156 }
            r2.getReadPosition()     // Catch:{ all -> 0x0156 }
            throw r0     // Catch:{ all -> 0x0156 }
        L_0x00c7:
            if (r13 != 0) goto L_0x00d2
            io.ktor.utils.io.core.internal.ChunkBuffer r7 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r5)     // Catch:{ all -> 0x00ce }
            goto L_0x00ee
        L_0x00ce:
            r0 = move-exception
            r4 = 0
            goto L_0x0157
        L_0x00d2:
            if (r13 < r8) goto L_0x00e7
            r7 = r5
            io.ktor.utils.io.core.Buffer r7 = (io.ktor.utils.io.core.Buffer) r7     // Catch:{ all -> 0x00ce }
            int r12 = r7.getCapacity()     // Catch:{ all -> 0x00ce }
            int r7 = r7.getLimit()     // Catch:{ all -> 0x00ce }
            int r12 = r12 - r7
            r7 = 8
            if (r12 >= r7) goto L_0x00e5
            goto L_0x00e7
        L_0x00e5:
            r7 = r5
            goto L_0x00ee
        L_0x00e7:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)     // Catch:{ all -> 0x00ce }
            io.ktor.utils.io.core.internal.ChunkBuffer r7 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r8)     // Catch:{ all -> 0x00ce }
        L_0x00ee:
            if (r7 != 0) goto L_0x00f2
            r7 = 0
            goto L_0x00f6
        L_0x00f2:
            r5 = r7
            if (r8 > 0) goto L_0x001b
            r7 = r4
        L_0x00f6:
            if (r7 == 0) goto L_0x00fb
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        L_0x00fb:
            r7 = r10
        L_0x00fc:
            boolean r1 = r3.hasRemaining()
            if (r1 == 0) goto L_0x011c
            if (r7 != 0) goto L_0x011c
            java.nio.ByteBuffer r1 = EmptyByteBuffer
            java.nio.charset.CoderResult r0 = r0.decode(r1, r3, r4)
            boolean r1 = r0.isMalformed()
            if (r1 != 0) goto L_0x0116
            boolean r1 = r0.isUnmappable()
            if (r1 == 0) goto L_0x011c
        L_0x0116:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            throwExceptionWrapped(r0)
        L_0x011c:
            if (r9 > 0) goto L_0x0135
            if (r9 < 0) goto L_0x012d
            r3.flip()
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "cb.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        L_0x012d:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "remainingInputBytes < 0"
            r0.<init>(r1)
            throw r0
        L_0x0135:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Not enough bytes available: had only "
            r1.append(r3)
            int r3 = r2 - r9
            r1.append(r3)
            java.lang.String r3 = " instead of "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0156:
            r0 = move-exception
        L_0x0157:
            if (r4 == 0) goto L_0x015c
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        L_0x015c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.CharsetJVMKt.decodeImplSlow(java.nio.charset.CharsetDecoder, io.ktor.utils.io.core.Input, int):java.lang.String");
    }

    private static final void throwExceptionWrapped(CoderResult coderResult) {
        try {
            coderResult.throwException();
        } catch (MalformedInputException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new MalformedInputException(message);
        }
    }

    static {
        ByteBuffer allocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNull(allocate);
        EmptyByteBuffer = allocate;
    }

    public static final boolean encodeComplete(CharsetEncoder charsetEncoder, Buffer buffer) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "dst");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        ByteBuffer r02 = Memory.m50slice87lwejk(r0, writePosition, limit);
        boolean z = true;
        CoderResult encode = charsetEncoder.encode(EmptyCharBuffer, r02, true);
        if (encode.isMalformed() || encode.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(encode, Constant.PARAM_RESULT);
            throwExceptionWrapped(encode);
        }
        boolean isUnderflow = encode.isUnderflow();
        if (r02.limit() != limit) {
            z = false;
        }
        if (z) {
            buffer.commitWritten(r02.position());
            return isUnderflow;
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }

    /* JADX INFO: finally extract failed */
    public static final int decodeBuffer(CharsetDecoder charsetDecoder, Buffer buffer, Appendable appendable, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "input");
        Intrinsics.checkNotNullParameter(appendable, "out");
        ByteBuffer r10 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition() - readPosition;
        ByteBuffer r102 = Memory.m50slice87lwejk(r10, readPosition, writePosition);
        ChunkBuffer borrow = ChunkBuffer.Companion.getPool().borrow();
        CharBuffer asCharBuffer = borrow.m184getMemorySK3TCg8().asCharBuffer();
        boolean z2 = false;
        int i2 = 0;
        while (r102.hasRemaining() && i2 < i) {
            try {
                int min = Math.min(asCharBuffer.capacity(), i - i2);
                asCharBuffer.clear();
                asCharBuffer.limit(min);
                CoderResult decode = charsetDecoder.decode(r102, asCharBuffer, z);
                if (decode.isMalformed() || decode.isUnmappable()) {
                    Intrinsics.checkNotNullExpressionValue(decode, Constant.PARAM_RESULT);
                    throwExceptionWrapped(decode);
                }
                i2 += min;
            } catch (Throwable th) {
                borrow.release(ChunkBuffer.Companion.getPool());
                throw th;
            }
        }
        borrow.release(ChunkBuffer.Companion.getPool());
        if (r102.limit() == writePosition) {
            z2 = true;
        }
        if (z2) {
            buffer.discardExact(r102.position());
            return i2;
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }

    public static final String decodeExactBytes(CharsetDecoder charsetDecoder, Input input, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (i == 0) {
            return "";
        }
        if (input.getHeadEndExclusive() - input.getHeadPosition() < i) {
            return decodeImplSlow(charsetDecoder, input, i);
        }
        if (!input.m224getHeadMemorySK3TCg8().hasArray()) {
            return decodeImplByteBuffer(charsetDecoder, input, i);
        }
        ByteBuffer r0 = input.m224getHeadMemorySK3TCg8();
        byte[] array = r0.array();
        Intrinsics.checkNotNullExpressionValue(array, "bb.array()");
        Charset charset = charsetDecoder.charset();
        Intrinsics.checkNotNullExpressionValue(charset, "charset()");
        String str = new String(array, r0.arrayOffset() + r0.position() + input.getHead().getReadPosition(), i, charset);
        input.discardExact(i);
        return str;
    }
}
