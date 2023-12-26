package com.zhpan.bannerview.transform;

import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

public class RotateUpTransformer extends BaseTransformer {
    private static final float ROT_MOD = -15.0f;

    /* access modifiers changed from: protected */
    public boolean isPagingEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        float f2 = f * ROT_MOD;
        view.setPivotX(((float) view.getWidth()) * 0.5f);
        view.setPivotY(CropImageView.DEFAULT_ASPECT_RATIO);
        view.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
        view.setRotation(f2);
    }
}
