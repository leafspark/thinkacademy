package com.tal.app.thinkacademy.business.login.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.business.login.entity.AccountListEntity;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/MyAccountListViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "accountList", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/login/entity/AccountListEntity;", "getAccountList", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setAccountList", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "loginData", "Lcom/tal/app/thinkacademy/common/user/UserBean;", "getLoginData", "setLoginData", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "getBasicUserInfo", "", "switchLogin", "uid", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MyAccountListViewModel.kt */
public final class MyAccountListViewModel extends BaseViewModel {
    private StateLiveData<AccountListEntity> accountList = new StateLiveData<>();
    private StateLiveData<UserBean> loginData = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final LoginRepository repository = new LoginRepository();

    public final StateLiveData<AccountListEntity> getAccountList() {
        return this.accountList;
    }

    public final void setAccountList(StateLiveData<AccountListEntity> stateLiveData) {
        this.accountList = stateLiveData;
    }

    public final void getBasicUserInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new MyAccountListViewModel$getBasicUserInfo$1(this)), (CoroutineStart) null, new MyAccountListViewModel$getBasicUserInfo$2(this, (Continuation<? super MyAccountListViewModel$getBasicUserInfo$2>) null), 2, (Object) null);
    }

    public final StateLiveData<UserBean> getLoginData() {
        return this.loginData;
    }

    public final void setLoginData(StateLiveData<UserBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.loginData = stateLiveData;
    }

    public final void switchLogin(String str) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new MyAccountListViewModel$switchLogin$1(this)), (CoroutineStart) null, new MyAccountListViewModel$switchLogin$2(this, str, (Continuation<? super MyAccountListViewModel$switchLogin$2>) null), 2, (Object) null);
    }
}
