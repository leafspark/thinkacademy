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
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1", f = "PingPong.kt", i = {0, 0, 1, 1}, l = {61, 70, 86}, m = "invokeSuspend", n = {"random", "pingIdBytes", "random", "pingIdBytes"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: PingPong.kt */
final class PingPongKt$pinger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Pong> $channel;
    final /* synthetic */ SendChannel<Frame> $outgoing;
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ long $timeoutMillis;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PingPongKt$pinger$1(long j, long j2, SendChannel<? super Frame> sendChannel, Channel<Frame.Pong> channel, Continuation<? super PingPongKt$pinger$1> continuation) {
        super(2, continuation);
        this.$periodMillis = j;
        this.$timeoutMillis = j2;
        this.$outgoing = sendChannel;
        this.$channel = channel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new PingPongKt$pinger$1(this.$periodMillis, this.$timeoutMillis, this.$outgoing, this.$channel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a2 A[Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c9  */
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
            if (r1 == 0) goto L_0x003a
            if (r1 == r4) goto L_0x002d
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            goto L_0x00cd
        L_0x0017:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x001f:
            java.lang.Object r1 = r14.L$1
            byte[] r1 = (byte[]) r1
            java.lang.Object r6 = r14.L$0
            kotlin.random.Random r6 = (kotlin.random.Random) r6
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r7 = r14
            goto L_0x00a5
        L_0x002d:
            java.lang.Object r1 = r14.L$1
            byte[] r1 = (byte[]) r1
            java.lang.Object r6 = r14.L$0
            kotlin.random.Random r6 = (kotlin.random.Random) r6
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r15 = r14
            goto L_0x0068
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r15)
            long r6 = io.ktor.util.date.DateJvmKt.getTimeMillis()
            kotlin.random.Random r15 = kotlin.random.RandomKt.Random(r6)
            r1 = 32
            byte[] r1 = new byte[r1]
            r6 = r14
        L_0x004a:
            long r7 = r6.$periodMillis     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            io.ktor.websocket.PingPongKt$pinger$1$1 r9 = new io.ktor.websocket.PingPongKt$pinger$1$1     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame$Pong> r10 = r6.$channel     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r9.<init>(r10, r5)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r10 = r6
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r6.L$0 = r15     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r6.L$1 = r1     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r6.label = r4     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r7, r9, r10)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            if (r7 != r0) goto L_0x0065
            return r0
        L_0x0065:
            r13 = r6
            r6 = r15
            r15 = r13
        L_0x0068:
            r6.nextBytes(r1)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r7.<init>()     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            java.lang.String r8 = "[ping "
            r7.append(r8)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            java.lang.String r8 = io.ktor.util.CryptoKt.hex((byte[]) r1)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r7.append(r8)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            java.lang.String r8 = " ping]"
            r7.append(r8)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            java.lang.String r7 = r7.toString()     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            long r8 = r15.$timeoutMillis     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            io.ktor.websocket.PingPongKt$pinger$1$rc$1 r10 = new io.ktor.websocket.PingPongKt$pinger$1$rc$1     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame> r11 = r15.$outgoing     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame$Pong> r12 = r15.$channel     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r10.<init>(r11, r7, r12, r5)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r7 = r15
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r15.L$0 = r6     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r15.L$1 = r1     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r15.label = r3     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r8, r10, r7)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            if (r7 != r0) goto L_0x00a2
            return r0
        L_0x00a2:
            r13 = r7
            r7 = r15
            r15 = r13
        L_0x00a5:
            kotlin.Unit r15 = (kotlin.Unit) r15     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            if (r15 != 0) goto L_0x00c9
            io.ktor.websocket.Frame$Close r15 = new io.ktor.websocket.Frame$Close     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            io.ktor.websocket.CloseReason r1 = new io.ktor.websocket.CloseReason     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            io.ktor.websocket.CloseReason$Codes r3 = io.ktor.websocket.CloseReason.Codes.INTERNAL_ERROR     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            java.lang.String r4 = "Ping timeout"
            r1.<init>((io.ktor.websocket.CloseReason.Codes) r3, (java.lang.String) r4)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r15.<init>((io.ktor.websocket.CloseReason) r1)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame> r1 = r7.$outgoing     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r7.L$0 = r5     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r7.L$1 = r5     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            r7.label = r2     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            java.lang.Object r15 = r1.send(r15, r3)     // Catch:{ CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00cd }
            if (r15 != r0) goto L_0x00cd
            return r0
        L_0x00c9:
            r15 = r6
            r6 = r7
            goto L_0x004a
        L_0x00cd:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt$pinger$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
