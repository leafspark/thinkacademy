package com.tal.app.thinkacademy.business.home.main.api;

import com.tal.app.thinkacademy.business.home.main.bean.RedDotPostBody;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.api.HomeRepository", f = "HomeRepository.kt", i = {}, l = {29, 27}, m = "getRedDot", n = {}, s = {})
/* compiled from: HomeRepository.kt */
final class HomeRepository$getRedDot$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeRepository$getRedDot$1(HomeRepository homeRepository, Continuation<? super HomeRepository$getRedDot$1> continuation) {
        super(continuation);
        this.this$0 = homeRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.getRedDot((RedDotPostBody) null, this);
    }
}
