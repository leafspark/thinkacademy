package com.tal.app.thinkacademy.business.study.study.ready;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.study.study.entity.ReadyClassBackBean;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ$\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ready/ReadyClassBackVM;", "Lcom/tal/app/thinkacademy/business/study/study/ready/ReadyClassBaseVM;", "()V", "mReadyClassBean", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/study/study/entity/ReadyClassBackBean;", "getMReadyClassBean", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "requestInitModule", "", "planId", "", "requestPlaybackEnter", "courseId", "bizId", "requestPlaybackInfo", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadyClassBackVM.kt */
public final class ReadyClassBackVM extends ReadyClassBaseVM {
    private final StateLiveData<ReadyClassBackBean> mReadyClassBean = new StateLiveData<>();

    public final StateLiveData<ReadyClassBackBean> getMReadyClassBean() {
        return this.mReadyClassBean;
    }

    public final void requestPlaybackInfo(String str) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ReadyClassBackVM$requestPlaybackInfo$1(this)), (CoroutineStart) null, new ReadyClassBackVM$requestPlaybackInfo$2(str, this, (Continuation<? super ReadyClassBackVM$requestPlaybackInfo$2>) null), 2, (Object) null);
    }

    public final void requestPlaybackEnter(String str, String str2, String str3) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ReadyClassBackVM$requestPlaybackEnter$1()), (CoroutineStart) null, new ReadyClassBackVM$requestPlaybackEnter$2(str, str2, str3, (Continuation<? super ReadyClassBackVM$requestPlaybackEnter$2>) null), 2, (Object) null);
    }

    public final void requestInitModule(String str) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ReadyClassBackVM$requestInitModule$1()), (CoroutineStart) null, new ReadyClassBackVM$requestInitModule$2(str, (Continuation<? super ReadyClassBackVM$requestInitModule$2>) null), 2, (Object) null);
    }
}
