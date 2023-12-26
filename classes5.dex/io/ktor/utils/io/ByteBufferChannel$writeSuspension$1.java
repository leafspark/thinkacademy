package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "ucont", "Lkotlin/coroutines/Continuation;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteBufferChannel.kt */
final class ByteBufferChannel$writeSuspension$1 extends Lambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$writeSuspension$1(ByteBufferChannel byteBufferChannel) {
        super(1);
        this.this$0 = byteBufferChannel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006b, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "ucont"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            io.ktor.utils.io.ByteBufferChannel r0 = r8.this$0
            int r0 = r0.writeSuspensionSize
        L_0x000b:
            io.ktor.utils.io.ByteBufferChannel r1 = r8.this$0
            io.ktor.utils.io.internal.ClosedElement r1 = r1.getClosed()
            if (r1 == 0) goto L_0x0023
            java.lang.Throwable r1 = r1.getSendException()
            if (r1 != 0) goto L_0x001a
            goto L_0x0023
        L_0x001a:
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.rethrowClosed(r1)
            kotlin.KotlinNothingValueException r9 = new kotlin.KotlinNothingValueException
            r9.<init>()
            throw r9
        L_0x0023:
            io.ktor.utils.io.ByteBufferChannel r1 = r8.this$0
            boolean r1 = r1.writeSuspendPredicate(r0)
            if (r1 != 0) goto L_0x0037
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            java.lang.Object r1 = kotlin.Result.m320constructorimpl(r1)
            r9.resumeWith(r1)
            goto L_0x006d
        L_0x0037:
            io.ktor.utils.io.ByteBufferChannel r1 = r8.this$0
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r9)
            io.ktor.utils.io.ByteBufferChannel r3 = r8.this$0
        L_0x003f:
            kotlin.coroutines.Continuation r4 = r1.getWriteOp()
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x0049
            r4 = r5
            goto L_0x004a
        L_0x0049:
            r4 = r6
        L_0x004a:
            if (r4 == 0) goto L_0x0084
            boolean r4 = r3.writeSuspendPredicate(r0)
            if (r4 != 0) goto L_0x0054
        L_0x0052:
            r5 = r6
            goto L_0x006b
        L_0x0054:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = io.ktor.utils.io.ByteBufferChannel._writeOp$FU
            r7 = 0
            boolean r4 = r4.compareAndSet(r1, r7, r2)
            if (r4 == 0) goto L_0x003f
            boolean r3 = r3.writeSuspendPredicate(r0)
            if (r3 != 0) goto L_0x006b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = io.ktor.utils.io.ByteBufferChannel._writeOp$FU
            boolean r1 = r3.compareAndSet(r1, r2, r7)
            if (r1 != 0) goto L_0x0052
        L_0x006b:
            if (r5 == 0) goto L_0x000b
        L_0x006d:
            io.ktor.utils.io.ByteBufferChannel r9 = r8.this$0
            r9.flushImpl(r0)
            io.ktor.utils.io.ByteBufferChannel r9 = r8.this$0
            boolean r9 = r9.shouldResumeReadOp()
            if (r9 == 0) goto L_0x007f
            io.ktor.utils.io.ByteBufferChannel r9 = r8.this$0
            r9.resumeReadOp()
        L_0x007f:
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            return r9
        L_0x0084:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "Operation is already in progress"
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel$writeSuspension$1.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
