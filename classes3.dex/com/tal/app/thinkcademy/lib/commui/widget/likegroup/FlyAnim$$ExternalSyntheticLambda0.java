package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import android.animation.ValueAnimator;

public final /* synthetic */ class FlyAnim$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FlyAnim f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ FlyAnim$$ExternalSyntheticLambda0(FlyAnim flyAnim, int i) {
        this.f$0 = flyAnim;
        this.f$1 = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        FlyAnim.m519createAnim$lambda3$lambda1(this.f$0, this.f$1, valueAnimator);
    }
}
