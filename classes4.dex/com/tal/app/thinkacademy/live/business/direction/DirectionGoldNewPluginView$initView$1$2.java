package com.tal.app.thinkacademy.live.business.direction;

import android.animation.Animator;
import com.tal.app.thinkacademy.live.util.LiveMainHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/live/business/direction/DirectionGoldNewPluginView$initView$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DirectionGoldNewPluginView.kt */
public final class DirectionGoldNewPluginView$initView$1$2 implements Animator.AnimatorListener {
    final /* synthetic */ DirectionGoldNewPluginView this$0;

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    DirectionGoldNewPluginView$initView$1$2(DirectionGoldNewPluginView directionGoldNewPluginView) {
        this.this$0 = directionGoldNewPluginView;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        DirectionGoldListener mListener = this.this$0.getMListener();
        if (mListener != null) {
            mListener.updateUserCoins();
        }
        LiveMainHandler.postDelayed(new DirectionGoldNewPluginView$initView$1$2$$ExternalSyntheticLambda0(this.this$0), 400);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAnimationEnd$lambda-0  reason: not valid java name */
    public static final void m204onAnimationEnd$lambda0(DirectionGoldNewPluginView directionGoldNewPluginView) {
        Intrinsics.checkNotNullParameter(directionGoldNewPluginView, "this$0");
        directionGoldNewPluginView.hideDirectionGoldView(true);
    }
}
