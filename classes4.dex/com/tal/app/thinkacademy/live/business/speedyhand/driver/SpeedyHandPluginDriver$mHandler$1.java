package com.tal.app.thinkacademy.live.business.speedyhand.driver;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.live.business.speedyhand.view.SpeedyHandView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/speedyhand/driver/SpeedyHandPluginDriver$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedyHandPluginDriver.kt */
public final class SpeedyHandPluginDriver$mHandler$1 extends Handler {
    final /* synthetic */ SpeedyHandPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpeedyHandPluginDriver$mHandler$1(SpeedyHandPluginDriver speedyHandPluginDriver, Looper looper) {
        super(looper);
        this.this$0 = speedyHandPluginDriver;
    }

    public void handleMessage(Message message) {
        SpeedyHandView access$getMSpeedyHandView$p;
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        super.handleMessage(message);
        int i = message.what;
        if (i == this.this$0.KCloseView) {
            SpeedyHandView access$getMSpeedyHandView$p2 = this.this$0.mSpeedyHandView;
            if (access$getMSpeedyHandView$p2 != null) {
                access$getMSpeedyHandView$p2.setVisibility(8);
            }
            SpeedyHandView access$getMSpeedyHandView$p3 = this.this$0.mSpeedyHandView;
            if (access$getMSpeedyHandView$p3 != null) {
                access$getMSpeedyHandView$p3.onDestroy();
            }
            this.this$0.mSpeedyHandView = null;
        } else if (i == this.this$0.KShowResult && (access$getMSpeedyHandView$p = this.this$0.mSpeedyHandView) != null) {
            access$getMSpeedyHandView$p.showResultAnimator();
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
