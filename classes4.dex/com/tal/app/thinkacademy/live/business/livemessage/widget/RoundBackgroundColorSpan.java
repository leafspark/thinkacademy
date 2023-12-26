package com.tal.app.thinkacademy.live.business.livemessage.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class RoundBackgroundColorSpan extends ReplacementSpan {
    private final int bgColor;
    private final int innerColor;
    private final int mRadius;
    private int mSize;
    private int paddingRight = 0;
    private final int textColor;

    public RoundBackgroundColorSpan(int i, int i2, int i3) {
        this.bgColor = i;
        this.innerColor = 0;
        this.textColor = i2;
        this.mRadius = i3;
    }

    public RoundBackgroundColorSpan(int i, int i2, int i3, int i4) {
        this.bgColor = i;
        this.innerColor = i2;
        this.textColor = i3;
        this.mRadius = i4;
    }

    public void setPaddingRight(int i) {
        this.paddingRight = i;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        int measureText = (int) (paint.measureText(charSequence, i, i2) + (((float) this.mRadius) * 1.2f));
        this.mSize = measureText;
        return measureText + this.paddingRight;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2 = f;
        Paint paint2 = paint;
        int color = paint.getColor();
        float strokeWidth = paint.getStrokeWidth();
        paint2.setColor(this.bgColor);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(2.0f);
        paint2.setAntiAlias(true);
        float f3 = (float) i4;
        RectF rectF = new RectF(f2, paint.ascent() + f3, ((float) this.mSize) + f2, paint.descent() + f3);
        int i6 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint2);
        paint2.setColor(this.innerColor);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(2.0f);
        paint2.setAntiAlias(true);
        RectF rectF2 = new RectF(f2, paint.ascent() + f3, ((float) this.mSize) + f2, paint.descent() + f3);
        int i7 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i7, (float) i7, paint2);
        paint2.setColor(this.textColor);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(strokeWidth);
        canvas.drawText(charSequence, i, i2, f2 + (((float) this.mRadius) * 0.6f), f3, paint);
        paint2.setColor(color);
    }
}
