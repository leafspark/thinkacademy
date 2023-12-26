package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.yalantis.ucrop.view.CropImageView;

public class RectangleIndicator extends BaseIndicator {
    RectF rectF;

    public RectangleIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rectF = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            int i3 = indicatorSize - 1;
            setMeasuredDimension((this.config.getIndicatorSpace() * i3) + (this.config.getNormalWidth() * i3) + this.config.getSelectedWidth(), this.config.getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            int i = 0;
            float f = 0.0f;
            while (i < indicatorSize) {
                this.mPaint.setColor(this.config.getCurrentPosition() == i ? this.config.getSelectedColor() : this.config.getNormalColor());
                int selectedWidth = this.config.getCurrentPosition() == i ? this.config.getSelectedWidth() : this.config.getNormalWidth();
                this.rectF.set(f, CropImageView.DEFAULT_ASPECT_RATIO, ((float) selectedWidth) + f, (float) this.config.getHeight());
                f += (float) (selectedWidth + this.config.getIndicatorSpace());
                canvas.drawRoundRect(this.rectF, (float) this.config.getRadius(), (float) this.config.getRadius(), this.mPaint);
                i++;
            }
        }
    }
}
