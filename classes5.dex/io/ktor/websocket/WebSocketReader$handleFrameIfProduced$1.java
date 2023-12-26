package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketReader", f = "WebSocketReader.kt", i = {0}, l = {112}, m = "handleFrameIfProduced", n = {"this"}, s = {"L$0"})
/* compiled from: WebSocketReader.kt */
final class WebSocketReader$handleFrameIfProduced$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebSocketReader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebSocketReader$handleFrameIfProduced$1(WebSocketReader webSocketReader, Continuation<? super WebSocketReader$handleFrameIfProduced$1> continuation) {
        super(continuation);
        this.this$0 = webSocketReader;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleFrameIfProduced((Continuation) this);
    }
}
