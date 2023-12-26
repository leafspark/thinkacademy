package io.ktor.utils.io.core.internal;

import com.wushuangtech.library.GlobalVideoConfig;
import io.agora.rtc.Constants;
import io.ktor.utils.io.core.Buffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0014\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0011\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\b\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000\u001a_\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u0013\u001a\u00020\u00012$\u0010\u0014\u001a \b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001b0\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0001H\u0001\u001a\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0001\u001a\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0001H\u0001\u001a\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0001H\u0002\u001a$\u0010)\u001a\u00020\u000f*\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u001aH\bø\u0001\u0001\u001a$\u0010,\u001a\u00020\u0001*\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u001aH\bø\u0001\u0001\u001aA\u0010-\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b6\u00107\u001aQ\u00108\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0001H\u0002ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b=\u0010>\u001aQ\u0010?\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0001H\u0002ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b@\u0010>\u001a*\u0010A\u001a\u00020\u0001*\u00020/2\u0006\u0010B\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\bø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\bC\u0010D\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0012\n\u0002\b\u0019\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"HighSurrogateMagic", "", "MaxCodePoint", "MinHighSurrogate", "MinLowSurrogate", "MinSupplementary", "byteCountUtf8", "firstByte", "charactersSize", "v", "codePoint", "high", "", "low", "decodeUTF8LineLoopSuspend", "", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "limit", "nextChunk", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lio/ktor/utils/io/core/Input;", "", "afterRead", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "highSurrogate", "cp", "isBmpCodePoint", "isValidCodePoint", "lowSurrogate", "malformedByteCount", "", "byteCount", "malformedCodePoint", "value", "prematureEndOfStreamUtf", "size", "decodeASCII", "Lio/ktor/utils/io/core/Buffer;", "consumer", "decodeUTF8", "encodeUTF8", "Lio/ktor/utils/io/core/internal/EncodeResult;", "Lio/ktor/utils/io/bits/Memory;", "text", "", "from", "to", "dstOffset", "dstLimit", "encodeUTF8-lBXzO7A", "(Ljava/nio/ByteBuffer;Ljava/lang/CharSequence;IIII)I", "encodeUTF8Stage1", "index1", "lastCharIndex", "resultPosition1", "resultLimit", "encodeUTF8Stage1-Vm9B2pQ", "(Ljava/nio/ByteBuffer;Ljava/lang/CharSequence;IIIIII)I", "encodeUTF8Stage2", "encodeUTF8Stage2-Vm9B2pQ", "putUtf8Char", "offset", "putUtf8Char-62zg_DM", "(Ljava/nio/ByteBuffer;II)I", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UTF8.kt */
public final class UTF8Kt {
    private static final int HighSurrogateMagic = 55232;
    private static final int MaxCodePoint = 1114111;
    private static final int MinHighSurrogate = 55296;
    private static final int MinLowSurrogate = 56320;
    private static final int MinSupplementary = 65536;

    public static final int byteCountUtf8(int i) {
        int i2 = 0;
        int i3 = Constants.ERR_WATERMARK_ARGB;
        for (int i4 = 1; i4 < 7 && (i & i3) != 0; i4++) {
            i &= ~i3;
            i3 >>= 1;
            i2++;
        }
        return i2;
    }

    public static final int codePoint(char c, char c2) {
        return ((c - HighSurrogateMagic) << 10) | (c2 - MinLowSurrogate);
    }

    public static final int highSurrogate(int i) {
        return (i >>> 10) + HighSurrogateMagic;
    }

    public static final boolean isBmpCodePoint(int i) {
        return (i >>> 16) == 0;
    }

    public static final boolean isValidCodePoint(int i) {
        return i <= MaxCodePoint;
    }

