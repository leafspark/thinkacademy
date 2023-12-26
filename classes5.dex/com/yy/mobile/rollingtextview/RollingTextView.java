package com.yy.mobile.rollingtextview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.yalantis.ucrop.view.CropImageView;
import com.yy.mobile.rollingtextview.strategy.CharOrderStrategy;
import com.yy.mobile.rollingtextview.strategy.Strategy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DJ\u0019\u0010E\u001a\u00020B2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020H0G¢\u0006\u0002\u0010IJ\u000e\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020/J\u0014\u0010E\u001a\u00020B2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020H0JJ\b\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020\u0007H\u0002J\b\u0010N\u001a\u00020\u0007H\u0002J\b\u0010O\u001a\u00020\u0007H\u0016J\u0006\u0010P\u001a\u00020/J\u0006\u0010Q\u001a\u00020RJ\u0010\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020UH\u0014J\u0018\u0010V\u001a\u00020B2\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u0007H\u0014J(\u0010Y\u001a\u00020B2\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u0007H\u0014J\b\u0010^\u001a\u00020BH\u0002J\u0010\u0010_\u001a\u00020B2\u0006\u0010T\u001a\u00020UH\u0002J\u000e\u0010`\u001a\u00020B2\u0006\u0010C\u001a\u00020DJ\u000e\u0010a\u001a\u00020B2\u0006\u0010b\u001a\u00020/J\u0016\u0010a\u001a\u00020B2\u0006\u0010b\u001a\u00020/2\u0006\u0010c\u001a\u00020LJ\u000e\u0010d\u001a\u00020B2\u0006\u0010e\u001a\u00020RJ\u0016\u0010d\u001a\u00020B2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020RR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010)\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R$\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R(\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u001b\u001a\u0004\u0018\u0001098F@FX\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020@X\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/yy/mobile/rollingtextview/RollingTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "animationDuration", "", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "animationInterpolator", "Landroid/view/animation/Interpolator;", "getAnimationInterpolator", "()Landroid/view/animation/Interpolator;", "setAnimationInterpolator", "(Landroid/view/animation/Interpolator;)V", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "charOrderManager", "Lcom/yy/mobile/rollingtextview/CharOrderManager;", "value", "Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;", "charStrategy", "getCharStrategy", "()Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;", "setCharStrategy", "(Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;)V", "currentText", "", "getCurrentText", "()[C", "gravity", "lastMeasuredDesiredHeight", "lastMeasuredDesiredWidth", "letterSpacingExtra", "getLetterSpacingExtra", "()I", "setLetterSpacingExtra", "(I)V", "targetText", "", "color", "textColor", "getTextColor", "setTextColor", "textManager", "Lcom/yy/mobile/rollingtextview/TextManager;", "textPaint", "Landroid/graphics/Paint;", "textStyle", "Landroid/graphics/Typeface;", "typeface", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", "viewBounds", "Landroid/graphics/Rect;", "addAnimatorListener", "", "listener", "Landroid/animation/Animator$AnimatorListener;", "addCharOrder", "orderList", "", "", "([Ljava/lang/Character;)V", "", "checkForReLayout", "", "computeDesiredHeight", "computeDesiredWidth", "getBaseline", "getText", "getTextSize", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "width", "height", "oldw", "oldh", "onTextPaintMeasurementChanged", "realignAndClipCanvasForGravity", "removeAnimatorListener", "setText", "text", "animate", "setTextSize", "textSize", "unit", "size", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: RollingTextView.kt */
public class RollingTextView extends View {
    private long animationDuration;
    private Interpolator animationInterpolator;
    private ValueAnimator animator;
    private final CharOrderManager charOrderManager;
    private int gravity;
    private int lastMeasuredDesiredHeight;
    private int lastMeasuredDesiredWidth;
    private CharSequence targetText;
    private int textColor;
    /* access modifiers changed from: private */
    public final TextManager textManager;
    private final Paint textPaint;
    private int textStyle;
    private final Rect viewBounds;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RollingTextView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RollingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RollingTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RollingTextView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RollingTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Ref.ObjectRef objectRef;
        Ref.FloatRef floatRef;
        TypedArray typedArray;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Paint paint = new Paint();
        this.textPaint = paint;
        CharOrderManager charOrderManager2 = new CharOrderManager();
        this.charOrderManager = charOrderManager2;
        this.textManager = new TextManager(paint, charOrderManager2);
        this.animator = ValueAnimator.ofFloat(new float[]{1.0f});
        this.viewBounds = new Rect();
        this.gravity = 8388613;
        this.targetText = "";
        this.animationDuration = 750;
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.FloatRef floatRef2 = new Ref.FloatRef();
        Ref.FloatRef floatRef3 = new Ref.FloatRef();
        Ref.FloatRef floatRef4 = new Ref.FloatRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        Ref.FloatRef floatRef5 = new Ref.FloatRef();
        floatRef5.element = TypedValue.applyDimension(2, 12.0f, context.getResources().getDisplayMetrics());
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.RollingTextView, i, i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…efStyleAttr, defStyleRes)");
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.RollingTextView_android_textAppearance, -1);
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(resourceId, R.styleable.RollingTextView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes2, "context.obtainStyledAttr…tyleable.RollingTextView)");
            TypedArray typedArray2 = obtainStyledAttributes2;
            typedArray = obtainStyledAttributes;
            floatRef = floatRef5;
            objectRef = objectRef2;
            _init_$applyTypedArray(this, intRef, floatRef2, floatRef3, floatRef4, objectRef2, floatRef5, typedArray2);
            typedArray2.recycle();
        } else {
            typedArray = obtainStyledAttributes;
            floatRef = floatRef5;
            objectRef = objectRef2;
        }
        _init_$applyTypedArray(this, intRef, floatRef2, floatRef3, floatRef4, objectRef, floatRef, typedArray);
        TypedArray typedArray3 = typedArray;
        this.animationDuration = (long) typedArray3.getInt(R.styleable.RollingTextView_duration, (int) this.animationDuration);
        paint.setAntiAlias(true);
        if (intRef.element != 0) {
            paint.setShadowLayer(floatRef4.element, floatRef2.element, floatRef3.element, intRef.element);
        }
        if (this.textStyle != 0) {
            setTypeface(paint.getTypeface());
        }
        setTextSize(0, floatRef.element);
        setText((CharSequence) objectRef.element, false);
        typedArray3.recycle();
        this.animator.addUpdateListener(new RollingTextView$$ExternalSyntheticLambda0(this));
        this.animator.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ RollingTextView this$0;

            {
                this.this$0 = r1;
            }

            public void onAnimationEnd(Animator animator) {
                this.this$0.textManager.onAnimationEnd();
            }
        });
        this.animationInterpolator = new LinearInterpolator();
        this.textColor = -16777216;
    }

    public final long getAnimationDuration() {
        return this.animationDuration;
    }

    public final void setAnimationDuration(long j) {
        this.animationDuration = j;
    }

    public final void setTypeface(Typeface typeface) {
        Paint paint = this.textPaint;
        int i = this.textStyle;
        if (i == 1) {
            typeface = Typeface.create(typeface, 1);
        } else if (i == 2) {
            typeface = Typeface.create(typeface, 2);
        } else if (i == 3) {
            typeface = Typeface.create(typeface, 3);
        }
        paint.setTypeface(typeface);
        onTextPaintMeasurementChanged();
    }

    public final Typeface getTypeface() {
        return this.textPaint.getTypeface();
    }

    private static final void _init_$applyTypedArray(RollingTextView rollingTextView, Ref.IntRef intRef, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.FloatRef floatRef3, Ref.ObjectRef<String> objectRef, Ref.FloatRef floatRef4, TypedArray typedArray) {
        rollingTextView.gravity = typedArray.getInt(R.styleable.RollingTextView_android_gravity, rollingTextView.gravity);
        intRef.element = typedArray.getColor(R.styleable.RollingTextView_android_shadowColor, intRef.element);
        floatRef.element = typedArray.getFloat(R.styleable.RollingTextView_android_shadowDx, floatRef.element);
        floatRef2.element = typedArray.getFloat(R.styleable.RollingTextView_android_shadowDy, floatRef2.element);
        floatRef3.element = typedArray.getFloat(R.styleable.RollingTextView_android_shadowRadius, floatRef3.element);
        String string = typedArray.getString(R.styleable.RollingTextView_android_text);
        if (string == null) {
            string = "";
        }
        objectRef.element = string;
        rollingTextView.setTextColor(typedArray.getColor(R.styleable.RollingTextView_android_textColor, rollingTextView.textColor));
        floatRef4.element = typedArray.getDimension(R.styleable.RollingTextView_android_textSize, floatRef4.element);
        rollingTextView.textStyle = typedArray.getInt(R.styleable.RollingTextView_android_textStyle, rollingTextView.textStyle);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m0_init_$lambda0(RollingTextView rollingTextView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(rollingTextView, "this$0");
        rollingTextView.textManager.updateAnimation(valueAnimator.getAnimatedFraction());
        rollingTextView.checkForReLayout();
        rollingTextView.invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        realignAndClipCanvasForGravity(canvas);
        canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, this.textManager.getTextBaseline());
        this.textManager.draw(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.lastMeasuredDesiredWidth = computeDesiredWidth();
        this.lastMeasuredDesiredHeight = computeDesiredHeight();
        setMeasuredDimension(View.resolveSize(this.lastMeasuredDesiredWidth, i), View.resolveSize(this.lastMeasuredDesiredHeight, i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.viewBounds.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
    }

    private final boolean checkForReLayout() {
        requestLayout();
        return true;
    }

    private final int computeDesiredWidth() {
        return ((int) this.textManager.getCurrentTextWidth()) + getPaddingLeft() + getPaddingRight();
    }

    private final int computeDesiredHeight() {
        return ((int) this.textManager.getTextHeight()) + getPaddingTop() + getPaddingBottom();
    }

    private final void realignAndClipCanvasForGravity(Canvas canvas) {
        float currentTextWidth = this.textManager.getCurrentTextWidth();
        float textHeight = this.textManager.getTextHeight();
        int width = this.viewBounds.width();
        int height = this.viewBounds.height();
        float f = (this.gravity & 16) == 16 ? ((float) this.viewBounds.top) + ((((float) height) - textHeight) / 2.0f) : 0.0f;
        float f2 = (this.gravity & 1) == 1 ? ((float) this.viewBounds.left) + ((((float) width) - currentTextWidth) / 2.0f) : 0.0f;
        if ((this.gravity & 48) == 48) {
            f = (float) this.viewBounds.top;
        }
        if ((this.gravity & 80) == 80) {
            f = ((float) this.viewBounds.top) + (((float) height) - textHeight);
        }
        if ((this.gravity & 8388611) == 8388611) {
            f2 = (float) this.viewBounds.left;
        }
        if ((this.gravity & 8388613) == 8388613) {
            f2 = ((float) this.viewBounds.left) + (((float) width) - currentTextWidth);
        }
        canvas.translate(f2, f);
        canvas.clipRect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, currentTextWidth, textHeight);
    }

    private final void onTextPaintMeasurementChanged() {
        this.textManager.updateFontMatrics();
        checkForReLayout();
        invalidate();
    }

    public final Interpolator getAnimationInterpolator() {
        return this.animationInterpolator;
    }

    public final void setAnimationInterpolator(Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(interpolator, "<set-?>");
        this.animationInterpolator = interpolator;
    }

    public final void setText(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        setText(charSequence, !TextUtils.isEmpty(this.targetText));
    }

    public final CharSequence getText() {
        return this.targetText;
    }

    public final void setText(CharSequence charSequence, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.targetText = charSequence;
        if (z) {
            this.textManager.setText(charSequence);
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            valueAnimator.setDuration(getAnimationDuration());
            valueAnimator.setInterpolator(getAnimationInterpolator());
            post(new RollingTextView$$ExternalSyntheticLambda1(valueAnimator));
            return;
        }
        CharOrderStrategy charStrategy = getCharStrategy();
        setCharStrategy(Strategy.NoAnimation());
        this.textManager.setText(charSequence);
        setCharStrategy(charStrategy);
        this.textManager.onAnimationEnd();
        checkForReLayout();
        invalidate();
    }

    /* access modifiers changed from: private */
    /* renamed from: setText$lambda-2$lambda-1  reason: not valid java name */
    public static final void m1setText$lambda2$lambda1(ValueAnimator valueAnimator) {
        valueAnimator.start();
    }

    public final char[] getCurrentText() {
        return this.textManager.getCurrentText();
    }

    public final void setTextSize(float f) {
        setTextSize(2, f);
    }

    public final float getTextSize() {
        return this.textPaint.getTextSize();
    }

    public final void setTextSize(int i, float f) {
        Context context = getContext();
        Resources resources = context == null ? null : context.getResources();
        if (resources == null) {
            resources = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(resources, "getSystem()");
        }
        this.textPaint.setTextSize(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
        onTextPaintMeasurementChanged();
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(int i) {
        if (this.textColor != i) {
            this.textColor = i;
            this.textPaint.setColor(i);
            invalidate();
        }
    }

    public final void setLetterSpacingExtra(int i) {
        this.textManager.setLetterSpacingExtra(i);
    }

    public final int getLetterSpacingExtra() {
        return this.textManager.getLetterSpacingExtra();
    }

    public int getBaseline() {
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        float f = (float) 2;
        return (int) ((this.textManager.getTextHeight() / f) + (((fontMetrics.descent - fontMetrics.ascent) / f) - fontMetrics.descent));
    }

    public final void setCharStrategy(CharOrderStrategy charOrderStrategy) {
        Intrinsics.checkNotNullParameter(charOrderStrategy, "value");
        this.charOrderManager.setCharStrategy(charOrderStrategy);
    }

    public final CharOrderStrategy getCharStrategy() {
        return this.charOrderManager.getCharStrategy();
    }

    public final void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        Intrinsics.checkNotNullParameter(animatorListener, "listener");
        this.animator.addListener(animatorListener);
    }

    public final void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        Intrinsics.checkNotNullParameter(animatorListener, "listener");
        this.animator.removeListener(animatorListener);
    }

    public final void addCharOrder(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "orderList");
        this.charOrderManager.addCharOrder(StringsKt.asIterable(charSequence));
    }

    public final void addCharOrder(Iterable<Character> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "orderList");
        this.charOrderManager.addCharOrder(iterable);
    }

    public final void addCharOrder(Character[] chArr) {
        Intrinsics.checkNotNullParameter(chArr, "orderList");
        this.charOrderManager.addCharOrder(ArraysKt.asIterable(chArr));
    }
}
