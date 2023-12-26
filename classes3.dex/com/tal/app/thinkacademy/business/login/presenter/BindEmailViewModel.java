package com.tal.app.thinkacademy.business.login.presenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.login.config.LoginRepository;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/BindEmailViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "emailData", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "", "getEmailData", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setEmailData", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "bindEmail", "", "email", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BindEmailViewModel.kt */
public final class BindEmailViewModel extends BaseViewModel {
    private StateLiveData<Object> emailData = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final LoginRepository repository = new LoginRepository();

    public final StateLiveData<Object> getEmailData() {
        return this.emailData;
    }

    public final void setEmailData(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.emailData = stateLiveData;
    }

    public final void bindEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new BindEmailViewModel$bindEmail$1(this)), (CoroutineStart) null, new BindEmailViewModel$bindEmail$2(this, str, (Continuation<? super BindEmailViewModel$bindEmail$2>) null), 2, (Object) null);
    }
}
