package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.PointF;
import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class RectangularPyramid2 extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        PointF pointF = new PointF(0.28f, CropImageView.DEFAULT_ASPECT_RATIO);
        PointF pointF2 = new PointF(0.32f, 0.65f);
        PointF pointF3 = new PointF(1.0f, 0.65f);
        PointF pointF4 = new PointF(0.73f, 1.0f);
        PointF pointF5 = new PointF(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(pointF.x, pointF.y);
        vectorPath.lineTo(pointF5.x, pointF5.y);
        vectorPath.lineTo(pointF4.x, pointF4.y);
        vectorPath.lineTo(pointF3.x, pointF3.y);
        vectorPath.close();
        vectorPath.moveTo(pointF.x, pointF.y);
        vectorPath.lineTo(pointF4.x, pointF4.y);
        VectorPath vectorPath2 = getVectorPath(SketchSVGShape.Style.STROKE_DASHED);
        vectorPath2.reset();
        vectorPath2.moveTo(pointF.x, pointF.y);
        vectorPath2.lineTo(pointF2.x, pointF2.y);
        vectorPath2.lineTo(pointF3.x, pointF3.y);
        vectorPath2.moveTo(pointF2.x, pointF2.y);
        vectorPath2.lineTo(pointF5.x, pointF5.y);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new RectangularPyramid2();
        }
    }
}
