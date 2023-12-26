package io.ktor.utils.io;

import java.nio.CharBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSuspendSession;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {2036}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "this_$iv", "$this$readLineLoop$iv", "out$iv", "ca$iv", "cb$iv", "required$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$1"})
/* compiled from: ByteBufferChannel.kt */
final class ByteBufferChannel$readUTF8LineToUtf8Suspend$2 extends SuspendLambda implements Function2<LookAheadSuspendSession, Continuation<? super Unit>, Object> {
    final /* synthetic */ char[] $ca;
    final /* synthetic */ CharBuffer $cb;
    final /* synthetic */ int $consumed0;
    final /* synthetic */ Ref.IntRef $consumed1;
    final /* synthetic */ int $limit;
    final /* synthetic */ Appendable $out;
    final /* synthetic */ Ref.BooleanRef $result;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$readUTF8LineToUtf8Suspend$2(ByteBufferChannel byteBufferChannel, Appendable appendable, char[] cArr, CharBuffer charBuffer, Ref.IntRef intRef, int i, Ref.BooleanRef booleanRef, int i2, Continuation<? super ByteBufferChannel$readUTF8LineToUtf8Suspend$2> continuation) {
        super(2, continuation);
        this.this$0 = byteBufferChannel;
        this.$out = appendable;
        this.$ca = cArr;
        this.$cb = charBuffer;
        this.$consumed1 = intRef;
        this.$consumed0 = i;
        this.$result = booleanRef;
        this.$limit = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> byteBufferChannel$readUTF8LineToUtf8Suspend$2 = new ByteBufferChannel$readUTF8LineToUtf8Suspend$2(this.this$0, this.$out, this.$ca, this.$cb, this.$consumed1, this.$consumed0, this.$result, this.$limit, continuation);
        byteBufferChannel$readUTF8LineToUtf8Suspend$2.L$0 = obj;
        return (Continuation) byteBufferChannel$readUTF8LineToUtf8Suspend$2;
    }

