package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.PointF;
import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.yalantis.ucrop.view.CropImageView;

public class CubePlatform extends SixSides {
    /* access modifiers changed from: protected */
    public void pointConfig(RectF rectF, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, PointF pointF6, PointF pointF7, PointF pointF8) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        pointF.set(0.49f, CropImageView.DEFAULT_ASPECT_RATIO);
        pointF2.set(0.77f, CropImageView.DEFAULT_ASPECT_RATIO);
        pointF3.set(0.55f, 0.33f);
        pointF4.set(0.24f, 0.33f);
        pointF5.set(0.49f, 0.62f);
        pointF6.set(1.0f, 0.62f);
        pointF7.set(0.67f, 1.0f);
        pointF8.set(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new CubePlatform();
        }
    }
}
