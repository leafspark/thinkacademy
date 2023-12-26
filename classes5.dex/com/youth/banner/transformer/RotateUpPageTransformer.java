package com.youth.banner.transformer;

import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

public class RotateUpPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MAX_ROTATE = 15.0f;
    private float mMaxRotate = DEFAULT_MAX_ROTATE;

    public RotateUpPageTransformer() {
    }

    public RotateUpPageTransformer(float f) {
        this.mMaxRotate = f;
    }

    public void transformPage(View view, float f) {
        if (f < -1.0f) {
            view.setRotation(this.mMaxRotate);
            view.setPivotX((float) view.getWidth());
            view.setPivotY(CropImageView.DEFAULT_ASPECT_RATIO);
        } else if (f > 1.0f) {
            view.setRotation(-this.mMaxRotate);
            view.setPivotX(CropImageView.DEFAULT_ASPECT_RATIO);
            view.setPivotY(CropImageView.DEFAULT_ASPECT_RATIO);
        } else if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            view.setPivotX(((float) view.getWidth()) * (((-f) * 0.5f) + 0.5f));
            view.setPivotY(CropImageView.DEFAULT_ASPECT_RATIO);
            view.setRotation((-this.mMaxRotate) * f);
        } else {
            view.setPivotX(((float) view.getWidth()) * 0.5f * (1.0f - f));
            view.setPivotY(CropImageView.DEFAULT_ASPECT_RATIO);
            view.setRotation((-this.mMaxRotate) * f);
        }
    }
}
