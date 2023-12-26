package com.tal.app.thinkacademy.business.study.study.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.study.study.entity.CheckInData;
import com.tal.app.thinkacademy.business.study.study.entity.CheckInStatus;
import com.tal.app.thinkacademy.business.study.study.entity.PlaybackOfflineBean;
import com.tal.app.thinkacademy.business.study.study.entity.PrepareClassBean;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010!J\u001f\u0010\"\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001fJ\u0006\u0010#\u001a\u00020\u001bJ\u0015\u0010$\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010!R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vm/PrepareClassVM;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "netStatus", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "", "getNetStatus", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setNetStatus", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "offlineZip", "Lcom/tal/app/thinkacademy/business/study/study/entity/PlaybackOfflineBean;", "getOfflineZip", "setOfflineZip", "prepareCheckInData", "Lcom/tal/app/thinkacademy/business/study/study/entity/CheckInData;", "getPrepareCheckInData", "setPrepareCheckInData", "prepareCheckInStatus", "Lcom/tal/app/thinkacademy/business/study/study/entity/CheckInStatus;", "getPrepareCheckInStatus", "setPrepareCheckInStatus", "prepareDataStatus", "Lcom/tal/app/thinkacademy/business/study/study/entity/PrepareClassBean;", "getPrepareDataStatus", "setPrepareDataStatus", "checkInStatus", "", "planId", "", "classId", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getOfflineData", "(Ljava/lang/Integer;)V", "requestCheckIn", "requestNetStatus", "requestPrepareData", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareClassVM.kt */
public final class PrepareClassVM extends BaseViewModel {
    private StateLiveData<Object> netStatus = new StateLiveData<>();
    private StateLiveData<PlaybackOfflineBean> offlineZip = new StateLiveData<>();
    private StateLiveData<CheckInData> prepareCheckInData = new StateLiveData<>();
    private StateLiveData<CheckInStatus> prepareCheckInStatus = new StateLiveData<>();
    private StateLiveData<PrepareClassBean> prepareDataStatus = new StateLiveData<>();

    public final StateLiveData<Object> getNetStatus() {
        return this.netStatus;
    }

    public final void setNetStatus(StateLiveData<Object> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.netStatus = stateLiveData;
    }

    public final StateLiveData<PrepareClassBean> getPrepareDataStatus() {
        return this.prepareDataStatus;
    }

    public final void setPrepareDataStatus(StateLiveData<PrepareClassBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.prepareDataStatus = stateLiveData;
    }

    public final StateLiveData<CheckInStatus> getPrepareCheckInStatus() {
        return this.prepareCheckInStatus;
    }

    public final void setPrepareCheckInStatus(StateLiveData<CheckInStatus> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.prepareCheckInStatus = stateLiveData;
    }

    public final StateLiveData<CheckInData> getPrepareCheckInData() {
        return this.prepareCheckInData;
    }

    public final void setPrepareCheckInData(StateLiveData<CheckInData> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.prepareCheckInData = stateLiveData;
    }

    public final StateLiveData<PlaybackOfflineBean> getOfflineZip() {
        return this.offlineZip;
    }

    public final void setOfflineZip(StateLiveData<PlaybackOfflineBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.offlineZip = stateLiveData;
    }

    public final void requestNetStatus() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PrepareClassVM$requestNetStatus$1(this)), (CoroutineStart) null, new PrepareClassVM$requestNetStatus$2(this, (Continuation<? super PrepareClassVM$requestNetStatus$2>) null), 2, (Object) null);
    }

    public final void requestPrepareData(Integer num) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PrepareClassVM$requestPrepareData$1(this)), (CoroutineStart) null, new PrepareClassVM$requestPrepareData$2(this, num, (Continuation<? super PrepareClassVM$requestPrepareData$2>) null), 2, (Object) null);
    }

    public final void checkInStatus(Integer num, Integer num2) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PrepareClassVM$checkInStatus$1(this)), (CoroutineStart) null, new PrepareClassVM$checkInStatus$2(this, num, num2, (Continuation<? super PrepareClassVM$checkInStatus$2>) null), 2, (Object) null);
    }

    public final void requestCheckIn(Integer num, Integer num2) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PrepareClassVM$requestCheckIn$1(this)), (CoroutineStart) null, new PrepareClassVM$requestCheckIn$2(this, num, num2, (Continuation<? super PrepareClassVM$requestCheckIn$2>) null), 2, (Object) null);
    }

    public final void getOfflineData(Integer num) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PrepareClassVM$getOfflineData$1(this)), (CoroutineStart) null, new PrepareClassVM$getOfflineData$2(num, this, (Continuation<? super PrepareClassVM$getOfflineData$2>) null), 2, (Object) null);
    }
}
