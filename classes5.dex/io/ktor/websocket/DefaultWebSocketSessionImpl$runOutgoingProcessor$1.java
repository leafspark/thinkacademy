package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1", f = "DefaultWebSocketSession.kt", i = {}, l = {219, 229, 229, 229, 229, 229, 226, 229, 229}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultWebSocketSession.kt */
final class DefaultWebSocketSessionImpl$runOutgoingProcessor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultWebSocketSessionImpl$runOutgoingProcessor$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation<? super DefaultWebSocketSessionImpl$runOutgoingProcessor$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultWebSocketSessionImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new DefaultWebSocketSessionImpl$runOutgoingProcessor$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getOutgoingToBeProcessed$p(r6.this$0), (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r6.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.close$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getRaw$p(r6.this$0), (io.ktor.websocket.CloseReason) null, (kotlin.coroutines.Continuation) r6, 1, (java.lang.Object) null) != r0) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        io.ktor.websocket.DefaultWebSocketSessionImpl.access$getOutgoingToBeProcessed$p(r6.this$0).cancel(kotlinx.coroutines.ExceptionsKt.CancellationException("Failed to send frame", r7));
        r6.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007c, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.closeExceptionally(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getRaw$p(r6.this$0), r7, (kotlin.coroutines.Continuation) r6) == r0) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007f, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getOutgoingToBeProcessed$p(r6.this$0), (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r6.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.close$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getRaw$p(r6.this$0), (io.ktor.websocket.CloseReason) null, (kotlin.coroutines.Continuation) r6, 1, (java.lang.Object) null) != r0) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009e, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getOutgoingToBeProcessed$p(r6.this$0), (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r6.L$0 = r7;
        r6.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bc, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.close$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getRaw$p(r6.this$0), (io.ktor.websocket.CloseReason) null, (kotlin.coroutines.Continuation) r6, 1, (java.lang.Object) null) == r0) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00be, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bf, code lost:
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c0, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getOutgoingToBeProcessed$p(r6.this$0), (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r6.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00dc, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.close$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getRaw$p(r6.this$0), (io.ktor.websocket.CloseReason) null, (kotlin.coroutines.Continuation) r6, 1, (java.lang.Object) null) == r0) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00de, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00df, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getOutgoingToBeProcessed$p(r6.this$0), (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r6.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00fa, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.close$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getRaw$p(r6.this$0), (io.ktor.websocket.CloseReason) null, (kotlin.coroutines.Continuation) r6, 1, (java.lang.Object) null) == r0) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00fc, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fd, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getOutgoingToBeProcessed$p(r6.this$0), (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r6.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0118, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.close$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getRaw$p(r6.this$0), (io.ktor.websocket.CloseReason) null, (kotlin.coroutines.Continuation) r6, 1, (java.lang.Object) null) == r0) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x011a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011b, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getOutgoingToBeProcessed$p(r6.this$0), (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        r6.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0136, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.close$default(io.ktor.websocket.DefaultWebSocketSessionImpl.access$getRaw$p(r6.this$0), (io.ktor.websocket.CloseReason) null, (kotlin.coroutines.Continuation) r6, 1, (java.lang.Object) null) == r0) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0138, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x013b, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x001c, B:9:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            r3 = 0
            switch(r1) {
                case 0: goto L_0x002e;
                case 1: goto L_0x0028;
                case 2: goto L_0x0023;
                case 3: goto L_0x0023;
                case 4: goto L_0x0023;
                case 5: goto L_0x0023;
                case 6: goto L_0x0023;
                case 7: goto L_0x001c;
                case 8: goto L_0x0023;
                case 9: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0013:
            java.lang.Object r0 = r6.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00c0
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0020 }
            goto L_0x007f
        L_0x0020:
            r7 = move-exception
            goto L_0x009e
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0139
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ ClosedSendChannelException -> 0x011b, ClosedReceiveChannelException -> 0x00fd, CancellationException -> 0x00df, ChannelIOException -> 0x00c1, all -> 0x002c }
            goto L_0x003f
        L_0x002c:
            r7 = move-exception
            goto L_0x005d
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r7)
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0     // Catch:{ ClosedSendChannelException -> 0x011b, ClosedReceiveChannelException -> 0x00fd, CancellationException -> 0x00df, ChannelIOException -> 0x00c1, all -> 0x002c }
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch:{ ClosedSendChannelException -> 0x011b, ClosedReceiveChannelException -> 0x00fd, CancellationException -> 0x00df, ChannelIOException -> 0x00c1, all -> 0x002c }
            r6.label = r2     // Catch:{ ClosedSendChannelException -> 0x011b, ClosedReceiveChannelException -> 0x00fd, CancellationException -> 0x00df, ChannelIOException -> 0x00c1, all -> 0x002c }
            java.lang.Object r7 = r7.outgoingProcessorLoop(r1)     // Catch:{ ClosedSendChannelException -> 0x011b, ClosedReceiveChannelException -> 0x00fd, CancellationException -> 0x00df, ChannelIOException -> 0x00c1, all -> 0x002c }
            if (r7 != r0) goto L_0x003f
            return r0
        L_0x003f:
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            kotlinx.coroutines.channels.Channel r7 = r7.outgoingToBeProcessed
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r7, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            io.ktor.websocket.WebSocketSession r7 = r7.raw
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4 = 2
            r6.label = r4
            java.lang.Object r7 = io.ktor.websocket.WebSocketSessionKt.close$default(r7, r3, r1, r2, r3)
            if (r7 != r0) goto L_0x0139
            return r0
        L_0x005d:
            io.ktor.websocket.DefaultWebSocketSessionImpl r1 = r6.this$0     // Catch:{ all -> 0x0020 }
            kotlinx.coroutines.channels.Channel r1 = r1.outgoingToBeProcessed     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = "Failed to send frame"
            java.util.concurrent.CancellationException r4 = kotlinx.coroutines.ExceptionsKt.CancellationException(r4, r7)     // Catch:{ all -> 0x0020 }
            r1.cancel(r4)     // Catch:{ all -> 0x0020 }
            io.ktor.websocket.DefaultWebSocketSessionImpl r1 = r6.this$0     // Catch:{ all -> 0x0020 }
            io.ktor.websocket.WebSocketSession r1 = r1.raw     // Catch:{ all -> 0x0020 }
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch:{ all -> 0x0020 }
            r5 = 7
            r6.label = r5     // Catch:{ all -> 0x0020 }
            java.lang.Object r7 = io.ktor.websocket.WebSocketSessionKt.closeExceptionally(r1, r7, r4)     // Catch:{ all -> 0x0020 }
            if (r7 != r0) goto L_0x007f
            return r0
        L_0x007f:
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            kotlinx.coroutines.channels.Channel r7 = r7.outgoingToBeProcessed
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r7, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            io.ktor.websocket.WebSocketSession r7 = r7.raw
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4 = 8
            r6.label = r4
            java.lang.Object r7 = io.ktor.websocket.WebSocketSessionKt.close$default(r7, r3, r1, r2, r3)
            if (r7 != r0) goto L_0x0139
            return r0
        L_0x009e:
            io.ktor.websocket.DefaultWebSocketSessionImpl r1 = r6.this$0
            kotlinx.coroutines.channels.Channel r1 = r1.outgoingToBeProcessed
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r1, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r1 = r6.this$0
            io.ktor.websocket.WebSocketSession r1 = r1.raw
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.L$0 = r7
            r5 = 9
            r6.label = r5
            java.lang.Object r1 = io.ktor.websocket.WebSocketSessionKt.close$default(r1, r3, r4, r2, r3)
            if (r1 != r0) goto L_0x00bf
            return r0
        L_0x00bf:
            r0 = r7
        L_0x00c0:
            throw r0
        L_0x00c1:
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            kotlinx.coroutines.channels.Channel r7 = r7.outgoingToBeProcessed
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r7, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            io.ktor.websocket.WebSocketSession r7 = r7.raw
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4 = 6
            r6.label = r4
            java.lang.Object r7 = io.ktor.websocket.WebSocketSessionKt.close$default(r7, r3, r1, r2, r3)
            if (r7 != r0) goto L_0x0139
            return r0
        L_0x00df:
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            kotlinx.coroutines.channels.Channel r7 = r7.outgoingToBeProcessed
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r7, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            io.ktor.websocket.WebSocketSession r7 = r7.raw
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4 = 5
            r6.label = r4
            java.lang.Object r7 = io.ktor.websocket.WebSocketSessionKt.close$default(r7, r3, r1, r2, r3)
            if (r7 != r0) goto L_0x0139
            return r0
        L_0x00fd:
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            kotlinx.coroutines.channels.Channel r7 = r7.outgoingToBeProcessed
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r7, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            io.ktor.websocket.WebSocketSession r7 = r7.raw
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4 = 4
            r6.label = r4
            java.lang.Object r7 = io.ktor.websocket.WebSocketSessionKt.close$default(r7, r3, r1, r2, r3)
            if (r7 != r0) goto L_0x0139
            return r0
        L_0x011b:
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            kotlinx.coroutines.channels.Channel r7 = r7.outgoingToBeProcessed
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r7, r3, r2, r3)
            io.ktor.websocket.DefaultWebSocketSessionImpl r7 = r6.this$0
            io.ktor.websocket.WebSocketSession r7 = r7.raw
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4 = 3
            r6.label = r4
            java.lang.Object r7 = io.ktor.websocket.WebSocketSessionKt.close$default(r7, r3, r1, r2, r3)
            if (r7 != r0) goto L_0x0139
            return r0
        L_0x0139:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
