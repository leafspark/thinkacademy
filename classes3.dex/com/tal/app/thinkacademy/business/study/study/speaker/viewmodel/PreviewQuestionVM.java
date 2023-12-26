package com.tal.app.thinkacademy.business.study.study.speaker.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.PaperDetailEntity;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/viewmodel/PreviewQuestionVM;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "jumpUrl", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "", "getJumpUrl", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setJumpUrl", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "paperDetailData", "Lcom/tal/app/thinkacademy/business/study/study/entity/PaperDetailEntity;", "getPaperDetailData", "setPaperDetailData", "getPaperDetail", "", "paperId", "planId", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getPreQuestionJumpUrl", "jumpParamsEntity", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewQuestionVM.kt */
public final class PreviewQuestionVM extends BaseViewModel {
    private StateLiveData<String> jumpUrl = new StateLiveData<>();
    private StateLiveData<PaperDetailEntity> paperDetailData = new StateLiveData<>();

    public final StateLiveData<PaperDetailEntity> getPaperDetailData() {
        return this.paperDetailData;
    }

    public final void setPaperDetailData(StateLiveData<PaperDetailEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.paperDetailData = stateLiveData;
    }

    public final void getPaperDetail(String str, Integer num) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PreviewQuestionVM$getPaperDetail$1(this)), (CoroutineStart) null, new PreviewQuestionVM$getPaperDetail$2(this, str, num, (Continuation<? super PreviewQuestionVM$getPaperDetail$2>) null), 2, (Object) null);
    }

    public final StateLiveData<String> getJumpUrl() {
        return this.jumpUrl;
    }

    public final void setJumpUrl(StateLiveData<String> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.jumpUrl = stateLiveData;
    }

    public final void getPreQuestionJumpUrl(JumpParamsEntity jumpParamsEntity) {
        Intrinsics.checkNotNullParameter(jumpParamsEntity, "jumpParamsEntity");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new PreviewQuestionVM$getPreQuestionJumpUrl$1(this)), (CoroutineStart) null, new PreviewQuestionVM$getPreQuestionJumpUrl$2(this, jumpParamsEntity, (Continuation<? super PreviewQuestionVM$getPreQuestionJumpUrl$2>) null), 2, (Object) null);
    }
}
