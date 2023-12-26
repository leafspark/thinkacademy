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
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$rc$1", f = "PingPong.kt", i = {}, l = {71, 75}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PingPong.kt */
final class PingPongKt$pinger$1$rc$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Pong> $channel;
    final /* synthetic */ SendChannel<Frame> $outgoing;
    final /* synthetic */ String $pingMessage;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PingPongKt$pinger$1$rc$1(SendChannel<? super Frame> sendChannel, String str, Channel<Frame.Pong> channel, Continuation<? super PingPongKt$pinger$1$rc$1> continuation) {
        super(2, continuation);
        this.$outgoing = sendChannel;
        this.$pingMessage = str;
        this.$channel = channel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new PingPongKt$pinger$1$rc$1(this.$outgoing, this.$pingMessage, this.$channel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0021
            if (r1 == r4) goto L_0x001d
            if (r1 != r3) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r10)
            r1 = r0
            r0 = r9
            goto L_0x006f
        L_0x0015:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005c
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame> r10 = r9.$outgoing
            io.ktor.websocket.Frame$Ping r1 = new io.ktor.websocket.Frame$Ping
            java.lang.String r5 = r9.$pingMessage
            java.nio.charset.Charset r6 = kotlin.text.Charsets.ISO_8859_1
            java.nio.charset.Charset r7 = kotlin.text.Charsets.UTF_8
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r7 == 0) goto L_0x0039
            byte[] r5 = kotlin.text.StringsKt.encodeToByteArray(r5)
            goto L_0x004d
        L_0x0039:
            java.nio.charset.CharsetEncoder r6 = r6.newEncoder()
            java.lang.String r7 = "charset.newEncoder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r7 = r5
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r5 = r5.length()
            byte[] r5 = io.ktor.utils.io.charsets.CharsetJVMKt.encodeToByteArray(r6, r7, r2, r5)
        L_0x004d:
            r1.<init>((byte[]) r5)
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r9.label = r4
            java.lang.Object r10 = r10.send(r1, r5)
            if (r10 != r0) goto L_0x005c
            return r0
        L_0x005c:
            r10 = r9
        L_0x005d:
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame$Pong> r1 = r10.$channel
            r4 = r10
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r10.label = r3
            java.lang.Object r1 = r1.receive(r4)
            if (r1 != r0) goto L_0x006b
            return r0
        L_0x006b:
            r8 = r0
            r0 = r10
            r10 = r1
            r1 = r8
        L_0x006f:
            io.ktor.websocket.Frame$Pong r10 = (io.ktor.websocket.Frame.Pong) r10
            byte[] r10 = r10.getData()
            java.nio.charset.Charset r4 = kotlin.text.Charsets.ISO_8859_1
            int r5 = r10.length
            java.lang.String r6 = new java.lang.String
            r6.<init>(r10, r2, r5, r4)
            java.lang.String r10 = r0.$pingMessage
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r10)
            if (r10 == 0) goto L_0x0088
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0088:
            r10 = r0
            r0 = r1
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt$pinger$1$rc$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
