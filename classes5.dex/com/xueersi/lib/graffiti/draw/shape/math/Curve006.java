package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve006 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, -0.0f, 0.33f, 0.29f, 0.15f);
        vectorPath2.cubicTo(0.43f, 0.07f, 0.71f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve006();
        }
    }
}
