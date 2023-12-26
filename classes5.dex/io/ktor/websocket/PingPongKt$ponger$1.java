package io.ktor.websocket;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$ponger$1", f = "PingPong.kt", i = {0, 1}, l = {110, 31}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$1", "L$1"})
/* compiled from: PingPong.kt */
final class PingPongKt$ponger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Ping> $channel;
    final /* synthetic */ SendChannel<Frame.Pong> $outgoing;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PingPongKt$ponger$1(Channel<Frame.Ping> channel, SendChannel<? super Frame.Pong> sendChannel, Continuation<? super PingPongKt$ponger$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$outgoing = sendChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new PingPongKt$ponger$1(this.$channel, this.$outgoing, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008f, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058 A[Catch:{ all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065 A[Catch:{ all -> 0x008b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L_0x003a
            if (r1 == r2) goto L_0x0027
            if (r1 != r3) goto L_0x001f
            java.lang.Object r1 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0038 }
            r11 = r5
            goto L_0x0048
        L_0x001f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0027:
            java.lang.Object r1 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r10.L$1
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r10.L$0
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0038 }
            r6 = r10
            goto L_0x005c
        L_0x0038:
            r11 = move-exception
            goto L_0x008a
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame$Ping> r11 = r10.$channel     // Catch:{ ClosedSendChannelException -> 0x0090 }
            r4 = r11
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4     // Catch:{ ClosedSendChannelException -> 0x0090 }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Pong> r11 = r10.$outgoing     // Catch:{ ClosedSendChannelException -> 0x0090 }
            kotlinx.coroutines.channels.ChannelIterator r1 = r4.iterator()     // Catch:{ all -> 0x0038 }
        L_0x0048:
            r5 = r10
        L_0x0049:
            r5.L$0 = r11     // Catch:{ all -> 0x0038 }
            r5.L$1 = r4     // Catch:{ all -> 0x0038 }
            r5.L$2 = r1     // Catch:{ all -> 0x0038 }
            r5.label = r2     // Catch:{ all -> 0x0038 }
            java.lang.Object r6 = r1.hasNext(r5)     // Catch:{ all -> 0x0038 }
            if (r6 != r0) goto L_0x0058
            return r0
        L_0x0058:
            r9 = r5
            r5 = r11
            r11 = r6
            r6 = r9
        L_0x005c:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0038 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0038 }
            r7 = 0
            if (r11 == 0) goto L_0x0086
            java.lang.Object r11 = r1.next()     // Catch:{ all -> 0x0038 }
            io.ktor.websocket.Frame$Ping r11 = (io.ktor.websocket.Frame.Ping) r11     // Catch:{ all -> 0x0038 }
            io.ktor.websocket.Frame$Pong r8 = new io.ktor.websocket.Frame$Pong     // Catch:{ all -> 0x0038 }
            byte[] r11 = r11.getData()     // Catch:{ all -> 0x0038 }
            r8.<init>((byte[]) r11, (kotlinx.coroutines.DisposableHandle) r7, (int) r3, (kotlin.jvm.internal.DefaultConstructorMarker) r7)     // Catch:{ all -> 0x0038 }
            r6.L$0 = r5     // Catch:{ all -> 0x0038 }
            r6.L$1 = r4     // Catch:{ all -> 0x0038 }
            r6.L$2 = r1     // Catch:{ all -> 0x0038 }
            r6.label = r3     // Catch:{ all -> 0x0038 }
            java.lang.Object r11 = r5.send(r8, r6)     // Catch:{ all -> 0x0038 }
            if (r11 != r0) goto L_0x0083
            return r0
        L_0x0083:
            r11 = r5
            r5 = r6
            goto L_0x0049
        L_0x0086:
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r7)     // Catch:{ ClosedSendChannelException -> 0x0090 }
            goto L_0x0090
        L_0x008a:
            throw r11     // Catch:{ all -> 0x008b }
        L_0x008b:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r11)     // Catch:{ ClosedSendChannelException -> 0x0090 }
            throw r0     // Catch:{ ClosedSendChannelException -> 0x0090 }
        L_0x0090:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt$ponger$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
