package com.tal.app.thinkcademy.lib.commui.widget;

import android.animation.ValueAnimator;

public final /* synthetic */ class CircleProgressView$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CircleProgressView f$0;

    public /* synthetic */ CircleProgressView$$ExternalSyntheticLambda0(CircleProgressView circleProgressView) {
        this.f$0 = circleProgressView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        CircleProgressView.m517startProgress$lambda0(this.f$0, valueAnimator);
    }
}
