package com.tal.app.thinkacademy.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.util.ViewLevelCons;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u001fJ\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0015J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/tal/app/thinkacademy/live/view/CircularProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBackGroundPaint", "Landroid/graphics/Paint;", "mCircleColor", "mCircleRadius", "", "mEndColor", "mMaxProgress", "mProgress", "mProgressPaint", "mRingRadius", "mStartColor", "mStrokeWidth", "mTextColor", "mTextContent", "", "mTextHeight", "mTextPaint", "mTextSize", "mTextWidth", "mXCenter", "mYCenter", "initArrrs", "", "initMaxProgress", "progress", "maxProgress", "initPaint", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateProgress", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CircularProgressView.kt */
public final class CircularProgressView extends View {
    private Paint mBackGroundPaint;
    private int mCircleColor;
    private float mCircleRadius;
    private int mEndColor;
    private int mMaxProgress;
    private int mProgress;
    private Paint mProgressPaint;
    private float mRingRadius;
    private int mStartColor;
    private float mStrokeWidth;
    private int mTextColor;
    private String mTextContent;
    private float mTextHeight;
    private Paint mTextPaint;
    private float mTextSize;
    private float mTextWidth;
    private float mXCenter;
    private float mYCenter;

    public CircularProgressView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircularProgressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCircleRadius = (float) SizeUtils.dp2px(20.0f);
        this.mStrokeWidth = (float) SizeUtils.dp2px(2.0f);
        this.mCircleColor = Color.parseColor("#80000000");
        this.mStartColor = Color.parseColor("#FFD518");
        this.mEndColor = Color.parseColor("#FFAA0A");
        this.mTextColor = -1;
        this.mTextSize = (float) SizeUtils.dp2px(14.0f);
        this.mMaxProgress = 10;
        this.mTextContent = "10s";
        initArrrs(context, attributeSet);
        initPaint();
    }

    public static /* synthetic */ void initArrrs$default(CircularProgressView circularProgressView, Context context, AttributeSet attributeSet, int i, Object obj) {
        if ((i & 2) != 0) {
            attributeSet = null;
        }
        circularProgressView.initArrrs(context, attributeSet);
    }

    public final void initArrrs(Context context, AttributeSet attributeSet) {
        Resources.Theme theme;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            if (!(context == null || (theme = context.getTheme()) == null)) {
                typedArray = theme.obtainStyledAttributes(attributeSet, R.styleable.CircularProgressView, 0, 0);
            }
            if (typedArray != null) {
                this.mCircleRadius = typedArray.getDimension(R.styleable.CircularProgressView_radius, (float) SizeUtils.dp2px(20.0f));
                this.mStrokeWidth = typedArray.getDimension(R.styleable.CircularProgressView_strokeWIdth, (float) SizeUtils.dp2px(2.0f));
                this.mCircleColor = typedArray.getColor(R.styleable.CircularProgressView_ringColor, Color.parseColor("#80000000"));
                this.mStartColor = typedArray.getColor(R.styleable.CircularProgressView_ringStartColor, Color.parseColor("#FFD518"));
                this.mEndColor = typedArray.getColor(R.styleable.CircularProgressView_ringEndColor, Color.parseColor("#FFAA0A"));
                this.mTextColor = typedArray.getColor(R.styleable.CircularProgressView_textColor, -1);
                this.mTextSize = typedArray.getDimension(R.styleable.CircularProgressView_textSize, (float) SizeUtils.dp2px(14.0f));
                this.mProgress = typedArray.getInt(R.styleable.CircularProgressView_progress, 0);
                this.mMaxProgress = typedArray.getInt(R.styleable.CircularProgressView_maxProgress, 10);
            }
        }
        this.mRingRadius = this.mCircleRadius - (this.mStrokeWidth / ((float) 2));
    }

    public final void initPaint() {
        float f;
        Paint paint = new Paint(1);
        this.mBackGroundPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = this.mBackGroundPaint;
        if (paint2 != null) {
            paint2.setColor(this.mCircleColor);
        }
        Paint paint3 = new Paint(1);
        this.mTextPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = this.mTextPaint;
        if (paint4 != null) {
            paint4.setColor(this.mTextColor);
        }
        Paint paint5 = this.mTextPaint;
        if (paint5 != null) {
            paint5.setTextSize(this.mTextSize);
        }
        Paint paint6 = this.mTextPaint;
        if (paint6 != null) {
            paint6.setTextAlign(Paint.Align.CENTER);
        }
        Paint paint7 = new Paint(1);
        this.mProgressPaint = paint7;
        paint7.setStyle(Paint.Style.STROKE);
        Paint paint8 = this.mProgressPaint;
        if (paint8 != null) {
            paint8.setStrokeWidth(this.mStrokeWidth);
        }
        Paint paint9 = this.mProgressPaint;
        if (paint9 != null) {
            paint9.setStrokeCap(Paint.Cap.BUTT);
        }
        Paint paint10 = this.mProgressPaint;
        if (paint10 != null) {
            paint10.setShader(new SweepGradient((float) (getWidth() / 2), (float) (getHeight() / 2), this.mStartColor, this.mEndColor));
        }
        Paint paint11 = this.mTextPaint;
        Paint.FontMetrics fontMetrics = paint11 == null ? null : paint11.getFontMetrics();
        float f2 = 0.0f;
        if (fontMetrics == null) {
            f = 0.0f;
        } else {
            f = fontMetrics.descent;
        }
        if (fontMetrics != null) {
            f2 = fontMetrics.ascent;
        }
        this.mTextHeight = (float) Math.ceil((double) (f - f2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mXCenter = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        this.mYCenter = height;
        float f = this.mCircleRadius;
        float f2 = this.mXCenter;
        if (f > f2) {
            this.mCircleRadius = f2;
        }
        Paint paint = this.mBackGroundPaint;
        if (!(paint == null || canvas == null)) {
            canvas.drawCircle(f2, height, this.mCircleRadius, paint);
        }
        int i = this.mMaxProgress;
        int i2 = this.mProgress;
        if (i2 >= 0 && i2 <= i) {
            Paint paint2 = this.mTextPaint;
            if (paint2 != null) {
                StringBuilder sb = new StringBuilder();
                int i3 = this.mMaxProgress;
                sb.append((int) ((float) Math.ceil((double) (((((float) i3) - ((float) this.mProgress)) / ((float) i3)) * ((float) 10)))));
                sb.append('s');
                String sb2 = sb.toString();
                this.mTextContent = sb2;
                Paint paint3 = this.mTextPaint;
                this.mTextWidth = paint3 == null ? 0.0f : paint3.measureText(sb2, 0, sb2.length());
                if (canvas != null) {
                    canvas.drawText(this.mTextContent, this.mXCenter, this.mYCenter + (this.mTextHeight / ((float) 4)), paint2);
                }
            }
            Paint paint4 = this.mProgressPaint;
            if (paint4 != null) {
                RectF rectF = new RectF();
                rectF.left = this.mXCenter - this.mRingRadius;
                rectF.top = this.mYCenter - this.mRingRadius;
                rectF.right = this.mXCenter + this.mRingRadius;
                rectF.bottom = this.mYCenter + this.mRingRadius;
                if (canvas != null) {
                    canvas.drawArc(rectF, -90.0f, (((float) this.mProgress) / ((float) this.mMaxProgress)) * ((float) ViewLevelCons.LEVEL_GiftLivePluginDriver_sendGiftBarrage), false, paint4);
                }
            }
        }
    }

    public final void updateProgress(int i) {
        this.mProgress = i;
        postInvalidate();
    }

    public final void initMaxProgress(int i, int i2) {
        this.mProgress = i;
        this.mMaxProgress = i2;
        postInvalidate();
    }
}
