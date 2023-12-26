package com.tal.app.thinkacademy.business.home.main;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/home/main/MainActivityLogic$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MainActivityLogic.kt */
public final class MainActivityLogic$mHandler$1 extends Handler {
    final /* synthetic */ MainActivityLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivityLogic$mHandler$1(MainActivityLogic mainActivityLogic, Looper looper) {
        super(looper);
        this.this$0 = mainActivityLogic;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        super.handleMessage(message);
        int i = message.what;
        if (i == this.this$0.KShowStartClass) {
            XesLog.i(Tag.MainActivity, new Object[]{"KShowStartClass"});
            MainActivityLogic.getLessonReminder$default(this.this$0, (Integer) null, 1, (Object) null);
        } else if (i == this.this$0.KGoneStartClass) {
            XesLog.i(Tag.MainActivity, new Object[]{"KGoneStartClass"});
            MainActivityLogic.getLessonReminder$default(this.this$0, (Integer) null, 1, (Object) null);
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
