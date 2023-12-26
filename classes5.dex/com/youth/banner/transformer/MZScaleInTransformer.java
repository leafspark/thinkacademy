package com.youth.banner.transformer;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.yalantis.ucrop.view.CropImageView;

public class MZScaleInTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    private float mMinScale = 0.85f;

    public MZScaleInTransformer() {
    }

    public MZScaleInTransformer(float f) {
        this.mMinScale = f;
    }

    public void transformPage(View view, float f) {
        ViewPager2 requireViewPager = requireViewPager(view);
        float paddingLeft = (float) requireViewPager.getPaddingLeft();
        float measuredWidth = f - (paddingLeft / ((((float) requireViewPager.getMeasuredWidth()) - paddingLeft) - ((float) requireViewPager.getPaddingRight())));
        float f2 = this.mMinScale;
        float width = ((1.0f - f2) * ((float) view.getWidth())) / 2.0f;
        if (measuredWidth <= -1.0f) {
            view.setTranslationX(width);
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
            return;
        }
        double d = (double) measuredWidth;
        if (d <= 1.0d) {
            float abs = (1.0f - f2) * Math.abs(1.0f - Math.abs(measuredWidth));
            float f3 = (-width) * measuredWidth;
            if (d <= -0.5d) {
                view.setTranslationX(f3 + (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
            } else if (measuredWidth <= CropImageView.DEFAULT_ASPECT_RATIO) {
                view.setTranslationX(f3);
            } else if (d >= 0.5d) {
                view.setTranslationX(f3 - (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
            } else {
                view.setTranslationX(f3);
            }
            view.setScaleX(this.mMinScale + abs);
            view.setScaleY(abs + this.mMinScale);
            return;
        }
        view.setScaleX(f2);
        view.setScaleY(this.mMinScale);
        view.setTranslationX(-width);
    }

    private ViewPager2 requireViewPager(View view) {
        ViewParent parent = view.getParent();
        ViewPager2 parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }
}
