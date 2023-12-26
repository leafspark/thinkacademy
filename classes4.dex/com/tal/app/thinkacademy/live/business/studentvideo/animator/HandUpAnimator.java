package com.tal.app.thinkacademy.live.business.studentvideo.animator;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/studentvideo/animator/HandUpAnimator;", "", "handUpView", "Landroid/view/View;", "bgView", "(Landroid/view/View;Landroid/view/View;)V", "mHandUpHideAnim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "mHandUpShowAnim", "hide", "", "release", "show", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HandUpAnimator.kt */
public final class HandUpAnimator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final View bgView;
    /* access modifiers changed from: private */
    public final View handUpView;
    private final ValueAnimator mHandUpHideAnim;
    private final ValueAnimator mHandUpShowAnim;

    public /* synthetic */ HandUpAnimator(View view, View view2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, view2);
    }

    @JvmStatic
    public static final HandUpAnimator create(View view, View view2) {
        return Companion.create(view, view2);
    }

    private HandUpAnimator(View view, View view2) {
        this.handUpView = view;
        this.bgView = view2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(800);
        ofFloat.addUpdateListener(new HandUpAnimator$$ExternalSyntheticLambda1(this));
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.addListener(new HandUpAnimator$mHandUpShowAnim$1$2(this));
        this.mHandUpShowAnim = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setDuration(400);
        ofFloat2.addUpdateListener(new HandUpAnimator$$ExternalSyntheticLambda0(this));
        ofFloat2.addListener(new HandUpAnimator$mHandUpHideAnim$1$2(this));
        this.mHandUpHideAnim = ofFloat2;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/studentvideo/animator/HandUpAnimator$Companion;", "", "()V", "create", "Lcom/tal/app/thinkacademy/live/business/studentvideo/animator/HandUpAnimator;", "handUpView", "Landroid/view/View;", "bgView", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HandUpAnimator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HandUpAnimator create(View view, View view2) {
            Intrinsics.checkNotNullParameter(view, "handUpView");
            Intrinsics.checkNotNullParameter(view2, "bgView");
            return new HandUpAnimator(view, view2, (DefaultConstructorMarker) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mHandUpShowAnim$lambda-1$lambda-0  reason: not valid java name */
    public static final void m444mHandUpShowAnim$lambda1$lambda0(HandUpAnimator handUpAnimator, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(handUpAnimator, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        if (((double) floatValue) <= 0.25d) {
            handUpAnimator.bgView.setAlpha((floatValue / 0.25f) * 0.76f);
        }
        View view = handUpAnimator.handUpView;
        view.setTranslationY(((float) view.getHeight()) * (((float) 1) - floatValue));
    }

    /* access modifiers changed from: private */
    /* renamed from: mHandUpHideAnim$lambda-3$lambda-2  reason: not valid java name */
    public static final void m443mHandUpHideAnim$lambda3$lambda2(HandUpAnimator handUpAnimator, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(handUpAnimator, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        View view = handUpAnimator.handUpView;
        view.setTranslationY(((float) view.getHeight()) * floatValue);
    }

    public final void show() {
        if (this.handUpView.getVisibility() != 0) {
            if (this.mHandUpHideAnim.isRunning()) {
                this.mHandUpHideAnim.cancel();
            }
            this.mHandUpShowAnim.start();
        }
    }

    public final void hide() {
        if (this.handUpView.getVisibility() != 4 && this.handUpView.getVisibility() != 8) {
            if (this.mHandUpShowAnim.isRunning()) {
                this.mHandUpShowAnim.cancel();
            }
            this.mHandUpHideAnim.start();
        }
    }

    public final void release() {
        this.mHandUpShowAnim.cancel();
        this.mHandUpHideAnim.cancel();
    }
}
