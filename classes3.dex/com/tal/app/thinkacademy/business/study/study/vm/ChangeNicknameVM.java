package com.tal.app.thinkacademy.business.study.study.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vm/ChangeNicknameVM;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "changeNickname", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "", "getChangeNickname", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setChangeNickname", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "modifyDisplayName", "", "nickname", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChangeNicknameVM.kt */
public final class ChangeNicknameVM extends BaseViewModel {
    private StateLiveData<Object> changeNickname = new StateLiveData<>();

    public final StateLiveData<Object> getChangeNickname() {
        return this.changeNickname;
    }

    public final void setChangeNickname(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.changeNickname = stateLiveData;
    }

    public final void modifyDisplayName(String str) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ChangeNicknameVM$modifyDisplayName$1(this)), (CoroutineStart) null, new ChangeNicknameVM$modifyDisplayName$2(this, str, (Continuation<? super ChangeNicknameVM$modifyDisplayName$2>) null), 2, (Object) null);
    }
}
