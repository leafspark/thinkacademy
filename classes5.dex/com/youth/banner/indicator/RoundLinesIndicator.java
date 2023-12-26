package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.yalantis.ucrop.view.CropImageView;

public class RoundLinesIndicator extends BaseIndicator {
    public RoundLinesIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundLinesIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinesIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            setMeasuredDimension(this.config.getSelectedWidth() * indicatorSize, this.config.getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.config.getIndicatorSize() > 1) {
            this.mPaint.setColor(this.config.getNormalColor());
            canvas.drawRoundRect(new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (float) canvas.getWidth(), (float) this.config.getHeight()), (float) this.config.getRadius(), (float) this.config.getRadius(), this.mPaint);
            this.mPaint.setColor(this.config.getSelectedColor());
            int currentPosition = this.config.getCurrentPosition() * this.config.getSelectedWidth();
            canvas.drawRoundRect(new RectF((float) currentPosition, CropImageView.DEFAULT_ASPECT_RATIO, (float) (currentPosition + this.config.getSelectedWidth()), (float) this.config.getHeight()), (float) this.config.getRadius(), (float) this.config.getRadius(), this.mPaint);
        }
    }
}
