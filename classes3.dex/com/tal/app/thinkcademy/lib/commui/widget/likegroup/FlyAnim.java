package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0006J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u0002\u001a\u00020\u0003J\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/FlyAnim;", "", "view", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;)V", "mAnimator", "Landroid/animation/ValueAnimator;", "mFlyDistance", "", "mOnAnimEnd", "Lkotlin/Function0;", "", "mSwingRange", "cancel", "createAnim", "createPoints", "", "Landroid/graphics/PointF;", "()[Landroid/graphics/PointF;", "loadCircleImage", "url", "", "onAnimEnd", "onEnd", "setFlyDistance", "int", "setImageResource", "resId", "setSwingRange", "dispersed", "", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlyAnimGroup.kt */
final class FlyAnim {
    private ValueAnimator mAnimator;
    private int mFlyDistance;
    /* access modifiers changed from: private */
    public Function0<Unit> mOnAnimEnd;
    private int mSwingRange;
    private final ImageView view;

    public FlyAnim(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "view");
        this.view = imageView;
        imageView.setAlpha(0.0f);
    }

    public final ImageView view() {
        return this.view;
    }

    public final void cancel() {
        XesLog.it("FlyAnimGroup", new Object[]{"cancel"});
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.cancel();
        }
        this.view.setTranslationX(0.0f);
        this.view.setTranslationY(0.0f);
        this.view.setAlpha(0.0f);
        this.mAnimator = null;
    }

    public final ValueAnimator createAnim() {
        PointF[] createPoints = createPoints();
        ValueAnimator ofObject = ValueAnimator.ofObject(new BesselTypeEvaluator(createPoints[1], createPoints[2]), new Object[]{createPoints[0], createPoints[3]});
        ofObject.addUpdateListener(new FlyAnim$$ExternalSyntheticLambda0(this, RangesKt.random(new IntRange(0, 90), (Random) Random.Default) - 45));
        Intrinsics.checkNotNullExpressionValue(ofObject, "");
        ofObject.addListener(new FlyAnim$createAnim$lambda3$$inlined$doOnEnd$1(this));
        ofObject.setInterpolator(new LinearInterpolator());
        ofObject.setDuration(1000);
        this.mAnimator = ofObject;
        Intrinsics.checkNotNullExpressionValue(ofObject, "animator");
        return ofObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: createAnim$lambda-3$lambda-1  reason: not valid java name */
    public static final void m519createAnim$lambda3$lambda1(FlyAnim flyAnim, int i, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(flyAnim, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type android.graphics.PointF");
        PointF pointF = (PointF) animatedValue;
        float animatedFraction = valueAnimator.getAnimatedFraction();
        flyAnim.view.setRotation(((float) i) - (((float) 30) * animatedFraction));
        flyAnim.view.setAlpha(((float) 1) - animatedFraction);
        flyAnim.view.setX(pointF.x);
        flyAnim.view.setY(pointF.y);
    }

    public final void setSwingRange(int i) {
        this.mSwingRange = i;
    }

    public final void setFlyDistance(int i) {
        this.mFlyDistance = i;
    }

    public final void onAnimEnd(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onEnd");
        this.mOnAnimEnd = function0;
    }

    private final PointF[] createPoints() {
        float nextDouble = (float) Random.Default.nextDouble();
        float nextDouble2 = (float) Random.Default.nextDouble();
        Context context = this.view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        float access$dp2px = (((float) this.mSwingRange) / 2.0f) - ((float) (FlyAnimGroupKt.dp2px(context, 36.0f) / 2));
        int i = this.mFlyDistance;
        Context context2 = this.view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        float access$dp2px2 = (float) (i - FlyAnimGroupKt.dp2px(context2, 36.0f));
        float f = ((float) 2) * access$dp2px;
        return new PointF[]{new PointF((nextDouble2 + 0.5f) * access$dp2px, access$dp2px2), new PointF(dispersed(nextDouble) * f, 0.7f * access$dp2px2), new PointF(f * dispersed(nextDouble2), access$dp2px2 * 0.3f), new PointF(access$dp2px * (nextDouble + 0.5f), 0.0f)};
    }

    private final float dispersed(float f) {
        if (f < 0.5f) {
            return ((float) 2) * ((float) Math.pow((double) f, (double) 2));
        }
        return ((float) Math.pow((double) (f - 0.5f), (double) 0.5f)) + 0.5f;
    }

    public final void setImageResource(int i) {
        this.view.setImageResource(i);
    }

    public final void loadCircleImage(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        XesImageLoader xesImageLoader = XesImageLoader.INSTANCE;
        ImageView imageView = this.view;
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        XesImageLoader.loadCircleWithBorderImage$default(xesImageLoader, imageView, context, str, 1, -1, 0, false, 48, (Object) null);
    }
}
