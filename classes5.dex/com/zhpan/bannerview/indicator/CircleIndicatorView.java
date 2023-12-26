package com.zhpan.bannerview.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

@Deprecated
public class CircleIndicatorView extends BaseIndicatorView {
    private int height;
    private float mCheckedRadius;
    private float mNormalRadius;
    private Paint mPaint;
    private float maxRadius;

    public CircleIndicatorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircleIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(getNormalColor());
        this.mNormalRadius = getNormalSliderWidth() / 2.0f;
        this.mCheckedRadius = getCheckedSliderWidth() / 2.0f;
        getIndicatorOptions().setSliderGap(this.mNormalRadius * 2.0f);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.height = getHeight();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mNormalRadius = getNormalSliderWidth() / 2.0f;
        float checkedSliderWidth = getCheckedSliderWidth() / 2.0f;
        this.mCheckedRadius = checkedSliderWidth;
        this.maxRadius = Math.max(checkedSliderWidth, this.mNormalRadius);
        setMeasuredDimension((int) ((((float) (getPageSize() - 1)) * getIndicatorGap()) + ((this.maxRadius + (this.mNormalRadius * ((float) (getPageSize() - 1)))) * 2.0f)), (int) (this.maxRadius * 2.0f));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getPageSize() > 1) {
            for (int i = 0; i < getPageSize(); i++) {
                this.mPaint.setColor(getNormalColor());
                canvas.drawCircle(this.maxRadius + (((this.mNormalRadius * 2.0f) + getIndicatorGap()) * ((float) i)), ((float) this.height) / 2.0f, this.mNormalRadius, this.mPaint);
            }
            drawSliderStyle(canvas);
        }
    }

    private void drawSliderStyle(Canvas canvas) {
        this.mPaint.setColor(getCheckedColor());
        canvas.drawCircle(this.maxRadius + (((this.mNormalRadius * 2.0f) + getIndicatorGap()) * ((float) getCurrentPosition())) + (((this.mNormalRadius * 2.0f) + getIndicatorGap()) * getSlideProgress()), ((float) this.height) / 2.0f, this.mCheckedRadius, this.mPaint);
    }
}
