package com.tal.app.thinkacademy.business.study.study.speaker;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class PreviewQuestionActivity$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ PreviewQuestionActivity f$0;

    public /* synthetic */ PreviewQuestionActivity$$ExternalSyntheticLambda3(PreviewQuestionActivity previewQuestionActivity) {
        this.f$0 = previewQuestionActivity;
    }

    public final void onChanged(Object obj) {
        PreviewQuestionActivity.m480startObserve$lambda1(this.f$0, (StateData) obj);
    }
}
