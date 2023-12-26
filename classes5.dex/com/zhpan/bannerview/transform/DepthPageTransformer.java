package com.zhpan.bannerview.transform;

import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

public class DepthPageTransformer extends BaseTransformer {
    private static final float MIN_SCALE = 0.75f;

    /* access modifiers changed from: protected */
    public boolean isPagingEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            view.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f <= 1.0f) {
            float abs = ((1.0f - Math.abs(f)) * 0.25f) + MIN_SCALE;
            view.setAlpha(1.0f - f);
            view.setPivotY(((float) view.getHeight()) * 0.5f);
            view.setTranslationX(((float) view.getWidth()) * (-f));
            view.setScaleX(abs);
            view.setScaleY(abs);
        }
    }
}
