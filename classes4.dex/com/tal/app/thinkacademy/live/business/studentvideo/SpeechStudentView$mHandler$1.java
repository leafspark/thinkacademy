package com.tal.app.thinkacademy.live.business.studentvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/studentvideo/SpeechStudentView$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeechStudentView.kt */
public final class SpeechStudentView$mHandler$1 extends Handler {
    final /* synthetic */ SpeechStudentView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpeechStudentView$mHandler$1(SpeechStudentView speechStudentView, Looper looper) {
        super(looper);
        this.this$0 = speechStudentView;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        super.handleMessage(message);
        if (message.what == this.this$0.KUpdateMic) {
            removeMessages(this.this$0.KUpdateMic);
            String access$getMaxStuNameStr = this.this$0.getMaxStuNameStr();
            if (access$getMaxStuNameStr.length() > 0) {
                this.this$0.mBinding.tvSpeechStudent.setText(Intrinsics.stringPlus(this.this$0.mContext.getString(R.string.student_speaking), access$getMaxStuNameStr));
                this.this$0.setVisibility(0);
                sendEmptyMessageDelayed(this.this$0.KUpdateMic, 1000);
            } else {
                this.this$0.setVisibility(8);
            }
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
