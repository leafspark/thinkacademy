package com.tal.app.thinkacademy.business.study.study.speaker;

import com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity;
import com.tal.app.thinkacademy.business.study.study.speaker.viewmodel.PreviewQuestionVM;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewQuestionActivity.kt */
final class PreviewQuestionActivity$init$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PreviewQuestionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewQuestionActivity$init$2(PreviewQuestionActivity previewQuestionActivity) {
        super(0);
        this.this$0 = previewQuestionActivity;
    }

    public final void invoke() {
        int access$getMStatus$p = this.this$0.mStatus;
        boolean z = false;
        if (4 <= access$getMStatus$p && access$getMStatus$p < 7) {
            z = true;
        }
        if (z) {
            PreviewQuestionVM access$getMViewModel = this.this$0.getMViewModel();
            JumpParamsEntity access$getMJumpParams$p = this.this$0.mJumpParams;
            Intrinsics.checkNotNull(access$getMJumpParams$p);
            access$getMViewModel.getPreQuestionJumpUrl(access$getMJumpParams$p);
            this.this$0.track("click_view_resolution");
            this.this$0.showLoading();
            return;
        }
        this.this$0.track("click_begin_to_answer");
        this.this$0.showDialog();
    }
}
