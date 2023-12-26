package com.didi.hummer.devtools.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.didi.hummer.utils.BarUtils;
import com.didi.hummer.utils.ScreenUtils;

public class FloatLayout extends FrameLayout {
    private float lastX;
    private float lastY;
    private int maxHeight;
    private int maxWidth;
    private int statusBarHeight;
    private long touchDownTimestamp;
    private int viewHeight;
    private int viewWidth;

    public FloatLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public FloatLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.statusBarHeight = BarUtils.getStatusBarHeight(getContext());
        this.maxWidth = ScreenUtils.getScreenWidth(context);
        this.maxHeight = (ScreenUtils.getScreenHeight(context) - this.statusBarHeight) - BarUtils.getNavBarHeight(context);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            float f = 0.0f;
            if (action == 1) {
                if (getX() + (((float) this.viewWidth) / 2.0f) > ((float) this.maxWidth) / 2.0f) {
                    animate().setInterpolator(new DecelerateInterpolator()).setDuration(200).xBy(((float) (this.maxWidth - this.viewWidth)) - getX()).start();
                } else {
                    animate().setInterpolator(new DecelerateInterpolator()).setDuration(200).x(0.0f).start();
                }
                if (System.currentTimeMillis() - this.touchDownTimestamp < 200) {
                    performClick();
                }
            } else if (action == 2) {
                float rawX = motionEvent.getRawX() - this.lastX;
                float rawY = motionEvent.getRawY() - this.lastY;
                float x = getX() + rawX;
                float y = getY() + rawY;
                if (x < 0.0f) {
                    x = 0.0f;
                } else {
                    int i = this.viewWidth;
                    int i2 = this.maxWidth;
                    if (((float) i) + x > ((float) i2)) {
                        x = (float) (i2 - i);
                    }
                }
                if (y >= 0.0f) {
                    int i3 = this.viewHeight;
                    int i4 = this.maxHeight;
                    f = ((float) i3) + y > ((float) i4) ? (float) (i4 - i3) : y;
                }
                setX(x);
                setY(f);
                this.lastX = motionEvent.getRawX();
                this.lastY = motionEvent.getRawY();
            }
        } else {
            clearAnimation();
            this.lastX = motionEvent.getRawX();
            this.lastY = motionEvent.getRawY();
            this.viewWidth = getWidth();
            this.viewHeight = getHeight();
            if (getParent() != null && (getParent() instanceof View)) {
                this.maxWidth = ((View) getParent()).getWidth();
                this.maxHeight = ((View) getParent()).getHeight();
            }
            this.touchDownTimestamp = System.currentTimeMillis();
        }
        return true;
    }
}
