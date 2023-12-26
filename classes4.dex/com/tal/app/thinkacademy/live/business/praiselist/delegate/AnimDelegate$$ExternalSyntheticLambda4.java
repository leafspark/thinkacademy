package com.tal.app.thinkacademy.live.business.praiselist.delegate;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class AnimDelegate$$ExternalSyntheticLambda4 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View f$0;

    public /* synthetic */ AnimDelegate$$ExternalSyntheticLambda4(View view) {
        this.f$0 = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AnimDelegate.m391startScreenshotAnim$lambda12$lambda6(this.f$0, valueAnimator);
    }
}
