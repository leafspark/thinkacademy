package com.tal.app.thinkacademy.business.login.config;

import com.tal.app.thinkacademy.business.login.entity.LinkedAccount;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.config.LoginRepository", f = "LoginRepository.kt", i = {}, l = {158, 157}, m = "modifyUserBasicInfo", n = {}, s = {})
/* compiled from: LoginRepository.kt */
final class LoginRepository$modifyUserBasicInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginRepository$modifyUserBasicInfo$1(LoginRepository loginRepository, Continuation<? super LoginRepository$modifyUserBasicInfo$1> continuation) {
        super(continuation);
        this.this$0 = loginRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.modifyUserBasicInfo((String) null, (String) null, (String) null, (String) null, (Integer) null, (List<LinkedAccount>) null, this);
    }
}
