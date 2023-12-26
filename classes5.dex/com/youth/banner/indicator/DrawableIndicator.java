package com.youth.banner.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.yalantis.ucrop.view.CropImageView;
import com.youth.banner.R;

public class DrawableIndicator extends BaseIndicator {
    private Bitmap normalBitmap;
    private Bitmap selectedBitmap;

    public DrawableIndicator(Context context, int i, int i2) {
        super(context);
        this.normalBitmap = BitmapFactoryInstrumentation.decodeResource(getResources(), i);
        this.selectedBitmap = BitmapFactoryInstrumentation.decodeResource(getResources(), i2);
    }

    public DrawableIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DrawableIndicator);
        if (obtainStyledAttributes != null) {
            this.normalBitmap = ((BitmapDrawable) obtainStyledAttributes.getDrawable(R.styleable.DrawableIndicator_normal_drawable)).getBitmap();
            this.selectedBitmap = ((BitmapDrawable) obtainStyledAttributes.getDrawable(R.styleable.DrawableIndicator_selected_drawable)).getBitmap();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            int i3 = indicatorSize - 1;
            setMeasuredDimension((this.selectedBitmap.getWidth() * i3) + this.selectedBitmap.getWidth() + (this.config.getIndicatorSpace() * i3), Math.max(this.normalBitmap.getHeight(), this.selectedBitmap.getHeight()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1 && this.normalBitmap != null && this.selectedBitmap != null) {
            int i = 0;
            float f = 0.0f;
            while (i < indicatorSize) {
                canvas.drawBitmap(this.config.getCurrentPosition() == i ? this.selectedBitmap : this.normalBitmap, f, CropImageView.DEFAULT_ASPECT_RATIO, this.mPaint);
                f += (float) (this.normalBitmap.getWidth() + this.config.getIndicatorSpace());
                i++;
            }
        }
    }
}
