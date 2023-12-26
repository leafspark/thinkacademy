package com.tal.app.thinkacademy.live.business.teachercameup.view;

import android.os.Handler;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/teachercameup/view/TeacherCameUpSmallView$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherCameUpSmallView.kt */
public final class TeacherCameUpSmallView$mHandler$1 extends Handler {
    final /* synthetic */ TeacherCameUpSmallView this$0;

    TeacherCameUpSmallView$mHandler$1(TeacherCameUpSmallView teacherCameUpSmallView) {
        this.this$0 = teacherCameUpSmallView;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        super.handleMessage(message);
        int i = message.what;
        if (i == this.this$0.KCloseMic) {
            this.this$0.mBinding.ivMic1.setEnabled(false);
            this.this$0.mBinding.ivMic2.setEnabled(false);
        } else if (i == this.this$0.KUpdateMic) {
            this.this$0.mBinding.ivMic1.setEnabled(true);
            this.this$0.mBinding.ivMic2.setEnabled(true);
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}