package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve005 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, 0.5f);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(CropImageView.DEFAULT_ASPECT_RATIO, 0.5f, 0.08f, CropImageView.DEFAULT_ASPECT_RATIO, 0.25f, CropImageView.DEFAULT_ASPECT_RATIO);
        vectorPath2.cubicTo(0.39f, CropImageView.DEFAULT_ASPECT_RATIO, 0.49f, 0.46f, 0.5f, 0.5f);
        vectorPath2.cubicTo(0.51f, 0.52f, 0.59f, 1.0f, 0.75f, 1.0f);
        vectorPath2.cubicTo(0.95f, 1.0f, 1.0f, 0.5f, 1.0f, 0.5f);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve005();
        }
    }
}
