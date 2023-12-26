package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class LikeManager$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Ref.IntRef f$0;
    public final /* synthetic */ LikeManager f$1;

    public /* synthetic */ LikeManager$$ExternalSyntheticLambda0(Ref.IntRef intRef, LikeManager likeManager) {
        this.f$0 = intRef;
        this.f$1 = likeManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        LikeManager.m521animAppend$lambda0(this.f$0, this.f$1, valueAnimator);
    }
}
