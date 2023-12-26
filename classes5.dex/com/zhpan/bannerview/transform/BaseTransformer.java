package com.zhpan.bannerview.transform;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.yalantis.ucrop.view.CropImageView;

public abstract class BaseTransformer implements ViewPager.PageTransformer {
    protected static final float min(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    /* access modifiers changed from: protected */
    public boolean hideOffscreenPages() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isPagingEnabled() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPostTransform(View view, float f) {
    }

    /* access modifiers changed from: protected */
    public abstract void onTransform(View view, float f);

    public void transformPage(View view, float f) {
        onPreTransform(view, f);
        onTransform(view, f);
        onPostTransform(view, f);
    }

    /* access modifiers changed from: protected */
    public void onPreTransform(View view, float f) {
        float width = (float) view.getWidth();
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        view.setRotationX(CropImageView.DEFAULT_ASPECT_RATIO);
        view.setRotationY(CropImageView.DEFAULT_ASPECT_RATIO);
        view.setRotation(CropImageView.DEFAULT_ASPECT_RATIO);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setPivotX(CropImageView.DEFAULT_ASPECT_RATIO);
        view.setPivotY(CropImageView.DEFAULT_ASPECT_RATIO);
        view.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
        view.setTranslationX(isPagingEnabled() ? 0.0f : (-width) * f);
        if (hideOffscreenPages()) {
            if (f > -1.0f && f < 1.0f) {
                f2 = 1.0f;
            }
            view.setAlpha(f2);
            return;
        }
        view.setAlpha(1.0f);
    }
}
