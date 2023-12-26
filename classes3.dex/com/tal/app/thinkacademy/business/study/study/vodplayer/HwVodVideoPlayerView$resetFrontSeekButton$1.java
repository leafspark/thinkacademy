package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.animation.Animator;
import com.tal.app.thinkacademy.business.studycenter.databinding.VodVideoPlayerViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/business/study/study/vodplayer/HwVodVideoPlayerView$resetFrontSeekButton$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwVodVideoPlayerView.kt */
public final class HwVodVideoPlayerView$resetFrontSeekButton$1 implements Animator.AnimatorListener {
    final /* synthetic */ HwVodVideoPlayerView this$0;

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "p0");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "p0");
    }

    HwVodVideoPlayerView$resetFrontSeekButton$1(HwVodVideoPlayerView hwVodVideoPlayerView) {
        this.this$0 = hwVodVideoPlayerView;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "p0");
        VodVideoPlayerViewBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.frontSeekTargetTextview.setVisibility(4);
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "p0");
        if (!this.this$0.mFrontSeekIsStart) {
            this.this$0.mFrontSeekCount = 0;
            VodVideoPlayerViewBinding access$getBinding$p = this.this$0.binding;
            if (access$getBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p = null;
            }
            access$getBinding$p.frontSeekTextView.setText("10s");
        }
    }
}
