package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.common.base.StateLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.presenter.LoginViewModel$securityCheck$2", f = "LoginViewModel.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LoginViewModel.kt */
final class LoginViewModel$securityCheck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $contactInfo;
    final /* synthetic */ String $countryCallingCode;
    final /* synthetic */ Integer $scene;
    final /* synthetic */ Integer $type;
    final /* synthetic */ String $verificationCode;
    Object L$0;
    int label;
    final /* synthetic */ LoginViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginViewModel$securityCheck$2(LoginViewModel loginViewModel, String str, String str2, Integer num, String str3, Integer num2, Continuation<? super LoginViewModel$securityCheck$2> continuation) {
        super(2, continuation);
        this.this$0 = loginViewModel;
        this.$contactInfo = str;
        this.$countryCallingCode = str2;
        this.$scene = num;
        this.$verificationCode = str3;
        this.$type = num2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginViewModel$securityCheck$2(this.this$0, this.$contactInfo, this.$countryCallingCode, this.$scene, this.$verificationCode, this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoginViewModel$securityCheck$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<Object> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<Object> securityCheckData = this.this$0.getSecurityCheckData();
            this.L$0 = securityCheckData;
            this.label = 1;
            Object securityCheck = this.this$0.repository.securityCheck(this.$contactInfo, this.$countryCallingCode, this.$scene, this.$verificationCode, this.$type, this);
            if (securityCheck == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = securityCheckData;
            obj = securityCheck;
        } else if (i == 1) {
            stateLiveData = (StateLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        stateLiveData.postSuccess(obj);
        return Unit.INSTANCE;
    }
}
