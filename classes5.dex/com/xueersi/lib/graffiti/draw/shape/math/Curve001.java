package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve001 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.03f, 0.67f, 0.72f, 0.85f);
        vectorPath2.cubicTo(0.57f, 0.93f, 0.29f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve001();
        }
    }
}
