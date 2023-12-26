package com.tal.app.thinkcademy.lib.commui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkcademy/lib/commui/widget/CircleProgressView$startProgress$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CircleProgressView.kt */
public final class CircleProgressView$startProgress$2 extends AnimatorListenerAdapter {
    final /* synthetic */ CircleProgressView this$0;

    CircleProgressView$startProgress$2(CircleProgressView circleProgressView) {
        this.this$0 = circleProgressView;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        CircleProgressView.OnProgressCallback access$getMProgressCallback$p = this.this$0.mProgressCallback;
        if (access$getMProgressCallback$p != null) {
            access$getMProgressCallback$p.onEnd();
        }
    }
}
