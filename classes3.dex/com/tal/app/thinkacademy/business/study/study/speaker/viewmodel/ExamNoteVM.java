package com.tal.app.thinkacademy.business.study.study.speaker.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.study.study.entity.PaperDetailEntity;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedPaperDetailEntity;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J=\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0017J.\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/viewmodel/ExamNoteVM;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "paperDetailData", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/study/study/entity/PaperDetailEntity;", "getPaperDetailData", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setPaperDetailData", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "recordedPaperDetail", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedPaperDetailEntity;", "getRecordedPaperDetail", "setRecordedPaperDetail", "getPaperOverview", "", "paperId", "", "planId", "", "homeworkType", "classId", "platform", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getRecordedPaperOverview", "entityId", "bindType", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExamNoteVM.kt */
public final class ExamNoteVM extends BaseViewModel {
    private StateLiveData<PaperDetailEntity> paperDetailData = new StateLiveData<>();
    private StateLiveData<RecordedPaperDetailEntity> recordedPaperDetail = new StateLiveData<>();

    public final StateLiveData<PaperDetailEntity> getPaperDetailData() {
        return this.paperDetailData;
    }

    public final void setPaperDetailData(StateLiveData<PaperDetailEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.paperDetailData = stateLiveData;
    }

    public final void getPaperOverview(String str, Integer num, Integer num2, Integer num3, String str2) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ExamNoteVM$getPaperOverview$1(this)), (CoroutineStart) null, new ExamNoteVM$getPaperOverview$2(this, str, num, num2, num3, str2, (Continuation<? super ExamNoteVM$getPaperOverview$2>) null), 2, (Object) null);
    }

    public final StateLiveData<RecordedPaperDetailEntity> getRecordedPaperDetail() {
        return this.recordedPaperDetail;
    }

    public final void setRecordedPaperDetail(StateLiveData<RecordedPaperDetailEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.recordedPaperDetail = stateLiveData;
    }

    public static /* synthetic */ void getRecordedPaperOverview$default(ExamNoteVM examNoteVM, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 1;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        examNoteVM.getRecordedPaperOverview(str, str2, i, i2);
    }

    public final void getRecordedPaperOverview(String str, String str2, int i, int i2) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ExamNoteVM$getRecordedPaperOverview$1(this)), (CoroutineStart) null, new ExamNoteVM$getRecordedPaperOverview$2(this, str, str2, i, i2, (Continuation<? super ExamNoteVM$getRecordedPaperOverview$2>) null), 2, (Object) null);
    }
}
