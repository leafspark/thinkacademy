package io.ktor.utils.io;

import java.nio.CharBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSession;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteBufferChannel.kt */
final class ByteBufferChannel$readUTF8LineToAscii$2 extends Lambda implements Function1<LookAheadSession, Unit> {
    final /* synthetic */ char[] $array;
    final /* synthetic */ CharBuffer $buffer;
    final /* synthetic */ Ref.IntRef $consumed;
    final /* synthetic */ Ref.BooleanRef $eol;
    final /* synthetic */ int $limit;
    final /* synthetic */ Appendable $out;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$readUTF8LineToAscii$2(Ref.BooleanRef booleanRef, ByteBufferChannel byteBufferChannel, Appendable appendable, char[] cArr, CharBuffer charBuffer, Ref.IntRef intRef, int i) {
        super(1);
        this.$eol = booleanRef;
        this.this$0 = byteBufferChannel;
        this.$out = appendable;
        this.$array = cArr;
        this.$buffer = charBuffer;
        this.$consumed = intRef;
        this.$limit = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LookAheadSession) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095 A[LOOP:0: B:1:0x0022->B:24:0x0095, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099 A[EDGE_INSN: B:32:0x0099->B:26:0x0099 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(io.ktor.utils.io.LookAheadSession r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "$this$lookAhead"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.jvm.internal.Ref$BooleanRef r2 = r0.$eol
            io.ktor.utils.io.ByteBufferChannel r3 = r0.this$0
            java.lang.Appendable r4 = r0.$out
            char[] r5 = r0.$array
            java.nio.CharBuffer r6 = r0.$buffer
            java.lang.String r7 = "buffer"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            io.ktor.utils.io.ByteBufferChannel r7 = r0.this$0
            kotlin.jvm.internal.Ref$IntRef r8 = r0.$consumed
            char[] r9 = r0.$array
            int r10 = r0.$limit
            r11 = 1
            r12 = r11
        L_0x0022:
            int r13 = r7.getAvailableForRead()
            r14 = 0
            if (r13 < r12) goto L_0x002b
            r13 = r11
            goto L_0x002c
        L_0x002b:
            r13 = r14
        L_0x002c:
            if (r13 == 0) goto L_0x0097
            java.nio.ByteBuffer r13 = r1.request(r14, r11)
            if (r13 != 0) goto L_0x0035
            goto L_0x0097
        L_0x0035:
            int r15 = r13.position()
            int r11 = r13.remaining()
            if (r11 >= r12) goto L_0x0042
            r3.rollBytes(r13, r12)
        L_0x0042:
            int r11 = r9.length
            int r12 = r8.element
            int r12 = r10 - r12
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = io.ktor.utils.io.internal.StringsKt.decodeASCIILine(r13, r9, r14, r11)
            int r16 = r13.position()
            int r15 = r16 - r15
            r1.consumed(r15)
            r15 = 32
            long r14 = r11 >> r15
            int r14 = (int) r14
            r17 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r11 = r11 & r17
            int r11 = (int) r11
            r12 = -1
            if (r11 != r12) goto L_0x006b
            r12 = 0
        L_0x0069:
            r13 = 1
            goto L_0x007a
        L_0x006b:
            if (r11 != 0) goto L_0x0074
            boolean r13 = r13.hasRemaining()
            if (r13 == 0) goto L_0x0074
            goto L_0x0069
        L_0x0074:
            r13 = 1
            int r11 = java.lang.Math.max(r13, r11)
            r12 = r11
        L_0x007a:
            int r11 = r8.element
            int r11 = r11 + r14
            r8.element = r11
            boolean r11 = r4 instanceof java.lang.StringBuilder
            if (r11 == 0) goto L_0x008b
            r11 = r4
            java.lang.StringBuilder r11 = (java.lang.StringBuilder) r11
            r15 = 0
            r11.append(r5, r15, r14)
            goto L_0x0092
        L_0x008b:
            r15 = 0
            r11 = r6
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r4.append(r11, r15, r14)
        L_0x0092:
            if (r12 > 0) goto L_0x0095
            goto L_0x0099
        L_0x0095:
            r11 = r13
            goto L_0x0022
        L_0x0097:
            r13 = r11
            r15 = r14
        L_0x0099:
            if (r12 != 0) goto L_0x009d
            r11 = r13
            goto L_0x009e
        L_0x009d:
            r11 = r15
        L_0x009e:
            r2.element = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel$readUTF8LineToAscii$2.invoke(io.ktor.utils.io.LookAheadSession):void");
    }
}
