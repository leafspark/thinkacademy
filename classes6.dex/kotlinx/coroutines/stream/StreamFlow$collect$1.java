package kotlinx.coroutines.stream;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.stream.StreamFlow", f = "Stream.kt", i = {0, 0}, l = {26}, m = "collect", n = {"this", "collector"}, s = {"L$0", "L$1"})
/* compiled from: Stream.kt */
final class StreamFlow$collect$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamFlow<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StreamFlow$collect$1(StreamFlow<T> streamFlow, Continuation<? super StreamFlow$collect$1> continuation) {
        super(continuation);
        this.this$0 = streamFlow;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect((FlowCollector) null, (Continuation) this);
    }
}
