package com.tal.app.thinkacademy.live.abilitypack;

import com.tal.app.thinkacademy.live.abilitypack.keyboardfill.bean.KeyboardFillBody;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.abilitypack.LiveRepository", f = "LiveRepository.kt", i = {}, l = {25, 23}, m = "check", n = {}, s = {})
/* compiled from: LiveRepository.kt */
final class LiveRepository$check$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveRepository$check$1(LiveRepository liveRepository, Continuation<? super LiveRepository$check$1> continuation) {
        super(continuation);
        this.this$0 = liveRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.check((KeyboardFillBody) null, (Continuation) this);
    }
}
