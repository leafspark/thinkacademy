package com.didi.hummer.component.viewpager;

import android.view.View;
import com.zhpan.bannerview.transform.ScaleInTransformer;

public class ScaleAndAlphaTransformer extends ScaleInTransformer {
    public static final float DEFAULT_MIN_ALPHA = 0.5f;
    public static final float MAX_ALPHA = 1.0f;
    private float mMinAlpha;

    public ScaleAndAlphaTransformer(float f, float f2) {
        super(f);
        this.mMinAlpha = f2;
    }

    public void transformPage(View view, float f) {
        ScaleAndAlphaTransformer.super.transformPage(view, f);
        if (f < -1.0f || f > 1.0f) {
            view.setAlpha(this.mMinAlpha);
        } else if (f < 0.0f) {
            float f2 = this.mMinAlpha;
            view.setAlpha(((f + 1.0f) * (1.0f - f2)) + f2);
        } else {
            float f3 = this.mMinAlpha;
            view.setAlpha(((1.0f - f) * (1.0f - f3)) + f3);
        }
    }
}
