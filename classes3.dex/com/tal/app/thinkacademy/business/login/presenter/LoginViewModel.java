package com.tal.app.thinkacademy.business.login.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019J6\u0010 \u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019J7\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010%JA\u0010&\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001c2\b\u0010!\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010'R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006("}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/LoginViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "accountLoginData", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/common/user/UserBean;", "getAccountLoginData", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setAccountLoginData", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "codeData", "", "getCodeData", "setCodeData", "loginData", "getLoginData", "setLoginData", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "securityCheckData", "getSecurityCheckData", "setSecurityCheckData", "accountLogin", "", "accountName", "", "password", "type", "", "countryCallingCode", "accountType", "registerType", "codeLogin", "verificationCode", "getSmsCode", "contactInfo", "scene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "securityCheck", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoginViewModel.kt */
public final class LoginViewModel extends BaseViewModel {
    private StateLiveData<UserBean> accountLoginData = new StateLiveData<>();
    private StateLiveData<Object> codeData = new StateLiveData<>();
    private StateLiveData<UserBean> loginData = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final LoginRepository repository = new LoginRepository();
    private StateLiveData<Object> securityCheckData = new StateLiveData<>();

    public final StateLiveData<Object> getCodeData() {
        return this.codeData;
    }

    public final void setCodeData(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.codeData = stateLiveData;
    }

    public static /* synthetic */ void getSmsCode$default(LoginViewModel loginViewModel, String str, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = 1;
        }
        if ((i & 8) != 0) {
            num2 = 1;
        }
        loginViewModel.getSmsCode(str, str2, num, num2);
    }

    public final void getSmsCode(String str, String str2, Integer num, Integer num2) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new LoginViewModel$getSmsCode$1(this)), (CoroutineStart) null, new LoginViewModel$getSmsCode$2(this, str, str2, num, num2, (Continuation<? super LoginViewModel$getSmsCode$2>) null), 2, (Object) null);
    }

    public final StateLiveData<UserBean> getLoginData() {
        return this.loginData;
    }

    public final void setLoginData(StateLiveData<UserBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.loginData = stateLiveData;
    }

    public final void codeLogin(String str, String str2, String str3, int i, String str4, String str5) {
        String str6 = str4;
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str, "countryCallingCode");
        Intrinsics.checkNotNullParameter(str2, "verificationCode");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "accountName");
        Intrinsics.checkNotNullParameter(str6, "accountType");
        Intrinsics.checkNotNullParameter(str7, "registerType");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new LoginViewModel$codeLogin$1(this, str6, str7)), (CoroutineStart) null, new LoginViewModel$codeLogin$2(this, str, str2, str8, i, str6, str7, (Continuation<? super LoginViewModel$codeLogin$2>) null), 2, (Object) null);
    }

    public final StateLiveData<UserBean> getAccountLoginData() {
        return this.accountLoginData;
    }

    public final void setAccountLoginData(StateLiveData<UserBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.accountLoginData = stateLiveData;
    }

    public final void accountLogin(String str, String str2, int i, String str3, String str4, String str5) {
        String str6 = str4;
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str, "accountName");
        Intrinsics.checkNotNullParameter(str2, "password");
        Intrinsics.checkNotNullParameter(str6, "accountType");
        Intrinsics.checkNotNullParameter(str7, "registerType");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new LoginViewModel$accountLogin$1(this, str6, str7)), (CoroutineStart) null, new LoginViewModel$accountLogin$2(this, str, str2, i, str3, str6, str7, (Continuation<? super LoginViewModel$accountLogin$2>) null), 2, (Object) null);
    }

    public final StateLiveData<Object> getSecurityCheckData() {
        return this.securityCheckData;
    }

    public final void setSecurityCheckData(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.securityCheckData = stateLiveData;
    }

    public static /* synthetic */ void securityCheck$default(LoginViewModel loginViewModel, String str, String str2, Integer num, String str3, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = 14;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            num2 = 1;
        }
        loginViewModel.securityCheck(str, str2, num3, str3, num2);
    }

    public final void securityCheck(String str, String str2, Integer num, String str3, Integer num2) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new LoginViewModel$securityCheck$1(this)), (CoroutineStart) null, new LoginViewModel$securityCheck$2(this, str, str2, num, str3, num2, (Continuation<? super LoginViewModel$securityCheck$2>) null), 2, (Object) null);
    }
}
