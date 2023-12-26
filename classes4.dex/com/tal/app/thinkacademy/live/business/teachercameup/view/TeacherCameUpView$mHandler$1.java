package com.tal.app.thinkacademy.live.business.teachercameup.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/teachercameup/view/TeacherCameUpView$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherCameUpView.kt */
public final class TeacherCameUpView$mHandler$1 extends Handler {
    final /* synthetic */ TeacherCameUpView this$0;

    TeacherCameUpView$mHandler$1(TeacherCameUpView teacherCameUpView) {
        this.this$0 = teacherCameUpView;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        super.handleMessage(message);
        int i = message.what;
        if (i == this.this$0.KCloseMic) {
            ImageView imageView = this.this$0.mBinding.ivMic1;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.live_business_icon_disable_mic);
            }
            ImageView imageView2 = this.this$0.mBinding.ivMic2;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.live_business_icon_disable_mic);
            }
        } else if (i == this.this$0.KUpdateMic) {
            ImageView imageView3 = this.this$0.mBinding.ivMic1;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.bg_live_business_mic_layer);
            }
            ImageView imageView4 = this.this$0.mBinding.ivMic2;
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.bg_live_business_mic_layer);
            }
            ImageView imageView5 = this.this$0.mBinding.ivMic1;
            Drawable drawable = null;
            Drawable drawable2 = imageView5 == null ? null : imageView5.getDrawable();
            if (drawable2 != null) {
                Object obj = message.obj;
                if (obj != null) {
                    drawable2.setLevel((int) ((float) Math.ceil((double) ((((float) ((Integer) obj).intValue()) * 10000.0f) / ((float) 255)))));
                } else {
                    NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    AsynchronousInstrumentation.handlerMessageEnd();
                    throw nullPointerException;
                }
            }
            ImageView imageView6 = this.this$0.mBinding.ivMic2;
            if (imageView6 != null) {
                drawable = imageView6.getDrawable();
            }
            if (drawable != null) {
                Object obj2 = message.obj;
                if (obj2 != null) {
                    drawable.setLevel((int) ((float) Math.ceil((double) ((((float) ((Integer) obj2).intValue()) * 10000.0f) / ((float) 255)))));
                } else {
                    NullPointerException nullPointerException2 = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    AsynchronousInstrumentation.handlerMessageEnd();
                    throw nullPointerException2;
                }
            }
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
