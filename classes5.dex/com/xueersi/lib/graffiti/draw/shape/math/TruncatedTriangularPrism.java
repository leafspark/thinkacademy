package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.PointF;
import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class TruncatedTriangularPrism extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        PointF pointF = new PointF(0.27f, CropImageView.DEFAULT_ASPECT_RATIO);
        PointF pointF2 = new PointF(1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        PointF pointF3 = new PointF(0.67f, 0.21f);
        PointF pointF4 = new PointF(CropImageView.DEFAULT_ASPECT_RATIO, 0.75f);
        PointF pointF5 = new PointF(0.76f, 0.75f);
        PointF pointF6 = new PointF(0.41f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(pointF.x, pointF.y);
        vectorPath.lineTo(pointF2.x, pointF2.y);
        vectorPath.lineTo(pointF3.x, pointF3.y);
        vectorPath.close();
        vectorPath.moveTo(pointF.x, pointF.y);
        vectorPath.lineTo(pointF4.x, pointF4.y);
        vectorPath.lineTo(pointF6.x, pointF6.y);
        vectorPath.lineTo(pointF3.x, pointF3.y);
        vectorPath.moveTo(pointF2.x, pointF2.y);
        vectorPath.lineTo(pointF5.x, pointF5.y);
        vectorPath.lineTo(pointF6.x, pointF6.y);
        VectorPath vectorPath2 = getVectorPath(SketchSVGShape.Style.STROKE_DASHED);
        vectorPath2.reset();
        vectorPath2.moveTo(pointF4.x, pointF4.y);
        vectorPath2.lineTo(pointF5.x, pointF5.y);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new TruncatedTriangularPrism();
        }
    }
}
