package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve013 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(CropImageView.DEFAULT_ASPECT_RATIO, 0.96f, 0.03f, 0.62f, 0.34f, 0.36f);
        vectorPath2.cubicTo(0.36f, 0.34f, 0.65f, 0.04f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve013();
        }
    }
}
