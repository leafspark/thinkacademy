package com.tal.app.thinkacademy.live.business.redpackagerain.view;

import android.animation.Animator;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.RedPackageRainCoinSettlementListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/live/business/redpackagerain/view/RedPackageRainCoinSettlementPluginView$countdownEnd$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainCoinSettlementPluginView.kt */
public final class RedPackageRainCoinSettlementPluginView$countdownEnd$1 implements Animator.AnimatorListener {
    final /* synthetic */ RedPackageRainCoinSettlementPluginView this$0;

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    RedPackageRainCoinSettlementPluginView$countdownEnd$1(RedPackageRainCoinSettlementPluginView redPackageRainCoinSettlementPluginView) {
        this.this$0 = redPackageRainCoinSettlementPluginView;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        if (this.this$0.getCoin() > 0) {
            RedPackageRainCoinSettlementListener access$getMListener$p = this.this$0.mListener;
            if (access$getMListener$p != null) {
                access$getMListener$p.onCoinSettlementAnimationEnd();
            }
            RedPackageRainCoinSettlementListener access$getMListener$p2 = this.this$0.mListener;
            if (access$getMListener$p2 != null) {
                access$getMListener$p2.updateUserCoins(this.this$0.getCoin());
                return;
            }
            return;
        }
        RedPackageRainCoinSettlementListener access$getMListener$p3 = this.this$0.mListener;
        if (access$getMListener$p3 != null) {
            access$getMListener$p3.onCoinSettlementAnimationEnd();
        }
    }
}
