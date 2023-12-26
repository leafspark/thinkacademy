package com.tal.app.thinkacademy.business.login.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/ChooseTimeZoneViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "timeZoneList", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/login/entity/TimeZoneEntity;", "getTimeZoneList", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setTimeZoneList", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChooseTimeZoneViewModel.kt */
public final class ChooseTimeZoneViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final LoginRepository repository = new LoginRepository();
    private StateLiveData<TimeZoneEntity> timeZoneList = new StateLiveData<>();

    public final StateLiveData<TimeZoneEntity> getTimeZoneList() {
        return this.timeZoneList;
    }

    public final void setTimeZoneList(StateLiveData<TimeZoneEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.timeZoneList = stateLiveData;
    }

    /* renamed from: getTimeZoneList  reason: collision with other method in class */
    public final void m46getTimeZoneList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ChooseTimeZoneViewModel$getTimeZoneList$1(this)), (CoroutineStart) null, new ChooseTimeZoneViewModel$getTimeZoneList$2(this, (Continuation<? super ChooseTimeZoneViewModel$getTimeZoneList$2>) null), 2, (Object) null);
    }
}
