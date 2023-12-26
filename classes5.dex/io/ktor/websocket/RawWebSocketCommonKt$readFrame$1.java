package io.ktor.websocket;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5}, l = {207, 208, 211, 212, 217, 225}, m = "readFrame", n = {"$this$readFrame", "maxFrameSize", "lastOpcode", "$this$readFrame", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "$this$readFrame", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "maskAndLength", "$this$readFrame", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "maskAndLength", "$this$readFrame", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "length", "lastOpcode", "flagsAndOpcode", "maskKey"}, s = {"L$0", "J$0", "I$0", "L$0", "J$0", "I$0", "B$0", "L$0", "J$0", "I$0", "B$0", "B$1", "L$0", "J$0", "I$0", "B$0", "B$1", "L$0", "J$0", "I$0", "B$0", "J$1", "I$0", "B$0", "I$1"})
/* compiled from: RawWebSocketCommon.kt */
final class RawWebSocketCommonKt$readFrame$1 extends ContinuationImpl {
    byte B$0;
    byte B$1;
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    RawWebSocketCommonKt$readFrame$1(Continuation<? super RawWebSocketCommonKt$readFrame$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RawWebSocketCommonKt.readFrame((ByteReadChannel) null, 0, 0, (Continuation) this);
    }
}
