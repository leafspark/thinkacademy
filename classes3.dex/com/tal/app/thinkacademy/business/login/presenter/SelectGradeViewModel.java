package com.tal.app.thinkacademy.business.login.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/SelectGradeViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "gradeStageList", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/common/user/GradeStageList;", "getGradeStageList", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setGradeStageList", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectGradeViewModel.kt */
public final class SelectGradeViewModel extends BaseViewModel {
    private StateLiveData<GradeStageList> gradeStageList = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final LoginRepository repository = new LoginRepository();

    public final StateLiveData<GradeStageList> getGradeStageList() {
        return this.gradeStageList;
    }

    public final void setGradeStageList(StateLiveData<GradeStageList> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.gradeStageList = stateLiveData;
    }

    /* renamed from: getGradeStageList  reason: collision with other method in class */
    public final void m53getGradeStageList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new SelectGradeViewModel$getGradeStageList$1(this)), (CoroutineStart) null, new SelectGradeViewModel$getGradeStageList$2(this, (Continuation<? super SelectGradeViewModel$getGradeStageList$2>) null), 2, (Object) null);
    }
}
