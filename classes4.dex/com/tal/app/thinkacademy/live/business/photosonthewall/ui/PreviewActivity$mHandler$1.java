package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/photosonthewall/ui/PreviewActivity$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewActivity.kt */
public final class PreviewActivity$mHandler$1 extends Handler {
    final /* synthetic */ PreviewActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewActivity$mHandler$1(PreviewActivity previewActivity, Looper looper) {
        super(looper);
        this.this$0 = previewActivity;
    }

    public void handleMessage(Message message) {
        RoundLinearLayout roundLinearLayout;
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        if (message.what == this.this$0.KSubmissionFailed && (roundLinearLayout = this.this$0.getBinding().llSubmissionFailed) != null) {
            roundLinearLayout.setVisibility(8);
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
