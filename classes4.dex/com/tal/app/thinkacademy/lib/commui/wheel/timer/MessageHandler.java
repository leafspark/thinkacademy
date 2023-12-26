package com.tal.app.thinkacademy.lib.commui.wheel.timer;

import android.os.Handler;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView;

public final class MessageHandler extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    private final WheelView wheelView;

    public MessageHandler(WheelView wheelView2) {
        this.wheelView = wheelView2;
    }

    public final void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        int i = message.what;
        if (i == 1000) {
            this.wheelView.invalidate();
        } else if (i == 2000) {
            this.wheelView.smoothScroll(WheelView.ACTION.FLING);
        } else if (i == 3000) {
            this.wheelView.onItemSelected();
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
