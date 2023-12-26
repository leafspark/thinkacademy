package com.tal.app.thinkacademy.live.business.mediacontroller.feedback;

import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tal/app/thinkacademy/live/business/mediacontroller/feedback/FeedBackPlayBackView$mRunnable$1", "Ljava/lang/Runnable;", "run", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBackPlayBackView.kt */
public final class FeedBackPlayBackView$mRunnable$1 implements Runnable {
    final /* synthetic */ FeedBackPlayBackView this$0;

    FeedBackPlayBackView$mRunnable$1(FeedBackPlayBackView feedBackPlayBackView) {
        this.this$0 = feedBackPlayBackView;
    }

    public void run() {
        ToastUtils.showLong(R.string.playback_feedback_submit_failed);
        this.this$0.sendServer((String) null);
    }
}
