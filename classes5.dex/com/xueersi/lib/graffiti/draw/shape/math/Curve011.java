package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve011 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(0.538f, CropImageView.DEFAULT_ASPECT_RATIO);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(0.538f, CropImageView.DEFAULT_ASPECT_RATIO, 0.545f, 0.264f, 0.558f, 0.308f);
        vectorPath2.cubicTo(0.557f, 0.308f, 0.567f, 0.407f, 0.659f, 0.323f);
        vectorPath2.cubicTo(0.659f, 0.323f, 0.936f, 0.078f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        vectorPath.moveTo(0.462f, 1.0f);
        vectorPath2.cubicTo(0.462f, 1.0f, 0.455f, 0.736f, 0.442f, 0.692f);
        vectorPath2.cubicTo(0.442f, 0.692f, 0.433f, 0.593f, 0.341f, 0.677f);
        vectorPath2.cubicTo(0.34f, 0.677f, 0.064f, 0.922f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve011();
        }
    }
}
