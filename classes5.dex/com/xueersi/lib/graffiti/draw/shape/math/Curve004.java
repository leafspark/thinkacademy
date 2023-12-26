package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve004 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 0.24f, CropImageView.DEFAULT_ASPECT_RATIO, 0.5f, CropImageView.DEFAULT_ASPECT_RATIO);
        vectorPath.moveTo(1.0f, 1.0f);
        vectorPath2.cubicTo(1.0f, 1.0f, 0.79f, CropImageView.DEFAULT_ASPECT_RATIO, 0.5f, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve004();
        }
    }
}
