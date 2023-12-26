package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/business/study/study/vodplayer/VideoScreenShotDialog$setAlphaProAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoScreenShotDialog.kt */
public final class VideoScreenShotDialog$setAlphaProAnimation$1 implements Animator.AnimatorListener {
    final /* synthetic */ VideoScreenShotDialog this$0;

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    VideoScreenShotDialog$setAlphaProAnimation$1(VideoScreenShotDialog videoScreenShotDialog) {
        this.this$0 = videoScreenShotDialog;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.this$0.binding.imageCardLayout.setVisibility(0);
        this.this$0.binding.imageCardLayout.setScaleX(1.0f);
        this.this$0.binding.imageCardLayout.setScaleY(1.0f);
        this.this$0.binding.imageCardLayout.postDelayed(new VideoScreenShotDialog$setAlphaProAnimation$1$$ExternalSyntheticLambda0(this.this$0), 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAnimationEnd$lambda-0  reason: not valid java name */
    public static final void m498onAnimationEnd$lambda0(VideoScreenShotDialog videoScreenShotDialog) {
        Intrinsics.checkNotNullParameter(videoScreenShotDialog, "this$0");
        videoScreenShotDialog.setScaleProAnimation(videoScreenShotDialog.binding.imageCardLayout);
    }
}
