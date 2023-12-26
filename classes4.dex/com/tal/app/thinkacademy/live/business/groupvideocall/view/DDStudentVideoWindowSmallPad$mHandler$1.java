package com.tal.app.thinkacademy.live.business.groupvideocall.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/groupvideocall/view/DDStudentVideoWindowSmallPad$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DDStudentVideoWindowSmallPad.kt */
public final class DDStudentVideoWindowSmallPad$mHandler$1 extends Handler {
    final /* synthetic */ DDStudentVideoWindowSmallPad this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DDStudentVideoWindowSmallPad$mHandler$1(DDStudentVideoWindowSmallPad dDStudentVideoWindowSmallPad, Looper looper) {
        super(looper);
        this.this$0 = dDStudentVideoWindowSmallPad;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        super.handleMessage(message);
        int i = message.what;
        if (i == this.this$0.KCloseMic) {
            this.this$0.mViewBinding.ivMic.setEnabled(false);
        } else if (i == this.this$0.KUpdateMic) {
            this.this$0.mViewBinding.ivMic.setEnabled(true);
        } else if (i == this.this$0.KVideoShow) {
            CardView cardView = this.this$0.mViewBinding.rlBg;
            if (cardView != null) {
                cardView.setVisibility(8);
            }
        } else if (i == this.this$0.KVideoGone) {
            CardView cardView2 = this.this$0.mViewBinding.rlBg;
            if (cardView2 != null) {
                cardView2.setVisibility(0);
            }
        } else if (i == this.this$0.KCloseFace) {
            EmojiView emojiView = this.this$0.mViewBinding.emojiView;
            if (emojiView != null) {
                emojiView.setVisibility(8);
            }
            LinearLayout linearLayout = this.this$0.mViewBinding.emojiViewBg;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
