package com.didi.hummer.render.component.anim;

import android.animation.ObjectAnimator;

public class Transition {
    private float delay = 0.0f;
    private float duration = 0.0f;
    private String property;
    private String timingFunction = "linear";

    public Transition(String str) {
        this.property = str;
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String str) {
        this.property = str;
    }

    public float getDuration() {
        return this.duration;
    }

    public void setDuration(double d) {
        this.duration = (float) d;
    }

    public float getDelay() {
        return this.delay;
    }

    public void setDelay(double d) {
        this.delay = (float) d;
    }

    public String getTimingFunction() {
        return this.timingFunction;
    }

    public void setTimingFunction(String str) {
        this.timingFunction = str;
    }

    public void warpAnim(ObjectAnimator objectAnimator) {
        objectAnimator.setRepeatCount(0);
        objectAnimator.setDuration(HummerAnimationUtils.getAnimDuration(getDuration()));
        objectAnimator.setStartDelay((long) HummerAnimationUtils.getAnimDelay(getDelay()));
        objectAnimator.setInterpolator(HummerAnimationUtils.getInterpolator(getTimingFunction()));
    }
}
