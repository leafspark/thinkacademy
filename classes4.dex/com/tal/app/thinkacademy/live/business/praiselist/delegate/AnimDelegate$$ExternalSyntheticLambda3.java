package com.tal.app.thinkacademy.live.business.praiselist.delegate;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class AnimDelegate$$ExternalSyntheticLambda3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View f$0;

    public /* synthetic */ AnimDelegate$$ExternalSyntheticLambda3(View view) {
        this.f$0 = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AnimDelegate.m393startScreenshotAnim$lambda12$lambda8(this.f$0, valueAnimator);
    }
}
