package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve009 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(1.0f, -0.0f, 0.89f, 0.32f, 0.8f, 0.41f);
        vectorPath2.cubicTo(0.8f, 0.41f, 0.71f, 0.53f, 0.5f, 0.53f);
        vectorPath2.cubicTo(0.5f, 0.53f, 0.24f, 0.49f, 0.13f, 0.72f);
        vectorPath2.cubicTo(0.13f, 0.72f, 0.02f, 0.91f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve009();
        }
    }
}
