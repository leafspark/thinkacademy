package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve003 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0.13f, 0.08f, 0.28f, 0.58f);
        vectorPath2.cubicTo(0.38f, 0.92f, 0.43f, 1.0f, 0.5f, 1.0f);
        vectorPath.moveTo(1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        vectorPath2.cubicTo(1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 0.88f, 0.08f, 0.73f, 0.58f);
        vectorPath2.cubicTo(0.63f, 0.91f, 0.57f, 1.0f, 0.5f, 1.0f);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve003();
        }
    }
}
