package com.youth.banner.transformer;

import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

public class ZoomOutPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_ALPHA = 0.5f;
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    private float mMinAlpha = 0.5f;
    private float mMinScale = 0.85f;

    public ZoomOutPageTransformer() {
    }

    public ZoomOutPageTransformer(float f, float f2) {
        this.mMinScale = f;
        this.mMinAlpha = f2;
    }

    public void transformPage(View view, float f) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (f < -1.0f) {
            view.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        } else if (f <= 1.0f) {
            float max = Math.max(this.mMinScale, 1.0f - Math.abs(f));
            float f2 = 1.0f - max;
            float f3 = (((float) height) * f2) / 2.0f;
            float f4 = (((float) width) * f2) / 2.0f;
            if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
                view.setTranslationX(f4 - (f3 / 2.0f));
            } else {
                view.setTranslationX((-f4) + (f3 / 2.0f));
            }
            view.setScaleX(max);
            view.setScaleY(max);
            float f5 = this.mMinAlpha;
            float f6 = this.mMinScale;
            view.setAlpha(f5 + (((max - f6) / (1.0f - f6)) * (1.0f - f5)));
        } else {
            view.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }
}
