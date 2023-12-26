package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve008 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        vectorPath.lineTo(CropImageView.DEFAULT_ASPECT_RATIO, 0.12f);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(CropImageView.DEFAULT_ASPECT_RATIO, 0.5f, 0.06f, 0.63f, 0.18f, 0.73f);
        vectorPath2.cubicTo(0.31f, 0.84f, 0.56f, 0.97f, 1.0f, 1.0f);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve008();
        }
    }
}
