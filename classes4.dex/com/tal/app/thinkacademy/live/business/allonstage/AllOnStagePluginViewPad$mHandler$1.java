package com.tal.app.thinkacademy.live.business.allonstage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.live.business.allonstage.adapter.AllOnstagePadAdapter;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginViewPad$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginViewPad.kt */
public final class AllOnStagePluginViewPad$mHandler$1 extends Handler {
    final /* synthetic */ AllOnStagePluginViewPad this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnStagePluginViewPad$mHandler$1(AllOnStagePluginViewPad allOnStagePluginViewPad, Looper looper) {
        super(looper);
        this.this$0 = allOnStagePluginViewPad;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        super.handleMessage(message);
        switch (message.what) {
            case 10001:
                Object obj = message.obj;
                if (obj != null) {
                    StudentVideoBean.ListBean listBean = (StudentVideoBean.ListBean) obj;
                    listBean.setShowEmoji(false);
                    this.this$0.showEmoji(listBean.getUserId(), new EmojiBean(), false);
                    break;
                } else {
                    NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean.ListBean");
                    AsynchronousInstrumentation.handlerMessageEnd();
                    throw nullPointerException;
                }
            case 10002:
                Object obj2 = message.obj;
                if (obj2 != null) {
                    this.this$0.hideForbidUserView(((StudentVideoBean.ListBean) obj2).getUserId());
                    break;
                } else {
                    NullPointerException nullPointerException2 = new NullPointerException("null cannot be cast to non-null type com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean.ListBean");
                    AsynchronousInstrumentation.handlerMessageEnd();
                    throw nullPointerException2;
                }
            case 10003:
                Object obj3 = message.obj;
                if (obj3 != null) {
                    StudentVideoBean.ListBean listBean2 = (StudentVideoBean.ListBean) obj3;
                    AllOnstagePadAdapter access$getMAdapter$p = this.this$0.mAdapter;
                    if (access$getMAdapter$p != null) {
                        access$getMAdapter$p.showHighLight(listBean2.getUserId(), false);
                        break;
                    }
                } else {
                    NullPointerException nullPointerException3 = new NullPointerException("null cannot be cast to non-null type com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean.ListBean");
                    AsynchronousInstrumentation.handlerMessageEnd();
                    throw nullPointerException3;
                }
                break;
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
