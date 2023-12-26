package com.tal.app.thinkacademy.lib.commui.wheel.timer;

import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView;
import java.util.TimerTask;

public final class SmoothScrollTimerTask extends TimerTask {
    private int offset;
    private int realOffset = 0;
    private int realTotalOffset = Integer.MAX_VALUE;
    private final WheelView wheelView;

    public SmoothScrollTimerTask(WheelView wheelView2, int i) {
        this.wheelView = wheelView2;
        this.offset = i;
    }

    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        int i = this.realTotalOffset;
        int i2 = (int) (((float) i) * 0.1f);
        this.realOffset = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (Math.abs(i) <= 1) {
            this.wheelView.cancelFuture();
            Handler handler = this.wheelView.getHandler();
            if (!(handler instanceof Handler)) {
                handler.sendEmptyMessage(MessageHandler.WHAT_ITEM_SELECTED);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler, MessageHandler.WHAT_ITEM_SELECTED);
            }
        } else {
            WheelView wheelView2 = this.wheelView;
            wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() + ((float) this.realOffset));
            if (!this.wheelView.isLoop()) {
                float itemHeight = this.wheelView.getItemHeight();
                float f = ((float) (-this.wheelView.getInitPosition())) * itemHeight;
                float itemsCount = ((float) ((this.wheelView.getItemsCount() - 1) - this.wheelView.getInitPosition())) * itemHeight;
                if (this.wheelView.getTotalScrollY() <= f || this.wheelView.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView3 = this.wheelView;
                    wheelView3.setTotalScrollY(wheelView3.getTotalScrollY() - ((float) this.realOffset));
                    this.wheelView.cancelFuture();
                    Handler handler2 = this.wheelView.getHandler();
                    if (!(handler2 instanceof Handler)) {
                        handler2.sendEmptyMessage(MessageHandler.WHAT_ITEM_SELECTED);
                        return;
                    } else {
                        AsynchronousInstrumentation.sendEmptyMessage(handler2, MessageHandler.WHAT_ITEM_SELECTED);
                        return;
                    }
                }
            }
            Handler handler3 = this.wheelView.getHandler();
            if (!(handler3 instanceof Handler)) {
                handler3.sendEmptyMessage(1000);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler3, 1000);
            }
            this.realTotalOffset -= this.realOffset;
        }
    }
}
