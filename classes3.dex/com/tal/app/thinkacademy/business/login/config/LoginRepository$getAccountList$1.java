package com.tal.app.thinkacademy.business.login.config;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.config.LoginRepository", f = "LoginRepository.kt", i = {}, l = {168, 164}, m = "getAccountList", n = {}, s = {})
/* compiled from: LoginRepository.kt */
final class LoginRepository$getAccountList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginRepository$getAccountList$1(LoginRepository loginRepository, Continuation<? super LoginRepository$getAccountList$1> continuation) {
        super(continuation);
        this.this$0 = loginRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.getAccountList((String) null, this);
    }
}
