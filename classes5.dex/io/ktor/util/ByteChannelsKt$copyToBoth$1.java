package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", i = {0, 1, 1, 1, 1, 2, 2, 2}, l = {58, 60, 61}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$use$iv", "it", "closed$iv", "$this$launch", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$0", "L$1", "L$5", "I$0", "L$0", "L$1", "I$0"})
/* compiled from: ByteChannels.kt */
final class ByteChannelsKt$copyToBoth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteWriteChannel $first;
    final /* synthetic */ ByteWriteChannel $second;
    final /* synthetic */ ByteReadChannel $this_copyToBoth;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteChannelsKt$copyToBoth$1(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, Continuation<? super ByteChannelsKt$copyToBoth$1> continuation) {
        super(2, continuation);
        this.$this_copyToBoth = byteReadChannel;
        this.$first = byteWriteChannel;
        this.$second = byteWriteChannel2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> byteChannelsKt$copyToBoth$1 = new ByteChannelsKt$copyToBoth$1(this.$this_copyToBoth, this.$first, this.$second, continuation);
        byteChannelsKt$copyToBoth$1.L$0 = obj;
        return (Continuation) byteChannelsKt$copyToBoth$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:37|39|40|41|42|(1:44)|45|(0)|48|49|55|56) */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fc, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fd, code lost:
        r13 = r1;
        r1 = r15;
        r15 = r10;
        r10 = r8;
        r8 = r6;
        r6 = r13;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097 A[Catch:{ all -> 0x0141 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00dc A[Catch:{ all -> 0x00fc }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f7 A[Catch:{ all -> 0x00fc }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0128 A[Catch:{ all -> 0x0141 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0077
            if (r1 == r4) goto L_0x0069
            if (r1 == r3) goto L_0x003b
            if (r1 != r2) goto L_0x0033
            java.lang.Object r1 = r14.L$4
            io.ktor.utils.io.ByteReadChannel r1 = (io.ktor.utils.io.ByteReadChannel) r1
            java.lang.Object r6 = r14.L$3
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            java.lang.Object r7 = r14.L$2
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            java.lang.Object r8 = r14.L$1
            java.io.Closeable r8 = (java.io.Closeable) r8
            java.lang.Object r9 = r14.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x002d }
            r15 = r1
            r1 = r14
            goto L_0x00f8
        L_0x002d:
            r15 = move-exception
            r10 = r8
            r8 = r6
            r6 = r14
            goto L_0x0103
        L_0x0033:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x003b:
            int r1 = r14.I$0
            java.lang.Object r6 = r14.L$5
            io.ktor.utils.io.core.ByteReadPacket r6 = (io.ktor.utils.io.core.ByteReadPacket) r6
            java.lang.Object r7 = r14.L$4
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            java.lang.Object r8 = r14.L$3
            io.ktor.utils.io.ByteWriteChannel r8 = (io.ktor.utils.io.ByteWriteChannel) r8
            java.lang.Object r9 = r14.L$2
            io.ktor.utils.io.ByteWriteChannel r9 = (io.ktor.utils.io.ByteWriteChannel) r9
            java.lang.Object r10 = r14.L$1
            java.io.Closeable r10 = (java.io.Closeable) r10
            java.lang.Object r11 = r14.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0062 }
            r15 = r7
            r7 = r9
            r9 = r11
            r11 = r6
            r6 = r8
            r8 = r10
            r10 = r1
            r1 = r14
            goto L_0x00dd
        L_0x0062:
            r15 = move-exception
            r6 = r14
            r1 = r7
            r7 = r9
            r9 = r11
            goto L_0x0103
        L_0x0069:
            java.lang.Object r1 = r14.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0073 }
            r9 = r1
            r1 = r14
            goto L_0x00b5
        L_0x0073:
            r15 = move-exception
            r1 = r14
            goto L_0x0142
        L_0x0077:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            kotlinx.coroutines.CoroutineScope r15 = (kotlinx.coroutines.CoroutineScope) r15
            r1 = r14
        L_0x007f:
            io.ktor.utils.io.ByteReadChannel r6 = r1.$this_copyToBoth     // Catch:{ all -> 0x0141 }
            boolean r6 = r6.isClosedForRead()     // Catch:{ all -> 0x0141 }
            if (r6 != 0) goto L_0x0128
            io.ktor.utils.io.ByteWriteChannel r6 = r1.$first     // Catch:{ all -> 0x0141 }
            boolean r6 = r6.isClosedForWrite()     // Catch:{ all -> 0x0141 }
            if (r6 == 0) goto L_0x0097
            io.ktor.utils.io.ByteWriteChannel r6 = r1.$second     // Catch:{ all -> 0x0141 }
            boolean r6 = r6.isClosedForWrite()     // Catch:{ all -> 0x0141 }
            if (r6 != 0) goto L_0x0128
        L_0x0097:
            io.ktor.utils.io.ByteReadChannel r6 = r1.$this_copyToBoth     // Catch:{ all -> 0x0141 }
            r7 = 4096(0x1000, double:2.0237E-320)
            r9 = r1
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ all -> 0x0141 }
            r1.L$0 = r15     // Catch:{ all -> 0x0141 }
            r1.L$1 = r5     // Catch:{ all -> 0x0141 }
            r1.L$2 = r5     // Catch:{ all -> 0x0141 }
            r1.L$3 = r5     // Catch:{ all -> 0x0141 }
            r1.L$4 = r5     // Catch:{ all -> 0x0141 }
            r1.L$5 = r5     // Catch:{ all -> 0x0141 }
            r1.label = r4     // Catch:{ all -> 0x0141 }
            java.lang.Object r6 = r6.readRemaining(r7, r9)     // Catch:{ all -> 0x0141 }
            if (r6 != r0) goto L_0x00b3
            return r0
        L_0x00b3:
            r9 = r15
            r15 = r6
        L_0x00b5:
            r8 = r15
            java.io.Closeable r8 = (java.io.Closeable) r8     // Catch:{ all -> 0x0141 }
            io.ktor.utils.io.ByteWriteChannel r7 = r1.$first     // Catch:{ all -> 0x0141 }
            io.ktor.utils.io.ByteWriteChannel r6 = r1.$second     // Catch:{ all -> 0x0141 }
            io.ktor.utils.io.ByteReadChannel r15 = r1.$this_copyToBoth     // Catch:{ all -> 0x0141 }
            r10 = 0
            r11 = r8
            io.ktor.utils.io.core.ByteReadPacket r11 = (io.ktor.utils.io.core.ByteReadPacket) r11     // Catch:{ all -> 0x011c }
            io.ktor.utils.io.core.ByteReadPacket r12 = r11.copy()     // Catch:{ all -> 0x00fc }
            r1.L$0 = r9     // Catch:{ all -> 0x00fc }
            r1.L$1 = r8     // Catch:{ all -> 0x00fc }
            r1.L$2 = r7     // Catch:{ all -> 0x00fc }
            r1.L$3 = r6     // Catch:{ all -> 0x00fc }
            r1.L$4 = r15     // Catch:{ all -> 0x00fc }
            r1.L$5 = r11     // Catch:{ all -> 0x00fc }
            r1.I$0 = r10     // Catch:{ all -> 0x00fc }
            r1.label = r3     // Catch:{ all -> 0x00fc }
            java.lang.Object r12 = r7.writePacket(r12, r1)     // Catch:{ all -> 0x00fc }
            if (r12 != r0) goto L_0x00dd
            return r0
        L_0x00dd:
            io.ktor.utils.io.core.ByteReadPacket r11 = r11.copy()     // Catch:{ all -> 0x00fc }
            r1.L$0 = r9     // Catch:{ all -> 0x00fc }
            r1.L$1 = r8     // Catch:{ all -> 0x00fc }
            r1.L$2 = r7     // Catch:{ all -> 0x00fc }
            r1.L$3 = r6     // Catch:{ all -> 0x00fc }
            r1.L$4 = r15     // Catch:{ all -> 0x00fc }
            r1.L$5 = r5     // Catch:{ all -> 0x00fc }
            r1.I$0 = r10     // Catch:{ all -> 0x00fc }
            r1.label = r2     // Catch:{ all -> 0x00fc }
            java.lang.Object r10 = r6.writePacket(r11, r1)     // Catch:{ all -> 0x00fc }
            if (r10 != r0) goto L_0x00f8
            return r0
        L_0x00f8:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00fc }
            r15 = r9
            goto L_0x0113
        L_0x00fc:
            r10 = move-exception
            r13 = r1
            r1 = r15
            r15 = r10
            r10 = r8
            r8 = r6
            r6 = r13
        L_0x0103:
            r1.cancel(r15)     // Catch:{ all -> 0x0118 }
            r7.close(r15)     // Catch:{ all -> 0x0118 }
            boolean r15 = r8.close(r15)     // Catch:{ all -> 0x0118 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r15)     // Catch:{ all -> 0x0118 }
            r1 = r6
            r15 = r9
            r8 = r10
        L_0x0113:
            r8.close()     // Catch:{ all -> 0x0141 }
            goto L_0x007f
        L_0x0118:
            r15 = move-exception
            r1 = r6
            r8 = r10
            goto L_0x011d
        L_0x011c:
            r15 = move-exception
        L_0x011d:
            r8.close()     // Catch:{ all -> 0x0121 }
            goto L_0x0125
        L_0x0121:
            r0 = move-exception
            io.ktor.utils.io.core.CloseableJVMKt.addSuppressedInternal(r15, r0)     // Catch:{ all -> 0x0126 }
        L_0x0125:
            throw r15     // Catch:{ all -> 0x0126 }
        L_0x0126:
            r15 = move-exception
            throw r15     // Catch:{ all -> 0x0141 }
        L_0x0128:
            boolean r0 = r15 instanceof io.ktor.utils.io.ByteChannel     // Catch:{ all -> 0x0141 }
            if (r0 == 0) goto L_0x0136
            io.ktor.utils.io.ByteChannel r15 = (io.ktor.utils.io.ByteChannel) r15     // Catch:{ all -> 0x0141 }
            java.lang.Throwable r15 = r15.getClosedCause()     // Catch:{ all -> 0x0141 }
            if (r15 != 0) goto L_0x0135
            goto L_0x0136
        L_0x0135:
            throw r15     // Catch:{ all -> 0x0141 }
        L_0x0136:
            io.ktor.utils.io.ByteWriteChannel r15 = r1.$first
            io.ktor.utils.io.ByteWriteChannelKt.close(r15)
            io.ktor.utils.io.ByteWriteChannel r15 = r1.$second
            io.ktor.utils.io.ByteWriteChannelKt.close(r15)
            goto L_0x014d
        L_0x0141:
            r15 = move-exception
        L_0x0142:
            io.ktor.utils.io.ByteWriteChannel r0 = r1.$first     // Catch:{ all -> 0x0150 }
            r0.close(r15)     // Catch:{ all -> 0x0150 }
            io.ktor.utils.io.ByteWriteChannel r0 = r1.$second     // Catch:{ all -> 0x0150 }
            r0.close(r15)     // Catch:{ all -> 0x0150 }
            goto L_0x0136
        L_0x014d:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x0150:
            r15 = move-exception
            io.ktor.utils.io.ByteWriteChannel r0 = r1.$first
            io.ktor.utils.io.ByteWriteChannelKt.close(r0)
            io.ktor.utils.io.ByteWriteChannel r0 = r1.$second
            io.ktor.utils.io.ByteWriteChannelKt.close(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt$copyToBoth$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
