package com.tal.app.thinkacademy.business.login.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.business.login.entity.BannersData;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.entity.InitEntryInfoBean;
import com.tal.app.thinkacademy.common.user.BasicUserInfo;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u000f\u001a\u00020\u0016R&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/MePageViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "bannersData", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "", "Lcom/tal/app/thinkacademy/business/login/entity/BannersData;", "getBannersData", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setBannersData", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "basicUserInfoData", "Lcom/tal/app/thinkacademy/common/user/BasicUserInfo;", "getBasicUserInfoData", "setBasicUserInfoData", "initEntryInfoData", "Lcom/tal/app/thinkacademy/common/entity/InitEntryInfoBean;", "getInitEntryInfoData", "setInitEntryInfoData", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "bannersDataData", "", "getBasicUserInfo", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MePageViewModel.kt */
public final class MePageViewModel extends BaseViewModel {
    private StateLiveData<List<BannersData>> bannersData = new StateLiveData<>();
    private StateLiveData<BasicUserInfo> basicUserInfoData = new StateLiveData<>();
    private StateLiveData<InitEntryInfoBean> initEntryInfoData = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final LoginRepository repository = new LoginRepository();

    public final StateLiveData<BasicUserInfo> getBasicUserInfoData() {
        return this.basicUserInfoData;
    }

    public final void setBasicUserInfoData(StateLiveData<BasicUserInfo> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.basicUserInfoData = stateLiveData;
    }

    public final void getBasicUserInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new MePageViewModel$getBasicUserInfo$1(this)), (CoroutineStart) null, new MePageViewModel$getBasicUserInfo$2(this, (Continuation<? super MePageViewModel$getBasicUserInfo$2>) null), 2, (Object) null);
    }

    public final StateLiveData<InitEntryInfoBean> getInitEntryInfoData() {
        return this.initEntryInfoData;
    }

    public final void setInitEntryInfoData(StateLiveData<InitEntryInfoBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.initEntryInfoData = stateLiveData;
    }

    public final void initEntryInfoData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new MePageViewModel$initEntryInfoData$1(this)), (CoroutineStart) null, new MePageViewModel$initEntryInfoData$2(this, (Continuation<? super MePageViewModel$initEntryInfoData$2>) null), 2, (Object) null);
    }

    public final StateLiveData<List<BannersData>> getBannersData() {
        return this.bannersData;
    }

    public final void setBannersData(StateLiveData<List<BannersData>> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.bannersData = stateLiveData;
    }

    public final void bannersDataData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new MePageViewModel$bannersDataData$1(this)), (CoroutineStart) null, new MePageViewModel$bannersDataData$2(this, (Continuation<? super MePageViewModel$bannersDataData$2>) null), 2, (Object) null);
    }
}
