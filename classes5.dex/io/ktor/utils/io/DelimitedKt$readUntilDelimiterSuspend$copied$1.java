package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSuspendSession;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$copied$1", f = "Delimited.kt", i = {0, 0, 1, 1}, l = {79, 89}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "copied", "$this$lookAheadSuspend", "copied"}, s = {"L$0", "I$0", "L$0", "I$0"})
/* compiled from: Delimited.kt */
final class DelimitedKt$readUntilDelimiterSuspend$copied$1 extends SuspendLambda implements Function2<LookAheadSuspendSession, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $copied0;
    final /* synthetic */ ByteBuffer $delimiter;
    final /* synthetic */ ByteBuffer $dst;
    final /* synthetic */ Ref.BooleanRef $endFound;
    final /* synthetic */ ByteReadChannel $this_readUntilDelimiterSuspend;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelimitedKt$readUntilDelimiterSuspend$copied$1(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, Ref.BooleanRef booleanRef, ByteReadChannel byteReadChannel, Continuation<? super DelimitedKt$readUntilDelimiterSuspend$copied$1> continuation) {
        super(2, continuation);
        this.$copied0 = i;
        this.$delimiter = byteBuffer;
        this.$dst = byteBuffer2;
        this.$endFound = booleanRef;
        this.$this_readUntilDelimiterSuspend = byteReadChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> delimitedKt$readUntilDelimiterSuspend$copied$1 = new DelimitedKt$readUntilDelimiterSuspend$copied$1(this.$copied0, this.$delimiter, this.$dst, this.$endFound, this.$this_readUntilDelimiterSuspend, continuation);
        delimitedKt$readUntilDelimiterSuspend$copied$1.L$0 = obj;
        return (Continuation) delimitedKt$readUntilDelimiterSuspend$copied$1;
    }

    public final Object invoke(LookAheadSuspendSession lookAheadSuspendSession, Continuation<? super Integer> continuation) {
        return create(lookAheadSuspendSession, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a2, code lost:
        if (r4.$endFound.element == false) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002d
            if (r1 == r3) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            int r1 = r9.I$0
            java.lang.Object r4 = r9.L$0
            io.ktor.utils.io.LookAheadSuspendSession r4 = (io.ktor.utils.io.LookAheadSuspendSession) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            goto L_0x0089
        L_0x001a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0022:
            int r1 = r9.I$0
            java.lang.Object r4 = r9.L$0
            io.ktor.utils.io.LookAheadSuspendSession r4 = (io.ktor.utils.io.LookAheadSuspendSession) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            goto L_0x004a
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            io.ktor.utils.io.LookAheadSuspendSession r10 = (io.ktor.utils.io.LookAheadSuspendSession) r10
            int r1 = r9.$copied0
            r4 = r9
        L_0x0037:
            r5 = r4
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r4.L$0 = r10
            r4.I$0 = r1
            r4.label = r3
            java.lang.Object r5 = r10.awaitAtLeast(r3, r5)
            if (r5 != r0) goto L_0x0047
            return r0
        L_0x0047:
            r8 = r4
            r4 = r10
            r10 = r8
        L_0x004a:
            r5 = r4
            io.ktor.utils.io.LookAheadSession r5 = (io.ktor.utils.io.LookAheadSession) r5
            java.nio.ByteBuffer r6 = r10.$delimiter
            java.nio.ByteBuffer r7 = r10.$dst
            int r6 = io.ktor.utils.io.DelimitedKt.tryCopyUntilDelimiter(r5, r6, r7)
            if (r6 != 0) goto L_0x008d
            java.nio.ByteBuffer r6 = r10.$delimiter
            int r5 = io.ktor.utils.io.DelimitedKt.startsWithDelimiter(r5, r6)
            java.nio.ByteBuffer r6 = r10.$delimiter
            int r6 = r6.remaining()
            if (r5 != r6) goto L_0x006a
            kotlin.jvm.internal.Ref$BooleanRef r10 = r10.$endFound
            r10.element = r3
            goto L_0x00a4
        L_0x006a:
            io.ktor.utils.io.ByteReadChannel r5 = r10.$this_readUntilDelimiterSuspend
            boolean r5 = r5.isClosedForWrite()
            if (r5 == 0) goto L_0x0073
            goto L_0x00a4
        L_0x0073:
            java.nio.ByteBuffer r5 = r10.$delimiter
            int r5 = r5.remaining()
            r6 = r10
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r10.L$0 = r4
            r10.I$0 = r1
            r10.label = r2
            java.lang.Object r5 = r4.awaitAtLeast(r5, r6)
            if (r5 != r0) goto L_0x0089
            return r0
        L_0x0089:
            r8 = r4
            r4 = r10
            r10 = r8
            goto L_0x0096
        L_0x008d:
            if (r6 > 0) goto L_0x0094
            kotlin.jvm.internal.Ref$BooleanRef r5 = r10.$endFound
            r5.element = r3
            int r6 = -r6
        L_0x0094:
            int r1 = r1 + r6
            goto L_0x0089
        L_0x0096:
            java.nio.ByteBuffer r5 = r4.$dst
            boolean r5 = r5.hasRemaining()
            if (r5 == 0) goto L_0x00a4
            kotlin.jvm.internal.Ref$BooleanRef r5 = r4.$endFound
            boolean r5 = r5.element
            if (r5 == 0) goto L_0x0037
        L_0x00a4:
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$copied$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
