package com.tal.app.thinkacademy.business.home.main;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.MainActivityLogic", f = "MainActivityLogic.kt", i = {}, l = {206, 204}, m = "apiTimezoneCheck", n = {}, s = {})
/* compiled from: MainActivityLogic.kt */
final class MainActivityLogic$apiTimezoneCheck$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MainActivityLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivityLogic$apiTimezoneCheck$1(MainActivityLogic mainActivityLogic, Continuation<? super MainActivityLogic$apiTimezoneCheck$1> continuation) {
        super(continuation);
        this.this$0 = mainActivityLogic;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.apiTimezoneCheck((String) null, this);
    }
}
