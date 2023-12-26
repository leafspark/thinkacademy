package com.tal.app.thinkcademy.lib.commui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ValueAnimatorUtil;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 .2\u00020\u0001:\u0002./B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014J\u0006\u0010\u001f\u001a\u00020\u0019J\b\u0010 \u001a\u00020\u0019H\u0002J\u0010\u0010!\u001a\u00020\u00192\b\b\u0001\u0010\"\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\u00192\b\b\u0001\u0010\"\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u000fJ\u0010\u0010(\u001a\u00020\u00192\b\b\u0001\u0010\"\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010+\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/CircleProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBGPaint", "Landroid/graphics/Paint;", "mBackPaint", "mProgressAnimator", "Landroid/animation/ValueAnimator;", "mProgressCallback", "Lcom/tal/app/thinkcademy/lib/commui/widget/CircleProgressView$OnProgressCallback;", "mProgressPaint", "mRadius", "mRectF", "Landroid/graphics/RectF;", "progress", "", "revertMode", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "reset", "resetAnimator", "setBackColor", "color", "setBackWidth", "width", "setBgColor", "setProgressCallback", "progressCallback", "setProgressColor", "setProgressWidth", "setRevertMode", "startProgress", "animTime", "", "Companion", "OnProgressCallback", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CircleProgressView.kt */
public final class CircleProgressView extends View {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEF_BACK_COLOR = Color.parseColor("#7c7199");
    private static final int DEF_BACK_WIDTH = SizeUtils.dp2px(5.0f);
    private static final int DEF_PROGRESS_COLOR = -1;
    private static final int DEF_PROGRESS_WIDTH = SizeUtils.dp2px(5.0f);
    public static final float MAX_PROGRESS = 100.0f;
    private Paint mBGPaint;
    private Paint mBackPaint;
    private ValueAnimator mProgressAnimator;
    /* access modifiers changed from: private */
    public OnProgressCallback mProgressCallback;
    private Paint mProgressPaint;
    private int mRadius;
    private final RectF mRectF;
    private float progress;
    private boolean revertMode;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/CircleProgressView$OnProgressCallback;", "", "onEnd", "", "onProgress", "progress", "", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CircleProgressView.kt */
    public interface OnProgressCallback {
        void onEnd();

        void onProgress(float f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircleProgressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRectF = new RectF();
        this.progress = 100.0f;
        Paint paint = new Paint();
        this.mBackPaint = paint;
        Intrinsics.checkNotNull(paint);
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = this.mBackPaint;
        Intrinsics.checkNotNull(paint2);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = this.mBackPaint;
        Intrinsics.checkNotNull(paint3);
        paint3.setAntiAlias(true);
        Paint paint4 = this.mBackPaint;
        Intrinsics.checkNotNull(paint4);
        paint4.setDither(true);
        Paint paint5 = this.mBackPaint;
        Intrinsics.checkNotNull(paint5);
        paint5.setStrokeWidth((float) DEF_BACK_WIDTH);
        Paint paint6 = this.mBackPaint;
        Intrinsics.checkNotNull(paint6);
        paint6.setColor(DEF_BACK_COLOR);
        Paint paint7 = new Paint();
        this.mBGPaint = paint7;
        Intrinsics.checkNotNull(paint7);
        paint7.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint8 = this.mBGPaint;
        Intrinsics.checkNotNull(paint8);
        paint8.setStrokeCap(Paint.Cap.ROUND);
        Paint paint9 = this.mBGPaint;
        Intrinsics.checkNotNull(paint9);
        paint9.setAntiAlias(true);
        Paint paint10 = this.mBGPaint;
        Intrinsics.checkNotNull(paint10);
        paint10.setDither(true);
        Paint paint11 = new Paint();
        this.mProgressPaint = paint11;
        Intrinsics.checkNotNull(paint11);
        paint11.setStyle(Paint.Style.STROKE);
        Paint paint12 = this.mProgressPaint;
        Intrinsics.checkNotNull(paint12);
        paint12.setStrokeCap(Paint.Cap.ROUND);
        Paint paint13 = this.mProgressPaint;
        Intrinsics.checkNotNull(paint13);
        paint13.setAntiAlias(true);
        Paint paint14 = this.mProgressPaint;
        Intrinsics.checkNotNull(paint14);
        paint14.setDither(true);
        Paint paint15 = this.mProgressPaint;
        Intrinsics.checkNotNull(paint15);
        paint15.setStrokeWidth((float) DEF_PROGRESS_WIDTH);
        Paint paint16 = this.mProgressPaint;
        Intrinsics.checkNotNull(paint16);
        paint16.setColor(-1);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/CircleProgressView$Companion;", "", "()V", "DEF_BACK_COLOR", "", "DEF_BACK_WIDTH", "DEF_PROGRESS_COLOR", "DEF_PROGRESS_WIDTH", "MAX_PROGRESS", "", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CircleProgressView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i2, i2);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        Paint paint = this.mBackPaint;
        Intrinsics.checkNotNull(paint);
        float strokeWidth = paint.getStrokeWidth();
        Paint paint2 = this.mProgressPaint;
        Intrinsics.checkNotNull(paint2);
        int min = (int) (((float) Math.min(measuredWidth, measuredHeight)) - Math.max(strokeWidth, paint2.getStrokeWidth()));
        int paddingLeft = getPaddingLeft() + ((measuredWidth - min) / 2);
        int paddingTop = getPaddingTop() + ((measuredHeight - min) / 2);
        this.mRadius = min / 2;
        this.mRectF.set((float) paddingLeft, (float) paddingTop, (float) (paddingLeft + min), (float) (paddingTop + min));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Paint paint = this.mBGPaint;
        Intrinsics.checkNotNull(paint);
        canvas.drawCircle(this.mRectF.centerX(), this.mRectF.centerY(), (float) this.mRadius, paint);
        RectF rectF = this.mRectF;
        Paint paint2 = this.mBackPaint;
        Intrinsics.checkNotNull(paint2);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, paint2);
        float f = this.revertMode ? 100.0f - this.progress : this.progress;
        Paint paint3 = this.mProgressPaint;
        Intrinsics.checkNotNull(paint3);
        canvas.drawArc(this.mRectF, 270.0f, (((float) -360) * f) / 100.0f, false, paint3);
    }

