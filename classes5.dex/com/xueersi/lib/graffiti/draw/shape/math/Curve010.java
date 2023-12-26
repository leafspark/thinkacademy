package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve010 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0.4f, 0.35f, 0.4f, 0.5f);
        vectorPath.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        vectorPath2.cubicTo(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 0.4f, 0.65f, 0.4f, 0.5f);
        vectorPath.moveTo(1.0f, -0.0f);
        vectorPath2.cubicTo(1.0f, -0.0f, 0.6f, 0.35f, 0.6f, 0.5f);
        vectorPath.moveTo(1.0f, 1.0f);
        vectorPath2.cubicTo(1.0f, 1.0f, 0.6f, 0.65f, 0.6f, 0.5f);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve010();
        }
    }
}
