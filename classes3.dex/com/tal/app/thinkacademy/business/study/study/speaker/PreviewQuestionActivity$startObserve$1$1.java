package com.tal.app.thinkacademy.business.study.study.speaker;

import com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity;
import com.tal.app.thinkacademy.business.study.study.speaker.viewmodel.PreviewQuestionVM;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewQuestionActivity.kt */
final class PreviewQuestionActivity$startObserve$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PreviewQuestionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewQuestionActivity$startObserve$1$1(PreviewQuestionActivity previewQuestionActivity) {
        super(0);
        this.this$0 = previewQuestionActivity;
    }

    public final void invoke() {
        LoadStatusView loadStatusView = this.this$0.getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        Integer num = null;
        LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        PreviewQuestionVM access$getMViewModel = this.this$0.getMViewModel();
        JumpParamsEntity access$getMJumpParams$p = this.this$0.mJumpParams;
        String homeworkId = access$getMJumpParams$p == null ? null : access$getMJumpParams$p.getHomeworkId();
        JumpParamsEntity access$getMJumpParams$p2 = this.this$0.mJumpParams;
        if (access$getMJumpParams$p2 != null) {
            num = access$getMJumpParams$p2.getPlanId();
        }
        Intrinsics.checkNotNull(num);
        access$getMViewModel.getPaperDetail(homeworkId, num);
    }
}
