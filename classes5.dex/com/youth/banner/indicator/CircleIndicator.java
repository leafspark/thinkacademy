package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.yalantis.ucrop.view.CropImageView;

public class CircleIndicator extends BaseIndicator {
    private int mNormalRadius;
    private int mSelectedRadius;
    private int maxRadius;

    public CircleIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNormalRadius = this.config.getNormalWidth() / 2;
        this.mSelectedRadius = this.config.getSelectedWidth() / 2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            this.mNormalRadius = this.config.getNormalWidth() / 2;
            int selectedWidth = this.config.getSelectedWidth() / 2;
            this.mSelectedRadius = selectedWidth;
            this.maxRadius = Math.max(selectedWidth, this.mNormalRadius);
            int i3 = indicatorSize - 1;
            setMeasuredDimension((this.config.getIndicatorSpace() * i3) + this.config.getSelectedWidth() + (this.config.getNormalWidth() * i3), Math.max(this.config.getNormalWidth(), this.config.getSelectedWidth()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            float f = CropImageView.DEFAULT_ASPECT_RATIO;
            int i = 0;
            while (i < indicatorSize) {
                this.mPaint.setColor(this.config.getCurrentPosition() == i ? this.config.getSelectedColor() : this.config.getNormalColor());
                int selectedWidth = this.config.getCurrentPosition() == i ? this.config.getSelectedWidth() : this.config.getNormalWidth();
                float f2 = (float) (this.config.getCurrentPosition() == i ? this.mSelectedRadius : this.mNormalRadius);
                canvas.drawCircle(f + f2, (float) this.maxRadius, f2, this.mPaint);
                f += (float) (selectedWidth + this.config.getIndicatorSpace());
                i++;
            }
        }
    }
}
