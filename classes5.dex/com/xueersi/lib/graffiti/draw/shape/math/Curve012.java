package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class Curve012 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(0.571f, 1.0f);
        VectorPath vectorPath2 = vectorPath;
        vectorPath2.cubicTo(0.574f, 0.934f, 0.578f, 0.868f, 0.586f, 0.803f);
        vectorPath2.cubicTo(0.594f, 0.727f, 0.603f, 0.649f, 0.624f, 0.576f);
        vectorPath2.cubicTo(0.646f, 0.499f, 0.684f, 0.431f, 0.725f, 0.366f);
        vectorPath2.cubicTo(0.745f, 0.333f, 0.766f, 0.301f, 0.788f, 0.27f);
        vectorPath2.cubicTo(0.854f, 0.176f, 0.926f, 0.086f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        vectorPath.moveTo(0.429f, CropImageView.DEFAULT_ASPECT_RATIO);
        vectorPath2.cubicTo(0.426f, 0.066f, 0.421f, 0.131f, 0.414f, 0.196f);
        vectorPath2.cubicTo(0.406f, 0.272f, 0.396f, 0.35f, 0.375f, 0.423f);
        vectorPath2.cubicTo(0.353f, 0.5f, 0.315f, 0.568f, 0.274f, 0.633f);
        vectorPath2.cubicTo(0.254f, 0.666f, 0.233f, 0.698f, 0.211f, 0.729f);
        vectorPath2.cubicTo(0.145f, 0.824f, 0.074f, 0.913f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Curve012();
        }
    }
}
