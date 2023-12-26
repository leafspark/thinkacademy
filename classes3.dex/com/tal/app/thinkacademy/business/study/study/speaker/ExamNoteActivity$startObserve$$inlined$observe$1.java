package com.tal.app.thinkacademy.business.study.study.speaker;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.business.study.study.entity.PaperDetailEntity;
import com.tal.app.thinkacademy.business.study.study.speaker.ExamNoteActivity;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class ExamNoteActivity$startObserve$$inlined$observe$1<T> implements Observer<T> {
    final /* synthetic */ ExamNoteActivity this$0;

    public ExamNoteActivity$startObserve$$inlined$observe$1(ExamNoteActivity examNoteActivity) {
        this.this$0 = examNoteActivity;
    }

    public final void onChanged(T t) {
        StateData stateData = (StateData) t;
        if (ExamNoteActivity.WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            this.this$0.getBinding().loadStatusView.restoreView();
            this.this$0.updateValues((PaperDetailEntity) stateData.getData());
            return;
        }
        LoadStatusView loadStatusView = this.this$0.getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        String msg = stateData.getMsg();
        if (msg == null) {
            msg = this.this$0.getString(R.string.study_center_data_error);
            Intrinsics.checkNotNullExpressionValue(msg, "getString(R.string.study_center_data_error)");
        }
        LoadStatusView.showErrorView$default(loadStatusView, 0, msg, (String) null, (String) null, new ExamNoteActivity$startObserve$1$1(this.this$0), 13, (Object) null);
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showShort(stateData.getMsg(), new Object[0]);
        XesLog.it("ExamInstructionsActivity", new Object[]{stateData.getCode() + "  " + stateData.getMsg()});
    }
}