    public final void startProgress(int i, long j) {
        if (j <= 0) {
            j = 1;
        }
        if (i < 0) {
            i = 0;
        }
        resetAnimator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (float) i});
        this.mProgressAnimator = ofFloat;
        if (ofFloat != null) {
            ofFloat.addUpdateListener(new CircleProgressView$$ExternalSyntheticLambda0(this));
        }
        ValueAnimator valueAnimator = this.mProgressAnimator;
        if (valueAnimator != null) {
            valueAnimator.addListener(new CircleProgressView$startProgress$2(this));
        }
        ValueAnimator valueAnimator2 = this.mProgressAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator3 = this.mProgressAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.setDuration(j);
        }
        ValueAnimatorUtil.resetDurationScale();
        ValueAnimator valueAnimator4 = this.mProgressAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startProgress$lambda-0  reason: not valid java name */
    public static final void m517startProgress$lambda0(CircleProgressView circleProgressView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(circleProgressView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        circleProgressView.progress = ((Float) animatedValue).floatValue();
        circleProgressView.invalidate();
        OnProgressCallback onProgressCallback = circleProgressView.mProgressCallback;
        if (onProgressCallback != null) {
            onProgressCallback.onProgress(circleProgressView.progress);
        }
    }

    public final void setProgressCallback(OnProgressCallback onProgressCallback) {
        Intrinsics.checkNotNullParameter(onProgressCallback, "progressCallback");
        this.mProgressCallback = onProgressCallback;
    }

    public final void reset() {
        resetAnimator();
        invalidate();
    }

    private final void resetAnimator() {
        ValueAnimator valueAnimator = this.mProgressAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            valueAnimator.removeAllUpdateListeners();
            ValueAnimator valueAnimator2 = this.mProgressAnimator;
            Intrinsics.checkNotNull(valueAnimator2);
            valueAnimator2.removeAllListeners();
            ValueAnimator valueAnimator3 = this.mProgressAnimator;
            Intrinsics.checkNotNull(valueAnimator3);
            valueAnimator3.cancel();
            this.mProgressAnimator = null;
        }
        this.progress = 100.0f;
    }

    public final void setRevertMode(boolean z) {
        this.revertMode = z;
    }

    public final void setBackWidth(int i) {
        Paint paint = this.mBackPaint;
        Intrinsics.checkNotNull(paint);
        paint.setStrokeWidth((float) i);
        invalidate();
    }

    public final void setBackColor(int i) {
        Paint paint = this.mBackPaint;
        Intrinsics.checkNotNull(paint);
        paint.setColor(i);
        invalidate();
    }

    public final void setBgColor(int i) {
        Paint paint = this.mBGPaint;
        Intrinsics.checkNotNull(paint);
        paint.setColor(i);
        invalidate();
    }

    public final void setProgressWidth(int i) {
        Paint paint = this.mProgressPaint;
        Intrinsics.checkNotNull(paint);
        paint.setStrokeWidth((float) i);
        invalidate();
    }

    public final void setProgressColor(int i) {
        Paint paint = this.mProgressPaint;
        Intrinsics.checkNotNull(paint);
        paint.setColor(i);
        Paint paint2 = this.mProgressPaint;
        Intrinsics.checkNotNull(paint2);
        paint2.setShader((Shader) null);
        invalidate();
    }
}
