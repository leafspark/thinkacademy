package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.PointF;
import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.yalantis.ucrop.view.CropImageView;

public class SideCube extends SixSides {
    /* access modifiers changed from: protected */
    public void pointConfig(RectF rectF, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, PointF pointF6, PointF pointF7, PointF pointF8) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        pointF.set(0.45f, CropImageView.DEFAULT_ASPECT_RATIO);
        pointF2.set(1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        pointF3.set(0.55f, 0.27f);
        pointF4.set(CropImageView.DEFAULT_ASPECT_RATIO, 0.27f);
        pointF5.set(0.45f, 0.73f);
        pointF6.set(1.0f, 0.73f);
        pointF7.set(0.55f, 1.0f);
        pointF8.set(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new SideCube();
        }
    }
}
