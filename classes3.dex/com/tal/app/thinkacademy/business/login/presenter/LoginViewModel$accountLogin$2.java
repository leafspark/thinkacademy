package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.user.UserBean;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.presenter.LoginViewModel$accountLogin$2", f = "LoginViewModel.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LoginViewModel.kt */
final class LoginViewModel$accountLogin$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountName;
    final /* synthetic */ String $accountType;
    final /* synthetic */ String $countryCallingCode;
    final /* synthetic */ String $password;
    final /* synthetic */ String $registerType;
    final /* synthetic */ int $type;
    Object L$0;
    int label;
    final /* synthetic */ LoginViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginViewModel$accountLogin$2(LoginViewModel loginViewModel, String str, String str2, int i, String str3, String str4, String str5, Continuation<? super LoginViewModel$accountLogin$2> continuation) {
        super(2, continuation);
        this.this$0 = loginViewModel;
        this.$accountName = str;
        this.$password = str2;
        this.$type = i;
        this.$countryCallingCode = str3;
        this.$accountType = str4;
        this.$registerType = str5;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginViewModel$accountLogin$2(this.this$0, this.$accountName, this.$password, this.$type, this.$countryCallingCode, this.$accountType, this.$registerType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoginViewModel$accountLogin$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<UserBean> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<UserBean> accountLoginData = this.this$0.getAccountLoginData();
            this.L$0 = accountLoginData;
            this.label = 1;
            Object accountLogin = this.this$0.repository.accountLogin(this.$accountName, this.$password, this.$type, this.$countryCallingCode, this);
            if (accountLogin == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = accountLoginData;
            obj = accountLogin;
        } else if (i == 1) {
            stateLiveData = (StateLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        stateLiveData.postSuccess(obj);
        LoginTrack.INSTANCE.signInClick(this.$accountType, this.$registerType, 1);
        return Unit.INSTANCE;
    }
}
