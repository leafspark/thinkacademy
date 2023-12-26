package com.tal.app.thinkacademy.business.study.study.speaker.viewmodel;

import com.tal.app.thinkacademy.lib.network.exception.IError;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/business/study/study/speaker/viewmodel/PreviewQuestionVM$getPaperDetail$1", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewQuestionVM.kt */
public final class PreviewQuestionVM$getPaperDetail$1 implements IError {
    final /* synthetic */ PreviewQuestionVM this$0;

    PreviewQuestionVM$getPaperDetail$1(PreviewQuestionVM previewQuestionVM) {
        this.this$0 = previewQuestionVM;
    }

    public void onFail(int i, String str) {
        this.this$0.getPaperDetailData().postFailure(i, str);
    }

    public void onError(int i, String str) {
        this.this$0.getPaperDetailData().postError(i, str);
    }
}