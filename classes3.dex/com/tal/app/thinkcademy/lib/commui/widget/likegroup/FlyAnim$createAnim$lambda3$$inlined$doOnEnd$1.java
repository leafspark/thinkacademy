package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnEnd$$inlined$addListener$1"}, k = 1, mv = {1, 6, 0})
/* renamed from: com.tal.app.thinkcademy.lib.commui.widget.likegroup.FlyAnim$createAnim$lambda-3$$inlined$doOnEnd$1  reason: invalid class name */
/* compiled from: Animator.kt */
public final class FlyAnim$createAnim$lambda3$$inlined$doOnEnd$1 implements Animator.AnimatorListener {
    final /* synthetic */ FlyAnim this$0;

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public FlyAnim$createAnim$lambda3$$inlined$doOnEnd$1(FlyAnim flyAnim) {
        this.this$0 = flyAnim;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        Function0 access$getMOnAnimEnd$p = this.this$0.mOnAnimEnd;
        if (access$getMOnAnimEnd$p != null) {
            access$getMOnAnimEnd$p.invoke();
        }
    }
}
