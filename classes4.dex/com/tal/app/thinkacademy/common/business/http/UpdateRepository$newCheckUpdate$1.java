package com.tal.app.thinkacademy.common.business.http;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.common.business.http.UpdateRepository", f = "UpdateRepository.kt", i = {}, l = {17, 16}, m = "newCheckUpdate", n = {}, s = {})
/* compiled from: UpdateRepository.kt */
final class UpdateRepository$newCheckUpdate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdateRepository$newCheckUpdate$1(UpdateRepository updateRepository, Continuation<? super UpdateRepository$newCheckUpdate$1> continuation) {
        super(continuation);
        this.this$0 = updateRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.newCheckUpdate((Continuation) this);
    }
}
