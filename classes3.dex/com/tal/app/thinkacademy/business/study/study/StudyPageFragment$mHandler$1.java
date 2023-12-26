package com.tal.app.thinkacademy.business.study.study;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/study/study/StudyPageFragment$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyPageFragment.kt */
public final class StudyPageFragment$mHandler$1 extends Handler {
    final /* synthetic */ StudyPageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudyPageFragment$mHandler$1(StudyPageFragment studyPageFragment, Looper looper) {
        super(looper);
        this.this$0 = studyPageFragment;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        super.handleMessage(message);
        if (message.what == this.this$0.KTabSwitch) {
            this.this$0.isGetSchoolsTimeout = true;
            this.this$0.showLive();
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
