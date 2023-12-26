package com.didi.hummer.render.component.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.render.component.view.HMBase;

@Component("BasicAnimation")
public class BasicAnimation {
    public static final int AXIS_X = 1;
    public static final int AXIS_Y = 2;
    public static final int AXIS_Z = 3;
    public static final int DIRECTION_X = 11;
    public static final int DIRECTION_XY = 13;
    public static final int DIRECTION_Y = 12;
    protected JSCallback animEndCallback;
    protected JSCallback animStartCallback;
    protected String animType;
    protected Animator animator;
    protected AnimatorListenerAdapter animatorListener = new AnimatorListenerAdapter() {
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (BasicAnimation.this.animStartCallback != null) {
                BasicAnimation.this.animStartCallback.call(new Object[0]);
            }
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (BasicAnimation.this.animEndCallback != null) {
                BasicAnimation.this.animEndCallback.call(new Object[0]);
            }
        }
    };
    @JsProperty("delay")
    protected float delay;
    @JsProperty("duration")
    protected float duration;
    @JsProperty("easing")
    protected String easing;
    @JsProperty("from")
    protected Object from;
    @JsProperty("repeatCount")
    protected int repeatCount;
    @JsProperty("repeatMode")
    protected String repeatMode;
    @JsProperty("value")
    protected Object value;

    /* access modifiers changed from: protected */
    public int toRawRepeatCount(int i) {
        if (i < 0) {
            return -1;
        }
        if (i > 1) {
            return i - 1;
        }
        return 0;
    }

    public BasicAnimation(String str) {
        this.animType = str;
    }

    protected static Object[] trans2Array(Object obj) {
        return HummerAnimationUtils.trans2Array(obj);
    }

    @JsMethod("on")
    public void on(String str, JSCallback jSCallback) {
        if ("start".equalsIgnoreCase(str)) {
            this.animStartCallback = jSCallback;
        } else if ("end".equalsIgnoreCase(str)) {
            this.animEndCallback = jSCallback;
        }
    }

    public void start(HMBase hMBase) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(hMBase.getAnimViewWrapper(), (PropertyValuesHolder[]) HummerAnimationUtils.parser(this.animType, this.value, this.from).toArray(new PropertyValuesHolder[0]));
        this.animator = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(HummerAnimationUtils.getAnimDuration(this.duration));
        ofPropertyValuesHolder.setRepeatCount(toRawRepeatCount(this.repeatCount));
        ofPropertyValuesHolder.setRepeatMode(toRawRepeatMode(this.repeatMode));
        ofPropertyValuesHolder.setStartDelay((long) HummerAnimationUtils.getAnimDelay(this.delay));
        ofPropertyValuesHolder.setInterpolator(HummerAnimationUtils.getInterpolator(this.easing));
        ofPropertyValuesHolder.addListener(this.animatorListener);
        ofPropertyValuesHolder.start();
    }

    public void stop() {
        if (isRunning()) {
            this.animator.cancel();
            this.animator = null;
        }
        JSCallback jSCallback = this.animStartCallback;
        if (jSCallback != null) {
            jSCallback.release();
        }
        JSCallback jSCallback2 = this.animEndCallback;
        if (jSCallback2 != null) {
            jSCallback2.release();
        }
    }

    public boolean isRunning() {
        Animator animator2 = this.animator;
        return animator2 != null && animator2.isRunning();
    }

    /* access modifiers changed from: protected */
    public int toRawRepeatMode(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.equals("normal") && lowerCase.equals("reverse")) {
            return 2;
        }
        return 1;
    }
}
