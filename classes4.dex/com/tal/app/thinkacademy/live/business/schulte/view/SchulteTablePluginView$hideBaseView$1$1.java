package com.tal.app.thinkacademy.live.business.schulte.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/schulte/view/SchulteTablePluginView$hideBaseView$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTablePluginView.kt */
public final class SchulteTablePluginView$hideBaseView$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ Function0<Unit> $it;
    final /* synthetic */ SchulteTablePluginView this$0;

    SchulteTablePluginView$hideBaseView$1$1(SchulteTablePluginView schulteTablePluginView, Function0<Unit> function0) {
        this.this$0 = schulteTablePluginView;
        this.$it = function0;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        ViewPropertyAnimator animate = this.this$0.mBinding.layoutBaseView.animate();
        if (animate != null) {
            animate.setListener((Animator.AnimatorListener) null);
        }
        this.$it.invoke();
    }
}
