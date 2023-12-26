package com.tal.app.thinkacademy.live.business.praiselist.delegate;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class AnimDelegate$$ExternalSyntheticLambda5 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View[] f$0;

    public /* synthetic */ AnimDelegate$$ExternalSyntheticLambda5(View[] viewArr) {
        this.f$0 = viewArr;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AnimDelegate.m388startBreathingAnim$lambda5$lambda4(this.f$0, valueAnimator);
    }
}
