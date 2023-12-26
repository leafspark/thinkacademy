package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$readerJob$1", f = "RawWebSocketCommon.kt", i = {2}, l = {88, 92, 95}, m = "invokeSuspend", n = {"cause"}, s = {"L$0"})
/* compiled from: RawWebSocketCommon.kt */
final class RawWebSocketCommon$readerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RawWebSocketCommon$readerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$readerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new RawWebSocketCommon$readerJob$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00b6 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0079 A[Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0106 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0107  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:62:0x00d1=Splitter:B:62:0x00d1, B:73:0x010a=Splitter:B:73:0x010a, B:52:0x00ac=Splitter:B:52:0x00ac} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:68:0x00e3=Splitter:B:68:0x00e3, B:55:0x00b6=Splitter:B:55:0x00b6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0047
            if (r1 == r4) goto L_0x002d
            if (r1 == r3) goto L_0x0029
            if (r1 != r2) goto L_0x0021
            java.lang.Object r0 = r11.L$0
            io.ktor.websocket.FrameTooBigException r0 = (io.ktor.websocket.FrameTooBigException) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x001d }
            r12 = r0
            r0 = r11
            goto L_0x010a
        L_0x001d:
            r12 = move-exception
            r0 = r11
            goto L_0x011d
        L_0x0021:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ FrameTooBigException -> 0x0041, CancellationException -> 0x003d, EOFException | ClosedReceiveChannelException -> 0x003a, ChannelIOException -> 0x0037, all -> 0x0033 }
            goto L_0x004a
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ FrameTooBigException -> 0x0041, CancellationException -> 0x003d, EOFException | ClosedReceiveChannelException -> 0x003a, ChannelIOException -> 0x0037, all -> 0x0033 }
            r1 = r0
            r0 = r11
            goto L_0x006d
        L_0x0033:
            r12 = move-exception
            r0 = r11
            goto L_0x00ac
        L_0x0037:
            r12 = r11
            goto L_0x00b6
        L_0x003a:
            r12 = r11
            goto L_0x00c1
        L_0x003d:
            r12 = move-exception
            r0 = r11
            goto L_0x00d1
        L_0x0041:
            r12 = move-exception
            r1 = r0
            r0 = r12
            r12 = r11
            goto L_0x00e3
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r12)
        L_0x004a:
            r12 = r11
        L_0x004b:
            io.ktor.websocket.RawWebSocketCommon r1 = r12.this$0     // Catch:{ FrameTooBigException -> 0x00df, CancellationException -> 0x00cd, EOFException | ClosedReceiveChannelException -> 0x00c1, ChannelIOException -> 0x00b6, all -> 0x00a8 }
            io.ktor.utils.io.ByteReadChannel r1 = r1.input     // Catch:{ FrameTooBigException -> 0x00df, CancellationException -> 0x00cd, EOFException | ClosedReceiveChannelException -> 0x00c1, ChannelIOException -> 0x00b6, all -> 0x00a8 }
            io.ktor.websocket.RawWebSocketCommon r6 = r12.this$0     // Catch:{ FrameTooBigException -> 0x00df, CancellationException -> 0x00cd, EOFException | ClosedReceiveChannelException -> 0x00c1, ChannelIOException -> 0x00b6, all -> 0x00a8 }
            long r6 = r6.getMaxFrameSize()     // Catch:{ FrameTooBigException -> 0x00df, CancellationException -> 0x00cd, EOFException | ClosedReceiveChannelException -> 0x00c1, ChannelIOException -> 0x00b6, all -> 0x00a8 }
            io.ktor.websocket.RawWebSocketCommon r8 = r12.this$0     // Catch:{ FrameTooBigException -> 0x00df, CancellationException -> 0x00cd, EOFException | ClosedReceiveChannelException -> 0x00c1, ChannelIOException -> 0x00b6, all -> 0x00a8 }
            int r8 = r8.lastOpcode     // Catch:{ FrameTooBigException -> 0x00df, CancellationException -> 0x00cd, EOFException | ClosedReceiveChannelException -> 0x00c1, ChannelIOException -> 0x00b6, all -> 0x00a8 }
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ FrameTooBigException -> 0x00df, CancellationException -> 0x00cd, EOFException | ClosedReceiveChannelException -> 0x00c1, ChannelIOException -> 0x00b6, all -> 0x00a8 }
            r12.label = r4     // Catch:{ FrameTooBigException -> 0x00df, CancellationException -> 0x00cd, EOFException | ClosedReceiveChannelException -> 0x00c1, ChannelIOException -> 0x00b6, all -> 0x00a8 }
            java.lang.Object r1 = io.ktor.websocket.RawWebSocketCommonKt.readFrame(r1, r6, r8, r9)     // Catch:{ FrameTooBigException -> 0x00df, CancellationException -> 0x00cd, EOFException | ClosedReceiveChannelException -> 0x00c1, ChannelIOException -> 0x00b6, all -> 0x00a8 }
            if (r1 != r0) goto L_0x0069
            return r0
        L_0x0069:
            r10 = r0
            r0 = r12
            r12 = r1
            r1 = r10
        L_0x006d:
            io.ktor.websocket.Frame r12 = (io.ktor.websocket.Frame) r12     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
            io.ktor.websocket.FrameType r6 = r12.getFrameType()     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
            boolean r6 = r6.getControlFrame()     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
            if (r6 != 0) goto L_0x0086
            io.ktor.websocket.RawWebSocketCommon r6 = r0.this$0     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
            io.ktor.websocket.FrameType r7 = r12.getFrameType()     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
            int r7 = r7.getOpcode()     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
            r6.lastOpcode = r7     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
        L_0x0086:
            io.ktor.websocket.RawWebSocketCommon r6 = r0.this$0     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
            kotlinx.coroutines.channels.Channel r6 = r6._incoming     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
            r0.label = r3     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
            java.lang.Object r12 = r6.send(r12, r7)     // Catch:{ FrameTooBigException -> 0x00a3, CancellationException -> 0x00a1, EOFException | ClosedReceiveChannelException -> 0x009f, ChannelIOException -> 0x009d, all -> 0x009b }
            if (r12 != r1) goto L_0x0098
            return r1
        L_0x0098:
            r12 = r0
            r0 = r1
            goto L_0x004b
        L_0x009b:
            r12 = move-exception
            goto L_0x00ac
        L_0x009d:
            r12 = r0
            goto L_0x00b6
        L_0x009f:
            r12 = r0
            goto L_0x00c1
        L_0x00a1:
            r12 = move-exception
            goto L_0x00d1
        L_0x00a3:
            r12 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L_0x00e3
        L_0x00a8:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
        L_0x00ac:
            io.ktor.websocket.RawWebSocketCommon r1 = r0.this$0     // Catch:{ all -> 0x00dd }
            kotlinx.coroutines.channels.Channel r1 = r1._incoming     // Catch:{ all -> 0x00dd }
            r1.close(r12)     // Catch:{ all -> 0x00dd }
            throw r12     // Catch:{ all -> 0x00dd }
        L_0x00b6:
            io.ktor.websocket.RawWebSocketCommon r0 = r12.this$0     // Catch:{ all -> 0x0119 }
            kotlinx.coroutines.channels.Channel r0 = r0._incoming     // Catch:{ all -> 0x0119 }
            kotlinx.coroutines.channels.ReceiveChannel r0 = (kotlinx.coroutines.channels.ReceiveChannel) r0     // Catch:{ all -> 0x0119 }
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r0, r5, r4, r5)     // Catch:{ all -> 0x0119 }
        L_0x00c1:
            io.ktor.websocket.RawWebSocketCommon r12 = r12.this$0
        L_0x00c3:
            kotlinx.coroutines.channels.Channel r12 = r12._incoming
            kotlinx.coroutines.channels.SendChannel r12 = (kotlinx.coroutines.channels.SendChannel) r12
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r12, r5, r4, r5)
            goto L_0x0116
        L_0x00cd:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
        L_0x00d1:
            io.ktor.websocket.RawWebSocketCommon r1 = r0.this$0     // Catch:{ all -> 0x00dd }
            kotlinx.coroutines.channels.Channel r1 = r1._incoming     // Catch:{ all -> 0x00dd }
            r1.cancel(r12)     // Catch:{ all -> 0x00dd }
        L_0x00da:
            io.ktor.websocket.RawWebSocketCommon r12 = r0.this$0
            goto L_0x00c3
        L_0x00dd:
            r12 = move-exception
            goto L_0x011d
        L_0x00df:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
        L_0x00e3:
            io.ktor.websocket.RawWebSocketCommon r3 = r12.this$0     // Catch:{ all -> 0x0119 }
            kotlinx.coroutines.channels.SendChannel r3 = r3.getOutgoing()     // Catch:{ all -> 0x0119 }
            io.ktor.websocket.Frame$Close r6 = new io.ktor.websocket.Frame$Close     // Catch:{ all -> 0x0119 }
            io.ktor.websocket.CloseReason r7 = new io.ktor.websocket.CloseReason     // Catch:{ all -> 0x0119 }
            io.ktor.websocket.CloseReason$Codes r8 = io.ktor.websocket.CloseReason.Codes.TOO_BIG     // Catch:{ all -> 0x0119 }
            java.lang.String r9 = r0.getMessage()     // Catch:{ all -> 0x0119 }
            r7.<init>((io.ktor.websocket.CloseReason.Codes) r8, (java.lang.String) r9)     // Catch:{ all -> 0x0119 }
            r6.<init>((io.ktor.websocket.CloseReason) r7)     // Catch:{ all -> 0x0119 }
            r7 = r12
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ all -> 0x0119 }
            r12.L$0 = r0     // Catch:{ all -> 0x0119 }
            r12.label = r2     // Catch:{ all -> 0x0119 }
            java.lang.Object r2 = r3.send(r6, r7)     // Catch:{ all -> 0x0119 }
            if (r2 != r1) goto L_0x0107
            return r1
        L_0x0107:
            r10 = r0
            r0 = r12
            r12 = r10
        L_0x010a:
            io.ktor.websocket.RawWebSocketCommon r1 = r0.this$0     // Catch:{ all -> 0x00dd }
            kotlinx.coroutines.channels.Channel r1 = r1._incoming     // Catch:{ all -> 0x00dd }
            java.lang.Throwable r12 = (java.lang.Throwable) r12     // Catch:{ all -> 0x00dd }
            r1.close(r12)     // Catch:{ all -> 0x00dd }
            goto L_0x00da
        L_0x0116:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0119:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
        L_0x011d:
            io.ktor.websocket.RawWebSocketCommon r0 = r0.this$0
            kotlinx.coroutines.channels.Channel r0 = r0._incoming
            kotlinx.coroutines.channels.SendChannel r0 = (kotlinx.coroutines.channels.SendChannel) r0
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r0, r5, r4, r5)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon$readerJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
