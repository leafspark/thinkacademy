package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1", f = "ByteChannels.kt", i = {0, 1, 1, 1}, l = {24, 28}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$0", "L$1", "I$0"})
/* compiled from: ByteChannels.kt */
final class ByteChannelsKt$split$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteChannel $first;
    final /* synthetic */ ByteChannel $second;
    final /* synthetic */ ByteReadChannel $this_split;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteChannelsKt$split$1(ByteReadChannel byteReadChannel, ByteChannel byteChannel, ByteChannel byteChannel2, Continuation<? super ByteChannelsKt$split$1> continuation) {
        super(2, continuation);
        this.$this_split = byteReadChannel;
        this.$first = byteChannel;
        this.$second = byteChannel2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> byteChannelsKt$split$1 = new ByteChannelsKt$split$1(this.$this_split, this.$first, this.$second, continuation);
        byteChannelsKt$split$1.L$0 = obj;
        return (Continuation) byteChannelsKt$split$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r5) goto L_0x002e
            if (r2 != r4) goto L_0x0026
            java.lang.Object r2 = r1.L$1
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r6 = r1.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x0021 }
            r8 = r20
            r7 = r1
            goto L_0x00b4
        L_0x0021:
            r0 = move-exception
            r3 = r0
            r6 = r1
            goto L_0x00c6
        L_0x0026:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x002e:
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x0039 }
            r7 = r20
            r6 = r1
            goto L_0x0061
        L_0x0039:
            r0 = move-exception
            r6 = r1
            goto L_0x00eb
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            r6 = r1
        L_0x0045:
            io.ktor.utils.io.ByteReadChannel r7 = r6.$this_split     // Catch:{ all -> 0x00ea }
            boolean r7 = r7.isClosedForRead()     // Catch:{ all -> 0x00ea }
            if (r7 != 0) goto L_0x00d2
            io.ktor.utils.io.ByteReadChannel r7 = r6.$this_split     // Catch:{ all -> 0x00ea }
            r8 = 4096(0x1000, double:2.0237E-320)
            r10 = r6
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch:{ all -> 0x00ea }
            r6.L$0 = r2     // Catch:{ all -> 0x00ea }
            r6.L$1 = r3     // Catch:{ all -> 0x00ea }
            r6.label = r5     // Catch:{ all -> 0x00ea }
            java.lang.Object r7 = r7.readRemaining(r8, r10)     // Catch:{ all -> 0x00ea }
            if (r7 != r0) goto L_0x0061
            return r0
        L_0x0061:
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ all -> 0x00ea }
            io.ktor.utils.io.ByteChannel r8 = r6.$first     // Catch:{ all -> 0x00ea }
            io.ktor.utils.io.ByteChannel r14 = r6.$second     // Catch:{ all -> 0x00ea }
            r15 = r7
            io.ktor.utils.io.core.ByteReadPacket r15 = (io.ktor.utils.io.core.ByteReadPacket) r15     // Catch:{ all -> 0x00c3 }
            kotlinx.coroutines.Deferred[] r13 = new kotlinx.coroutines.Deferred[r4]     // Catch:{ all -> 0x00c3 }
            r9 = 0
            r10 = 0
            io.ktor.util.ByteChannelsKt$split$1$1$1 r11 = new io.ktor.util.ByteChannelsKt$split$1$1$1     // Catch:{ all -> 0x00c3 }
            r11.<init>(r8, r15, r3)     // Catch:{ all -> 0x00c3 }
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch:{ all -> 0x00c3 }
            r12 = 3
            r16 = 0
            r8 = r2
            r17 = r13
            r13 = r16
            kotlinx.coroutines.Deferred r8 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00c3 }
            r13 = 0
            r17[r13] = r8     // Catch:{ all -> 0x00c3 }
            r9 = 0
            r10 = 0
            io.ktor.util.ByteChannelsKt$split$1$1$2 r8 = new io.ktor.util.ByteChannelsKt$split$1$1$2     // Catch:{ all -> 0x00c3 }
            r8.<init>(r14, r15, r3)     // Catch:{ all -> 0x00c3 }
            r11 = r8
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch:{ all -> 0x00c3 }
            r12 = 3
            r14 = 0
            r8 = r2
            r15 = r13
            r13 = r14
            kotlinx.coroutines.Deferred r8 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00c3 }
            r17[r5] = r8     // Catch:{ all -> 0x00c3 }
            java.util.List r8 = kotlin.collections.CollectionsKt.listOf(r17)     // Catch:{ all -> 0x00c3 }
            java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x00c3 }
            r6.L$0 = r2     // Catch:{ all -> 0x00c3 }
            r6.L$1 = r7     // Catch:{ all -> 0x00c3 }
            r6.I$0 = r15     // Catch:{ all -> 0x00c3 }
            r6.label = r4     // Catch:{ all -> 0x00c3 }
            java.lang.Object r8 = kotlinx.coroutines.AwaitKt.awaitAll(r8, r6)     // Catch:{ all -> 0x00c3 }
            if (r8 != r0) goto L_0x00ae
            return r0
        L_0x00ae:
            r18 = r6
            r6 = r2
            r2 = r7
            r7 = r18
        L_0x00b4:
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x00bf }
            r2.close()     // Catch:{ all -> 0x00bc }
            r2 = r6
            r6 = r7
            goto L_0x0045
        L_0x00bc:
            r0 = move-exception
            r6 = r7
            goto L_0x00eb
        L_0x00bf:
            r0 = move-exception
            r3 = r0
            r6 = r7
            goto L_0x00c6
        L_0x00c3:
            r0 = move-exception
            r3 = r0
            r2 = r7
        L_0x00c6:
            r2.close()     // Catch:{ all -> 0x00ca }
            goto L_0x00cf
        L_0x00ca:
            r0 = move-exception
            r2 = r0
            io.ktor.utils.io.core.CloseableJVMKt.addSuppressedInternal(r3, r2)     // Catch:{ all -> 0x00d0 }
        L_0x00cf:
            throw r3     // Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00ea }
        L_0x00d2:
            io.ktor.utils.io.ByteReadChannel r0 = r6.$this_split     // Catch:{ all -> 0x00ea }
            java.lang.Throwable r0 = r0.getClosedCause()     // Catch:{ all -> 0x00ea }
            if (r0 != 0) goto L_0x00e9
        L_0x00da:
            io.ktor.utils.io.ByteChannel r0 = r6.$first
            io.ktor.utils.io.ByteWriteChannel r0 = (io.ktor.utils.io.ByteWriteChannel) r0
            io.ktor.utils.io.ByteWriteChannelKt.close(r0)
            io.ktor.utils.io.ByteChannel r0 = r6.$second
            io.ktor.utils.io.ByteWriteChannel r0 = (io.ktor.utils.io.ByteWriteChannel) r0
            io.ktor.utils.io.ByteWriteChannelKt.close(r0)
            goto L_0x00fb
        L_0x00e9:
            throw r0     // Catch:{ all -> 0x00ea }
        L_0x00ea:
            r0 = move-exception
        L_0x00eb:
            io.ktor.utils.io.ByteReadChannel r2 = r6.$this_split     // Catch:{ all -> 0x00fe }
            r2.cancel(r0)     // Catch:{ all -> 0x00fe }
            io.ktor.utils.io.ByteChannel r2 = r6.$first     // Catch:{ all -> 0x00fe }
            r2.cancel(r0)     // Catch:{ all -> 0x00fe }
            io.ktor.utils.io.ByteChannel r2 = r6.$second     // Catch:{ all -> 0x00fe }
            r2.cancel(r0)     // Catch:{ all -> 0x00fe }
            goto L_0x00da
        L_0x00fb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00fe:
            r0 = move-exception
            io.ktor.utils.io.ByteChannel r2 = r6.$first
            io.ktor.utils.io.ByteWriteChannel r2 = (io.ktor.utils.io.ByteWriteChannel) r2
            io.ktor.utils.io.ByteWriteChannelKt.close(r2)
            io.ktor.utils.io.ByteChannel r2 = r6.$second
            io.ktor.utils.io.ByteWriteChannel r2 = (io.ktor.utils.io.ByteWriteChannel) r2
            io.ktor.utils.io.ByteWriteChannelKt.close(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt$split$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
