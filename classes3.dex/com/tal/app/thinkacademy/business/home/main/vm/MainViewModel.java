package com.tal.app.thinkacademy.business.home.main.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.home.main.api.HomeRepository;
import com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0010R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/vm/MainViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "clientLogin", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "", "getClientLogin", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setClientLogin", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "mLessonReminder", "Lcom/tal/app/thinkacademy/business/home/main/bean/LessonReminderData;", "getMLessonReminder", "setMLessonReminder", "repository", "Lcom/tal/app/thinkacademy/business/home/main/api/HomeRepository;", "", "clientId", "", "clientType", "", "getLessonReminder", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MainViewModel.kt */
public final class MainViewModel extends BaseViewModel {
    private StateLiveData<Object> clientLogin = new StateLiveData<>();
    private StateLiveData<LessonReminderData> mLessonReminder = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final HomeRepository repository = new HomeRepository();

    public final StateLiveData<Object> getClientLogin() {
        return this.clientLogin;
    }

    public final void setClientLogin(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.clientLogin = stateLiveData;
    }

    public final void clientLogin(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "clientId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new MainViewModel$clientLogin$1(this)), (CoroutineStart) null, new MainViewModel$clientLogin$2(this, str, i, (Continuation<? super MainViewModel$clientLogin$2>) null), 2, (Object) null);
    }

    public final StateLiveData<LessonReminderData> getMLessonReminder() {
        return this.mLessonReminder;
    }

    public final void setMLessonReminder(StateLiveData<LessonReminderData> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mLessonReminder = stateLiveData;
    }

    public final void getLessonReminder() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new MainViewModel$getLessonReminder$1(this)), (CoroutineStart) null, new MainViewModel$getLessonReminder$2(this, (Continuation<? super MainViewModel$getLessonReminder$2>) null), 2, (Object) null);
    }
}
