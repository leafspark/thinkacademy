package com.tal.app.thinkacademy.business.login.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.business.login.entity.SetPasswordData;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013JG\u0010\u0014\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/ChangePasswordViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "changePasswordData", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "", "getChangePasswordData", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setChangePasswordData", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "setPasswordData", "Lcom/tal/app/thinkacademy/business/login/entity/SetPasswordData;", "getSetPasswordData", "setSetPasswordData", "changePassword", "", "password", "", "setPassword", "accountName", "verificationCode", "countryCallingCode", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChangePasswordViewModel.kt */
public final class ChangePasswordViewModel extends BaseViewModel {
    private StateLiveData<Object> changePasswordData = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final LoginRepository repository = new LoginRepository();
    private StateLiveData<SetPasswordData> setPasswordData = new StateLiveData<>();

    public final StateLiveData<SetPasswordData> getSetPasswordData() {
        return this.setPasswordData;
    }

    public final void setSetPasswordData(StateLiveData<SetPasswordData> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.setPasswordData = stateLiveData;
    }

    public static /* synthetic */ void setPassword$default(ChangePasswordViewModel changePasswordViewModel, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        if ((i & 16) != 0) {
            num = 1;
        }
        changePasswordViewModel.setPassword(str, str2, str3, str4, num);
    }

    public final void setPassword(String str, String str2, String str3, String str4, Integer num) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ChangePasswordViewModel$setPassword$1(this)), (CoroutineStart) null, new ChangePasswordViewModel$setPassword$2(this, str, str2, str3, str4, num, (Continuation<? super ChangePasswordViewModel$setPassword$2>) null), 2, (Object) null);
    }

    public final StateLiveData<Object> getChangePasswordData() {
        return this.changePasswordData;
    }

    public final void setChangePasswordData(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.changePasswordData = stateLiveData;
    }

    public static /* synthetic */ void changePassword$default(ChangePasswordViewModel changePasswordViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        changePasswordViewModel.changePassword(str);
    }

    public final void changePassword(String str) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ChangePasswordViewModel$changePassword$1(this)), (CoroutineStart) null, new ChangePasswordViewModel$changePassword$2(this, str, (Continuation<? super ChangePasswordViewModel$changePassword$2>) null), 2, (Object) null);
    }
}
