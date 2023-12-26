package io.ktor.client.engine.okhttp;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.websocket.WebSocketException;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketExtension;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ActorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010?\u001a\u00020@H@ø\u0001\u0000¢\u0006\u0002\u0010AJ \u0010B\u001a\u00020@2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016J \u0010I\u001a\u00020@2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016J\"\u0010J\u001a\u00020@2\u0006\u0010C\u001a\u00020D2\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010/H\u0016J\u0018\u0010N\u001a\u00020@2\u0006\u0010C\u001a\u00020D2\u0006\u0010O\u001a\u00020HH\u0016J\u0018\u0010N\u001a\u00020@2\u0006\u0010C\u001a\u00020D2\u0006\u0010P\u001a\u00020QH\u0016J\u0018\u0010R\u001a\u00020@2\u0006\u0010C\u001a\u00020D2\u0006\u0010M\u001a\u00020/H\u0016J\u0006\u0010S\u001a\u00020@J\u001a\u0010S\u001a\u00020@2\u0010\u0010T\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0019H\u0016J\b\u0010U\u001a\u00020@H\u0017R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R$\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"8V@VX\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u00020(2\u0006\u0010!\u001a\u00020(8V@VX\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R \u00102\u001a\b\u0012\u0004\u0012\u00020\u001103X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u00105\u001a\u0004\b6\u00107R$\u00108\u001a\u00020(2\u0006\u0010!\u001a\u00020(8V@VX\u000e¢\u0006\f\u001a\u0004\b9\u0010+\"\u0004\b:\u0010-R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00000\rX\u0004¢\u0006\u0002\n\u0000R$\u0010<\u001a\u00020(2\u0006\u0010!\u001a\u00020(8V@VX\u000e¢\u0006\f\u001a\u0004\b=\u0010+\"\u0004\b>\u0010-R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006V"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpWebsocketSession;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lokhttp3/WebSocketListener;", "engine", "Lokhttp3/OkHttpClient;", "webSocketFactory", "Lokhttp3/WebSocket$Factory;", "engineRequest", "Lokhttp3/Request;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lokhttp3/OkHttpClient;Lokhttp3/WebSocket$Factory;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;)V", "_closeReason", "Lkotlinx/coroutines/CompletableDeferred;", "Lio/ktor/websocket/CloseReason;", "_incoming", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "closeReason", "Lkotlinx/coroutines/Deferred;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "extensions", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "incoming", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "<anonymous parameter 0>", "", "masking", "getMasking", "()Z", "setMasking", "(Z)V", "", "maxFrameSize", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "originResponse", "Lokhttp3/Response;", "getOriginResponse$ktor_client_okhttp", "()Lkotlinx/coroutines/CompletableDeferred;", "outgoing", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing$annotations", "()V", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "pingIntervalMillis", "getPingIntervalMillis", "setPingIntervalMillis", "self", "timeoutMillis", "getTimeoutMillis", "setTimeoutMillis", "flush", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosed", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "t", "", "response", "onMessage", "text", "bytes", "Lokio/ByteString;", "onOpen", "start", "negotiatedExtensions", "terminate", "ktor-client-okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpWebsocketSession.kt */
public final class OkHttpWebsocketSession extends WebSocketListener implements DefaultWebSocketSession {
    private final CompletableDeferred<CloseReason> _closeReason = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    private final Channel<Frame> _incoming = ChannelKt.Channel$default(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
    private final CoroutineContext coroutineContext;
    private final OkHttpClient engine;
    private final CompletableDeferred<Response> originResponse = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    private final SendChannel<Frame> outgoing;
    /* access modifiers changed from: private */
    public final CompletableDeferred<OkHttpWebsocketSession> self = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    /* access modifiers changed from: private */
    public final WebSocket.Factory webSocketFactory;

    public static /* synthetic */ void getOutgoing$annotations() {
    }

    public boolean getMasking() {
        return true;
    }

    public long getMaxFrameSize() {
        return HttpTimeout.INFINITE_TIMEOUT_MS;
    }

    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return DefaultWebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public OkHttpWebsocketSession(OkHttpClient okHttpClient, WebSocket.Factory factory, Request request, CoroutineContext coroutineContext2) {
        Intrinsics.checkNotNullParameter(okHttpClient, "engine");
        Intrinsics.checkNotNullParameter(factory, "webSocketFactory");
        Intrinsics.checkNotNullParameter(request, "engineRequest");
        Intrinsics.checkNotNullParameter(coroutineContext2, "coroutineContext");
        this.engine = okHttpClient;
        this.webSocketFactory = factory;
        this.coroutineContext = coroutineContext2;
        this.outgoing = ActorKt.actor$default(this, (CoroutineContext) null, 0, (CoroutineStart) null, (Function1) null, new OkHttpWebsocketSession$outgoing$1(this, request, (Continuation<? super OkHttpWebsocketSession$outgoing$1>) null), 15, (Object) null);
    }

    public final CompletableDeferred<Response> getOriginResponse$ktor_client_okhttp() {
        return this.originResponse;
    }

    public long getPingIntervalMillis() {
        return (long) this.engine.pingIntervalMillis();
    }

    public void setPingIntervalMillis(long j) {
        throw new WebSocketException("OkHttp doesn't support dynamic ping interval. You could switch it in the engine configuration.");
    }

    public long getTimeoutMillis() {
        return (long) this.engine.readTimeoutMillis();
    }

    public void setTimeoutMillis(long j) {
        throw new WebSocketException("Websocket timeout should be configured in OkHttpEngine.");
    }

    public void setMasking(boolean z) {
        throw new WebSocketException("Masking switch is not supported in OkHttp engine.");
    }

    public void setMaxFrameSize(long j) {
        throw new WebSocketException("Max frame size switch is not supported in OkHttp engine.");
    }

    public ReceiveChannel<Frame> getIncoming() {
        return (ReceiveChannel) this._incoming;
    }

    public Deferred<CloseReason> getCloseReason() {
        return this._closeReason;
    }

    public void start(List<? extends WebSocketExtension<?>> list) {
        Intrinsics.checkNotNullParameter(list, "negotiatedExtensions");
        if (!list.isEmpty()) {
            throw new IllegalArgumentException("Extensions are not supported.".toString());
        }
    }

    public SendChannel<Frame> getOutgoing() {
        return this.outgoing;
    }

    public List<WebSocketExtension<?>> getExtensions() {
        return CollectionsKt.emptyList();
    }

    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(response, "response");
        OkHttpWebsocketSession.super.onOpen(webSocket, response);
        this.originResponse.complete(response);
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        OkHttpWebsocketSession.super.onMessage(webSocket, byteString);
        ChannelsKt.trySendBlocking(this._incoming, new Frame.Binary(true, byteString.toByteArray()));
    }

    public void onMessage(WebSocket webSocket, String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "text");
        OkHttpWebsocketSession.super.onMessage(webSocket, str);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        ChannelsKt.trySendBlocking(this._incoming, new Frame.Text(true, bytes));
    }

    public void onClosed(WebSocket webSocket, int i, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
        OkHttpWebsocketSession.super.onClosed(webSocket, i, str);
        short s = (short) i;
        this._closeReason.complete(new CloseReason(s, str));
        SendChannel.DefaultImpls.close$default(this._incoming, (Throwable) null, 1, (Object) null);
        SendChannel<Frame> outgoing2 = getOutgoing();
        StringBuilder sb = new StringBuilder();
        sb.append("WebSocket session closed with code ");
        CloseReason.Codes byCode = CloseReason.Codes.Companion.byCode(s);
        if (byCode == null || (obj = byCode.toString()) == null) {
            obj = Integer.valueOf(i);
        }
        sb.append(obj);
        sb.append('.');
        outgoing2.close(new CancellationException(sb.toString()));
    }

    public void onClosing(WebSocket webSocket, int i, String str) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(str, "reason");
        OkHttpWebsocketSession.super.onClosing(webSocket, i, str);
        short s = (short) i;
        this._closeReason.complete(new CloseReason(s, str));
        try {
            ChannelsKt.trySendBlocking(getOutgoing(), new Frame.Close(new CloseReason(s, str)));
        } catch (Throwable unused) {
        }
        SendChannel.DefaultImpls.close$default(this._incoming, (Throwable) null, 1, (Object) null);
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(th, "t");
        OkHttpWebsocketSession.super.onFailure(webSocket, th, response);
        this._closeReason.completeExceptionally(th);
        this.originResponse.completeExceptionally(th);
        this._incoming.close(th);
        getOutgoing().close(th);
    }

    public Object flush(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public final void start() {
        this.self.complete(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }
}
