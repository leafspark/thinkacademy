package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1", f = "Blocking.kt", i = {0, 0, 1}, l = {316, 40}, m = "loop", n = {"this", "this_$iv", "this"}, s = {"L$0", "L$1", "L$0"})
/* compiled from: Blocking.kt */
final class InputAdapter$loop$1$loop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InputAdapter$loop$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputAdapter$loop$1$loop$1(InputAdapter$loop$1 inputAdapter$loop$1, Continuation<? super InputAdapter$loop$1$loop$1> continuation) {
        super(continuation);
        this.this$0 = inputAdapter$loop$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loop((Continuation) this);
    }
}
