package com.tal.app.thinkacademy.live.business.praiselist.delegate;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class AnimDelegate$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View f$0;

    public /* synthetic */ AnimDelegate$$ExternalSyntheticLambda1(View view) {
        this.f$0 = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AnimDelegate.m392startScreenshotAnim$lambda12$lambda7(this.f$0, valueAnimator);
    }
}
