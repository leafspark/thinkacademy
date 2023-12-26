package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketSessionKt", f = "WebSocketSession.kt", i = {0}, l = {112, 113}, m = "close", n = {"$this$close"}, s = {"L$0"})
/* compiled from: WebSocketSession.kt */
final class WebSocketSessionKt$close$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    WebSocketSessionKt$close$1(Continuation<? super WebSocketSessionKt$close$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WebSocketSessionKt.close((WebSocketSession) null, (CloseReason) null, (Continuation<? super Unit>) (Continuation) this);
    }
}
