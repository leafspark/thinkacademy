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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0002\u0010\u0013R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/FeedbackViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "feedback", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "", "getFeedback", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setFeedback", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "repository", "Lcom/tal/app/thinkacademy/business/login/config/LoginRepository;", "submitFeedback", "", "tag", "", "details", "images", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedbackViewModel.kt */
public final class FeedbackViewModel extends BaseViewModel {
    private StateLiveData<Object> feedback = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final LoginRepository repository = new LoginRepository();

    public final StateLiveData<Object> getFeedback() {
        return this.feedback;
    }

    public final void setFeedback(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.feedback = stateLiveData;
    }

    public static /* synthetic */ void submitFeedback$default(FeedbackViewModel feedbackViewModel, String str, String str2, String[] strArr, int i, Object obj) {
        if ((i & 4) != 0) {
            strArr = new String[0];
        }
        feedbackViewModel.submitFeedback(str, str2, strArr);
    }

    public final void submitFeedback(String str, String str2, String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "images");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new FeedbackViewModel$submitFeedback$1(this)), (CoroutineStart) null, new FeedbackViewModel$submitFeedback$2(this, str, str2, strArr, (Continuation<? super FeedbackViewModel$submitFeedback$2>) null), 2, (Object) null);
    }
}
