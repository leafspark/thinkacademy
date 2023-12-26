package com.tal.app.thinkacademy.live.business.praiselist.delegate;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class AnimDelegate$$ExternalSyntheticLambda6 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View[] f$0;

    public /* synthetic */ AnimDelegate$$ExternalSyntheticLambda6(View[] viewArr) {
        this.f$0 = viewArr;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AnimDelegate.m389startClickAnim$lambda2$lambda1(this.f$0, valueAnimator);
    }
}
