package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class IsoscelesTrapezoid extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(0.18f, CropImageView.DEFAULT_ASPECT_RATIO);
        vectorPath.lineTo(0.82f, CropImageView.DEFAULT_ASPECT_RATIO);
        vectorPath.lineTo(1.0f, 1.0f);
        vectorPath.lineTo(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        vectorPath.close();
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new IsoscelesTrapezoid();
        }
    }
}
