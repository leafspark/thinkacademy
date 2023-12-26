package com.zhpan.bannerview.transform;

import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

public class AccordionTransformer extends BaseTransformer {
    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        int i = (f > CropImageView.DEFAULT_ASPECT_RATIO ? 1 : (f == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : -1));
        if (i >= 0) {
            f2 = (float) view.getWidth();
        }
        view.setPivotX(f2);
        view.setScaleX(i < 0 ? f + 1.0f : 1.0f - f);
    }
}
