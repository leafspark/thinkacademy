package io.ktor.websocket;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0, 1, 1}, l = {46, 48}, m = "writeLoop", n = {"this", "buffer", "this", "buffer"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: WebSocketWriter.kt */
final class WebSocketWriter$writeLoop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebSocketWriter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebSocketWriter$writeLoop$1(WebSocketWriter webSocketWriter, Continuation<? super WebSocketWriter$writeLoop$1> continuation) {
        super(continuation);
        this.this$0 = webSocketWriter;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeLoop((ByteBuffer) null, (Continuation) this);
    }
}
