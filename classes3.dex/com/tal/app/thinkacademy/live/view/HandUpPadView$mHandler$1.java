package com.tal.app.thinkacademy.live.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/view/HandUpPadView$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HandUpPadView.kt */
public final class HandUpPadView$mHandler$1 extends Handler {
    final /* synthetic */ HandUpPadView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandUpPadView$mHandler$1(HandUpPadView handUpPadView, Looper looper) {
        super(looper);
        this.this$0 = handUpPadView;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        super.handleMessage(message);
        if (message.what == 1) {
            if (this.this$0.currentTime > 0.0f) {
                TextView access$getMTvHandUpTime$p = this.this$0.mTvHandUpTime;
                if (access$getMTvHandUpTime$p != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((int) ((float) Math.ceil((double) this.this$0.currentTime)));
                    sb.append('s');
                    access$getMTvHandUpTime$p.setText(sb.toString());
                }
                ProgressBar access$getMBarHandUp$p = this.this$0.mBarHandUp;
                if (access$getMBarHandUp$p != null) {
                    access$getMBarHandUp$p.setProgress(this.this$0.currentProgress);
                }
                sendEmptyMessageDelayed(1, 100);
            } else {
                this.this$0.endHandUp();
            }
            HandUpPadView handUpPadView = this.this$0;
            handUpPadView.currentTime = handUpPadView.currentTime - 0.1f;
            HandUpPadView handUpPadView2 = this.this$0;
            handUpPadView2.currentProgress = handUpPadView2.currentProgress + 1;
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
