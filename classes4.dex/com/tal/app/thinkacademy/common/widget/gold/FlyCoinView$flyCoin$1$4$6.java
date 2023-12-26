package com.tal.app.thinkacademy.common.widget.gold;

import android.animation.Animator;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/common/widget/gold/FlyCoinView$flyCoin$1$4$6", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlyCoinView.kt */
public final class FlyCoinView$flyCoin$1$4$6 implements Animator.AnimatorListener {
    final /* synthetic */ FlyCoinConfig $flyCoinConfig;
    final /* synthetic */ ImageView $line2Coin3;
    final /* synthetic */ FlyCoinView this$0;

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    FlyCoinView$flyCoin$1$4$6(ImageView imageView, FlyCoinConfig flyCoinConfig, FlyCoinView flyCoinView) {
        this.$line2Coin3 = imageView;
        this.$flyCoinConfig = flyCoinConfig;
        this.this$0 = flyCoinView;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        ImageView imageView = this.$line2Coin3;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        if (this.$flyCoinConfig.isTargetViewAnimation()) {
            this.this$0.playToViewAnimation();
        }
    }
}
