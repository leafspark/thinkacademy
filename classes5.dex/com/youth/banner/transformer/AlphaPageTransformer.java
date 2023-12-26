package com.youth.banner.transformer;

import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

public class AlphaPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_ALPHA = 0.5f;
    private float mMinAlpha = 0.5f;

    public AlphaPageTransformer() {
    }

    public AlphaPageTransformer(float f) {
        this.mMinAlpha = f;
    }

    public void transformPage(View view, float f) {
        view.setScaleX(0.999f);
        if (f < -1.0f) {
            view.setAlpha(this.mMinAlpha);
        } else if (f > 1.0f) {
            view.setAlpha(this.mMinAlpha);
        } else if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            float f2 = this.mMinAlpha;
            view.setAlpha(f2 + ((1.0f - f2) * (f + 1.0f)));
        } else {
            float f3 = this.mMinAlpha;
            view.setAlpha(f3 + ((1.0f - f3) * (1.0f - f)));
        }
    }
}