    public static final int lowSurrogate(int i) {
        return (i & 1023) + MinLowSurrogate;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02da, code lost:
        r13 = 0;
        r0.discardExact(((r15 - r17) - r7.element) + 1);
        r2 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x032d, code lost:
        r10 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x016d, code lost:
        r2 = -1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0285 A[Catch:{ all -> 0x031a, all -> 0x035a }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x03f6  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x021f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0168 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x02da A[EDGE_INSN: B:231:0x02da->B:147:0x02da ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x02be A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object decodeUTF8LineLoopSuspend(java.lang.Appendable r27, int r28, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.Input>, ? extends java.lang.Object> r29, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r30, kotlin.coroutines.Continuation<? super java.lang.Boolean> r31) {
        /*
            r0 = r31
            boolean r1 = r0 instanceof io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1 r1 = (io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1 r1 = new io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r5 = 1
            if (r3 == 0) goto L_0x0061
            if (r3 != r5) goto L_0x0059
            int r3 = r1.I$0
            java.lang.Object r6 = r1.L$6
            kotlin.jvm.internal.Ref$BooleanRef r6 = (kotlin.jvm.internal.Ref.BooleanRef) r6
            java.lang.Object r7 = r1.L$5
            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
            java.lang.Object r8 = r1.L$4
            kotlin.jvm.internal.Ref$IntRef r8 = (kotlin.jvm.internal.Ref.IntRef) r8
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$IntRef r9 = (kotlin.jvm.internal.Ref.IntRef) r9
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            java.lang.Object r12 = r1.L$0
            java.lang.Appendable r12 = (java.lang.Appendable) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r25 = r6
            r6 = r1
            r1 = r3
            r3 = r10
            r10 = r8
            r8 = r25
            r26 = r7
            r7 = r2
            r2 = r11
            r11 = r9
            r9 = r26
            goto L_0x00b4
        L_0x0059:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef
            r0.<init>()
            kotlin.jvm.internal.Ref$IntRef r3 = new kotlin.jvm.internal.Ref$IntRef
            r3.<init>()
            r3.element = r5
            kotlin.jvm.internal.Ref$BooleanRef r6 = new kotlin.jvm.internal.Ref$BooleanRef
            r6.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            r11 = r0
            r10 = r3
            r9 = r6
            r8 = r7
            r0 = r27
            r3 = r30
            r6 = r1
            r7 = r2
            r1 = r28
            r2 = r29
        L_0x0088:
            boolean r12 = r8.element
            if (r12 != 0) goto L_0x00b9
            int r12 = r10.element
            if (r12 == 0) goto L_0x00b9
            int r12 = r10.element
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            r6.L$0 = r0
            r6.L$1 = r2
            r6.L$2 = r3
            r6.L$3 = r11
            r6.L$4 = r10
            r6.L$5 = r9
            r6.L$6 = r8
            r6.I$0 = r1
            r6.label = r5
            java.lang.Object r12 = r2.invoke(r12, r6)
            if (r12 != r7) goto L_0x00af
            return r7
        L_0x00af:
            r25 = r12
            r12 = r0
            r0 = r25
        L_0x00b4:
            r13 = r0
            io.ktor.utils.io.core.Input r13 = (io.ktor.utils.io.core.Input) r13
            if (r13 != 0) goto L_0x00bc
        L_0x00b9:
            r13 = 0
            goto L_0x03f1
        L_0x00bc:
            long r14 = r13.getRemaining()
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r13, r5)
            if (r0 != 0) goto L_0x00d4
            r27 = r2
            r16 = r3
            r28 = r6
            r29 = r7
            r2 = r13
            r18 = r14
            r13 = 0
            goto L_0x03be
        L_0x00d4:
            r4 = r0
            r0 = r5
        L_0x00d6:
            r16 = r4
            io.ktor.utils.io.core.Buffer r16 = (io.ktor.utils.io.core.Buffer) r16     // Catch:{ all -> 0x03e7 }
            int r17 = r16.getWritePosition()     // Catch:{ all -> 0x03e7 }
            int r16 = r16.getReadPosition()     // Catch:{ all -> 0x03e7 }
            int r5 = r17 - r16
            if (r5 < r0) goto L_0x0373
            r0 = r4
            io.ktor.utils.io.core.Buffer r0 = (io.ktor.utils.io.core.Buffer) r0     // Catch:{ all -> 0x035c }
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x035c }
            r5.<init>()     // Catch:{ all -> 0x035c }
            r27 = r2
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x035c }
            r2.<init>()     // Catch:{ all -> 0x035c }
            r28 = r6
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x035c }
            r6.<init>()     // Catch:{ all -> 0x035c }
            r29 = r7
            kotlin.jvm.internal.Ref$IntRef r7 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x035c }
            r7.<init>()     // Catch:{ all -> 0x035c }
            r16 = r3
            java.nio.ByteBuffer r3 = r0.m184getMemorySK3TCg8()     // Catch:{ all -> 0x035c }
            int r17 = r0.getReadPosition()     // Catch:{ all -> 0x035c }
            r18 = r14
            int r14 = r0.getWritePosition()     // Catch:{ all -> 0x035c }
            r15 = r17
        L_0x0115:
            r20 = -1
            if (r15 >= r14) goto L_0x031e
            r30 = r13
            byte r13 = r3.get(r15)     // Catch:{ all -> 0x031a }
            r13 = r13 & 255(0xff, float:3.57E-43)
            r21 = r3
            r3 = r13 & 128(0x80, float:1.794E-43)
            r22 = r4
            java.lang.String r4 = " exceeded"
            r23 = r10
            java.lang.String r10 = "Too many characters in line: limit "
            r24 = r14
            r14 = 13
            if (r3 != 0) goto L_0x0197
            int r3 = r2.element     // Catch:{ all -> 0x035a }
            if (r3 != 0) goto L_0x018c
            char r3 = (char) r13     // Catch:{ all -> 0x035a }
            if (r3 != r14) goto L_0x0147
            boolean r3 = r9.element     // Catch:{ all -> 0x035a }
            if (r3 == 0) goto L_0x0143
            r13 = 1
            r8.element = r13     // Catch:{ all -> 0x035a }
        L_0x0141:
            r13 = 0
            goto L_0x0166
        L_0x0143:
            r13 = 1
            r9.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x0166
        L_0x0147:
            r13 = 1
            r14 = 10
            if (r3 != r14) goto L_0x0151
            r8.element = r13     // Catch:{ all -> 0x035a }
            r5.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x0141
        L_0x0151:
            boolean r14 = r9.element     // Catch:{ all -> 0x035a }
            if (r14 == 0) goto L_0x0158
            r8.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x0141
        L_0x0158:
            int r14 = r11.element     // Catch:{ all -> 0x035a }
            if (r14 == r1) goto L_0x0174
            int r4 = r11.element     // Catch:{ all -> 0x035a }
            int r4 = r4 + r13
            r11.element = r4     // Catch:{ all -> 0x035a }
            char r3 = (char) r3     // Catch:{ all -> 0x035a }
            r12.append(r3)     // Catch:{ all -> 0x035a }
            r13 = 1
        L_0x0166:
            if (r13 != 0) goto L_0x030b
            int r15 = r15 - r17
            r0.discardExact(r15)     // Catch:{ all -> 0x035a }
        L_0x016d:
            r2 = r20
        L_0x016f:
            r10 = r23
            r13 = 0
            goto L_0x032f
        L_0x0174:
            io.ktor.utils.io.charsets.TooLongLineException r0 = new io.ktor.utils.io.charsets.TooLongLineException     // Catch:{ all -> 0x035a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x035a }
            r2.<init>()     // Catch:{ all -> 0x035a }
            r2.append(r10)     // Catch:{ all -> 0x035a }
            r2.append(r1)     // Catch:{ all -> 0x035a }
            r2.append(r4)     // Catch:{ all -> 0x035a }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x035a }
            r0.<init>(r1)     // Catch:{ all -> 0x035a }
            throw r0     // Catch:{ all -> 0x035a }
        L_0x018c:
            int r0 = r2.element     // Catch:{ all -> 0x035a }
            malformedByteCount(r0)     // Catch:{ all -> 0x035a }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x035a }
            r0.<init>()     // Catch:{ all -> 0x035a }
            throw r0     // Catch:{ all -> 0x035a }
        L_0x0197:
            int r3 = r2.element     // Catch:{ all -> 0x035a }
            if (r3 != 0) goto L_0x01d1
            r6.element = r13     // Catch:{ all -> 0x035a }
            r3 = 128(0x80, float:1.794E-43)
            r4 = 1
        L_0x01a0:
            r10 = 7
            if (r4 >= r10) goto L_0x01b9
            int r10 = r6.element     // Catch:{ all -> 0x035a }
            r10 = r10 & r3
            if (r10 == 0) goto L_0x01b9
            int r10 = r6.element     // Catch:{ all -> 0x035a }
            int r13 = ~r3     // Catch:{ all -> 0x035a }
            r10 = r10 & r13
            r6.element = r10     // Catch:{ all -> 0x035a }
            int r3 = r3 >> 1
            int r10 = r2.element     // Catch:{ all -> 0x035a }
            r13 = 1
            int r10 = r10 + r13
            r2.element = r10     // Catch:{ all -> 0x035a }
            int r4 = r4 + 1
            goto L_0x01a0
        L_0x01b9:
            int r3 = r2.element     // Catch:{ all -> 0x035a }
            r7.element = r3     // Catch:{ all -> 0x035a }
            int r3 = r2.element     // Catch:{ all -> 0x035a }
            int r3 = r3 + -1
            r2.element = r3     // Catch:{ all -> 0x035a }
            int r3 = r7.element     // Catch:{ all -> 0x035a }
            int r14 = r24 - r15
            if (r3 <= r14) goto L_0x030b
            int r15 = r15 - r17
            r0.discardExact(r15)     // Catch:{ all -> 0x035a }
            int r2 = r7.element     // Catch:{ all -> 0x035a }
            goto L_0x016f
        L_0x01d1:
            int r3 = r6.element     // Catch:{ all -> 0x035a }
            int r3 = r3 << 6
            r13 = r13 & 127(0x7f, float:1.78E-43)
            r3 = r3 | r13
            r6.element = r3     // Catch:{ all -> 0x035a }
            int r3 = r2.element     // Catch:{ all -> 0x035a }
            int r3 = r3 + -1
            r2.element = r3     // Catch:{ all -> 0x035a }
            int r3 = r2.element     // Catch:{ all -> 0x035a }
            if (r3 != 0) goto L_0x030b
            int r3 = r6.element     // Catch:{ all -> 0x035a }
            boolean r3 = isBmpCodePoint(r3)     // Catch:{ all -> 0x035a }
            if (r3 == 0) goto L_0x0246
            int r3 = r6.element     // Catch:{ all -> 0x035a }
            char r3 = (char) r3     // Catch:{ all -> 0x035a }
            if (r3 != r14) goto L_0x01fe
            boolean r3 = r9.element     // Catch:{ all -> 0x035a }
            if (r3 == 0) goto L_0x01fa
            r13 = 1
            r8.element = r13     // Catch:{ all -> 0x035a }
        L_0x01f8:
            r13 = 0
            goto L_0x021d
        L_0x01fa:
            r13 = 1
            r9.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x021d
        L_0x01fe:
            r13 = 1
            r14 = 10
            if (r3 != r14) goto L_0x0208
            r8.element = r13     // Catch:{ all -> 0x035a }
            r5.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x01f8
        L_0x0208:
            boolean r14 = r9.element     // Catch:{ all -> 0x035a }
            if (r14 == 0) goto L_0x020f
            r8.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x01f8
        L_0x020f:
            int r14 = r11.element     // Catch:{ all -> 0x035a }
            if (r14 == r1) goto L_0x022e
            int r4 = r11.element     // Catch:{ all -> 0x035a }
            int r4 = r4 + r13
            r11.element = r4     // Catch:{ all -> 0x035a }
            char r3 = (char) r3     // Catch:{ all -> 0x035a }
            r12.append(r3)     // Catch:{ all -> 0x035a }
            r13 = 1
        L_0x021d:
            if (r13 != 0) goto L_0x022b
            int r15 = r15 - r17
            int r2 = r7.element     // Catch:{ all -> 0x035a }
            int r15 = r15 - r2
            r2 = 1
            int r15 = r15 + r2
            r0.discardExact(r15)     // Catch:{ all -> 0x035a }
            goto L_0x016d
        L_0x022b:
            r13 = 0
            goto L_0x02bf
        L_0x022e:
            io.ktor.utils.io.charsets.TooLongLineException r0 = new io.ktor.utils.io.charsets.TooLongLineException     // Catch:{ all -> 0x035a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x035a }
            r2.<init>()     // Catch:{ all -> 0x035a }
            r2.append(r10)     // Catch:{ all -> 0x035a }
            r2.append(r1)     // Catch:{ all -> 0x035a }
            r2.append(r4)     // Catch:{ all -> 0x035a }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x035a }
            r0.<init>(r1)     // Catch:{ all -> 0x035a }
            throw r0     // Catch:{ all -> 0x035a }
        L_0x0246:
            int r3 = r6.element     // Catch:{ all -> 0x035a }
            boolean r3 = isValidCodePoint(r3)     // Catch:{ all -> 0x035a }
            if (r3 == 0) goto L_0x0300
            int r3 = r6.element     // Catch:{ all -> 0x035a }
            int r3 = highSurrogate(r3)     // Catch:{ all -> 0x035a }
            char r3 = (char) r3     // Catch:{ all -> 0x035a }
            if (r3 != r14) goto L_0x0264
            boolean r3 = r9.element     // Catch:{ all -> 0x035a }
            if (r3 == 0) goto L_0x0260
            r13 = 1
            r8.element = r13     // Catch:{ all -> 0x035a }
        L_0x025e:
            r13 = 0
            goto L_0x0283
        L_0x0260:
            r13 = 1
            r9.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x0283
        L_0x0264:
            r13 = 1
            r14 = 10
            if (r3 != r14) goto L_0x026e
            r8.element = r13     // Catch:{ all -> 0x035a }
            r5.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x025e
        L_0x026e:
            boolean r14 = r9.element     // Catch:{ all -> 0x035a }
            if (r14 == 0) goto L_0x0275
            r8.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x025e
        L_0x0275:
            int r14 = r11.element     // Catch:{ all -> 0x035a }
            if (r14 == r1) goto L_0x02e8
            int r14 = r11.element     // Catch:{ all -> 0x035a }
            int r14 = r14 + r13
            r11.element = r14     // Catch:{ all -> 0x035a }
            char r3 = (char) r3     // Catch:{ all -> 0x035a }
            r12.append(r3)     // Catch:{ all -> 0x035a }
            r13 = 1
        L_0x0283:
            if (r13 == 0) goto L_0x02da
            int r3 = r6.element     // Catch:{ all -> 0x035a }
            int r3 = lowSurrogate(r3)     // Catch:{ all -> 0x035a }
            char r3 = (char) r3     // Catch:{ all -> 0x035a }
            r13 = 13
            if (r3 != r13) goto L_0x029d
            boolean r3 = r9.element     // Catch:{ all -> 0x035a }
            if (r3 == 0) goto L_0x0299
            r13 = 1
            r8.element = r13     // Catch:{ all -> 0x035a }
        L_0x0297:
            r13 = 0
            goto L_0x02bc
        L_0x0299:
            r13 = 1
            r9.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x02bc
        L_0x029d:
            r13 = 1
            r14 = 10
            if (r3 != r14) goto L_0x02a7
            r8.element = r13     // Catch:{ all -> 0x035a }
            r5.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x0297
        L_0x02a7:
            boolean r14 = r9.element     // Catch:{ all -> 0x035a }
            if (r14 == 0) goto L_0x02ae
            r8.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x0297
        L_0x02ae:
            int r14 = r11.element     // Catch:{ all -> 0x035a }
            if (r14 == r1) goto L_0x02c2
            int r4 = r11.element     // Catch:{ all -> 0x035a }
            int r4 = r4 + r13
            r11.element = r4     // Catch:{ all -> 0x035a }
            char r3 = (char) r3     // Catch:{ all -> 0x035a }
            r12.append(r3)     // Catch:{ all -> 0x035a }
            r13 = 1
        L_0x02bc:
            if (r13 != 0) goto L_0x022b
            goto L_0x02da
        L_0x02bf:
            r6.element = r13     // Catch:{ all -> 0x035a }
            goto L_0x030c
        L_0x02c2:
            io.ktor.utils.io.charsets.TooLongLineException r0 = new io.ktor.utils.io.charsets.TooLongLineException     // Catch:{ all -> 0x035a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x035a }
            r2.<init>()     // Catch:{ all -> 0x035a }
            r2.append(r10)     // Catch:{ all -> 0x035a }
            r2.append(r1)     // Catch:{ all -> 0x035a }
            r2.append(r4)     // Catch:{ all -> 0x035a }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x035a }
            r0.<init>(r1)     // Catch:{ all -> 0x035a }
            throw r0     // Catch:{ all -> 0x035a }
        L_0x02da:
            r13 = 0
            int r15 = r15 - r17
            int r2 = r7.element     // Catch:{ all -> 0x035a }
            int r15 = r15 - r2
            r2 = 1
            int r15 = r15 + r2
            r0.discardExact(r15)     // Catch:{ all -> 0x035a }
            r2 = r20
            goto L_0x032d
        L_0x02e8:
            io.ktor.utils.io.charsets.TooLongLineException r0 = new io.ktor.utils.io.charsets.TooLongLineException     // Catch:{ all -> 0x035a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x035a }
            r2.<init>()     // Catch:{ all -> 0x035a }
            r2.append(r10)     // Catch:{ all -> 0x035a }
            r2.append(r1)     // Catch:{ all -> 0x035a }
            r2.append(r4)     // Catch:{ all -> 0x035a }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x035a }
            r0.<init>(r1)     // Catch:{ all -> 0x035a }
            throw r0     // Catch:{ all -> 0x035a }
        L_0x0300:
            int r0 = r6.element     // Catch:{ all -> 0x035a }
            malformedCodePoint(r0)     // Catch:{ all -> 0x035a }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x035a }
            r0.<init>()     // Catch:{ all -> 0x035a }
            throw r0     // Catch:{ all -> 0x035a }
        L_0x030b:
            r13 = 0
        L_0x030c:
            int r15 = r15 + 1
            r13 = r30
            r3 = r21
            r4 = r22
            r10 = r23
            r14 = r24
            goto L_0x0115
        L_0x031a:
            r0 = move-exception
            r22 = r4
            goto L_0x0361
        L_0x031e:
            r22 = r4
            r23 = r10
            r30 = r13
            r24 = r14
            r13 = 0
            int r14 = r24 - r17
            r0.discardExact(r14)     // Catch:{ all -> 0x035a }
            r2 = r13
        L_0x032d:
            r10 = r23
        L_0x032f:
            r10.element = r2     // Catch:{ all -> 0x035a }
            int r2 = r5.element     // Catch:{ all -> 0x035a }
            if (r2 <= 0) goto L_0x033a
            int r2 = r5.element     // Catch:{ all -> 0x035a }
            r0.discardExact(r2)     // Catch:{ all -> 0x035a }
        L_0x033a:
            boolean r0 = r8.element     // Catch:{ all -> 0x035a }
            if (r0 == 0) goto L_0x0340
            r0 = r13
            goto L_0x0347
        L_0x0340:
            int r0 = r10.element     // Catch:{ all -> 0x035a }
            r2 = 1
            int r0 = kotlin.ranges.RangesKt.coerceAtLeast(r0, r2)     // Catch:{ all -> 0x035a }
        L_0x0347:
            r10.element = r0     // Catch:{ all -> 0x035a }
            int r0 = r10.element     // Catch:{ all -> 0x035a }
            r4 = r22
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x036c }
            int r2 = r4.getWritePosition()     // Catch:{ all -> 0x036c }
            int r3 = r4.getReadPosition()     // Catch:{ all -> 0x036c }
            int r5 = r2 - r3
            goto L_0x0382
        L_0x035a:
            r0 = move-exception
            goto L_0x0361
        L_0x035c:
            r0 = move-exception
            r22 = r4
            r30 = r13
        L_0x0361:
            r4 = r22
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x036c }
            r4.getWritePosition()     // Catch:{ all -> 0x036c }
            r4.getReadPosition()     // Catch:{ all -> 0x036c }
            throw r0     // Catch:{ all -> 0x036c }
        L_0x036c:
            r0 = move-exception
            r2 = r30
            r3 = r22
            goto L_0x03ea
        L_0x0373:
            r27 = r2
            r16 = r3
            r22 = r4
            r28 = r6
            r29 = r7
            r30 = r13
            r18 = r14
            r13 = 0
        L_0x0382:
            if (r5 != 0) goto L_0x0391
            r2 = r30
            r3 = r22
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r2, r3)     // Catch:{ all -> 0x038d }
            goto L_0x03b1
        L_0x038d:
            r0 = move-exception
            r4 = r13
            goto L_0x03eb
        L_0x0391:
            r2 = r30
            r3 = r22
            if (r5 < r0) goto L_0x03aa
            r4 = r3
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x038d }
            int r5 = r4.getCapacity()     // Catch:{ all -> 0x038d }
            int r4 = r4.getLimit()     // Catch:{ all -> 0x038d }
            int r5 = r5 - r4
            r4 = 8
            if (r5 >= r4) goto L_0x03a8
            goto L_0x03aa
        L_0x03a8:
            r4 = r3
            goto L_0x03b1
        L_0x03aa:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r2, r3)     // Catch:{ all -> 0x038d }
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r2, r0)     // Catch:{ all -> 0x038d }
        L_0x03b1:
            if (r4 != 0) goto L_0x03b6
            r4 = r3
            r0 = r13
            goto L_0x03b9
        L_0x03b6:
            if (r0 > 0) goto L_0x03d9
            r0 = 1
        L_0x03b9:
            if (r0 == 0) goto L_0x03be
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r2, r4)
        L_0x03be:
            long r2 = r2.getRemaining()
            long r14 = r18 - r2
            int r0 = (int) r14
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r5 = r16
            r5.invoke(r0)
            r2 = r27
            r6 = r28
            r7 = r29
            r3 = r5
            r0 = r12
            r5 = 1
            goto L_0x0088
        L_0x03d9:
            r6 = r28
            r7 = r29
            r13 = r2
            r3 = r16
            r14 = r18
            r5 = 1
            r2 = r27
            goto L_0x00d6
        L_0x03e7:
            r0 = move-exception
            r3 = r4
            r2 = r13
        L_0x03ea:
            r4 = 1
        L_0x03eb:
            if (r4 == 0) goto L_0x03f0
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r2, r3)
        L_0x03f0:
            throw r0
        L_0x03f1:
            int r0 = r10.element
            r1 = 1
            if (r0 > r1) goto L_0x040d
            boolean r0 = r9.element
            if (r0 == 0) goto L_0x03fc
            r8.element = r1
        L_0x03fc:
            int r0 = r11.element
            if (r0 > 0) goto L_0x0407
            boolean r0 = r8.element
            if (r0 == 0) goto L_0x0405
            goto L_0x0407
        L_0x0405:
            r4 = r13
            goto L_0x0408
        L_0x0407:
            r4 = r1
        L_0x0408:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r0
        L_0x040d:
            int r0 = r10.element
            prematureEndOfStreamUtf(r0)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.decodeUTF8LineLoopSuspend(java.lang.Appendable, int, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Void prematureEndOfStreamUtf(int i) {
        throw new EOFException("Premature end of stream: expected " + i + " bytes to decode UTF-8 char");
    }

    /* renamed from: encodeUTF8-lBXzO7A  reason: not valid java name */
    public static final int m304encodeUTF8lBXzO7A(ByteBuffer byteBuffer, CharSequence charSequence, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$encodeUTF8");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        int min = Math.min(i2, i + 65535);
        int coerceAtMost = RangesKt.coerceAtMost(i4, 65535);
        int i5 = i;
        int i6 = i3;
        while (i6 < coerceAtMost && i5 < min) {
            int i7 = i5 + 1;
            char charAt = charSequence.charAt(i5) & 65535;
            if ((65408 & charAt) == 0) {
                byteBuffer.put(i6, (byte) charAt);
                i5 = i7;
                i6++;
            } else {
                return m305encodeUTF8Stage1Vm9B2pQ(byteBuffer, charSequence, i7 - 1, min, i, i6, coerceAtMost, i3);
            }
        }
        return EncodeResult.m296constructorimpl(UShort.m598constructorimpl((short) (i5 - i)), UShort.m598constructorimpl((short) (i6 - i3)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: char} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: encodeUTF8Stage1-Vm9B2pQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int m305encodeUTF8Stage1Vm9B2pQ(java.nio.ByteBuffer r13, java.lang.CharSequence r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        /*
            r0 = r13
            r1 = r14
            r3 = r16
            int r2 = r19 + -3
            r4 = r15
            r5 = r18
        L_0x0009:
            int r6 = r2 - r5
            if (r6 <= 0) goto L_0x00d4
            if (r4 < r3) goto L_0x0011
            goto L_0x00d4
        L_0x0011:
            int r6 = r4 + 1
            char r4 = r14.charAt(r4)
            boolean r7 = java.lang.Character.isHighSurrogate(r4)
            r8 = 63
            if (r7 == 0) goto L_0x0039
            if (r6 == r3) goto L_0x0038
            char r7 = r14.charAt(r6)
            boolean r7 = java.lang.Character.isLowSurrogate(r7)
            if (r7 != 0) goto L_0x002c
            goto L_0x0038
        L_0x002c:
            int r7 = r6 + 1
            char r6 = r14.charAt(r6)
            int r4 = codePoint(r4, r6)
            r6 = r7
            goto L_0x0039
        L_0x0038:
            r4 = r8
        L_0x0039:
            r7 = 128(0x80, float:1.794E-43)
            r9 = 0
            r10 = 1
            if (r4 < 0) goto L_0x0043
            if (r4 >= r7) goto L_0x0043
            r11 = r10
            goto L_0x0044
        L_0x0043:
            r11 = r9
        L_0x0044:
            if (r11 == 0) goto L_0x004c
            byte r4 = (byte) r4
            r13.put(r5, r4)
            goto L_0x00c7
        L_0x004c:
            r11 = 2048(0x800, float:2.87E-42)
            if (r7 > r4) goto L_0x0054
            if (r4 >= r11) goto L_0x0054
            r12 = r10
            goto L_0x0055
        L_0x0054:
            r12 = r9
        L_0x0055:
            if (r12 == 0) goto L_0x006c
            int r8 = r4 >> 6
            r8 = r8 & 31
            r8 = r8 | 192(0xc0, float:2.69E-43)
            byte r8 = (byte) r8
            r13.put(r5, r8)
            int r8 = r5 + 1
            r4 = r4 & 63
            r4 = r4 | r7
            byte r4 = (byte) r4
            r13.put(r8, r4)
            r10 = 2
            goto L_0x00c7
        L_0x006c:
            r12 = 65536(0x10000, float:9.18355E-41)
            if (r11 > r4) goto L_0x0074
            if (r4 >= r12) goto L_0x0074
            r11 = r10
            goto L_0x0075
        L_0x0074:
            r11 = r9
        L_0x0075:
            if (r11 == 0) goto L_0x0096
            int r9 = r4 >> 12
            r9 = r9 & 15
            r9 = r9 | 224(0xe0, float:3.14E-43)
            byte r9 = (byte) r9
            r13.put(r5, r9)
            int r9 = r5 + 1
            int r10 = r4 >> 6
            r8 = r8 & r10
            r8 = r8 | r7
            byte r8 = (byte) r8
            r13.put(r9, r8)
            int r8 = r5 + 2
            r4 = r4 & 63
            r4 = r4 | r7
            byte r4 = (byte) r4
            r13.put(r8, r4)
            r10 = 3
            goto L_0x00c7
        L_0x0096:
            if (r12 > r4) goto L_0x009d
            r11 = 1114112(0x110000, float:1.561203E-39)
            if (r4 >= r11) goto L_0x009d
            r9 = r10
        L_0x009d:
            if (r9 == 0) goto L_0x00cb
            int r9 = r4 >> 18
            r9 = r9 & 7
            r9 = r9 | 240(0xf0, float:3.36E-43)
            byte r9 = (byte) r9
            r13.put(r5, r9)
            int r9 = r5 + 1
            int r10 = r4 >> 12
            r10 = r10 & r8
            r10 = r10 | r7
            byte r10 = (byte) r10
            r13.put(r9, r10)
            int r9 = r5 + 2
            int r10 = r4 >> 6
            r8 = r8 & r10
            r8 = r8 | r7
            byte r8 = (byte) r8
            r13.put(r9, r8)
            int r8 = r5 + 3
            r4 = r4 & 63
            r4 = r4 | r7
            byte r4 = (byte) r4
            r13.put(r8, r4)
            r10 = 4
        L_0x00c7:
            int r5 = r5 + r10
            r4 = r6
            goto L_0x0009
        L_0x00cb:
            malformedCodePoint(r4)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00d4:
            if (r5 != r2) goto L_0x00e6
            r0 = r13
            r1 = r14
            r2 = r4
            r3 = r16
            r4 = r17
            r6 = r19
            r7 = r20
            int r0 = m306encodeUTF8Stage2Vm9B2pQ(r0, r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x00e6:
            int r4 = r4 - r17
            short r0 = (short) r4
            short r0 = kotlin.UShort.m598constructorimpl(r0)
            int r5 = r5 - r20
            short r1 = (short) r5
            short r1 = kotlin.UShort.m598constructorimpl(r1)
            int r0 = io.ktor.utils.io.core.internal.EncodeResult.m296constructorimpl(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.m305encodeUTF8Stage1Vm9B2pQ(java.nio.ByteBuffer, java.lang.CharSequence, int, int, int, int, int, int):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: char} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: encodeUTF8Stage2-Vm9B2pQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int m306encodeUTF8Stage2Vm9B2pQ(java.nio.ByteBuffer r17, java.lang.CharSequence r18, int r19, int r20, int r21, int r22, int r23, int r24) {
        /*
            r0 = r17
            r1 = r18
            r2 = r20
            r3 = r19
            r4 = r22
        L_0x000a:
            int r5 = r23 - r4
            if (r5 <= 0) goto L_0x0117
            if (r3 < r2) goto L_0x0012
            goto L_0x0117
        L_0x0012:
            int r6 = r3 + 1
            char r3 = r1.charAt(r3)
            boolean r7 = java.lang.Character.isHighSurrogate(r3)
            r8 = 63
            if (r7 != 0) goto L_0x0021
            goto L_0x003b
        L_0x0021:
            if (r6 == r2) goto L_0x003a
            char r7 = r1.charAt(r6)
            boolean r7 = java.lang.Character.isLowSurrogate(r7)
            if (r7 != 0) goto L_0x002e
            goto L_0x003a
        L_0x002e:
            int r7 = r6 + 1
            char r6 = r1.charAt(r6)
            int r3 = codePoint(r3, r6)
            r6 = r7
            goto L_0x003b
        L_0x003a:
            r3 = r8
        L_0x003b:
            r7 = 128(0x80, float:1.794E-43)
            r10 = 1
            if (r10 > r3) goto L_0x0044
            if (r3 >= r7) goto L_0x0044
            r11 = r10
            goto L_0x0045
        L_0x0044:
            r11 = 0
        L_0x0045:
            r12 = 4
            r13 = 1114112(0x110000, float:1.561203E-39)
            r14 = 3
            r15 = 65536(0x10000, float:9.18355E-41)
            r16 = 2
            r9 = 2048(0x800, float:2.87E-42)
            if (r11 == 0) goto L_0x0053
            r11 = r10
            goto L_0x0074
        L_0x0053:
            if (r7 > r3) goto L_0x0059
            if (r3 >= r9) goto L_0x0059
            r11 = r10
            goto L_0x005a
        L_0x0059:
            r11 = 0
        L_0x005a:
            if (r11 == 0) goto L_0x005f
            r11 = r16
            goto L_0x0074
        L_0x005f:
            if (r9 > r3) goto L_0x0065
            if (r3 >= r15) goto L_0x0065
            r11 = r10
            goto L_0x0066
        L_0x0065:
            r11 = 0
        L_0x0066:
            if (r11 == 0) goto L_0x006a
            r11 = r14
            goto L_0x0074
        L_0x006a:
            if (r15 > r3) goto L_0x0070
            if (r3 >= r13) goto L_0x0070
            r11 = r10
            goto L_0x0071
        L_0x0070:
            r11 = 0
        L_0x0071:
            if (r11 == 0) goto L_0x010e
            r11 = r12
        L_0x0074:
            if (r11 <= r5) goto L_0x007a
            int r3 = r6 + -1
            goto L_0x0117
        L_0x007a:
            if (r3 < 0) goto L_0x0080
            if (r3 >= r7) goto L_0x0080
            r5 = r10
            goto L_0x0081
        L_0x0080:
            r5 = 0
        L_0x0081:
            if (r5 == 0) goto L_0x0089
            byte r3 = (byte) r3
            r0.put(r4, r3)
            goto L_0x0101
        L_0x0089:
            if (r7 > r3) goto L_0x008f
            if (r3 >= r9) goto L_0x008f
            r5 = r10
            goto L_0x0090
        L_0x008f:
            r5 = 0
        L_0x0090:
            if (r5 == 0) goto L_0x00a8
            int r5 = r3 >> 6
            r5 = r5 & 31
            r5 = r5 | 192(0xc0, float:2.69E-43)
            byte r5 = (byte) r5
            r0.put(r4, r5)
            int r5 = r4 + 1
            r3 = r3 & 63
            r3 = r3 | r7
            byte r3 = (byte) r3
            r0.put(r5, r3)
            r10 = r16
            goto L_0x0101
        L_0x00a8:
            if (r9 > r3) goto L_0x00ae
            if (r3 >= r15) goto L_0x00ae
            r5 = r10
            goto L_0x00af
        L_0x00ae:
            r5 = 0
        L_0x00af:
            if (r5 == 0) goto L_0x00d0
            int r5 = r3 >> 12
            r5 = r5 & 15
            r5 = r5 | 224(0xe0, float:3.14E-43)
            byte r5 = (byte) r5
            r0.put(r4, r5)
            int r5 = r4 + 1
            int r9 = r3 >> 6
            r8 = r8 & r9
            r8 = r8 | r7
            byte r8 = (byte) r8
            r0.put(r5, r8)
            int r5 = r4 + 2
            r3 = r3 & 63
            r3 = r3 | r7
            byte r3 = (byte) r3
            r0.put(r5, r3)
            r10 = r14
            goto L_0x0101
        L_0x00d0:
            if (r15 > r3) goto L_0x00d6
            if (r3 >= r13) goto L_0x00d6
            r9 = r10
            goto L_0x00d7
        L_0x00d6:
            r9 = 0
        L_0x00d7:
            if (r9 == 0) goto L_0x0105
            int r5 = r3 >> 18
            r5 = r5 & 7
            r5 = r5 | 240(0xf0, float:3.36E-43)
            byte r5 = (byte) r5
            r0.put(r4, r5)
            int r5 = r4 + 1
            int r9 = r3 >> 12
            r9 = r9 & r8
            r9 = r9 | r7
            byte r9 = (byte) r9
            r0.put(r5, r9)
            int r5 = r4 + 2
            int r9 = r3 >> 6
            r8 = r8 & r9
            r8 = r8 | r7
            byte r8 = (byte) r8
            r0.put(r5, r8)
            int r5 = r4 + 3
            r3 = r3 & 63
            r3 = r3 | r7
            byte r3 = (byte) r3
            r0.put(r5, r3)
            r10 = r12
        L_0x0101:
            int r4 = r4 + r10
            r3 = r6
            goto L_0x000a
        L_0x0105:
            malformedCodePoint(r3)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x010e:
            malformedCodePoint(r3)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0117:
            int r3 = r3 - r21
            short r0 = (short) r3
            short r0 = kotlin.UShort.m598constructorimpl(r0)
            int r4 = r4 - r24
            short r1 = (short) r4
            short r1 = kotlin.UShort.m598constructorimpl(r1)
            int r0 = io.ktor.utils.io.core.internal.EncodeResult.m296constructorimpl(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.m306encodeUTF8Stage2Vm9B2pQ(java.nio.ByteBuffer, java.lang.CharSequence, int, int, int, int, int, int):int");
    }

    private static final int charactersSize(int i) {
        boolean z = true;
        if (1 <= i && i < 128) {
            return 1;
        }
        if (128 <= i && i < 2048) {
            return 2;
        }
        if (2048 <= i && i < 65536) {
            return 3;
        }
        if (65536 > i || i >= 1114112) {
            z = false;
        }
        if (z) {
            return 4;
        }
        malformedCodePoint(i);
        throw new KotlinNothingValueException();
    }

    public static final Void malformedByteCount(int i) {
        throw new MalformedUTF8InputException("Expected " + i + " more character bytes");
    }

    public static final Void malformedCodePoint(int i) {
        throw new IllegalArgumentException("Malformed code-point " + i + " found");
    }

    public static final boolean decodeASCII(Buffer buffer, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function1, "consumer");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        for (int i = readPosition; i < writePosition; i++) {
            byte b = r0.get(i) & UByte.MAX_VALUE;
            if ((b & 128) == 128 || !((Boolean) function1.invoke(Character.valueOf((char) b))).booleanValue()) {
                buffer.discardExact(i - readPosition);
                return false;
            }
        }
        buffer.discardExact(writePosition - readPosition);
        return true;
    }

    public static final int decodeUTF8(Buffer buffer, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function1, "consumer");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        int i = 0;
        byte b = 0;
        int i2 = 0;
        for (int i3 = readPosition; i3 < writePosition; i3++) {
            byte b2 = r0.get(i3) & UByte.MAX_VALUE;
            if ((b2 & 128) != 0) {
                if (i == 0) {
                    int i4 = 128;
                    b = b2;
                    for (int i5 = 1; i5 < 7 && (b & i4) != 0; i5++) {
                        b &= ~i4;
                        i4 >>= 1;
                        i++;
                    }
                    int i6 = i - 1;
                    if (i > writePosition - i3) {
                        buffer.discardExact(i3 - readPosition);
                        return i;
                    }
                    int i7 = i6;
                    i2 = i;
                    i = i7;
                } else {
                    b = (b << 6) | (b2 & Byte.MAX_VALUE);
                    i--;
                    if (i != 0) {
                        continue;
                    } else {
                        if (isBmpCodePoint(b)) {
                            if (!((Boolean) function1.invoke(Character.valueOf((char) b))).booleanValue()) {
                                buffer.discardExact(((i3 - readPosition) - i2) + 1);
                                return -1;
                            }
                        } else if (!isValidCodePoint(b)) {
                            malformedCodePoint(b);
                            throw new KotlinNothingValueException();
                        } else if (!((Boolean) function1.invoke(Character.valueOf((char) highSurrogate(b)))).booleanValue() || !((Boolean) function1.invoke(Character.valueOf((char) lowSurrogate(b)))).booleanValue()) {
                            buffer.discardExact(((i3 - readPosition) - i2) + 1);
                            return -1;
                        }
                        b = 0;
                    }
                }
            } else if (i != 0) {
                malformedByteCount(i);
                throw new KotlinNothingValueException();
            } else if (!((Boolean) function1.invoke(Character.valueOf((char) b2))).booleanValue()) {
                buffer.discardExact(i3 - readPosition);
                return -1;
            }
        }
        buffer.discardExact(writePosition - readPosition);
        return 0;
    }

    /* renamed from: putUtf8Char-62zg_DM  reason: not valid java name */
    public static final int m307putUtf8Char62zg_DM(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$putUtf8Char");
        boolean z = true;
        if (i2 >= 0 && i2 < 128) {
            byteBuffer.put(i, (byte) i2);
            return 1;
        }
        if (128 <= i2 && i2 < 2048) {
            byteBuffer.put(i, (byte) (((i2 >> 6) & 31) | 192));
            byteBuffer.put(i + 1, (byte) ((i2 & 63) | Constants.ERR_WATERMARK_ARGB));
            return 2;
        }
        if (2048 <= i2 && i2 < 65536) {
            byteBuffer.put(i, (byte) (((i2 >> 12) & 15) | 224));
            byteBuffer.put(i + 1, (byte) (((i2 >> 6) & 63) | Constants.ERR_WATERMARK_ARGB));
            byteBuffer.put(i + 2, (byte) ((i2 & 63) | Constants.ERR_WATERMARK_ARGB));
            return 3;
        }
        if (65536 > i2 || i2 >= 1114112) {
            z = false;
        }
        if (z) {
            byteBuffer.put(i, (byte) (((i2 >> 18) & 7) | GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH));
            byteBuffer.put(i + 1, (byte) (((i2 >> 12) & 63) | Constants.ERR_WATERMARK_ARGB));
            byteBuffer.put(i + 2, (byte) (((i2 >> 6) & 63) | Constants.ERR_WATERMARK_ARGB));
            byteBuffer.put(i + 3, (byte) ((i2 & 63) | Constants.ERR_WATERMARK_ARGB));
            return 4;
        }
        malformedCodePoint(i2);
        throw new KotlinNothingValueException();
    }
}
