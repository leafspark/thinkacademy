package com.youth.banner.transformer;

import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

public class DepthPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_SCALE = 0.75f;
    private float mMinScale = DEFAULT_MIN_SCALE;

    public DepthPageTransformer() {
    }

    public DepthPageTransformer(float f) {
        this.mMinScale = f;
    }

    public void transformPage(View view, float f) {
        int width = view.getWidth();
        if (f < -1.0f) {
            view.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        } else if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            view.setAlpha(1.0f);
            view.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f <= 1.0f) {
            view.setVisibility(0);
            view.setAlpha(1.0f - f);
            view.setTranslationX(((float) width) * (-f));
            float f2 = this.mMinScale;
            float abs = f2 + ((1.0f - f2) * (1.0f - Math.abs(f)));
            view.setScaleX(abs);
            view.setScaleY(abs);
            if (f == 1.0f) {
                view.setVisibility(4);
            }
        } else {
            view.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }
}
