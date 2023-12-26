package com.tal.app.thinkacademy.business.login.view.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkcademy.lib.commui.widget.StateImageView;
import com.tal.app.thinkcademy.lib.commui.widget.ViewState;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/customview/DeviceNetStateProgress;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCurrentPos", "mIvProgress1", "Lcom/tal/app/thinkcademy/lib/commui/widget/StateImageView;", "mIvProgress2", "mIvProgress3", "mIvProgress4", "mIvProgress5", "mIvProgress6", "mIvStateError", "Landroid/widget/ImageView;", "mProgressAnimate", "Landroid/animation/ValueAnimator;", "changeState", "", "pos", "error", "release", "reset", "startLoop", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceNetStateProgress.kt */
public final class DeviceNetStateProgress extends FrameLayout {
    private int mCurrentPos;
    private StateImageView mIvProgress1;
    private StateImageView mIvProgress2;
    private StateImageView mIvProgress3;
    private StateImageView mIvProgress4;
    private StateImageView mIvProgress5;
    private StateImageView mIvProgress6;
    private ImageView mIvStateError;
    private ValueAnimator mProgressAnimate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeviceNetStateProgress(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeviceNetStateProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceNetStateProgress(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceNetStateProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = FrameLayout.inflate(context, R.layout.layout_net_state_progress, this);
        View findViewById = inflate.findViewById(R.id.progress_1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "content.findViewById(R.id.progress_1)");
        this.mIvProgress1 = (StateImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.progress_2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "content.findViewById(R.id.progress_2)");
        this.mIvProgress2 = (StateImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.progress_3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "content.findViewById(R.id.progress_3)");
        this.mIvProgress3 = (StateImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.progress_4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "content.findViewById(R.id.progress_4)");
        this.mIvProgress4 = (StateImageView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.progress_5);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "content.findViewById(R.id.progress_5)");
        this.mIvProgress5 = (StateImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.progress_6);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "content.findViewById(R.id.progress_6)");
        this.mIvProgress6 = (StateImageView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.iv_state_error);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "content.findViewById(R.id.iv_state_error)");
        this.mIvStateError = (ImageView) findViewById7;
    }

    public final void startLoop() {
        DeviceNetStateProgress deviceNetStateProgress = this;
        ValueAnimator valueAnimator = deviceNetStateProgress.mProgressAnimate;
        if (valueAnimator == null) {
            valueAnimator = ValueAnimator.ofInt(new int[]{1, 7});
            valueAnimator.setDuration(3500);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new DeviceNetStateProgress$$ExternalSyntheticLambda0(deviceNetStateProgress));
            valueAnimator.setRepeatMode(1);
            valueAnimator.setRepeatCount(-1);
            deviceNetStateProgress.mProgressAnimate = valueAnimator;
        }
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        this.mIvStateError.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: startLoop$lambda-3$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m138startLoop$lambda3$lambda2$lambda1$lambda0(DeviceNetStateProgress deviceNetStateProgress, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(deviceNetStateProgress, "$this_run");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        if (deviceNetStateProgress.mCurrentPos != intValue) {
            deviceNetStateProgress.changeState(intValue);
            deviceNetStateProgress.mCurrentPos = intValue;
        }
    }

    public final void reset() {
        ValueAnimator valueAnimator = this.mProgressAnimate;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        changeState(0);
        this.mIvStateError.setVisibility(8);
    }

    public final void error() {
        ValueAnimator valueAnimator = this.mProgressAnimate;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        changeState(0);
        this.mIvStateError.setVisibility(0);
    }

    private final void changeState(int i) {
        boolean z = false;
        this.mIvProgress1.changeState(ViewState.ONE, i == 1);
        this.mIvProgress2.changeState(ViewState.ONE, i == 2);
        this.mIvProgress3.changeState(ViewState.ONE, i == 3);
        this.mIvProgress4.changeState(ViewState.ONE, i == 4);
        this.mIvProgress5.changeState(ViewState.ONE, i == 5);
        StateImageView stateImageView = this.mIvProgress6;
        ViewState viewState = ViewState.ONE;
        if (i == 6) {
            z = true;
        }
        stateImageView.changeState(viewState, z);
    }

    public final void release() {
        ValueAnimator valueAnimator = this.mProgressAnimate;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mProgressAnimate;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        this.mProgressAnimate = null;
    }
}
