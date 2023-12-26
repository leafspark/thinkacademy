package com.tal.app.thinkacademy.lib.commui.wheel.timer;

import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView;
import java.util.TimerTask;

public final class InertiaTimerTask extends TimerTask {
    private float mCurrentVelocityY = 2.14748365E9f;
    private final float mFirstVelocityY;
    private final WheelView mWheelView;

    public InertiaTimerTask(WheelView wheelView, float f) {
        this.mWheelView = wheelView;
        this.mFirstVelocityY = f;
    }

    public final void run() {
        if (this.mCurrentVelocityY == 2.14748365E9f) {
            float f = 2000.0f;
            if (Math.abs(this.mFirstVelocityY) > 2000.0f) {
                if (this.mFirstVelocityY <= 0.0f) {
                    f = -2000.0f;
                }
                this.mCurrentVelocityY = f;
            } else {
                this.mCurrentVelocityY = this.mFirstVelocityY;
            }
        }
        if (Math.abs(this.mCurrentVelocityY) < 0.0f || Math.abs(this.mCurrentVelocityY) > 20.0f) {
            WheelView wheelView = this.mWheelView;
            float f2 = (float) ((int) (this.mCurrentVelocityY / 100.0f));
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
            if (!this.mWheelView.isLoop()) {
                float itemHeight = this.mWheelView.getItemHeight();
                float f3 = ((float) (-this.mWheelView.getInitPosition())) * itemHeight;
                float itemsCount = ((float) ((this.mWheelView.getItemsCount() - 1) - this.mWheelView.getInitPosition())) * itemHeight;
                double d = ((double) itemHeight) * 0.25d;
                if (((double) this.mWheelView.getTotalScrollY()) - d < ((double) f3)) {
                    f3 = this.mWheelView.getTotalScrollY() + f2;
                } else if (((double) this.mWheelView.getTotalScrollY()) + d > ((double) itemsCount)) {
                    itemsCount = this.mWheelView.getTotalScrollY() + f2;
                }
                if (this.mWheelView.getTotalScrollY() <= f3) {
                    this.mCurrentVelocityY = 40.0f;
                    this.mWheelView.setTotalScrollY((float) ((int) f3));
                } else if (this.mWheelView.getTotalScrollY() >= itemsCount) {
                    this.mWheelView.setTotalScrollY((float) ((int) itemsCount));
                    this.mCurrentVelocityY = -40.0f;
                }
            }
            float f4 = this.mCurrentVelocityY;
            if (f4 < 0.0f) {
                this.mCurrentVelocityY = f4 + 20.0f;
            } else {
                this.mCurrentVelocityY = f4 - 20.0f;
            }
            Handler handler = this.mWheelView.getHandler();
            if (!(handler instanceof Handler)) {
                handler.sendEmptyMessage(1000);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler, 1000);
            }
        } else {
            this.mWheelView.cancelFuture();
            Handler handler2 = this.mWheelView.getHandler();
            if (!(handler2 instanceof Handler)) {
                handler2.sendEmptyMessage(2000);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler2, 2000);
            }
        }
    }
}
