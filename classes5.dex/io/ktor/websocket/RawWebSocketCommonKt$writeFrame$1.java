package io.ktor.websocket;

import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {169, 179, 182, 183, 191, 196}, m = "writeFrame", n = {"$this$writeFrame", "frame", "masking", "length", "$this$writeFrame", "frame", "masking", "length", "formattedLength", "$this$writeFrame", "frame", "masking", "$this$writeFrame", "frame", "masking", "$this$writeFrame", "data", "maskKey"}, s = {"L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0", "I$1", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "I$0"})
/* compiled from: RawWebSocketCommon.kt */
final class RawWebSocketCommonKt$writeFrame$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    RawWebSocketCommonKt$writeFrame$1(Continuation<? super RawWebSocketCommonKt$writeFrame$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RawWebSocketCommonKt.writeFrame((ByteWriteChannel) null, (Frame) null, false, (Continuation) this);
    }
}
