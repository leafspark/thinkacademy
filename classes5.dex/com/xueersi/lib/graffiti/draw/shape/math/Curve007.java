package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve007 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(1.0f, 1.0f);
        vectorPath.lineTo(0.88f, 1.0f);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(0.5f, 1.0f, 0.37f, 0.94f, 0.27f, 0.83f);
        vectorPath2.cubicTo(0.16f, 0.69f, 0.03f, 0.44f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve007();
        }
    }
}
