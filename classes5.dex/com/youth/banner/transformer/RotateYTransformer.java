package com.youth.banner.transformer;

import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

public class RotateYTransformer extends BasePageTransformer {
    private static final float DEFAULT_MAX_ROTATE = 35.0f;
    private float mMaxRotate = DEFAULT_MAX_ROTATE;

    public RotateYTransformer() {
    }

    public RotateYTransformer(float f) {
        this.mMaxRotate = f;
    }

    public void transformPage(View view, float f) {
        view.setPivotY((float) (view.getHeight() / 2));
        if (f < -1.0f) {
            view.setRotationY(this.mMaxRotate * -1.0f);
            view.setPivotX((float) view.getWidth());
        } else if (f <= 1.0f) {
            view.setRotationY(this.mMaxRotate * f);
            if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
                view.setPivotX(((float) view.getWidth()) * (((-f) * 0.5f) + 0.5f));
                view.setPivotX((float) view.getWidth());
                return;
            }
            view.setPivotX(((float) view.getWidth()) * 0.5f * (1.0f - f));
            view.setPivotX(CropImageView.DEFAULT_ASPECT_RATIO);
        } else {
            view.setRotationY(this.mMaxRotate * 1.0f);
            view.setPivotX(CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }
}
