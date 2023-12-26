package io.ktor.client.engine.okhttp;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ActorScope;
import okhttp3.Request;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ActorScope;", "Lio/ktor/websocket/Frame;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpWebsocketSession$outgoing$1", f = "OkHttpWebsocketSession.kt", i = {0, 1, 1}, l = {62, 66}, m = "invokeSuspend", n = {"$this$actor", "websocket", "closeReason"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: OkHttpWebsocketSession.kt */
final class OkHttpWebsocketSession$outgoing$1 extends SuspendLambda implements Function2<ActorScope<Frame>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Request $engineRequest;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ OkHttpWebsocketSession this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttpWebsocketSession$outgoing$1(OkHttpWebsocketSession okHttpWebsocketSession, Request request, Continuation<? super OkHttpWebsocketSession$outgoing$1> continuation) {
        super(2, continuation);
        this.this$0 = okHttpWebsocketSession;
        this.$engineRequest = request;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> okHttpWebsocketSession$outgoing$1 = new OkHttpWebsocketSession$outgoing$1(this.this$0, this.$engineRequest, continuation);
        okHttpWebsocketSession$outgoing$1.L$0 = obj;
        return (Continuation) okHttpWebsocketSession$outgoing$1;
    }

    public final Object invoke(ActorScope<Frame> actorScope, Continuation<? super Unit> continuation) {
        return create(actorScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: kotlinx.coroutines.channels.ActorScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f A[Catch:{ all -> 0x012f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003f
            if (r1 == r3) goto L_0x002f
            if (r1 != r2) goto L_0x0027
            java.lang.Object r1 = r10.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r3 = r10.L$1
            io.ktor.websocket.CloseReason r3 = (io.ktor.websocket.CloseReason) r3
            java.lang.Object r4 = r10.L$0
            okhttp3.WebSocket r4 = (okhttp3.WebSocket) r4
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0024 }
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            goto L_0x0097
        L_0x0024:
            r11 = move-exception
            goto L_0x0136
        L_0x0027:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x002f:
            java.lang.Object r1 = r10.L$2
            okhttp3.Request r1 = (okhttp3.Request) r1
            java.lang.Object r3 = r10.L$1
            okhttp3.WebSocket$Factory r3 = (okhttp3.WebSocket.Factory) r3
            java.lang.Object r4 = r10.L$0
            kotlinx.coroutines.channels.ActorScope r4 = (kotlinx.coroutines.channels.ActorScope) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006a
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            r4 = r11
            kotlinx.coroutines.channels.ActorScope r4 = (kotlinx.coroutines.channels.ActorScope) r4
            io.ktor.client.engine.okhttp.OkHttpWebsocketSession r11 = r10.this$0
            okhttp3.WebSocket$Factory r11 = r11.webSocketFactory
            okhttp3.Request r1 = r10.$engineRequest
            io.ktor.client.engine.okhttp.OkHttpWebsocketSession r5 = r10.this$0
            kotlinx.coroutines.CompletableDeferred r5 = r5.self
            r6 = r10
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r10.L$0 = r4
            r10.L$1 = r11
            r10.L$2 = r1
            r10.label = r3
            java.lang.Object r3 = r5.await(r6)
            if (r3 != r0) goto L_0x0067
            return r0
        L_0x0067:
            r9 = r3
            r3 = r11
            r11 = r9
        L_0x006a:
            okhttp3.WebSocketListener r11 = (okhttp3.WebSocketListener) r11
            okhttp3.WebSocket r11 = r3.newWebSocket(r1, r11)
            io.ktor.websocket.CloseReason r3 = io.ktor.client.engine.okhttp.OkHttpWebsocketSessionKt.DEFAULT_CLOSE_REASON_ERROR
            kotlinx.coroutines.channels.Channel r1 = r4.getChannel()     // Catch:{ all -> 0x0133 }
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()     // Catch:{ all -> 0x0133 }
            r4 = r11
            r11 = r10
        L_0x007e:
            r5 = r11
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ all -> 0x0024 }
            r11.L$0 = r4     // Catch:{ all -> 0x0024 }
            r11.L$1 = r3     // Catch:{ all -> 0x0024 }
            r11.L$2 = r1     // Catch:{ all -> 0x0024 }
            r11.label = r2     // Catch:{ all -> 0x0024 }
            java.lang.Object r5 = r1.hasNext(r5)     // Catch:{ all -> 0x0024 }
            if (r5 != r0) goto L_0x0090
            return r0
        L_0x0090:
            r9 = r0
            r0 = r11
            r11 = r5
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r9
        L_0x0097:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x012f }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x012f }
            if (r11 == 0) goto L_0x011c
            java.lang.Object r11 = r3.next()     // Catch:{ all -> 0x012f }
            io.ktor.websocket.Frame r11 = (io.ktor.websocket.Frame) r11     // Catch:{ all -> 0x012f }
            boolean r6 = r11 instanceof io.ktor.websocket.Frame.Binary     // Catch:{ all -> 0x012f }
            if (r6 == 0) goto L_0x00c8
            okio.ByteString$Companion r6 = okio.ByteString.Companion     // Catch:{ all -> 0x012f }
            byte[] r7 = r11.getData()     // Catch:{ all -> 0x012f }
            r8 = 0
            byte[] r11 = r11.getData()     // Catch:{ all -> 0x012f }
            int r11 = r11.length     // Catch:{ all -> 0x012f }
            okio.ByteString r11 = r6.of(r7, r8, r11)     // Catch:{ all -> 0x012f }
            boolean r6 = r5 instanceof okhttp3.WebSocket     // Catch:{ all -> 0x012f }
            if (r6 != 0) goto L_0x00c1
            r5.send(r11)     // Catch:{ all -> 0x012f }
            goto L_0x00e5
        L_0x00c1:
            r6 = r5
            okhttp3.WebSocket r6 = (okhttp3.WebSocket) r6     // Catch:{ all -> 0x012f }
            com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation.newSend(r6, r11)     // Catch:{ all -> 0x012f }
            goto L_0x00e5
        L_0x00c8:
            boolean r6 = r11 instanceof io.ktor.websocket.Frame.Text     // Catch:{ all -> 0x012f }
            if (r6 == 0) goto L_0x00eb
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x012f }
            byte[] r11 = r11.getData()     // Catch:{ all -> 0x012f }
            java.nio.charset.Charset r7 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x012f }
            r6.<init>(r11, r7)     // Catch:{ all -> 0x012f }
            boolean r11 = r5 instanceof okhttp3.WebSocket     // Catch:{ all -> 0x012f }
            if (r11 != 0) goto L_0x00df
            r5.send(r6)     // Catch:{ all -> 0x012f }
            goto L_0x00e5
        L_0x00df:
            r11 = r5
            okhttp3.WebSocket r11 = (okhttp3.WebSocket) r11     // Catch:{ all -> 0x012f }
            com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation.newSend(r11, r6)     // Catch:{ all -> 0x012f }
        L_0x00e5:
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r4 = r5
            goto L_0x007e
        L_0x00eb:
            boolean r0 = r11 instanceof io.ktor.websocket.Frame.Close     // Catch:{ all -> 0x012f }
            if (r0 == 0) goto L_0x0116
            io.ktor.websocket.Frame$Close r11 = (io.ktor.websocket.Frame.Close) r11     // Catch:{ all -> 0x012f }
            io.ktor.websocket.CloseReason r11 = io.ktor.websocket.FrameCommonKt.readReason(r11)     // Catch:{ all -> 0x012f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch:{ all -> 0x012f }
            boolean r0 = io.ktor.client.engine.okhttp.OkHttpWebsocketSessionKt.isReserved(r11)     // Catch:{ all -> 0x012f }
            if (r0 != 0) goto L_0x0100
            r3 = r11
            goto L_0x0101
        L_0x0100:
            r3 = r4
        L_0x0101:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0114 }
            short r0 = r3.getCode()     // Catch:{ all -> 0x010f }
            java.lang.String r1 = r3.getMessage()     // Catch:{ all -> 0x010f }
            r5.close(r0, r1)     // Catch:{ all -> 0x010f }
            return r11
        L_0x010f:
            r11 = move-exception
            r5.cancel()
            throw r11
        L_0x0114:
            r11 = move-exception
            goto L_0x0131
        L_0x0116:
            io.ktor.client.engine.okhttp.UnsupportedFrameTypeException r0 = new io.ktor.client.engine.okhttp.UnsupportedFrameTypeException     // Catch:{ all -> 0x012f }
            r0.<init>(r11)     // Catch:{ all -> 0x012f }
            throw r0     // Catch:{ all -> 0x012f }
        L_0x011c:
            short r11 = r4.getCode()     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r4.getMessage()     // Catch:{ all -> 0x012a }
            r5.close(r11, r0)     // Catch:{ all -> 0x012a }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x012a:
            r11 = move-exception
            r5.cancel()
            throw r11
        L_0x012f:
            r11 = move-exception
            r3 = r4
        L_0x0131:
            r4 = r5
            goto L_0x0136
        L_0x0133:
            r0 = move-exception
            r4 = r11
            r11 = r0
        L_0x0136:
            short r0 = r3.getCode()     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = r3.getMessage()     // Catch:{ all -> 0x0142 }
            r4.close(r0, r1)     // Catch:{ all -> 0x0142 }
            throw r11
        L_0x0142:
            r11 = move-exception
            r4.cancel()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpWebsocketSession$outgoing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