    public final Object invoke(LookAheadSuspendSession lookAheadSuspendSession, Continuation<? super Unit> continuation) {
        return create(lookAheadSuspendSession, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00cb A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            int r2 = r0.I$1
            int r4 = r0.I$0
            java.lang.Object r5 = r0.L$8
            kotlin.jvm.internal.Ref$IntRef r5 = (kotlin.jvm.internal.Ref.IntRef) r5
            java.lang.Object r6 = r0.L$7
            char[] r6 = (char[]) r6
            java.lang.Object r7 = r0.L$6
            kotlin.jvm.internal.Ref$IntRef r7 = (kotlin.jvm.internal.Ref.IntRef) r7
            java.lang.Object r8 = r0.L$5
            java.nio.CharBuffer r8 = (java.nio.CharBuffer) r8
            java.lang.Object r9 = r0.L$4
            char[] r9 = (char[]) r9
            java.lang.Object r10 = r0.L$3
            java.lang.Appendable r10 = (java.lang.Appendable) r10
            java.lang.Object r11 = r0.L$2
            io.ktor.utils.io.LookAheadSession r11 = (io.ktor.utils.io.LookAheadSession) r11
            java.lang.Object r12 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r12 = (io.ktor.utils.io.ByteBufferChannel) r12
            java.lang.Object r13 = r0.L$0
            io.ktor.utils.io.LookAheadSuspendSession r13 = (io.ktor.utils.io.LookAheadSuspendSession) r13
            kotlin.ResultKt.throwOnFailure(r20)
            r15 = r20
            r14 = r0
            goto L_0x0084
        L_0x003c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.LookAheadSuspendSession r2 = (io.ktor.utils.io.LookAheadSuspendSession) r2
            io.ktor.utils.io.ByteBufferChannel r4 = r0.this$0
            r5 = r2
            io.ktor.utils.io.LookAheadSession r5 = (io.ktor.utils.io.LookAheadSession) r5
            java.lang.Appendable r6 = r0.$out
            char[] r7 = r0.$ca
            java.nio.CharBuffer r8 = r0.$cb
            kotlin.jvm.internal.Ref$IntRef r9 = r0.$consumed1
            int r10 = r0.$limit
            r14 = r0
            r13 = r2
            r2 = r3
            r12 = r4
            r11 = r5
            r5 = r9
            r4 = r10
            r10 = r6
            r6 = r7
            r9 = r6
            r7 = r5
        L_0x0065:
            r14.L$0 = r13
            r14.L$1 = r12
            r14.L$2 = r11
            r14.L$3 = r10
            r14.L$4 = r9
            r14.L$5 = r8
            r14.L$6 = r7
            r14.L$7 = r6
            r14.L$8 = r5
            r14.I$0 = r4
            r14.I$1 = r2
            r14.label = r3
            java.lang.Object r15 = r13.awaitAtLeast(r2, r14)
            if (r15 != r1) goto L_0x0084
            return r1
        L_0x0084:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            r0 = 0
            if (r15 == 0) goto L_0x00fc
            java.nio.ByteBuffer r15 = r11.request(r0, r3)
            if (r15 != 0) goto L_0x0094
            goto L_0x00fc
        L_0x0094:
            int r16 = r15.position()
            int r3 = r15.remaining()
            if (r3 >= r2) goto L_0x00a1
            r12.rollBytes(r15, r2)
        L_0x00a1:
            int r2 = r6.length
            int r3 = r5.element
            int r3 = r4 - r3
            int r2 = java.lang.Math.min(r2, r3)
            long r2 = io.ktor.utils.io.charsets.UTFKt.decodeUTF8Line(r15, r6, r0, r2)
            int r17 = r15.position()
            int r0 = r17 - r16
            r11.consumed(r0)
            r0 = 32
            r16 = r1
            long r0 = r2 >> r0
            int r0 = (int) r0
            r17 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r1 = r2 & r17
            int r1 = (int) r1
            r2 = -1
            if (r1 != r2) goto L_0x00cb
            r2 = 0
            goto L_0x00da
        L_0x00cb:
            if (r1 != 0) goto L_0x00d4
            boolean r3 = r15.hasRemaining()
            if (r3 == 0) goto L_0x00d4
            goto L_0x00da
        L_0x00d4:
            r2 = 1
            int r1 = java.lang.Math.max(r2, r1)
            r2 = r1
        L_0x00da:
            int r1 = r7.element
            int r1 = r1 + r0
            r7.element = r1
            boolean r1 = r10 instanceof java.lang.StringBuilder
            if (r1 == 0) goto L_0x00eb
            r1 = r10
            java.lang.StringBuilder r1 = (java.lang.StringBuilder) r1
            r3 = 0
            r1.append(r9, r3, r0)
            goto L_0x00f2
        L_0x00eb:
            r3 = 0
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r10.append(r1, r3, r0)
        L_0x00f2:
            if (r2 > 0) goto L_0x00f5
            goto L_0x00fc
        L_0x00f5:
            r0 = r19
            r1 = r16
            r3 = 1
            goto L_0x0065
        L_0x00fc:
            if (r2 != 0) goto L_0x0100
            r0 = 1
            goto L_0x0101
        L_0x0100:
            r0 = 0
        L_0x0101:
            if (r0 != 0) goto L_0x0165
            io.ktor.utils.io.ByteBufferChannel r0 = r14.this$0
            boolean r0 = r0.isClosedForWrite()
            if (r0 != 0) goto L_0x010c
            goto L_0x0165
        L_0x010c:
            r0 = 0
            r1 = 1
            java.nio.ByteBuffer r2 = r13.request(r0, r1)
            if (r2 == 0) goto L_0x0153
            byte r0 = r2.get()
            r3 = 13
            byte r3 = (byte) r3
            if (r0 != r3) goto L_0x0142
            r13.consumed(r1)
            boolean r0 = r2.hasRemaining()
            if (r0 != 0) goto L_0x0127
            goto L_0x0162
        L_0x0127:
            io.ktor.utils.io.charsets.MalformedInputException r0 = new io.ktor.utils.io.charsets.MalformedInputException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Illegal trailing bytes: "
            r1.append(r3)
            int r2 = r2.remaining()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0142:
            int r0 = r2.position()
            r1 = 1
            int r0 = r0 - r1
            r2.position(r0)
            io.ktor.utils.io.charsets.TooLongLineException r0 = new io.ktor.utils.io.charsets.TooLongLineException
            java.lang.String r1 = "Line is longer than limit"
            r0.<init>(r1)
            throw r0
        L_0x0153:
            kotlin.jvm.internal.Ref$IntRef r0 = r14.$consumed1
            int r0 = r0.element
            if (r0 != 0) goto L_0x0162
            int r0 = r14.$consumed0
            if (r0 != 0) goto L_0x0162
            kotlin.jvm.internal.Ref$BooleanRef r0 = r14.$result
            r1 = 0
            r0.element = r1
        L_0x0162:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0165:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
