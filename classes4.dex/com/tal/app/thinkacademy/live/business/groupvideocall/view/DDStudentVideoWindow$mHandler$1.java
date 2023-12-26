package com.tal.app.thinkacademy.live.business.groupvideocall.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/groupvideocall/view/DDStudentVideoWindow$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DDStudentVideoWindow.kt */
public final class DDStudentVideoWindow$mHandler$1 extends Handler {
    final /* synthetic */ DDStudentVideoWindow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DDStudentVideoWindow$mHandler$1(DDStudentVideoWindow dDStudentVideoWindow, Looper looper) {
        super(looper);
        this.this$0 = dDStudentVideoWindow;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        super.handleMessage(message);
        int i = message.what;
        if (i == this.this$0.KCloseMic) {
            ImageView imageView = this.this$0.mViewBinding.ivMic;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.live_business_icon_disable_mic);
            }
        } else if (i == this.this$0.KUpdateMic) {
            ImageView imageView2 = this.this$0.mViewBinding.ivMic;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.bg_live_business_mic_layer);
            }
            ImageView imageView3 = this.this$0.mViewBinding.ivMic;
            Drawable drawable = imageView3 == null ? null : imageView3.getDrawable();
            if (drawable != null) {
                Object obj = message.obj;
                if (obj != null) {
                    drawable.setLevel((int) ((float) Math.ceil((double) ((((float) ((Integer) obj).intValue()) * 10000.0f) / ((float) 255)))));
                } else {
                    NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    AsynchronousInstrumentation.handlerMessageEnd();
                    throw nullPointerException;
                }
            }
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
