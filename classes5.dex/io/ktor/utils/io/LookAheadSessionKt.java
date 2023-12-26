package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\bø\u0001\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bHHø\u0001\u0001¢\u0006\u0002\u0010\u000b\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"consumeEachRemaining", "", "Lio/ktor/utils/io/LookAheadSession;", "visitor", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/utils/io/LookAheadSuspendSession;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LookAheadSession.kt */
public final class LookAheadSessionKt {
    public static final void consumeEachRemaining(LookAheadSession lookAheadSession, Function1<? super ByteBuffer, Boolean> function1) {
        boolean z;
        Intrinsics.checkNotNullParameter(lookAheadSession, "<this>");
        Intrinsics.checkNotNullParameter(function1, "visitor");
        do {
            z = false;
            ByteBuffer request = lookAheadSession.request(0, 1);
            if (request != null) {
                int remaining = request.remaining();
                boolean booleanValue = ((Boolean) function1.invoke(request)).booleanValue();
                lookAheadSession.consumed(remaining);
                z = booleanValue;
                continue;
            }
        } while (z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object consumeEachRemaining(io.ktor.utils.io.LookAheadSuspendSession r6, kotlin.jvm.functions.Function2<? super java.nio.ByteBuffer, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.LookAheadSessionKt$consumeEachRemaining$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.LookAheadSessionKt$consumeEachRemaining$1 r0 = (io.ktor.utils.io.LookAheadSessionKt$consumeEachRemaining$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.LookAheadSessionKt$consumeEachRemaining$1 r0 = new io.ktor.utils.io.LookAheadSessionKt$consumeEachRemaining$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004b
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.LookAheadSuspendSession r2 = (io.ktor.utils.io.LookAheadSuspendSession) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0087
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003f:
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.LookAheadSuspendSession r7 = (io.ktor.utils.io.LookAheadSuspendSession) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0065
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x004e:
            r8 = 0
            java.nio.ByteBuffer r8 = r6.request(r8, r4)
            if (r8 != 0) goto L_0x0071
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r6.awaitAtLeast(r4, r0)
            if (r8 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0065:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0094
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x004e
        L_0x0071:
            int r2 = r8.remaining()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.invoke(r8, r0)
            if (r8 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0087:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r2.consumed(r6)
            if (r8 == 0) goto L_0x0094
            r6 = r2
            goto L_0x004e
        L_0x0094:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.LookAheadSessionKt.consumeEachRemaining(io.ktor.utils.io.LookAheadSuspendSession, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object consumeEachRemaining$$forInline(LookAheadSuspendSession lookAheadSuspendSession, Function2<? super ByteBuffer, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        while (true) {
            ByteBuffer request = lookAheadSuspendSession.request(0, 1);
            if (request != null) {
                int remaining = request.remaining();
                boolean booleanValue = ((Boolean) function2.invoke(request, continuation)).booleanValue();
                lookAheadSuspendSession.consumed(remaining);
                if (!booleanValue) {
                    break;
                }
            } else {
                InlineMarker.mark(0);
                Object awaitAtLeast = lookAheadSuspendSession.awaitAtLeast(1, continuation);
                InlineMarker.mark(1);
                if (!((Boolean) awaitAtLeast).booleanValue()) {
                    break;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
