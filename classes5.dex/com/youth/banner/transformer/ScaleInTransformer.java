package com.youth.banner.transformer;

import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

public class ScaleInTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    private float mMinScale = 0.85f;

    public ScaleInTransformer() {
    }

    public ScaleInTransformer(float f) {
        this.mMinScale = f;
    }

    public void transformPage(View view, float f) {
        int width = view.getWidth();
        view.setPivotY((float) (view.getHeight() / 2));
        view.setPivotX((float) (width / 2));
        if (f < -1.0f) {
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
            view.setPivotX((float) width);
        } else if (f > 1.0f) {
            view.setPivotX(CropImageView.DEFAULT_ASPECT_RATIO);
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
        } else if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            float f2 = this.mMinScale;
            float f3 = ((f + 1.0f) * (1.0f - f2)) + f2;
            view.setScaleX(f3);
            view.setScaleY(f3);
            view.setPivotX(((float) width) * (((-f) * 0.5f) + 0.5f));
        } else {
            float f4 = 1.0f - f;
            float f5 = this.mMinScale;
            float f6 = ((1.0f - f5) * f4) + f5;
            view.setScaleX(f6);
            view.setScaleY(f6);
            view.setPivotX(((float) width) * f4 * 0.5f);
        }
    }
}
