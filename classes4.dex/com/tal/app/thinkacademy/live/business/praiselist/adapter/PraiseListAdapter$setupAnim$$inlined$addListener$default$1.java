package com.tal.app.thinkacademy.live.business.praiselist.adapter;

import android.animation.Animator;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 6, 0})
/* compiled from: Animator.kt */
public final class PraiseListAdapter$setupAnim$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ BaseViewHolder $holder$inlined;
    final /* synthetic */ boolean $open$inlined;
    final /* synthetic */ String $uid$inlined;
    final /* synthetic */ PraiseListAdapter this$0;

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public PraiseListAdapter$setupAnim$$inlined$addListener$default$1(PraiseListAdapter praiseListAdapter, String str, boolean z, BaseViewHolder baseViewHolder) {
        this.this$0 = praiseListAdapter;
        this.$uid$inlined = str;
        this.$open$inlined = z;
        this.$holder$inlined = baseViewHolder;
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.this$0.updateViewState(this.$uid$inlined, !this.$open$inlined, this.$holder$inlined);
    }
}
