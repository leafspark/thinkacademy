package com.tal.app.thinkacademy.live.business.praiselist.delegate;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tal.app.thinkacademy.lib.entity.AppNetWorkConfigRemoteInfo;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u001f\u0010\r\u001a\u00020\t2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\t2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010¢\u0006\u0002\u0010\u0011J&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/praiselist/delegate/AnimDelegate;", "", "()V", "mBreathingAnim", "Landroid/animation/ValueAnimator;", "mClickAnim", "mScreenshotAnimSet", "Landroid/animation/AnimatorSet;", "destroy", "", "initBreathingAnim", "initClickAnim", "initScreenshotAnim", "startBreathingAnim", "views", "", "Landroid/view/View;", "([Landroid/view/View;)V", "startClickAnim", "startScreenshotAnim", "writeView", "blackView", "screenView", "delay", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimDelegate.kt */
public final class AnimDelegate {
    private ValueAnimator mBreathingAnim;
    private ValueAnimator mClickAnim;
    private AnimatorSet mScreenshotAnimSet;

    public final void startClickAnim(View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        if (!(viewArr.length == 0)) {
            initClickAnim();
            ValueAnimator valueAnimator = this.mClickAnim;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.addUpdateListener(new AnimDelegate$$ExternalSyntheticLambda6(viewArr));
                valueAnimator.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startClickAnim$lambda-2$lambda-1  reason: not valid java name */
    public static final void m389startClickAnim$lambda2$lambda1(View[] viewArr, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(viewArr, "$views");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        Iterator it = ArrayIteratorKt.iterator(viewArr);
        while (it.hasNext()) {
            View view = (View) it.next();
            if (floatValue < 80.0f) {
                float f = ((floatValue / ((float) 80)) * 0.1f) + 1.0f;
                view.setScaleX(f);
                view.setScaleY(f);
                view.setRotation((((float) -15) * floatValue) / 80.0f);
            } else if (floatValue > 80.0f) {
                float f2 = ((float) 120) - floatValue;
                float f3 = ((f2 / ((float) 40)) * 0.1f) + 1.0f;
                view.setScaleX(f3);
                view.setScaleY(f3);
                view.setRotation((((float) -15) * f2) / 40.0f);
            }
        }
    }

    private final void initClickAnim() {
        if (this.mClickAnim == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 120.0f});
            ofFloat.setDuration(120);
            ofFloat.setInterpolator(new LinearInterpolator());
            this.mClickAnim = ofFloat;
        }
    }

    public final void startBreathingAnim(View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        if (!(viewArr.length == 0)) {
            initBreathingAnim();
            ValueAnimator valueAnimator = this.mBreathingAnim;
            if (valueAnimator != null) {
                valueAnimator.addUpdateListener(new AnimDelegate$$ExternalSyntheticLambda5(viewArr));
                valueAnimator.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startBreathingAnim$lambda-5$lambda-4  reason: not valid java name */
    public static final void m388startBreathingAnim$lambda5$lambda4(View[] viewArr, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(viewArr, "$views");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        Iterator it = ArrayIteratorKt.iterator(viewArr);
        while (it.hasNext()) {
            View view = (View) it.next();
            view.setScaleX(floatValue);
            view.setScaleY(floatValue);
        }
    }

    private final void initBreathingAnim() {
        if (this.mBreathingAnim == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 1.08f});
            ofFloat.setDuration(600);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            this.mBreathingAnim = ofFloat;
        }
    }

    public final void startScreenshotAnim(View view, View view2, View view3, long j) {
        Intrinsics.checkNotNullParameter(view, "writeView");
        Intrinsics.checkNotNullParameter(view2, "blackView");
        Intrinsics.checkNotNullParameter(view3, "screenView");
        initScreenshotAnim();
        AnimatorSet animatorSet = this.mScreenshotAnimSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f, 0.0f});
            ofFloat.addUpdateListener(new AnimDelegate$$ExternalSyntheticLambda4(view));
            ofFloat.setDuration(400);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat2.addUpdateListener(new AnimDelegate$$ExternalSyntheticLambda1(view2));
            ofFloat2.setDuration(200);
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat3.addUpdateListener(new AnimDelegate$$ExternalSyntheticLambda3(view3));
            ofFloat3.setDuration(200);
            view2.setVisibility(0);
            animatorSet.play(ofFloat).after(j);
            animatorSet.play(ofFloat2).after(j);
            animatorSet.play(ofFloat3).after(((long) AppNetWorkConfigRemoteInfo.MAX_TIME_OUT) + j);
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ofFloat4.addUpdateListener(new AnimDelegate$$ExternalSyntheticLambda0(view2));
            Intrinsics.checkNotNullExpressionValue(ofFloat4, "blackHideAnim");
            Animator animator = ofFloat4;
            animator.addListener(new AnimDelegate$startScreenshotAnim$lambda12$$inlined$addListener$default$1(view2));
            ofFloat4.setDuration(400);
            ValueAnimator ofFloat5 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ofFloat5.addUpdateListener(new AnimDelegate$$ExternalSyntheticLambda2(view3));
            ofFloat5.setDuration(200);
            long j2 = j + ((long) 1400);
            animatorSet.play(animator).after(j2);
            animatorSet.play(ofFloat5).after(j2);
            animatorSet.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startScreenshotAnim$lambda-12$lambda-6  reason: not valid java name */
    public static final void m391startScreenshotAnim$lambda12$lambda6(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$writeView");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: startScreenshotAnim$lambda-12$lambda-7  reason: not valid java name */
    public static final void m392startScreenshotAnim$lambda12$lambda7(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$blackView");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: startScreenshotAnim$lambda-12$lambda-8  reason: not valid java name */
    public static final void m393startScreenshotAnim$lambda12$lambda8(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$screenView");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        view.setAlpha(floatValue);
        float f = (floatValue * 0.6f) + 0.4f;
        view.setScaleX(f);
        view.setScaleY(f);
    }

    /* access modifiers changed from: private */
    /* renamed from: startScreenshotAnim$lambda-12$lambda-9  reason: not valid java name */
    public static final void m394startScreenshotAnim$lambda12$lambda9(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$blackView");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: startScreenshotAnim$lambda-12$lambda-11  reason: not valid java name */
    public static final void m390startScreenshotAnim$lambda12$lambda11(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$screenView");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        view.setScaleX(floatValue);
        view.setScaleY(floatValue);
        view.setAlpha(floatValue);
    }

    private final void initScreenshotAnim() {
        if (this.mScreenshotAnimSet == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            this.mScreenshotAnimSet = animatorSet;
        }
    }

    public final void destroy() {
        ValueAnimator valueAnimator = this.mBreathingAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mBreathingAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.mBreathingAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllListeners();
        }
        this.mBreathingAnim = null;
        ValueAnimator valueAnimator4 = this.mClickAnim;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
        }
        ValueAnimator valueAnimator5 = this.mClickAnim;
        if (valueAnimator5 != null) {
            valueAnimator5.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator6 = this.mClickAnim;
        if (valueAnimator6 != null) {
            valueAnimator6.removeAllListeners();
        }
        this.mClickAnim = null;
        AnimatorSet animatorSet = this.mScreenshotAnimSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.mScreenshotAnimSet;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
        }
        this.mScreenshotAnimSet = null;
    }
}
