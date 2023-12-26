package com.tal.app.thinkacademy.business.login.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.business.login.entity.AccountCheckData;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\n\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u0015R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/SettingsViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "accountCheckData", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/login/entity/AccountCheckData;", "getAccountCheckData", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setAccountCheckData", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "accountSwitchSchool", "", "getAccountSwitchSchool", "setAccountSwitchSchool", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "signOutData", "", "getSignOutData", "setSignOutData", "accountCheck", "", "schoolCode", "signOut", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsViewModel.kt */
public final class SettingsViewModel extends BaseViewModel {
    private StateLiveData<AccountCheckData> accountCheckData = new StateLiveData<>();
    private StateLiveData<Integer> accountSwitchSchool = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final LoginRepository repository = new LoginRepository();
    private StateLiveData<Object> signOutData = new StateLiveData<>();

    public final StateLiveData<Object> getSignOutData() {
        return this.signOutData;
    }

    public final void setSignOutData(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.signOutData = stateLiveData;
    }

    public final void signOut() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new SettingsViewModel$signOut$1(this)), (CoroutineStart) null, new SettingsViewModel$signOut$2(this, (Continuation<? super SettingsViewModel$signOut$2>) null), 2, (Object) null);
    }

    public final StateLiveData<AccountCheckData> getAccountCheckData() {
        return this.accountCheckData;
    }

    public final void setAccountCheckData(StateLiveData<AccountCheckData> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.accountCheckData = stateLiveData;
    }

    public final void accountCheck() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new SettingsViewModel$accountCheck$1(this)), (CoroutineStart) null, new SettingsViewModel$accountCheck$2(this, (Continuation<? super SettingsViewModel$accountCheck$2>) null), 2, (Object) null);
    }

    public final StateLiveData<Integer> getAccountSwitchSchool() {
        return this.accountSwitchSchool;
    }

    public final void setAccountSwitchSchool(StateLiveData<Integer> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.accountSwitchSchool = stateLiveData;
    }

    public final void accountSwitchSchool(int i) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new SettingsViewModel$accountSwitchSchool$1(this)), (CoroutineStart) null, new SettingsViewModel$accountSwitchSchool$2(this, i, (Continuation<? super SettingsViewModel$accountSwitchSchool$2>) null), 2, (Object) null);
    }
}
