package com.adyen.checkout.components.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.adyen.checkout.components.ui.R;

public class RoundCornerImageView extends AppCompatImageView {
    public static final float DEFAULT_RADIUS = 9.0f;
    public static final int DEFAULT_STROKE_COLOR = -16777216;
    public static final float DEFAULT_STROKE_WIDTH = 4.0f;
    private boolean mIsBorderEnabled;
    private float mRadius;
    private int mStrokeColor;
    private final Paint mStrokePaint;
    private float mStrokeWidth;

    public RoundCornerImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStrokePaint = new Paint();
        this.mIsBorderEnabled = true;
        applyAttrs(context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.RoundCornerImageView, 0, 0));
    }

    public void setRadius(float f) {
        this.mRadius = f;
        invalidate();
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
        invalidate();
    }

    public void setBorderEnabled(boolean z) {
        this.mIsBorderEnabled = z;
        invalidate();
    }

    private void applyAttrs(TypedArray typedArray) {
        try {
            this.mStrokeColor = typedArray.getColor(R.styleable.RoundCornerImageView_strokeColor, -16777216);
            this.mStrokeWidth = typedArray.getDimension(R.styleable.RoundCornerImageView_strokeWidth, 4.0f);
            this.mRadius = typedArray.getDimension(R.styleable.RoundCornerImageView_radius, 9.0f);
        } finally {
            typedArray.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        float f = this.mStrokeWidth;
        super.onMeasure(i + (((int) f) * 2), i2 + (((int) f) * 2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.mIsBorderEnabled) {
            super.onDraw(canvas);
            return;
        }
        float f = this.mStrokeWidth;
        RectF rectF = new RectF(f / 2.0f, f / 2.0f, ((float) getWidth()) - (this.mStrokeWidth / 2.0f), ((float) getHeight()) - (this.mStrokeWidth / 2.0f));
        this.mStrokePaint.reset();
        if (this.mStrokeWidth > 0.0f) {
            this.mStrokePaint.setStyle(Paint.Style.STROKE);
            this.mStrokePaint.setAntiAlias(true);
            this.mStrokePaint.setColor(this.mStrokeColor);
            this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
            float f2 = this.mRadius;
            canvas.drawRoundRect(rectF, f2, f2, this.mStrokePaint);
        }
        Path path = new Path();
        float f3 = this.mRadius;
        path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
